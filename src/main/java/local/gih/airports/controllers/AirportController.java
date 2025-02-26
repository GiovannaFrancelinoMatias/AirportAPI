package local.gih.airports.controllers;

import java.util.List;
import local.gih.airports.entities.Airport;
import local.gih.airports.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesideva
 */
@RestController
public class AirportController {
    
    @Autowired
    private AirportService airportService;
    
    @GetMapping("/airport")
    public List<Airport> findAll(){
        List<Airport> result = airportService.findAll();
        return result;
    }
    
    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<Airport>> findByCityIgnoreCase(@PathVariable String cityName){
        List<Airport> result = airportService.findByCity(cityName);
        
        if (result.isEmpty()){
            return ResponseEntity.notFound().build();
            
        }else{ 
            
            return ResponseEntity.ok(result);
        }
      
    }
}
