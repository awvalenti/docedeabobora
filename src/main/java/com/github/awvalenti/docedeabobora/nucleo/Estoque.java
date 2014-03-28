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

	public boolean consumir() {
		if (tamanho > 0) {
			eventoEstoque.aoConsumir(--tamanho);
		}
		return true;
	}

	public void produzir() {
		if (tamanho < limite) {
			eventoEstoque.aoProduzir(++tamanho);
		}
	}

	public int tamanho() {
		return tamanho;
	}

}
