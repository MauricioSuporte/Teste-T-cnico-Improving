package br.com.improving.carrinho.Test;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.improving.carrinho.Item;
import br.com.improving.carrinho.Produto;

public class ItemTest {

	@Test
	public void testGetProduto() {
		Produto produto = new Produto(1L, "Produto Teste");
		BigDecimal valorUnitario = new BigDecimal("10.00");
		int quantidade = 2;
		Item item = new Item(produto, valorUnitario, quantidade);

		assertEquals(produto, item.getProduto());
	}

	@Test
	public void testGetQuantidade() {
		Produto produto = new Produto(1L, "Produto Teste");
		BigDecimal valorUnitario = new BigDecimal("10.00");
		int quantidade = 2;
		Item item = new Item(produto, valorUnitario, quantidade);

		assertEquals(quantidade, item.getQuantidade());
	}

	@Test
	public void testGetValorTotal() {
		Produto produto = new Produto(1L, "Produto Teste");
		BigDecimal valorUnitario = new BigDecimal("10.00");
		int quantidade = 3;

		Item item = new Item(produto, valorUnitario, quantidade);

		BigDecimal valorTotalEsperado = new BigDecimal("30.00");
		BigDecimal valorTotalCalculado = item.getValorTotal();

		assertEquals(valorTotalEsperado, valorTotalCalculado);
	}

	@Test
	public void testSetValorUnitario() {
		Produto produto = new Produto(1L, "Produto Teste");
		BigDecimal valorUnitarioInicial = new BigDecimal("10.00");
		int quantidade = 3;

		Item item = new Item(produto, valorUnitarioInicial, quantidade);

		BigDecimal novoValorUnitario = new BigDecimal("15.00");
		item.setValorUnitario(novoValorUnitario);

		assertEquals(novoValorUnitario, item.getValorUnitario());
	}

	@Test
	public void testSetQuantidade() {
		Produto produto = new Produto(1L, "Produto Teste");
		BigDecimal valorUnitario = new BigDecimal("10.00");
		int quantidadeInicial = 3;

		Item item = new Item(produto, valorUnitario, quantidadeInicial);

		int novaQuantidade = 5;
		item.setQuantidade(novaQuantidade);

		assertEquals(novaQuantidade, item.getQuantidade());
	}
}
