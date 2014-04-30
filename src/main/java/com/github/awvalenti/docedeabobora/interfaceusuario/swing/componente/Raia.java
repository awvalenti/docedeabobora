package com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public abstract class Raia extends JPanel {
	private static final long serialVersionUID = 1L;
	
	protected JPanel painelConteudo;

	public Raia(String titulo, int larguraTitulo, int alturaTitulo) {
		super(new BorderLayout());
		
		JLabel labelTitulo = new JLabel(titulo);
		labelTitulo.setPreferredSize(new Dimension(larguraTitulo, alturaTitulo));
		labelTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(labelTitulo, BorderLayout.WEST);

		painelConteudo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		painelConteudo.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), BorderFactory.createLineBorder(Color.GRAY)));
		add(painelConteudo, BorderLayout.CENTER);
	}

	public abstract void setQuantidade(int quantidadeProdutos);

}