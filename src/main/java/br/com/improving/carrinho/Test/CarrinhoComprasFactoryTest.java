package br.com.improving.carrinho.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import br.com.improving.carrinho.CarrinhoCompras;
import br.com.improving.carrinho.CarrinhoComprasFactory;
import br.com.improving.carrinho.Produto;

public class CarrinhoComprasFactoryTest {

	private CarrinhoComprasFactory carrinhoComprasFactory;

	@BeforeEach
	public void setUp() {
		carrinhoComprasFactory = new CarrinhoComprasFactory();
	}

	@Test
	public void testCriarCarrinhoParaNovoCliente() {
		String identificacaoCliente = "cliente1";

		CarrinhoCompras carrinhoCompras = carrinhoComprasFactory.criar(identificacaoCliente);

		assertNotNull(carrinhoCompras);
	}

	@Test
	public void testReutilizarCarrinhoParaClienteExistente() {
		String identificacaoCliente = "cliente2";

		CarrinhoCompras carrinhoCompras1 = carrinhoComprasFactory.criar(identificacaoCliente);
		CarrinhoCompras carrinhoCompras2 = carrinhoComprasFactory.criar(identificacaoCliente);

		assertEquals(carrinhoCompras1, carrinhoCompras2);
	}

	@Test
	public void testGetValorTicketMedioCarrinhoVazio() {
		BigDecimal valorTicketMedio = carrinhoComprasFactory.getValorTicketMedio();

		assertEquals(BigDecimal.ZERO, valorTicketMedio);
	}

	@Test
	public void testGetValorTicketMedioCarrinhoComItens() {
		String identificacaoCliente1 = "cliente3";
		String identificacaoCliente2 = "cliente4";

		CarrinhoCompras carrinhoCompras1 = carrinhoComprasFactory.criar(identificacaoCliente1);
		carrinhoCompras1.adicionarItem(new Produto(1L, "Produto 1"), new BigDecimal("10.00"), 2);
		carrinhoCompras1.adicionarItem(new Produto(2L, "Produto 2"), new BigDecimal("15.00"), 1);

		CarrinhoCompras carrinhoCompras2 = carrinhoComprasFactory.criar(identificacaoCliente2);
		carrinhoCompras2.adicionarItem(new Produto(3L, "Produto 3"), new BigDecimal("20.00"), 3);

		BigDecimal valorTicketMedio = carrinhoComprasFactory.getValorTicketMedio();

		assertEquals(new BigDecimal("47.50"), valorTicketMedio);
	}

	@Test
	public void testValorTicketMedioArredondamentoCima() {
		String identificacaoCliente1 = "cliente1";
		String identificacaoCliente2 = "cliente2";

		CarrinhoCompras carrinhoCompras1 = carrinhoComprasFactory.criar(identificacaoCliente1);
		carrinhoCompras1.adicionarItem(new Produto(1L, "Produto 1"), new BigDecimal("30.155"), 1);

		CarrinhoCompras carrinhoCompras2 = carrinhoComprasFactory.criar(identificacaoCliente2);
		carrinhoCompras2.adicionarItem(new Produto(2L, "Produto 2"), new BigDecimal("30.155"), 1);

		BigDecimal valorTicketMedio = carrinhoComprasFactory.getValorTicketMedio();

		assertEquals(new BigDecimal("30.16"), valorTicketMedio);
	}

	@Test
	public void testValorTicketMedioArredondamentoBaixo() {
		String identificacaoCliente1 = "cliente1";
		String identificacaoCliente2 = "cliente2";

		CarrinhoCompras carrinhoCompras1 = carrinhoComprasFactory.criar(identificacaoCliente1);
		carrinhoCompras1.adicionarItem(new Produto(1L, "Produto 1"), new BigDecimal("30.144"), 1);

		CarrinhoCompras carrinhoCompras2 = carrinhoComprasFactory.criar(identificacaoCliente2);
		carrinhoCompras2.adicionarItem(new Produto(2L, "Produto 2"), new BigDecimal("30.144"), 1);

		BigDecimal valorTicketMedio = carrinhoComprasFactory.getValorTicketMedio();

		assertEquals(new BigDecimal("30.14"), valorTicketMedio);
	}

	@Test
	public void testValorTicketMedioDuasCasasDecimais() {
		String identificacaoCliente1 = "cliente1";
		String identificacaoCliente2 = "cliente2";

		CarrinhoCompras carrinhoCompras1 = carrinhoComprasFactory.criar(identificacaoCliente1);
		carrinhoCompras1.adicionarItem(new Produto(6L, "Produto 1"), new BigDecimal("2.333"), 2);

		CarrinhoCompras carrinhoCompras2 = carrinhoComprasFactory.criar(identificacaoCliente2);
		carrinhoCompras2.adicionarItem(new Produto(7L, "Produto 2"), new BigDecimal("3.777"), 1);

		BigDecimal valorTicketMedio = carrinhoComprasFactory.getValorTicketMedio();

		assertEquals(new BigDecimal("4.22"), valorTicketMedio);
	}

	@Test
	public void testInvalidarCarrinhoExistente() {
		String identificacaoCliente = "cliente5";
		CarrinhoCompras carrinhoCompras = carrinhoComprasFactory.criar(identificacaoCliente);

		assertTrue(carrinhoComprasFactory.invalidar(identificacaoCliente));
	}

	@Test
	public void testInvalidarCarrinhoInexistente() {
		String identificacaoCliente = "cliente6";

		assertFalse(carrinhoComprasFactory.invalidar(identificacaoCliente));
	}

	@Test
	public void testInvalidarCarrinhoNulo() {
		String identificacaoCliente = null;

		assertFalse(carrinhoComprasFactory.invalidar(identificacaoCliente));
	}
}
