package modelo;
import java.util.List;
import java.util.ArrayList;


public class Equipo {
	private int idEquipo;
	private String codigo;
	private String nombre;
	private List<Jugador> jugadores;
	private Entrenador entrenador;
	
	public Equipo(int idEquipo, String codigo, String nombre, Entrenador entrenador) {
		super();
		this.idEquipo = idEquipo;
		this.codigo = codigo;
		this.nombre = nombre;
		this.jugadores = new ArrayList<Jugador>();
		this.entrenador = entrenador;
	}
	
	public Equipo(Jugador jugador) {
		super();
		this.jugadores = new ArrayList<Jugador>();
	}
	
	
	
	public boolean tieneJugador(String dni) {
	    for (Jugador j : jugadores) if (j.getDni().equals(dni)) return true; // equals!
	    return false;
	}

	public boolean agregarJugador(Jugador j) throws Exception {
	    if (j == null) throw new Exception("Jugador nulo");
	    if (tieneJugador(j.getDni())) throw new Exception("Jugador ya está en este equipo");
	    // (opcional) validar número de camiseta único acá
	    jugadores.add(j);
	    return true;
	}
	
	
	
	
	@Override
	public String toString() {
		return  "\n" + ", codigo=" + codigo + ", Nombre: " + nombre + "\n Lista de jugadores:\n" + jugadores
				+ "  \nEntrenador: " + this.getEntrenador().getApellido()+" "+ this.getEntrenador().getNombre()+ "\n";
	}
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	public Entrenador getEntrenador() {
		return entrenador;
	}
	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}
	
	
}
