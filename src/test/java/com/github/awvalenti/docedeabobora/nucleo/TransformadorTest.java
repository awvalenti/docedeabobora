package com.github.awvalenti.docedeabobora.nucleo;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.github.awvalenti.docedeabobora.nucleo.Estoque;
import com.github.awvalenti.docedeabobora.nucleo.Transformador;

public class TransformadorTest {

	private Transformador doceiro;
	private Estoque estoqueAboboras;
	private Estoque estoqueDoces;

	@Before
	public void setUp() {
		estoqueAboboras = mock(Estoque.class);
		estoqueDoces = mock(Estoque.class);
		doceiro = new Transformador(estoqueAboboras, estoqueDoces);
	}

	@Test
	public void deve_produzir_doce() {
		when(estoqueAboboras.consumir()).thenReturn(true);
		doceiro.run();
		verify(estoqueAboboras, times(1)).consumir();
		verify(estoqueDoces, times(1)).produzir();
	}

	@Test
	public void nao_deve_produzir_doce_quando_faltar_espaco_para_doce() {
		when(estoqueAboboras.consumir()).thenReturn(false);
		doceiro.run();
		verify(estoqueDoces, never()).produzir();
	}

}
