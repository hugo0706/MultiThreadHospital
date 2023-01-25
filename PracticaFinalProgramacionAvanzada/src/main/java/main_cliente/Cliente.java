
package main_cliente;

import mvc_cliente.Controlador;
import mvc_cliente.Interfaz_2;
import mvc_cliente.ModeloCliente;


/**
 * En la clase cliente se instancian los elementos del modelo MVC:
 * El modelo, la vista (interfaz) y el controlador
 * Una vez instanciados y relacionados entre sí,
 * se arranca el cliente a través del controlador.
 * @author David
 */
public class Cliente {

    public static void main(String[] args) {
        Interfaz_2 interfaz=new Interfaz_2();
        ModeloCliente modeloCliente=new ModeloCliente();
        Controlador controlador =new Controlador(interfaz,modeloCliente);
                
        interfaz.setControlador(controlador);
        modeloCliente.setControlador(controlador);
        
        controlador.arrancar();
        
    }
    
}
