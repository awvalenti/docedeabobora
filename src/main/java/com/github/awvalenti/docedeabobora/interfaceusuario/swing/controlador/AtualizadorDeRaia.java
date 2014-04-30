package com.github.awvalenti.docedeabobora.interfaceusuario.swing.controlador;

import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.Raia;
import com.github.awvalenti.docedeabobora.nucleo.EventoEstoque;

public class AtualizadorDeRaia implements EventoEstoque {
	private final Raia raia;

	public AtualizadorDeRaia(Raia raia) {
		this.raia = raia;
	}

	@Override
	public void aoProduzir(int novaQuantidade) {
		raia.setQuantidade(novaQuantidade);
	}

	@Override
	public void aoConsumir(int novaQuantidade) {
		raia.setQuantidade(novaQuantidade);
	}

}
