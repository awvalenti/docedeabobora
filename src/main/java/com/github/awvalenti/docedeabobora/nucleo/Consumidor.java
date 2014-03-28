package com.github.awvalenti.docedeabobora.nucleo;

public class Consumidor implements Runnable {
	private final Estoque estoque;

	public Consumidor(Estoque estoque) {
		this.estoque = estoque;
	}

	@Override
	public void run() {
		estoque.consumir();
	}
}