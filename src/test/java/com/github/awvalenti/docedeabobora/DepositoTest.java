package com.github.awvalenti.docedeabobora;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class DepositoTest {

	private Deposito deposito;

	@Test
	public void deve_produzir() {
		deposito = new Deposito(0, 30);
		deposito.produzir();
		assertThat(deposito.tamanho(), is(1));
	}

	@Test
	public void deve_consumir() {
		deposito = new Deposito(1, 30);
		deposito.consumir();
		assertThat(deposito.tamanho(), is(0));
	}

	@Test
	public void deve_impedir_producao_quando_atingir_limite() {
		deposito = new Deposito(30, 30);
		deposito.produzir();
		assertThat(deposito.tamanho(), is(30));
	}

	@Test
	public void deve_impedir_consumo_quando_vazio() {
		deposito = new Deposito(0, 30);
		deposito.consumir();
		assertThat(deposito.tamanho(), is(0));
	}

}
