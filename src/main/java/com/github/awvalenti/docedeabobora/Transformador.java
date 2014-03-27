package com.github.awvalenti.docedeabobora;

public class Transformador {

	private final Deposito depositoOrigem;
	private final Deposito depositoDestino;

	public Transformador(Deposito depositoOrigem, Deposito depositoDestino) {
		this.depositoOrigem = depositoOrigem;
		this.depositoDestino = depositoDestino;
	}

	public void produzir() {
		if (depositoOrigem.consumir()) depositoDestino.produzir();
	}

}
