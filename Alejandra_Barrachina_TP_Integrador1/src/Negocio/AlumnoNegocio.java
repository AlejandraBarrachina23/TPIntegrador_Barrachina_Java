package Negocio;

public class AlumnoNegocio implements IAlumno {

	
	public int calcularNota(int parcial, int recuperatorio) {
		
		if(parcial>recuperatorio) return parcial;
		else return recuperatorio;
	}

	public float calcularPromedio(int notaUno, int notaDos) {
		
		return (notaUno+notaDos)/2;
	}

	public String EstadoAlumno(float promedio) {
		
		if(promedio>=8) return "Promociona";
		else if(promedio>=6 && promedio<8) return "Regulariza";
		else return "Recursa";
	}

}