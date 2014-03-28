package com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
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
		setBorder(new EmptyBorder(10, 10, 10, 10));

		this.capacidade = capacidade;
		this.labelAlemDaCapacidade = new JLabel(". . .");

		final Image imagem = lerImagem(inputStreamImagem).getScaledInstance(larguraImagem, alturaImagem, Image.SCALE_SMOOTH);

		for (int i = 0; i < capacidade; ++i) {
			add(new JLabel(new ImageIcon(imagem)));
		}
		add(labelAlemDaCapacidade);

		setQuantidadeItens(0);
	}

	public void setQuantidadeItens(int quantidadeItens) {
		final int quantidadeImagensAExibir = Math.min(quantidadeItens, capacidade);

		for (int i = 0; i < quantidadeImagensAExibir; ++i) {
			getComponent(i).setVisible(true);
		}

		for (int i = quantidadeItens; i < capacidade; ++i) {
			getComponent(i).setVisible(false);
		}

		labelAlemDaCapacidade.setVisible(quantidadeItens > capacidade);
	}

	private static BufferedImage lerImagem(InputStream inputStream) {
		try {
			return ImageIO.read(inputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}