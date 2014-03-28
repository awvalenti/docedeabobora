package com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PainelRaias extends JPanel {
	private static final long serialVersionUID = 1L;

	public PainelRaias(Raia... raias) {
		super(new GridLayout(raias.length, 1));
		setBorder(new EmptyBorder(10, 10, 10, 10));

		for (Raia raia : raias) {
			add(raia);
		}
	}

}