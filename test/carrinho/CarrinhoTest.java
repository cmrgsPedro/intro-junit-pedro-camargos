package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {

	private Carrinho carrinho;

	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
	}

	@Test
	public void deveIniciarVazio() {
		assertEquals(0, carrinho.getQtdeItems());
		assertEquals(0.0, carrinho.getValorTotal(), 0.001);
	}

	@Test
	public void deveAdicionarProduto() {
		Produto livro = new Produto("Livro", 100.00);

		carrinho.addItem(livro);

		assertEquals(1, carrinho.getQtdeItems());
	}

	@Test
	public void deveCalcularValorTotal() {
		Produto livro = new Produto("Livro", 100.00);
		Produto caderno = new Produto("Caderno", 25.00);

		carrinho.addItem(livro);
		carrinho.addItem(caderno);

		assertEquals(125.00, carrinho.getValorTotal(), 0.001);
	}

	@Test
	public void deveRemoverProduto() throws ProdutoNaoEncontradoException {
		Produto livro = new Produto("Livro", 100.00);
		carrinho.addItem(livro);

		carrinho.removeItem(livro);

		assertEquals(0, carrinho.getQtdeItems());
	}

	@Test
	public void deveLancarExcecaoAoRemoverProdutoInexistente() {
		Produto livro = new Produto("Livro", 100.00);

		assertThrows(ProdutoNaoEncontradoException.class,
				() -> carrinho.removeItem(livro));
	}

	@Test
	public void deveEsvaziarCarrinho() {
		carrinho.addItem(new Produto("Livro", 100.00));
		carrinho.addItem(new Produto("Caderno", 25.00));

		carrinho.esvazia();

		assertEquals(0, carrinho.getQtdeItems());
		assertEquals(0.0, carrinho.getValorTotal(), 0.001);
	}
}
