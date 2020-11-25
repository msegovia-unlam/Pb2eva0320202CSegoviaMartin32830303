package ar.edu.unlam.pb220202c.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Autopista {
	// Si es necesario Utilice herencia o implemente de Interfaces
	// Se debe crear contructeres getters y Setters y los atributos o metodos que
	// crean convenientes
	private HashMap<Integer, Vehiculo> telepase = new HashMap<Integer, Vehiculo>();
	private HashSet<Vehiculo> vehiculosEnCirculacion = new HashSet<Vehiculo>();
	private TreeSet<Vehiculo> infractores = new TreeSet<Vehiculo>();

	public Autopista() {
		super();
	}

	public void registrarTelepase(Integer numeroTelpase, Vehiculo vehiculo) {
		
		telepase.put(numeroTelpase, vehiculo);
	}

	public String obtenerTelepase(Integer numeroTelepase) {

		return telepase.get(numeroTelepase).getPatente();
	}

	public Boolean ingresarAutopista(Integer numeroTelepase) throws VehiculoNotFounException{
		// si el telepase no esta registrado lanza una Exceptios del tipo
		// VehiculoNotFounException
		// y no permite ingresar al autopista
		if(telepase.containsKey(numeroTelepase)) {
			Vehiculo vehiculo = telepase.get(numeroTelepase);
			return vehiculosEnCirculacion.add(vehiculo);	
		} else {
			throw new VehiculoNotFounException("Vehiculo no registrado!");
		}
		
	}

	public void salirAutpista(Vehiculo vehiculo) throws VehiculoNotFounException {
		// lanza Una exception VehiculoNotFounException si no esta en circulacion
		boolean enCirculacion = vehiculosEnCirculacion.contains(vehiculo);
		if (!enCirculacion) {
			throw new VehiculoNotFounException("El vehiculo no esta en circulacion");
		}
	}
	
	public boolean verificarExcesoVelocidad(Vehiculo vehiculo) {
		Boolean excedido = false;
		if(vehiculo.getVelocidadActual() > 100) {
			infractores.add(vehiculo);
			excedido = true;
		}		
		return excedido;
	}

	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente() {
		 Iterator<Vehiculo> it = infractores.iterator();
	     while(it.hasNext()){
	        System.out.println(it.next().getPatente());
	     }
		return infractores;
	}

	public Integer cantidadDeVehiculosENCirculacion() {

		return vehiculosEnCirculacion.size();
	}
	
}
