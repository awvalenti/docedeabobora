package com.github.awvalenti.docedeabobora.main.console;

import com.github.awvalenti.docedeabobora.nucleo.EventoDeposito;

public class SaidaNoConsole implements EventoDeposito {
	private final String nomeProduto;

	public SaidaNoConsole(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	@Override
	public void aoProduzir(int novaQuantidade) {
		System.out.println("Produziu " + nomeProduto);
	}

	@Override
	public void aoConsumir(int novaQuantidade) {
		System.out.println("Consumiu " + nomeProduto);
	}

}