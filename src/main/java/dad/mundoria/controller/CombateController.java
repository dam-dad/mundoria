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
 * Controlador de la vista de combate.
 * <p>
 * Esta clase se encarga de gestionar la interfaz de combate, incluyendo la actualización
 * de las barras de salud y stamina, la selección de personajes y enemigos, y la ejecución de
 * acciones de combate a través de habilidades.
 * </p>
 * <p>
 * Implementa {@link Initializable} para la inicialización de la vista y {@link TurnoListener}
 * para gestionar los turnos de jugador y enemigo.
 * </p>
 */
public class CombateController implements Initializable, TurnoListener {

    // Componentes de la interfaz
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

    // Métodos de manejo de eventos de selección de enemigos
    /**
     * Gestiona la selección del primer slot de enemigo.
     * Asigna a {@code enemigoSeleccionado} el enemigo del primer slot si existe.
     * 
     * @param event Evento de clic sobre el slot del primer enemigo.
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
     * Gestiona la selección del segundo slot de enemigo.
     * Asigna a {@code enemigoSeleccionado} el enemigo del segundo slot si existe.
     * 
     * @param event Evento de clic sobre el slot del segundo enemigo.
     */
    @FXML
    void onEnemigoSlot2Clicked(MouseEvent event) {
        if (enemigo2 != null) {
            enemigoSeleccionado = enemigo2;
        } else {
            System.err.println("ERROR: Enemigo es NULL");
        }
    }

    /**
     * Gestiona la selección del tercer slot de enemigo.
     * Asigna a {@code enemigoSeleccionado} el enemigo del tercer slot si existe.
     * 
     * @param event Evento de clic sobre el slot del tercer enemigo.
     */
    @FXML
    void onEnemigoSlot3Clicked(MouseEvent event) {
        if (enemigo3 != null) {
            enemigoSeleccionado = enemigo3;
        } else {
            System.err.println("ERROR: Enemigo es NULL");
        }
    }

    /**
     * Gestiona la selección del cuarto slot de enemigo.
     * Asigna a {@code enemigoSeleccionado} el enemigo del cuarto slot si existe.
     * 
     * @param event Evento de clic sobre el slot del cuarto enemigo.
     */
    @FXML
    void onEnemigoSlot4Clicked(MouseEvent event) {
        if (enemigo4 != null) {
            enemigoSeleccionado = enemigo4;
        } else {
            System.err.println("ERROR: Enemigo es NULL");
        }
    }

    // Métodos de manejo de eventos de selección de personajes
    /**
     * Gestiona la selección del primer slot de personaje.
     * Asigna a {@code personajeSeleccionado} el personaje del primer slot, carga sus detalles
     * y habilidades.
     * 
     * @param event Evento de clic sobre el slot del primer personaje.
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
     * Gestiona la selección del segundo slot de personaje.
     * Asigna a {@code personajeSeleccionado} el personaje del segundo slot, carga sus detalles
     * y habilidades.
     * 
     * @param event Evento de clic sobre el slot del segundo personaje.
     */
    @FXML
    void onPersonajeSlot2Clicked(MouseEvent event) {
        if (personaje2 != null) {
            personajeSeleccionado = personaje2;
            cargarDetalles(personaje2);
            cargarHabilidades(personaje2.getClase().getHabilidades());
        } else {
            System.err.println("ERROR: Personaje es NULL");
        }
    }

    /**
     * Gestiona la selección del tercer slot de personaje.
     * Asigna a {@code personajeSeleccionado} el personaje del tercer slot, carga sus detalles
     * y habilidades.
     * 
     * @param event Evento de clic sobre el slot del tercer personaje.
     */
    @FXML
    void onPersonajeSlot3Clicked(MouseEvent event) {
        if (personaje3 != null) {
            personajeSeleccionado = personaje3;
            cargarDetalles(personaje3);
            cargarHabilidades(personaje3.getClase().getHabilidades());
        } else {
            System.err.println("ERROR: Personaje es NULL");
        }
    }

    /**
     * Gestiona la selección del cuarto slot de personaje.
     * Asigna a {@code personajeSeleccionado} el personaje del cuarto slot, carga sus detalles
     * y habilidades.
     * 
     * @param event Evento de clic sobre el slot del cuarto personaje.
     */
    @FXML
    void onPersonajeSlot4Clicked(MouseEvent event) {
        if (personaje4 != null) {
            personajeSeleccionado = personaje4;
            cargarDetalles(personaje4);
            cargarHabilidades(personaje4.getClase().getHabilidades());
        } else {
            System.err.println("ERROR: Personaje es NULL");
        }
    }

