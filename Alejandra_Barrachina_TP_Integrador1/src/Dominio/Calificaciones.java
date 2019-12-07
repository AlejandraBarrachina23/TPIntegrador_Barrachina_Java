package Dominio;

public class Calificaciones {
	
	private int parcialUno;
	private int parcialDos;
	private int recuperatorioUno;
	private int recuperatorioDos;
	private String Estado;
	private int LegajoAlumno;
	
	public int getLegajoAlumno() {
		return LegajoAlumno;
	}
	public void setLegajoAlumno(int legajoAlumno) {
		LegajoAlumno = legajoAlumno;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public int getParcialUno() {
		return parcialUno;
	}
	public void setParcialUno(int parcialUno) {
		this.parcialUno = parcialUno;
	}
	public int getParcialDos() {
		return parcialDos;
	}
	public void setParcialDos(int parcialDos) {
		this.parcialDos = parcialDos;
	}
	public int getRecuperatorioUno() {
		return recuperatorioUno;
	}
	public void setRecuperatorioUno(int recuperatorioUno) {
		this.recuperatorioUno = recuperatorioUno;
	}
	public int getRecuperatorioDos() {
		return recuperatorioDos;
	}
	public void setRecuperatorioDos(int recuperatorioDos) {
		this.recuperatorioDos = recuperatorioDos;
	}
	
}
