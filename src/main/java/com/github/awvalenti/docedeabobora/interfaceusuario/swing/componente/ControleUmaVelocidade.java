package com.github.awvalenti.docedeabobora.interfaceusuario.swing.componente;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControleUmaVelocidade extends JPanel implements ChangeListener {
	private static final long serialVersionUID = 1L;

	private final JSlider slider;
	private final JLabel labelValor;

	public ControleUmaVelocidade(String nome) {
		super(new BorderLayout());
		setBorder(new EmptyBorder(10, 10, 10, 10));

		slider = new JSlider(SwingConstants.VERTICAL, 0, 100, 50);
		slider.addChangeListener(this);

		labelValor = new JLabel();
		labelValor.setHorizontalAlignment(SwingConstants.CENTER);
		stateChanged(null);

		add(new JLabel(nome, SwingConstants.CENTER), BorderLayout.NORTH);
		add(slider, BorderLayout.CENTER);
		add(labelValor, BorderLayout.SOUTH);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		labelValor.setText(String.valueOf(slider.getValue()) + "%");
	}

}