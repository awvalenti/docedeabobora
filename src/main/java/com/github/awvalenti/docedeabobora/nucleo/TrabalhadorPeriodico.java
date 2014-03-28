package com.github.awvalenti.docedeabobora.nucleo;

public class TrabalhadorPeriodico {

	private final Runnable tarefa;
	private final Thread thread;
	private long periodo;

	public TrabalhadorPeriodico(Runnable tarefa) {
		this.tarefa = tarefa;
		this.thread = new ThreadTrabalhadorPeriodico();
		setPeriodo(1000);
	}

	public void iniciar() {
		thread.start();
	}

	private class ThreadTrabalhadorPeriodico extends Thread {
		@Override
		public void run() {
			for (;;) {
				try {
					Thread.sleep(periodo);
					tarefa.run();
				} catch (InterruptedException e) {
				}
			}
		}
	}

	public void setPeriodo(long periodo) {
		this.periodo = periodo;
		thread.interrupt();
	}

}
