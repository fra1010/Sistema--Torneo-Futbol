package modelo;

import java.time.LocalDate;

public class Ganador {
	private LocalDate fecha;
	private String  equipoGanador;
	private int cantidadDeGoles;

	public Ganador(LocalDate fecha, String equipoGanador, int cantidadDeGoles) {
		
		this.fecha = fecha;
		this.equipoGanador = equipoGanador;
		this.cantidadDeGoles = cantidadDeGoles;
	}
	
	
	

	@Override
	public String toString() {
		 return "Fecha: " + fecha + "  Ganador: " + equipoGanador + "  Goles: " + cantidadDeGoles+"\n";
	}




	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getEquipoGanador() {
		return equipoGanador;
	}

	public void setEquipoGanador(String equipoGanador) {
		this.equipoGanador = equipoGanador;
	}

	public int getCantidadDeGoles() {
		return cantidadDeGoles;
	}

	public void setCantidadDeGoles(int cantidadDeGoles) {
		this.cantidadDeGoles = cantidadDeGoles;
	}
	
	
	
	
}