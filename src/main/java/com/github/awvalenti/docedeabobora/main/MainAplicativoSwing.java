package com.github.awvalenti.docedeabobora.main;

import javax.swing.JFrame;

import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.PainelRaias;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.Raia;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.fabrica.FabricaObjetosSwing;
import com.github.awvalenti.docedeabobora.nucleo.Estoque;
import com.github.awvalenti.docedeabobora.nucleo.EventoEstoque;
import com.github.awvalenti.docedeabobora.nucleo.TrabalhadorPeriodico;
import com.github.awvalenti.docedeabobora.nucleo.fabrica.FabricaObjetosNucleo;

public class MainAplicativoSwing {

	public static void main(String[] args) {
		final Raia raiaAboboras = FabricaObjetosSwing.fabricarRaiaAboboras();
		final Raia raiaDoces = FabricaObjetosSwing.fabricarRaiaDoces();

		PainelRaias painelRaias = new PainelRaias(raiaAboboras, raiaDoces);

		Estoque estoqueAboboras = FabricaObjetosNucleo.fabricarEstoqueAboboras(new EventoEstoque() {
			@Override
			public void aoProduzir(int novaQuantidade) {
				raiaAboboras.setQuantidadeProdutos(novaQuantidade);
			}

			@Override
			public void aoConsumir(int novaQuantidade) {
				raiaAboboras.setQuantidadeProdutos(novaQuantidade);
			}
		});

		Estoque estoqueDoces = FabricaObjetosNucleo.fabricarEstoqueDoces(new EventoEstoque() {
			@Override
			public void aoProduzir(int novaQuantidade) {
				raiaDoces.setQuantidadeProdutos(novaQuantidade);
			}

			@Override
			public void aoConsumir(int novaQuantidade) {
				raiaDoces.setQuantidadeProdutos(novaQuantidade);
			}
		});

		TrabalhadorPeriodico agricultor = FabricaObjetosNucleo.fabricarAgricultor(estoqueAboboras);
		TrabalhadorPeriodico doceiro = FabricaObjetosNucleo.fabricarDoceiro(estoqueAboboras, estoqueDoces);
		TrabalhadorPeriodico clientela = FabricaObjetosNucleo.fabricarClientela(estoqueDoces);

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
