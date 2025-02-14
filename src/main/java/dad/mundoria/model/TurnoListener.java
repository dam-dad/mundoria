package dad.mundoria.model;

/**
 * Interfaz que define los métodos necesarios para manejar los turnos
 * de los jugadores y los enemigos durante el combate.
 * Las clases que implementen esta interfaz serán responsables de
 * gestionar los eventos de los turnos, notificando cuando le corresponde
 * al jugador o al enemigo realizar una acción.
 */
public interface TurnoListener {

    /**
     * Método llamado cuando es el turno de un jugador para realizar una acción.
     * 
     * @param personaje El personaje cuyo turno está en curso.
     */
    void turnoJugador(Personaje personaje);

    /**
     * Método llamado cuando es el turno de un enemigo para realizar una acción.
     */
    void turnoEnemigo();
}
