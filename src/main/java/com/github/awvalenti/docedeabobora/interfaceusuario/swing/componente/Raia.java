package com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Raia extends JPanel {
	private static final long serialVersionUID = 1L;

	private final int capacidade;
	private JLabel labelAlemDaCapacidade;
	private JPanel painelProdutos;

	public Raia(String titulo, int capacidade, String caminhoImagemNoClasspath, int larguraImagem, int alturaImagem) {
		super(new BorderLayout());

		this.capacidade = capacidade;

		adicionarLabelTitulo(titulo, larguraImagem, alturaImagem);
		adicionarPainelProdutos(caminhoImagemNoClasspath, larguraImagem, alturaImagem);

		setQuantidadeProdutos(0);
	}

	private void adicionarLabelTitulo(String titulo, int larguraImagem, int alturaImagem) {
		JLabel labelTitulo = new JLabel(titulo);
		labelTitulo.setPreferredSize(new Dimension(larguraImagem, alturaImagem));
		labelTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(labelTitulo, BorderLayout.WEST);
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

	private void adicionarPainelProdutos(String caminhoImagemNoClasspath, int larguraImagem, int alturaImagem) {
		painelProdutos = new JPanel(new FlowLayout(FlowLayout.LEFT));
		painelProdutos.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), BorderFactory.createLineBorder(Color.GRAY)));

		Icon iconeImagemAtiva = new ImageIcon(lerImagem(caminhoImagemNoClasspath).getScaledInstance(larguraImagem, alturaImagem, Image.SCALE_SMOOTH));
		Icon iconeImagemInativa = new IconeVazio(larguraImagem, alturaImagem);

		for (int i = 0; i < capacidade; ++i) {
			JLabel labelImagem = new JLabel(iconeImagemAtiva);
			labelImagem.setDisabledIcon(iconeImagemInativa);
			painelProdutos.add(labelImagem);
		}

		criarLabelAlemDaCapacidade();
		painelProdutos.add(labelAlemDaCapacidade);
		add(painelProdutos, BorderLayout.CENTER);
	}

	private void criarLabelAlemDaCapacidade() {
		labelAlemDaCapacidade = new JLabel("...");
		labelAlemDaCapacidade.setFont(new Font(Font.SERIF, Font.BOLD, 50));
		labelAlemDaCapacidade.setForeground(Color.RED);
	}

	private static BufferedImage lerImagem(String caminhoImagemNoClasspath) {
		try {
			return ImageIO.read(Raia.class.getResourceAsStream(caminhoImagemNoClasspath));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}