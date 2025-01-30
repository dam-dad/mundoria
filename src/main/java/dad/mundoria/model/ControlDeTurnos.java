package dad.mundoria.model;

import java.util.ArrayList;
import java.util.List;

public class ControlDeTurnos {

	private List<Object> entidadesEnTurno;
	private int turnoActual;
	
	public ControlDeTurnos(List<Personaje> personajesEnTurno, List<Enemigo> enemigosEnTurno) {
		
		this.entidadesEnTurno = new ArrayList<>();
		this.entidadesEnTurno.addAll(personajesEnTurno);
		this.entidadesEnTurno.addAll(enemigosEnTurno);
		this.turnoActual = 0;
		
	}
	
	public Object iniciarTurnos() {
		
		turnoActual = 0;
		return entidadesEnTurno.get(turnoActual);
		
	}
	
	public Object avanzarTurno() {
		
		turnoActual = (turnoActual + 1) % entidadesEnTurno.size();
		return entidadesEnTurno.get(turnoActual);
		
	}
	
	public Object obtenerEntidadActual() {
		
		return entidadesEnTurno.get(turnoActual);
		
	}
	
	public int getTurnoActual() {
		return turnoActual;
	}
	
	public List<Object> getEntidadesEnTurno() {
		return entidadesEnTurno;
	}
	
}
