package dad.mundoria.model;

public class Efecto {

	public enum TipoEfecto {
		
		CURACION("Este efecto aumentará la salud del objetivo"),
		DAÑO("Este efecto disminuirá la salud del objtivo"),
		STUN("Este efecto hará que el objetivo pierda un número de turnos"),
		PROTECCION("Este efecto evitará el daño al objetivo un número de turnos");
		
		private String descripcion;
		
		TipoEfecto(String descripcion) {
			this.descripcion = descripcion;
		}
		
		public String getDescripcion() {
			return descripcion;
		}
		
	}
	
	private int idEfecto;
	private String nombre;
	private String descripcion;
	private TipoEfecto tipo;
	private int valor;
	private int duracion;
	
	public Efecto(int idEfecto, String nombre, String descripcion, TipoEfecto tipo, int valor, int duracion) {
		super();
		this.idEfecto = idEfecto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.valor = valor;
		this.duracion = duracion;
	}

	public void aplicarEfecto(Personaje objetivo, int modificadorPuntos) { //TODO Actualmente esto cambia las estadísticas de manera permanente, hay que cambiarlo.
		
		switch(tipo) {
		// Curación se calcula en base al valor propio de la habilidad más el modificador de puntos entre tirada de dados y Ataque del atacante
		case CURACION:
			objetivo.modificarEstadistica("salud", valor + modificadorPuntos);
			break;
		// Daño se calcula en base al valor propio de la habilidad más el modificador de puntos entre tirada de dados y Ataque del atacante menos la defensa del objetivo
		case DAÑO:
			objetivo.modificarEstadistica("salud", -valor + modificadorPuntos - objetivo.getDefensa());
			break;
		case STUN:
			objetivo.actualizarEfectos(); //TODO Pendiente sistema de turnos para los efectos temporales.
			break;
		case PROTECCION:
			objetivo.actualizarEfectos(); //TODO Pendiente sistema de turnos para los efectos temporales.
		}
	}

	public int getIdEfecto() {
		return idEfecto;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public TipoEfecto getTipo() {
		return tipo;
	}
	
	public int getValor() {
		return valor;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	
	
	
}
