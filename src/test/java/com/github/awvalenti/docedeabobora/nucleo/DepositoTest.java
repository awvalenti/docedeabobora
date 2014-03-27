package com.github.awvalenti.docedeabobora.nucleo;

import org.junit.Before;
import org.junit.Test;

import com.github.awvalenti.docedeabobora.nucleo.Deposito;
import com.github.awvalenti.docedeabobora.nucleo.EventoDeposito;

import static org.mockito.Mockito.*;

public class DepositoTest {

	private Deposito deposito;
	private EventoDeposito eventoDeposito;

	@Before
	public void setUp() {
		eventoDeposito = mock(EventoDeposito.class);
	}

	@Test
	public void deve_produzir() {
		deposito = new Deposito(10, 30, eventoDeposito);
		deposito.produzir();
		verify(eventoDeposito, times(1)).aoProduzir(11);
	}

	@Test
	public void deve_consumir() {
		deposito = new Deposito(10, 30, eventoDeposito);
		deposito.consumir();
		verify(eventoDeposito, times(1)).aoConsumir(9);
	}

	@Test
	public void deve_impedir_producao_quando_atingir_limite() {
		deposito = new Deposito(30, 30, eventoDeposito);
		deposito.produzir();
		verify(eventoDeposito, never()).aoProduzir(anyInt());
	}

	@Test
	public void deve_impedir_consumo_quando_vazio() {
		deposito = new Deposito(0, 30, eventoDeposito);
		deposito.consumir();
		verify(eventoDeposito, never()).aoConsumir(anyInt());
	}

}
