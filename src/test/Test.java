package test;

import java.time.LocalDate;
import modelo.*;

public class Test {

	public static void main(String[] args) {
		
		Sistema sys= new Sistema();
		
		try {
			LocalDate fechaActual = LocalDate.now();
			sys.agregarJugador("Ricado","Bochini","10896458",fechaActual,1.68, 67, "Delantero", 10 );
			
			sys.agregarJugador("Romelu","Lukaku","36896458",fechaActual,1.91, 93, "Delantero", 9 );
			
			//sys.agregarJugador(1,"Ricado","Bochini","10896458",fechaActual,1.68, 67, "Delantero", 10 );
			
			sys.agregarEntrenador(1,"Sabella","Alejandro ","10896451",fechaActual,"Defensivo" );
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		
		}
		
		System.out.println(sys.getJugadores());
		System.out.println(sys.getEntrenadores());
	}

}
