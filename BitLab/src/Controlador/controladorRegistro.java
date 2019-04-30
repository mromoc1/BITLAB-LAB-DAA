package Controlador;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Modelo.BaseDeDatos;
import Vista.Registro;

public class controladorRegistro implements ActionListener,KeyListener{
	
	Registro ventanaregistro;
	
	public controladorRegistro(Registro ventanaregistro) {
		this.ventanaregistro = ventanaregistro;
		
		this.ventanaregistro.BotonFinalizar.addActionListener(this);
		this.ventanaregistro.camporut.addKeyListener(this);
	}
	
	public void  IniciarVentana() {
		ImageIcon icono = new ImageIcon(getClass().getResource("/Imagen/clipboard (4).png"));
		Image imagen = icono.getImage();
		
		ventanaregistro.setIconImage(imagen);
		ventanaregistro.setTitle("Registro");
		ventanaregistro.setSize(600, 300);
		ventanaregistro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventanaregistro.setLocationRelativeTo(null);
		ventanaregistro.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ventanaregistro.BotonFinalizar) {
			
			BaseDeDatos.RegistrarAlumno(ventanaregistro.camporut.getText(), ventanaregistro.camponombre.getText(), ventanaregistro.BoxNivel.getSelectedItem().toString(), ventanaregistro.campomail.getText());
			this.ventanaregistro.dispose();
		}
	}

	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}

	public void keyTyped(KeyEvent e) {
		if(e.getSource() == ventanaregistro.camporut){
			char caracter = e.getKeyChar();
			if(((caracter < '0') ||
			         (caracter > '9')) &&
			         (caracter != '\b'))
			      {
			         e.consume();
			      }
		}
		
	}

	
}
