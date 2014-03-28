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
		return new TrabalhadorPeriodico(new Produtor(estoqueAboboras));
	}

	public static TrabalhadorPeriodico fabricarDoceiro(Estoque estoqueAboboras, Estoque estoqueDoces) {
		return new TrabalhadorPeriodico(new Transformador(estoqueAboboras, estoqueDoces));
	}

	public static TrabalhadorPeriodico fabricarClientela(Estoque estoqueDoces) {
		return new TrabalhadorPeriodico(new Consumidor(estoqueDoces));
	}

	private static Estoque fabricarEstoqueGenerico(EventoEstoque eventoEstoque) {
		return new Estoque(0, 12, eventoEstoque);
	}

}
