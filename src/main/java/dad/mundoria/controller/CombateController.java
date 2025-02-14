package dad.mundoria.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dad.mundoria.model.Enemigo;
import dad.mundoria.model.Habilidad;
import dad.mundoria.model.Inventario;
import dad.mundoria.model.Personaje;
import dad.mundoria.model.SistemaDeCombate;
import dad.mundoria.model.TurnoListener;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 * Controlador para la vista de combate del juego. Este controlador gestiona las interacciones
 * entre los personajes y enemigos, incluyendo la selección de personajes, el uso de habilidades,
 * y el seguimiento del progreso de salud y stamina durante el combate.
 * 
 * <p>Implementa la interfaz {@link TurnoListener} para gestionar los turnos entre el jugador
 * y los enemigos durante el combate.</p>
 */
public class CombateController implements Initializable, TurnoListener {

    // Definición de los componentes FXML que serán usados en la vista de combate.
    @FXML private AnchorPane combateAnchorPane;
    @FXML private ImageView dadosImageView;
    @FXML private Label detallesAgilidadLabel;
    @FXML private AnchorPane detallesAnchorPane;
    @FXML private Label detallesAtaqueLabel;
    @FXML private Label detallesClaseLabel;
    @FXML private Label detallesDefensaLabel;
    @FXML private ImageView detallesImageView;
    @FXML private Label detallesNombreLabel;
    @FXML private Label detallesSaludLabel;
    @FXML private Label detallesStamanaLabel;
    @FXML private Label detallesSuerteLabel;
    @FXML private AnchorPane enemigoSlot1;
    @FXML private AnchorPane enemigoSlot2;
    @FXML private AnchorPane enemigoSlot3;
    @FXML private AnchorPane enemigoSlot4;
    @FXML private HBox enemigosListaHBox;
    @FXML private Button habilidadButtonSlot1;
    @FXML private Button habilidadButtonSlot2;
    @FXML private Button habilidadButtonSlot3;
    @FXML private Button habilidadButtonSlot4;
    @FXML private Button habilidadButtonSlot5;
    @FXML private AnchorPane habilidadesListaAnchorPane;
    @FXML private Button inventarioButton;
    @FXML private HBox listaHabilidadesHBox;
    @FXML private Label nombreEnemigoSlot1;
    @FXML private Label nombreEnemigoSlot2;
    @FXML private Label nombreEnemigoSlot3;
    @FXML private Label nombreEnemigoSlot4;
    @FXML private Label nombrePersonajeSlot1;
    @FXML private Label nombrePersonajeSlot2;
    @FXML private Label nombrePersonajeSlot3;
    @FXML private Label nombrePersonajeSlot4;
    @FXML private AnchorPane personajeSlot1;
    @FXML private AnchorPane personajeSlot2;
    @FXML private AnchorPane personajeSlot3;
    @FXML private AnchorPane personajeSlot4;
    @FXML private HBox personajesListaHBox;
    @FXML private BorderPane root;
    @FXML private ProgressBar saludEnemigoSlot1;
    @FXML private ProgressBar saludEnemigoSlot2;
    @FXML private ProgressBar saludEnemigoSlot3;
    @FXML private ProgressBar saludEnemigoSlot4;
    @FXML private ProgressBar saludPersonajeSlot1;
    @FXML private ProgressBar saludPersonajeSlot2;
    @FXML private ProgressBar saludPersonajeSlot3;
    @FXML private ProgressBar saludPersonajeSlot4;
    @FXML private ProgressBar stamanaEnemigoSlot1;
    @FXML private ProgressBar stamanaEnemigoSlot2;
    @FXML private ProgressBar stamanaEnemigoSlot3;
    @FXML private ProgressBar stamanaEnemigoSlot4;
    @FXML private ProgressBar stamanaPersonajeSlot1;
    @FXML private ProgressBar stamanaPersonajeSlot2;
    @FXML private ProgressBar stamanaPersonajeSlot3;
    @FXML private ProgressBar stamanaPersonajeSlot4;
    @FXML private GridPane statsGridPane;

    /**
     * Método que gestiona la selección de un enemigo al hacer clic en uno de los slots de enemigo.
     * Este método asigna el enemigo seleccionado a la variable {@code enemigoSeleccionado}.
     *
     * @param event El evento de clic del mouse sobre el slot del enemigo seleccionado.
     */
    @FXML
    void onEnemigoSlot1Clicked(MouseEvent event) {
        if (enemigo1 != null) {
            enemigoSeleccionado = enemigo1;
        } else {
            System.err.println("ERROR: Enemigo es NULL");
        }
    }

