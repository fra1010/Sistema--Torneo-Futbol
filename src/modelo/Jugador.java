package modelo;

import java.time.LocalDate;

public class Jugador {
	
	private int idJugador;
	private String nombre;
	private String apellido;
	private String dni;
	private LocalDate fechaNacimiento;
	private double estatura;
	private double peso;
	private String posicion;
	private int numeroCamiseta;
	
	
	public Jugador(int idJugador, String nombre, String apellido, String dni, LocalDate fechaNacimiento,
			double estatura, double peso, String posicion, int numeroCamiseta) {
		super();
		this.idJugador = idJugador;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
		this.numeroCamiseta = numeroCamiseta;
	}
	@Override
	public String toString() {
		return "Jugador [idJugador=" + idJugador + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", fechaNacimiento=" + fechaNacimiento + ", estatura=" + estatura + ", peso=" + peso + ", posicion="
				+ posicion + ", numeroCamiseta=" + numeroCamiseta + "]\n";
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
	public double getEstatura() {
		return estatura;
	}
	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public int getNumeroCamiseta() {
		return numeroCamiseta;
	}
	public void setNumeroCamiseta(int numeroCamiseta) {
		this.numeroCamiseta = numeroCamiseta;
	}
	

	
	
	
	
	
	
	
}