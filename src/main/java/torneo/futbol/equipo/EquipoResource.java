package torneo.futbol.equipo;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/equipo")
public class EquipoResource {
	
	@Inject
	EquipoRepository equipoRepository;

	@GET
    public String hello() {
        return "Recurso de Equipo";
    }
	
	@GET
	@Path("/all")
    public List<Equipo> list() {
        return equipoRepository.listAll();
    }

	@POST
    @Transactional
    public Response create(Equipo equipo) {
    	
		equipoRepository.persist(equipo);
        return Response.ok(equipo).build();
    }
}
