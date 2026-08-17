import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import carrinho.Carrinho;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoChatGPTTest {

    private Carrinho carrinho;

    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();
    }

    @Test
    public void deveIniciarComCarrinhoVazio() {
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    public void deveAdicionarUmProduto() {
        Produto livro = new Produto("Livro", 100.00);

        carrinho.addItem(livro);

        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(100.00, carrinho.getValorTotal(), 0.001);
    }

    @Test
    public void deveCalcularTotalDeVariosProdutos() {
        carrinho.addItem(new Produto("Livro", 100.00));
        carrinho.addItem(new Produto("Caderno", 25.50));
        carrinho.addItem(new Produto("Caneta", 4.50));

        assertEquals(3, carrinho.getQtdeItems());
        assertEquals(130.00, carrinho.getValorTotal(), 0.001);
    }

    @Test
    public void deveRemoverProdutoExistente() throws ProdutoNaoEncontradoException {
        Produto livro = new Produto("Livro", 100.00);
        carrinho.addItem(livro);

        carrinho.removeItem(livro);

        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    public void deveAtualizarTotalAposRemoverProduto() throws ProdutoNaoEncontradoException {
        Produto livro = new Produto("Livro", 100.00);
        Produto caderno = new Produto("Caderno", 25.50);
        carrinho.addItem(livro);
        carrinho.addItem(caderno);

        carrinho.removeItem(livro);

        assertEquals(25.50, carrinho.getValorTotal(), 0.001);
    }

    @Test
    public void deveLancarExcecaoAoRemoverProdutoInexistente() {
        Produto livro = new Produto("Livro", 100.00);

        assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(livro));
    }

    @Test
    public void deveEsvaziarCarrinho() {
        carrinho.addItem(new Produto("Livro", 100.00));
        carrinho.addItem(new Produto("Caderno", 25.50));

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    public void devePermitirAdicionarProdutoRepetido() {
        Produto livro = new Produto("Livro", 100.00);

        carrinho.addItem(livro);
        carrinho.addItem(livro);

        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(200.00, carrinho.getValorTotal(), 0.001);
    }

    @Test
    public void deveRemoverProdutoComMesmoNome() throws ProdutoNaoEncontradoException {
        carrinho.addItem(new Produto("Livro", 100.00));

        carrinho.removeItem(new Produto("Livro", 50.00));

        assertEquals(0, carrinho.getQtdeItems());
    }
}
