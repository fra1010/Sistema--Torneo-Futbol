package modelo;

public class Asistencia {
	private Jugador jugador;
	private int asistencias;
	
	
	public Asistencia(Jugador jugador, int asistencias) {
		super();
		this.jugador = jugador;
		this.asistencias = asistencias;
	}
	@Override
	public String toString() {
		return jugador.getApellido() + ", asistencias=" + asistencias + "\n";
	}
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public int getAsistencias() {
		return asistencias;
	}
	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}
	
	

}
