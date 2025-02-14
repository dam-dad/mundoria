package dad.mundoria.model;

/**
 * Clase abstracta que representa a una entidad dentro del juego, como personajes, enemigos, etc.
 * Contiene las estadísticas básicas que definen las características de la entidad,
 * como salud, estamina, agilidad, suerte, defensa, ataque, así como su clase y raza.
 * También incluye métodos para modificar y obtener estas estadísticas.
 */
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

    /**
     * Constructor de la clase {@link Entidad}.
     * 
     * @param nombre Nombre de la entidad.
     * @param trasfondo Trasfondo o historia de la entidad.
     * @param clase Clase a la que pertenece la entidad.
     * @param raza Raza de la entidad.
     */
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

    /**
     * Método abstracto para inicializar las estadísticas de la entidad. 
     * Este método debe ser implementado por las clases hijas.
     */
    public abstract void inicializarEstadisticas();

    /**
     * Método abstracto para manejar la evasión de la entidad. 
     * Este método debe ser implementado por las clases hijas.
     */
    public abstract void evadir();

    /**
     * Modifica una de las estadísticas de la entidad en función del valor proporcionado.
     * 
     * @param estadistica El nombre de la estadística a modificar (salud, stamina, agilidad, suerte, defensa, ataque).
     * @param valor El valor a agregar o restar a la estadística.
     */
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

    /**
     * Actualiza los efectos aplicados a la entidad. Este método puede ser usado para gestionar
     * efectos temporales o cambios en las estadísticas a lo largo del tiempo.
     */
    public void actualizarEfectos() {
        // Método para actualizar efectos temporales, aún no implementado.
    }

    /**
     * Obtiene el nombre de la entidad.
     * 
     * @return El nombre de la entidad.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el trasfondo de la entidad.
     * 
     * @return El trasfondo de la entidad.
     */
    public String getTrasfondo() {
        return trasfondo;
    }

    /**
     * Obtiene la salud actual de la entidad.
     * 
     * @return La salud de la entidad.
     */
    public int getSalud() {
        return salud;
    }

    /**
     * Obtiene la stamina actual de la entidad.
     * 
     * @return La stamina de la entidad.
     */
    public int getStamana() {
        return stamana;
    }

    /**
     * Obtiene la suerte de la entidad.
     * 
     * @return La suerte de la entidad.
     */
    public int getSuerte() {
        return suerte;
    }

    /**
     * Obtiene la agilidad de la entidad.
     * 
     * @return La agilidad de la entidad.
     */
    public int getAgilidad() {
        return agilidad;
    }

    /**
     * Obtiene la defensa de la entidad.
     * 
     * @return La defensa de la entidad.
     */
    public int getDefensa() {
        return defensa;
    }

    /**
     * Obtiene el ataque de la entidad.
     * 
     * @return El ataque de la entidad.
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * Obtiene la clase a la que pertenece la entidad.
     * 
     * @return La clase de la entidad.
     */
    public Clase getClase() {
        return clase;
    }

    /**
     * Obtiene la raza de la entidad.
     * 
     * @return La raza de la entidad.
     */
    public Raza getRaza() {
        return raza;
    }
}
