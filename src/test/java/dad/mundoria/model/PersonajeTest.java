package dad.mundoria.model;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import dad.mundoria.model.Efecto.TipoEfecto;
import dad.mundoria.model.Habilidad.TipoHabilidad;
import dad.mundoria.model.Item.RarezaItem;
import dad.mundoria.model.Item.TipoItem;

public class PersonajeTest {

	@Test
	void inicializarEstadisticasTest() {
		Efecto pruebaEfecto = new Efecto(0, "prueba", "", TipoEfecto.DAÑO, 10, 1);

		List<Efecto> efectos = new ArrayList<>();
		efectos.add(pruebaEfecto);

		Habilidad pruebaHabilidad = new Habilidad(0, "prueba", "", TipoHabilidad.FISICO_CORTANTE, 10, 0, efectos);

		List<Habilidad> habilidades = new ArrayList<>();
		habilidades.add(pruebaHabilidad);

		Clase guardian = new Clase(0, "Guardián", "", "", habilidades);
		Raza skarn = new Raza(0, "Skarn", "", 100, 100, 100, 100, 100, 100, TipoHabilidad.MAGICO_FUEGO,
				TipoHabilidad.FISICO_CONTUNDENTE);

		List<Item> items = new ArrayList<>();

		Inventario inventario = new Inventario(items, 10, 0);
		Personaje personaje = new Personaje("Prueba", "", 0, 0, 0, 0, 0, 0, guardian, skarn, inventario);

		personaje.inicializarEstadisticas();

		boolean estadisticasIguales;
		if (personaje.getSalud() == skarn.getSaludBase() && personaje.getStamana() == skarn.getStamanaBase()
				&& personaje.getAgilidad() == skarn.getAgilidadBase() && personaje.getSuerte() == skarn.getSuerteBase()
				&& personaje.getDefensa() == skarn.getDefensaBase() && personaje.getAtaque() == skarn.getAtaqueBase()

		) {
			estadisticasIguales = true;
		} else {
			estadisticasIguales = false;
		}

		assertTrue("Los valores deben ser iguales a los de la raza", estadisticasIguales);

		Item item = new Item(0, "prueba", "", 10, 10, 10, 10, 10, 10, 10, true, TipoItem.ARMA, RarezaItem.BUENO);
		inventario.agregarItem(item);
		inventario.getItemsEquipados().add(item);

		personaje.inicializarEstadisticas();

		if (personaje.getSalud() == skarn.getSaludBase() + item.getSaludExtra()
				&& personaje.getStamana() == skarn.getStamanaBase() + item.getStamanaExtra()
				&& personaje.getAgilidad() == skarn.getAgilidadBase() + item.getAgilidadExtra()
				&& personaje.getSuerte() == skarn.getSuerteBase() + item.getSuerteExtra()
				&& personaje.getDefensa() == skarn.getDefensaBase() + item.getDefensaExtra()
				&& personaje.getAtaque() == skarn.getAtaqueBase() + item.getAtaqueExtra()

		) {
			estadisticasIguales = true;
		} else {
			estadisticasIguales = false;
		}

		assertTrue("Los valores deben ser iguales a los de la raza más los items", estadisticasIguales);

	}

}
