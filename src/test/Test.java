package test;

import java.time.LocalDate;
import modelo.*;

public class Test {

	public static void main(String[] args) {
		
		Sistema sys= new Sistema();
		
		try {
			LocalDate fechaActual = LocalDate.now();
			sys.agregarJugador("Ricado","Bochini","10896458",LocalDate.of(1956, 1, 25),1.68, 67, "Delantero", 10 );
			
			sys.agregarJugador("Romelu","Lukaku","36896458",LocalDate.of(1993, 5, 13),1.91, 93, "Delantero", 9 );
			
			sys.agregarJugador("Martin","Palermo","30896458",LocalDate.of(1973, 10, 7),1.91, 93, "Delantero", 9 );
			
			//sys.agregarJugador(1,"Ricado","Bochini","10896458",fechaActual,1.68, 67, "Delantero", 10 );
			
			sys.agregarEntrenador("Sabella","Alejandro ","10896451",fechaActual,"Defensivo" );
			sys.agregarEntrenador("Guardiola","Pep","10896452",fechaActual,"tiki taka" );
			sys.agregarEntrenador("Basile","Coco","1896452",fechaActual,"futbol champan" );
			sys.agregarEntrenador("Simeone","Diego","20896451",fechaActual,"Defensivo" );
			
			System.out.println(sys.getJugadores());
			System.out.println(sys.getEntrenadores());
			
			System.out.println("LISTA FECHA NACIMIENTO:");
			
			System.out.println(sys.listaPorFechaNacimiento(LocalDate.of(1955, 1, 25), fechaActual));
			
			System.out.println(sys.listaTacticaPreferida("Defensivo"));
			
			sys.borrarJugador(3);
			
			sys.borrarEntrenador(3);
			sys.agregarEquipo("Lns", "Lanus", sys.traerEntrenadorId(1));
			
			//sys.agregarJugadorEquipo(sys.traerJugadorDni("10896458"), 1);
			
			sys.agregarEquipo("Ban", "Banfield", sys.traerEntrenadorId(2));
			
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		
		}
		
		System.out.println(sys.getJugadores());
		System.out.println(sys.getEntrenadores());
		System.out.println(sys.getEquipos());
	}

}
