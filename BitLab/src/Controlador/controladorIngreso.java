package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import Modelo.BaseDeDatos;
import Vista.Registro;
import Vista.panelIngreso;

public class controladorIngreso implements ActionListener,KeyListener{

	panelIngreso ventanaingreso;
	
	public controladorIngreso(panelIngreso ventanaingreso) {
		this.ventanaingreso = ventanaingreso;
		
		this.ventanaingreso.botonanotarhora.addActionListener(this);
		this.ventanaingreso.camporut.addKeyListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ventanaingreso.botonanotarhora) {
			if(BaseDeDatos.EstaRegistrado(ventanaingreso.camporut.getText())) {
				
				BaseDeDatos.AnotarHoraIngreso(ventanaingreso.camporut.getText(),ventanaingreso.maquina.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null, "Su hora ha sido ingresada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				ventanaingreso.camporut.setText("");
				
			}else if(!BaseDeDatos.EstaRegistrado(ventanaingreso.camporut.getText())) {	
				
				JOptionPane.showMessageDialog(null, "No se encuentra registrado en el sistema \n   porfavor registrese a continuacion", "Aviso", JOptionPane.WARNING_MESSAGE);
				ventanaingreso.camporut.setText("");
				Registro ventanaregistro = new Registro();
				controladorRegistro controlador = new controladorRegistro(ventanaregistro);
				controlador.IniciarVentana();
				
			}
		}	
	}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {
		if(e.getSource() == ventanaingreso.camporut){
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
