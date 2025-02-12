import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

// Dummy Dado que siempre devuelve un valor fijo para control de test.
class DummyDado extends Dado {
	private int fixedValue;

	public DummyDado(int fixedValue, int numCaras) {
		super(numCaras);
		this.fixedValue = fixedValue;
	}

	@Override
	public int lanzar() {
		return fixedValue;
	}
}

// Dummy Habilidad que simplemente reduce la salud del objetivo por un valor fijo.
class DummyHabilidad extends Habilidad {
	private int damage;

	public DummyHabilidad(String nombre, int costeStamana, int damage) {
		// Asumimos un constructor en Habilidad que recibe nombre, coste de stamana y
		// (por ejemplo) una lista de efectos.
		super(100, nombre, "", TipoHabilidad.FISICO_CONTUNDENTE, costeStamana, 1, null);
		this.damage = damage;
	}

	@Override
	public void usarHabilidad(Entidad actor, Entidad objetivo, int tiradaDaño) {
		// Para simplificar, ignoramos la tiradaDaño y aplicamos un daño fijo.
		objetivo.modificarEstadistica("salud", -damage);
	}

	@Override
	public int getCosteStamana() {
		return super.getCosteStamana(); // O devuelve el coste que se estableció.
	}
}

// Implementación de TurnoListener para el test.
class TestTurnoListener implements TurnoListener {
	private SistemaDeTurnoAccionCallback accionCallback;

	// Usaremos este callback para simular la acción del jugador
	public TestTurnoListener(SistemaDeTurnoAccionCallback accionCallback) {
		this.accionCallback = accionCallback;
	}

	@Override
	public void turnoJugador(Personaje personaje) {
		// Simulamos que el jugador elige una habilidad.
		// Aquí usamos nuestra DummyHabilidad: "Ataque Básico" que inflige 10 de daño.
		DummyHabilidad habilidad = new DummyHabilidad("Ataque Básico", 0, 10);
		// Simulamos que el objetivo es el primer enemigo (asumimos que hay al menos
		// uno)
		accionCallback.procesarAccionJugador(habilidad);
	}

	@Override
	public void turnoEnemigo() {
		// Para el test no es necesario hacer nada aquí.
	}
}

// Una interfaz auxiliar para notificar al test cuando el jugador ha elegido su acción.
interface SistemaDeTurnoAccionCallback {
	void procesarAccionJugador(Habilidad habilidadElegida);
}

// Test de combate en el modelo
public class CombateTest {

	@Test
	public void testCombateConCallback() {
		// --- Configurar el escenario ---
		// Crear un Personaje (jugador)
		// Supongamos que Raza y Clase tienen constructores simples.
		Raza razaHumano = new Raza(100, "Humano", "Un humano", 100, 100, 50, 10, 10, 10, null, null);
		Clase claseGuerrero = new Clase(100, "Guerrero", "Fuert y resistente", "Si o que", null);
		Personaje jugador = new Personaje("Arthur", "El héroe", claseGuerrero, razaHumano);
		jugador.inicializarEstadisticas(); // Salud quedará en 100 (por ejemplo)

		// Crear un Enemigo
		Raza razaOrco = new Raza(110, "Orco", "Un orco", 120, 100, 50, 5, 15, 15, null, null);
		Enemigo enemigo = new Enemigo("Orco Bruto", "Un enemigo feroz", claseGuerrero, razaOrco, new ArrayList<>());
		enemigo.inicializarEstadisticas(); // Salud quedará en 120

		// Crear listas de personajes y enemigos
		List<Personaje> listaPersonajes = new ArrayList<>();
		listaPersonajes.add(jugador);
		List<Enemigo> listaEnemigos = new ArrayList<>();
		listaEnemigos.add(enemigo);

		// Crear el SistemaDeCombate con las listas
		SistemaDeCombate sistema = new SistemaDeCombate(listaEnemigos, listaPersonajes);

		// Para asegurar resultados deterministas, reemplazamos los dados con dummy.
		// Suponemos que SistemaDeCombate tiene setters para los dados (o bien
		// modificamos directamente los atributos para el test)
		// Aquí usaremos números que permitan que la tirada de combate no sea empate.
		// Por ejemplo, para el enemigo, la tirada será 16, y para el objetivo (defensa)
		// será 10.
		sistema.getDado20().setFixedValue(16); // Necesitarás implementar este setter en Dado o usar una versión
												// DummyDado.
		sistema.getDado6().setFixedValue(3); // De igual forma, para daño.

		// --- Configurar el callback ---
		// Creamos una variable para capturar la acción del jugador.
		final boolean[] turnoJugadorNotificado = { false };
		SistemaDeTurnoAccionCallback callback = habilidadElegida -> {
			// Este callback se invoca cuando el jugador elige su acción.
			turnoJugadorNotificado[0] = true;
			// Simulamos que la acción se procesa llamando al método realizarAccion del
			// sistema
			// En este caso, el objetivo es el enemigo.
			sistema.realizarAccion(jugador, enemigo, habilidadElegida);
			// Avanzamos el turno manualmente (el sistema lo hará internamente)
		};
		// Establecemos el listener en el sistema.
		sistema.setListener(new TestTurnoListener(callback));

		// --- Ejecutar el combate ---
		// Para el test, llamamos a iniciarCombate(). El flujo interno debe llegar al
		// turno del jugador, disparar el callback, y procesar la acción.
		sistema.iniciarCombate();

		// --- Verificaciones ---
		// Verificar que el turno del jugador fue notificado y que la acción redujo la
		// salud del enemigo.
		// Por ejemplo, la DummyHabilidad "Ataque Básico" reduce la salud en 10 puntos.
		int saludEnemigoFinal = enemigo.getSalud();
		System.out.println("Salud final del enemigo: " + saludEnemigoFinal);
		// Como la salud base del enemigo es 120, tras recibir 10 de daño, debería
		// quedar en 110.
		assertTrue(saludEnemigoFinal < 120, "El enemigo debería haber recibido daño y tener menos salud.");
		assertTrue(turnoJugadorNotificado[0], "El turno del jugador debe haber sido notificado mediante el callback.");
	}
}
