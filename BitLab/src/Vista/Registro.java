package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Registro extends JFrame {

	private Font f = new Font("Century Gothic", Font.PLAIN, 16);
	
	public JButton BotonFinalizar;
	public JTextField camporut,camponombre,campomail;
	public JComboBox BoxNivel;

	public Registro() {
		getContentPane().add(new JPanel(),BorderLayout.EAST);
		getContentPane().add(PanelNorte(),BorderLayout.NORTH);
		getContentPane().add(PanelOeste(),BorderLayout.WEST);
		getContentPane().add(PanelSur(),BorderLayout.SOUTH);
		getContentPane().add(PanelCentral(),BorderLayout.CENTER);
		
	}
	
	public JPanel PanelNorte() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout());		
		JLabel titulo = new JLabel("Registro");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Century Gothic", Font.PLAIN, 44));
		panel.add(titulo,BorderLayout.CENTER);
		
		return panel;
	}
	
	public JPanel PanelOeste() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,1,1,1));
		
		JLabel textonombre = new JLabel(" Nombre: ");
		textonombre.setFont(f);
		panel.add(textonombre);
		
		JLabel textorut = new JLabel(" Rut: ");
		textorut.setFont(f);
		panel.add(textorut);
		
		JLabel textomail = new JLabel(" Mail: ");
		textomail.setFont(f);
		panel.add(textomail);
		
		JLabel textonivel = new JLabel(" Nivel: ");
		textonivel.setFont(f);
		panel.add(textonivel);
		
		return panel;
	}
	
	JPanel PanelCentral() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1,10,5));
		
		camponombre = new JTextField();
		camponombre.setFont(f);
		panel.add(camponombre);
		
		camporut = new JTextField();
		camporut.setFont(f);
		panel.add(camporut);
		
		campomail = new JTextField();
		campomail.setFont(f);
		panel.add(campomail);
		
		BoxNivel = new JComboBox();
		BoxNivel.setFont(f);
		for(int i =1;i<=10;i++)
			BoxNivel.addItem(""+i);
		panel.add(BoxNivel);
		
		return panel;
	}
	
	public JPanel PanelSur() {
		JPanel panel = new JPanel(); 
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		BotonFinalizar = new JButton("Finalizar Registro");
		BotonFinalizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BotonFinalizar.setBackground(Color.LIGHT_GRAY);
		BotonFinalizar.setFont(f);
		
		panel.add(BotonFinalizar);
		
		return panel;
	}

}
