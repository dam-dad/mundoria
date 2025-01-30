package dad.mundoria.model;

import java.util.List;

public class SistemaDeCombate {

	private Dado dado6;
	private Dado dado20;
	private List<Enemigo> enemigos;
	private List<Personaje> personajes;
	
	public SistemaDeCombate(List<Enemigo> enemigos, List<Personaje> personajes) {
		super();
		this.dado6 = new Dado(6);
		this.dado20 = new Dado(20);
		this.enemigos = enemigos;
		this.personajes = personajes;
	}
	
	public void iniciarCombate(List<Personaje> personajes, List<Enemigo> enemigos) {
		
		for(Personaje personaje : personajes) {
			personaje.inicializarEstadisticas();
		}
		
		for(Enemigo enemigo : enemigos) {
			enemigo.inicializarEstadisticas();
		}
		
	}
	
	public boolean resolverCombate(List<Personaje> personajes, List<Enemigo> enemigos) {
		
		boolean enemigoGanador;
		boolean jugadorGanador;
		
		enemigoGanador = equipoDerrotado(personajes);
		jugadorGanador = equipoEnemigoDerrotado(enemigos);
		
		if(enemigoGanador == true) {
			return true;
		} else if(jugadorGanador == true) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean equipoDerrotado(List<Personaje> personajes) {
		for(Personaje personaje : personajes) {
			if(personaje.getSalud() > 0) {
				return false;
			}
		}
		return true;
	}
	
	public boolean equipoEnemigoDerrotado(List<Enemigo> enemigos) {
		for(Enemigo enemigo : enemigos) {
			if(enemigo.getSalud() > 0) {
				return false;
			}
		}
		return true;
	}
	
	public void realizarAccion(Personaje atacante, Personaje atacado, Habilidad habilidadElegida) {
		
		int tiradaAtacante = 0;
		int tiradaAtacado = 0;
		int tiradaDaño = 0;
		
		while(tiradaAtacante == tiradaAtacado) {
			tiradaAtacante = dado20.lanzar();
			tiradaAtacado = dado20.lanzar();
		}
		
		if(tiradaAtacante > tiradaAtacado) {
			tiradaDaño = dado6.lanzar();
			habilidadElegida.usarHabilidad(atacante, atacado, tiradaDaño);
			
		} else {
			atacante.modificarEstadistica("stamana", -habilidadElegida.getCosteStamana());
			atacado.evadir();
		}
		
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
	
}
