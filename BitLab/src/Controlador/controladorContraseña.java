package Controlador;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Modelo.BaseDeDatos;
import Vista.Administrador;
import Vista.Contraseña;

public class controladorContraseña implements ActionListener {
	
	Contraseña ventanaContraseña;

	public controladorContraseña(Contraseña ventanaContraseña) {
		this.ventanaContraseña = ventanaContraseña;
		
		this.ventanaContraseña.botonIngresarContraseña.addActionListener(this);
		
	}
	
	public void iniciarVentana() {
		ventanaContraseña.setIconImage(Toolkit.getDefaultToolkit().getImage("Imagen\\businessman-with-shield.png"));
		ventanaContraseña.setTitle("");
		ventanaContraseña.setSize(400, 150);
		ventanaContraseña.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventanaContraseña.setLocationRelativeTo(null);
		ventanaContraseña.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ventanaContraseña.botonIngresarContraseña) {
			if(BaseDeDatos.coincide(String.copyValueOf(ventanaContraseña.passwordField.getPassword()))) {
				ventanaContraseña.dispose();
				Administrador ventanaAdministrador = new Administrador();
				controladorAdministrador controlador = new controladorAdministrador(ventanaAdministrador);
				controlador.iniciarVentana();
			}else {
				JOptionPane.showMessageDialog(null, "Contraseña Erronea","Error",JOptionPane.ERROR_MESSAGE);
				ventanaContraseña.passwordField.setText("");
			}
		}
		
	}
	
	
	
}
