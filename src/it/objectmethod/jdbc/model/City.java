package it.objectmethod.jdbc.model;

public class City {

	private int id;
	private String name;
	private int population;
	private boolean capital;
	private String countryCode;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public boolean isCapital() {
		return capital;
	}
	public void setCapital(boolean isCapital) {
		this.capital = isCapital;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}
