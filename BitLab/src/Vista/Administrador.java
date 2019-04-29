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
import javax.swing.SwingConstants;

public class Administrador extends JFrame {
	
	private Font f = new Font("Century Gothic", Font.PLAIN, 16);
	public JPanel panelcambio;
	public JButton botonModificar, botonRegistrados, botonBitacora, botonImportarregistro, botonExportarregistro, botonExportarbitacora;

	public Administrador() {
		getContentPane().add(panelBotones(),BorderLayout.SOUTH);
		
		panelcambio = new JPanel();
		panelcambio.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panelcambio,BorderLayout.CENTER);
		panelcambio.setLayout(new BorderLayout(0, 0));
		
		
		JLabel label = new JLabel("Administrador");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Century Gothic", Font.PLAIN, 40));
		getContentPane().add(label,BorderLayout.NORTH);

	}
	
	public JPanel panelBotones() {
		JPanel panelbotones = new JPanel();
		panelbotones.setLayout(new GridLayout(1, 0, 0, 5));
		
		botonModificar = new JButton("<html><p>Modificar  </p><p>Registro</p><html>\r\n\r\n");
		botonModificar.setFont(f);
		botonModificar.setBackground(Color.LIGHT_GRAY);
		panelbotones.add(botonModificar);
		
		botonRegistrados = new JButton("<html><p>Ver </p><p>Registro</p><html>\r\n");
		botonRegistrados.setFont(f);
		botonRegistrados.setBackground(Color.LIGHT_GRAY);
		panelbotones.add(botonRegistrados);
		
		botonBitacora = new JButton("<html><p>Ver</p><p>Bit\u00E1cora</p><html>");
		botonBitacora.setFont(f);
		botonBitacora.setBackground(Color.LIGHT_GRAY);
		panelbotones.add(botonBitacora);
		
		botonImportarregistro = new JButton("<html><p> Importar </p><p>Registro</p><html>");
		botonImportarregistro.setFont(f);
		botonImportarregistro.setBackground(Color.LIGHT_GRAY);
		panelbotones.add(botonImportarregistro);
		
		botonExportarregistro = new JButton("<html><p>Exportar</p><p>Registro</p><html>");
		botonExportarregistro.setFont(f);
		botonExportarregistro.setBackground(Color.LIGHT_GRAY);
		panelbotones.add(botonExportarregistro);
		
		botonExportarbitacora = new JButton("<html><p>Exportar</p><p>Bit\u00E1cora</p><html>");
		botonExportarbitacora.setFont(f);
		botonExportarbitacora.setBackground(Color.LIGHT_GRAY);
		panelbotones.add(botonExportarbitacora);
	
		return panelbotones;
	}
}
