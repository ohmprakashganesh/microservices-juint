package microservice.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Country {
	
	@Id
	@Column(name="cid")
	int id;
	@Column(name="cname")
	String countryName;
	@Column(name="capital")
	String countryCapital;
	
	
	public int getId() {
		return id;
	}
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Country(int id, String countryName, String countryCapital) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.countryCapital = countryCapital;
	}
	public void setId(int id) {
		this.id = id;
		
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCapital() {
		return countryCapital;
	}
	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}

}
