
package recursos_compartidos;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;
/**
 * Clase para representar un puesto de la sala de observación
 * @author David
 */
public class PuestoVacunacion {
    private String sanitarioPresente,pacientePresente;
    //barrera para el proceso de vacunacion
    private CyclicBarrier pacienteListoVacunar;
    private int id;

    //Para la gestion de los botones para cerrar puestos
    private Exchanger<Integer> accion;
    private Semaphore semaforoGestionBoton;
    private boolean puestoAbierto;
    
    public PuestoVacunacion(int id) {
        this.pacientePresente="            ";
        this.sanitarioPresente="";
        this.pacienteListoVacunar = new CyclicBarrier(2);
        this.accion = new Exchanger<Integer>();
        this.semaforoGestionBoton = new Semaphore(0, true);
        this.puestoAbierto = false;
        this.id = id;
    }

    public Exchanger<Integer> getAccion() {
        return accion;
    }

    public Semaphore getSemaforoGestionBoton() {
        return semaforoGestionBoton;
    }

    public boolean isPuestoAbierto() {
        return puestoAbierto;
    }

    public void setPuestoAbierto(boolean puestoAbierto) {
        this.puestoAbierto = puestoAbierto;
    }

    public String getIdSanitario(){
        return sanitarioPresente;
    }

    public CyclicBarrier getBarrier(){
        return pacienteListoVacunar ;
    }

    public void setIdPaciente(String pacientePresente) {
        this.pacientePresente = pacientePresente;
    }

    public void setIdSanitario(String sanitarioPresente) {
        this.sanitarioPresente = sanitarioPresente;
    }
    public String getIdPaciente(){
        return pacientePresente;
    }

    public int getId() {
        return id;
    }    
}
