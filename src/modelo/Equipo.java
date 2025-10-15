package modelo;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Equipo {
	private int idEquipo;
	private LocalDate fechaFundacion;
	private String codigo;
	private String nombre;
	private List<Jugador> jugadores;
	private Entrenador entrenador;

	public Equipo(int idEquipo, LocalDate fechaFundacion, String nombre, Entrenador entrenador) {
		super();
		this.idEquipo = idEquipo;
		setCodigo(nombre);
		this.fechaFundacion = fechaFundacion;
		this.nombre = nombre;
		this.jugadores = new ArrayList<Jugador>();
		this.entrenador = entrenador;
	}

	public Equipo(Jugador jugador) {
		super();
		this.jugadores = new ArrayList<Jugador>();
	}

	public boolean tieneJugador(String dni) {
		for (Jugador j : jugadores)
			if (j.getDni().equals(dni))
				return true; // equals!
		return false;
	}

	public boolean agregarJugador(Jugador j) throws Exception {
		if (j == null)
			throw new Exception("Jugador nulo");
		if (tieneJugador(j.getDni()))
			throw new Exception("Jugador ya está en este equipo");
		// (opcional) validar número de camiseta único acá
		return jugadores.add(j);

	}

	@Override
	public String toString() {

		String retorno;

		if (this.getEntrenador() == null) {
			retorno = "\n\ncodigo=" + codigo + ", Nombre: " + nombre + "\n Lista de jugadores:\n" + jugadores
					+ " \nNo hay entrenador\n\n";
		} else
			retorno = "\n\ncodigo=" + codigo + ", Nombre: " + nombre + "\n Lista de jugadores:\n" + jugadores

					+ "  \nEntrenador: " + this.getEntrenador().getApellido() + " " + this.getEntrenador().getNombre()
					+ "\n\n";
		return retorno;

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

	public void setCodigo(String nombre) {

		if (nombre != null && nombre.length() >= 3) {
			// Toma las primeras 3 letras del nombre
			this.codigo = nombre.substring(0, 3).toUpperCase();
		} else if (nombre != null && nombre.length() < 3) {
			// Si el nombre tiene menos de 3 letras, usamos todo el nombre
			this.codigo = nombre.toUpperCase();
		} else {
			// Si el nombre es nulo, puedes lanzar una excepción o asignar un valor por
			// defecto
			this.codigo = "no tiene nombre"; // Valor por defecto, puedes cambiarlo según convenga
		}
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

	public LocalDate getFechaFundacion() {
		return fechaFundacion;
	}

	public void setFechaFundacion(LocalDate fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}

}
