package com.github.awvalenti.docedeabobora.main;

import javax.swing.JFrame;

import com.github.awvalenti.docedeabobora.interfaceusuario.swing.fabrica.FabricaInterfaceGrafica;

public class MainCaixaAreiaSwing {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Doce de abobora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(FabricaInterfaceGrafica.fabricarPainelRaias());

		frame.pack();
		frame.setVisible(true);
	}
}
