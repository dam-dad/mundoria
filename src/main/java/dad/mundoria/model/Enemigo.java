package dad.mundoria.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemigo extends Personaje {
	
	private int nivelDificultad;
	private List<Item> lootProbable;
	
	public Enemigo(String nombre, String trasfondo, int salud, int stamana, int agilidad, int suerte, int defensa,
			int ataque, Clase clase, Raza raza, Inventario inventario, int nivelDificultad, List<Item> lootProbable) {
		super(nombre, trasfondo, salud, stamana, agilidad, suerte, defensa, ataque, clase, raza, inventario);
		
		this.nivelDificultad = nivelDificultad;
		this.lootProbable = lootProbable;
		
	}
	
	public List<Item> generarLoot() {
		
		Random random = new Random();
		getInventario().getItems().clear();
		
		for(Item item : lootProbable) {
			
			if(item.getRareza().name() == "COMUN") {
				if(random.nextInt(100) < 60) {
					getInventario().agregarItem(item);
				}
			} else if(item.getRareza().name() == "RARO") {
				if(random.nextInt(100) < 40) {
					getInventario().agregarItem(item);
				}
			} else if(item.getRareza().name() == "BUENO") {
				if(random.nextInt(100) < 30) {
					getInventario().agregarItem(item);
				}
			} else if(item.getRareza().name() == "EXCEPCIONAL") {
				if(random.nextInt(100) < 20) {
					getInventario().agregarItem(item);
				}
			} else if(item.getRareza().name() == "LEGENDARIO") {
				if(random.nextInt(100) < 10) {
					getInventario().agregarItem(item);
				}
			}
			
		}
		
		return getInventario().getItems();
		
	}
	
	public Personaje elegirObjetivo(List<Personaje> personajes) {
		
		Random random = new Random();
		
		if(!personajes.isEmpty()) {
		
		int indiceRandom = random.nextInt(personajes.size());
		
		Personaje personajeRandom = personajes.get(indiceRandom);
		
		return personajeRandom;
		
		} else {
			System.err.println("ERROR: LA LISTA DE PERSONAJES ESTÁ VACÍA");
			return null;
		}
		
	}
	
	
}
