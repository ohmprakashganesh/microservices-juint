package microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import microservice.beans.Country;
import microservice.services.CountryService;

@RestController
@RequestMapping
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@GetMapping("/getallcountries")
	public ResponseEntity<List<Country>> getCountries(){
		try {
		List<Country> countries= countryService.getAllCountries();
		return new ResponseEntity<List <Country>>(countries, HttpStatus.FOUND);
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	@GetMapping("/getcountry/{cid}")
	public ResponseEntity<Country >getCountryById(@PathVariable(value="cid") int cid){
		try {
			Country country= countryService.getcountryById(cid);
			 return new ResponseEntity<Country>(country, HttpStatus.FOUND);
			}catch(Exception ex) {
				 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}
	

	
	@GetMapping("/getcountries/countryname")
	public ResponseEntity<Country> getCountrybyname(@RequestParam(value="name") String countryName){
		try {
		Country country= countryService.getcountryByName(countryName);
		 return new ResponseEntity<Country>(country, HttpStatus.FOUND);
		}catch(Exception ex) {
			 return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/addcountry")
	public ResponseEntity<Country> addCountry(@RequestBody Country country) {
		try {
			country=countryService.addCountry(country);
			return new ResponseEntity<Country>(country,HttpStatus.CREATED);
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
        
	}
	
	@PostMapping("/updatecountry")
	public  ResponseEntity<Country> updateCountry(@PathVariable(value="id") int id, @RequestBody Country country) {
	try {
		
	
		Country existcountry=	countryService.getcountryById(id);
	if(existcountry!= null) {
		existcountry.setCountryCapital(country.getCountryCapital());
		existcountry.setCountryName(country.getCountryName());
		Country xcountry=countryService.updateCountry(existcountry);
		 return new ResponseEntity<Country>(xcountry, HttpStatus.CREATED);


	}
	}catch(Exception ex) {
		
	}
	
	 return new ResponseEntity<>( HttpStatus.NOT_FOUND);

           
	}
	@DeleteMapping("/deletecountry/{id}")
	public ResponseEntity<Country> deleteCountry(@PathVariable("id") int id) {
		Country country=null;
		try {
			country=countryService.getcountryById(id);
			countryService.deleteCountry(country);
			
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	return new  ResponseEntity<Country>(country,HttpStatus.OK);
	}
	
	
	
}
