package recursos_compartidos;

import recursos_compartidos.SalaObservacion;
import recursos_compartidos.SalaVacunacion;
import hilos.Paciente;
import java.io.Serializable;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Recepcion implements Serializable {

    private SalaVacunacion salaVacunacion;
    private SalaObservacion salaObservacion;
    private String idPacienteDentro;
    private Semaphore pacienteEnRecepcion;

    private LinkedBlockingQueue<Paciente> cola = new LinkedBlockingQueue<Paciente>();

    public Recepcion(SalaObservacion salaObservacion, SalaVacunacion salaVacunacion) {
        this.salaObservacion = salaObservacion;
        this.salaVacunacion = salaVacunacion;
        this.pacienteEnRecepcion = new Semaphore(0);
    }
    /**
     * En esta funcion se gestiona el la comprobacion del paciente (si tiene cita o no)
     * por parte del auxiliar 1.
     * Se utiliza un semáforo que empieza en 0 y que liberará el paciente cuando 
     * llegue a la recepción para que el auxiliar no atienda cuando aún no hay paciente
     * Se utiliza un CyclicBarrier para indicarle al paciente que ya ha sido atendido y que puede ir a vacunarse
     * @return mensaje que indica si el paciente no tiene cita, o, en caso contrario,
     * en que puesto y con qué sanitario se vacunará
     * @throws InterruptedException 
     */
    public String comprobarPaciente() throws InterruptedException {
        //Semaforo para empezar solo cuando haya un paciente en la recepción
        pacienteEnRecepcion.acquire();
        
        //Entra el primer paciente de la cola
        Paciente paciente = cola.poll();
        //Se guarda el paciente que está actualmente en la recepción
        this.idPacienteDentro = paciente.getID();
        String mensaje = "";
        //El auxiliar tarda entre 0.5 y 1s en realizar la comprobacion
        sleep((new Random()).nextInt(500) + 500);
        
        //Hay un 1% de posibilidad de que el paciente no tenga cita
        int porcentaje = (new Random()).nextInt(100);
        if (porcentaje == 1) {
            paciente.setTieneCita(false);
            mensaje = "Paciente " + paciente.getID() + " ha acudido sin cita";

        } else {
            //Si tiene cita se le asigna un puesto de vacunación y de observación.
            //Además se ve que sanitario le vacunará para mostrarlo en el registro del auxiliar 1
            paciente.setPuestoVacunacion(salaVacunacion.getPuestoVacunacionPaciente());
            String idSanitario = paciente.getPuestoVacunacion().getIdSanitario();
            mensaje = "Paciente " + paciente.getID() + " será vacunado en el puesto " + paciente.getPuestoVacunacion().getId() + " por " + idSanitario;
            paciente.setPuestoObservacion(salaObservacion.getPuestoObservacionPaciente());
            paciente.setTieneCita(true);

        }
        try {
            //Cuando sale el paciente se vacía idPacienteDentro y se hace await() a la barrera
            //para indicar al paciente que ya puede irse
            this.idPacienteDentro = "";
            paciente.getBarrera().await();
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(Recepcion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;
    }
    /**
     * El paciente se registra metiéndose en la cola y libera el semaforo para
     * que lo pueda coger el auxiliar
     * @param paciente 
     */
    public void registrarse(Paciente paciente) {
        cola.add(paciente);
        pacienteEnRecepcion.release();
    }

    public LinkedBlockingQueue<String> getColaIDs() {
        ArrayList<Paciente> listaCopia = new ArrayList<Paciente>();
        listaCopia.addAll(cola);

        LinkedBlockingQueue<String> listaIDs = new LinkedBlockingQueue<String>();
        for (int i = 0; i < listaCopia.size(); i++) {
            listaIDs.add(listaCopia.get(i).getID());
        }

        return listaIDs;
    }

    public String getIdPacienteDentro() {
        return idPacienteDentro;
    }

}
