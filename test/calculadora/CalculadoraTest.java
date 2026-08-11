package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

	private Calculadora calculadora;

	@BeforeEach
	public void inicializa() {
		calculadora = new Calculadora();
	}

	@Test
	public void deveSomarDoisNumeros() {
		assertEquals(9, calculadora.soma(4, 5));
	}

	@Test
	public void deveSubtrairDoisNumeros() {
		assertEquals(6, calculadora.subtracao(10, 4));
	}

	@Test
	public void deveMultiplicarDoisNumeros() {
		assertEquals(15, calculadora.multiplicacao(3, 5));
	}

	@Test
	public void deveDividirDoisNumeros() {
		assertEquals(2, calculadora.divisao(8, 4));
	}

	@Test
	public void deveLancarExcecaoAoDividirPorZero() {
		assertThrows(ArithmeticException.class,
				() -> calculadora.divisao(8, 0));
	}

	@Test
	public void deveCalcularSomatoria() {
		assertEquals(10, calculadora.somatoria(4));
	}

	@Test
	public void deveIdentificarNumeroPositivo() {
		assertTrue(calculadora.ehPositivo(5));
	}

	@Test
	public void deveIdentificarNumeroNegativo() {
		assertFalse(calculadora.ehPositivo(-2));
	}

	@Test
	public void deveRetornarZeroAoCompararNumerosIguais() {
		assertEquals(0, calculadora.compara(5, 5));
	}

	@Test
	public void deveRetornarUmQuandoPrimeiroNumeroForMaior() {
		assertEquals(1, calculadora.compara(8, 3));
	}

	@Test
	public void deveRetornarMenosUmQuandoPrimeiroNumeroForMenor() {
		assertEquals(-1, calculadora.compara(3, 8));
	}
}
