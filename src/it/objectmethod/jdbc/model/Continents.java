package it.objectmethod.jdbc.model;

public class Continents {
	private String continent;
	private double totSurfaceArea;
	private long  totPopulation;
	
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public double getTotSurfaceArea() {
		return totSurfaceArea;
	}
	public void setTotSurfaceArea(double totSurfaceArea) {
		this.totSurfaceArea = totSurfaceArea;
	}
	public long getTotPopulation() {
		return totPopulation;
	}
	public void setTotPopulation(long totPopulation) {
		this.totPopulation = totPopulation;
	}
	
	
}