    // Métodos de manejo de eventos de habilidades
    /**
     * Gestiona el uso de la primera habilidad.
     * Verifica que existan el personaje, el enemigo y la habilidad, luego realiza la acción
     * y procesa el combate.
     * 
     * @param event Evento de acción al presionar el botón de la primera habilidad.
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
     * Gestiona el uso de la segunda habilidad.
     * 
     * @param event Evento de acción al presionar el botón de la segunda habilidad.
     */
    @FXML
    void onHabilidadSlot2(ActionEvent event) {
        if (personajeSeleccionado == null) {
            System.err.println("ERROR: Personaje seleccionado es NULL");
        } else if (enemigoSeleccionado == null) {
            System.err.println("ERROR: Enemigo seleccionado es NULL");
        } else if (habilidad2 == null) {
            System.err.println("ERROR: Habilidad seleccionada es NULL");
        } else {
            sistemaDeCombate.realizarAccion(personajeSeleccionado, enemigoSeleccionado, habilidad2);
            sistemaDeCombate.procesarCombate();
        }
    }

    /**
     * Gestiona el uso de la tercera habilidad.
     * 
     * @param event Evento de acción al presionar el botón de la tercera habilidad.
     */
    @FXML
    void onHabilidadSlot3(ActionEvent event) {
        if (personajeSeleccionado == null) {
            System.err.println("ERROR: Personaje seleccionado es NULL");
        } else if (enemigoSeleccionado == null) {
            System.err.println("ERROR: Enemigo seleccionado es NULL");
        } else if (habilidad3 == null) {
            System.err.println("ERROR: Habilidad seleccionada es NULL");
        } else {
            sistemaDeCombate.realizarAccion(personajeSeleccionado, enemigoSeleccionado, habilidad3);
            sistemaDeCombate.procesarCombate();
        }
    }

    /**
     * Gestiona el uso de la cuarta habilidad.
     * 
     * @param event Evento de acción al presionar el botón de la cuarta habilidad.
     */
    @FXML
    void onHabilidadSlot4(ActionEvent event) {
        if (personajeSeleccionado == null) {
            System.err.println("ERROR: Personaje seleccionado es NULL");
        } else if (enemigoSeleccionado == null) {
            System.err.println("ERROR: Enemigo seleccionado es NULL");
        } else if (habilidad4 == null) {
            System.err.println("ERROR: Habilidad seleccionada es NULL");
        } else {
            sistemaDeCombate.realizarAccion(personajeSeleccionado, enemigoSeleccionado, habilidad4);
            sistemaDeCombate.procesarCombate();
        }
    }

    /**
     * Gestiona el uso de la quinta habilidad.
     * 
     * @param event Evento de acción al presionar el botón de la quinta habilidad.
     */
    @FXML
    void onHabilidadSlot5(ActionEvent event) {
        if (personajeSeleccionado == null) {
            System.err.println("ERROR: Personaje seleccionado es NULL");
        } else if (enemigoSeleccionado == null) {
            System.err.println("ERROR: Enemigo seleccionado es NULL");
        } else if (habilidad5 == null) {
            System.err.println("ERROR: Habilidad seleccionada es NULL");
        } else {
            sistemaDeCombate.realizarAccion(personajeSeleccionado, enemigoSeleccionado, habilidad5);
            sistemaDeCombate.procesarCombate();
        }
    }

    /**
     * Gestiona la acción de inventario.
     * Actualmente no implementado.
     * 
     * @param event Evento de acción al presionar el botón de inventario.
     */
    @FXML
    void onInventarioAction(ActionEvent event) {
        // Implementar acción de inventario
    }

    // Variables de datos para personajes
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

    // Variables de datos para enemigos
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

    // Variables para selección actual y datos auxiliares
    private Personaje personajeSeleccionado;
    private Enemigo enemigoSeleccionado;
    private Inventario inventarioActual;
    private Habilidad habilidad1;
    private Habilidad habilidad2;
    private Habilidad habilidad3;
    private Habilidad habilidad4;
    private Habilidad habilidad5;
    private SistemaDeCombate sistemaDeCombate;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		root.getStylesheets().add(getClass().getResource("/styles/combate.css").toExternalForm());
		

