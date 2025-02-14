package dad.mundoria.model;

import java.util.List;

/**
 * Clase que representa una habilidad que puede ser utilizada por las entidades en el juego.
 * Cada habilidad tiene un tipo, coste de estamina, nivel requerido para ser utilizada, 
 * y una lista de efectos que pueden aplicarse al objetivo de la habilidad.
 */
public class Habilidad {

    /**
     * Enumeración que define los diferentes tipos de habilidad disponibles en el juego.
     * Cada tipo tiene una descripción asociada que explica el efecto de daño que produce.
     */
    public enum TipoHabilidad {
        FISICO_CORTANTE("Daño físico cortante, genera cortes en el objetivo"),
        FISICO_CONTUNDENTE("Daño físico contundente, genera golpes en el objetivo"),
        FISICO_PERFORANTE("Daño físico perforante, genera perforaciones en el enemigo"),
        MAGICO_FUEGO("Daño mágico tipo fuego, quema al objetivo"),
        MAGICO_ARCANO("Daño mágico tipo arcano, daña al objetivo con energía mágica pura"),
        MAGICO_HIELO("Daño mágico tipo hielo, congela al objetivo"),
        MAGICO_SOMBRA("Daño mágico tipo sombra, usa el poder sombrío para dañar al enemigo"),
        MAGICO_CELESTIAL("Daño mágico tipo celestial, usa el poder celestial para dañar al enemigo");

        private final String descripcion;

        /**
         * Constructor de la enumeración {@link TipoHabilidad}.
         * 
         * @param descripcion Descripción del tipo de habilidad.
         */
        TipoHabilidad(String descripcion) {
            this.descripcion = descripcion;
        }

        /**
         * Obtiene la descripción del tipo de habilidad.
         * 
         * @return La descripción del tipo de habilidad.
         */
        public String getDescripcion() {
            return descripcion;
        }
    }

    private int idHabilidad;
    private String nombre;
    private String resumen;
    private TipoHabilidad tipo;
    private int costeStamana;
    private int nivelRequerido;
    private List<Efecto> efectos;

    /**
     * Constructor de la clase {@link Habilidad}.
     * 
     * @param idHabilidad Identificador único de la habilidad.
     * @param nombre Nombre de la habilidad.
     * @param resumen Resumen o descripción breve de la habilidad.
     * @param tipo Tipo de habilidad (físico o mágico).
     * @param costeStamana Coste en estamina para utilizar la habilidad.
     * @param nivelRequerido Nivel mínimo del personaje para poder utilizar la habilidad.
     * @param efectos Lista de efectos que la habilidad aplica al objetivo.
     */
    public Habilidad(int idHabilidad, String nombre, String resumen, TipoHabilidad tipo, int costeStamana,
            int nivelRequerido, List<Efecto> efectos) {
        super();
        this.idHabilidad = idHabilidad;
        this.nombre = nombre;
        this.resumen = resumen;
        this.tipo = tipo;
        this.costeStamana = costeStamana;
        this.nivelRequerido = nivelRequerido;
        this.efectos = efectos;
    }

    /**
     * Método que se encarga de utilizar la habilidad sobre un objetivo. La habilidad consume 
     * estamina y aplica efectos o daño según los efectos asociados.
     * 
     * @param actor El actor que usa la habilidad (por ejemplo, un personaje o enemigo).
     * @param objetivo El objetivo de la habilidad (la entidad que recibirá el daño o efectos).
     * @param tiradaDado El valor de la tirada del dado (determina si el daño es bajo, neutro o alto).
     */
    public void usarHabilidad(Entidad actor, Entidad objetivo, int tiradaDado) {

        // Comienza el uso del dado de daño (6 caras)
        // Habrán 3 tiradas por así decirlo. 1 y 2 serán tirada baja, 3 y 4 tirada
        // neutra y por último; 5 y 6 tirada alta.
        // Cada tirada afecta al daño. Tirada baja quita 20 puntos de daño, tirada
        // neutra no quita ni suma, tirada alta añade 20 puntos de daño.
        int modificador = 0;

        if (tiradaDado == 1 || tiradaDado == 2) {
            modificador = -20;
        } else if (tiradaDado == 3 || tiradaDado == 4) {
            modificador = 0;
        } else if (tiradaDado == 5 || tiradaDado == 6) {
            modificador = 20;
        } else {
            System.err.println("ERROR: Dado inválido, dado de solamente 6 caras.");
        }

        // Aquí se suma a la tirada el ataque del actor
        modificador += actor.getAtaque();

        if (actor.getStamana() >= costeStamana) {
            actor.modificarEstadistica("stamana", -costeStamana);

            if (efectos == null) {
                objetivo.modificarEstadistica("salud", -30 + modificador); // TODO Esto es solo para prueba, se debería cambiar en el futuro.
                System.out.println("Se le ha modificado la estadística salud a`" + objetivo.getNombre()+ " con un valor de " + -30+modificador);
            } else {

                for (Efecto efecto : efectos) {
                    efecto.aplicarEfecto(objetivo, modificador);
                }
            }

        } else {
            return;
        }

    }

    /**
     * Verifica si la habilidad está bloqueada para un personaje, basándose en el nivel requerido.
     * 
     * @param nivelRequerido El nivel necesario para usar la habilidad.
     * @param personaje El personaje que intenta usar la habilidad.
     * @return {@code true} si el personaje no tiene el nivel suficiente para usar la habilidad, 
     *         {@code false} en caso contrario.
     */
    public boolean estaBloqueado(int nivelRequerido, Personaje personaje) {

        if (nivelRequerido > personaje.getNivel()) {
            return true;
        } else {
            return false;
        }

    }

    // Métodos getter para acceder a las propiedades de la habilidad.

    public int getIdHabilidad() {
        return idHabilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getResumen() {
        return resumen;
    }

    public TipoHabilidad getTipo() {
        return tipo;
    }

    public int getCosteStamana() {
        return costeStamana;
    }

    public int getNivelRequerido() {
        return nivelRequerido;
    }

    public List<Efecto> getEfectos() {
        return efectos;
    }

}
