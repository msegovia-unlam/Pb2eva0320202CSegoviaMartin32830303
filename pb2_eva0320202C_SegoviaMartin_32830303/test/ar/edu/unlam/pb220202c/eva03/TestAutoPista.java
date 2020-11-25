package ar.edu.unlam.pb220202c.eva03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

public class TestAutoPista {

	@Test
	public void queSePuedaRegistrarTelepase() {
		Autopista autopista = new Autopista();
		Automovil auto1 = new Automovil("abc123", 100, 120);

		autopista.registrarTelepase(1, auto1);

		assertEquals("abc123", autopista.obtenerTelepase(1));
	}

	@Test(expected = VehiculoNotFounException.class)
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFounException{
		
			Autopista autopista = new Autopista();
			Automovil auto1 = new Automovil("abc123", 100, 120);
			Automovil auto2 = new Automovil("xyz123", 100, 120);
			
			autopista.registrarTelepase(1, auto1);
			autopista.ingresarAutopista(1);
			autopista.salirAutpista(auto1);
			autopista.salirAutpista(auto2);
		
	}

	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente() throws VehiculoNotFounException {
		Autopista autopista = new Autopista();
		Automovil auto1 = new Automovil("abc123", 180, 120);
		Automovil auto2 = new Automovil("xyz123", 190, 120);
		Automovil auto3 = new Automovil("ghj456", 170, 120);
		Integer ve = 3;
		
		autopista.registrarTelepase(1, auto1);
		autopista.registrarTelepase(2, auto2);
		autopista.registrarTelepase(3, auto3);
		autopista.ingresarAutopista(1);
		autopista.ingresarAutopista(2);
		autopista.ingresarAutopista(3);
		autopista.verificarExcesoVelocidad(auto1);
		autopista.verificarExcesoVelocidad(auto2);
		autopista.verificarExcesoVelocidad(auto3);
		autopista.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente();
		
	}

	@Test
	public void queObtengaCantidadDeVehiculosEnCirulacion() throws VehiculoNotFounException {
		Autopista autopista = new Autopista();
		Automovil auto1 = new Automovil("abc123", 100, 120);
		Automovil auto2 = new Automovil("xyz123", 100, 120);
		Automovil auto3 = new Automovil("ghj456", 100, 120);
		Integer ve = 3;
		
		autopista.registrarTelepase(1, auto1);
		autopista.registrarTelepase(2, auto2);
		autopista.registrarTelepase(3, auto3);
		autopista.ingresarAutopista(1);
		autopista.ingresarAutopista(2);
		autopista.ingresarAutopista(3);
		
		
		assertEquals(ve, autopista.cantidadDeVehiculosENCirculacion());
		
	}
	
	@Test
	public void queUnAutoEsteExcedidoDeVelocidad() {
		Autopista autopista = new Autopista();
		Automovil auto1 = new Automovil("abc123", 100, 120);
		
		auto1.setVelocidadActual(110);
		
		assertTrue(autopista.verificarExcesoVelocidad(auto1));
		
	}
}
