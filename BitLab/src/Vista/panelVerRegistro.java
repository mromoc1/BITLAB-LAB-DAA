package Vista;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.table.DefaultTableModel;

import Modelo.BaseDeDatos;


public class panelVerRegistro extends JPanel {
	private Font f = new Font("Century Gothic", Font.PLAIN, 12);
	
	private JTable tabla;
	
	public panelVerRegistro() {
		setBounds(220, 114, 654, 466);
		setLayout(new BorderLayout(0, 0));
		
		add(panelNorte(),BorderLayout.NORTH);
		add(panelCentral(),BorderLayout.CENTER);
	}
	
	public JPanel panelNorte() {
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("Lista de Alumnos Registrados");
		label.setFont(new Font("Century Gothic", Font.PLAIN, 35));
		label.setBounds(304, 29, 275, 55);
		panel.add(label);
		
		return panel;
	}
	
	public JScrollPane panelCentral() {
		JScrollPane panel = new JScrollPane();
		
		tabla = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		
		
		modelo.addColumn("Rut");
		modelo.addColumn("Nombre");
		modelo.addColumn("Nivel");
		modelo.addColumn("Mail");
		tabla.setModel(BaseDeDatos.CargarDatosRegistros(modelo));
		tabla.setFont(f);
		
		panel.setViewportView(tabla);
		return panel;
		
	}
}
