package hilos;


import recursos_compartidos.Log;
import recursos_compartidos.PuestoObservacion;
import recursos_compartidos.PuestoVacunacion;
import recursos_compartidos.Recepcion;
import recursos_compartidos.SalaObservacion;
import recursos_compartidos.SalaVacunacion;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class Paciente extends Thread implements Serializable {
    String id;
    private Recepcion recepcion;
    private SalaVacunacion salaVacunacion;
    private SalaObservacion salaObservacion;
    private PuestoVacunacion puestoVacunacion;
    private PuestoObservacion puestoObservacion;
    private Log log;
    private boolean tieneCita;
    private CyclicBarrier barrera;
    public Paciente(int id, Recepcion recepcion, SalaVacunacion salaVacunacion, SalaObservacion salaObservacion, Log log) {
        CrearID(id);
        this.recepcion = recepcion;
        this.salaVacunacion = salaVacunacion;
        this.salaObservacion = salaObservacion;
        this.log = log;
        this.barrera = new CyclicBarrier(2);
    }
    /**
     * En este método añadimos los ceros necearios entre la 'P' y el id pasado
     * como parametro en el bucle for de la clase 'Main' para crear el ID del
     * paciente.
     * @param id 
     */
    private void CrearID(int id) {
        this.id = "P";
        int aux = id;
        while(aux < 1000) {
            this.id += '0';
            aux *= 10;
        }
        this.id += id;
    }
    
    public void run() {
        
        recepcion.registrarse(this);
        try {
            //El paciente espera a que el auxiliar le atienda para poder ir a vacunarse
            barrera.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (tieneCita) {

            //Entra a la sala de vacunacion y espera a la vacuna
            String sanitario = null;
            try {
                sanitario = salaVacunacion.esperarVacuna(puestoVacunacion.getId(), this);
            } catch (InterruptedException ex) {
                Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Una vez vacunado, el paciente sale de la sala de vacunacion
            salaVacunacion.salirVacunacionPaciente(puestoVacunacion.getId());

            //Entra a la sala de observacion y espera por una posible reaccion
            salaObservacion.entrarSalaObservacion(puestoObservacion.getId(), this);
            try {
                log.escribir("Paciente " + id + " vacunado en el puesto " + puestoVacunacion.getId() + " por " + sanitario);
                sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Tiene un 5% de tener una reaccion
            if ((new Random()).nextInt(100) < 5) {
                try {
                    //Si la tiene espera a que un sanitario le atienda
                    log.escribir("Paciente " + id + " sufre una reaccion y espera sanitario. Puesto: " + puestoObservacion.getId());                    
                    String idSanitario = salaObservacion.esperarAtencionReaccion(puestoObservacion.getId());
                    log.escribir("Paciente " + id + " ha sido atendido en el puesto " + puestoObservacion.getId() + " por " + idSanitario);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            salaObservacion.salirSalaObservacionPaciente(puestoObservacion.getId());
            //Sale del hospital
            log.escribir("Paciente " + id + " sale del hospital");           
        }
    }

    public void setTieneCita(boolean b) {
        this.tieneCita = b;
    }
    
    public String getID() {
        return id;
    }
    
    public void setPuestoVacunacion(PuestoVacunacion puesto) {
        this.puestoVacunacion = puesto;
    }
    public PuestoVacunacion getPuestoVacunacion() {
        return puestoVacunacion;
    }
    public void setPuestoObservacion(PuestoObservacion puesto) {
        this.puestoObservacion = puesto;
    }
    public PuestoObservacion getPuestoObservacion() {
        return puestoObservacion;
    }
    public CyclicBarrier getBarrera() {
        return barrera;
    }
}
