package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import Modelo.BaseDeDatos;
import Vista.panelModificar;

public class controladorModificar implements ActionListener,KeyListener{

	panelModificar ventanaModificar;
	
	public controladorModificar(panelModificar ventanaModificar) {
		this.ventanaModificar = ventanaModificar;
		this.ventanaModificar.botonModificar.addActionListener(this);
		this.ventanaModificar.botonEliminar.addActionListener(this);
		this.ventanaModificar.botonGuardarCambios.addActionListener(this);
		this.ventanaModificar.camporut.addKeyListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ventanaModificar.botonModificar) {
			
			if(BaseDeDatos.EstaRegistrado(ventanaModificar.camporut.getText())) {
				ventanaModificar.camporut.setEditable(false);
				ventanaModificar.campomail.setEditable(true);
				ventanaModificar.camponombre.setEditable(true);
				ventanaModificar.BoxNivel.setVisible(true);
				ventanaModificar.botonGuardarCambios.setVisible(true);
				
			}else{
				JOptionPane.showMessageDialog(null, "El Estudiante no se encuentra registrado", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
			
		}else if(e.getSource() == ventanaModificar.botonEliminar){
			
			if(BaseDeDatos.EstaRegistrado(ventanaModificar.camporut.getText())) {
				
				BaseDeDatos.EliminarAlumno(ventanaModificar.camporut.getText());
				ventanaModificar.removeAll();
				ventanaModificar.revalidate();
				ventanaModificar.repaint();
				
			}else{
				JOptionPane.showMessageDialog(null, "El Estudiante no se encuentra registrado", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
			
		}else if(e.getSource() == ventanaModificar.botonGuardarCambios) {
			
			BaseDeDatos.ActualizarInfo(ventanaModificar.camporut.getText(),ventanaModificar.campomail.getText(),ventanaModificar.camponombre.getText(),ventanaModificar.BoxNivel.getSelectedItem().toString());
			ventanaModificar.removeAll();
			ventanaModificar.revalidate();
			ventanaModificar.repaint();
		}
	}

	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}

	public void keyTyped(KeyEvent e) {
		if(e.getSource() == ventanaModificar.camporut){
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
