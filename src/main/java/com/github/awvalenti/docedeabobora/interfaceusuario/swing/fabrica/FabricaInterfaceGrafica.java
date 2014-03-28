package com.github.awvalenti.docedeabobora.interfaceusuario.swing.fabrica;

import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.PainelRaias;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.Raia;

public class FabricaInterfaceGrafica {

	public static PainelRaias fabricarPainelRaias() {
		final int capacidade = 10;

		Raia raiaAboboras = new Raia("Ab\u00f3boras", capacidade, "/img/abobora.jpg", 100, 100);
		Raia raiaDoces = new Raia("Doces", capacidade, "/img/doce-de-abobora.jpg", 100, 100);

		raiaAboboras.setQuantidadeProdutos(capacidade / 2);
		raiaDoces.setQuantidadeProdutos(capacidade / 2);

		return new PainelRaias(raiaAboboras, raiaDoces);
	}

}
