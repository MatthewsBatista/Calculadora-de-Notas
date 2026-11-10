# Calculadora de Notas

Hola, soy Matthews Batista y este es mi proyecto de la asignación de Java Swing. Es una aplicación de escritorio donde capturo los datos de un estudiante y sus calificaciones, y el programa calcula la nota final y me dice si aprobó o reprobó la materia.

## ¿Qué hace mi programa?

Yo escribo en la ventana:

- El nombre completo, la matrícula y la carrera del estudiante.
- Las cuatro calificaciones: prácticas, parciales, asignaciones y examen final.

Cuando pulso el botón **Calcular Resultado**, el programa suma las cuatro notas, muestra la nota total y me dice si el estudiante quedó **APROBADO** o **REPROBADO**.

## Cómo está repartida la nota

| Componente | Puntos máximos |
|---|---|
| Prácticas | 40 |
| Parciales | 20 |
| Asignaciones | 20 |
| Examen final | 20 |
| **Total** | **100** |

El estudiante aprueba si la suma es **60 puntos o más**. Si saca menos de 60, queda reprobado. El resultado sale en verde cuando aprueba y en rojo cuando reprueba.

## Validaciones que le puse

Quise que el programa no se caiga si alguien escribe algo mal, así que valido todo antes de calcular:

- Que nombre, matrícula y carrera no estén vacíos.
- Que ninguna nota esté vacía.
- Que las notas sean números (si escribo letras, me avisa).
- Que cada nota esté entre 0 y su máximo (por ejemplo, prácticas no puede pasar de 40).

Si algo está mal, me sale una ventana de error con un mensaje que explica cuál es el problema.

## Cómo está hecho el código

Todo está en una sola clase, `CalculadoraNotas`, que hereda de `JFrame`. Las partes principales son:

- **El constructor**: crea la ventana, los campos de texto, las etiquetas y el botón, y los ordena con un `GridLayout`. También le puse colores, fuentes y un fondo azul claro para que se vea más bonita.
- **`crearEtiqueta()`**: un método que crea las etiquetas ya con estilo, para no repetir el mismo código muchas veces.
- **`calcularResultado()`**: el método que se ejecuta al pulsar el botón. Valida, suma las notas y decide si aprobó o reprobó.
- **`leerNota()`**: un método auxiliar que lee un campo, revisa que sea un número y que esté dentro del rango. Lo usé para no repetir la misma validación cuatro veces. Si algo está mal, lanza una excepción con un mensaje claro y el `catch` la muestra.

## Cómo ejecutarlo

Yo lo hice en NetBeans:

1. Crear un proyecto nuevo de tipo **Java Application** llamado `CalculadoraNotas`.
2. Pegar el código en la clase `CalculadoraNotas.java` (en el paquete `calculadoranotas`).
3. Hacer clic derecho en el archivo y elegir **Run File**.

## Pruebas que hice

| Prácticas | Parciales | Asignaciones | Examen | Resultado |
|---|---|---|---|---|
| 35 | 15 | 12 | 10 | 72, APROBADO |
| 20 | 10 | 10 | 10 | 50, REPROBADO |
| abc | 10 | 10 | 10 | Error: debe ser un número |
| 45 | 10 | 10 | 10 | Error: fuera de rango |
| (vacío) | 10 | 10 | 10 | Error: campo vacío |

## Lo que aprendí

Con este proyecto practiqué cómo armar una interfaz con Swing, cómo usar `GridLayout`, cómo manejar eventos de botones con `addActionListener` y cómo validar datos con `try/catch` y excepciones. También aprendí a separar el código en métodos para que sea más ordenado y fácil de leer.

## Autor

Matthews Batista
