package com.github.awvalenti.docedeabobora.nucleo;

public class Produtor implements Runnable {
	private final Estoque estoque;

	public Produtor(Estoque estoque) {
		this.estoque = estoque;
	}

	@Override
	public void run() {
		estoque.produzir();
	}
}