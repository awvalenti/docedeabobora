package com.github.awvalenti.docedeabobora.nucleo;

public class Estoque {

	private int tamanho;
	private final int limite;
	private final EventoEstoque eventoEstoque;

	public Estoque(int tamanho, int limite, EventoEstoque eventoEstoque) {
		this.tamanho = tamanho;
		this.limite = limite;
		this.eventoEstoque = eventoEstoque;
	}

	public synchronized boolean consumir() {
		if (tamanho <= 0) return false;

		eventoEstoque.aoConsumir(--tamanho);
		return true;
	}

	public synchronized void produzir() {
		if (tamanho < limite) {
			eventoEstoque.aoProduzir(++tamanho);
		}
	}

}
