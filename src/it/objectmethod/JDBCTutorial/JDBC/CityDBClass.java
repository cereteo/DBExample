package it.objectmethod.JDBCTutorial.JDBC;

public class CityDBClass {
	
	String Name;
	String District;
	int Population;
	
	public CityDBClass(String name, String district, int population) {
		setName(name);
		setDistrict(district);
		setPopulation(population);
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public int getPopulation() {
		return Population;
	}
	public void setPopulation(int population) {
		Population = population;
	}
	
	
	

}
