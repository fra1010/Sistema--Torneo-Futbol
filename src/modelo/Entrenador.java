package modelo;

import java.time.LocalDate;

public class Entrenador extends Persona {
	private int idEntrenador;
	private String estrategiaFavorita;

	public Entrenador(int idEntrenador, String apellido, String nombre, String dni, LocalDate fechaNacimiento,
			String estrategiaFavorita) throws Exception {
		super(nombre, apellido, dni, fechaNacimiento);
		this.idEntrenador = idEntrenador;
		this.setEstrategiaFavorita(estrategiaFavorita);
	}

	public int getIdEntrenador() {
		return idEntrenador;
	}

	public void setIdEntrenador(int idEntrenador) {
		this.idEntrenador = idEntrenador;
	}

	public String getEstrategiaFavorita() {
		return estrategiaFavorita;
	}

	public void setEstrategiaFavorita(String estrategiaFavorita) throws Exception {
		if (estrategiaFavorita == null) {
			throw new Exception("Error El entrenador no tiene estrategia");
		}
		this.estrategiaFavorita = estrategiaFavorita;
	}

}
