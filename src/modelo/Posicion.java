package modelo;

public class Posicion {

	private Equipo equipo;
	private int puntos;

	public Posicion(Equipo equipo, int puntos) {
		super();
		this.equipo = equipo;
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return  equipo.getNombre() + ", puntos=" + puntos + "\n";
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public int getPuntaje() {
		return puntos;
	}

	public void setPuntaje(int puntaje) {
		this.puntos = puntaje;
	}

}
