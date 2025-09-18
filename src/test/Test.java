package test;

import java.time.LocalDate;
import modelo.*;

public class Test {

	public static void main(String[] args) {
		
		Sistema sys= new Sistema();
		
		try {
			
			sys.agregarJugador("Ricado","Bochini","10896458",LocalDate.of(1954, 1, 25),1.68, 67, "Delantero", 10 );//id:1
			
			sys.agregarJugador("Romelu","Lukaku","36896458",LocalDate.of(1993, 5, 13),1.91, 93, "Delantero", 9 );//id:2
			
			sys.agregarJugador("Martin","Palermo","30896458",LocalDate.of(1973, 10, 7),1.91, 93, "Delantero", 9 );//id:3
			
			sys.agregarJugador("Franck","Ribéry ","10896468",LocalDate.now(),1.68, 67, "Delantero", 7 );//id:4
			
			sys.agregarEntrenador("Sabella","Alejandro ","10896451",LocalDate.now(),"Defensivo" );
			sys.agregarEntrenador("Guardiola","Pep","10896452",LocalDate.now(),"tiki taka" );
			sys.agregarEntrenador("Basile","Coco","1896452",LocalDate.now(),"futbol champan" );
			sys.agregarEntrenador("Simeone","Diego","20896451",LocalDate.now(),"Defensivo" );
			
			
			
			
			System.out.println("LISTA FECHA NACIMIENTO:");
			
			System.out.println(sys.listaPorFechaNacimiento(LocalDate.of(1960, 1, 25), LocalDate.now()));
			
			System.out.println("LISTA TACTICA PREFERIDA:");
			
			System.out.println(sys.listaTacticaPreferida("Defensivo"));
			
			sys.agregarEquipo("Lns", "Lanus", sys.traerEntrenadorId(1));//id:1 
			
			//sys.agregarJugadorEquipo(sys.traerJugadorDni("10896458"), 1);
			
			sys.agregarEquipo("Ban", "Banfield", sys.traerEntrenadorId(2));//id:2
			sys.agregarJugadorEquipo(sys.traerJugadorId(3), 1);
			sys.agregarJugadorEquipo(sys.traerJugadorId(1), 2);
			sys.agregarJugadorEquipo(sys.traerJugadorId(2), 2);
			sys.agregarJugadorEquipo(sys.traerJugadorId(4), 1);
			System.out.println(sys.getEquipos());
			sys.borrarJugadorEquipo(1, 2);
			sys.borrarJugadorEquipo(4, 1);
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		
		}
		
		System.out.println(sys.getEquipos());
	}

}
