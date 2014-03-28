package com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Raia extends JPanel {
	private static final long serialVersionUID = 1L;

	private final int capacidade;
	private final JLabel labelAlemDaCapacidade;

	public Raia(int capacidade, String caminhoImagemNoClasspath, int larguraImagem, int alturaImagem) {
		this(capacidade, Raia.class.getResourceAsStream(caminhoImagemNoClasspath), larguraImagem, alturaImagem);
	}

	public Raia(int capacidade, InputStream inputStreamImagem, int larguraImagem, int alturaImagem) {
		super(new FlowLayout(FlowLayout.LEFT));
		setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), BorderFactory.createLineBorder(Color.GRAY)));


		this.capacidade = capacidade;
		this.labelAlemDaCapacidade = new JLabel("...");
		labelAlemDaCapacidade.setFont(new Font(Font.SERIF, Font.BOLD, 50));
		labelAlemDaCapacidade.setForeground(Color.RED);

		Icon iconeImagemAtiva = new ImageIcon(lerImagem(inputStreamImagem).getScaledInstance(larguraImagem, alturaImagem, Image.SCALE_SMOOTH));
		Icon iconeImagemInativa = new IconeVazio(larguraImagem, alturaImagem);

		for (int i = 0; i < capacidade; ++i) {
			JLabel labelImagem = new JLabel(iconeImagemAtiva);
			labelImagem.setDisabledIcon(iconeImagemInativa);
			add(labelImagem);
		}
		add(labelAlemDaCapacidade);

		setQuantidadeItens(0);
	}

	public void setQuantidadeItens(int quantidadeItens) {
		final int quantidadeImagensAExibir = Math.min(quantidadeItens, capacidade);

		for (int i = 0; i < quantidadeImagensAExibir; ++i) {
			getComponent(i).setEnabled(true);
		}

		for (int i = quantidadeItens; i < capacidade; ++i) {
			getComponent(i).setEnabled(false);
		}

		labelAlemDaCapacidade.setEnabled(quantidadeItens > capacidade);
	}

	private static BufferedImage lerImagem(InputStream inputStream) {
		try {
			return ImageIO.read(inputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}