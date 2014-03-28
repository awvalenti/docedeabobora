package com.github.awvalenti.docedeabobora.nucleo;

public class Produtor implements Runnable {
	private final Deposito deposito;

	public Produtor(Deposito deposito) {
		this.deposito = deposito;
	}

	@Override
	public void run() {
		deposito.produzir();
	}
}