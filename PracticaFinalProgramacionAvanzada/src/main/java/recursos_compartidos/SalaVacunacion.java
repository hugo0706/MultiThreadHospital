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
import java.util.concurrent.Exchanger;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * En esta clase se gestiona todo lo relacionado con la vacunación
 * @author David
 */
public class SalaVacunacion implements Serializable {

    private CopyOnWriteArrayList<PuestoVacunacion> puestos;
    private LinkedBlockingQueue<PuestoVacunacion> puestosLibresPaciente;
    private LinkedBlockingQueue<PuestoVacunacion> puestosLibresSanitario;

    private Semaphore vacunasDisponibles = new Semaphore(0);
    private Semaphore puestosVacunacionPaciente;

    public SalaVacunacion(Semaphore puestosVacunacionPaciente) {
        this.puestosVacunacionPaciente = puestosVacunacionPaciente;
        this.puestos = new CopyOnWriteArrayList<PuestoVacunacion>();
        this.puestosLibresPaciente = new LinkedBlockingQueue<PuestoVacunacion>();
        this.puestosLibresSanitario = new LinkedBlockingQueue<PuestoVacunacion>();
        for (int i = 1; i < 11; i++) {
            puestos.add(new PuestoVacunacion(i));
            puestosLibresSanitario.add(puestos.get(i - 1));
        }
    }

    /**
     * función usada por el auxiliar 1 para asignarle el puesto de vacunacion al
     * paciente.
     * @return
     * @throws InterruptedException 
     */
    public PuestoVacunacion getPuestoVacunacionPaciente() throws InterruptedException {
        puestosVacunacionPaciente.acquire();

        if (!puestosLibresPaciente.isEmpty()) {
            //Se elimina de la cola el puesto libre y se retorna ese puesto
            return puestosLibresPaciente.poll();
        } else {
            return null;
        }
    }

    /**
     * función para que el sanitario entre a un puesto de vacunación
     * @param sanitario
     * @return el puesto al que entra en sanitario
     */
    public PuestoVacunacion entrarPuestoVacunacionSanitario(Sanitario sanitario) {
        if (!puestosLibresSanitario.isEmpty()) {

            PuestoVacunacion puesto = puestosLibresSanitario.poll();
            int numeroPuesto = puesto.getId();
            puestos.get(numeroPuesto - 1).setIdSanitario(sanitario.getID()); //Se añade el id del sanitario en su puesto
            puestosLibresPaciente.add(puesto); //Cuando entra un sanitario se añade como disponible el puesto para un paciente
            puestos.get(numeroPuesto - 1).setPuestoAbierto(true); //El puesto ahora no está cerrado
            puestosVacunacionPaciente.release();//Libera un permit del semaforo para que pueda entrar un paciente         
            return puesto;
        } else {
            return null;
        }
    }

