package com.github.awvalenti.docedeabobora.nucleo;

public class Transformador implements Runnable {

	private final Deposito depositoOrigem;
	private final Deposito depositoDestino;

	public Transformador(Deposito depositoOrigem, Deposito depositoDestino) {
		this.depositoOrigem = depositoOrigem;
		this.depositoDestino = depositoDestino;
	}

	public void run() {
		if (depositoOrigem.consumir()) depositoDestino.produzir();
	}

}
