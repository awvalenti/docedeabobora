package com.github.awvalenti.docedeabobora.main;

import javax.swing.JFrame;

import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.PainelRaias;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.fabrica.FabricaInterfaceGrafica;

public class MainCaixaAreiaSwing {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Doce de ab\u00f3bora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(new PainelRaias(FabricaInterfaceGrafica.fabricarRaiaAboboras(), FabricaInterfaceGrafica.fabricarRaiaDoces()));

		frame.pack();
		frame.setVisible(true);
	}
}
