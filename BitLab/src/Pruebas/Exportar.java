package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import Modelo.BaseDeDatos;

class Exportar {

	@Test
	public void testExportar() {
		/**
		 * Cuenta los archivos de C:\\Users\\M\\eclipse-workspace\\V3\\src\\Pruebas
		 * y los guarda
		 */
		File dir = new File("C:\\Users\\M\\eclipse-workspace\\V3\\src\\Pruebas");
		String[] ficheros = dir.list();
		int cantidad = ficheros.length;
		
		BaseDeDatos.exportarRegistro();
		File dir2 = new File("C:\\Users\\M\\eclipse-workspace\\V3\\src\\Pruebas");
		ficheros = dir2.list();
		int esperado = ficheros.length;
		
		
		
		assertEquals(esperado, cantidad + 1);
		
	}
}
