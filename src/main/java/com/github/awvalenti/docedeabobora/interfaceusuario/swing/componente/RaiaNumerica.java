package com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente;

import java.awt.Font;

import javax.swing.JLabel;

public class RaiaNumerica extends Raia {
	private static final long serialVersionUID = 1L;
	
	private JLabel labelQuantidade;

	public RaiaNumerica(String titulo, int larguraTitulo, int alturaTitulo, String textoADireita) {
		super(titulo, larguraTitulo, alturaTitulo);
		
		labelQuantidade = new JLabel("0");
		labelQuantidade.setFont(new Font(Font.SERIF, Font.BOLD, 50));
		labelQuantidade.setVerticalAlignment(JLabel.CENTER);
		painelConteudo.add(labelQuantidade);
		
		JLabel labelTextoADireita = new JLabel(" " + textoADireita);
		labelTextoADireita.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		painelConteudo.add(labelTextoADireita);
	}

	@Override
	public void setQuantidade(int quantidadeProdutos) {
		labelQuantidade.setText(String.valueOf(quantidadeProdutos));
	}

}