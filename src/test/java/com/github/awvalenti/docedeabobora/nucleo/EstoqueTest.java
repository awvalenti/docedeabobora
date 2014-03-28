package com.github.awvalenti.docedeabobora.nucleo;

import org.junit.Before;
import org.junit.Test;

import com.github.awvalenti.docedeabobora.nucleo.Estoque;
import com.github.awvalenti.docedeabobora.nucleo.EventoEstoque;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

public class EstoqueTest {

	private Estoque estoque;
	private EventoEstoque eventoEstoque;

	@Before
	public void setUp() {
		eventoEstoque = mock(EventoEstoque.class);
	}

	@Test
	public void deve_produzir() {
		estoque = new Estoque(10, 30, eventoEstoque);
		estoque.produzir();
		verify(eventoEstoque, times(1)).aoProduzir(11);
	}

	@Test
	public void deve_consumir() {
		estoque = new Estoque(10, 30, eventoEstoque);
		boolean consumiu = estoque.consumir();
		assertThat(consumiu, is(true));
		verify(eventoEstoque, times(1)).aoConsumir(9);
	}

	@Test
	public void deve_impedir_producao_quando_atingir_limite() {
		estoque = new Estoque(30, 30, eventoEstoque);
		estoque.produzir();
		verify(eventoEstoque, never()).aoProduzir(anyInt());
	}

	@Test
	public void deve_impedir_consumo_quando_vazio() {
		estoque = new Estoque(0, 30, eventoEstoque);
		boolean consumiu = estoque.consumir();
		assertThat(consumiu, is(false));
		verify(eventoEstoque, never()).aoConsumir(anyInt());
	}

}
