package dad.mundoria.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el inventario de un personaje o entidad dentro del juego.
 * Un inventario contiene una lista de {@link Item}s, un límite de capacidad máxima y
 * una cantidad de oro disponible.
 */
public class Inventario {

    private List<Item> items;
    private int capacidadMaxima;
    private double oro;
    private List<Item> itemsEquipados = new ArrayList<>();

    /**
     * Constructor de la clase {@link Inventario}.
     * 
     * @param items Lista de objetos {@link Item} que forman el inventario.
     * @param capacidadMaxima La cantidad máxima de objetos que el inventario puede contener.
     * @param oro La cantidad de oro disponible en el inventario.
     */
    public Inventario(List<Item> items, int capacidadMaxima, double oro) {
        super();
        this.items = items;
        this.capacidadMaxima = capacidadMaxima;
        this.oro = oro;
    }

    /**
     * Agrega un nuevo {@link Item} al inventario si no se ha alcanzado la capacidad máxima.
     * 
     * @param item El {@link Item} a agregar al inventario.
     * @return {@code true} si el item se agrega correctamente, 
     *         {@code false} si no hay espacio suficiente.
     */
    public boolean agregarItem(Item item) {

        if (capacidadMaxima != items.size()) {
            items.add(item);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Elimina un {@link Item} del inventario.
     * 
     * @param item El {@link Item} a eliminar.
     * @return {@code true} si el item se elimina correctamente.
     */
    public boolean eliminarItem(Item item) {
        items.remove(item);
        return true;
    }

    /**
     * Suma una cantidad de oro al inventario.
     * 
     * @param cantidad La cantidad de oro a agregar al inventario.
     */
    public void sumarOro(double cantidad) {
        oro = oro + cantidad;
    }

    /**
     * Resta una cantidad de oro del inventario.
     * 
     * @param cantidad La cantidad de oro a restar del inventario.
     */
    public void restarOro(double cantidad) {
        oro = oro - cantidad;
    }

    /**
     * Obtiene la lista de objetos {@link Item} en el inventario.
     * 
     * @return La lista de objetos {@link Item}.
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Establece la lista de objetos {@link Item} en el inventario.
     * 
     * @param items Lista de objetos {@link Item} a establecer.
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Obtiene la capacidad máxima del inventario.
     * 
     * @return La capacidad máxima del inventario.
     */
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    /**
     * Establece la capacidad máxima del inventario.
     * 
     * @param capacidadMaxima La capacidad máxima a establecer.
     */
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    /**
     * Obtiene la cantidad de oro disponible en el inventario.
     * 
     * @return La cantidad de oro en el inventario.
     */
    public double getOro() {
        return oro;
    }

    /**
     * Establece la cantidad de oro disponible en el inventario.
     * 
     * @param oro La cantidad de oro a establecer.
     */
    public void setOro(double oro) {
        this.oro = oro;
    }

    /**
     * Obtiene la lista de objetos {@link Item} que están equipados actualmente.
     * 
     * @return La lista de objetos {@link Item} equipados.
     */
    public List<Item> getItemsEquipados() {
        return itemsEquipados;
    }

    /**
     * Establece la lista de objetos {@link Item} que están equipados actualmente.
     * 
     * @param itemsEquipados Lista de objetos {@link Item} equipados a establecer.
     */
    public void setItemsEquipados(List<Item> itemsEquipados) {
        this.itemsEquipados = itemsEquipados;
    }

}
