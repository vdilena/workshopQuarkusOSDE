package torneo.futbol.equipo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EquipoRepository implements PanacheRepository<Equipo> {

}
