package dad.mundoria.model;

import java.util.Map;

/**
 * Representa un personaje dentro del juego. 
 * Un personaje tiene atributos como nivel, experiencia, inventario, 
 * y una lista de efectos temporales que pueden modificar sus estadísticas.
 */
public class Personaje extends Entidad {

    private int nivel;
    private double xp;
    private Inventario inventario;
    private Map<Efecto, Integer> efectosTemporales;

    /**
     * Constructor de la clase {@link Personaje}.
     * 
     * @param nombre El nombre del personaje.
     * @param trasfondo El trasfondo o historia del personaje.
     * @param clase La clase del personaje (guerrero, mago, etc.).
     * @param raza La raza del personaje (humano, elfo, orco, etc.).
     */
    public Personaje(String nombre, String trasfondo, Clase clase, Raza raza) {
        super(nombre, trasfondo, clase, raza);
        this.inventario = new Inventario(null, 10, 100);
        this.nivel = 1;
        this.xp = 0;
    }

    /**
     * Método para evadir un ataque o acción.
     * Actualmente no implementado.
     */
    @Override
    public void evadir() {

    }

    /**
     * Incrementa el nivel del personaje en 1.
     */
    public void subirNivel() {
        setNivel(nivel++);
    }

    /**
     * Inicializa o actualiza las estadísticas del personaje en base a su raza 
     * y los items equipados en su inventario.
     * Calcula las estadísticas finales sumando los atributos extra de los items.
     */
    @Override
    public void inicializarEstadisticas() {

        int saludExtraTotal = 0;
        int stamanaExtraTotal = 0;
        int agilidadExtraTotal = 0;
        int suerteExtraTotal = 0;
        int defensaExtraTotal = 0;
        int ataqueExtraTotal = 0;

        // Sumar los atributos extra proporcionados por los items equipados
        for (Item item : inventario.getItemsEquipados()) {
            saludExtraTotal += item.getSaludExtra();
            stamanaExtraTotal += item.getStamanaExtra();
            agilidadExtraTotal += item.getAgilidadExtra();
            suerteExtraTotal += item.getSuerteExtra();
            defensaExtraTotal += item.getDefensaExtra();
            ataqueExtraTotal += item.getAtaqueExtra();
        }

        // Asignar las estadísticas finales considerando los valores base de la raza
        this.salud = this.raza.getSaludBase() + saludExtraTotal;
        this.stamana = this.raza.getStamanaBase() + stamanaExtraTotal;
        this.agilidad = this.raza.getAgilidadBase() + agilidadExtraTotal;
        this.suerte = this.raza.getSuerteBase() + suerteExtraTotal;
        this.defensa = this.raza.getDefensaBase() + defensaExtraTotal;
        this.ataque = this.raza.getAtaqueBase() + ataqueExtraTotal;
    }

    /**
     * Agrega un efecto temporal al personaje que afectará sus estadísticas.
     * 
     * @param efecto El {@link Efecto} que se aplicará al personaje.
     * @param turnos La duración del efecto en turnos.
     */
    public void agregarEfectoTemporal(Efecto efecto, int turnos) {

    }

    /**
     * Actualiza los efectos temporales del personaje, descontando turnos o eliminándolos.
     * Actualmente no implementado.
     */
    public void actualizarEfectos() {

    }

    /**
     * Obtiene el nivel actual del personaje.
     * 
     * @return El nivel del personaje.
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Establece el nivel del personaje.
     * 
     * @param nivel El nuevo nivel del personaje.
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Obtiene la experiencia actual del personaje.
     * 
     * @return La experiencia del personaje.
     */
    public double getXp() {
        return xp;
    }

    /**
     * Establece la experiencia del personaje.
     * 
     * @param xp La nueva cantidad de experiencia del personaje.
     */
    public void setXp(double xp) {
        this.xp = xp;
    }

    /**
     * Obtiene el inventario del personaje.
     * 
     * @return El inventario del personaje.
     */
    public Inventario getInventario() {
        return inventario;
    }

    /**
     * Obtiene los efectos temporales aplicados al personaje, junto con su duración en turnos.
     * 
     * @return Un mapa de efectos temporales con su duración en turnos.
     */
    public Map<Efecto, Integer> getEfectosTemporales() {
        return efectosTemporales;
    }
}
