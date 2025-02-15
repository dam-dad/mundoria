# mundoria
Juego de rol generativo usando una IA (GPT-4) como Game Master

```markdown
# Mundoria

**Mundoria** es un juego de rol generativo que utiliza la IA (GPT-4) como Game Master. Combina elementos de combate por turnos, narrativa generada dinámicamente y un sistema de efectos y habilidades, todo ello orquestado con JavaFX para la interfaz gráfica.

---

## Índice

1. [Descripción](#descripción)
2. [Características Principales](#características-principales)
3. [Requisitos](#requisitos)
4. [Estructura del Proyecto](#estructura-del-proyecto)
5. [Instalación y Ejecución](#instalación-y-ejecución)
6. [Uso del Sistema de Combate](#uso-del-sistema-de-combate)
7. [Contribuyendo](#contribuyendo)
8. [Licencia](#licencia)
9. [Contacto](#contacto)

---

## Descripción

**Mundoria** se desarrolla en un vasto mundo de fantasía, donde el jugador controla personajes de diferentes razas y clases para enfrentarse a enemigos, completar misiones y progresar en un entorno narrativo generado por la IA (GPT-4). El proyecto busca:

- Combinar la generación de contenido (misiones, diálogos) a través de la API de OpenAI.
- Implementar un sistema de combate por turnos con **JavaFX** como interfaz gráfica.
- Manejar estadísticas, habilidades, efectos temporales y loot de manera extensible.

---

## Características Principales

- **IA como Game Master**: Se conecta a GPT-4 para generar misiones, descripciones y eventos narrativos.
- **Combate por Turnos**:
  - Slots para personajes y enemigos (hasta 4 cada uno).
  - Sistema de acciones (habilidades, inventario, huida) y tiradas de dados.
- **Sistema de Efectos** (en progreso):
  - Efectos inmediatos (daño directo, curación).
  - Efectos temporales (veneno, protección, aturdimiento) que duran varios turnos.
- **Interfaz Gráfica con JavaFX**:
  - Vistas de Menú Principal y Combate.
  - Controles para seleccionar personajes, enemigos y habilidades.
  - Barras de progreso de salud y stamina.
- **Diseño Modular**:
  - `SistemaDeCombate` maneja la lógica central del combate y notifica al controlador cuándo es turno del jugador.
  - `CombateController` actualiza la interfaz y gestiona la interacción del usuario.
- **Datos Predefinidos**:
  - Clases, razas, habilidades y efectos definidos en `DatosPredefinidos` para prototipos rápidos.
  - Posible carga dinámica de datos en el futuro.

---

## Requisitos

- **Java 11+** (se recomienda Java 17 o superior).
- **JavaFX** (en algunos entornos es necesario incluir las librerías de JavaFX manualmente).
- **Maven** Para gestionar dependencias.
- (Opcional) **OpenAI API Key** si deseas probar la integración con GPT-4.

---

## Estructura del Proyecto

```plaintext
mundoria/
│
├── src/main/java/dad/mundoria/
│   ├── controller/
│   │   ├── MenuController.java
│   │   ├── CombateController.java
│   │   
│   ├── model/
│   │   ├── Personaje.java
│   │   ├── Enemigo.java
│   │   ├── SistemaDeCombate.java
│   │   ├── Efecto.java
│   │   ├── Habilidad.java
│   │   └── ...
│   ├── app/
│   │   └── Main.java (punto de entrada)
│   └── ...
├── src/main/resources/fxml/
│   ├── MenuView.fxml
│   ├── CombateView.fxml
│   └── ...
├── build.gradle / pom.xml
├── README.md
└── ...
```

- **controller/**: Clases de controlador para JavaFX (MenuController, CombateController).
- **model/**: Lógica de negocio (Personaje, Enemigo, SistemaDeCombate, Efecto, etc.).
- **app/**: Clase principal (`MainApp`) que inicia JavaFX.
- **fxml/**: Archivos de interfaz para SceneBuilder.

---

## Instalación y Ejecución

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/usuario/mundoria.git
   cd mundoria
   ```
2. **Importar el proyecto** en tu IDE favorito (IntelliJ, Eclipse, VSCode con extensiones de Java).
3. **Ejecutar** el proyecto:
   - Con Gradle:
     ```bash
     gradle run
     ```
   - Con Maven:
     ```bash
     mvn javafx:run
     ```
   - O directamente desde la clase `MainApp` en tu IDE.

4. **(Opcional)** Configurar la API Key de OpenAI para la IA:
   - Podrías definir una variable de entorno `OPENAI_API_KEY` o un archivo de configuración.

---

## Uso del Sistema de Combate

- **Menu Principal**: El usuario selecciona “Nueva Partida” para iniciar un combate de prueba.
- **Combate**:
  - Seleccionar personaje (click en el slot de personaje).
  - Seleccionar enemigo (click en el slot de enemigo).
  - Elegir una habilidad (botones de habilidades).
  - El `SistemaDeCombate` procesará la acción y notificará si es turno del enemigo o del jugador.
  - Repetir hasta que un equipo sea derrotado.

- **Efectos Temporales**:
  - Actualmente, el sistema permite aplicar efectos con duración (pendiente de completar).
  - Cada turno, se llama a `actualizarEfectos()` en Personaje/Enemigo para aplicar daño/curación continua o remover efectos expirados.

---

## Contribuyendo

1. **Fork** este repositorio.
2. **Crea una rama** para tu característica o bugfix (`git checkout -b feature/efectos-temporales`).
3. **Realiza tus cambios** y **haz commits** descriptivos.
4. **Envía un Pull Request** a la rama principal (main o master).

**Buenas prácticas**:
- Seguir el estilo de codificación existente.
- Documentar los métodos clave con JavaDoc.
- Asegurarte de que los tests pasan (en caso de haberlos).
- Incluir ejemplos o capturas si la contribución es visual.

---

## Licencia

*(Si no has definido licencia, puedes indicar que es un proyecto privado o que está bajo una licencia permisiva.)*

Por ejemplo:
```
MIT License
```
*(Incluye el texto de la licencia en el archivo LICENSE.)*

---

## Contacto

- **Autores**: NIVELZ69 (Jarod Miguel Peña Castro) y madc79 (Joel Gómez Salgado)
- **Email**: nivelz69contacto@gmail.com y joelchambe007@gmail.com

Si tienes preguntas, abre un Issue en GitHub o contáctame por email.

---

¡Disfruta de **Mundoria** y contribuye con tus ideas!
