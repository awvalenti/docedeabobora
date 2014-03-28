package com.github.awvalenti.docedeabobora.interfaceusuario.swing.fabrica;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.ControleUmaVelocidade;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.PainelControle;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.PainelRaias;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.Raia;

public class FabricaObjetosSwing {

	public static JPanel fabricarPainelGeral(PainelRaias painelRaias, PainelControle painelControle) {
		JPanel painelGeral = new JPanel();
		painelGeral.setLayout(new BoxLayout(painelGeral, BoxLayout.Y_AXIS));
		painelGeral.add(painelRaias);
		painelGeral.add(painelControle);
		return painelGeral;
	}

	public static Raia fabricarRaiaAboboras() {
		return fabricarRaiaGenerica("Ab\u00f3boras", "/img/abobora.jpg");
	}

	public static Raia fabricarRaiaDoces() {
		return fabricarRaiaGenerica("Doces", "/img/doce-de-abobora.jpg");
	}

	private static Raia fabricarRaiaGenerica(String titulo, String caminhoImagemNoClasspath) {
		return new Raia(titulo, 10, caminhoImagemNoClasspath, 100, 100);
	}

	public static ControleUmaVelocidade criarControleVelocidadeAgricultor() {
		return new ControleUmaVelocidade("Agricultor");
	}

	public static ControleUmaVelocidade criarControleVelocidadeDoceiro() {
		return new ControleUmaVelocidade("Doceiro");
	}

	public static ControleUmaVelocidade criarControleVelocidadeClientela() {
		return new ControleUmaVelocidade("Clientela");
	}

}
