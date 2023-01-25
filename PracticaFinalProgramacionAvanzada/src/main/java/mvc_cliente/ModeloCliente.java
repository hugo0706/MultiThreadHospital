
package mvc_cliente;

import mvc_cliente.Controlador;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloCliente extends Thread implements Serializable {
    private Controlador controlador;
    private final int PUERTO=40080;
    private final String HOST="localhost";
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private CopyOnWriteArrayList<Integer> cerrarPuesto;
    private ArrayList<ArrayList<Object>> informacionHospital;
    public ModeloCliente() {
    }
    
    public void setControlador(Controlador controlador) {
        this.controlador=controlador;
        this.cerrarPuesto = new CopyOnWriteArrayList<Integer>();
    }

    
    public void conectarseServidor() {
        
        try {
            socket= new Socket(HOST,PUERTO);
            
        } catch (IOException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    
    public void crearFlujos() {
        try {
            oos= new ObjectOutputStream(socket.getOutputStream());
            ois= new ObjectInputStream(socket.getInputStream());
            
        } catch (IOException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setCerrarPuesto(String n){
        cerrarPuesto.add(Integer.parseInt(n.substring(6)));
    }
    
    public void run() {

        while(true){
            try {
                //Se va a pedir informacion al servidor cada segundo
                Thread.sleep(1000);
                //Al servidor le mandamos una lista con los puestos que queremos cerrar
                oos.writeObject(cerrarPuesto);
                oos.reset();
                cerrarPuesto.clear();
                
                //El servidor nos manda toda la informacion del hospital
                informacionHospital = (ArrayList<ArrayList<Object>>) ois.readObject();
                
                //Actualizamos la interfaz a traves del controlador
                controlador.actualizarInterfaz(informacionHospital);
                informacionHospital.clear();


            }  catch (InterruptedException ex) {
                Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }



    
}
