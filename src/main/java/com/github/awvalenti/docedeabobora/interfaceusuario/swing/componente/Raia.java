package com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
	private JLabel labelAlemDaCapacidade;
	private JPanel painelProdutos;

	public Raia(String titulo, int capacidade, String caminhoImagemNoClasspath, int larguraImagem, int alturaImagem) {
		super(new BorderLayout());

		this.capacidade = capacidade;

		criarLabelAlemDaCapacidade();
		criarPainelProdutos(caminhoImagemNoClasspath, larguraImagem, alturaImagem);

		add(new JLabel(titulo), BorderLayout.WEST);
		add(painelProdutos, BorderLayout.CENTER);

		setQuantidadeProdutos(0);
	}

	public void setQuantidadeProdutos(int quantidadeProdutos) {
		final int quantidadeImagensAExibir = Math.min(quantidadeProdutos, capacidade);

		for (int i = 0; i < quantidadeImagensAExibir; ++i) {
			painelProdutos.getComponent(i).setEnabled(true);
		}

		for (int i = quantidadeProdutos; i < capacidade; ++i) {
			painelProdutos.getComponent(i).setEnabled(false);
		}

		labelAlemDaCapacidade.setEnabled(quantidadeProdutos > capacidade);
	}

	private void criarLabelAlemDaCapacidade() {
		labelAlemDaCapacidade = new JLabel("...");
		labelAlemDaCapacidade.setFont(new Font(Font.SERIF, Font.BOLD, 50));
		labelAlemDaCapacidade.setForeground(Color.RED);
	}

	private void criarPainelProdutos(String caminhoImagemNoClasspath, int larguraImagem, int alturaImagem) {
		painelProdutos = new JPanel(new FlowLayout(FlowLayout.LEFT));
		painelProdutos.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), BorderFactory.createLineBorder(Color.GRAY)));

		Icon iconeImagemAtiva = new ImageIcon(lerImagem(caminhoImagemNoClasspath).getScaledInstance(larguraImagem, alturaImagem, Image.SCALE_SMOOTH));
		Icon iconeImagemInativa = new IconeVazio(larguraImagem, alturaImagem);

		for (int i = 0; i < capacidade; ++i) {
			JLabel labelImagem = new JLabel(iconeImagemAtiva);
			labelImagem.setDisabledIcon(iconeImagemInativa);
			painelProdutos.add(labelImagem);
		}

		painelProdutos.add(labelAlemDaCapacidade);
	}

	private static BufferedImage lerImagem(String caminhoImagemNoClasspath) {
		try {
			return ImageIO.read(Raia.class.getResourceAsStream(caminhoImagemNoClasspath));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}