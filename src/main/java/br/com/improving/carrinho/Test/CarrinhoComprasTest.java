package br.com.improving.carrinho.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import br.com.improving.carrinho.CarrinhoCompras;
import br.com.improving.carrinho.Produto;

public class CarrinhoComprasTest {

	private CarrinhoCompras carrinho;

	@BeforeEach
	public void setUp() {
		carrinho = new CarrinhoCompras();
	}

	@Test
	public void testAdicionarItem() {
		Produto produto = new Produto(1L, "Produto Teste");
		BigDecimal valorUnitario = new BigDecimal("10.00");
		int quantidade = 2;

		carrinho.adicionarItem(produto, valorUnitario, quantidade);

		assertEquals(1, carrinho.getItens().size());
	}

	@Test
	public void testAdicionarItemComValorNegativo() {
		Produto produto = new Produto(1L, "Produto Teste");
		BigDecimal valorUnitario = new BigDecimal("-10.00");
		int quantidade = 2;

		assertThrows(IllegalArgumentException.class, () -> {
			carrinho.adicionarItem(produto, valorUnitario, quantidade);
		});
	}

	@Test
	public void testAdicionarItemComValorNulo() {
		Produto produto = new Produto(1L, "Produto Teste");
		BigDecimal valorUnitario = null;
		int quantidade = 2;

		assertThrows(IllegalArgumentException.class, () -> {
			carrinho.adicionarItem(produto, valorUnitario, quantidade);
		});
	}

	@Test
	public void testAdicionarItemComValorZero() {
		Produto produto = new Produto(1L, "Produto Teste");
		BigDecimal valorUnitario = BigDecimal.ZERO;
		int quantidade = 2;

		assertThrows(IllegalArgumentException.class, () -> {
			carrinho.adicionarItem(produto, valorUnitario, quantidade);
		});
	}

	@Test
	public void testAdicionarItemComQuantidadeZero() {
		Produto produto = new Produto(1L, "Produto Teste");
		BigDecimal valorUnitario = null;
		int quantidade = 0;

		assertThrows(IllegalArgumentException.class, () -> {
			carrinho.adicionarItem(produto, valorUnitario, quantidade);
		});
	}

	@Test
	public void testAdicionarItemComQuantidadeNegativa() {
		Produto produto = new Produto(1L, "Produto Teste");
		BigDecimal valorUnitario = null;
		int quantidade = -1;

		assertThrows(IllegalArgumentException.class, () -> {
			carrinho.adicionarItem(produto, valorUnitario, quantidade);
		});
	}

	@Test
	public void testAdicionarItemComQuantidadeNula() {
		Produto produto = new Produto(1L, "Produto Teste");
		BigDecimal valorUnitario = new BigDecimal("10.00");
		Integer quantidade = null;

		assertThrows(IllegalArgumentException.class, () -> {
			carrinho.adicionarItem(produto, valorUnitario, quantidade);
		});
	}

	@Test
	public void testAdicionarItemComProdutoNulo() {
		BigDecimal valorUnitario = new BigDecimal("10.00");
		int quantidade = 2;

		assertThrows(IllegalArgumentException.class, () -> {
			carrinho.adicionarItem(null, valorUnitario, quantidade);
		});
	}

	@Test
	public void testRemoverItemExistente() {
		Produto produto = new Produto(1L, "Produto Teste");
		BigDecimal valorUnitario = new BigDecimal("10.00");
		int quantidade = 2;

		carrinho.adicionarItem(produto, valorUnitario, quantidade);
		boolean removido = carrinho.removerItem(produto);

		assertTrue(removido);
		assertEquals(0, carrinho.getItens().size());
	}

	@Test
	public void testRemoverItemInexiste() {
		Produto produto = new Produto(1L, "Produto Inexistente");

		assertFalse(carrinho.removerItem(produto));
	}

	@Test
	public void testRemoverItemComProdutoNulo() {
		assertFalse(carrinho.removerItem(null));
	}

	@Test
	public void testRemoverItemExistentePelaPosicao() {
		Produto produto1 = new Produto(1L, "Produto 1");
		Produto produto2 = new Produto(2L, "Produto 2");
		BigDecimal valorUnitario = new BigDecimal("10.00");
		int quantidade = 2;

		carrinho.adicionarItem(produto1, valorUnitario, quantidade);
		carrinho.adicionarItem(produto2, valorUnitario, quantidade);

		assertTrue(carrinho.removerItem(0));
		assertEquals(1, carrinho.getItens().size());
	}

	@Test
	public void testRemoverItemInexistentePelaPosicao() {
		Produto produto1 = new Produto(1L, "Produto 1");
		Produto produto2 = new Produto(2L, "Produto 2");
		BigDecimal valorUnitario = new BigDecimal("10.00");
		int quantidade = 2;

		carrinho.adicionarItem(produto1, valorUnitario, quantidade);
		carrinho.adicionarItem(produto2, valorUnitario, quantidade);

		assertFalse(carrinho.removerItem(2));
	}

	@Test
	public void testCalcularValorTotalComItens() {
		Produto produto1 = new Produto(1L, "Produto 1");
		BigDecimal valorUnitario1 = new BigDecimal("10.00");
		int quantidade1 = 2;

		Produto produto2 = new Produto(2L, "Produto 2");
		BigDecimal valorUnitario2 = new BigDecimal("15.00");
		int quantidade2 = 1;

		carrinho.adicionarItem(produto1, valorUnitario1, quantidade1);
		carrinho.adicionarItem(produto2, valorUnitario2, quantidade2);

		BigDecimal valorTotalEsperado = new BigDecimal("35.00");

		assertEquals(valorTotalEsperado, carrinho.getValorTotal());
	}

	@Test
	public void testCalcularValorTotalCarrinhoVazio() {
		assertEquals(BigDecimal.ZERO, carrinho.getValorTotal());
	}

	@Test
	public void testQuantidadeDeItensAposAdicaoERemocao() {
		Produto produto1 = new Produto(1L, "Produto 1");
		BigDecimal valorUnitario1 = new BigDecimal("10.00");
		int quantidade1 = 2;

		Produto produto2 = new Produto(2L, "Produto 2");
		BigDecimal valorUnitario2 = new BigDecimal("15.00");
		int quantidade2 = 1;

		carrinho.adicionarItem(produto1, valorUnitario1, quantidade1);
		carrinho.adicionarItem(produto2, valorUnitario2, quantidade2);

		assertEquals(2, carrinho.getItens().size());

		carrinho.removerItem(produto1);

		assertEquals(1, carrinho.getItens().size());
	}

	@Test
	public void testQuantidadeItensAdicaoERemocao() {
		Produto produto1 = new Produto(1L, "Produto 1");
		Produto produto2 = new Produto(2L, "Produto 2");
		BigDecimal valorUnitario = new BigDecimal("10.00");
		int quantidade = 2;

		carrinho.adicionarItem(produto1, valorUnitario, quantidade);
		carrinho.adicionarItem(produto2, valorUnitario, quantidade);

		assertEquals(2, carrinho.getItens().size());

		carrinho.removerItem(produto1);

		assertEquals(1, carrinho.getItens().size());
	}
}
