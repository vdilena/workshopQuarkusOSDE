package torneo.futbol.equipo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import torneo.futbol.jugador.Jugador;

@Entity
public class Equipo {

	@Id @GeneratedValue private Long id;
	private String nombre;
	private String directorTecnico;
	private String nombreEstadio;
	private String direccionEstadio;
	
	@OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Jugador> jugadores = new ArrayList<Jugador>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreEstadio() {
		return nombreEstadio;
	}
	public void setNombreEstadio(String nombreEstadio) {
		this.nombreEstadio = nombreEstadio;
	}
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDirectorTecnico() {
		return directorTecnico;
	}
	public void setDirectorTecnico(String directorTecnico) {
		this.directorTecnico = directorTecnico;
	}
	public String getNommbreEstadio() {
		return nombreEstadio;
	}
	public void setNommbreEstadio(String nommbreEstadio) {
		this.nombreEstadio = nommbreEstadio;
	}
	public String getDireccionEstadio() {
		return direccionEstadio;
	}
	public void setDireccionEstadio(String direccionEstadio) {
		this.direccionEstadio = direccionEstadio;
	}
}
