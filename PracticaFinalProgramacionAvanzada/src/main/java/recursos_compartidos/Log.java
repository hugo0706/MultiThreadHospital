package recursos_compartidos;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * La clase Log servirá para escribir toda lo que vaya pasando en el hospital
 * en el fichero informacionHospital.txt que estará dentro del proio proyecto
 * @author David
 */
public class Log implements Serializable{
    
    private FileWriter fw;
    private PrintWriter pw;
    private DateFormat formato;
    
    public Log() {
        try {
            fw = new FileWriter("./evolucionHospital.txt");
            pw = null;
            formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
        } catch (IOException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(String mensaje) {
        pw = new PrintWriter(fw);
        pw.println(formato.format(new Date()) + " " + mensaje);
        pw.flush();
    }
    
    public void cerrarFichero() {
        try {
            pw.close();
            fw.close();            
        } catch (IOException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