    /**
     * Método que gestiona la selección de un personaje al hacer clic en uno de los slots de personaje.
     * Este método asigna el personaje seleccionado a la variable {@code personajeSeleccionado},
     * cargando los detalles y habilidades del personaje.
     *
     * @param event El evento de clic del mouse sobre el slot del personaje seleccionado.
     */
    @FXML
    void onPersonajeSlot1Clicked(MouseEvent event) {
        if (personaje1 != null) {
            personajeSeleccionado = personaje1;
            cargarDetalles(personaje1);
            cargarHabilidades(personaje1.getClase().getHabilidades());
        } else {
            System.err.println("ERROR: Personaje es NULL");
        }
    }

    /**
     * Acción que se ejecuta al seleccionar la primera habilidad de un personaje.
     * Realiza la acción correspondiente en el combate entre el personaje seleccionado y el enemigo seleccionado.
     * 
     * Si alguno de los objetos necesarios (personaje, enemigo o habilidad) es {@code null},
     * se mostrará un mensaje de error en la consola.
     * 
     * @param event El evento que dispara la acción de la habilidad (clic sobre el botón).
     */
    @FXML
    void onHabilidadSlot1(ActionEvent event) {
        if (personajeSeleccionado == null) {
            System.err.println("ERROR: Personaje seleccionado es NULL");
        } else if (enemigoSeleccionado == null) {
            System.err.println("ERROR: Enemigo seleccionado es NULL");
        } else if (habilidad1 == null) {
            System.err.println("ERROR: Habilidad seleccionada es NULL");
        } else {
            sistemaDeCombate.realizarAccion(personajeSeleccionado, enemigoSeleccionado, habilidad1);
            sistemaDeCombate.procesarCombate();
        }
    }

    /**
     * Método de inicialización de la vista de combate, que se ejecuta cuando el controlador es cargado.
     * Actualiza los slots de personajes y enemigos, y configura un {@link Timeline} para actualizar
     * la interfaz durante el combate.
     */
    public void inicializarVista() {
        actualizarSlotsPersonajes(sistemaDeCombate.getPersonajes());
        actualizarSlotsEnemigos(sistemaDeCombate.getEnemigos());
        configurarTimeline();
        
        if (personaje1 != null) {
            personajeSeleccionado = personaje1;
            cargarDetalles(personaje1);
            cargarHabilidades(personaje1.getClase().getHabilidades());
        }
    }

