package model;

import java.time.LocalDate;

public class Ingreso {
	//attributes
	private double ingreso;
	private String descripcion;
	private LocalDate date;
	
	
	//relations
	
	//methods
	public Ingreso(double ingreso, String descripcion, LocalDate date) {
		this.ingreso = ingreso;
		this.descripcion = descripcion;
		this.date = date;
	}
	
	
	
	public double getIngreso() {
		return ingreso;
	}

	public void setIngreso(double ingreso) {
		this.ingreso = ingreso;
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
