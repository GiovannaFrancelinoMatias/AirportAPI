package local.gih.airports.repositories;

import java.util.List;
import local.gih.airports.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sesideva
 */
public interface AirportRepository extends JpaRepository<Airport, Long> {
    
    List<Airport> findByCityIgnoreCase(String city);

}
