package main_servidor;



import recursos_compartidos.Log;
import recursos_compartidos.Recepcion;
import recursos_compartidos.SalaDescanso;
import recursos_compartidos.SalaObservacion;
import recursos_compartidos.SalaVacunacion;
import hilos.Sanitario;
import hilos.Paciente;
import hilos.Auxiliar2;
import hilos.Auxiliar1;
import interfaz_servidor.Interfaz_1;
import servidor.Servidor;
import static java.lang.Thread.sleep;
import java.util.Random;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Hospital {

    
    public static void main(String[] args) {    
        Semaphore puestosVacunacion = new Semaphore(0, true);
        Semaphore puestosObservacion = new Semaphore(20, true);
        
        //Se crea las cuatro salas del hospital
        SalaDescanso salaDescanso= new SalaDescanso();
        SalaObservacion salaObservacion = new SalaObservacion(puestosObservacion);
        SalaVacunacion salaVacunacion = new SalaVacunacion(puestosVacunacion);
        Recepcion recepcion = new Recepcion(salaObservacion, salaVacunacion);
        
        //Se crea el servidor
        Servidor servidor=new Servidor(salaObservacion, salaVacunacion, recepcion, salaDescanso);
        servidor.start();
        
        //Se crea el log donde se va a escribir la informacion del hospital
        Log log = new Log();
        
        //Creamos la interfaz
        Interfaz_1 interfaz = new Interfaz_1(recepcion,salaVacunacion,salaObservacion,salaDescanso);
        Thread t = new Thread(new Runnable() {
            public void run() {
                interfaz.setVisible(true);
                
                while(true){
                    
                    interfaz.actualizarDescanso();
                    interfaz.actualizarObservacion();
                    interfaz.actualizarRecepcion();
                    interfaz.actualizarVacunacion();
                }
            }
        });
        
        t.start();

        //Bucle para los Sanitarios
        Sanitario[] sanitarios = new Sanitario[10];
        for(int i = 1; i <= 10; i++) {
            sanitarios[i-1] = new Sanitario(i,  salaVacunacion, salaObservacion, log,salaDescanso);
            sanitarios[i-1].start();
        }
        
        
        //Auxiliares
        Auxiliar1 auxiliar1 = new Auxiliar1("A1", recepcion, salaVacunacion, salaObservacion,  log,salaDescanso);
        Auxiliar2 auxiliar2 = new Auxiliar2("A2", salaVacunacion, log,salaDescanso);
        auxiliar1.start();
        auxiliar2.start();
        
        //Pacientes
        Paciente[] pacientes = new Paciente[2000];
        for(int i = 1; i <= 2000; i++) {            
            pacientes[i-1] = new Paciente(i, recepcion, salaVacunacion, salaObservacion, log); //Creamos Paciente          
            pacientes[i-1].start(); //El paciente entra          
            try {
                sleep((new Random()).nextInt(3000)+1000); //Se espera entre 1 y 3 segundos
            } catch (InterruptedException ex) {
                Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Esperamos a que acaben los pacientes
        for(int i = 0; i < 2000; i++) {
            try {
                pacientes[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Una vez acaban los pacientes hacemos interrupt a los sanitarios para que 
        //Cuando no haya pacientes, salte la InterruptedExxception y termine así la ecejución
        //del sanitario
        for(int i = 0; i < 10; i++) {
            sanitarios[i].interrupt();
        }
        
        //Interrumpimos también los auxiliares
        auxiliar1.interrupt();
        auxiliar2.interrupt();    
        
        //Esperamos a que terminen su ejecución tanto los auxiliares como los
        //sanitarios para cerrar el fichero log.
        try {
            auxiliar1.join();
            auxiliar2.join();
            for(int i = 0; i < 10; i++) {
                sanitarios[i].join();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, ex);
        }
        log.escribir("El hospital ha cerrado");
        log.cerrarFichero();
    }
    
}
