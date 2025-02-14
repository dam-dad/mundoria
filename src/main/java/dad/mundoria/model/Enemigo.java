package dad.mundoria.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Representa un enemigo dentro del juego, que extiende la clase {@link Entidad}.
 * Los enemigos tienen un conjunto de objetos que pueden soltar al ser derrotados
 * y pueden elegir un objetivo y una habilidad para usar durante el combate.
 */
public class Enemigo extends Entidad {

    private List<Item> lootProbable;
    private Entidad objetivoActual;

    /**
     * Constructor de la clase {@link Enemigo}.
     * 
     * @param nombre Nombre del enemigo.
     * @param trasfondo Trasfondo o historia del enemigo.
     * @param clase Clase a la que pertenece el enemigo.
     * @param raza Raza del enemigo.
     * @param lootProbable Lista de objetos que el enemigo puede soltar.
     */
    public Enemigo(String nombre, String trasfondo, Clase clase, Raza raza, List<Item> lootProbable) {
        super(nombre, trasfondo, clase, raza);
        this.lootProbable = lootProbable;
    }

    /**
     * Genera un loot aleatorio para el enemigo basado en la probabilidad de raridad de los objetos.
     * 
     * @return Lista de objetos generados como loot.
     */
    public List<Item> generarLoot() {
        Random random = new Random();
        List<Item> lootGenerado = new ArrayList<>();

        for (Item item : lootProbable) {
            // Probabilidades de soltar un ítem según su rareza
            if (item.getRareza().name() == "COMUN" && random.nextInt(100) < 60) {
                lootGenerado.add(item);
            } else if (item.getRareza().name() == "RARO" && random.nextInt(100) < 40) {
                lootGenerado.add(item);
            } else if (item.getRareza().name() == "BUENO" && random.nextInt(100) < 30) {
                lootGenerado.add(item);
            } else if (item.getRareza().name() == "EXCEPCIONAL" && random.nextInt(100) < 20) {
                lootGenerado.add(item);
            } else if (item.getRareza().name() == "LEGENDARIO" && random.nextInt(100) < 10) {
                lootGenerado.add(item);
            }
        }

        return lootGenerado;
    }

    /**
     * Elige aleatoriamente un objetivo de la lista de entidades disponibles.
     * 
     * @param entidades Lista de entidades entre las que se seleccionará un objetivo.
     * @return La entidad seleccionada como objetivo.
     */
    public Entidad elegirObjetivo(List<Entidad> entidades) {
        Random random = new Random();

        if (!entidades.isEmpty()) {
            int indiceRandom = random.nextInt(entidades.size());
            Entidad entidadRandom = entidades.get(indiceRandom);
            objetivoActual = entidadRandom;
            return entidadRandom;
        } else {
            System.err.println("ERROR: LA LISTA DE ENTIDADES ESTÁ VACÍA");
            return null;
        }
    }

    /**
     * Elige aleatoriamente una habilidad disponible según el tipo de objetivo.
     * Si el objetivo es otro enemigo, selecciona una habilidad ofensiva; si el objetivo
     * es un personaje, selecciona una habilidad de apoyo.
     * 
     * @return La habilidad seleccionada.
     */
    public Habilidad elegirHabilidad() {
        Random random = new Random();

        List<Habilidad> habilidadesDisponibles = getClase().getHabilidades();
        int habilidadRandom = random.nextInt(habilidadesDisponibles.size());

        if (objetivoActual instanceof Enemigo) {
            // Elige una habilidad ofensiva
            while (habilidadesDisponibles.get(habilidadRandom).getTipo() != null) {
                habilidadRandom = random.nextInt(habilidadesDisponibles.size());
            }
            return habilidadesDisponibles.get(habilidadRandom);
        } else if (objetivoActual instanceof Personaje) {
            // Elige una habilidad de apoyo
            while (habilidadesDisponibles.get(habilidadRandom).getTipo() == null) {
                habilidadRandom = random.nextInt(habilidadesDisponibles.size());
            }
            return habilidadesDisponibles.get(habilidadRandom);
        } else {
            System.err.println("ERROR: ENTIDADES ERRÓNEAS, IMPOSIBLE ELEGIR HABILIDAD.");
            return null;
        }
    }

    /**
     * Inicializa las estadísticas del enemigo basándose en las estadísticas de su raza.
     * Se establece la salud, estamina, agilidad, suerte, defensa y ataque.
     */
    @Override
    public void inicializarEstadisticas() {
        this.salud = this.raza.getSaludBase();
        this.stamana = this.raza.getStamanaBase();
        this.agilidad = this.raza.getAgilidadBase();
        this.suerte = this.raza.getSuerteBase();
        this.defensa = this.raza.getDefensaBase();
        this.ataque = this.raza.getAtaqueBase();
    }

    /**
     * Método de evasión del enemigo. Actualmente no implementado.
     */
    @Override
    public void evadir() {
        // TODO: Implementar lógica de evasión
    }
}
