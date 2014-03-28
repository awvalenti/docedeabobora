package com.github.awvalenti.docedeabobora.nucleo;

public class Transformador implements Runnable {

	private final Estoque estoqueOrigem;
	private final Estoque estoqueDestino;

	public Transformador(Estoque estoqueOrigem, Estoque estoqueDestino) {
		this.estoqueOrigem = estoqueOrigem;
		this.estoqueDestino = estoqueDestino;
	}

	@Override
	public void run() {
		if (estoqueOrigem.consumir()) estoqueDestino.produzir();
	}

}
