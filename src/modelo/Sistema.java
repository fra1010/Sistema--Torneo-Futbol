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
	
	


	
	
	public boolean agregarEntrenador(String nombre, String apellido, String dni, LocalDate fechaNacimiento,
			String estrategiaFavorita)throws Exception {
		
		Entrenador entrenadorABuscar= traerEntrenadorDni(dni) ;
		
		if(entrenadorABuscar!=null) throw new Exception("Error, ya existe un entrenador con dni:"+ dni );
		
		int id=0;
		
		if(entrenadores.size()>0) {
			int ultimoIndice= entrenadores.size()-1;
			
			Entrenador ultimoEntrenador= entrenadores.get(ultimoIndice);
			id= ultimoEntrenador.getIdEntrenador();
				
		}
		
		Entrenador entrenadorAux= new Entrenador(id+1, nombre,apellido,dni,fechaNacimiento,estrategiaFavorita);
		
		return entrenadores.add(entrenadorAux);
		
	
	}
	
	
	
	public boolean agregarJugador(String nombre, String apellido, String dni, LocalDate fechaNacimiento,
			double estatura, double peso, String posicion, int numeroCamiseta)throws Exception {
		
		Jugador jugadorABuscar= traerJugadorDni(dni) ;
		
		if(jugadorABuscar!=null) throw new Exception("Error, ya existe un jugador con dni:"+ dni );
		
		int id=0;
		
		if(jugadores.size()>0) {
			int ultimoIndice= jugadores.size()-1;
			
			Jugador ultimoJugador= jugadores.get(ultimoIndice);
			id= ultimoJugador.getIdJugador();
				
		}
		
		Jugador jugadorAux= new Jugador(id+1,nombre,apellido,dni,fechaNacimiento,estatura,peso,posicion,numeroCamiseta);
		
		return jugadores.add(jugadorAux);
		
	
	}
	
	
	public Jugador traerJugadorId(int id) {
		
		int indice= 0;
		boolean encontrado = false;
		Jugador jugadorAux=null;
		
		if (!jugadores.isEmpty()) {
			
			while(indice<jugadores.size()&& !encontrado) {
				if(jugadores.get(indice).getIdJugador()==id) {
					encontrado = true;
					jugadorAux= jugadores.get(indice);
				}
				indice++;
			}
		
		}
		return jugadorAux;
	}
	
	public Entrenador traerEntrenadorDni(String dni) {
		
		int indice= 0;
		boolean encontrado = false;
		Entrenador entrenadorAux=null;
		
		if (!entrenadores.isEmpty()) {
			
			while(indice<entrenadores.size()&& !encontrado) {
				if(entrenadores.get(indice).getDni()==dni) {
					encontrado = true;
					entrenadorAux= entrenadores.get(indice);
				}
				indice++;
			}
		
		}
		return entrenadorAux;
	}
	
	
	
	
	public Jugador traerJugadorDni(String dni) {
		
		int indice= 0;
		boolean encontrado = false;
		Jugador jugadorAux=null;
		
		if (!jugadores.isEmpty()) {
			
			while(indice<jugadores.size()&& !encontrado) {
				if(jugadores.get(indice).getDni()==dni) {
					encontrado = true;
					jugadorAux= jugadores.get(indice);
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
