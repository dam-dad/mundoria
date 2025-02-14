package dad.mundoria.model;

import java.util.List;

/**
 * Representa una clase dentro del juego, que incluye su nombre, resumen, lema
 * y una lista de habilidades asociadas a esa clase.
 */
public class Clase {

    private int idClase;
    private String nombre;
    private String resumen;
    private String lema;
    private List<Habilidad> habilidades;

    /**
     * Constructor que inicializa una nueva instancia de la clase con los parámetros especificados.
     * 
     * @param idClase El identificador único de la clase.
     * @param nombre El nombre de la clase.
     * @param resumen Una breve descripción o resumen de la clase.
     * @param lema El lema o frase representativa de la clase.
     * @param habilidades La lista de habilidades asociadas a la clase.
     */
    public Clase(int idClase, String nombre, String resumen, String lema, List<Habilidad> habilidades) {
        super();
        this.idClase = idClase;
        this.nombre = nombre;
        this.resumen = resumen;
        this.lema = lema;
        this.habilidades = habilidades;
    }

    /**
     * Obtiene el identificador único de la clase.
     * 
     * @return El id de la clase.
     */
    public int getIdClase() {
        return idClase;
    }

    /**
     * Obtiene el nombre de la clase.
     * 
     * @return El nombre de la clase.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el resumen de la clase.
     * 
     * @return El resumen de la clase.
     */
    public String getResumen() {
        return resumen;
    }

    /**
     * Obtiene el lema o frase representativa de la clase.
     * 
     * @return El lema de la clase.
     */
    public String getLema() {
        return lema;
    }

    /**
     * Obtiene la lista de habilidades asociadas a la clase.
     * 
     * @return La lista de habilidades de la clase.
     */
    public List<Habilidad> getHabilidades() {
        return habilidades;
    }
}
