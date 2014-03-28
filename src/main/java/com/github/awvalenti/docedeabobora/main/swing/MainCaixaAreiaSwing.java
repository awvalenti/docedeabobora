package com.github.awvalenti.docedeabobora.main.swing;

import javax.swing.JFrame;

import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.PainelRaias;

public class MainCaixaAreiaSwing {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Doce de abobora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(new PainelRaias("Aboboras", "Doces"));

		frame.pack();
		frame.setVisible(true);
	}
}
