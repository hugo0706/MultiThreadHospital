
package mvc_cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * La clase controlador es la que comunica la interfaz y el modelo del cliente
 * @author David
 */
public class Controlador implements ActionListener, Serializable{
    private I_Interfaz interfaz;
    private ModeloCliente modelo;
    public Controlador(I_Interfaz interfaz, ModeloCliente modelo) {
        this.interfaz=interfaz;
        this.modelo=modelo;
    }
    /**
     * En este metodo se hace visible la interfaz y se inicializan sus eventos.
     * También se realizan todas las acciones necesarias para conseguir una conexion TCP
     * entre el cliente y el servidor usando métodos del modelo
     */
    public void arrancar(){
        interfaz.hacerVisible();
        interfaz.inicializarEventos();
        System.out.println("Conectando con servidor...");
        modelo.conectarseServidor();
        modelo.crearFlujos();
        System.out.println("Conectado");
        modelo.start();
    }
   
    /**
     * Se le dice a la interfaz que se actualice con la informacion del hospital
     * y además habilitamos los botones que estaban dehabilitados siempre que haya
     * vuelto un sanitario al puesto
     * @param informacionHospital 
     */
    public void actualizarInterfaz(ArrayList<ArrayList<Object>> informacionHospital) {
        interfaz.actualizar(informacionHospital);
        habilitarBotones(informacionHospital.get(8)); //Sanitarios en Puestos de vacunacion
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Se pasa el String del ActionCommand del botón pulsado al modelo
        modelo.setCerrarPuesto(e.getActionCommand());
        //Se dehabilita el botón
        interfaz.deshabilitarBoton(e.getActionCommand());
        
    }

    public void habilitarBotones(ArrayList<Object> puestos) {
        for(int i = 0; i < puestos.size(); i++)
            if((Boolean)puestos.get(i) == true) {
                interfaz.habilitarBoton(i + 1);
            }
    }
}
