package torneo.futbol.jugador;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JugadorRepository implements PanacheRepository<Jugador> {

}
