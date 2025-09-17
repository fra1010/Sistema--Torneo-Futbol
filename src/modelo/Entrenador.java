package modelo;

import java.time.LocalDate;

public class Entrenador {
	private int idJugador;
	private String nombre;
	private String apellido;
	private String dni;
	private LocalDate fechaNacimiento;
	private String estrategiaFavorita;
	
	
	public Entrenador(int idJugador, String nombre, String apellido, String dni, LocalDate fechaNacimiento,
			String estrategiaFavorita) {
		super();
		this.idJugador = idJugador;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.estrategiaFavorita = estrategiaFavorita;
	}



	public int getIdJugador() {
		return idJugador;
	}



	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public String getEstrategiaFavorita() {
		return estrategiaFavorita;
	}



	public void setEstrategiaFavorita(String estrategiaFavorita) {
		this.estrategiaFavorita = estrategiaFavorita;
	}



	@Override
	public String toString() {
		return "Entrenador [idJugador=" + idJugador + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", fechaNacimiento=" + fechaNacimiento + ", estrategiaFavorita=" + estrategiaFavorita + "]";
	}
	
	
	
}
