package it.objectmethod.jdbc.model;

public class City {
	
	private String name;
	private int population;
	private boolean capital;
	
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
	
}
