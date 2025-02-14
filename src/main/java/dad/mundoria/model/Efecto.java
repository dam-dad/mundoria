package dad.mundoria.model;

/**
 * Representa un efecto que puede aplicarse a una entidad. 
 * Los efectos pueden tener distintos tipos como curación, daño, aturdimiento, protección y llamada.
 */
public class Efecto {

    /**
     * Enum que define los diferentes tipos de efectos posibles.
     * Cada tipo de efecto tiene una descripción asociada.
     */
    public enum TipoEfecto {

        CURACION("Este efecto aumentará la salud del objetivo"), 
        DAÑO("Este efecto disminuirá la salud del objetivo"),
        STUN("Este efecto hará que el objetivo pierda un número de turnos"),
        PROTECCION("Este efecto evitará el daño al objetivo un número de turnos"),
        LLAMADA("Este efecto hará que los enemigos centren sus ataques en quien lo hace");

        private String descripcion;

        /**
         * Constructor del tipo de efecto que asigna una descripción al mismo.
         * 
         * @param descripcion Descripción del efecto.
         */
        TipoEfecto(String descripcion) {
            this.descripcion = descripcion;
        }

        /**
         * Obtiene la descripción asociada al tipo de efecto.
         * 
         * @return Descripción del tipo de efecto.
         */
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

    /**
     * Constructor que inicializa un efecto con los parámetros dados.
     * 
     * @param idEfecto ID único del efecto.
     * @param nombre Nombre del efecto.
     * @param descripcion Descripción del efecto.
     * @param tipo Tipo de efecto (curación, daño, etc.).
     * @param valor Valor que representa el impacto del efecto.
     * @param duracion Duración del efecto en turnos.
     */
    public Efecto(int idEfecto, String nombre, String descripcion, TipoEfecto tipo, int valor, int duracion) {
        super();
        this.idEfecto = idEfecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.valor = valor;
        this.duracion = duracion;
    }

    /**
     * Aplica el efecto sobre una entidad objetivo.
     * Dependiendo del tipo de efecto, modifica las estadísticas de la entidad.
     * 
     * @param objetivo La entidad sobre la que se aplicará el efecto.
     * @param modificadorPuntos Modificador de puntos que puede alterar el valor base del efecto.
     */
    public void aplicarEfecto(Entidad objetivo, int modificadorPuntos) {
        switch (tipo) {
            // Curación se calcula en base al valor propio de la habilidad más el modificador de puntos entre tirada de dados y Ataque del atacante
            case CURACION:
                objetivo.modificarEstadistica("salud", valor + modificadorPuntos);
                break;
            // Daño se calcula en base al valor propio de la habilidad más el modificador de puntos entre tirada de dados y Ataque del atacante menos la defensa del objetivo
            case DAÑO:
                objetivo.modificarEstadistica("salud", -valor + modificadorPuntos - objetivo.getDefensa());
                break;
            case STUN:
                objetivo.actualizarEfectos(); // TODO: Pendiente sistema de turnos para los efectos temporales.
                break;
            case PROTECCION:
                objetivo.actualizarEfectos(); // TODO: Pendiente sistema de turnos para los efectos temporales.
        }
    }

    // Métodos getters para obtener las propiedades del efecto

    /**
     * Obtiene el ID del efecto.
     * 
     * @return El ID del efecto.
     */
    public int getIdEfecto() {
        return idEfecto;
    }

    /**
     * Obtiene el nombre del efecto.
     * 
     * @return El nombre del efecto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la descripción del efecto.
     * 
     * @return La descripción del efecto.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene el tipo de efecto.
     * 
     * @return El tipo de efecto.
     */
    public TipoEfecto getTipo() {
        return tipo;
    }

    /**
     * Obtiene el valor del efecto.
     * 
     * @return El valor del efecto.
     */
    public int getValor() {
        return valor;
    }

    /**
     * Obtiene la duración del efecto.
     * 
     * @return La duración del efecto en turnos.
     */
    public int getDuracion() {
        return duracion;
    }

}
