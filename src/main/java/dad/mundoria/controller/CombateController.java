package dad.mundoria.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dad.mundoria.model.Enemigo;
import dad.mundoria.model.Personaje;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class CombateController implements Initializable {

	@FXML
	private AnchorPane combateAnchorPane;

	@FXML
	private ImageView dadosImageView;

	@FXML
	private Label detallesAgilidadLabel;

	@FXML
	private AnchorPane detallesAnchorPane;

	@FXML
	private Label detallesAtaqueLabel;

	@FXML
	private Label detallesClaseLabel;

	@FXML
	private Label detallesDefensaLabel;

	@FXML
	private ImageView detallesImageView;

	@FXML
	private Label detallesNombreLabel;

	@FXML
	private Label detallesSaludLabel;

	@FXML
	private Label detallesStamanaLabel;

	@FXML
	private Label detallesSuerteLabel;

	@FXML
	private AnchorPane enemigoSlot1;

	@FXML
	private AnchorPane enemigoSlot2;

	@FXML
	private AnchorPane enemigoSlot3;

	@FXML
	private AnchorPane enemigoSlot4;

	@FXML
	private HBox enemigosListaHBox;

	@FXML
	private Button habilidadButtonSlot1;

	@FXML
	private Button habilidadButtonSlot2;

	@FXML
	private Button habilidadButtonSlot3;

	@FXML
	private Button habilidadButtonSlot4;

	@FXML
	private Button habilidadButtonSlot5;

	@FXML
	private AnchorPane habilidadesListaAnchorPane;

	@FXML
	private Button inventarioButton;

	@FXML
	private HBox listaHabilidadesHBox;

	@FXML
	private Label nombreEnemigoSlot1;

	@FXML
	private Label nombreEnemigoSlot2;

	@FXML
	private Label nombreEnemigoSlot3;

	@FXML
	private Label nombreEnemigoSlot4;

	@FXML
	private Label nombrePersonajeSlot1;

	@FXML
	private Label nombrePersonajeSlot2;

	@FXML
	private Label nombrePersonajeSlot3;

	@FXML
	private Label nombrePersonajeSlot4;

	@FXML
	private AnchorPane personajeSlot1;

	@FXML
	private AnchorPane personajeSlot2;

	@FXML
	private AnchorPane personajeSlot3;

	@FXML
	private AnchorPane personajeSlot4;

	@FXML
	private HBox personajesListaHBox;

	@FXML
	private BorderPane root;

	@FXML
	private ProgressBar saludEnemigoSlot1;

	@FXML
	private ProgressBar saludEnemigoSlot2;

	@FXML
	private ProgressBar saludEnemigoSlot3;

	@FXML
	private ProgressBar saludEnemigoSlot4;

	@FXML
	private ProgressBar saludPersonajeSlot1;

	@FXML
	private ProgressBar saludPersonajeSlot2;

	@FXML
	private ProgressBar saludPersonajeSlot3;

	@FXML
	private ProgressBar saludPersonajeSlot4;

	@FXML
	private ProgressBar stamanaEnemigoSlot1;

	@FXML
	private ProgressBar stamanaEnemigoSlot2;

	@FXML
	private ProgressBar stamanaEnemigoSlot3;

	@FXML
	private ProgressBar stamanaEnemigoSlot4;

	@FXML
	private ProgressBar stamanaPersonajeSlot1;

	@FXML
	private ProgressBar stamanaPersonajeSlot2;

	@FXML
	private ProgressBar stamanaPersonajeSlot3;

	@FXML
	private ProgressBar stamanaPersonajeSlot4;

	@FXML
	private GridPane statsGridPane;

	@FXML
	void onHabilidadSlot1(ActionEvent event) {

	}

	@FXML
	void onHabilidadSlot2(ActionEvent event) {

	}

	@FXML
	void onHabilidadSlot3(ActionEvent event) {

	}

	@FXML
	void onHabilidadSlot4(ActionEvent event) {

	}

	@FXML
	void onHabilidadSlot5(ActionEvent event) {

	}

	@FXML
	void onInventarioAction(ActionEvent event) {

	}
	
	private Personaje personaje1;
	private int saludMaxima1;
	private int saludActual1;
	private int stamanaMaxima1;
	private int stamanaActual1;
	private double progresoSalud1;
	private double progresoStamana1;
	
	private Personaje personaje2;
	private int saludMaxima2;
	private int saludActual2;
	private int stamanaMaxima2;
	private int stamanaActual2;
	private double progresoSalud2;
	private double progresoStamana2;
	
	private Personaje personaje3;
	private int saludMaxima3;
	private int saludActual3;
	private int stamanaMaxima3;
	private int stamanaActual3;
	private double progresoSalud3;
	private double progresoStamana3;
	
	
	private Personaje personaje4;
	private int saludMaxima4;
	private int saludActual4;
	private int stamanaMaxima4;
	private int stamanaActual4;
	private double progresoSalud4;
	private double progresoStamana4;
	
	private Enemigo enemigo1;
	private int saludMaximaE1;
	private int saludActualE1;
	private int stamanaMaximaE1;
	private int stamanaActualE1;
	private double progresoSaludE1;
	private double progresoStamanaE1;
	
	private Enemigo enemigo2;
	private int saludMaximaE2;
	private int saludActualE2;
	private int stamanaMaximaE2;
	private int stamanaActualE2;
	private double progresoSaludE2;
	private double progresoStamanaE2;
	
	private Enemigo enemigo3;
	private int saludMaximaE3;
	private int saludActualE3;
	private int stamanaMaximaE3;
	private int stamanaActualE3;
	private double progresoSaludE3;
	private double progresoStamanaE3;
	
	private Enemigo enemigo4;
	private int saludMaximaE4;
	private int saludActualE4;
	private int stamanaMaximaE4;
	private int stamanaActualE4;
	private double progresoSaludE4;
	private double progresoStamanaE4;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// bindings
		
		SimpleIntegerProperty saludWrapper1 = new SimpleIntegerProperty();
		SimpleIntegerProperty saludWrapper2 = new SimpleIntegerProperty();
		SimpleIntegerProperty saludWrapper3 = new SimpleIntegerProperty();
		SimpleIntegerProperty saludWrapper4 = new SimpleIntegerProperty();
		SimpleIntegerProperty saludWrapperE1 = new SimpleIntegerProperty();
		SimpleIntegerProperty saludWrapperE2 = new SimpleIntegerProperty();
		SimpleIntegerProperty saludWrapperE3 = new SimpleIntegerProperty();
		SimpleIntegerProperty saludWrapperE4 = new SimpleIntegerProperty();
		
		SimpleIntegerProperty stamanaWrapper1 = new SimpleIntegerProperty();
		SimpleIntegerProperty stamanaWrapper2 = new SimpleIntegerProperty();
		SimpleIntegerProperty stamanaWrapper3 = new SimpleIntegerProperty();
		SimpleIntegerProperty stamanaWrapper4 = new SimpleIntegerProperty();
		SimpleIntegerProperty stamanaWrapperE1 = new SimpleIntegerProperty();
		SimpleIntegerProperty stamanaWrapperE2 = new SimpleIntegerProperty();
		SimpleIntegerProperty stamanaWrapperE3 = new SimpleIntegerProperty();
		SimpleIntegerProperty stamanaWrapperE4 = new SimpleIntegerProperty();
		
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> {
		    saludWrapper1.set(personaje1.getSalud());
		    stamanaWrapper1.set(personaje1.getStamana());
		    saludActual1 = saludWrapper1.get();
		    stamanaActual1 = stamanaWrapper1.get();
		    progresoSalud1 = (double) saludActual1 / saludMaxima1;
		    progresoStamana1 = (double) stamanaActual1 / stamanaMaxima1;
		    
		    saludPersonajeSlot1.setProgress(progresoSalud1);
		    stamanaPersonajeSlot1.setProgress(progresoStamana1);
		    
		    saludWrapper2.set(personaje2.getSalud());
		    stamanaWrapper2.set(personaje2.getStamana());
		    saludActual2 = saludWrapper2.get();
		    stamanaActual2 = stamanaWrapper2.get();
		    progresoSalud2 = (double) saludActual2 / saludMaxima2;
		    progresoStamana2 = (double) stamanaActual2 / stamanaMaxima2;
		    
		    saludPersonajeSlot2.setProgress(progresoSalud2);
		    stamanaPersonajeSlot2.setProgress(progresoStamana2);
		    
		    saludWrapper3.set(personaje3.getSalud());
		    stamanaWrapper3.set(personaje3.getStamana());
		    saludActual3 = saludWrapper3.get();
		    stamanaActual3 = stamanaWrapper3.get();
		    progresoSalud3 = (double) saludActual3 / saludMaxima3;
		    progresoStamana3 = (double) stamanaActual3 / stamanaMaxima3;
		    
		    saludPersonajeSlot3.setProgress(progresoSalud3);
		    stamanaPersonajeSlot3.setProgress(progresoStamana3);
		    
		    saludWrapper4.set(personaje4.getSalud());
		    stamanaWrapper4.set(personaje4.getStamana());
		    saludActual4 = saludWrapper4.get();
		    stamanaActual4 = stamanaWrapper4.get();
		    progresoSalud4 = (double) saludActual4 / saludMaxima4;
		    progresoStamana4 = (double) stamanaActual4 / stamanaMaxima4;
		    
		    saludPersonajeSlot4.setProgress(progresoSalud4);
		    stamanaPersonajeSlot4.setProgress(progresoStamana4);
		    
		    saludWrapperE1.set(enemigo1.getSalud());
		    stamanaWrapperE1.set(enemigo1.getSalud());
		    saludActualE1 = saludWrapperE1.get();
		    stamanaActualE1 = stamanaWrapperE1.get();
		    progresoSaludE1 = (double) saludActualE1 / saludMaximaE1;
		    progresoStamanaE1 = (double) stamanaActualE1 / stamanaActualE1;
		    
		    saludEnemigoSlot1.setProgress(progresoSaludE1);
		    stamanaEnemigoSlot1.setProgress(progresoStamanaE1);
		    
		    saludWrapperE2.set(enemigo2.getSalud());
		    stamanaWrapperE2.set(enemigo2.getStamana());
		    saludActualE2 = saludWrapperE2.get();
		    stamanaActualE2 = stamanaWrapperE2.get();
		    progresoSaludE2 = (double) saludActualE2 / saludMaximaE2;
		    progresoStamanaE2 = (double) stamanaActualE2 / stamanaMaximaE2;
		    
		    saludEnemigoSlot2.setProgress(progresoSaludE2);
		    stamanaEnemigoSlot2.setProgress(progresoStamanaE2);
		    
		    saludWrapperE3.set(enemigo3.getSalud());
		    stamanaWrapperE3.set(enemigo3.getStamana());
		    saludActualE3 = saludWrapperE3.get();
		    stamanaActualE3 = stamanaWrapperE3.get();
		    progresoSaludE3 = (double) saludActualE3 / saludMaximaE3;
		    progresoStamanaE3 = (double) stamanaActualE3 / stamanaMaximaE3;
		    
		    saludEnemigoSlot3.setProgress(progresoSaludE3);
		    stamanaEnemigoSlot3.setProgress(progresoStamanaE3);
		    
		    saludWrapperE4.set(enemigo4.getSalud());
		    stamanaWrapperE4.set(enemigo4.getSalud());
		    saludActualE4 = saludWrapperE4.get();
		    stamanaActualE4 = stamanaWrapperE4.get();
		    progresoSaludE4 = (double) saludActualE4 / saludMaximaE4;
		    progresoStamanaE4 = (double) stamanaActualE4 / stamanaMaximaE4;
		    
		    saludEnemigoSlot4.setProgress(progresoSaludE4);
		    stamanaEnemigoSlot4.setProgress(progresoStamanaE4);
		    
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		
	}
	
	//Este método lo que hace resumidamente es obtener una lista de personajes
	//para con un switch calcular el tamaño de la lista y actuar en consecuencia.
	//Si hay 1 personaje, activa 1 slot. Si hay 2 personajes activa dos slots
	//y así consecutivamente. Es un método pensado para llamarse una vez por combate.
	public void actualizarSlotsPersonajes(List<Personaje> listaPersonajes) {
		
		switch (listaPersonajes.size()) {
		case 1:
			personaje1 = listaPersonajes.get(0);
			saludMaxima1 = personaje1.getSalud();
			saludActual1 = saludMaxima1;
			stamanaMaxima1 = personaje1.getStamana();
			stamanaActual1 = stamanaMaxima1;
			
			personajeSlot1.setVisible(true);
			nombrePersonajeSlot1.setText(personaje1.getNombre());
			saludPersonajeSlot1.setProgress(1);
			progresoSalud1 = 1;
			stamanaPersonajeSlot1.setProgress(1);
			progresoStamana1 = 1;
			
			break;
		case 2:
			personaje1 = listaPersonajes.get(0);
			saludMaxima1 = personaje1.getSalud();
			saludActual1 = saludMaxima1;
			stamanaMaxima1 = personaje1.getStamana();
			stamanaActual1 = stamanaMaxima1;
			
			personajeSlot1.setVisible(true);
			nombrePersonajeSlot1.setText(personaje1.getNombre());
			saludPersonajeSlot1.setProgress(1);
			progresoSalud1 = 1;
			stamanaPersonajeSlot1.setProgress(1);
			progresoStamana1 = 1;
			
			personaje2 = listaPersonajes.get(1);
			saludMaxima2 = personaje2.getSalud();
			saludActual2 = saludMaxima2;
			stamanaMaxima2 = personaje2.getStamana();
			stamanaActual2 = stamanaMaxima2;
			
			personajeSlot2.setVisible(true);
			nombrePersonajeSlot2.setText(personaje2.getNombre());
			saludPersonajeSlot2.setProgress(1);
			progresoSalud2 = 1;
			stamanaPersonajeSlot2.setProgress(1);
			progresoStamana2 = 1;
			
			break;
		case 3:
			personaje1 = listaPersonajes.get(0);
			saludMaxima1 = personaje1.getSalud();
			saludActual1 = saludMaxima1;
			stamanaMaxima1 = personaje1.getStamana();
			stamanaActual1 = stamanaMaxima1;
			
			personajeSlot1.setVisible(true);
			nombrePersonajeSlot1.setText(personaje1.getNombre());
			saludPersonajeSlot1.setProgress(1);
			progresoSalud1 = 1;
			stamanaPersonajeSlot1.setProgress(1);
			progresoStamana1 = 1;
			
			personaje2 = listaPersonajes.get(1);
			saludMaxima2 = personaje2.getSalud();
			saludActual2 = saludMaxima2;
			stamanaMaxima2 = personaje2.getStamana();
			stamanaActual2 = stamanaMaxima2;
			
			personajeSlot2.setVisible(true);
			nombrePersonajeSlot2.setText(personaje2.getNombre());
			saludPersonajeSlot2.setProgress(1);
			progresoSalud2 = 1;
			stamanaPersonajeSlot2.setProgress(1);
			progresoStamana2 = 1;
			
			personaje3 = listaPersonajes.get(2);
			saludMaxima3 = personaje3.getSalud();
			saludActual3 = saludMaxima3;
			stamanaMaxima3 = personaje3.getStamana();
			stamanaActual3 = stamanaMaxima3;
			
			personajeSlot3.setVisible(true);
			nombrePersonajeSlot3.setText(personaje3.getNombre());
			saludPersonajeSlot3.setProgress(1);
			progresoSalud3 = 1;
			stamanaPersonajeSlot3.setProgress(1);
			progresoStamana3 = 1;
			
			break;
		case 4:
			personaje1 = listaPersonajes.get(0);
			saludMaxima1 = personaje1.getSalud();
			saludActual1 = saludMaxima1;
			stamanaMaxima1 = personaje1.getStamana();
			stamanaActual1 = stamanaMaxima1;
			
			personajeSlot1.setVisible(true);
			nombrePersonajeSlot1.setText(personaje1.getNombre());
			saludPersonajeSlot1.setProgress(1);
			progresoSalud1 = 1;
			stamanaPersonajeSlot1.setProgress(1);
			progresoStamana1 = 1;
			
			personaje2 = listaPersonajes.get(1);
			saludMaxima2 = personaje2.getSalud();
			saludActual2 = saludMaxima2;
			stamanaMaxima2 = personaje2.getStamana();
			stamanaActual2 = stamanaMaxima2;
			
			personajeSlot2.setVisible(true);
			nombrePersonajeSlot2.setText(personaje2.getNombre());
			saludPersonajeSlot2.setProgress(1);
			progresoSalud2 = 1;
			stamanaPersonajeSlot2.setProgress(1);
			progresoStamana2 = 1;
			
			personaje3 = listaPersonajes.get(2);
			saludMaxima3 = personaje3.getSalud();
			saludActual3 = saludMaxima3;
			stamanaMaxima3 = personaje3.getStamana();
			stamanaActual3 = stamanaMaxima3;
			
			personajeSlot3.setVisible(true);
			nombrePersonajeSlot3.setText(personaje3.getNombre());
			saludPersonajeSlot3.setProgress(1);
			progresoSalud3 = 1;
			stamanaPersonajeSlot3.setProgress(1);
			progresoStamana3 = 1;
			
			personaje4 = listaPersonajes.get(3);
			saludMaxima4 = personaje4.getSalud();
			saludActual4 = saludMaxima4;
			stamanaMaxima4 = personaje4.getStamana();
			stamanaActual4 = stamanaMaxima4;
			
			personajeSlot4.setVisible(true);
			nombrePersonajeSlot4.setText(personaje4.getNombre());
			saludPersonajeSlot4.setProgress(1);
			progresoSalud4 = 1;
			stamanaPersonajeSlot4.setProgress(1);
			progresoStamana4 = 1;
			
			break;
		}
		
	}
	
	//Funciona igual que actualizarSlotsPersonajes.
	public void actualizarSlotsEnemigos(List<Enemigo> listaEnemigos) {
		
		switch(listaEnemigos.size()) {
		case 1:
			enemigo1 = listaEnemigos.get(0);
			saludMaximaE1 = enemigo1.getSalud();
			saludActualE1 = saludMaximaE1;
			stamanaMaximaE1 = enemigo1.getStamana();
			stamanaActualE1 = stamanaMaximaE1;
			
			enemigoSlot1.setVisible(true);
			nombreEnemigoSlot1.setText(enemigo1.getNombre());
			saludEnemigoSlot1.setProgress(1);
			progresoSaludE1 = 1;
			stamanaEnemigoSlot1.setProgress(1);
			progresoStamanaE1 = 1;
			
			break;
		case 2:
			enemigo1 = listaEnemigos.get(0);
			saludMaximaE1 = enemigo1.getSalud();
			saludActualE1 = saludMaximaE1;
			stamanaMaximaE1 = enemigo1.getStamana();
			stamanaActualE1 = stamanaMaximaE1;
			
			enemigoSlot1.setVisible(true);
			nombreEnemigoSlot1.setText(enemigo1.getNombre());
			saludEnemigoSlot1.setProgress(1);
			progresoSaludE1 = 1;
			stamanaEnemigoSlot1.setProgress(1);
			progresoStamanaE1 = 1;
			
			enemigo2 = listaEnemigos.get(1);
			saludMaximaE2 = enemigo2.getSalud();
			saludActualE2 = saludMaximaE2;
			stamanaMaximaE2 = enemigo2.getStamana();
			stamanaActualE2 = stamanaMaximaE2;
			
			enemigoSlot2.setVisible(true);
			nombreEnemigoSlot2.setText(enemigo2.getNombre());
			saludEnemigoSlot2.setProgress(1);
			progresoSaludE2 = 1;
			stamanaEnemigoSlot2.setProgress(1);
			progresoStamanaE2 = 1;
			
			break;
		case 3:
			enemigo1 = listaEnemigos.get(0);
			saludMaximaE1 = enemigo1.getSalud();
			saludActualE1 = saludMaximaE1;
			stamanaMaximaE1 = enemigo1.getStamana();
			stamanaActualE1 = stamanaMaximaE1;
			
			enemigoSlot1.setVisible(true);
			nombreEnemigoSlot1.setText(enemigo1.getNombre());
			saludEnemigoSlot1.setProgress(1);
			progresoSaludE1 = 1;
			stamanaEnemigoSlot1.setProgress(1);
			progresoStamanaE1 = 1;
			
			enemigo2 = listaEnemigos.get(1);
			saludMaximaE2 = enemigo2.getSalud();
			saludActualE2 = saludMaximaE2;
			stamanaMaximaE2 = enemigo2.getStamana();
			stamanaActualE2 = stamanaMaximaE2;
			
			enemigoSlot2.setVisible(true);
			nombreEnemigoSlot2.setText(enemigo2.getNombre());
			saludEnemigoSlot2.setProgress(1);
			progresoSaludE2 = 1;
			stamanaEnemigoSlot2.setProgress(1);
			progresoStamanaE2 = 1;
			
			enemigo3 = listaEnemigos.get(2);
			saludMaximaE3 = enemigo3.getSalud();
			saludActualE3 = saludMaximaE3;
			stamanaMaximaE3 = enemigo3.getStamana();
			stamanaActualE3 = stamanaMaximaE3;
			
			enemigoSlot3.setVisible(true);
			nombreEnemigoSlot3.setText(enemigo3.getNombre());
			saludEnemigoSlot3.setProgress(1);
			progresoSaludE3 = 1;
			stamanaEnemigoSlot3.setProgress(1);
			progresoStamanaE3 = 1;
			
			break;
		case 4:
			enemigo1 = listaEnemigos.get(0);
			saludMaximaE1 = enemigo1.getSalud();
			saludActualE1 = saludMaximaE1;
			stamanaMaximaE1 = enemigo1.getStamana();
			stamanaActualE1 = stamanaMaximaE1;
			
			enemigoSlot1.setVisible(true);
			nombreEnemigoSlot1.setText(enemigo1.getNombre());
			saludEnemigoSlot1.setProgress(1);
			progresoSaludE1 = 1;
			stamanaEnemigoSlot1.setProgress(1);
			progresoStamanaE1 = 1;
			
			enemigo2 = listaEnemigos.get(1);
			saludMaximaE2 = enemigo2.getSalud();
			saludActualE2 = saludMaximaE2;
			stamanaMaximaE2 = enemigo2.getStamana();
			stamanaActualE2 = stamanaMaximaE2;
			
			enemigoSlot2.setVisible(true);
			nombreEnemigoSlot2.setText(enemigo2.getNombre());
			saludEnemigoSlot2.setProgress(1);
			progresoSaludE2 = 1;
			stamanaEnemigoSlot2.setProgress(1);
			progresoStamanaE2 = 1;
			
			enemigo3 = listaEnemigos.get(2);
			saludMaximaE3 = enemigo3.getSalud();
			saludActualE3 = saludMaximaE3;
			stamanaMaximaE3 = enemigo3.getStamana();
			stamanaActualE3 = stamanaMaximaE3;
			
			enemigoSlot3.setVisible(true);
			nombreEnemigoSlot3.setText(enemigo3.getNombre());
			saludEnemigoSlot3.setProgress(1);
			progresoSaludE3 = 1;
			stamanaEnemigoSlot3.setProgress(1);
			progresoStamanaE3 = 1;
			
			enemigo4 = listaEnemigos.get(3);
			saludMaximaE4 = enemigo4.getSalud();
			saludActualE4 = saludMaximaE4;
			stamanaMaximaE4 = enemigo4.getStamana();
			stamanaActualE4 = stamanaMaximaE4;
			
			enemigoSlot4.setVisible(true);
			nombreEnemigoSlot4.setText(enemigo4.getNombre());
			saludEnemigoSlot4.setProgress(1);
			progresoSaludE4 = 1;
			stamanaEnemigoSlot4.setProgress(1);
			progresoStamanaE4 = 1;
			
			break;
		}
		
	}

}
