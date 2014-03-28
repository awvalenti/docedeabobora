package com.github.awvalenti.docedeabobora.interfaceusuario.swing.fabrica;

import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.PainelRaias;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.Raia;

public class FabricaInterfaceGrafica {

	public static PainelRaias fabricarPainelRaias() {
		Raia raiaAboboras = new Raia("Ab\u00f3boras", 3, "/img/abobora.jpg", 100, 100);
		raiaAboboras.setQuantidadeProdutos(2);

		Raia raiaDoces = new Raia("Doces", 3, "/img/doce-de-abobora.jpg", 100, 100);
		raiaDoces.setQuantidadeProdutos(3);

		return new PainelRaias(raiaAboboras, raiaDoces);
	}

}