    /**
 * Configura y arranca una animación en bucle que actualiza periódicamente los valores de salud y estamina
 * de los personajes y enemigos en la interfaz de usuario.
 * Esta animación se ejecuta cada 100 milisegundos y actualiza las barras de progreso de salud y estamina
 * para cada uno de los personajes y enemigos visibles en la interfaz.
 * La información sobre los personajes y enemigos se obtiene de sus respectivas propiedades, y los valores
 * de progreso se actualizan basándose en los valores actuales y máximos de salud y estamina.
 * 
 * Se utiliza un {@link Timeline} que se ejecuta de manera indefinida, actualizando los valores y los
 * componentes gráficos correspondientes.
 * 
 * @see Timeline
 * @see KeyFrame
 * @see Duration
 */
public void configurarTimeline() {
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
    
    // Crear una Timeline que se actualiza cada 100ms
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> {
        // Actualiza los valores de salud y estamina de cada personaje y enemigo visible
        if (personaje1 != null) {
            saludWrapper1.set(personaje1.getSalud());
            stamanaWrapper1.set(personaje1.getStamana());
            saludActual1 = saludWrapper1.get();
            stamanaActual1 = stamanaWrapper1.get();
            progresoSalud1 = (double) saludActual1 / saludMaxima1;
            progresoStamana1 = (double) stamanaActual1 / stamanaMaxima1;
            saludPersonajeSlot1.setProgress(progresoSalud1);
            stamanaPersonajeSlot1.setProgress(progresoStamana1);
        }

        if (personaje2 != null) {
            saludWrapper2.set(personaje2.getSalud());
            stamanaWrapper2.set(personaje2.getStamana());
            saludActual2 = saludWrapper2.get();
            stamanaActual2 = stamanaWrapper2.get();
            progresoSalud2 = (double) saludActual2 / saludMaxima2;
            progresoStamana2 = (double) stamanaActual2 / stamanaMaxima2;
            saludPersonajeSlot2.setProgress(progresoSalud2);
            stamanaPersonajeSlot2.setProgress(progresoStamana2);
        }

        if (personaje3 != null) {
            saludWrapper3.set(personaje3.getSalud());
            stamanaWrapper3.set(personaje3.getStamana());
            saludActual3 = saludWrapper3.get();
            stamanaActual3 = stamanaWrapper3.get();
            progresoSalud3 = (double) saludActual3 / saludMaxima3;
            progresoStamana3 = (double) stamanaActual3 / stamanaMaxima3;
            saludPersonajeSlot3.setProgress(progresoSalud3);
            stamanaPersonajeSlot3.setProgress(progresoStamana3);
        }

        if (personaje4 != null) {
            saludWrapper4.set(personaje4.getSalud());
            stamanaWrapper4.set(personaje4.getStamana());
            saludActual4 = saludWrapper4.get();
            stamanaActual4 = stamanaWrapper4.get();
            progresoSalud4 = (double) saludActual4 / saludMaxima4;
            progresoStamana4 = (double) stamanaActual4 / stamanaMaxima4;
            saludPersonajeSlot4.setProgress(progresoSalud4);
            stamanaPersonajeSlot4.setProgress(progresoStamana4);
        }

        if (enemigo1 != null) {
            saludWrapperE1.set(enemigo1.getSalud());
            stamanaWrapperE1.set(enemigo1.getStamana());
            saludActualE1 = saludWrapperE1.get();
            stamanaActualE1 = stamanaWrapperE1.get();
            progresoSaludE1 = (double) saludActualE1 / saludMaximaE1;
            progresoStamanaE1 = (double) stamanaActualE1 / stamanaMaximaE1;
            saludEnemigoSlot1.setProgress(progresoSaludE1);
            stamanaEnemigoSlot1.setProgress(progresoStamanaE1);
        }

        if (enemigo2 != null) {
            saludWrapperE2.set(enemigo2.getSalud());
            stamanaWrapperE2.set(enemigo2.getStamana());
            saludActualE2 = saludWrapperE2.get();
            stamanaActualE2 = stamanaWrapperE2.get();
            progresoSaludE2 = (double) saludActualE2 / saludMaximaE2;
            progresoStamanaE2 = (double) stamanaActualE2 / stamanaMaximaE2;
            saludEnemigoSlot2.setProgress(progresoSaludE2);
            stamanaEnemigoSlot2.setProgress(progresoStamanaE2);
        }

        if (enemigo3 != null) {
            saludWrapperE3.set(enemigo3.getSalud());
            stamanaWrapperE3.set(enemigo3.getStamana());
            saludActualE3 = saludWrapperE3.get();
            stamanaActualE3 = stamanaWrapperE3.get();
            progresoSaludE3 = (double) saludActualE3 / saludMaximaE3;
            progresoStamanaE3 = (double) stamanaActualE3 / stamanaMaximaE3;
            saludEnemigoSlot3.setProgress(progresoSaludE3);
            stamanaEnemigoSlot3.setProgress(progresoStamanaE3);
        }

        if (enemigo4 != null) {
            saludWrapperE4.set(enemigo4.getSalud());
            stamanaWrapperE4.set(enemigo4.getStamana());
            saludActualE4 = saludWrapperE4.get();
            stamanaActualE4 = stamanaWrapperE4.get();
            progresoSaludE4 = (double) saludActualE4 / saludMaximaE4;
            progresoStamanaE4 = (double) stamanaActualE4 / stamanaMaximaE4;
            saludEnemigoSlot4.setProgress(progresoSaludE4);
            stamanaEnemigoSlot4.setProgress(progresoStamanaE4);
        }

    }));
    // Configura la animación para que se repita indefinidamente
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();    
}
/**
 * Actualiza los slots de los personajes basándose en el tamaño de la lista de personajes.
 * Para cada personaje, se asignan valores de salud y estamina, y se configuran los slots visibles
 * con los datos correspondientes, como nombre, salud y estamina. Este método está diseñado 
 * para ejecutarse una vez por combate.
 * 
 * @param listaPersonajes Una lista de personajes que se utilizará para actualizar los slots.
 */
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

/**
 * Actualiza los slots de los enemigos basándose en el tamaño de la lista de enemigos.
 * Para cada enemigo, se asignan valores de salud y estamina, y se configuran los slots visibles
 * con los datos correspondientes, como nombre, salud y estamina. Este método está diseñado 
 * para ejecutarse una vez por combate.
 * 
 * @param listaEnemigos Una lista de enemigos que se utilizará para actualizar los slots.
 */
