package com.github.awvalenti.docedeabobora.main;

import javax.swing.JFrame;

import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.PainelRaias;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.Raia;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.fabrica.FabricaInterfaceGrafica;
import com.github.awvalenti.docedeabobora.nucleo.Estoque;
import com.github.awvalenti.docedeabobora.nucleo.EventoEstoque;
import com.github.awvalenti.docedeabobora.nucleo.TrabalhadorPeriodico;
import com.github.awvalenti.docedeabobora.nucleo.fabrica.FabricaNucleo;

public class MainAplicativoSwing {

	public static void main(String[] args) {
		final Raia raiaAboboras = FabricaInterfaceGrafica.fabricarRaiaAboboras();
		final Raia raiaDoces = FabricaInterfaceGrafica.fabricarRaiaDoces();

		PainelRaias painelRaias = new PainelRaias(raiaAboboras, raiaDoces);

		Estoque estoqueAboboras = FabricaNucleo.fabricarEstoqueAboboras(new EventoEstoque() {
			@Override
			public void aoProduzir(int novaQuantidade) {
				raiaAboboras.setQuantidadeProdutos(novaQuantidade);
			}

			@Override
			public void aoConsumir(int novaQuantidade) {
				raiaAboboras.setQuantidadeProdutos(novaQuantidade);
			}
		});

		Estoque estoqueDoces = FabricaNucleo.fabricarEstoqueDoces(new EventoEstoque() {
			@Override
			public void aoProduzir(int novaQuantidade) {
				raiaDoces.setQuantidadeProdutos(novaQuantidade);
			}

			@Override
			public void aoConsumir(int novaQuantidade) {
				raiaDoces.setQuantidadeProdutos(novaQuantidade);
			}
		});

		TrabalhadorPeriodico agricultor = FabricaNucleo.fabricarAgricultor(estoqueAboboras);
		TrabalhadorPeriodico doceiro = FabricaNucleo.fabricarDoceiro(estoqueAboboras, estoqueDoces);
		TrabalhadorPeriodico clientela = FabricaNucleo.fabricarClientela(estoqueDoces);

		JFrame frame = new JFrame("Doce de ab\u00f3bora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(painelRaias);

		frame.pack();
		frame.setVisible(true);

		agricultor.iniciar();
		doceiro.iniciar();
		clientela.iniciar();

	}
}
