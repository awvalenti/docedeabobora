package com.github.awvalenti.docedeabobora;

public class Deposito {

	private int tamanho;
	private final int limite;
	private final EventoDeposito eventoDeposito;

	public Deposito(int tamanho, int limite, EventoDeposito eventoDeposito) {
		this.tamanho = tamanho;
		this.limite = limite;
		this.eventoDeposito = eventoDeposito;
	}

	public boolean consumir() {
		if (tamanho > 0) {
			eventoDeposito.aoConsumir(--tamanho);
		}
		return true;
	}

	public void produzir() {
		if (tamanho < limite) {
			eventoDeposito.aoProduzir(++tamanho);
		}
	}

	public int tamanho() {
		return tamanho;
	}

}
