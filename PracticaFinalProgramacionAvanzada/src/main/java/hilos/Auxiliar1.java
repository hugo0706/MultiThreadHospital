package hilos;


import recursos_compartidos.Log;
import recursos_compartidos.Recepcion;
import recursos_compartidos.SalaDescanso;
import recursos_compartidos.SalaObservacion;
import recursos_compartidos.SalaVacunacion;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Auxiliar1 extends Thread{
    private String id;
    private int numeroPacientes=0;
    private Recepcion recepcion;
    private SalaVacunacion salaVacunacion;
    private SalaObservacion salaObservacion;
    private SalaDescanso salaDescanso;
    private Log log;
    public Auxiliar1(String id, Recepcion recepcion, SalaVacunacion salaVacunacion, SalaObservacion salaObservacion, Log log,SalaDescanso salaDescanso) {
        this.id = id;
        this.recepcion = recepcion;
        this.salaVacunacion = salaVacunacion;
        this.salaObservacion = salaObservacion;
        this.salaDescanso=salaDescanso;
        this.log = log;
    }
    /**
     * El Auxiliar 1 entrará en un bucle infinito en el cual irá comprobando si
     * la cita de los pacientes es correcta con el metodo ComprobarPaciente() de
     * la clase recepción. Esta función devolverá el mensaje que depués imprimirá
     * el auxiliar por pantalla. El auxiliar descansará cada 10 pacientes comprobados
     */
    public void run() {
        try {
        while(true) {
            if (numeroPacientes < 10) {
                String mensaje = recepcion.comprobarPaciente();
                System.out.println(mensaje);
                log.escribir(mensaje);
                numeroPacientes++; //aumentamos, cuando llegue a 10 descansa
            } else {

                numeroPacientes = 0;
                log.escribir("Auxiliar A1 comienza su descanso");
                salaDescanso.entrarDescansoAux1();
            }
        }
        }catch(InterruptedException e) {
            log.escribir("Auxiliar A1 finaliza su jornada laboral");
        }
    }

    
}
