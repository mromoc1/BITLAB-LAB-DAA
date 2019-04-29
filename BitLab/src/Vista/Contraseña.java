package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class Contraseña extends JFrame {
	
	private Font f = new Font("Century Gothic", Font.PLAIN, 16);
	public JButton botonIngresarContraseña;
	public JPasswordField passwordField;
	
	public Contraseña() {
		JLabel lblNewLabel = new JLabel("Ingrese Clave");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		
		getContentPane().add(new JPanel(), BorderLayout.EAST);
		getContentPane().add(new JPanel(), BorderLayout.WEST);
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		getContentPane().add(panelCampo(),BorderLayout.CENTER);
		getContentPane().add(panelBoton(),BorderLayout.SOUTH);
		
	}
	
	public JPanel panelCampo() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0, 5, 10));
		
		passwordField = new JPasswordField();
		passwordField.setFont(f);
		panel.add(passwordField);
		
		return panel;
	}
	
	public JPanel panelBoton() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		botonIngresarContraseña = new JButton("Ingresar");
		botonIngresarContraseña.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonIngresarContraseña.setBackground(Color.LIGHT_GRAY);
		botonIngresarContraseña.setFont(f);
		
		panel.add(botonIngresarContraseña);
		return panel;
	}
}
