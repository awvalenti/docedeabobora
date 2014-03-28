package com.github.awvalenti.docedeabobora.main;

import com.github.awvalenti.docedeabobora.interfaceusuario.console.SaidaNoConsole;
import com.github.awvalenti.docedeabobora.nucleo.Estoque;
import com.github.awvalenti.docedeabobora.nucleo.TrabalhadorPeriodico;
import com.github.awvalenti.docedeabobora.nucleo.fabrica.FabricaObjetosNucleo;

public class MainAplicativoConsole {

	public static void main(String[] args) {
		Estoque estoqueAboboras = FabricaObjetosNucleo.fabricarEstoqueAboboras(new SaidaNoConsole("abobora"));
		Estoque estoqueDoces = FabricaObjetosNucleo.fabricarEstoqueDoces(new SaidaNoConsole("doce de abobora"));

		TrabalhadorPeriodico agricultor = FabricaObjetosNucleo.fabricarAgricultor(estoqueAboboras);
		TrabalhadorPeriodico doceiro = FabricaObjetosNucleo.fabricarDoceiro(estoqueAboboras, estoqueDoces);
		TrabalhadorPeriodico clientela = FabricaObjetosNucleo.fabricarClientela(estoqueDoces);

		agricultor.iniciar();
		doceiro.iniciar();
		clientela.iniciar();
	}

}
