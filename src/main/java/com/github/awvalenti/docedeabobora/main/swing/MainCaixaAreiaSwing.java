package com.github.awvalenti.docedeabobora.main.swing;

import javax.swing.JFrame;

import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.ControleUmaVelocidade;

public class MainCaixaAreiaSwing {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Doce de abobora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(new ControleUmaVelocidade("Agricultor"));
		frame.pack();

		frame.setVisible(true);
	}
}
