package dad.mundoria.model;

public abstract class Entidad {

	protected String nombre;
	protected String trasfondo;
	protected int salud;
	protected int stamana;
	protected int agilidad;
	protected int suerte;
	protected int defensa;
	protected int ataque;
	protected Clase clase;
	protected Raza raza;

	public Entidad(String nombre, String trasfondo, Clase clase, Raza raza) {

		this.nombre = nombre;
		this.trasfondo = trasfondo;
		this.salud = 100;
		this.stamana = 100;
		this.agilidad = 50;
		this.suerte = 0;
		this.defensa = 0;
		this.ataque = 0;
		this.clase = clase;
		this.raza = raza;

	}

	public abstract void inicializarEstadisticas();

	public abstract void evadir();

	public void modificarEstadistica(String estadistica, int valor) {

		switch (estadistica) {
		case "salud":
			salud += valor;
			break;
		case "stamana":
			stamana += valor;
			break;
		case "agilidad":
			agilidad += valor;
			break;
		case "suerte":
			suerte += valor;
			break;
		case "defensa":
			defensa += valor;
			break;
		case "ataque":
			ataque += valor;
			break;
		default:
			System.err.println("ERROR: Valor en campo estadística inválido.");
			break;
		}

	}

	public void actualizarEfectos() {

	}

	public String getNombre() {
		return nombre;
	}

	public String getTrasfondo() {
		return trasfondo;
	}

	public int getSalud() {
		return salud;
	}

	public int getStamana() {
		return stamana;
	}

	public int getSuerte() {
		return suerte;
	}

	public int getAgilidad() {
		return agilidad;
	}

	public int getDefensa() {
		return defensa;
	}

	public int getAtaque() {
		return ataque;
	}

	public Clase getClase() {
		return clase;
	}

	public Raza getRaza() {
		return raza;
	}

}
