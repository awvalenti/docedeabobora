package com.github.awvalenti.docedeabobora.interfaceusuario.swing.controlador;

public class EventoVazioControleVelocidade implements EventoControleVelocidade {

	public static final EventoControleVelocidade INSTANCIA = new EventoVazioControleVelocidade();

	private EventoVazioControleVelocidade() {
	}

	@Override
	public void aoAlterarVelocidade(int porcentagem) {
	}

}
