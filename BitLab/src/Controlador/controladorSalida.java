package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import Modelo.BaseDeDatos;
import Vista.panelSalida;

public class controladorSalida implements ActionListener,KeyListener{

	panelSalida ventanasalida;
	
	public controladorSalida(panelSalida ventanasalida){
		this.ventanasalida = ventanasalida;
		
		this.ventanasalida.botonsalida.addActionListener(this);
		this.ventanasalida.camporut.addKeyListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == ventanasalida.botonsalida) {
			
			BaseDeDatos.AnotarHoraSalida(ventanasalida.camporut.getText());
			ventanasalida.camporut.setText("");
			JOptionPane.showMessageDialog(null, "Hora de salida ingresada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}

	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}

	public void keyTyped(KeyEvent e) {
		if(e.getSource() == ventanasalida.camporut){
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
