package com.github.awvalenti.docedeabobora.interfaceusuario.swing.fabrica;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.ControleUmaVelocidade;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.PainelControle;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.PainelRaias;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.Raia;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.RaiaComImagens;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente.RaiaNumerica;
import com.github.awvalenti.docedeabobora.interfaceusuario.swing.controlador.EventoControleVelocidade;

public class FabricaObjetosSwing {

	private static final int TAMANHO_IMAGEM = 100;

	public static JPanel fabricarPainelGeral(PainelRaias painelRaias, PainelControle painelControle) {
		JPanel painelGeral = new JPanel();
		painelGeral.setLayout(new BoxLayout(painelGeral, BoxLayout.Y_AXIS));
		painelGeral.add(painelRaias);
		painelGeral.add(painelControle);
		return painelGeral;
	}

	public static Raia fabricarRaiaAboboras() {
		return fabricarRaiaComImagens("Ab\u00f3boras", "/img/abobora.jpg");
	}

	public static Raia fabricarRaiaDoces() {
		return fabricarRaiaComImagens("Doces", "/img/doce-de-abobora.jpg");
	}

	public static Raia fabricarRaiaClientela() {
		return new RaiaNumerica("Resultado", TAMANHO_IMAGEM, TAMANHO_IMAGEM, "cliente(s) satisfeito(s)");
	}

	private static Raia fabricarRaiaComImagens(String titulo, String caminhoImagemNoClasspath) {
		return new RaiaComImagens(titulo, 10, caminhoImagemNoClasspath, TAMANHO_IMAGEM, TAMANHO_IMAGEM);
	}

	public static ControleUmaVelocidade criarControleVelocidadeAgricultor(EventoControleVelocidade eventoControleVelocidade) {
		return new ControleUmaVelocidade("Agricultor", eventoControleVelocidade);
	}

	public static ControleUmaVelocidade criarControleVelocidadeDoceiro(EventoControleVelocidade eventoControleVelocidade) {
		return new ControleUmaVelocidade("Doceiro", eventoControleVelocidade);
	}

	public static ControleUmaVelocidade criarControleVelocidadeClientela(EventoControleVelocidade eventoControleVelocidade) {
		return new ControleUmaVelocidade("Clientela", eventoControleVelocidade);
	}

}
