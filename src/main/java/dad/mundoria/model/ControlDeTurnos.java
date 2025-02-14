package dad.mundoria.model;

import java.util.List;

/**
 * Controla el flujo de los turnos de las entidades en un combate o escenario. 
 * Esta clase gestiona el turno actual y permite avanzar de un turno a otro, 
 * obteniendo la entidad que está en turno en cada momento.
 */
public class ControlDeTurnos {

    private List<Entidad> entidadesEnTurno;
    private int turnoActual;

    /**
     * Constructor que inicializa el control de turnos con las entidades proporcionadas.
     * 
     * @param entidadesEnTurno La lista de entidades que participan en los turnos.
     */
    public ControlDeTurnos(List<Entidad> entidadesEnTurno) {
        this.entidadesEnTurno = entidadesEnTurno;
        this.turnoActual = 0;
    }

    /**
     * Inicia el ciclo de turnos, estableciendo el primer turno a 0 y devolviendo 
     * la primera entidad en turno.
     * 
     * @return La entidad que comienza el primer turno.
     */
    public Entidad iniciarTurnos() {
        turnoActual = 0;
        return entidadesEnTurno.get(turnoActual);
    }

    /**
     * Avanza al siguiente turno, haciendo un ciclo a través de la lista de entidades 
     * y devolviendo la entidad correspondiente al nuevo turno.
     * 
     * @return La entidad cuyo turno es el siguiente en la lista.
     */
    public Entidad avanzarTurno() {
        turnoActual = (turnoActual + 1) % entidadesEnTurno.size();
        return entidadesEnTurno.get(turnoActual);
    }

    /**
     * Obtiene la entidad que está actualmente en turno.
     * 
     * @return La entidad que está en el turno actual.
     */
    public Entidad obtenerEntidadActual() {
        return entidadesEnTurno.get(turnoActual);
    }

    /**
     * Obtiene el número del turno actual.
     * 
     * @return El número del turno actual.
     */
    public int getTurnoActual() {
        return turnoActual;
    }

    /**
     * Obtiene la lista de entidades que participan en los turnos.
     * 
     * @return La lista de entidades en turno.
     */
    public List<Entidad> getEntidadesEnTurno() {
        return entidadesEnTurno;
    }
}
