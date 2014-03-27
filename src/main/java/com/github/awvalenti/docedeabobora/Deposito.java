package com.github.awvalenti.docedeabobora;

public class Deposito {

	private int tamanho;
	private final int limite;

	public Deposito(int tamanho, int limite) {
		this.tamanho = tamanho;
		this.limite = limite;
	}

	public boolean consumir() {
		if (tamanho > 0) --tamanho;
		return true;
	}

	public void produzir() {
		if (tamanho < limite) ++tamanho;
	}

	public int tamanho() {
		return tamanho;
	}

}
