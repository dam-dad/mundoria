package dad.mundoria.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemigo extends Entidad {

	private List<Item> lootProbable;
	private Entidad objetivoActual;

	public Enemigo(String nombre, String trasfondo, Clase clase, Raza raza, List<Item> lootProbable) {
		super(nombre, trasfondo, clase, raza);

		this.lootProbable = lootProbable;

	}

	public List<Item> generarLoot() {

		Random random = new Random();
		List<Item> lootGenerado = new ArrayList<>();

		for (Item item : lootProbable) {

			if (item.getRareza().name() == "COMUN") {
				if (random.nextInt(100) < 60) {
					lootGenerado.add(item);
				}
			} else if (item.getRareza().name() == "RARO") {
				if (random.nextInt(100) < 40) {
					lootGenerado.add(item);
				}
			} else if (item.getRareza().name() == "BUENO") {
				if (random.nextInt(100) < 30) {
					lootGenerado.add(item);
				}
			} else if (item.getRareza().name() == "EXCEPCIONAL") {
				if (random.nextInt(100) < 20) {
					lootGenerado.add(item);
				}
			} else if (item.getRareza().name() == "LEGENDARIO") {
				if (random.nextInt(100) < 10) {
					lootGenerado.add(item);
				}
			}

		}

		return lootGenerado;

	}

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

	public Habilidad elegirHabilidad() {

		Random random = new Random();

		List<Habilidad> habilidadesDisponibles = getClase().getHabilidades();

		int habilidadRandom = random.nextInt(habilidadesDisponibles.size());

		if (objetivoActual instanceof Enemigo) {

			while (habilidadesDisponibles.get(habilidadRandom).getTipo() != null) {
				habilidadRandom = random.nextInt(habilidadesDisponibles.size());
			}

			return habilidadesDisponibles.get(habilidadRandom);

		} else if (objetivoActual instanceof Personaje) {

			while (habilidadesDisponibles.get(habilidadRandom).getTipo() == null) {
				habilidadRandom = random.nextInt(habilidadesDisponibles.size());
			}

			return habilidadesDisponibles.get(habilidadRandom);

		} else {
			System.err.println("ERROR: ENTIDADES ERRÓNEAS, IMPOSIBLE ELEGIR HABILIDAD.");
			return null;
		}

	}

	@Override
	public void inicializarEstadisticas() {

		this.salud = this.raza.getSaludBase();
		this.stamana = this.raza.getStamanaBase();
		this.agilidad = this.raza.getAgilidadBase();
		this.suerte = this.raza.getSuerteBase();
		this.defensa = this.raza.getDefensaBase();
		this.ataque = this.raza.getAtaqueBase();

	}

	@Override
	public void evadir() {
		// TODO Auto-generated method stub

	}

}
