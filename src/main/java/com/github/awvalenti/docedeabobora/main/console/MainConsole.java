package com.github.awvalenti.docedeabobora.main.console;

import com.github.awvalenti.docedeabobora.nucleo.Estoque;
import com.github.awvalenti.docedeabobora.nucleo.TrabalhadorPeriodico;
import com.github.awvalenti.docedeabobora.nucleo.fabrica.FabricaObjetos;

public class MainConsole {

	public static void main(String[] args) {
		Estoque estoqueAboboras = FabricaObjetos.fabricarEstoqueAboboras(new SaidaNoConsole("abobora"));
		Estoque estoqueDoces = FabricaObjetos.fabricarEstoqueDoces(new SaidaNoConsole("doce de abobora"));

		TrabalhadorPeriodico agricultor = FabricaObjetos.fabricarAgricultor(estoqueAboboras);
		TrabalhadorPeriodico doceiro = FabricaObjetos.fabricarDoceiro(estoqueAboboras, estoqueDoces);
		TrabalhadorPeriodico clientela = FabricaObjetos.fabricarClientela(estoqueDoces);

		agricultor.iniciar();
		doceiro.iniciar();
		clientela.iniciar();
	}

}
