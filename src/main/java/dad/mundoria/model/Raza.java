package dad.mundoria.model;

import dad.mundoria.model.Habilidad.TipoHabilidad;

/**
 * Representa una raza dentro del juego.
 * Cada raza tiene atributos base que afectan a las estadísticas de los personajes que la elijan,
 * así como debilidades específicas frente a tipos de habilidades mágicas o físicas.
 */
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

    /**
     * Constructor de la clase {@link Raza}.
     * 
     * @param idRaza El identificador único de la raza.
     * @param nombre El nombre de la raza.
     * @param resumen Un resumen descriptivo de la raza.
     * @param saludBase El valor base de salud que los personajes de esta raza poseen.
     * @param stamanaBase El valor base de stamina que los personajes de esta raza poseen.
     * @param agilidadBase El valor base de agilidad que los personajes de esta raza poseen.
     * @param suerteBase El valor base de suerte que los personajes de esta raza poseen.
     * @param defensaBase El valor base de defensa que los personajes de esta raza poseen.
     * @param ataqueBase El valor base de ataque que los personajes de esta raza poseen.
     * @param debilidadMagica El tipo de habilidad mágica contra la que la raza tiene debilidad.
     * @param debilidadFisica El tipo de habilidad física contra la que la raza tiene debilidad.
     */
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

    /**
     * Obtiene el identificador único de la raza.
     * 
     * @return El identificador de la raza.
     */
    public int getIdRaza() {
        return idRaza;
    }

    /**
     * Obtiene el nombre de la raza.
     * 
     * @return El nombre de la raza.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene un resumen descriptivo de la raza.
     * 
     * @return El resumen de la raza.
     */
    public String getResumen() {
        return resumen;
    }

    /**
     * Obtiene el valor base de salud de la raza.
     * 
     * @return El valor base de salud.
     */
    public int getSaludBase() {
        return saludBase;
    }

    /**
     * Obtiene el valor base de stamina de la raza.
     * 
     * @return El valor base de stamina.
     */
    public int getStamanaBase() {
        return stamanaBase;
    }

    /**
     * Obtiene el valor base de agilidad de la raza.
     * 
     * @return El valor base de agilidad.
     */
    public int getAgilidadBase() {
        return agilidadBase;
    }

    /**
     * Obtiene el valor base de suerte de la raza.
     * 
     * @return El valor base de suerte.
     */
    public int getSuerteBase() {
        return suerteBase;
    }

    /**
     * Obtiene el valor base de defensa de la raza.
     * 
     * @return El valor base de defensa.
     */
    public int getDefensaBase() {
        return defensaBase;
    }

    /**
     * Obtiene el valor base de ataque de la raza.
     * 
     * @return El valor base de ataque.
     */
    public int getAtaqueBase() {
        return ataqueBase;
    }

    /**
     * Obtiene el tipo de habilidad mágica contra la que la raza tiene debilidad.
     * 
     * @return El tipo de habilidad mágica que la raza no puede resistir bien.
     */
    public TipoHabilidad getDebilidadMagica() {
        return debilidadMagica;
    }

    /**
     * Obtiene el tipo de habilidad física contra la que la raza tiene debilidad.
     * 
     * @return El tipo de habilidad física que la raza no puede resistir bien.
     */
    public TipoHabilidad getDebilidadFisica() {
        return debilidadFisica;
    }

}
