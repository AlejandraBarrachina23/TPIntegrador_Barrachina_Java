package Negocio;

public interface IAlumno {
	
	public int calcularNota(int parcial, int recuperatorio);
	public float calcularPromedio(int notaUno, int notaDos);
	public String EstadoAlumno(float promedio);

}