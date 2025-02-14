package dad.mundoria.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona el sistema de combate entre personajes y enemigos.
 * Se encarga de controlar los turnos, las acciones de los combatientes y la resolución del combate.
 */
public class SistemaDeCombate {

    private TurnoListener listener;
    private Dado dado6;
    private Dado dado20;
    private List<Enemigo> enemigos;
    private List<Personaje> personajes;
    private ControlDeTurnos controlTurnos;
    private List<Entidad> entidades;

    /**
     * Constructor de la clase {@link SistemaDeCombate}.
     * 
     * @param enemigos Lista de enemigos que participan en el combate.
     * @param personajes Lista de personajes que participan en el combate.
     */
    public SistemaDeCombate(List<Enemigo> enemigos, List<Personaje> personajes) {
        this.dado6 = new Dado(6);
        this.dado20 = new Dado(20);
        this.enemigos = enemigos;
        this.personajes = personajes;
        List<Entidad> entidades = new ArrayList<>();
        entidades.addAll(personajes);
        entidades.addAll(enemigos);
        this.entidades = entidades;
        this.controlTurnos = new ControlDeTurnos(entidades);
    }

    /**
     * Inicia el combate, inicializando las estadísticas de personajes y enemigos,
     * y comenzando la secuencia de turnos.
     */
    public void iniciarCombate() {

        // Inicializa las estadísticas de los personajes y enemigos.
        for (Personaje personaje : personajes) {
            personaje.inicializarEstadisticas();
        }

        for (Enemigo enemigo : enemigos) {
            enemigo.inicializarEstadisticas();
        }

        // Inicia los turnos.
        controlTurnos.iniciarTurnos();
        procesarCombate();
    }

    /**
     * Procesa el combate, gestionando los turnos de cada entidad (personaje o enemigo).
     * Llama a la función correspondiente para realizar las acciones durante su turno.
     */
    public void procesarCombate() {
        if (resolverCombate()) {
            System.out.println("COMBATE FINALIZADO.");
            return;
        }

        // Obtiene la entidad cuyo turno es el actual.
        Entidad entidad = controlTurnos.obtenerEntidadActual();

        // Si es un enemigo, se elige un objetivo y una habilidad para atacar.
        if (entidad instanceof Enemigo) {
            Enemigo enemigo = (Enemigo) entidad;
            Entidad objetivo = enemigo.elegirObjetivo(entidades); // Necesario llamar a elegirObjetivo antes de elegirHabilidad
            System.out.println("El objetivo del enemigo es: " + objetivo.getNombre());
            Habilidad habilidad = enemigo.elegirHabilidad();
            System.out.println("La habilidad del enemigo es: " + habilidad.getNombre());
            realizarAccion(enemigo, objetivo, habilidad);
            listener.turnoEnemigo();
        } else if (entidad instanceof Personaje) {
            // Si es un personaje, se pausa el combate y espera la entrada del jugador.
            listener.turnoJugador((Personaje) entidad);
        }
    }

    /**
     * Resuelve el combate verificando si algún equipo ha sido derrotado.
     * 
     * @return {@code true} si el combate ha terminado, {@code false} si no.
     */
    public boolean resolverCombate() {

        boolean enemigoGanador;
        boolean jugadorGanador;

        enemigoGanador = equipoDerrotado(personajes);
        jugadorGanador = equipoEnemigoDerrotado(enemigos);

        // Retorna {@code true} si alguno de los equipos ha sido derrotado.
        if (enemigoGanador == true) {
            return true;
        } else if (jugadorGanador == true) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Verifica si el equipo de personajes ha sido derrotado, es decir, si todos sus miembros
     * han perdido toda su salud.
     * 
     * @param personajes Lista de personajes a verificar.
     * @return {@code true} si todos los personajes están derrotados, {@code false} si al menos uno sigue en pie.
     */
    public boolean equipoDerrotado(List<Personaje> personajes) {
        for (Personaje personaje : personajes) {
            if (personaje.getSalud() > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica si el equipo de enemigos ha sido derrotado, es decir, si todos sus miembros
     * han perdido toda su salud.
     * 
     * @param enemigos Lista de enemigos a verificar.
     * @return {@code true} si todos los enemigos están derrotados, {@code false} si al menos uno sigue en pie.
     */
    public boolean equipoEnemigoDerrotado(List<Enemigo> enemigos) {
        for (Enemigo enemigo : enemigos) {
            if (enemigo.getSalud() > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Realiza una acción de combate, donde el atacante realiza una tirada y se determina
     * si el ataque tiene éxito. Si tiene éxito, se lanza una tirada de daño y se usa la habilidad
     * correspondiente, de lo contrario, el atacante pierde stamina y el objetivo evade el ataque.
     * 
     * @param atacante La entidad que ataca.
     * @param atacado La entidad que recibe el ataque.
     * @param habilidadElegida La habilidad que se usa para atacar.
     */
    public void realizarAccion(Entidad atacante, Entidad atacado, Habilidad habilidadElegida) {

        int tiradaAtacante = 0;
        int tiradaAtacado = 0;
        int tiradaDaño = 0;

        // Se repite la tirada hasta que los valores sean diferentes.
        while (tiradaAtacante == tiradaAtacado) {
            tiradaAtacante = dado20.lanzar();
            tiradaAtacado = dado20.lanzar();
        }

        // Si la tirada del atacante es mayor, el ataque tiene éxito.
        if (tiradaAtacante > tiradaAtacado) {
            tiradaDaño = dado6.lanzar();
            System.out.println("Se va a usar habilidad " + habilidadElegida.getNombre() + " de " + atacante.getNombre() + " contra " + atacado.getNombre());
            habilidadElegida.usarHabilidad(atacante, atacado, tiradaDaño);
        } else {
            // Si el ataque falla, el atacante pierde stamina y el objetivo evade.
            atacante.modificarEstadistica("stamana", -habilidadElegida.getCosteStamana());
            atacado.evadir();
        }

        // Avanza al siguiente turno.
        controlTurnos.avanzarTurno();
    }

    /**
     * Obtiene el dado de 6 caras utilizado en el combate.
     * 
     * @return El dado de 6 caras.
     */
    public Dado getDado6() {
        return dado6;
    }

    /**
     * Obtiene el dado de 20 caras utilizado en el combate.
     * 
     * @return El dado de 20 caras.
     */
    public Dado getDado20() {
        return dado20;
    }

    /**
     * Obtiene la lista de enemigos que participan en el combate.
     * 
     * @return La lista de enemigos.
     */
    public List<Enemigo> getEnemigos() {
        return enemigos;
    }

    /**
     * Obtiene la lista de personajes que participan en el combate.
     * 
     * @return La lista de personajes.
     */
    public List<Personaje> getPersonajes() {
        return personajes;
    }

    /**
     * Obtiene la lista de todas las entidades (personajes y enemigos) que participan en el combate.
     * 
     * @return La lista de entidades.
     */
    public List<Entidad> getEntidades() {
        return entidades;
    }

    /**
     * Establece el listener que escucha los turnos del combate.
     * 
     * @param listener El listener que gestiona los turnos.
     */
    public void setListener(TurnoListener listener) {
        this.listener = listener;
    }
}
