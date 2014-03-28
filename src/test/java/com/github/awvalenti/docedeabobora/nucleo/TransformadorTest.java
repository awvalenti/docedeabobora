package com.github.awvalenti.docedeabobora.nucleo;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.github.awvalenti.docedeabobora.nucleo.Deposito;
import com.github.awvalenti.docedeabobora.nucleo.Transformador;

public class TransformadorTest {

	private Transformador doceiro;
	private Deposito depositoAboboras;
	private Deposito depositoDoces;

	@Before
	public void setUp() {
		depositoAboboras = mock(Deposito.class);
		depositoDoces = mock(Deposito.class);
		doceiro = new Transformador(depositoAboboras, depositoDoces);
	}

	@Test
	public void deve_produzir_doce() {
		when(depositoAboboras.consumir()).thenReturn(true);
		doceiro.run();
		verify(depositoAboboras, times(1)).consumir();
		verify(depositoDoces, times(1)).produzir();
	}

	@Test
	public void nao_deve_produzir_doce_quando_faltar_espaco_para_doce() {
		when(depositoAboboras.consumir()).thenReturn(false);
		doceiro.run();
		verify(depositoDoces, never()).produzir();
	}

}
