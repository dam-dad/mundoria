package dad.mundoria.model;

import org.junit.jupiter.api.Test;

import dad.mundoria.model.data.DatosPredefinidos;

public class EfectoTest {

	@Test
	void aplicarEfectoTest() {

		Personaje objetivo = new Personaje("Prueba", "", DatosPredefinidos.CLASES.get(0),
				DatosPredefinidos.RAZAS.get(2));

	}

}
