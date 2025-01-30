package dad.mundoria.model.data;

import java.util.Arrays;
import java.util.List;

import dad.mundoria.model.Clase;
import dad.mundoria.model.Habilidad;
import dad.mundoria.model.Habilidad.TipoHabilidad;
import dad.mundoria.model.Raza;

public class DatosPredefinidos {
	
	//Descripciones razas
	private static final String HUMANO_DESCRIPCION = "Adaptables y ambiciosos, los humanos forman las naciones más extensas. "
			+ "Algunos se dedican a estudiar la magia en academias, mientras otros la temen.";
	private static final String ALDOREI_DESCRIPCION = "Una raza de elfos cuyo vínculo con la naturaleza les otorga longevidad y"
			+ " poderes mágicos innatos. Son protectores de los antiguos bosques encantados.";
	private static final String SKARN_DESCRIPCION = "Criaturas reptilianas, descendientes de los dragones. Viven en clanes "
			+ "dispersos y poseen una fuerza física superior, junto con una conexión mística a los "
			+ "dragones ancestrales.";
	private static final String DWARKIN_DESCRIPCION = "Parecidos a los enanos, viven bajo las montañas, forjan las armas más "
			+ "poderosas y dominan una magia terrenal que les permite modelar la roca a voluntad.";
	private static final String SILFOS_DESCRIPCION = "Espíritus del aire con forma etérea, pueden volar y manipular los vientos. "
			+ "Aunque son raros, son seres pacíficos que guardan secretos de la magia antigua.";
	private static final String TERSK_DESCRIPCION = "Nómadas felinos con agilidad extrema y sentidos agudos. Se dice que son los "
			+ "guardianes de las Ruinas Prohibidas, donde yace el poder del Cataclismo.";
	
	public static final List<Raza> RAZAS = Arrays.asList(
			new Raza(1, "Humano", HUMANO_DESCRIPCION, 100, 100, 50, 0, 0, 0, TipoHabilidad.MAGICO_ARCANO, TipoHabilidad.FISICO_PERFORANTE),
			new Raza(2, "Al'dorei", ALDOREI_DESCRIPCION, 75, 150, 40, 10, 0, 0, TipoHabilidad.MAGICO_SOMBRA, TipoHabilidad.FISICO_PERFORANTE),
			new Raza(3, "Skarn", SKARN_DESCRIPCION, 120, 80, 10, 0, 5, 5, TipoHabilidad.MAGICO_CELESTIAL, TipoHabilidad.FISICO_CONTUNDENTE),
			new Raza(4, "Dwarkin", DWARKIN_DESCRIPCION, 100, 120, 35, 0, 5, 0, TipoHabilidad.MAGICO_HIELO, TipoHabilidad.FISICO_CORTANTE),
			new Raza(5, "Silfos", SILFOS_DESCRIPCION, 120, 135, 65, 0, 0, 0, TipoHabilidad.MAGICO_ARCANO, null), //Posible clase incapaz de hacer y recibir daño físico.
			new Raza(6, "Tersk", TERSK_DESCRIPCION, 75, 120, 80, 10, 0, 0, TipoHabilidad.MAGICO_FUEGO, TipoHabilidad.FISICO_CORTANTE)
			);
	
