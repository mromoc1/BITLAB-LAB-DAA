package Controlador;

import Vista.Estudiante;

public class Main {
	public static void main(String[] args) {
		Estudiante ventanaEstudiante = new Estudiante();
		
		controladorEstudiante controlador = new controladorEstudiante(ventanaEstudiante);
		controlador.iniciarVentana();
	}
	
}
