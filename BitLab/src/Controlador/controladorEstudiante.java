package Controlador;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Modelo.BDConnection;
import Modelo.BaseDeDatos;
import Vista.Contraseña;
import Vista.Estudiante;
import Vista.panelIngreso;
import Vista.panelSalida;

public class controladorEstudiante implements ActionListener ,MouseListener{

	Estudiante ventanaestudiante;
	
	public controladorEstudiante(Estudiante ventanaestudiante) {
		this.ventanaestudiante = ventanaestudiante;
		
		this.ventanaestudiante.botonAdmin.addActionListener(this);
		this.ventanaestudiante.botonIngresar.addActionListener(this);
		this.ventanaestudiante.botonSalida.addActionListener(this);
		this.ventanaestudiante.botonInformacion.addMouseListener(this);
		this.ventanaestudiante.database.addMouseListener(this);
		
	}
	
	public void iniciarVentana() {
		
		ImageIcon icono = new ImageIcon(getClass().getResource("/Imagen/clipboard (4).png"));
		Image imagen = icono.getImage();
		
		ventanaestudiante.setIconImage(imagen);
		ventanaestudiante.setTitle("Bitacora de Ingreso a Laboratorio");
		ventanaestudiante.setSize(720, 330);
		ventanaestudiante.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaestudiante.setLocationRelativeTo(null);
		ventanaestudiante.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ventanaestudiante.botonIngresar) {	
			
			panelIngreso panel = new panelIngreso();
			controladorIngreso controlador = new controladorIngreso(panel);
			
			ventanaestudiante.panelcambio.removeAll();
			ventanaestudiante.panelcambio.add(panel);
			ventanaestudiante.panelcambio.revalidate();
			ventanaestudiante.panelcambio.repaint();
			
		}else if (e.getSource() == ventanaestudiante.botonSalida) {
			
			panelSalida panel = new panelSalida();
			controladorSalida controlador = new controladorSalida(panel);
			
			ventanaestudiante.panelcambio.removeAll();
			ventanaestudiante.panelcambio.add(panel);
			ventanaestudiante.panelcambio.revalidate();
			ventanaestudiante.panelcambio.repaint();
			
		}else if(e.getSource() == ventanaestudiante.botonAdmin) {
			ventanaestudiante.panelcambio.removeAll();
			ventanaestudiante.panelcambio.revalidate();
			ventanaestudiante.panelcambio.repaint();
			
			Contraseña ventana = new Contraseña();
			controladorContraseña controlador = new controladorContraseña(ventana);
			controlador.iniciarVentana();
			
		}
		
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == ventanaestudiante.botonInformacion) {
			
			JOptionPane.showMessageDialog(null, ""
					+ "Proyecto para la clase Diseño y Analisis de Algoritmos"
					+ "\nCreado por Marcelo Romo"
					+ "\nUniversidad de La Serena, Abril 2019"
					+ "\nVersion 2.6","Informacion",JOptionPane.INFORMATION_MESSAGE);
			
		}else if(e.getSource() == ventanaestudiante.database) {
			if(BDConnection.conectar() != null) {
				String pass = JOptionPane.showInputDialog(null, "Ingrese Contraseña Administrador", "Aviso", JOptionPane.WARNING_MESSAGE);
				
				if(BaseDeDatos.coincide(pass)) {
					String puerto = JOptionPane.showInputDialog(null, "Ingrese el puerto", "Puerto", JOptionPane.QUESTION_MESSAGE);
					String nombreusuario = JOptionPane.showInputDialog(null, "Ingrese el nombre de usuario", "Usuario", JOptionPane.QUESTION_MESSAGE);
					String contraseña = JOptionPane.showInputDialog(null, "Ingrese la contraseña", "Contraseña", JOptionPane.QUESTION_MESSAGE);
					
					BDConnection.Inicializarvariables(contraseña, nombreusuario, puerto);
				}else {
					JOptionPane.showMessageDialog(null, "Clave Administrador Incorrecta", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				String puerto = JOptionPane.showInputDialog(null, "Ingrese el puerto", "Puerto", JOptionPane.QUESTION_MESSAGE);
				String nombreusuario = JOptionPane.showInputDialog(null, "Ingrese el nombre de usuario", "Usuario", JOptionPane.QUESTION_MESSAGE);
				String contraseña = JOptionPane.showInputDialog(null, "Ingrese la contraseña", "Contraseña", JOptionPane.QUESTION_MESSAGE);
				
				BDConnection.Inicializarvariables(contraseña, nombreusuario, puerto);
			}
			
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	

}
