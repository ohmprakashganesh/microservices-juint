package microservice.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import microservice.beans.Country;
import microservice.controller.AddResponse;
import microservice.repositories.CountryRepository;

@Component
@Service
public class CountryService {

	 @Autowired
	 CountryRepository countryrep;
	
	
	 public List<Country> getAllCountries() {
		List<Country> country= countryrep.findAll();
		return country;
		
	}
	
	 public Country getcountryById(int id) {
		 Country country=null;
		 List<Country> countries=countryrep.findAll();
		 for(Country con: countries) {
			 if(con.getId()== id) {
				 country=con;
			 }
		 }
		return country;
		
	 }
	 
	 public Country getcountryByName(String name) {
		 Country country=null;
		List <Country> Countries =countryrep.findAll();
		for(Country con:Countries) {
			if(con.getCountryName().equalsIgnoreCase(name)){
			country =con;
			
			}
			
		}
		return country;
		
	 }
	 public Country addCountry(Country country) {
		 country.setId(getMaxId());
		 countryrep.save(country);
		 return country;
		 
		
	 }
	 public int getMaxId() {
		return countryrep.findAll().size()+1;
		
	 }
	 public Country updateCountry(Country country) {
		 countryrep.save(country);
		 return country;
		
	 }
//	 public AddResponse deleteCountry(int id) {
//		 countryrep.deleteById(id);
//		 AddResponse rs=new AddResponse();
//		 rs.setMessage("country is deleted" );
//		 rs.setId(id);
//		 return rs;
//		
//	 }
	 
//	 this is for testing easy 
	 public void deleteCountry(Country country) {
		 countryrep.delete(country);
	 }
}
