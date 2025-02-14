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
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;

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

    @FXML
    void onAjustes(ActionEvent event) {}

    @FXML
    void onContinuarPartida(ActionEvent event) {}

    @FXML
    void onHistoria(ActionEvent event) {}

    @FXML
    void onNuevaPartida(ActionEvent event) {

        if (mediaPlayer != null) {
            mediaPlayer.stop(); // Detiene la música del menú
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CombateView.fxml"));
            Parent root = loader.load();

            combateController = loader.getController();
            enemigosPrueba.add((Enemigo) DatosPredefinidos.ENTIDADES.get(3));
            personajesPrueba.add((Personaje) DatosPredefinidos.ENTIDADES.get(0));
            SistemaDeCombate sistemaDeCombate = new SistemaDeCombate(enemigosPrueba, personajesPrueba);
            combateController.setSistemaDeCombate(sistemaDeCombate);
            
            combateController.inicializarVista();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            String musicFile = getClass().getResource("/audio/musicaCombate.mp3").toExternalForm();
            Media media = new Media(musicFile);
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.setVolume(0.5);
            mediaPlayer.play();

        //    stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icono.png")));
            stage.setScene(new Scene(root));
            stage.setFullScreen(true);

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        root.getStylesheets().add(getClass().getResource("/styles/mundoria.css").toExternalForm());

        // Musica de fondo
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

    public MenuController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Menu.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BorderPane getRoot() {
        return root;
    }
}