public void actualizarSlotsEnemigos(List<Enemigo> listaEnemigos) {

    switch (listaEnemigos.size()) {
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

/**
 * Carga los detalles del personaje seleccionado y los muestra en la interfaz.
 * 
 * @param personaje El objeto Personaje cuyos detalles se mostrarán.
 */
public void cargarDetalles(Personaje personaje) {
    detallesNombreLabel.setText(personaje.getNombre());
    detallesClaseLabel.setText(personaje.getClase().getNombre());
    detallesSaludLabel.setText(String.valueOf(personaje.getSalud()));
    detallesStamanaLabel.setText(String.valueOf(personaje.getStamana()));
    detallesAgilidadLabel.setText(String.valueOf(personaje.getAgilidad()));
    detallesSuerteLabel.setText(String.valueOf(personaje.getSuerte()));
    detallesDefensaLabel.setText(String.valueOf(personaje.getDefensa()));
    detallesAtaqueLabel.setText(String.valueOf(personaje.getAtaque()));
    inventarioActual = personaje.getInventario();
}

/**
 * Carga las habilidades del personaje y ajusta los botones de habilidad en la interfaz
 * según el nivel del personaje y las habilidades disponibles.
 * 
 * @param listaHabilidades Lista de habilidades del personaje que se cargarán.
 */
public void cargarHabilidades(List<Habilidad> listaHabilidades) {
    habilidad1 = listaHabilidades.get(0);
    habilidad2 = listaHabilidades.get(1);
    habilidad3 = listaHabilidades.get(2);
    habilidad4 = listaHabilidades.get(3);
    habilidad5 = listaHabilidades.get(4);
    
    habilidadButtonSlot1.setText(habilidad1.getNombre());
    habilidadButtonSlot2.setText(habilidad2.getNombre());
    habilidadButtonSlot3.setText(habilidad3.getNombre());
    habilidadButtonSlot4.setText(habilidad4.getNombre());
    habilidadButtonSlot5.setText(habilidad5.getNombre());

    // Habilita o deshabilita los botones de habilidad según el nivel del personaje.
    if (habilidad1.getNivelRequerido() <= personajeSeleccionado.getNivel()) {
        habilidadButtonSlot1.setDisable(false);
    } else {
        habilidadButtonSlot1.setDisable(true);
    }
    if (habilidad2.getNivelRequerido() <= personajeSeleccionado.getNivel()) {
        habilidadButtonSlot2.setDisable(false);
    } else {
        habilidadButtonSlot2.setDisable(true);
    }
    if (habilidad3.getNivelRequerido() <= personajeSeleccionado.getNivel()) {
        habilidadButtonSlot3.setDisable(false);
    } else {
        habilidadButtonSlot3.setDisable(true);
    }
    if (habilidad4.getNivelRequerido() <= personajeSeleccionado.getNivel()) {
        habilidadButtonSlot4.setDisable(false);
    } else {
        habilidadButtonSlot4.setDisable(true);
    }
    if (habilidad5.getNivelRequerido() <= personajeSeleccionado.getNivel()) {
        habilidadButtonSlot5.setDisable(false);
    } else {
        habilidadButtonSlot5.setDisable(true);
    }
}

/**
 * Obtiene el contenedor de la lista de enemigos en la interfaz.
 * 
 * @return El HBox que contiene los enemigos.
 */
public HBox getEnemigosListaHBox() {
    return enemigosListaHBox;
}

/**
 * Obtiene el contenedor de la lista de personajes en la interfaz.
 * 
 * @return El HBox que contiene los personajes.
 */
public HBox getPersonajesListaHBox() {
    return personajesListaHBox;
}

/**
 * Obtiene el contenedor principal de la interfaz.
 * 
 * @return El BorderPane principal de la interfaz.
 */
public BorderPane getRoot() {
    return root;
}

/**
 * Obtiene el enemigo seleccionado en la interfaz.
 * 
 * @return El objeto Enemigo que está actualmente seleccionado.
 */
public Enemigo getEnemigoSeleccionado() {
    return enemigoSeleccionado;
}

/**
 * Establece el sistema de combate que se utilizará en la interfaz.
 * 
 * @param sistemaDeCombate El sistema de combate que se asignará.
 */
public void setSistemaDeCombate(SistemaDeCombate sistemaDeCombate) {
    this.sistemaDeCombate = sistemaDeCombate;
}
}
