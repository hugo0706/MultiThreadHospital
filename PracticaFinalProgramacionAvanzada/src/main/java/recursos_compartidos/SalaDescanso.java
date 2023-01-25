
package recursos_compartidos;

import hilos.Sanitario;
import java.io.Serializable;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * En esta clase están los métodos para los descansos de los auxiliares y los sanitarios.
 * Además de un CopyOnWriteArrayList con los IDs de los que estén descansando en ese momento.
 * @author David
 */
public class SalaDescanso implements Serializable {

    private CopyOnWriteArrayList<String> salaDescansoId = new CopyOnWriteArrayList<String>();

    public SalaDescanso() {

    }

    public void entrarDescansoAux1() throws InterruptedException {

        salaDescansoId.add("A1");
        sleep(new Random().nextInt(3000) + 3000);
        salaDescansoId.remove("A1");

    }

    public void entrarDescansoAux2() throws InterruptedException {
        salaDescansoId.add("A2");
        sleep((new Random()).nextInt(4000) + 1000);
        salaDescansoId.remove("A2");

    }

    public void entrarDescansoSanitario(Sanitario sanitario) throws InterruptedException {
        salaDescansoId.add(sanitario.getID());
        sleep((new Random()).nextInt(4000) + 5000); //Entra a la sala de descanso a cambiarse
        salaDescansoId.remove(sanitario.getID());
    }

    public void cambiarse(String idSanitario) throws InterruptedException {
        salaDescansoId.add(idSanitario);
        sleep((new Random()).nextInt(3000) + 1000); //Entra a la sala de descanso a cambiarse
        salaDescansoId.remove(idSanitario);
    }

    public CopyOnWriteArrayList<String> getIdsDescanso() {
        return salaDescansoId;
    }

}
