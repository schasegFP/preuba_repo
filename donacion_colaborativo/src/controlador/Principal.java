

package controlador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 */
public class Principal extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage ventana) throws Exception {
        Parent principal = FXMLLoader.load(getClass().getResource("../vistas/Formulario.fxml"));
        
        Scene escena = new Scene(principal);
        ventana.setTitle("Banco de Sangre - Extracción");
        ventana.setResizable(false);
        ventana.initStyle(StageStyle.UTILITY);  // Eliminando las opciones de ventna minimizar, mover, cerrar
        ventana.setScene(escena);
        ventana.show();

    }

} // fin de la clase principal
