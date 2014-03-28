package com.github.awvalenti.docedeabobora.interfaceusuario.swing.fabrica;

import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.Raia;

public class FabricaObjetosSwing {

	public static Raia fabricarRaiaAboboras() {
		return fabricarRaiaGenerica("Ab\u00f3boras", "/img/abobora.jpg");
	}

	public static Raia fabricarRaiaDoces() {
		return fabricarRaiaGenerica("Doces", "/img/doce-de-abobora.jpg");
	}

	private static Raia fabricarRaiaGenerica(String titulo, String caminhoImagemNoClasspath) {
		return new Raia(titulo, 10, caminhoImagemNoClasspath, 100, 100);
	}

}
