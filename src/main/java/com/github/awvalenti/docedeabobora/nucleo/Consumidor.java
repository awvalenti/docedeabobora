package com.github.awvalenti.docedeabobora.nucleo;

public class Consumidor implements Runnable {
	private final Deposito deposito;

	public Consumidor(Deposito deposito) {
		this.deposito = deposito;
	}

	@Override
	public void run() {
		deposito.consumir();
	}
}