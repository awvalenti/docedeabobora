package com.github.awvalenti.docedeabobora.main;

import javax.swing.JFrame;

import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.PainelControle;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.controlador.EventoVazioControleVelocidade;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.fabrica.FabricaObjetosSwing;

public class MainCaixaAreiaSwing {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Doce de Ab\u00f3bora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(new PainelControle(
			FabricaObjetosSwing.criarControleVelocidadeAgricultor(EventoVazioControleVelocidade.INSTANCIA),
			FabricaObjetosSwing.criarControleVelocidadeDoceiro(EventoVazioControleVelocidade.INSTANCIA),
			FabricaObjetosSwing.criarControleVelocidadeClientela(EventoVazioControleVelocidade.INSTANCIA)
		));

		frame.pack();
		frame.setVisible(true);
	}
}
