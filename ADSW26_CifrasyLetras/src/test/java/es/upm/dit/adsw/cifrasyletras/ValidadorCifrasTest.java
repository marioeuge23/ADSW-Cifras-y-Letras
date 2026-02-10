package es.upm.dit.adsw.cifrasyletras;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.upm.dit.adsw.cifrasyletras.juego.ValidadorCifras;

class ValidadorCifrasTest {

	@Test
	public void testEsValida() {
		ValidadorCifras validador = new ValidadorCifras();
		List<Integer> numerosDisponibles = Arrays.asList(25, 50, 75, 3, 6, 8);
		String expresion = "952 = 50 + 75 - 6 * 8";
		assertTrue(validador.esValida(expresion, numerosDisponibles));
	}

}
