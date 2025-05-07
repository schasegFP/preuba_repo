package recursos;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author d1
 */
public class Utilidades {
    
    /**
     * Metodo que muestra una ventana de error
     * @param err mensaje que muestra la ventana
     */
    public static void mensajeError(String err){
    Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ventana de error");
        alert.setHeaderText(err);
        alert.setContentText("Acepta para continuar");
        alert.showAndWait();
    }
    
    /**
     * Metodo que muestra una ventana de información 
     * @param inf mensaje que muestra la ventana
     * @return 
     */
    public static void mensajeInf(String inf){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ventana de información");
        alert.setHeaderText(inf);
        alert.setContentText("Acepta para continuar");
        alert.showAndWait();
    }
    
    /**
     * Metodo que muestra una ventana de información y espera que se de una respuesta
     * de confirmación o cancelación.
     * @param conf mensaje que muestra la ventana
     * @return 
     */
    public static boolean mensajeConfirmacion(String conf){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Ventana de Confirmación");
        alert.setHeaderText(conf);
        alert.setContentText("Acepta para continuar");
        Optional<ButtonType> opcion =  alert.showAndWait();

        if (opcion.get() == ButtonType.OK){
            return true;
        }
        return false;
            
    }
    
}// fin de la clase
