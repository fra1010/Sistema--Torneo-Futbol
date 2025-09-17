Laboratorio Grupal 2025: Sistema Torneo de Fútbol
El complejo de canchas de fútbol La Redonda está planeando organizar campeonatos de
fútbol, para ello necesitan un sistema que permita su gestión.

Hito 1: Capa de datos (Semana 5)

Diseñar las clases datos y una clase de negocio sistema para gestionar torneos de fútbol.
Considerar que el sistema debe relevar la siguiente información:
Se realizan diferentes tipos de torneos de duración variable. De cada torneo se deben conocer:
el nombre del torneo, temporada (primavera, verano, etc), los equipos participantes y la fecha
de inicio y fin.
Para cada equipo se debe contar con nombre del equipo, un código único formado por tres
letras del nombre, los jugadores que lo conforman y el entrenador. Se debe conocer de
jugadores y entrenadores: apellido, nombre, dni y fecha de nacimiento. Además para los
jugadores se debe registrar estatura, peso, posición y número de camiseta (tener cuenta que
un jugador debe ser mayor de edad). Del entrenador se debe registrar la estrategia favorita.
Por otra parte el sistema necesita un registro estadístico de cada jugador con la siguiente
información de su participación en un partido: cantidad de goles, asistencias y minutos que
jugó.
De cada partido se registran, fecha, los dos equipos local y visitante y en un estadio.
El sistema deberá poder manejar información sobre todos los jugadores,
 entrenadores,
equipos y torneos así como vincularlos con sus respectivos partidos.

Hito 2: Casos de uso (Semana 6)
●​●​●​Definir firma de los CUs
Implementarlos en la clase que corresponda del modelo
Testear en el paquete test cada CU

Nota: implementar cada CU en el modelo y testear. Recuerden que para los exámenes se
evalúa la implementación de modelo y test cada CU, en el caso que no se implemente el test
no acredita puntos el CU.

1.​ Generar todos los métodos para que se puedan agregar elementos a todas las
listas.

2.​ Generar los métodos eliminar solo si necesarios (física o lógica) elementos a
todas las listas por regla de negocio. Por ejemplo baja a un jugador del equipo.

3.​ Generar todos los métodos traer por atributo único (o id)

4.​ Traer para un torneo y un número de fecha, la lista de los equipos ganadores
utilizando una clase (Ganador, no se persiste es solo para generar reporte) con
fecha, el equipo ganador, cantidad de goles

5.​ Búsqueda de entrenadores: Crear un método que, dada una táctica preferida,
devuelva una lista de todos los entrenadores que la utilicen.

6.​ Búsqueda de jugadores por fecha de nacimiento: Implementar una método que
retorne una lista de jugadores nacidos entre dos fechas dadas.

7.​ Búsqueda de equipos por fecha de fundación: Desarrollar un método que devuelva
una lista de equipos fundados antes de una fecha específica.

8.​ Cálculo de altura promedio de equipo: Escribir un método que calcule y retorne la
altura promedio de un equipo.

9.​ Identificación de equipo con mayor altura promedio: Crear un método que devuelva
el objeto Equipo con la mayor altura promedio en el torneo.

10.​Cálculo de puntos de equipo: Implementar un método que calcule y retorne el total de
puntos acumulados por un equipo, considerando 3 puntos por victoria y 1 por empate.

11.​Generación de tabla de posiciones: Desarrollar un método que retorne una lista de
(Posicion, no se persiste es solo para generar reporte) que contenga equipo y puntaje,
ordenada de mayor a menor puntaje (utilizando ordenamiento de listas nativo o
desarrollando el algoritmo de algún método de ordenamiento).

12.​Cálculo de goles por jugador: Escribir un método que, dado un objeto Jugador,
devuelva el total de goles que ha logrado en el torneo.

13.​Cálculo de asistencias por jugador: Escribir un método que, dado un objeto Jugador,
devuelva el total de asistencias que ha logrado en el torneo.

14.​Generación de tabla de goleadores: Crear un método que retorne una lista de
(Goleador, no se persiste es solo para generar reporte) con el jugador y los goles,
ordenada de mayor a menor (utilizando ordenamiento de listas nativo o desarrollando el
algoritmo de algún método de ordenamiento).

15.​Generación de tabla de asistidores: Implementar un método que retorne una lista de
(Asistencia, no se persiste es solo para generar reporte) con el jugador y sus
asistencias, ordenada de mayor a menor (utilizando ordenamiento de listas nativo o
desarrollando el algoritmo de algún método de ordenamiento).
