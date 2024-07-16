package microservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import microservice.beans.Country;
import microservice.repositories.CountryRepository;
import microservice.services.CountryService;


@SpringBootTest(classes= {ServiceMockitoTest.class})
public class ServiceMockitoTest {

	@Mock
	CountryRepository countryrepo;
	
	@InjectMocks
	CountryService countryService;
	
	public List<Country> mycountries;
	
	
	@Test
	@Order(1)
	public void test_getAllCountries() 
	{
		List<Country> mycountries=new ArrayList<Country>();
		mycountries.add(new Country(1,"india","delhi"));
		mycountries.add(new Country(2,"nepal","ktm"));
		mycountries.add(new Country(3,"pakistan","asrafali"));
		
		
		when(countryrepo.findAll()).thenReturn(mycountries);//mocking data
		
		assertEquals(3, countryService.getAllCountries().size());
	}
	
	@Test
	@Order(2)
	public void test_getcountryById() {
		List<Country> mycountries=new ArrayList<Country>();
		mycountries.add(new Country(1,"india","delhi"));
		mycountries.add(new Country(2,"nepal","ktm"));
		mycountries.add(new Country(3,"pakistan","kabul"));
		int id=2;
		
		when(countryrepo.findAll()).thenReturn(mycountries);//mocking data
		
		assertEquals(id, countryService.getcountryById(id).getId());
		
	}
	
	@Test
	@Order(3)
	public void test_getCountryByName() {
		List<Country> mycountries=new ArrayList<Country>();
		mycountries.add(new Country (4,"indonosia", "manjur"));
		mycountries.add(new Country(1,"india","kubul"));
		mycountries.add(new Country(2,"nepal","hunxa"));
		mycountries.add(new Country(3,"pakistan","kubul"));
		String name="india";
		when(countryrepo.findAll()).thenReturn(mycountries);
		
		assertEquals(name, countryService.getcountryByName(name).getCountryName());
		
	}
	@Test
	@Order(4)
	public void test_addCountry() {
		
		Country country=new Country(5, "germany", "okay");
		
		
		when(countryrepo.save(country)).thenReturn(country);
	assertEquals(country,countryService.addCountry(country));
		
		
	}
	@Test
	@Order(5)
	public void test_updateCountry() {
		Country country=new Country(5, "germany", "okay");
		
		when(countryrepo.save(country)).thenReturn(country);
	assertEquals(country,countryService.updateCountry(country));

		
	
	}
//	@Test
//	@Order(6)
//	public void text_deleteCountry() {
//		Country country=new Country(5, "germany", "berlin");
//		
//		countryService.deleteCountry(country);
//		verify(countryrepo,times(1)).delete(country);//mocking and assert at single time 
//	}
	
}
