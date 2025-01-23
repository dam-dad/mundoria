package dad.mundoria.model;

import java.util.Map;

public class Personaje {

	private String nombre;
	private String trasfondo;
	private int salud;
	private int stamana;
	private int agilidad;
	private int suerte;
	private int defensa;
	private int ataque;
	private int nivel;
	private double xp;
	private Clase clase;
	private Raza raza;
	private Inventario inventario;
	private Map<Efecto, Integer> efectosTemporales;
	
	public Personaje(
			String nombre, String trasfondo, int salud, int stamana, int agilidad,
			int suerte, int defensa, int ataque, Clase clase, Raza raza, Inventario inventario
			) {
		super();
		this.nombre = nombre;
		this.trasfondo = trasfondo;
		this.salud = salud;
		this.stamana = stamana;
		this.agilidad = agilidad;
		this.suerte = suerte;
		this.defensa = defensa;
		this.ataque = ataque;
		this.clase = clase;
		this.raza = raza;
		this.inventario = inventario;
	}
	
	public int atacar(Personaje objetivo, Habilidad habilidadUsada) {
		
	}
	
	public boolean evadir() {
		
	}
	
	public void subirNivel() {
		
	}
	
	public void modificarEstadistica(String estadistica, int valor) {
		
		switch(estadistica) {
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
	
	public void inicializarEstadisticas() {
		
		int saludExtraTotal = 0;
		int stamanaExtraTotal = 0;
		int agilidadExtraTotal = 0;
		int suerteExtraTotal = 0;
		int defensaExtraTotal = 0;
		int ataqueExtraTotal = 0;
		
		for(Item item : inventario.getItemsEquipados()) {
			saludExtraTotal += item.getSaludExtra();
			stamanaExtraTotal += item.getStamanaExtra();
			agilidadExtraTotal += item.getAgilidadExtra();
			suerteExtraTotal += item.getSuerteExtra();
			defensaExtraTotal += item.getDefensaExtra();
			ataqueExtraTotal += item.getAtaqueExtra();
		}
		
		salud = raza.getSaludBase() + saludExtraTotal;
		stamana = raza.getStamanaBase() + stamanaExtraTotal;
		agilidad = raza.getAgilidadBase() + agilidadExtraTotal;
		suerte = raza.getSuerteBase() + suerteExtraTotal;
		defensa = raza.getDefensaBase() + defensaExtraTotal;
		ataque = raza.getAtaqueBase() + ataqueExtraTotal;
	}
	
	public void agregarEfectoTemporal(Efecto efecto, int turnos) {
		
	}
	
	public void actualizarEfectos() {
		
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public double getXp() {
		return xp;
	}

	public void setXp(double xp) {
		this.xp = xp;
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

	public Inventario getInventario() {
		return inventario;
	}

	public Map<Efecto, Integer> getEfectosTemporales() {
		return efectosTemporales;
	}
	
	
	
}
