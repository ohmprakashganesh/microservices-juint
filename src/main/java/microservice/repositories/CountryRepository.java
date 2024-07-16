package microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import microservice.beans.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
	

}
