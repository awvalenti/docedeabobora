package com.github.awvalenti.docedeabobora.main;

import com.github.awvalenti.docedeabobora.interfaceusuario.console.SaidaNoConsole;
import com.github.awvalenti.docedeabobora.nucleo.Estoque;
import com.github.awvalenti.docedeabobora.nucleo.TrabalhadorPeriodico;
import com.github.awvalenti.docedeabobora.nucleo.fabrica.FabricaNucleo;

public class MainAplicativoConsole {

	public static void main(String[] args) {
		Estoque estoqueAboboras = FabricaNucleo.fabricarEstoqueAboboras(new SaidaNoConsole("abobora"));
		Estoque estoqueDoces = FabricaNucleo.fabricarEstoqueDoces(new SaidaNoConsole("doce de abobora"));

		TrabalhadorPeriodico agricultor = FabricaNucleo.fabricarAgricultor(estoqueAboboras);
		TrabalhadorPeriodico doceiro = FabricaNucleo.fabricarDoceiro(estoqueAboboras, estoqueDoces);
		TrabalhadorPeriodico clientela = FabricaNucleo.fabricarClientela(estoqueDoces);

		agricultor.iniciar();
		doceiro.iniciar();
		clientela.iniciar();
	}

}
