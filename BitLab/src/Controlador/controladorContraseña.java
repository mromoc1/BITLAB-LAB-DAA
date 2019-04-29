package Controlador;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Modelo.BaseDeDatos;
import Vista.Administrador;
import Vista.Contrase�a;

public class controladorContrase�a implements ActionListener {
	
	Contrase�a ventanaContrase�a;

	public controladorContrase�a(Contrase�a ventanaContrase�a) {
		this.ventanaContrase�a = ventanaContrase�a;
		
		this.ventanaContrase�a.botonIngresarContrase�a.addActionListener(this);
		
	}
	
	public void iniciarVentana() {
		ventanaContrase�a.setIconImage(Toolkit.getDefaultToolkit().getImage("Imagen\\businessman-with-shield.png"));
		ventanaContrase�a.setTitle("");
		ventanaContrase�a.setSize(400, 150);
		ventanaContrase�a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventanaContrase�a.setLocationRelativeTo(null);
		ventanaContrase�a.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ventanaContrase�a.botonIngresarContrase�a) {
			if(BaseDeDatos.coincide(String.copyValueOf(ventanaContrase�a.passwordField.getPassword()))) {
				ventanaContrase�a.dispose();
				Administrador ventanaAdministrador = new Administrador();
				controladorAdministrador controlador = new controladorAdministrador(ventanaAdministrador);
				controlador.iniciarVentana();
			}else {
				JOptionPane.showMessageDialog(null, "Contrase�a Erronea","Error",JOptionPane.ERROR_MESSAGE);
				ventanaContrase�a.passwordField.setText("");
			}
		}
		
	}
	
	
	
}
