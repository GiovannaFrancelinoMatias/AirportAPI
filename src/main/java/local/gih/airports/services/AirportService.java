package local.gih.airports.services;


import local.gih.airports.repositories.AirportRepository;
import java.util.List;
import local.gih.AirportMinDTO.AirportMinDTO;
import local.gih.AirportMinDTO.AirportNearMeDTO;
import local.gih.airports.entities.Airport;
import local.gih.airports.projections.AirportNearMeProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sesideva
 */
@Service
public class AirportService {
    
    @Autowired
    private AirportRepository airportRepository;
    
    public List<Airport> findAll() {
        
        List<Airport> result = airportRepository.findAll();
        
        return result;
    }
    
    public List<Airport> findByCity(String city) {
        List<Airport> result = airportRepository.findByCityIgnoreCase(city);
        return result;
    }
    
    public List<AirportMinDTO> finByCountry(String country){
        List<Airport> resultAirport = airportRepository.findByCountryIgnoreCase(country);
        
        List<AirportMinDTO> resultDTO = resultAirport.stream()
                .map(x -> new AirportMinDTO (x)).toList();
        
        return resultDTO;
    }

    public List<AirportMinDTO> findByCountry(String countryName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Airport findByIataCode(String iataCode){
        Airport result = airportRepository.findByIataCode(iataCode);
        return result;
    }
    
    public List<AirportNearMeDTO> findNearMe(double latitude, double longitude){
        List<AirportNearMeProjection> resultNearAirports = airportRepository.findNearMe(latitude, longitude);
        
        List<AirportNearMeDTO> resultDTO = resultNearAirports.stream()
                .map(x -> new AirportNearMeDTO(x)).toList();
        
        return resultDTO;
    }
}
