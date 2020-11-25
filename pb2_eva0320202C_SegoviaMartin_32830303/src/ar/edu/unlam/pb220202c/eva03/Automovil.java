package ar.edu.unlam.pb220202c.eva03;

public class Automovil extends Vehiculo{
	
	public Automovil(String patente, Integer velocidadActual, Integer limiteVelocidad) {
		super(patente, velocidadActual, limiteVelocidad);
		// TODO Auto-generated constructor stub
	}

	private Integer velocidadLimite = 130;

	public Integer getVelocidadLimite() {
		return velocidadLimite;
	}

		
	//Si es necesario Utilice herencia o implemente de Interfaces
//	Se debe crear contructeres getters y Setters y loos que crean convenientes
	
//el Limite de velociadad para autos es de 130km
//en caso que supere dicho limite el este sera multado

	
	
   
	
}
