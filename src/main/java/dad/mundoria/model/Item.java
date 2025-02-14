package dad.mundoria.model;

/**
 * Representa un objeto o {@link Item} dentro del juego.
 * Un item puede ser de diferentes tipos, como armaduras, armas, consumibles o de misión,
 * y tener distintas rarezas, que influyen en su valor y utilidad.
 */
public class Item {

    /**
     * Enum que define los diferentes tipos de {@link Item} que existen en el juego.
     */
    public enum TipoItem {

        ARMADURA("Este item es equipable como armadura, te modificará las estadísticas"),
        ARMA("Este item es equipable como armadura, te modificará las estadísticas"),
        CONSUMIBLE("Este item es consumible, al usarlo desaparecerá y te modificará las estadísticas de manera temporal o permanente"),
        MISION("Este es un item únicamente útil para una misión concreta, ten cuidado");

        private String descripcion;

        /**
         * Constructor del tipo de {@link Item}.
         * 
         * @param descripcion Descripción breve del tipo de {@link Item}.
         */
        TipoItem(String descripcion) {
            this.descripcion = descripcion;
        }

        /**
         * Obtiene la descripción del tipo de {@link Item}.
         * 
         * @return La descripción del tipo.
         */
        public String getDescripcion() {
            return descripcion;
        }
    }

    /**
     * Enum que define las distintas rarezas que un {@link Item} puede tener.
     */
    public enum RarezaItem {

        COMUN("Un item bastante común"), 
        RARO("Algo que no se consigue tan fácilmente como lo demás"),
        BUENO("Item de buena calidad, con un valor y utilidad acorde"),
        EXCEPCIONAL("Algo que no se ve todos los días, es de muy buena calidad"),
        LEGENDARIO("Item sumamente complicado de conseguir, es de lo mejor que te puedes encontrar");

        private String descripcion;

        /**
         * Constructor de la rareza del {@link Item}.
         * 
         * @param descripcion Descripción breve de la rareza del {@link Item}.
         */
        RarezaItem(String descripcion) {
            this.descripcion = descripcion;
        }

        /**
         * Obtiene la descripción de la rareza del {@link Item}.
         * 
         * @return La descripción de la rareza.
         */
        public String getDescripcion() {
            return descripcion;
        }

    }

    private int idItem;
    private String nombre;
    private String descripcion;
    private int saludExtra;
    private int stamanaExtra;
    private int agilidadExtra;
    private int suerteExtra;
    private int defensaExtra;
    private int ataqueExtra;
    private double valor;
    private boolean estaEquipado;
    private TipoItem tipo;
    private RarezaItem rareza;

    /**
     * Constructor de la clase {@link Item}.
     * 
     * @param idItem El identificador único del item.
     * @param nombre El nombre del item.
     * @param descripcion Una descripción del item.
     * @param saludExtra La cantidad de salud extra que proporciona el item.
     * @param stamanaExtra La cantidad de stamina extra que proporciona el item.
     * @param agilidadExtra La cantidad de agilidad extra que proporciona el item.
     * @param suerteExtra La cantidad de suerte extra que proporciona el item.
     * @param defensaExtra La cantidad de defensa extra que proporciona el item.
     * @param ataqueExtra La cantidad de ataque extra que proporciona el item.
     * @param valor El valor monetario del item.
     * @param estaEquipado Indica si el item está actualmente equipado o no.
     * @param tipo El tipo de item (arma, armadura, consumible, misión).
     * @param rareza La rareza del item (común, raro, bueno, excepcional, legendario).
     */
    public Item(int idItem, String nombre, String descripcion, int saludExtra, int stamanaExtra, int agilidadExtra,
            int suerteExtra, int defensaExtra, int ataqueExtra, double valor, boolean estaEquipado, TipoItem tipo,
            RarezaItem rareza) {
        super();
        this.idItem = idItem;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.saludExtra = saludExtra;
        this.stamanaExtra = stamanaExtra;
        this.agilidadExtra = agilidadExtra;
        this.suerteExtra = suerteExtra;
        this.defensaExtra = defensaExtra;
        this.ataqueExtra = ataqueExtra;
        this.valor = valor;
        this.estaEquipado = estaEquipado;
        this.tipo = tipo;
        this.rareza = rareza;
    }

    /**
     * Equipa el item, cambiando su estado de "equipado" a {@code true}.
     */
    public void equipar() {
        estaEquipado = true;
    }

    /**
     * Desequipa el item, cambiando su estado de "equipado" a {@code false}.
     */
    public void desequipar() {
        estaEquipado = false;
    }

    /**
     * Obtiene el identificador único del {@link Item}.
     * 
     * @return El identificador del item.
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * Obtiene el nombre del {@link Item}.
     * 
     * @return El nombre del item.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la descripción del {@link Item}.
     * 
     * @return La descripción del item.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene la cantidad de salud extra proporcionada por el {@link Item}.
     * 
     * @return La cantidad de salud extra.
     */
    public int getSaludExtra() {
        return saludExtra;
    }

    /**
     * Obtiene la cantidad de stamina extra proporcionada por el {@link Item}.
     * 
     * @return La cantidad de stamina extra.
     */
    public int getStamanaExtra() {
        return stamanaExtra;
    }

    /**
     * Obtiene la cantidad de agilidad extra proporcionada por el {@link Item}.
     * 
     * @return La cantidad de agilidad extra.
     */
    public int getAgilidadExtra() {
        return agilidadExtra;
    }

    /**
     * Obtiene la cantidad de suerte extra proporcionada por el {@link Item}.
     * 
     * @return La cantidad de suerte extra.
     */
    public int getSuerteExtra() {
        return suerteExtra;
    }

    /**
     * Obtiene la cantidad de defensa extra proporcionada por el {@link Item}.
     * 
     * @return La cantidad de defensa extra.
     */
    public int getDefensaExtra() {
        return defensaExtra;
    }

    /**
     * Obtiene la cantidad de ataque extra proporcionada por el {@link Item}.
     * 
     * @return La cantidad de ataque extra.
     */
    public int getAtaqueExtra() {
        return ataqueExtra;
    }

    /**
     * Obtiene el valor del {@link Item}.
     * 
     * @return El valor monetario del item.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Indica si el {@link Item} está equipado o no.
     * 
     * @return {@code true} si el item está equipado, {@code false} en caso contrario.
     */
    public boolean estaEquipado() {
        return estaEquipado;
    }

    /**
     * Obtiene el tipo de {@link Item}.
     * 
     * @return El tipo de item (armadura, arma, consumible, misión).
     */
    public TipoItem getTipo() {
        return tipo;
    }

    /**
     * Obtiene la rareza del {@link Item}.
     * 
     * @return La rareza del item.
     */
    public RarezaItem getRareza() {
        return rareza;
    }

}
