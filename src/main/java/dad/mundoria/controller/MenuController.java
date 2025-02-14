package dad.mundoria.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import dad.mundoria.model.Enemigo;
import dad.mundoria.model.Personaje;
import dad.mundoria.model.SistemaDeCombate;
import dad.mundoria.model.data.DatosPredefinidos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * Controlador principal del menú de la aplicación, maneja las acciones de los botones y la música de fondo.
 * Esta clase gestiona la transición entre diferentes vistas del juego.
 */
public class MenuController implements Initializable {

    @FXML
    private Button ajustesButton;

    @FXML
    private Button continuarPartidaButton;

    @FXML
    private Button historiaButton;

    @FXML
    private Button nuevaPartidaButton;

    @FXML
    private Button salirButton;

    @FXML
    private BorderPane root;

    private MediaPlayer mediaPlayer;

    /**
     * Acción que se ejecuta al pulsar el botón de ajustes. Actualmente no implementada.
     * 
     * @param event El evento de acción que se genera al pulsar el botón.
     */
    @FXML
    void onAjustes(ActionEvent event) {}

    /**
     * Acción que se ejecuta al pulsar el botón de continuar partida. Actualmente no implementada.
     * 
     * @param event El evento de acción que se genera al pulsar el botón.
     */
    @FXML
    void onContinuarPartida(ActionEvent event) {}

    /**
     * Acción que se ejecuta al pulsar el botón de historia. Actualmente no implementada.
     * 
     * @param event El evento de acción que se genera al pulsar el botón.
     */
    @FXML
    void onHistoria(ActionEvent event) {}

    /**
     * Acción que se ejecuta al pulsar el botón de nueva partida. Carga la vista de combate y 
     * establece los enemigos y personajes iniciales para el combate.
     * 
     * @param event El evento de acción que se genera al pulsar el botón.
     */
    @FXML
    void onNuevaPartida(ActionEvent event) {
        try {
            // Carga la vista de combate
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CombateView.fxml"));
            Parent root = loader.load();

            // Configura el controlador de combate
            combateController = loader.getController();
            enemigosPrueba.add((Enemigo) DatosPredefinidos.ENTIDADES.get(3));
            personajesPrueba.add((Personaje) DatosPredefinidos.ENTIDADES.get(0));
            SistemaDeCombate sistemaDeCombate = new SistemaDeCombate(enemigosPrueba, personajesPrueba);
            combateController.setSistemaDeCombate(sistemaDeCombate);
            
            // Inicializa la vista de combate
            combateController.inicializarVista();

            // Establece la escena y la pone en pantalla completa
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setFullScreen(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Acción que se ejecuta al pulsar el botón de salir. Detiene la música de fondo y cierra la ventana.
     * 
     * @param event El evento de acción que se genera al pulsar el botón.
     */
    @FXML
    void onSalir(ActionEvent event) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }

    private CombateController combateController;
    private List<Enemigo> enemigosPrueba = new ArrayList<>();
    private List<Personaje> personajesPrueba = new ArrayList<>();

    /**
     * Método de inicialización que se ejecuta al cargar el controlador. Configura el estilo y la música de fondo.
     * 
     * @param location La URL de la ubicación del archivo FXML.
     * @param resources Los recursos utilizados en el archivo FXML.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        root.getStylesheets().add(getClass().getResource("/styles/mundoria.css").toExternalForm());

        // Música de fondo
        try {
            String musicFile = getClass().getResource("/audio/musicaMenu.mp3").toExternalForm();
            Media media = new Media(musicFile);
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.setVolume(0.5);
            mediaPlayer.play();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al cargar la música.");
        }
    }

    /**
     * Constructor que carga el archivo FXML correspondiente al menú y lo configura como controlador.
     */
    public MenuController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Menu.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Obtiene el contenedor raíz de la interfaz de usuario.
     * 
     * @return El BorderPane raíz que contiene la interfaz.
     */
    public BorderPane getRoot() {
        return root;
    }
}
