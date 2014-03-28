package com.github.awvalenti.docedeabobora.main.swing;

import javax.swing.JFrame;

import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.Raia;

public class MainCaixaAreiaSwing {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Doce de abobora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Raia raia = new Raia(5, "/img/abobora.jpg", 100, 100);
		raia.setQuantidadeItens(7);
		frame.add(raia);

		frame.pack();

		frame.setVisible(true);
	}
}
