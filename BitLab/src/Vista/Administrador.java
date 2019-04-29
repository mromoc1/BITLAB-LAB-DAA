package Vista;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Administrador extends JFrame {
	
	private Font f = new Font("Century Gothic", Font.PLAIN, 16);
	public JPanel panelcambio;
	public JButton botonModificar, botonRegistrados, botonBitacora, botonImportarregistro, botonExportarregistro, botonExportarbitacora;

	public Administrador() {
		
		getContentPane().setLayout(null);
		getContentPane().add(panelBotones());
		
		panelcambio = new JPanel();
		panelcambio.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelcambio.setBounds(220, 114, 654, 466);
		getContentPane().add(panelcambio);
		panelcambio.setLayout(new BorderLayout(0, 0));
		
		
		JLabel label = new JLabel("Administrador");
		label.setFont(new Font("Century Gothic", Font.PLAIN, 40));
		label.setBounds(304, 29, 275, 55);
		getContentPane().add(label);

	}
	
	public JPanel panelBotones() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 114, 200, 466);
		getContentPane().add(panel);
		
		JPanel panelbotones = new JPanel();
		panelbotones.setBounds(10, 11, 180, 444);
		panel.add(panelbotones);
		panelbotones.setLayout(new GridLayout(0, 1, 0, 5));
		
		botonModificar = new JButton("Modificar Registro");
		botonModificar.setFont(f);
		botonModificar.setBackground(Color.LIGHT_GRAY);
		panelbotones.add(botonModificar);
		
		botonRegistrados = new JButton("Ver Registro");
		botonRegistrados.setFont(f);
		botonRegistrados.setBackground(Color.LIGHT_GRAY);
		panelbotones.add(botonRegistrados);
		
		botonBitacora = new JButton("Ver Bitácora");
		botonBitacora.setFont(f);
		botonBitacora.setBackground(Color.LIGHT_GRAY);
		panelbotones.add(botonBitacora);
		
		botonImportarregistro = new JButton("Importar Registro");
		botonImportarregistro.setFont(f);
		botonImportarregistro.setBackground(Color.LIGHT_GRAY);
		panelbotones.add(botonImportarregistro);
		
		botonExportarregistro = new JButton("Exportar Registro");
		botonExportarregistro.setFont(f);
		botonExportarregistro.setBackground(Color.LIGHT_GRAY);
		panelbotones.add(botonExportarregistro);
		
		botonExportarbitacora = new JButton("Exportar Bitácora");
		botonExportarbitacora.setFont(f);
		botonExportarbitacora.setBackground(Color.LIGHT_GRAY);
		panelbotones.add(botonExportarbitacora);
	
		return panel;
	}
}
