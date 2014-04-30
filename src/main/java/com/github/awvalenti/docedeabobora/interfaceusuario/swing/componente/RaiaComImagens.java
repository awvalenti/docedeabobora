package com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RaiaComImagens extends Raia {
	private static final long serialVersionUID = 1L;

	private final int capacidade;
	private JLabel labelAlemDaCapacidade;

	public RaiaComImagens(String titulo, int capacidade, String caminhoImagemNoClasspath, int larguraImagem, int alturaImagem) {
		super(titulo, larguraImagem, alturaImagem);
		
		this.capacidade = capacidade;

		configurarPainelConteudo(caminhoImagemNoClasspath, larguraImagem, alturaImagem);
	}

	@Override
	public void setQuantidade(int quantidadeProdutos) {
		final int quantidadeImagensAExibir = Math.min(quantidadeProdutos, capacidade);

		for (int i = 0; i < quantidadeImagensAExibir; ++i) {
			painelConteudo.getComponent(i).setEnabled(true);
		}

		for (int i = quantidadeProdutos; i < capacidade; ++i) {
			painelConteudo.getComponent(i).setEnabled(false);
		}

		labelAlemDaCapacidade.setEnabled(quantidadeProdutos > capacidade);
	}

	private void configurarPainelConteudo(String caminhoImagemNoClasspath, int larguraImagem, int alturaImagem) {
		Icon iconeImagemAtiva = new ImageIcon(lerImagem(caminhoImagemNoClasspath).getScaledInstance(larguraImagem, alturaImagem, Image.SCALE_SMOOTH));
		Icon iconeImagemInativa = new IconeVazio(larguraImagem, alturaImagem);

		for (int i = 0; i < capacidade; ++i) {
			JLabel labelImagem = new JLabel(iconeImagemAtiva);
			labelImagem.setDisabledIcon(iconeImagemInativa);
			painelConteudo.add(labelImagem);
		}

		criarLabelAlemDaCapacidade();
		painelConteudo.add(labelAlemDaCapacidade);
		setQuantidade(0);
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