
package mvc_cliente;

import mvc_cliente.Controlador;
import java.util.ArrayList;


public interface I_Interfaz {
    public void setControlador(Controlador controlador);
    
    public void hacerVisible();

    public void actualizar(ArrayList<ArrayList<Object>> informacionHospital);

    public void inicializarEventos();

    public void deshabilitarBoton(String actionCommand);

    public void habilitarBoton(Integer get);

}
