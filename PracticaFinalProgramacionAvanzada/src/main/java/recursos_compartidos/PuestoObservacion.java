/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos_compartidos;

import java.util.concurrent.CyclicBarrier;

/**
 * Clase para representar un puesto de la sala de observación
 * @author David
 */
public class PuestoObservacion {
    
    private int id;
    private String sanitarioAtendiendoReaccion;
    private String pacieneteEnObservacion;
    //barrera para gestionar el proceso de atender una reaccion
    private CyclicBarrier barreraReaccion; 
    public PuestoObservacion(int id) {
        this.id = id;
        this.barreraReaccion = new CyclicBarrier(2);
        this.sanitarioAtendiendoReaccion = "";
        this.pacieneteEnObservacion = "            ";
    }
    
    public int getId() {
        return id;
    }

    public CyclicBarrier getBarreraReaccion() {
        return barreraReaccion;
    }

    public String getSanitarioAtendiendoReaccion() {
        return sanitarioAtendiendoReaccion;
    }

    public void setSanitarioAtendiendoReaccion(String sanitarioAtendiendoReaccion) {
        this.sanitarioAtendiendoReaccion = sanitarioAtendiendoReaccion;
    }

    public String getPacieneteEnObservacion() {
        return pacieneteEnObservacion;
    }

    public void setPacieneteEnObservacion(String pacieneteEnObservacion) {
        this.pacieneteEnObservacion = pacieneteEnObservacion;
    }
    
    
}
