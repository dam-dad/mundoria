package dad.mundoria.model;

import java.util.List;

public class Clase {

	private int idClase;
	private String nombre;
	private String resumen;
	private String lema;
	private List<Habilidad> habilidades;

	public Clase(int idClase, String nombre, String resumen, String lema, List<Habilidad> habilidades) {
		super();
		this.idClase = idClase;
		this.nombre = nombre;
		this.resumen = resumen;
		this.lema = lema;
		this.habilidades = habilidades;
	}

	public int getIdClase() {
		return idClase;
	}

	public String getNombre() {
		return nombre;
	}

	public String getResumen() {
		return resumen;
	}

	public String getLema() {
		return lema;
	}

	public List<Habilidad> getHabilidades() {
		return habilidades;
	}

}
