package dad.mundoria.model;

import java.util.List;

public class Inventario {

	private List<Item> items;
	private int capacidadMaxima;
	private double oro;
	private List<Item> itemsEquipados;
	
	public Inventario(List<Item> items, int capacidadMaxima, double oro) {
		super();
		this.items = items;
		this.capacidadMaxima = capacidadMaxima;
		this.oro = oro;
	}
	
	public boolean agregarItem(Item item) {
		
		if(capacidadMaxima != items.size()) {
			items.add(item);
			return true;
		} else {
			return false;
		}
		
		
	}
	
	public boolean eliminarItem(Item item) {
		items.remove(item);
		return true;
	}
	
	public void sumarOro(double cantidad) {
		oro = oro + cantidad;
	}
	
	public void restarOro(double cantidad) {
		oro = oro - cantidad;
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public double getOro() {
		return oro;
	}

	public void setOro(double oro) {
		this.oro = oro;
	}
	
	public List<Item> getItemsEquipados() {
		return itemsEquipados;
	}
	
	public void setItemsEquipados(List<Item> itemsEquipados) {
		this.itemsEquipados = itemsEquipados;
	}
	
	
	
}
