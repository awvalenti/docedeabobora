package com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PainelControle extends JPanel {
	private static final long serialVersionUID = 1L;

	public PainelControle(ControleUmaVelocidade... controles) {
		super(new BorderLayout());
		setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel painelControles = new JPanel();
		for (ControleUmaVelocidade controle : controles) {
			painelControles.add(controle);
		}

		add(new JLabel("Velocidades", SwingConstants.CENTER), BorderLayout.NORTH);
		add(painelControles, BorderLayout.CENTER);
	}

}