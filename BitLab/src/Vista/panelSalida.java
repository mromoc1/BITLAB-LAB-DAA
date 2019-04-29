package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class panelSalida extends JPanel {
	
	private Font f = new Font("Century Gothic", Font.PLAIN, 16);
	public JTextField camporut;
	public JButton botonsalida;

	/**
	 * Create the panel.
	 */
	public panelSalida() {
		setBounds(220, 103, 472, 150);
		setLayout(new BorderLayout());
		
		add(new JPanel(),BorderLayout.EAST);
		add(PanelOeste(),BorderLayout.WEST);
		add(PanelSur(),BorderLayout.SOUTH);
		add(PanelCentral(),BorderLayout.CENTER);
	}
	
	JPanel PanelCentral() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		camporut = new JTextField();
		camporut.setBounds(10, 35, 403, 30);
		camporut.setFont(f);
		panel.add(camporut);
		
		return panel;
	}
	
	JPanel PanelOeste() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel textorut = new JLabel(" Rut: ");
		textorut.setFont(f);
		panel.add(textorut);
	
		
		return panel;
	}
	
	JPanel PanelSur() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		botonsalida = new JButton("Anotar Salida");
		botonsalida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonsalida.setBackground(Color.LIGHT_GRAY);
		botonsalida.setFont(f);
		
		panel.add(botonsalida);
		
		return panel;
	}

}
