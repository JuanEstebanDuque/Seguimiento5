package model;

import java.time.LocalDate;

public class Gasto {
	//attributes
	private double gasto;
	private String descripcion;
	private LocalDate date;
	
	
	//relations
	
	//methods
	public Gasto(double gasto, String descripcion, LocalDate date) {
		this.gasto = gasto;
		this.descripcion = descripcion;
		this.date = date;
	}
	
	public double getGasto() {
		return gasto;
	}

	public void setGasto(double gasto) {
		this.gasto = gasto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
}
