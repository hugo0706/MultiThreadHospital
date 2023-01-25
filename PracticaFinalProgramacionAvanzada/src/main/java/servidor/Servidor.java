package servidor;

import mvc_cliente.Controlador;
import recursos_compartidos.Recepcion;
import recursos_compartidos.SalaDescanso;
import recursos_compartidos.SalaObservacion;
import recursos_compartidos.SalaVacunacion;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor extends Thread implements Serializable {
    private Controlador controlador;
    private final int PUERTO=40080;
    private ServerSocket sk;
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    
    private SalaObservacion salaObservacion;
    private SalaVacunacion salaVacunacion;
    private Recepcion recepcion;
    private SalaDescanso salaDescanso;
    
    public Servidor(SalaObservacion salaObservacion, SalaVacunacion salaVacunacion,Recepcion recepcion,SalaDescanso salaDescanso) {
        this.salaObservacion=salaObservacion;
        this.recepcion=recepcion;
        this.salaDescanso=salaDescanso;
        this.salaVacunacion=salaVacunacion;
       
    }
    
    public void setControlador(Controlador controlador) {
        this.controlador=controlador;
    }

    
    public void abrirPuerto() {
        try {
            sk=new ServerSocket(PUERTO);
        } catch (IOException ex) {
            
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void esperarCliente(){
        try {
            socket=sk.accept();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearFlujos() {
        try {
            oos= new ObjectOutputStream(socket.getOutputStream());
            ois= new ObjectInputStream(socket.getInputStream());         
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
    public void run(){
        System.out.println("Iniciando servidor...");
        abrirPuerto();
        System.out.println("Esperando al cliente...");
        esperarCliente();
        crearFlujos();
        System.out.println("Servidor iniciado");
        while(true){
            //Se crea la estructura de datos donde guardamos toda la informacion
            //necesaria para actualizar la interfaz del cliente
            ArrayList<ArrayList<Object>> mensaje = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                mensaje.add(new ArrayList<>());
            }
            try {
                
                //Recibimos los puestos a cerrar y llamamos a la función de la sala
                //de vacunacion para cerrarlos
                CopyOnWriteArrayList<Integer> puestosCerrar = (CopyOnWriteArrayList<Integer>) ois.readObject();
                salaVacunacion.cerrarPuesto(puestosCerrar);
                puestosCerrar.clear();
                
                //Vamos llenando los ArrayList con toda la informacion del hospital
                
                //Paciente siendo atendido en recepcion
                mensaje.get(0).clear();
                mensaje.get(0).add(recepcion.getIdPacienteDentro());
                //Cola recepcion
                mensaje.get(1).clear();
                mensaje.get(1).addAll(recepcion.getColaIDs());
                //Vacunas disponibles                
                mensaje.get(2).clear();
                mensaje.get(2).add(salaVacunacion.getVacunasDisponibles());
                //Pacientes en puestos de vacunacion
                mensaje.get(3).clear();
                mensaje.get(3).addAll(salaVacunacion.getIDPacientes());
                //Sanitarios en puestos de vacunacion
                mensaje.get(4).clear();
                mensaje.get(4).addAll(salaVacunacion.getIDSanitarios());
                //Pacientes en puestos de observacion
                mensaje.get(5).clear();
                mensaje.get(5).addAll(salaObservacion.getPacientesEnObservacion());
                //Sanitarios en puestos de observacion
                mensaje.get(6).clear();
                mensaje.get(6).addAll(salaObservacion.getSanitariosAtendiendoReaccion());
                //Personas en sala de descanso
                mensaje.get(7).clear();                
                mensaje.get(7).addAll(salaDescanso.getIdsDescanso());
                
                //Para la gestion de los botones de Cerrar puestos
                mensaje.get(8).addAll(salaVacunacion.getPuestosDisponibles());
                
                //Enviamos toda la informacion
                oos.writeObject(mensaje);
                oos.reset();
            } catch (Exception e){
                
            }
            
        }
        
    }


    
}
