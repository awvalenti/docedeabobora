package com.github.awvalenti.docedeabobora.nucleo.fabrica;

import com.github.awvalenti.docedeabobora.nucleo.Consumidor;
import com.github.awvalenti.docedeabobora.nucleo.Estoque;
import com.github.awvalenti.docedeabobora.nucleo.EventoEstoque;
import com.github.awvalenti.docedeabobora.nucleo.Produtor;
import com.github.awvalenti.docedeabobora.nucleo.TrabalhadorPeriodico;
import com.github.awvalenti.docedeabobora.nucleo.Transformador;

public class FabricaObjetosNucleo {

	public static Estoque fabricarEstoqueAboboras(EventoEstoque eventoEstoque) {
		return fabricarEstoqueGenerico(eventoEstoque);
	}

	public static Estoque fabricarEstoqueDoces(EventoEstoque eventoEstoque) {
		return fabricarEstoqueGenerico(eventoEstoque);
	}

	public static TrabalhadorPeriodico fabricarAgricultor(Estoque estoqueAboboras) {
		return criarTrabalhadorPeriodico(new Produtor(estoqueAboboras));
	}

	public static TrabalhadorPeriodico fabricarDoceiro(Estoque estoqueAboboras, Estoque estoqueDoces) {
		return criarTrabalhadorPeriodico(new Transformador(estoqueAboboras, estoqueDoces));
	}

	public static TrabalhadorPeriodico fabricarClientela(Estoque estoqueDoces) {
		return criarTrabalhadorPeriodico(new Consumidor(estoqueDoces));
	}

	private static Estoque fabricarEstoqueGenerico(EventoEstoque eventoEstoque) {
		return new Estoque(0, 12, eventoEstoque);
	}

	private static TrabalhadorPeriodico criarTrabalhadorPeriodico(Runnable runnable) {
		return new TrabalhadorPeriodico(runnable, 1000);
	}

}
