package dad.mundoria.model;

import java.util.List;

public class Habilidad {

	public enum TipoHabilidad {
		FISICO_CORTANTE("Daño físico cortante, genera cortes en el objetivo"),
		FISICO_CONTUNDENTE("Daño físico contundente, genera golpes en el objetivo"),
		FISICO_PERFORANTE("Daño físico perforante, genera perforaciones en el enemigo"),
		MAGICO_FUEGO("Daño mágico tipo fuego, quema al objetivo"),
		MAGICO_ARCANO("Daño mágico tipo arcano, daña al objetivo con energía mágica pura"),
		MAGICO_HIELO("Daño mágico tipo hielo, congela al objetivo"),
		MAGICO_SOMBRA("Daño mágico tipo sombra, usa el poder sombrío para dañar al enemigo"),
		MAGICO_CELESTIAL("Daño mágico tipo celestial, usa el poder celestial para dañar al enemigo");

		private final String descripcion;

		TipoHabilidad(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getDescripcion() {
			return descripcion;
		}
	}

	private int idHabilidad;
	private String nombre;
	private String resumen;
	private TipoHabilidad tipo;
	private int costeStamana;
	private int nivelRequerido;
	private List<Efecto> efectos;

	public Habilidad(int idHabilidad, String nombre, String resumen, TipoHabilidad tipo, int costeStamana,
			int nivelRequerido, List<Efecto> efectos) {
		super();
		this.idHabilidad = idHabilidad;
		this.nombre = nombre;
		this.resumen = resumen;
		this.tipo = tipo;
		this.costeStamana = costeStamana;
		this.nivelRequerido = nivelRequerido;
		this.efectos = efectos;
	}

	public void usarHabilidad(Entidad actor, Entidad objetivo, int tiradaDado) {

		// Comienza el uso del dado de daño (6 caras)
		// Habrán 3 tiradas por así decirlo. 1 y 2 serán tirada baja, 3 y 4 tirada
		// neutra y por último; 5 y 6 tirada alta.
		// Cada tirada afecta al daño. Tirada baja quita 20 puntos de daño, tirada
		// neutra no quita ni suma, tirada alta añade 20 puntos de daño.
		int modificador = 0;

		if (tiradaDado == 1 || tiradaDado == 2) {
			modificador = -20;
		} else if (tiradaDado == 3 || tiradaDado == 4) {
			modificador = 0;
		} else if (tiradaDado == 5 || tiradaDado == 6) {
			modificador = 20;
		} else {
			System.err.println("ERROR: Dado inválido, dado de solamente 6 caras.");
		}

		// Aquí se suma a la tirada el ataque del actor
		modificador += actor.getAtaque();

		if (actor.getStamana() >= costeStamana) {
			actor.modificarEstadistica("stamana", -costeStamana);

			for (Efecto efecto : efectos) {
				efecto.aplicarEfecto(objetivo, modificador);
			}

		} else {
			return;
		}

	}

	public boolean estaBloqueado(int nivelRequerido, Personaje personaje) {

		if (nivelRequerido > personaje.getNivel()) {
			return true;
		} else {
			return false;
		}

	}

	public int getIdHabilidad() {
		return idHabilidad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getResumen() {
		return resumen;
	}

	public TipoHabilidad getTipo() {
		return tipo;
	}

	public int getCosteStamana() {
		return costeStamana;
	}

	public int getNivelRequerido() {
		return nivelRequerido;
	}

	public List<Efecto> getEfectos() {
		return efectos;
	}

}