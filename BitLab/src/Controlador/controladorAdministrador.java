package Controlador;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Modelo.BaseDeDatos;
import Vista.Administrador;
import Vista.panelModificar;
import Vista.panelVerBitacora;
import Vista.panelVerRegistro;

public class controladorAdministrador implements ActionListener{

	Administrador ventanaAdministrador;
	
	public controladorAdministrador(Administrador ventanaAdministrador) {
		this.ventanaAdministrador = ventanaAdministrador;
		
		this.ventanaAdministrador.botonModificar.addActionListener(this);
		this.ventanaAdministrador.botonRegistrados.addActionListener(this);
		this.ventanaAdministrador.botonBitacora.addActionListener(this);
		this.ventanaAdministrador.botonImportarregistro.addActionListener(this);
		this.ventanaAdministrador.botonExportarregistro.addActionListener(this);
		this.ventanaAdministrador.botonExportarbitacora.addActionListener(this);
		
	}
	
	public void iniciarVentana() {

		ventanaAdministrador.setIconImage(Toolkit.getDefaultToolkit().getImage("Imagen\\businessman-with-shield.png"));
		ventanaAdministrador.setTitle("Opciones de Administrador");
		ventanaAdministrador.setSize(900, 630);
		ventanaAdministrador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventanaAdministrador.setLocationRelativeTo(null);
		ventanaAdministrador.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ventanaAdministrador.botonModificar ) {
			panelModificar panel = new panelModificar();
			controladorModificar controlador = new controladorModificar(panel);
			
			ventanaAdministrador.panelcambio.removeAll();
			ventanaAdministrador.panelcambio.add(panel);
			ventanaAdministrador.panelcambio.revalidate();
			ventanaAdministrador.panelcambio.repaint();
			
		}else if(e.getSource() == ventanaAdministrador.botonRegistrados) {
			
			panelVerRegistro panel = new panelVerRegistro();
			
			ventanaAdministrador.panelcambio.removeAll();
			ventanaAdministrador.panelcambio.add(panel);
			ventanaAdministrador.panelcambio.revalidate();
			ventanaAdministrador.panelcambio.repaint();
			
		}else if(e.getSource() == ventanaAdministrador.botonBitacora) {

			panelVerBitacora panel = new panelVerBitacora();
			
			ventanaAdministrador.panelcambio.removeAll();
			ventanaAdministrador.panelcambio.add(panel);
			ventanaAdministrador.panelcambio.revalidate();
			ventanaAdministrador.panelcambio.repaint();
		}else if(e.getSource() == ventanaAdministrador.botonImportarregistro) {
			ventanaAdministrador.panelcambio.removeAll();
			ventanaAdministrador.panelcambio.revalidate();
			ventanaAdministrador.panelcambio.repaint();
			
			BaseDeDatos.importarRegistro();
		}else if(e.getSource() == ventanaAdministrador.botonExportarregistro) {
			ventanaAdministrador.panelcambio.removeAll();
			ventanaAdministrador.panelcambio.revalidate();
			ventanaAdministrador.panelcambio.repaint();
			
			BaseDeDatos.exportarRegistro();
		}else if(e.getSource() == ventanaAdministrador.botonExportarbitacora) {
			ventanaAdministrador.panelcambio.removeAll();
			ventanaAdministrador.panelcambio.revalidate();
			ventanaAdministrador.panelcambio.repaint();
			
			BaseDeDatos.exportarBitacora();
		}
	}

}
