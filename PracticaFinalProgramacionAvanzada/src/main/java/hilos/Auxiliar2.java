package hilos;


import recursos_compartidos.Log;
import recursos_compartidos.SalaDescanso;
import recursos_compartidos.SalaVacunacion;
import static java.lang.Thread.sleep;
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
public class Auxiliar2 extends Thread{
    private String id;
    private SalaVacunacion salaVacunacion;
    private SalaDescanso salaDescanso;
    private Log log;

    public Auxiliar2(String id, SalaVacunacion salaVacunacion, Log log,SalaDescanso salaDescanso) {
        this.id = id;
        this.salaVacunacion = salaVacunacion;
        this.salaDescanso=salaDescanso;
        this.log = log;
    }
    /**
     * El auxiliar 2 prepara vacunas en un bucle infinito.
     * Descansa cada 20 vacunas preparadas
     */
    public void run() {
        try {
            int contadorVacunas = 0;
            while (true) {
                salaVacunacion.auxiliar2PrepararVacuna();
                contadorVacunas++;
                if (contadorVacunas == 20) {
                    contadorVacunas = 0;
                    log.escribir("Auxiliar A2 comienza su descanso");
                    salaDescanso.entrarDescansoAux2();
                }
            }
        } catch (InterruptedException e) {
            log.escribir("Auxiliar A2 finaliza su jornada laboral");
        }
    }


}
