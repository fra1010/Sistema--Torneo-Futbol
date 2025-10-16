package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Jugador> jugadores;
	private List<Entrenador> entrenadores;
	private List<Equipo> equipos;
	private List<Torneo> torneos;

	public Sistema() {
		super();
		this.jugadores = new ArrayList<Jugador>();
		this.entrenadores = new ArrayList<Entrenador>();
		this.equipos = new ArrayList<Equipo>();
		this.torneos = new ArrayList<Torneo>();
	}
	
	
	
	public int totalAsistenciasJugador(int idTorneo, Jugador jugador) {
		Torneo torneoAux = traerTorneoId(idTorneo);

		int asistencias = 0;

		for (Partido p : torneoAux.getPartidos()) {

			for (Estadistica e : p.getEstadisticas()) {
				if (e.getJugador().equals(jugador)) {

					asistencias += e.getAsistencias();
				}
			}

		}

		return asistencias;

	}

	
	
	public int totalGolesJugador(int idTorneo, Jugador jugador) {
		Torneo torneoAux = traerTorneoId(idTorneo);

		int goles = 0;

		for (Partido p : torneoAux.getPartidos()) {

			for (Estadistica e : p.getEstadisticas()) {
				if (e.getJugador().equals(jugador)) {

					goles += e.getGoles();
				}
			}

		}

		return goles;

	}

	public List<Posicion> generarTablaPosiciones(int idTorneo) {
		Torneo torneoAux = traerTorneoId(idTorneo);

		List<Posicion> tablaPosiciones = new ArrayList<Posicion>();

		for (Equipo e : torneoAux.getEquipos()) {
			int puntaje = calcularPuntosEquipo(idTorneo, e.getNombre());
			tablaPosiciones.add(new Posicion(e, puntaje));
		}

		tablaPosiciones.sort((p1, p2) -> Integer.compare(p2.getPuntaje(), p1.getPuntaje()));

		return tablaPosiciones;
	}

	public int calcularPuntosEquipo(int idTorneo, String nombreEquipo) {
		Torneo torneo = traerTorneoId(idTorneo);

		int puntos = 0;

		for (Partido p : torneo.getPartidos()) {

			int golesLocal = 0;
			int golesVisitante = 0;

			for (Estadistica e : p.getEstadisticas()) {
				Jugador jugador = e.getJugador();
				String equipoJugador = buscarEquipoDeJugador(jugador);

				if (equipoJugador.equalsIgnoreCase(p.getEquipoLocal())) {
					golesLocal += e.getGoles();
				} else if (equipoJugador.equalsIgnoreCase(p.getEquipoVisitante())) {
					golesVisitante += e.getGoles();
				}
			}

			if (p.getEquipoLocal().equalsIgnoreCase(nombreEquipo)) {
				if (golesLocal > golesVisitante) {
					puntos += 3;
				} else if (golesLocal == golesVisitante) {
					puntos += 1;
				}
			} else if (p.getEquipoVisitante().equalsIgnoreCase(nombreEquipo)) {
				if (golesVisitante > golesLocal) {
					puntos += 3;
				} else if (golesVisitante == golesLocal) {
					puntos += 1;
				}
			}
		}

		return puntos;
	}

	public List<Equipo> equiposFundadosAntesQue(LocalDate fechaFin) {
		List<Equipo> equiposAux = new ArrayList<Equipo>();

		for (Equipo e : equipos) {
			if (e.getFechaFundacion().isBefore(fechaFin)) {
				equiposAux.add(e);

			}

		}

		return equiposAux;
	}

	public List<Ganador> generarGanadores(int idTorneo, LocalDate fechaPartido) {
		Torneo torneoAux = traerTorneoId(idTorneo);

		List<Ganador> ganadores = new ArrayList<Ganador>();

		for (Partido p : torneoAux.getPartidos()) {
			if (p.getFecha().equals(fechaPartido)) {
				int golesLocal = 0;
				int golesVisitante = 0;
				for (Estadistica e : p.getEstadisticas()) {
					Jugador jugadorAux = e.getJugador();
					String equipoJugador = buscarEquipoDeJugador(jugadorAux);

					if (equipoJugador.equalsIgnoreCase(p.getEquipoLocal())) {
						golesLocal += e.getGoles();
					} else if (equipoJugador.equalsIgnoreCase(p.getEquipoVisitante())) {
						golesVisitante += e.getGoles();

					}
				}

				String equipoGanador = null;
				int golesGanador = 0;

				if (golesLocal > golesVisitante) {
					equipoGanador = p.getEquipoLocal();
					golesGanador = golesLocal;
				} else if (golesVisitante > golesLocal) {
					equipoGanador = p.getEquipoVisitante();
					golesGanador = golesVisitante;
				}

				if (equipoGanador != null) {// Crear objeto Ganador solamente si hay un ganador
					ganadores.add(new Ganador(p.getFecha(), equipoGanador, golesGanador));
				}

			}
		}
		return ganadores;

	}

	public String buscarEquipoDeJugador(Jugador jugador) { // util para otros metodos
		for (Equipo e : equipos) {
			if (e.getJugadores().contains(jugador)) {
				return e.getNombre();
			}
		}
		return null;
	}

	public String equipoConMayorAlturaPromedio(int idTorneo) throws Exception {
		Torneo torneo = traerTorneoId(idTorneo);
		if (torneo == null)
			throw new Exception("Error no existe torneo con ese id");

		List<Equipo> equiposTorneo = torneo.getEquipos();
		if (equiposTorneo == null || equiposTorneo.isEmpty())
			throw new Exception("Error el torneo no tiene equipos");

		Equipo equipoMayorPromedio = null;
		double mayorPromedio = 0;

		for (Equipo e : equiposTorneo) {
			if (e.getJugadores() == null || e.getJugadores().isEmpty())
				continue;

			double promedio = calcularPromedioAlturaEquipo(e.getIdEquipo());
			if (equipoMayorPromedio == null || promedio > mayorPromedio) {
				mayorPromedio = promedio;
				equipoMayorPromedio = e;
			}
		}

		if (equipoMayorPromedio == null)
			throw new Exception("Error no hay equipos validos");

		return equipoMayorPromedio.getNombre();
	}

	public double calcularPromedioAlturaEquipo(int idEquipo) throws Exception {
		Equipo equipo = traerEquipoId(idEquipo);
		if (equipo == null)
			throw new Exception("Error no existe equipo con ese id.");

		List<Jugador> jugadores = equipo.getJugadores();
		if (jugadores.isEmpty())
			throw new Exception("Error el equipo no tiene jugadores.");

		double sum = 0;
		for (Jugador j : jugadores) {
			sum = j.getEstatura() + sum;
		}

		return sum / jugadores.size();
	}

	public boolean agregarTorneo(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) {

		int id = 0;

		if (torneos.size() > 0) {
			int ultimoIndice = torneos.size() - 1;

			Torneo ultimoTorneo = torneos.get(ultimoIndice);
			id = ultimoTorneo.getIdTorneo();

		}

		Torneo torneoAux = new Torneo(id + 1, nombre, temporada, fechaInicio, fechaFin);

		return torneos.add(torneoAux);

	}

	public boolean agregarEquipoATorneo(String nombreEquipo, int idTorneo) throws Exception {
		Torneo torneo = traerTorneoId(idTorneo);
		if (torneo == null)
			throw new Exception("No existe torneo");

		Equipo equipo = traerEquipoNombre(nombreEquipo);
		if (equipo == null)
			throw new Exception("No existe equipo");

		return torneo.agregarEquipo(equipo);
	}

	public List<Jugador> listaPorFechaNacimiento(LocalDate inicio, LocalDate fin) {

		List<Jugador> jugadoresAux = new ArrayList<Jugador>();

		for (Jugador j : jugadores) {
			if(((j.getFechaNacimiento().isAfter(inicio)|| j.getFechaNacimiento().equals(inicio))
					&&(j.getFechaNacimiento().isBefore(fin) ||j.getFechaNacimiento().equals(fin)))) {
				jugadoresAux.add(j);
			}

		}

		return jugadoresAux;
	}

	public List<Entrenador> listaTacticaPreferida(String tactica) {

		List<Entrenador> entrenadoresAux = new ArrayList<Entrenador>();

		for (Entrenador e : entrenadores) {
			if (e.getEstrategiaFavorita().equalsIgnoreCase(tactica)) {
				entrenadoresAux.add(e);
			}

		}

		return entrenadoresAux;
	}

	public Torneo traerTorneoId(int id) {

		int indice = 0;
		boolean encontrado = false;
		Torneo TorneoAux = null;

		if (!torneos.isEmpty()) {

			while (indice < torneos.size() && !encontrado) {
				if (torneos.get(indice).getIdTorneo() == id) {
					encontrado = true;
					TorneoAux = torneos.get(indice);
				}
				indice++;
			}

		}
		return TorneoAux;
	}

	public boolean borrarJugadorEquipo(int idjugador, int idEquipo) throws Exception {

		Equipo equipoABuscar = traerEquipoId(idEquipo);
		Jugador jugadorABuscar = traerJugadorId(idjugador);

		if (equipoABuscar == null)
			throw new Exception("No existe ese equipo");

		if (jugadorABuscar == null)
			throw new Exception("No existe ese jugador");

		return equipos.get(idEquipo - 1).getJugadores().remove(jugadorABuscar);
	}

	public void borrarEntrenadorEquipo(int idEquipo) throws Exception {

		Equipo equipoABuscar = traerEquipoId(idEquipo);

		if (equipoABuscar == null)
			throw new Exception("No existe ese equipo");
		if (equipoABuscar.getEntrenador() == null) {
			throw new Exception("Este equipo no tiene entrenador asignado.");
		}

		equipoABuscar.setEntrenador(null);
	}

	public boolean agregarJugadorAEquipo(String dniJugador, int idEquipo) throws Exception {
		Equipo equipo = traerEquipoId(idEquipo);
		if (equipo == null)
			throw new Exception("No existe equipo");

		Jugador jugador = traerJugadorDni(dniJugador);
		if (jugador == null)
			throw new Exception("No existe jugador");

		for (Equipo e : equipos)
			if (e.tieneJugador(dniJugador))
				throw new Exception("El jugador ya pertenece a " + e.getCodigo());

		return equipo.agregarJugador(jugador);
	}

	public boolean borrarEquipo(int id) throws Exception {

		Equipo equipoABuscar = traerEquipoId(id);

		if (equipoABuscar == null)
			throw new Exception("Error, el entrenador no existe");

		return equipos.remove(equipoABuscar);
	}

	public Equipo traerEquipoId(int id) {

		int indice = 0;
		boolean encontrado = false;
		Equipo equipoAux = null;

		if (!equipos.isEmpty()) {

			while (indice < equipos.size() && !encontrado) {
				if (equipos.get(indice).getIdEquipo() == id) {
					encontrado = true;
					equipoAux = equipos.get(indice);
				}
				indice++;
			}

		}
		return equipoAux;
	}

	public Equipo traerEquipoNombre(String nombre) {

		int indice = 0;
		boolean encontrado = false;
		Equipo equipoAux = null;

		if (!equipos.isEmpty()) {

			while (indice < equipos.size() && !encontrado) {
				if (equipos.get(indice).getNombre().equalsIgnoreCase(nombre)) {
					encontrado = true;
					equipoAux = equipos.get(indice);
				}
				indice++;
			}

		}

		return equipoAux;
	}

	public boolean agregarEquipo(String nombre, LocalDate fechaFundacion, Entrenador entrenador) {

		int id = 0;

		if (equipos.size() > 0) {
			int ultimoIndice = equipos.size() - 1;

			Equipo ultimoEquipo = equipos.get(ultimoIndice);
			id = ultimoEquipo.getIdEquipo();

		}

		Equipo equipoAux = new Equipo(id + 1, fechaFundacion, nombre, entrenador);

		return equipos.add(equipoAux);

	}

	public boolean borrarEntrenador(int id) throws Exception {

		Entrenador entrenadorABuscar = traerEntrenadorId(id);

		if (entrenadorABuscar == null)
			throw new Exception("Error, el entrenador no existe");

		return entrenadores.remove(entrenadorABuscar);
	}

	public boolean agregarEntrenador(String nombre, String apellido, String dni, LocalDate fechaNacimiento,
			String estrategiaFavorita) throws Exception {

		Entrenador entrenadorABuscar = traerEntrenadorDni(dni);

		if (entrenadorABuscar != null)
			throw new Exception("Error, ya existe un entrenador con dni:" + dni);

		int id = 0;

		if (entrenadores.size() > 0) {
			int ultimoIndice = entrenadores.size() - 1;

			Entrenador ultimoEntrenador = entrenadores.get(ultimoIndice);
			id = ultimoEntrenador.getIdEntrenador();

		}

		Entrenador entrenadorAux = new Entrenador(id + 1, nombre, apellido, dni, fechaNacimiento, estrategiaFavorita);

		return entrenadores.add(entrenadorAux);

	}

	public Entrenador traerEntrenadorDni(String dni) {

		int indice = 0;
		boolean encontrado = false;
		Entrenador entrenadorAux = null;

		if (!entrenadores.isEmpty()) {

			while (indice < entrenadores.size() && !encontrado) {
				if (entrenadores.get(indice).getDni() == dni) {
					encontrado = true;
					entrenadorAux = entrenadores.get(indice);
				}
				indice++;
			}

		}
		return entrenadorAux;
	}

	public Entrenador traerEntrenadorId(int id) {

		int indice = 0;
		boolean encontrado = false;
		Entrenador entrenadorAux = null;

		if (!entrenadores.isEmpty()) {

			while (indice < entrenadores.size() && !encontrado) {
				if (entrenadores.get(indice).getIdEntrenador() == id) {
					encontrado = true;
					entrenadorAux = entrenadores.get(indice);
				}
				indice++;
			}

		}
		return entrenadorAux;
	}

	public boolean borrarJugador(int id) throws Exception {

		Jugador jugadorABuscar = traerJugadorId(id);

		if (jugadorABuscar == null)
			throw new Exception("Error, el jugador no existe");

		return jugadores.remove(jugadorABuscar);
	}

	public boolean agregarJugador(String nombre, String apellido, String dni, LocalDate fechaNacimiento,
			double estatura, double peso, String posicion, int numeroCamiseta) throws Exception {

		Jugador jugadorABuscar = traerJugadorDni(dni);

		if (jugadorABuscar != null)
			throw new Exception("Error, ya existe un jugador con dni:" + dni);

		int id = 0;

		if (jugadores.size() > 0) {
			int ultimoIndice = jugadores.size() - 1;

			Jugador ultimoJugador = jugadores.get(ultimoIndice);
			id = ultimoJugador.getIdJugador();

		}

		Jugador jugadorAux = new Jugador(id + 1, nombre, apellido, dni, fechaNacimiento, estatura, peso, posicion,
				numeroCamiseta);

		return jugadores.add(jugadorAux);

	}

	public Jugador traerJugadorId(int id) {

		int indice = 0;
		boolean encontrado = false;
		Jugador jugadorAux = null;

		if (!jugadores.isEmpty()) {

			while (indice < jugadores.size() && !encontrado) {
				if (jugadores.get(indice).getIdJugador() == id) {
					encontrado = true;
					jugadorAux = jugadores.get(indice);
				}
				indice++;
			}

		}
		return jugadorAux;
	}

	public Jugador traerJugadorDni(String dni) { // usar equals en strings

		int indice = 0;
		boolean encontrado = false;
		Jugador jugadorAux = null;

		if (!jugadores.isEmpty()) {

			while (indice < jugadores.size() && !encontrado) {
				if (jugadores.get(indice).getDni().equals(dni)) {
					encontrado = true;
					jugadorAux = jugadores.get(indice);
				}
				indice++;
			}

		}
		return jugadorAux;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public List<Entrenador> getEntrenadores() {
		return entrenadores;
	}

	public void setEntrenadores(List<Entrenador> entrenadores) {
		this.entrenadores = entrenadores;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public List<Torneo> getTorneos() {
		return torneos;
	}

	public void setTorneos(List<Torneo> torneos) {
		this.torneos = torneos;
	}

}