	//TODO Hay que replantear los efectos, quizás solo debamos dejarlos para los consumibles y no tanto para las habilidades, solo unos pocos.
	//     Ademas, quizás no haga falta una lista de efectos, sino crear un efecto distinto según el caso.
//	public static final List<Efecto> EFECTOS = Arrays.asList(
//			new Efecto(1, "Daño directo", "Daño directo al objetivo, resta HP.", TipoEfecto.DAÑO, 10, 0),
//			new Efecto(2, "Aturdimiento", "Aturde al objetivo, impidiendo que haga nada.", TipoEfecto.STUN, 0, 1),
//			new Efecto(3, "Proteccion temporal", "Evita o reduce el daño del objetivo. Se puede usar en si mismo.", TipoEfecto.PROTECCION, 0, 1),
//			new Efecto(4, "Mofa", "Llama la atención de los enemigos hacia quien lo tiene.", TipoEfecto.LLAMADA, 0, 1),
//			new Efecto(5, "Proteccion temporal", "Protege")
//			);
	
	
	// Descripciones de todas las habilidades. La nomenclatura de las variables va en función al ID de la habildiad.
	// Es decir, DESCRIPCION_1 es la descripción para la habilidad con id 1.
	private static final String DESCRIPCION_1 = "Realiza un ataque físico. Si el jugador saca un 5 o 6 en un dado de "
			+ "6 caras, el enemigo queda aturdido durante un turno.";
	private static final String DESCRIPCION_2 = "Reduce el daño recibido en un 25% durante 2 turnos. Necesita una tirada "
			+ "de 4 o más para activarse.";
	private static final String DESCRIPCION_3 = "Obliga a todos los enemigos a atacarte en su próximo turno. Enemigos deben "
			+ "acertar una tirada de 4 o más en 1d6 para resistir.";
	private static final String DESCRIPCION_4 = "Otorga un escudo al grupo que bloquea 5 puntos de daño por ataque durante 3 "
			+ "turnos. Requiere tirada de 5 o más para activarse.";
	private static final String DESCRIPCION_5 = "Ataca a todos los enemigos con una tirada de ataque (1d6). Si el resultado "
			+ "es 5 o más, inflige el doble de daño.";
	private static final String DESCRIPCION_6 = "Lanza un proyectil mágico con un daño base. Si el resultado en 1d6 es 4 o más,"
			+ " inflige un daño adicional igual al nivel del mago.";
	private static final String DESCRIPCION_7 = "Gasta puntos de maná para absorber hasta 10 puntos de daño durante 2 turnos. "
			+ "Tirada de 3 o más para activarse.";
	private static final String DESCRIPCION_8 = "Realiza un ataque en área. Cada enemigo hace una tirada de 4 o más para evitar "
			+ "el daño.";
	private static final String DESCRIPCION_9 = "Aumenta el daño mágico en un 50% durante 3 turnos. Requiere una tirada de 5 o "
			+ "más para activar.";
	private static final String DESCRIPCION_10 = "Lanza meteoros que golpean hasta a 3 enemigos al azar. Cada ataque requiere una"
			+ " tirada de 4 o más para acertar.";
	private static final String DESCRIPCION_11 = "Realiza un ataque con un bono. Si el enemigo tiene menos del 50% de vida, "
			+ "un 5 o más en 1d6 hace que sea un crítico (daño x2).";
	private static final String DESCRIPCION_12 = "Se mueve detrás de un enemigo y lo ataca. Si saca un 4 o más, el ataque ignora"
			+ " la defensa del enemigo.";
	private static final String DESCRIPCION_13 = "Evita todo el daño durante un turno. Tirada de 3 o más para activarse.";
	private static final String DESCRIPCION_14 = "Añade un veneno al arma que inflige daño adicional (igual a 1d6) durante 3 turnos.";
	private static final String DESCRIPCION_15 = "Realiza 3 ataques consecutivos. Cada uno requiere una tirada de 4 o más para acertar. "
			+ "Si todos impactan, el último golpe es un crítico.";
	private static final String DESCRIPCION_16 = "Realiza un ataque con un +1 al resultado del dado. Si saca un 5 o más, el enemigo "
			+ "queda ralentizado un turno.";
	private static final String DESCRIPCION_17 = "Coloca una trampa que se activa si un enemigo intenta moverse. Tirada de 3 o más"
			+ " en 1d6 para activarla.";
	private static final String DESCRIPCION_18 = "Causa daño en área. Cada enemigo impactado debe fallar una tirada de 4 o más para"
			+ " evitar el daño.";
	private static final String DESCRIPCION_19 = "Aumenta el alcance del ataque. Durante 3 turnos, obtiene un bono de +1 a todas "
			+ "las tiradas de ataque.";
	private static final String DESCRIPCION_20 = "Ataca a todos los enemigos en línea recta. Cada uno debe fallar una tirada de 5 "
			+ "o más para evitar el daño.";
	
	
	public static final List<Habilidad> HABILIDADES = Arrays.asList(
			new Habilidad(1, "Golpe de Escudo", DESCRIPCION_1, TipoHabilidad.FISICO_CONTUNDENTE, 10, 1, null),
			new Habilidad(2, "Postura Defensiva", DESCRIPCION_2, null, 10, 3, null),
			new Habilidad(3, "Rugido Intimidante", DESCRIPCION_3, null, 10, 5, null),
			new Habilidad(4, "Muro Inquebrantable", DESCRIPCION_4, null, 20, 7, null),
			new Habilidad(5, "Ira del Guardián", DESCRIPCION_5, null, 20, 10, null),
			
			new Habilidad(6, "Orbe Arcano", DESCRIPCION_6, TipoHabilidad.MAGICO_ARCANO, 10, 1, null),
			new Habilidad(7, "Escudo de Maná", DESCRIPCION_7, null, 15, 3, null),
			new Habilidad(8, "Explosión Elemental", DESCRIPCION_8, TipoHabilidad.MAGICO_FUEGO, 20, 5, null),
			new Habilidad(9, "Canalización Avanzada", DESCRIPCION_9, null, 20, 7, null),
			new Habilidad(10, "Lluvia de Meteoro", DESCRIPCION_10, TipoHabilidad.MAGICO_CELESTIAL, 45, 10, null),
			
			new Habilidad(11, "Golpe Letal", DESCRIPCION_11, TipoHabilidad.FISICO_PERFORANTE, 10, 1, null),
			new Habilidad(12, "Paso Sombrío", DESCRIPCION_12, TipoHabilidad.FISICO_PERFORANTE, 10, 3, null),
			new Habilidad(13, "Niebla Evasiva", DESCRIPCION_13, null, 10, 5, null),
			new Habilidad(14, "Veneno Mortal", DESCRIPCION_14, TipoHabilidad.FISICO_CORTANTE, 10, 7, null),
			new Habilidad(15, "Danza de las Sombras", DESCRIPCION_15, TipoHabilidad.FISICO_PERFORANTE, 20, 10, null),
			
			new Habilidad(16, "Disparo preciso", DESCRIPCION_16, TipoHabilidad.FISICO_PERFORANTE, 10, 1, null),
			new Habilidad(17, "Trampa de Pinchos", DESCRIPCION_17, TipoHabilidad.FISICO_CONTUNDENTE, 10, 3, null),
			new Habilidad(18, "Flecha Explosiva", DESCRIPCION_18, TipoHabilidad.MAGICO_FUEGO, 20, 5, null),
			new Habilidad(19, "Ojo de Halcón", DESCRIPCION_19, null, 10, 7, null),
			new Habilidad(20, "Disparo Perforante", DESCRIPCION_20, TipoHabilidad.FISICO_PERFORANTE, 20, 10, null)
			);
			
	
	//Descripciones de las clases
	private static final String DESCRIPCION_GUARDIAN = "El Guardián es un baluarte inquebrantable, un defensor nato que antepone la"
			+ " seguridad de su grupo a todo lo demás. Con su escudo y su determinación, se convierte en la primera línea de defensa"
			+ " contra cualquier amenaza. Aunque no es el más rápido ni el más ágil, su fortaleza y resistencia son legendarias, "
			+ "capaces de mantener la calma incluso en las situaciones más desesperadas.";
	private static final String DESCRIPCION_MAGO = "El Mago es un maestro de la magia, un estudioso de los arcanos que dedica su vida "
			+ "a comprender y controlar los secretos del universo. Con su vasto conocimiento, puede convocar fuerzas devastadoras o "
			+ "tejer hechizos de gran utilidad para el grupo. Sin embargo, este poder viene con el riesgo de fallos catastróficos si "
			+ "no se controla con precisión.";
	private static final String DESCRIPCION_ASESINO = "El Asesino es la sombra en la noche, un maestro del sigilo y el engaño que "
			+ "prefiere eliminar amenazas antes de que puedan reaccionar. Rápido, preciso y letal, se especializa en infligir grandes"
			+ " cantidades de daño en poco tiempo, atacando cuando y donde el enemigo menos lo espera.";
	private static final String DESCRIPCION_CAZADOR = "El Cazador es un explorador nato, un experto en rastreo y combate a distancia. "
			+ "Desde las sombras o la seguridad de la distancia, puede desatar una lluvia de flechas o atrapar a sus enemigos con "
			+ "trampas cuidadosamente colocadas. En combate, su precisión es mortal, y fuera de él, es un invaluable guía para "
			+ "cualquier grupo.";
	
	//Lemas de las clases
	private static final String LEMA_GUARDIAN = "";
	private static final String LEMA_MAGO = "";
	private static final String LEMA_ASESINO = "";
	private static final String LEMA_CAZADOR = "";
	
	public static final List<Clase> CLASES = Arrays.asList(
			new Clase(1, "Guardián", DESCRIPCION_GUARDIAN, LEMA_GUARDIAN, HABILIDADES.subList(0, 5)),
			new Clase(2, "Mago", DESCRIPCION_MAGO, LEMA_MAGO, HABILIDADES.subList(5, 10)),
			new Clase(3, "Asesino", DESCRIPCION_ASESINO, LEMA_ASESINO, HABILIDADES.subList(10, 15)),
			new Clase(4, "Cazador", DESCRIPCION_CAZADOR, LEMA_CAZADOR, HABILIDADES.subList(15, 20))
			);
	
}