		// bindings
		
	}

    /**
     * Inicializa la vista del combate. 
     * Se actualizan los slots de personajes y enemigos, se configura la actualización 
     * en tiempo real de las barras de salud y stamina, y se carga la información del primer personaje.
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
     * Configura y arranca un {@link Timeline} que se ejecuta cada 100 milisegundos para actualizar las barras de progreso
     * de salud y stamina de los personajes y enemigos en la interfaz.
     * <p>
     * En cada ciclo se obtienen los valores actuales de salud y stamina, se calcula la proporción respecto a los
     * valores máximos y, antes de asignar el progreso a las {@link ProgressBar}, se fuerza el valor a estar dentro
     * del rango [0,1] para evitar que la barra entre en estado indeterminado.
     * </p>
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
        
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            if (personaje1 != null) {
                saludWrapper1.set(personaje1.getSalud());
                stamanaWrapper1.set(personaje1.getStamana());
                saludActual1 = saludWrapper1.get();
                stamanaActual1 = stamanaWrapper1.get();
                progresoSalud1 = (double) saludActual1 / saludMaxima1;
                progresoStamana1 = (double) stamanaActual1 / stamanaMaxima1;
                // Asegurarse de que el progreso se mantenga en el rango [0,1]
                progresoSalud1 = Math.max(0, Math.min(progresoSalud1, 1));
                progresoStamana1 = Math.max(0, Math.min(progresoStamana1, 1));
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
                progresoSalud2 = Math.max(0, Math.min(progresoSalud2, 1));
                progresoStamana2 = Math.max(0, Math.min(progresoStamana2, 1));
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
                progresoSalud3 = Math.max(0, Math.min(progresoSalud3, 1));
                progresoStamana3 = Math.max(0, Math.min(progresoStamana3, 1));
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
                progresoSalud4 = Math.max(0, Math.min(progresoSalud4, 1));
                progresoStamana4 = Math.max(0, Math.min(progresoStamana4, 1));
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
                progresoSaludE1 = Math.max(0, Math.min(progresoSaludE1, 1));
                progresoStamanaE1 = Math.max(0, Math.min(progresoStamanaE1, 1));
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
                progresoSaludE2 = Math.max(0, Math.min(progresoSaludE2, 1));
                progresoStamanaE2 = Math.max(0, Math.min(progresoStamanaE2, 1));
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
                progresoSaludE3 = Math.max(0, Math.min(progresoSaludE3, 1));
                progresoStamanaE3 = Math.max(0, Math.min(progresoStamanaE3, 1));
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
                progresoSaludE4 = Math.max(0, Math.min(progresoSaludE4, 1));
                progresoStamanaE4 = Math.max(0, Math.min(progresoStamanaE4, 1));
                saludEnemigoSlot4.setProgress(progresoSaludE4);
                stamanaEnemigoSlot4.setProgress(progresoStamanaE4);
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    
    /**
     * Actualiza los slots de personajes en la interfaz.
     * Dependiendo del número de personajes en la lista, se activa el número correspondiente de slots,
     * se asigna la información y se inicializan las barras de salud y stamina.
     * 
     * @param listaPersonajes Lista de personajes a mostrar.
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
     * Actualiza los slots de enemigos en la interfaz.
     * Dependiendo del número de enemigos en la lista, se activa el número correspondiente de slots
     * y se asigna la información (nombre, salud y stamina) a cada slot.
     * 
     * @param listaEnemigos Lista de enemigos a mostrar en los slots.
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
     * Carga los detalles del personaje en la sección de detalles de la interfaz.
     * Actualiza los labels correspondientes con la información del personaje.
     * 
     * @param personaje El personaje cuyos detalles se mostrarán.
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
     * Carga las habilidades del personaje y actualiza los botones correspondientes en la interfaz.
     * Habilita o deshabilita cada botón según si el personaje cumple el nivel requerido para la habilidad.
     * 
     * @param listaHabilidades Lista de habilidades a cargar.
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
     * Obtiene el contenedor que muestra la lista de enemigos en la interfaz.
     * 
     * @return El contenedor HBox que contiene la lista de enemigos.
     */
    public HBox getEnemigosListaHBox() {
        return enemigosListaHBox;
    }
    
    /**
     * Obtiene el contenedor que muestra la lista de personajes en la interfaz.
     * 
     * @return El contenedor HBox que contiene la lista de personajes.
     */
    public HBox getPersonajesListaHBox() {
        return personajesListaHBox;
    }
    
    /**
     * Obtiene el contenedor raíz de la vista de combate.
     * 
     * @return El contenedor BorderPane raíz.
     */
    public BorderPane getRoot() {
        return root;
    }
    
    /**
     * Obtiene el enemigo actualmente seleccionado en la interfaz.
     * 
     * @return El enemigo seleccionado.
     */
    public Enemigo getEnemigoSeleccionado() {
        return enemigoSeleccionado;
    }
    
    /**
     * Establece el sistema de combate que se está utilizando en la interfaz.
     * 
     * @param sistemaDeCombate El objeto SistemaDeCombate a asignar.
     */
    public void setSistemaDeCombate(SistemaDeCombate sistemaDeCombate) {
        this.sistemaDeCombate = sistemaDeCombate;
    }
    
    // Métodos del TurnoListener
    /**
     * Gestiona el turno del jugador.
     * Este método debe desbloquear botones y permitir que el jugador realice su acción.
     * 
     * @param personaje El personaje cuyo turno es actual.
     */
    @Override
    public void turnoJugador(Personaje personaje) {
        // TODO: Desbloquear botones y permitir acciones del jugador.
    }
    
    /**
     * Gestiona el turno del enemigo.
     * Este método debe bloquear las acciones del jugador y permitir que el enemigo realice su acción.
     */
    @Override
    public void turnoEnemigo() {
        // TODO: Bloquear botones y permitir acciones del enemigo.
    }
}
