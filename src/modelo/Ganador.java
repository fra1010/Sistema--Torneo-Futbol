package modelo;

import java.time.LocalDate;

public class Ganador {
	private LocalDate fecha;
	private Equipo equipoGanador;
	private int cantidadDeGoles;

	public Ganador(LocalDate fecha, Equipo equipoGanador, int cantidadDeGoles) {
		
		this.fecha = fecha;
		this.equipoGanador = equipoGanador;
		this.cantidadDeGoles = cantidadDeGoles;
	}
	
	

	@Override
	public String toString() {
		return "Ganador [fecha=" + fecha + ", equipoGanador=" + equipoGanador + ", cantidadDeGoles=" + cantidadDeGoles
				+ "]";
	}



	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Equipo getEquipoGanador() {
		return equipoGanador;
	}

	public void setEquipoGanador(Equipo equipoGanador) {
		this.equipoGanador = equipoGanador;
	}

	public int getCantidadDeGoles() {
		return cantidadDeGoles;
	}

	public void setCantidadDeGoles(int cantidadDeGoles) {
		this.cantidadDeGoles = cantidadDeGoles;
	}
	
	

}
