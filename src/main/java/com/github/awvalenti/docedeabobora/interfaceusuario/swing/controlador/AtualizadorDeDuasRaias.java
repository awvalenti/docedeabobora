package com.github.awvalenti.docedeabobora.interfaceusuario.swing.controlador;

import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.Raia;
import com.github.awvalenti.docedeabobora.nucleo.EventoEstoque;

public class AtualizadorDeDuasRaias implements EventoEstoque {
	private final Raia raiaEstoque;
	private final Raia raiaMedidoraDeConsumo;

	private int contadorItensConsumidos = 0;

	public AtualizadorDeDuasRaias(Raia raiaEstoque, Raia raiaMedidoraDeConsumo) {
		this.raiaEstoque = raiaEstoque;
		this.raiaMedidoraDeConsumo = raiaMedidoraDeConsumo;
	}

	@Override
	public void aoProduzir(int novaQuantidade) {
		raiaEstoque.setQuantidade(novaQuantidade);
	}

	@Override
	public void aoConsumir(int novaQuantidade) {
		++contadorItensConsumidos;
		raiaEstoque.setQuantidade(novaQuantidade);
		raiaMedidoraDeConsumo.setQuantidade(contadorItensConsumidos);
	}

}
