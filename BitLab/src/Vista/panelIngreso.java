package Vista;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class panelIngreso extends JPanel {
	
	private Font f = new Font("Century Gothic", Font.PLAIN, 16);
	public JTextField camporut;
	public JComboBox maquina;
	public JButton botonanotarhora;
	
	
	public panelIngreso() {
		setBounds(220, 103, 472, 150);
		setLayout(new BorderLayout());
		
		add(panelBoton(),BorderLayout.SOUTH);
		add(panelCentral(),BorderLayout.CENTER);
		
		
	}
	
	public JPanel panelCentral() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JPanel paneldelpanel = new JPanel();
		paneldelpanel.setBounds(10, 11, 452, 75);
		paneldelpanel.setLayout(new BorderLayout());
		
		paneldelpanel.add(panelTexto(),BorderLayout.WEST);
		paneldelpanel.add(panelCampos(),BorderLayout.CENTER);
		
		panel.add(paneldelpanel);
		return panel;
	}
	
	public JPanel panelTexto() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel textorut = new JLabel(" Rut:");
		textorut.setFont(f);
		panel.add(textorut);
		
		JLabel textomaquina = new JLabel(" Seleccione: ");
		textomaquina.setFont(f);
		panel.add(textomaquina);
		
		return panel;
	}
	
	public JPanel panelCampos() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1,10,5));
		
		camporut = new JTextField();
		camporut.setFont(f);
		panel.add(camporut);
		
		maquina = new JComboBox();
		maquina.setFont(f);
		maquina.addItem("PC 1");
		maquina.addItem("PC 2");
		maquina.addItem("PC 3");
		maquina.addItem("PC 4");
		maquina.addItem("Notebook");
		maquina.addItem("Ninguno");
		
		panel.add(maquina);
		return panel;
	}
	
	public JPanel panelBoton() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		botonanotarhora = new JButton("Anotar Hora");
		botonanotarhora.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonanotarhora.setBackground(Color.LIGHT_GRAY);
		botonanotarhora.setFont(f);
		
		panel.add(botonanotarhora);
		
		
		return panel;
	}
}
