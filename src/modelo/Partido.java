package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Partido {
	private int idPartido;
	private LocalDate fecha;
	private String equipoLocal;
	private String equipoVisitante;
	private String estadio;
	private List<Estadistica> estadisticas;

	public void agregarEstadistica(Estadistica estadistica) {

		estadisticas.add(estadistica);
	}

	public Partido(int idPartido, LocalDate fecha, String equipoLocal, String equipoVisitante, String estadio)
			throws Exception {

		this.idPartido = idPartido;
		this.fecha = fecha;
		this.equipoLocal = equipoLocal;
		this.setEquipoVisitante(equipoVisitante);
		this.estadio = estadio;
		this.estadisticas = new ArrayList<Estadistica>();
	}

	@Override
	public String toString() {
		return "Partido [idPartido=" + idPartido + ", fecha=" + fecha + ", equipoLocal=" + equipoLocal
				+ ", equipoVisitante=" + equipoVisitante + ", estadio=" + estadio + ", estadisticas=" + estadisticas
				+ "]";
	}

	public int getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(String equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public String getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(String equipoVisitante) throws Exception {

		if (equipoVisitante.equals(equipoLocal))
			throw new Exception("Error el equipo local y visitante son el mismo");
		this.equipoVisitante = equipoVisitante;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public List<Estadistica> getEstadisticas() {
		return estadisticas;
	}

	public void setEstadisticas(List<Estadistica> estadisticas) {
		this.estadisticas = estadisticas;
	}

}