    /**
     * En esta función el sanitario espera a que el paciente llegue o a que se tenga que cerrar
     * el puesto de vacunacion. Esto se gestiona con un semaforo para esperar lo que le llegue primero
     * (si el paciente o la notificación de cerrar) y un exchanger para saber qué es lo que le ha llegado
     * y actuar en consecuencia
     * @param numeroPuesto
     * @return boolean que indica si ha llegado a vacunar a un paciente, o no
     * ha vacunado porque se ha cerrado el puesto
     * @throws InterruptedException 
     */
    public boolean vacunar(int numeroPuesto) throws InterruptedException {
        try {
            puestos.get(numeroPuesto - 1).getSemaforoGestionBoton().release();
            int accion = puestos.get(numeroPuesto - 1).getAccion().exchange(null);

            if (accion == 1) {

                //Coger una vacuna, si hay disponibles. Si no hay, espera.
                vacunasDisponibles.acquire(); 
                //en caso de haber un paciente esperando vacunamos, en otro caso esperamos   
                puestos.get(numeroPuesto - 1).getBarrier().await();    
                //El sanitario procede a vacunar
                sleep((new Random()).nextInt(3000) + 3000);
                //le decimos al paciente que le hemos vacunado    
                puestos.get(numeroPuesto - 1).getBarrier().await();             
                return true;
            }

        } catch (BrokenBarrierException ex) {
            Logger.getLogger(SalaVacunacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * el paciente, una vez en el puesto de vacunacion debe esperar a que el sanitario
     * le vacune
     * @param numeroPuesto
     * @param paciente
     * @return el id del sanitario que nos ha vacunado
     * @throws InterruptedException 
     */
    public String esperarVacuna(int numeroPuesto, Paciente paciente) throws InterruptedException {
        try {
            //Le indicamos al sanitario que le ha llegado algo
            puestos.get(numeroPuesto - 1).getSemaforoGestionBoton().acquire();
            //Le mandamos un mensaje indicandole que lo que le ha llegado es un paciente para vacunar
            puestos.get(numeroPuesto - 1).getAccion().exchange(1);
            //Metemos al paciente en el puesto
            puestos.get(numeroPuesto - 1).setIdPaciente(paciente.getID());
            //Indicmos al sanitario que el paciente ya está en el puesto
            puestos.get(numeroPuesto - 1).getBarrier().await();

            
            String idSanitario = puestos.get(numeroPuesto - 1).getIdSanitario();
            //el paciente espera a que el sanitario le vacune
            puestos.get(numeroPuesto - 1).getBarrier().await(); 
            return idSanitario;
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(SalaVacunacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    /**
     * Al salir se vacía el string del paciente en ese puesto,
     * se añade el puesto a la cola de puestos libres y se libera el semaforo
     * para dejar otro hueco
     * @param numeroPuesto 
     */
    public void salirVacunacionPaciente(int numeroPuesto) {
        puestos.get(numeroPuesto - 1).setIdPaciente("            ");
        puestosLibresPaciente.add(puestos.get(numeroPuesto - 1));
        puestosVacunacionPaciente.release();

    }

    /**
     * Al salir se vacía el string del sanitario en ese puesto,
     * se añade el puesto a la cola de puestos libres y se coge un permit
     * del semaforo para indicar que hay un puesto menos disponible
     * @param numeroPuesto 
     */
    public void salirVacunacionSanitario(int numeroPuesto) throws InterruptedException {

        puestosVacunacionPaciente.acquire();
        puestos.get(numeroPuesto - 1).setIdSanitario("");
        puestosLibresSanitario.add(puestos.get(numeroPuesto - 1));
    }

    /**
     * El auxiliar 2 prepara una vacuna
     * @throws InterruptedException 
     */
    public void auxiliar2PrepararVacuna() throws InterruptedException {
        sleep((new Random().nextInt(500) + 500));
        vacunasDisponibles.release();
    }

    /**
     * Se cierra el/los puesto/s pasado/s como parametro
     * @param numeroPuestos
     * @throws InterruptedException 
     */
    public void cerrarPuesto(CopyOnWriteArrayList<Integer> numeroPuestos) throws InterruptedException {
        if (!numeroPuestos.isEmpty()) {
            for (int i = 0; i < numeroPuestos.size(); i++) {

                //Le indicamos al sanitario que le ha llegado algo
                puestos.get(numeroPuestos.get(i) - 1).getSemaforoGestionBoton().acquire();
                //Se cierra el puesto
                puestos.get(numeroPuestos.get(i) - 1).setPuestoAbierto(false);
                //Le mandamos un mensaje indicandole que lo que le ha llegado es un peusto a cerrar
                puestos.get(numeroPuestos.get(i) - 1).getAccion().exchange(2);                                            
            }
        }
    }

    public ArrayList<String> getIDSanitarios() {
        ArrayList<String> idSanitarios = new ArrayList<String>();
        for (int i = 0; i < puestos.size(); i++) {
            idSanitarios.add(puestos.get(i).getIdSanitario());
        }
        return idSanitarios;
    }

    public ArrayList<String> getIDPacientes() {
        ArrayList<String> idPacientes = new ArrayList<String>();
        for (int i = 0; i < puestos.size(); i++) {
            idPacientes.add(puestos.get(i).getIdPaciente());
        }
        return idPacientes;
    }

    public String getVacunasDisponibles() {
        return String.valueOf(vacunasDisponibles.availablePermits());
    }

    public ArrayList<Boolean> getPuestosDisponibles() {
        ArrayList<Boolean> puestosDisponibles = new ArrayList<Boolean>();
        for (int i = 0; i < puestos.size(); i++) {
            puestosDisponibles.add(puestos.get(i).isPuestoAbierto());
        }
        return puestosDisponibles;
    }
}
