package com.github.awvalenti.docedeabobora.nucleo.fabrica;

import java.util.concurrent.Callable;

import com.github.awvalenti.docedeabobora.nucleo.Consumidor;
import com.github.awvalenti.docedeabobora.nucleo.Deposito;
import com.github.awvalenti.docedeabobora.nucleo.EventoDeposito;
import com.github.awvalenti.docedeabobora.nucleo.Produtor;
import com.github.awvalenti.docedeabobora.nucleo.TrabalhadorPeriodico;
import com.github.awvalenti.docedeabobora.nucleo.Transformador;

public class FabricaObjetos {

	public static Deposito fabricarDepositoAboboras(EventoDeposito eventoDeposito) {
		return fabricarDepositoGenerico(eventoDeposito);
	}

	public static Deposito fabricarDepositoDoces(EventoDeposito eventoDeposito) {
		return fabricarDepositoGenerico(eventoDeposito);
	}

	public static TrabalhadorPeriodico fabricarAgricultor(Deposito depositoAboboras) {
		return new TrabalhadorPeriodico(new Produtor(depositoAboboras), INTERVALO_PADRAO);
	}

	public static TrabalhadorPeriodico fabricarDoceiro(Deposito depositoAboboras, Deposito depositoDoces) {
		return new TrabalhadorPeriodico(new Transformador(depositoAboboras, depositoDoces), INTERVALO_PADRAO);
	}

	public static TrabalhadorPeriodico fabricarClientela(Deposito depositoDoces) {
		return new TrabalhadorPeriodico(new Consumidor(depositoDoces), INTERVALO_PADRAO);
	}

	private static Deposito fabricarDepositoGenerico(EventoDeposito eventoDeposito) {
		return new Deposito(0, 10, eventoDeposito);
	}

	private static final Callable<Long> INTERVALO_PADRAO = new Callable<Long>() {
		@Override
		public Long call() {
			return Long.valueOf(1000 + (long) (Math.random() * 1000));
		}
	};

}
