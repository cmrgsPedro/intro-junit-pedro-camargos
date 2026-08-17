import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calculadora.Calculadora;

public class CalculadoraChatGPTTest {

    private Calculadora calculadora;

    @BeforeEach
    public void inicializa() {
        calculadora = new Calculadora();
    }

    @Test
    public void deveSomarDoisNumerosPositivos() {
        assertEquals(9, calculadora.soma(4, 5));
    }

    @Test
    public void deveSomarNumeroPositivoENegativo() {
        assertEquals(2, calculadora.soma(5, -3));
    }

    @Test
    public void deveSubtrairDoisNumeros() {
        assertEquals(6, calculadora.subtracao(10, 4));
    }

    @Test
    public void deveRetornarResultadoNegativoNaSubtracao() {
        assertEquals(-5, calculadora.subtracao(3, 8));
    }

    @Test
    public void deveMultiplicarDoisNumeros() {
        assertEquals(15, calculadora.multiplicacao(3, 5));
    }

    @Test
    public void deveRetornarZeroAoMultiplicarPorZero() {
        assertEquals(0, calculadora.multiplicacao(9, 0));
    }

    @Test
    public void deveDividirDoisNumeros() {
        assertEquals(2, calculadora.divisao(8, 4));
    }

    @Test
    public void deveRealizarDivisaoInteira() {
        assertEquals(2, calculadora.divisao(5, 2));
    }

    @Test
    public void deveLancarExcecaoAoDividirPorZero() {
        assertThrows(ArithmeticException.class, () -> calculadora.divisao(8, 0));
    }

    @Test
    public void deveCalcularSomatoriaDeNumeroPositivo() {
        assertEquals(15, calculadora.somatoria(5));
    }

    @Test
    public void deveRetornarZeroNaSomatoriaDeZero() {
        assertEquals(0, calculadora.somatoria(0));
    }

    @Test
    public void deveRetornarZeroNaSomatoriaDeNumeroNegativo() {
        assertEquals(0, calculadora.somatoria(-3));
    }

    @Test
    public void deveIdentificarNumeroPositivo() {
        assertTrue(calculadora.ehPositivo(7));
    }

    @Test
    public void deveConsiderarZeroComoPositivo() {
        assertTrue(calculadora.ehPositivo(0));
    }

    @Test
    public void deveIdentificarNumeroNegativo() {
        assertFalse(calculadora.ehPositivo(-1));
    }

    @Test
    public void deveRetornarZeroAoCompararNumerosIguais() {
        assertEquals(0, calculadora.compara(5, 5));
    }

    @Test
    public void deveRetornarUmQuandoPrimeiroNumeroForMaior() {
        assertEquals(1, calculadora.compara(9, 2));
    }

    @Test
    public void deveRetornarMenosUmQuandoPrimeiroNumeroForMenor() {
        assertEquals(-1, calculadora.compara(2, 9));
    }
}
