package it.objectmethod.jdbc.model;

public class Country {
	
	private String name;
	private double surfaceArea;
	private int population;
	private String countryCode;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSurfaceArea() {
		return surfaceArea;
	}
	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}