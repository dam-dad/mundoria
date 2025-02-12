package dad.mundoria.model;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class DadoTest {

	@Test
	void lanzarTest() {

		int resultado;
		Dado dado6 = new Dado(6);
		Dado dado20 = new Dado(20);

		resultado = dado6.lanzar();
		assertTrue("El resultado debe estar entre 1 y 6", resultado >= 1 && resultado <= 6);

		resultado = dado20.lanzar();
		assertTrue("El resutado debe estar entre 1 y 20", resultado >= 1 && resultado <= 20);

	}

}
