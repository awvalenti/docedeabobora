package com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PainelRaias extends JPanel {
	private static final long serialVersionUID = 1L;
	private int i = 2;

	public PainelRaias(String... nomesRaias) {
		super(new GridLayout(nomesRaias.length, 1));
		setBorder(new EmptyBorder(10, 10, 10, 10));

		for (String nomeRaia : nomesRaias) {
			JPanel painel = new JPanel(new BorderLayout());
			painel.add(new JLabel(nomeRaia), BorderLayout.WEST);
			Raia raia = new Raia(3, "/img/abobora.jpg", 100, 100);
			raia.setQuantidadeItens(new Random().nextInt(5));
			painel.add(raia, BorderLayout.CENTER);
			add(painel);
		}
	}

}