package torneo.futbol.jugador;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import torneo.futbol.equipo.Equipo;
import torneo.futbol.equipo.EquipoRepository;

@Path("/jugador")
public class JugadorResource {

	@Inject
	JugadorRepository jugadorRepository;
	
	@Inject
	EquipoRepository equipoRepository;

	@GET
    public String hello() {
        return "Recurso de Jugador";
    }
	
	@GET
	@Path("/all")
    public List<Jugador> list() {
        return jugadorRepository.listAll();
    }
	
	@POST
    @Transactional
    public Response create(Jugador jugador) {
    	
		jugadorRepository.persist(jugador);
        return Response.ok(jugador).build();
    }
	
	@POST
    @Transactional
    @Path("/agregarAEquipo")
    public Response agregarJugador(Jugador jugador) {
		
		Jugador jugadorEncontrado = jugadorRepository.findById(jugador.getId());
        if(jugadorEncontrado == null) {
            throw new NotFoundException();
        }
        
        Equipo equipo = equipoRepository.findById(jugador.getEquipo().getId());
        if(equipo == null) {
            throw new NotFoundException();
        }
    	
        jugadorEncontrado.setEquipo(equipo);
        return Response.ok(jugador).build();
    }
}
