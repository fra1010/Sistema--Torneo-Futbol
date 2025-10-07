package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Torneo {
	private int idTorneo;
	private String nombre;
	private String temporada;
	private List<Equipo> equipos;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private List<Partido> partidos;

	public Torneo(int idTorneo, String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) {
		super();
		this.idTorneo = idTorneo;
		this.nombre = nombre;
		this.temporada = temporada;
		this.equipos = new ArrayList<Equipo>();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.partidos = new ArrayList<Partido>();
	}

	public boolean agregarPartido(LocalDate fecha, Equipo equipoLocal, Equipo equipoVisitante, String estadio) {

		int id = 0;

		if (partidos.size() > 0) {
			int ultimoIndice = partidos.size() - 1;

			Partido ultimoPartido = partidos.get(ultimoIndice);
			id = ultimoPartido.getIdPartido();

		}

		Partido partidoAux = new Partido(id + 1, fecha, equipoLocal.getNombre(), equipoVisitante.getNombre(), estadio);

		return partidos.add(partidoAux);

	}

	public Partido traerPartidoId(int id) {

		int indice = 0;
		boolean encontrado = false;
		Partido partidoAux = null;

		if (!partidos.isEmpty()) {

			while (indice < partidos.size() && !encontrado) {
				if (partidos.get(indice).getIdPartido() == id) {
					encontrado = true;
					partidoAux = partidos.get(indice);
				}
				indice++;
			}

		}
		return partidoAux;
	}

	public boolean tieneEquipo(int idEquipo) {
		for (Equipo j : equipos)
			if (j.getIdEquipo() == idEquipo)
				return true; // equals!
		return false;
	}

	public boolean agregarEquipo(Equipo j) throws Exception {
		if (j == null)
			throw new Exception("Equipo nulo");
		if (tieneEquipo(j.getIdEquipo()))
			throw new Exception("Equipo ya está en este Torneo");
		// (opcional) validar número de camiseta único acá
		equipos.add(j);
		return true;
	}

	@Override
	public String toString() {
		return "Torneo [idTorneo=" + idTorneo + ", nombre=" + nombre + ", temporada=" + temporada + ", equipos="
				+ equipos + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", partidos=" + partidos + "]";
	}

	public int getIdTorneo() {
		return idTorneo;
	}

	public void setIdTorneo(int idTorneo) {
		this.idTorneo = idTorneo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

}
