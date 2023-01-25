package recursos_compartidos;


import hilos.Sanitario;
import hilos.Paciente;
import java.io.Serializable;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * En esta clase se gestiona todo lo relacionado con la sala de observación, como
 * puede ser la propia observación o las reacciones de los pacientes
 * @author David
 */
public class SalaObservacion implements Serializable {
    private CopyOnWriteArrayList<PuestoObservacion> puestos = new CopyOnWriteArrayList<PuestoObservacion>();

    //En estas colas se guardan los puestos libres y los que tienen un padiente con una reacción
    private LinkedBlockingQueue<PuestoObservacion> colaObservacionPacientes;
    private LinkedBlockingQueue<PuestoObservacion> colaReaccionesVacuna;
    
    //Semáforo que utiliza el auxiliar en la recepcion para asignar un puesto al paciente
    private Semaphore puestosObservacionPaciente;
    
    public SalaObservacion(Semaphore puestosObservacion) {
        this.puestosObservacionPaciente = puestosObservacion;
        this.colaObservacionPacientes = new LinkedBlockingQueue<PuestoObservacion>();
        this.colaReaccionesVacuna = new LinkedBlockingQueue<PuestoObservacion>();
        for(int i = 1; i < 21; i++) {
            puestos.add(new PuestoObservacion(i));
            colaObservacionPacientes.add(puestos.get(i-1));
        }
    }
    /**
     * Se asigna el puesto de observación al paciente quitándolo de la cola 
     * para indicar que ya no está libre
     * @return puesto de observación
     * @throws InterruptedException 
     */
    public PuestoObservacion getPuestoObservacionPaciente() throws InterruptedException {
            puestosObservacionPaciente.acquire();
        if (!colaObservacionPacientes.isEmpty()) {
            return colaObservacionPacientes.poll();
        } else {
            return null;
        }
    }

    /**
     * Si hay alguna reaccion en la cola, el sanitario atiende la reaccion
     * @param sanitario que va a atender la reaccion
     * @throws InterruptedException 
     */
    public void atenderReaccion(Sanitario sanitario) throws InterruptedException {
        if (!colaReaccionesVacuna.isEmpty()) {
            try {
                //Vemos cual es el paciente que lleva mas tiempo sin ser atendido    
                int numeroPuesto = colaReaccionesVacuna.poll().getId();     
                //Incluimos al sanitario que va a atender la reaccion en el Array
                puestos.get(numeroPuesto - 1).setSanitarioAtendiendoReaccion(sanitario.getID()); 
                //Indicamos que el sanitario empieza a atender al paciente
                puestos.get(numeroPuesto - 1).getBarreraReaccion().await(); 
                //Se le atiende
                sleep((new Random()).nextInt(4000) + 2000); 

                //Se abre la CyclicBarrier para que el paciente se vaya
                puestos.get(numeroPuesto - 1).getBarreraReaccion().await(); 

                puestos.get(numeroPuesto - 1).setSanitarioAtendiendoReaccion("");

            } catch (BrokenBarrierException ex) {
                Logger.getLogger(SalaObservacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Funcion para que un paciente entre a un puesto de observación
     * @param numeroPuesto
     * @param paciente 
     */
    public void entrarSalaObservacion(int numeroPuesto, Paciente paciente){
        puestos.get(numeroPuesto-1).setPacieneteEnObservacion(paciente.getID());
    }
    
    /**
     * Si el paciente tiene una reacción tendrá que esperar a que un sanitario
     * le atienda.
     * @param numeroPuesto
     * @return ID del sanitario que atiende la reacción
     * @throws InterruptedException 
     */
    public String esperarAtencionReaccion(int numeroPuesto) throws InterruptedException {
        String idSanitario = "";
        //Se añade el peusto del paciente a la cola de reacciones
        colaReaccionesVacuna.add(puestos.get(numeroPuesto-1));
        try {
            //Esperamos a que venga el sanitario a atender al paciente
            puestos.get(numeroPuesto - 1).getBarreraReaccion().await();
            //Guardamos el sanitario que atiende al paciente
            idSanitario = puestos.get(numeroPuesto-1).getSanitarioAtendiendoReaccion(); 
            //Esperamos a que el sanitario atienda al paciente
            puestos.get(numeroPuesto - 1).getBarreraReaccion().await(); 
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(SalaObservacion.class.getName()).log(Level.SEVERE, null, ex);
        }       
        //Devolvemos el id del sanitario que ha atendido a este paciente
        return idSanitario; 
    }
    
    /**
     * Al salir se vacía el string del paciente en ese puesto,
     * se añade el puesto a la cola de puestos libres y se libera el semaforo
     * para dejar otro hueco
     * @param numeroPuesto 
     */
    public void salirSalaObservacionPaciente(int numeroPuesto) {
        puestos.get(numeroPuesto-1).setPacieneteEnObservacion("            ");
        colaObservacionPacientes.add(puestos.get(numeroPuesto-1));
        puestosObservacionPaciente.release();
    }
    
    public ArrayList<String> getSanitariosAtendiendoReaccion(){
        ArrayList<String> idSanitarios= new ArrayList<String>();
        for(int i=0;i<puestos.size();i++){
            idSanitarios.add(puestos.get(i).getSanitarioAtendiendoReaccion());
        }
        return idSanitarios;
    }
    public ArrayList<String> getPacientesEnObservacion(){
        ArrayList<String> idSanitarios= new ArrayList<String>();
        for(int i=0;i<puestos.size();i++){
            idSanitarios.add(puestos.get(i).getPacieneteEnObservacion());
        }
        return idSanitarios;
    }
}
