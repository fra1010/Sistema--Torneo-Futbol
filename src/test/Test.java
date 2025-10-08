package test;

import java.time.LocalDate;
import modelo.*;

public class Test {

	public static void main(String[] args) {

		Sistema sys = new Sistema();

		try {
			// Jugadores (fechas válidas para 18+)
			sys.agregarJugador("Ricado", "Bochini", "10896458", LocalDate.of(1954, 1, 25), 1.67, 67, "Delantero", 10); // id:1

			sys.agregarJugador("Romelu", "Lukaku", "36896458", LocalDate.of(1993, 5, 13), 1.91, 93, "Delantero", 9); // id:2

			sys.agregarJugador("Martin", "Palermo", "30896458", LocalDate.of(1973, 10, 7), 1.91, 93, "Delantero", 9); // id:3

			sys.agregarJugador("Franck", "Ribéry", "10896468", LocalDate.of(1983, 4, 7), 1.68, 67, "Delantero", 7); // id:4
																													

			// Entrenadores
			sys.agregarEntrenador("Sabella", "Alejandro", "10896451", LocalDate.of(1954, 11, 5), "Defensivo");
			sys.agregarEntrenador("Guardiola", "Pep", "10896452", LocalDate.of(1971, 1, 18), "tiki taka");
			sys.agregarEntrenador("Basile", "Coco", "1896452", LocalDate.of(1943, 11, 1), "futbol champan");
			sys.agregarEntrenador("Simeone", "Diego", "20896451", LocalDate.of(1970, 4, 28), "Defensivo");

			/*
			 * System.out.println("LISTA FECHA NACIMIENTO:");
			 * System.out.println(sys.listaPorFechaNacimiento(LocalDate.of(1960, 1, 25),
			 * LocalDate.now()));
			 * 
			 * System.out.println("LISTA TACTICA PREFERIDA:");
			 * System.out.println(sys.listaTacticaPreferida("Defensivo"));
			 */

			// Equipos (CAMBIO: pasar DNI del DT)
			sys.agregarEquipo("Lanus", sys.traerEntrenadorId(1)); // id:1
			// sys.agregarJugadorAEquipo("10896458", 1); // ejemplo por DNI (opcional)

			sys.agregarEquipo("Banfield", sys.traerEntrenadorId(2)); // id:2

			// Asignar jugadores a equipos (CAMBIO: usar método por DNI)
			sys.agregarJugadorAEquipo("30896458", 1); // Palermo -> Lanus
			sys.agregarJugadorAEquipo("10896458", 2); // Bochini -> Banfield
			sys.agregarJugadorAEquipo("36896458", 2); // Lukaku -> Banfield
			sys.agregarJugadorAEquipo("10896468", 1); // Ribéry -> Lanus

			// System.out.println(sys.getEquipos());

			// Borrar jugador de equipo (se mantiene igual, por idJugador e idEquipo)
			//sys.borrarJugadorEquipo(1, 2); // saca a Bochini (id=1) de Banfield (id=2)
			//sys.borrarJugadorEquipo(4, 1); // saca a Ribéry (id=4) de Lanus (id=1)
			sys.borrarEntrenadorEquipo(1);

			sys.agregarTorneo("torneo1", "invierno", LocalDate.of(1993, 5, 13), LocalDate.of(1994, 5, 13));

			sys.agregarEquipoATorneo("Banfield", 1);
			sys.agregarEquipoATorneo("Lanus", 1);
			System.out.println(sys.getEquipos());
			System.out.println(sys.calcularPromedioAlturaEquipo(1));
			System.out.println(sys.calcularPromedioAlturaEquipo(2));
			System.out.println(sys.equipoConMayorAlturaPromedio(1));

		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(sys.getTorneos()); // MUESTRA EL TORNEO CON SUS RESPECTIVOS EQUIPOS
		//System.out.println(sys.getEquipos());
	}
}