package dad.mundoria.model;

import java.util.ArrayList;
import java.util.List;

public class SistemaDeCombate {

	private TurnoListener listener;

	private Dado dado6;
	private Dado dado20;
	private List<Enemigo> enemigos;
	private List<Personaje> personajes;
	private ControlDeTurnos controlTurnos;
	private List<Entidad> entidades;

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

	public void iniciarCombate() {

		for (Personaje personaje : personajes) {
			personaje.inicializarEstadisticas();
		}

		for (Enemigo enemigo : enemigos) {
			enemigo.inicializarEstadisticas();
		}

		controlTurnos.iniciarTurnos();
		procesarCombate();

	}

	public void procesarCombate() {
		if (resolverCombate()) {
			System.out.println("COMBATE FINALIZADO.");
			return;
		}

		Entidad entidad = controlTurnos.obtenerEntidadActual();

		if (entidad instanceof Enemigo) {
			Enemigo enemigo = (Enemigo) entidad;
			Entidad objetivo = enemigo.elegirObjetivo(entidades); // Es estrictamente necesario llamar a elegirObjetivo
																	// antes de llamar a elegirHabilidad
			System.out.println("El objetivo del enemigo es: " + objetivo.getNombre());
			Habilidad habilidad = enemigo.elegirHabilidad();
			System.out.println("La habilidad del enemigo es: " + habilidad.getNombre());
			realizarAccion(enemigo, objetivo, habilidad);
			listener.turnoEnemigo();
		} else if (entidad instanceof Personaje) {
			// Pausar el combate y esperar a la entrada del jugador.
			listener.turnoJugador((Personaje) entidad);
		}
	}

	public boolean resolverCombate() {

		boolean enemigoGanador;
		boolean jugadorGanador;

		enemigoGanador = equipoDerrotado(personajes);
		jugadorGanador = equipoEnemigoDerrotado(enemigos);

		if (enemigoGanador == true) {
			return true;
		} else if (jugadorGanador == true) {
			return true;
		} else {
			return false;
		}

	}

	public boolean equipoDerrotado(List<Personaje> personajes) {
		for (Personaje personaje : personajes) {
			if (personaje.getSalud() > 0) {
				return false;
			}
		}
		return true;
	}

	public boolean equipoEnemigoDerrotado(List<Enemigo> enemigos) {
		for (Enemigo enemigo : enemigos) {
			if (enemigo.getSalud() > 0) {
				return false;
			}
		}
		return true;
	}

	public void realizarAccion(Entidad atacante, Entidad atacado, Habilidad habilidadElegida) {

		int tiradaAtacante = 0;
		int tiradaAtacado = 0;
		int tiradaDaño = 0;

		while (tiradaAtacante == tiradaAtacado) {
			tiradaAtacante = dado20.lanzar();
			tiradaAtacado = dado20.lanzar();
		}

		if (tiradaAtacante > tiradaAtacado) {
			tiradaDaño = dado6.lanzar();
			System.out.println("Se va a usar habilidad " + habilidadElegida.getNombre() + " de " + atacante.getNombre() + " contra " + atacado.getNombre());
			habilidadElegida.usarHabilidad(atacante, atacado, tiradaDaño);

		} else {
			atacante.modificarEstadistica("stamana", -habilidadElegida.getCosteStamana());
			atacado.evadir();
		}
		
		controlTurnos.avanzarTurno();

	}

	public Dado getDado6() {
		return dado6;
	}

	public Dado getDado20() {
		return dado20;
	}

	public List<Enemigo> getEnemigos() {
		return enemigos;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public List<Entidad> getEntidades() {
		return entidades;
	}

	public void setListener(TurnoListener listener) {
		this.listener = listener;
	}

}
