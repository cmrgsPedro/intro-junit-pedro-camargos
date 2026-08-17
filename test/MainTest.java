import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {

    private Main jogo;

    @BeforeEach
    public void inicializa() {
        jogo = new Main();
    }

    @Test
    public void deveEmpatarQuandoOsDoisEscolheremPapel() {
        assertEquals(0, jogo.jogar(1, 1));
    }

    @Test
    public void deveEmpatarQuandoOsDoisEscolheremPedra() {
        assertEquals(0, jogo.jogar(2, 2));
    }

    @Test
    public void deveEmpatarQuandoOsDoisEscolheremTesoura() {
        assertEquals(0, jogo.jogar(3, 3));
    }

    @Test
    public void jogadorUmDeveVencerComPapelContraPedra() {
        assertEquals(1, jogo.jogar(1, 2));
    }

    @Test
    public void jogadorUmDeveVencerComPedraContraTesoura() {
        assertEquals(1, jogo.jogar(2, 3));
    }

    @Test
    public void jogadorUmDeveVencerComTesouraContraPapel() {
        assertEquals(1, jogo.jogar(3, 1));
    }

    @Test
    public void jogadorDoisDeveVencerComPapelContraPedra() {
        assertEquals(2, jogo.jogar(2, 1));
    }

    @Test
    public void jogadorDoisDeveVencerComPedraContraTesoura() {
        assertEquals(2, jogo.jogar(3, 2));
    }

    @Test
    public void jogadorDoisDeveVencerComTesouraContraPapel() {
        assertEquals(2, jogo.jogar(1, 3));
    }

    @Test
    public void deveRetornarMenosUmQuandoJogadorUmEscolherZero() {
        assertEquals(-1, jogo.jogar(0, 1));
    }

    @Test
    public void deveRetornarMenosUmQuandoJogadorUmEscolherNumeroMaiorQueTres() {
        assertEquals(-1, jogo.jogar(4, 1));
    }

    @Test
    public void deveRetornarMenosUmQuandoJogadorDoisEscolherZero() {
        assertEquals(-1, jogo.jogar(1, 0));
    }

    @Test
    public void deveRetornarMenosUmQuandoJogadorDoisEscolherNumeroMaiorQueTres() {
        assertEquals(-1, jogo.jogar(1, 4));
    }
}
