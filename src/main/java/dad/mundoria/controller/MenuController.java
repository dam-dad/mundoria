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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
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

    @FXML
    void onAjustes(ActionEvent event) {

    }

    @FXML
    void onContinuarPartida(ActionEvent event) {

    }

    @FXML
    void onHistoria(ActionEvent event) {

    }

    @FXML
    void onNuevaPartida(ActionEvent event) {
    	
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CombateView.fxml"));
            Parent root = loader.load();

            combateController = loader.getController();

            enemigosPrueba.add((Enemigo) DatosPredefinidos.ENTIDADES.get(3));
        	personajesPrueba.add((Personaje) DatosPredefinidos.ENTIDADES.get(0));
        	SistemaDeCombate sistemaDeCombate = new SistemaDeCombate(enemigosPrueba, personajesPrueba);
        	combateController.setSistemaDeCombate(sistemaDeCombate);
        	
        	combateController.inicializarVista();
            
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("MundorIA");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onSalir(ActionEvent event) {

    }

    private CombateController combateController;
    
    private List<Enemigo> enemigosPrueba = new ArrayList<>();
    private List<Personaje> personajesPrueba = new ArrayList<>();
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public MenuController() {
		try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MenuView.fxml"));
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

