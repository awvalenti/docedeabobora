package com.github.awvalenti.docedeabobora.nucleo;

import java.util.concurrent.Callable;

public class TrabalhadorPeriodico {

	private final Runnable tarefa;
	private final Callable<Long> formulaIntervalo;

	public TrabalhadorPeriodico(Runnable tarefa, Callable<Long> formulaIntervalo) {
		this.tarefa = tarefa;
		this.formulaIntervalo = formulaIntervalo;
	}

	public void iniciar() {
		new ThreadTrabalhadorPeriodico().start();
	}

	private class ThreadTrabalhadorPeriodico extends Thread {
		@Override
		public void run() {
			try {
				for (;;) {
					Thread.sleep(formulaIntervalo.call());
					tarefa.run();
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

		}
	}

}
