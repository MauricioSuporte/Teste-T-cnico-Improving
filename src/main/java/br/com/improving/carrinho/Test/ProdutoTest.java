package br.com.improving.carrinho.Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import br.com.improving.carrinho.Produto;

public class ProdutoTest {

	@Test
	public void testGetCodigo() {
		Long codigo = 123L;
		String descricao = "Produto Teste";
		Produto produto = new Produto(codigo, descricao);

		assertEquals(codigo, produto.getCodigo());
	}

	@Test
	public void testGetDescricao() {
		Long codigo = 123L;
		String descricao = "Produto Teste";
		Produto produto = new Produto(codigo, descricao);

		assertEquals(descricao, produto.getDescricao());
	}

	@Test
	public void testEquals() {
		Long codigo1 = 123L;
		String descricao1 = "Produto Teste 1";
		Produto produto1 = new Produto(codigo1, descricao1);

		Long codigo2 = 123L;
		String descricao2 = "Produto Teste 2";
		Produto produto2 = new Produto(codigo2, descricao2);

		assertEquals(produto1, produto2);
	}

	@Test
	public void testNotEquals() {
		Long codigo1 = 123L;
		String descricao1 = "Produto Teste 1";
		Produto produto1 = new Produto(codigo1, descricao1);

		Long codigo2 = 456L;
		String descricao2 = "Produto Teste 2";
		Produto produto2 = new Produto(codigo2, descricao2);

		assertNotEquals(produto1, produto2);
	}
}
