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

	public ControleUmaVelocidade(String nome) {
		super(new BorderLayout());
		setBorder(new EmptyBorder(10, 10, 10, 10));

		slider = new JSlider(SwingConstants.VERTICAL, 0, 100, 50);
		slider.addChangeListener(this);

		add(new JLabel(nome, JLabel.CENTER), BorderLayout.NORTH);
		add(slider, BorderLayout.SOUTH);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		slider.getValue();
	}

}