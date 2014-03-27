package com.github.awvalenti.docedeabobora;

public class Doceiro {

	private final Deposito depositoAboboras;
	private final Deposito depositoDoces;

	public Doceiro(Deposito depositoAboboras, Deposito depositoDoces) {
		this.depositoAboboras = depositoAboboras;
		this.depositoDoces = depositoDoces;
	}

	public void produzir() {
		if (depositoAboboras.consumir()) depositoDoces.produzir();
	}

}
