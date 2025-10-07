package modelo;

import java.time.LocalDate;


public class Jugador extends Persona {

	private int idJugador;
	private double estatura;
	private double peso;
	private String posicion;
	private int numeroCamiseta;

	public Jugador(int idJugador, String nombre, String apellido, String dni, LocalDate fechaNacimiento,
			double estatura, double peso, String posicion, int numeroCamiseta) throws Exception {
		super(nombre, apellido, dni, fechaNacimiento);
		this.idJugador = idJugador;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
		this.numeroCamiseta = numeroCamiseta;
	}

	@Override
	public String toString() {
		return "Jugador [idJugador=" + idJugador + ", estatura=" + estatura + ", peso=" + peso + ", posicion="
				+ posicion + ", numeroCamiseta=" + numeroCamiseta + "]";
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
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

	public void setNumeroCamiseta(int numeroCamiseta) throws Exception {
		if(numeroCamiseta < 0 && numeroCamiseta>99) throw new Exception("Error: El numero de la camiseta es invalido");
		this.numeroCamiseta = numeroCamiseta;
	}
	

}