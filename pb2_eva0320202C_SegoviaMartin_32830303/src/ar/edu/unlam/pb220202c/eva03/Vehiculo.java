package ar.edu.unlam.pb220202c.eva03;

public class Vehiculo implements Comparable<Vehiculo> {

	//Se debe crear contructeres getters y Setters y loos que crean convenientes
	private String Patente;
	private Integer VelocidadActual;
	private Integer limiteVelocidad;
	
	public Vehiculo(String patente, Integer velocidadActual, Integer limiteVelocidad) {
		super();
		Patente = patente;
		VelocidadActual = velocidadActual;
		this.limiteVelocidad = limiteVelocidad;
	}

	

	public String getPatente() {
		return Patente;
	}



	public void setPatente(String patente) {
		Patente = patente;
	}



	public Integer getVelocidadActual() {
		return VelocidadActual;
	}



	public void setVelocidadActual(Integer velocidadActual) {
		VelocidadActual = velocidadActual;
	}



	public Integer getLimiteVelocidad() {
		return limiteVelocidad;
	}



	public void setLimiteVelocidad(Integer limiteVelocidad) {
		this.limiteVelocidad = limiteVelocidad;
	}



	public void incrmentarVelocidad(Integer Velocidad) {
		
	}
	
	@Override
    public boolean equals(Object obj) {
        Vehiculo other = (Vehiculo) obj;
        return this.getPatente() == other.getPatente();
    }


	@Override
	public int compareTo(Vehiculo o) {
		return this.getPatente().compareTo(o.getPatente());
	}
}
