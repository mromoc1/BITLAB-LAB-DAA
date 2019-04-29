package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Estudiante extends JFrame {

	private Font f = new Font("Century Gothic", Font.PLAIN, 16);
	public JPanel panelcambio;
	public JButton botonIngresar, botonSalida, botonAdmin;
	public JLabel botonInformacion;
	
	public Estudiante() {
		
		getContentPane().setLayout(null);
		inicializarPanel();
		getContentPane().add(panelBotones());
		
		panelcambio = new JPanel();
		panelcambio.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelcambio.setBounds(220, 103, 472, 150);
		getContentPane().add(panelcambio);
		panelcambio.setLayout(new BorderLayout(0, 0));
		
		botonInformacion = new JLabel("i");
		botonInformacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonInformacion.setBorder(new LineBorder(new Color(0, 0, 0)));
		botonInformacion.setBackground(SystemColor.control);
		botonInformacion.setHorizontalAlignment(SwingConstants.CENTER);
		botonInformacion.setHorizontalTextPosition(SwingConstants.CENTER);
		botonInformacion.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		botonInformacion.setBounds(653, 11, 30, 30);
		getContentPane().add(botonInformacion);
		
		
	}
	
	public JPanel panelBotones() {
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(10, 77, 200, 203);
		
		JPanel panelbotones = new JPanel();
		panelbotones.setBounds(10, 11, 180, 181);
		panelbotones.setLayout(new GridLayout(0, 1, 0, 5));
		
		botonIngresar = new JButton("Anotar Entrada"); 
		botonIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonIngresar.setBackground(Color.LIGHT_GRAY);
		botonIngresar.setFont(f);
		
		botonSalida = new JButton("Anotar Salida");
		botonSalida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonSalida.setBackground(Color.LIGHT_GRAY);
		botonSalida.setFont(f);
		
		botonAdmin  = new JButton("Administrador");
		botonAdmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAdmin.setBackground(Color.LIGHT_GRAY);
		botonAdmin.setFont(f);
		
		panelbotones.add(botonIngresar);
		panelbotones.add(botonSalida);
		panelbotones.add(botonAdmin);
		panel.add(panelbotones);
		
		return panel;
	}
	
	public void inicializarPanel() {
		
		JLabel titulo = new JLabel("Regístrese Aquí");
		titulo.setFont(new Font("Century Gothic", Font.PLAIN, 40));
		titulo.setBounds(220, 11, 303, 55);
		getContentPane().add(titulo);
		
		
		
	}
}
