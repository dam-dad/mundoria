package dad.mundoria.model;

import java.util.Map;

public class Personaje extends Entidad {

	private int nivel;
	private double xp;
	private Inventario inventario;
	private Map<Efecto, Integer> efectosTemporales;

	public Personaje(String nombre, String trasfondo, Clase clase, Raza raza) {
		super(nombre, trasfondo, clase, raza);
		this.inventario = new Inventario(null, 10, 100);
		this.nivel = 1;
		this.xp = 0;
	}

	@Override
	public void evadir() {

	}

	public void subirNivel() {
		setNivel(nivel++);
	}

	@Override
	public void inicializarEstadisticas() {

		int saludExtraTotal = 0;
		int stamanaExtraTotal = 0;
		int agilidadExtraTotal = 0;
		int suerteExtraTotal = 0;
		int defensaExtraTotal = 0;
		int ataqueExtraTotal = 0;

		for (Item item : inventario.getItemsEquipados()) {
			saludExtraTotal += item.getSaludExtra();
			stamanaExtraTotal += item.getStamanaExtra();
			agilidadExtraTotal += item.getAgilidadExtra();
			suerteExtraTotal += item.getSuerteExtra();
			defensaExtraTotal += item.getDefensaExtra();
			ataqueExtraTotal += item.getAtaqueExtra();
		}

		this.salud = this.raza.getSaludBase() + saludExtraTotal;
		this.stamana = this.raza.getStamanaBase() + stamanaExtraTotal;
		this.agilidad = this.raza.getAgilidadBase() + agilidadExtraTotal;
		this.suerte = this.raza.getSuerteBase() + suerteExtraTotal;
		this.defensa = this.raza.getDefensaBase() + defensaExtraTotal;
		this.ataque = this.raza.getAtaqueBase() + ataqueExtraTotal;
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

	public Inventario getInventario() {
		return inventario;
	}

	public Map<Efecto, Integer> getEfectosTemporales() {
		return efectosTemporales;
	}

}
