package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Persona {
	private String nombre;
	private String apellido;
	private String dni;
	private LocalDate fechaNacimiento;

	public Persona(String nombre, String apellido, String dni, LocalDate fechaNacimiento) throws Exception {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.setDni(dni);
		this.setFechaNacimiento(fechaNacimiento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
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

	public void setDni(String dni) throws Exception {

		String strValido = dni.replaceAll("[^0-9]", "");

		if (strValido.length() < 7 || strValido.length() > 8)
			throw new Exception("Error el dni es invalido");

		this.dni = strValido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) throws Exception {
		if (fechaNacimiento == null)
			throw new Exception("Error la fecha de nacimiento no puede estar vacia");
		if ((LocalDate.now().getYear() - fechaNacimiento.getYear()) < 18)
			throw new Exception("Error La persona es menor edad");
		this.fechaNacimiento = fechaNacimiento;
	}

}
