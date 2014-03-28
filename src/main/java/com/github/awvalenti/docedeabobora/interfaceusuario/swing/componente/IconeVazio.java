package com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class IconeVazio implements Icon {
	private final int largura;
	private final int altura;

	public IconeVazio(int largura, int altura) {
		this.largura = largura;
		this.altura = altura;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
	}

	@Override
	public int getIconWidth() {
		return largura;
	}

	@Override
	public int getIconHeight() {
		return altura;
	}

}
