package com.github.awvalenti.docedeabobora.main.console;

import com.github.awvalenti.docedeabobora.nucleo.Deposito;
import com.github.awvalenti.docedeabobora.nucleo.TrabalhadorPeriodico;
import com.github.awvalenti.docedeabobora.nucleo.fabrica.FabricaObjetos;

public class MainConsole {

	public static void main(String[] args) {
		Deposito depositoAboboras = FabricaObjetos.fabricarDepositoAboboras(new SaidaNoConsole("abobora"));
		Deposito depositoDoces = FabricaObjetos.fabricarDepositoDoces(new SaidaNoConsole("doce de abobora"));

		TrabalhadorPeriodico agricultor = FabricaObjetos.fabricarAgricultor(depositoAboboras);
		TrabalhadorPeriodico doceiro = FabricaObjetos.fabricarDoceiro(depositoAboboras, depositoDoces);
		TrabalhadorPeriodico clientela = FabricaObjetos.fabricarClientela(depositoDoces);

		agricultor.iniciar();
		doceiro.iniciar();
		clientela.iniciar();
	}

}
