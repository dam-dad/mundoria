package dad.mundoria.model;

import java.util.List;

public class ControlDeTurnos {

	private List<Entidad> entidadesEnTurno;
	private int turnoActual;

	public ControlDeTurnos(List<Entidad> entidadesEnTurno) {

		this.entidadesEnTurno = entidadesEnTurno;
		this.turnoActual = 0;

	}

	public Entidad iniciarTurnos() {

		turnoActual = 0;
		return entidadesEnTurno.get(turnoActual);

	}

	public Entidad avanzarTurno() {

		turnoActual = (turnoActual + 1) % entidadesEnTurno.size();
		return entidadesEnTurno.get(turnoActual);

	}

	public Entidad obtenerEntidadActual() {

		return entidadesEnTurno.get(turnoActual);

	}

	public int getTurnoActual() {
		return turnoActual;
	}

	public List<Entidad> getEntidadesEnTurno() {
		return entidadesEnTurno;
	}

}
