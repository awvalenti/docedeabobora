package com.github.awvalenti.docedeabobora.main;

import javax.swing.JFrame;

import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.ControleUmaVelocidade;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.PainelControle;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.PainelRaias;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.Raia;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.controlador.AdaptadorPorcentagemTempo;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.controlador.AtualizadorDeDuasRaias;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.controlador.AtualizadorDeRaia;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.fabrica.FabricaObjetosSwing;
import com.github.awvalenti.docedeabobora.nucleo.Estoque;
import com.github.awvalenti.docedeabobora.nucleo.TrabalhadorPeriodico;
import com.github.awvalenti.docedeabobora.nucleo.fabrica.FabricaObjetosNucleo;

public class MainAplicativoSwing {

	public static void main(String[] args) {
		final Raia raiaAboboras = FabricaObjetosSwing.fabricarRaiaAboboras();
		final Raia raiaDoces = FabricaObjetosSwing.fabricarRaiaDoces();
		final Raia raiaClientela = FabricaObjetosSwing.fabricarRaiaClientela();

		Estoque estoqueAboboras = FabricaObjetosNucleo.fabricarEstoqueAboboras(new AtualizadorDeRaia(raiaAboboras));
		Estoque estoqueDoces = FabricaObjetosNucleo.fabricarEstoqueDoces(new AtualizadorDeDuasRaias(raiaDoces, raiaClientela));

		TrabalhadorPeriodico agricultor = FabricaObjetosNucleo.fabricarAgricultor(estoqueAboboras);
		TrabalhadorPeriodico doceiro = FabricaObjetosNucleo.fabricarDoceiro(estoqueAboboras, estoqueDoces);
		TrabalhadorPeriodico clientela = FabricaObjetosNucleo.fabricarClientela(estoqueDoces);

		JFrame frame = new JFrame("Doce de ab\u00f3bora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ControleUmaVelocidade controleVelocidadeAgricultor = FabricaObjetosSwing.criarControleVelocidadeAgricultor(new AdaptadorPorcentagemTempo(agricultor));
		ControleUmaVelocidade controleVelocidadeDoceiro = FabricaObjetosSwing.criarControleVelocidadeDoceiro(new AdaptadorPorcentagemTempo(doceiro));
		ControleUmaVelocidade controleVelocidadeClientela = FabricaObjetosSwing.criarControleVelocidadeClientela(new AdaptadorPorcentagemTempo(clientela));

		frame.add(FabricaObjetosSwing.fabricarPainelGeral(
			new PainelRaias(raiaAboboras, raiaDoces, raiaClientela),
			new PainelControle(controleVelocidadeAgricultor, controleVelocidadeDoceiro, controleVelocidadeClientela))
		);

		frame.pack();
		frame.setVisible(true);

		agricultor.iniciar();
		doceiro.iniciar();
		clientela.iniciar();
	}

}
