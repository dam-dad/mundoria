package dad.mundoria.model;

import dad.mundoria.model.Habilidad.TipoHabilidad;

public class Raza {

	private int idRaza;
	private String nombre;
	private String resumen;
	private int saludBase;
	private int stamanaBase;
	private int agilidadBase;
	private int suerteBase;
	private int defensaBase;
	private int ataqueBase;
	private TipoHabilidad debilidadMagica;
	private TipoHabilidad debilidadFisica;

	public Raza(int idRaza, String nombre, String resumen, int saludBase, int stamanaBase, int agilidadBase,
			int suerteBase, int defensaBase, int ataqueBase, TipoHabilidad debilidadMagica,
			TipoHabilidad debilidadFisica) {
		super();
		this.idRaza = idRaza;
		this.nombre = nombre;
		this.resumen = resumen;
		this.saludBase = saludBase;
		this.stamanaBase = stamanaBase;
		this.agilidadBase = agilidadBase;
		this.suerteBase = suerteBase;
		this.defensaBase = defensaBase;
		this.ataqueBase = ataqueBase;
		this.debilidadMagica = debilidadMagica;
		this.debilidadFisica = debilidadFisica;
	}

	public int getIdRaza() {
		return idRaza;
	}

	public String getNombre() {
		return nombre;
	}

	public String getResumen() {
		return resumen;
	}

	public int getSaludBase() {
		return saludBase;
	}
	
	public int getStamanaBase() {
		return stamanaBase;
	}

	public int getAgilidadBase() {
		return agilidadBase;
	}

	public int getSuerteBase() {
		return suerteBase;
	}

	public int getDefensaBase() {
		return defensaBase;
	}

	public int getAtaqueBase() {
		return ataqueBase;
	}

	public TipoHabilidad getDebilidadMagica() {
		return debilidadMagica;
	}

	public TipoHabilidad getDebilidadFisica() {
		return debilidadFisica;
	}
	
}
