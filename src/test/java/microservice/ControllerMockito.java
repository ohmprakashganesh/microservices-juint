package microservice;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import microservice.beans.Country;
import microservice.controller.CountryController;
import microservice.services.CountryService;

@SpringBootTest(classes= {ControllerMockito.class})
public class ControllerMockito {

	@Mock
	CountryService countryService;
	@InjectMocks
	CountryController countryController;
	
	List<Country> mycountries;
	Country country;
	
	@Test
	@Order(1)
	public void test_getallcountries() {
		mycountries=new ArrayList<Country>();
		mycountries.add(new Country(1,"nepal","ktm"));
		mycountries.add(new Country(2,"bhutan", "thimpu"));
		
	when(countryService.getAllCountries()).thenReturn(mycountries);
	ResponseEntity<List<Country>> res=countryController.getCountries();

	assertEquals(HttpStatus.FOUND,res.getStatusCode());
	assertEquals(2,res.getBody().size());
	}
	
	@Test
	@Order(2)
	public void test_getcountrybyid() {	
	country =new Country(2,"nepal","ktm");
		int id=2;
		
		when(countryService.getcountryById(id)).thenReturn(country);
		ResponseEntity<Country> resp=countryController.getCountryById(id);
		
		assertEquals(HttpStatus.FOUND,resp.getStatusCode());
		assertEquals(id,resp.getBody().getId());
	}
	
	@Test
	@Order(3)
	public void test_getcountrybyname() {
		country=new Country(1,"nepal","ktm");
		String name="nepal";
		
		when(countryService.getcountryByName(name)).thenReturn(country);
		ResponseEntity<Country> resp= countryController.getCountrybyname(name);
		
		assertEquals(name,resp.getBody().getCountryName());
		assertEquals(HttpStatus.FOUND,resp.getStatusCode());
		
	}
	@Test
	@Order(4)
	public void test_addcountry() {
		country=new Country(1,"nepal","ktm");
		String name="nepal";
		when(countryService.addCountry(country)).thenReturn(country);
	  ResponseEntity<Country>resp=countryController.addCountry(country);
	  
	  assertEquals(name,resp.getBody().getCountryName());
	  assertEquals(HttpStatus.CREATED,resp.getStatusCode());

	}
	@Test
	@Order(5)
	public void test_updatecountry() {
		country=new Country(1,"nepal","ktm");
		int id=1;
		String name="nepal";
		
		when(countryService.getcountryById(id)).thenReturn(country);
		when(countryService.updateCountry(country)).thenReturn(country);

	ResponseEntity<Country>resp=countryController.updateCountry(id, country);
	
	assertEquals(name,resp.getBody().getCountryName());
	assertEquals(HttpStatus.CREATED,resp.getStatusCode());
		
	}
	
	@Test
	@Order(6)
	public void test_deletecountry() {
		country = new Country(1,"nepal","ktm");
		int id=1;
		when(countryService.getcountryById(id)).thenReturn(country);
		ResponseEntity<Country> resp=countryController.deleteCountry(id);
		assertEquals(HttpStatus.OK,resp.getStatusCode());
		
		
		
		
	}

}
