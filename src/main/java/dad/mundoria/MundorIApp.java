package dad.mundoria;

import dad.mundoria.controller.MenuController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación que extiende {@link Application}
 * e inicia la interfaz gráfica.
 */
public class MundorIApp extends Application {
    
    /**
     * Controlador del menú principal.
     */
    private MenuController menuController = new MenuController();

    /**
     * Método que inicia la aplicación JavaFX.
     *
     * @param primaryStage El escenario principal de la aplicación (no utilizado en este caso).
     * @throws Exception Si ocurre un error durante la inicialización.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        // Se crea un nuevo Stage para la aplicación
        Stage mundoriaStage = new Stage();

        // Se establece el icono de la aplicación
        mundoriaStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icono.png")));

        // Se establece el título de la ventana
        mundoriaStage.setTitle("MundorIA");

        // Se configura la escena con el menú principal
        mundoriaStage.setScene(new Scene(menuController.getRoot()));

        // Se muestra la ventana
        mundoriaStage.show();

        // Se establece la aplicación en pantalla completa
        mundoriaStage.setFullScreen(true);
    }
}
