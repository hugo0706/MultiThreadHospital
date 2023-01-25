package hilos;


import recursos_compartidos.Log;
import recursos_compartidos.PuestoVacunacion;
import recursos_compartidos.SalaDescanso;
import recursos_compartidos.SalaObservacion;
import recursos_compartidos.SalaVacunacion;
import java.util.Random;
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
public class Sanitario extends Thread {

    private String id;
    
    private SalaVacunacion salaVacunacion;
    private SalaObservacion salaObservacion;
    private SalaDescanso salaDescanso;
    private PuestoVacunacion puestoVacunacion;
    private int contadorPacientesVacunados;
    private Log log;

    public Sanitario(int id,SalaVacunacion salaVacunacion, SalaObservacion salaObservacion, Log log,SalaDescanso salaDescanso) {
        if (id < 10) {
            this.id = "S0" + id;
        } else {
            this.id = "S" + id;
        }
        this.salaDescanso=salaDescanso;
        this.salaVacunacion = salaVacunacion;
        this.salaObservacion = salaObservacion;
        this.log = log;
    }

    public void run() {
        try {
        salaDescanso.cambiarse(id);
        
        //Despues de cambiarse entra a su puesto de vacunacion
        puestoVacunacion = salaVacunacion.entrarPuestoVacunacionSanitario(this);
        log.escribir("Sanitario " + id + " entrando a puesto " + puestoVacunacion.getId());
        while (true) {
            //Puede pasar que el sanitario haya vacunado o que haya cerrado su puesto
            boolean haVacunado = salaVacunacion.vacunar(puestoVacunacion.getId());
            //Si ha vacunado se suma 1 al contador de pacientes vacunados
            if (haVacunado) {
                contadorPacientesVacunados++;
            }
            //Si ha vacunado a 15 pacientes o no ha vacunado, es decir, se ha cerrado el puesto
            //sale del puesto y se va a descansar
            if (contadorPacientesVacunados == 15 || !haVacunado) {

                if (contadorPacientesVacunados == 15) {
                    contadorPacientesVacunados = 0;
                }

                salaVacunacion.salirVacunacionSanitario(puestoVacunacion.getId());
                log.escribir("Sanitario " + id + " se va a descansar");
                salaDescanso.entrarDescansoSanitario(this);

                //Despues de descansar atiende una reaccion en la sala de observación si la hay
                salaObservacion.atenderReaccion(this);
                //Por último vuelve a un puesto de vacunacion libre
                puestoVacunacion = salaVacunacion.entrarPuestoVacunacionSanitario(this);
                log.escribir("Sanitario " + id + " entrando a puesto " + puestoVacunacion.getId());
            }
        }
        }catch(InterruptedException e) {
            log.escribir("Sanitario " + id + " finaliza su jornada laboral");
        }
    }

    public String getID() {
        return id;
    }



    
}
