package com.github.awvalenti.docedeabobora.nucleo;

import java.lang.Thread.State;

public class TrabalhadorPeriodico {

	private final Runnable tarefa;
	private final Thread thread;
	private long periodo;

	public TrabalhadorPeriodico(Runnable tarefa, int periodo) {
		this.tarefa = tarefa;
		this.thread = new ThreadTrabalhadorPeriodico();
		setPeriodo(periodo);
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
		if (thread.getState() == State.TIMED_WAITING) thread.interrupt();
	}

}
