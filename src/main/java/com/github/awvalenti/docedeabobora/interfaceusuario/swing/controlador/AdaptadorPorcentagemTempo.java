package com.github.awvalenti.docedeabobora.interfaceusuario.swing.controlador;

import com.github.awvalenti.docedeabobora.nucleo.TrabalhadorPeriodico;

public class AdaptadorPorcentagemTempo implements EventoControleVelocidade {

	private final TrabalhadorPeriodico trabalhador;

	public AdaptadorPorcentagemTempo(TrabalhadorPeriodico trabalhador) {
		this.trabalhador = trabalhador;
	}

	@Override
	public void aoAlterarVelocidade(int porcentagem) {
		trabalhador.setPeriodo(-95 * porcentagem + 10000);
	}

}
