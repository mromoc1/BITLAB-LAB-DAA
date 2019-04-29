package Vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class panelModificar extends JPanel {
	
	private Font f = new Font("Century Gothic", Font.PLAIN, 16);
	public JButton botonModificar, botonEliminar, botonGuardarCambios;
	public JTextField camporut,camponombre,campomail;
	public JComboBox BoxNivel;

	
	public panelModificar() {
		setBounds(220, 114, 654, 466);
		setLayout(null);
		
		
		add(panelBotones());
		add(panelNombres());
		add(panelCampos());
		
	}
	
	public JPanel panelNombres() {
		
		JPanel panel = new JPanel();
		panel.setBounds(111, 100, 80, 149);
		panel.setLayout(new GridLayout(0, 1, 1, 1));
		
		JLabel label_1 = new JLabel(" Rut:");
		label_1.setFont(f);
		panel.add(label_1);
		
		JLabel label = new JLabel(" Nombre:");
		label.setFont(f);
		panel.add(label);
		
		JLabel label_2 = new JLabel(" Mail:");
		label_2.setFont(f);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel(" Nivel:");
		label_3.setFont(f);
		panel.add(label_3);
		
		return panel;
	}
	
	public JPanel panelCampos() {
		JPanel panel = new JPanel();
		panel.setBounds(191, 100, 344, 149);
		panel.setLayout(new GridLayout(0, 1, 10, 5));
		
		camporut = new JTextField();
		camporut.setFont(f);
		panel.add(camporut);
		
		camponombre = new JTextField();
		camponombre.setFont(f);
		panel.add(camponombre);
		camponombre.setEditable(false);
		
		campomail = new JTextField();
		campomail.setFont(f);
		panel.add(campomail);
		campomail.setEditable(false);
		
		BoxNivel = new JComboBox();
		BoxNivel.setFont(f);
		for(int i =1;i<=10;i++)
			BoxNivel.addItem(""+i);
		panel.add(BoxNivel);
		BoxNivel.setVisible(false);
		
		return panel;
	}
	
	public JPanel panelBotones() {
		JPanel panel = new JPanel();
		
		panel.setBounds(111, 263, 424, 53);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		botonModificar = new JButton("Modificar");
		botonModificar.setFont(f);
		botonModificar.setBackground(Color.LIGHT_GRAY);
		panel.add(botonModificar);
		
		botonEliminar = new JButton("Eliminar");
		botonEliminar.setFont(f);
		botonEliminar.setBackground(Color.LIGHT_GRAY);
		panel.add(botonEliminar);
		
		botonGuardarCambios = new JButton("Guardar");
		botonGuardarCambios.setFont(f);
		botonGuardarCambios.setBackground(Color.LIGHT_GRAY);
		botonGuardarCambios.setVisible(false);
		panel.add(botonGuardarCambios);
		
		return panel;
	}
	
	
}
