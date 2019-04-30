package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import Modelo.BaseDeDatos;

class Exportar {

	@Test
	public void testExportar() {
		/**
		 * Cuenta los archivos de src\\Pruebas
		 * y los guarda
		 */
		File dir = new File("src\\Pruebas");
		String[] ficheros = dir.list();
		int cantidad = ficheros.length;
		
		BaseDeDatos.exportarRegistro();
		File dir2 = new File("src\\Pruebas");
		ficheros = dir2.list();
		int esperado = ficheros.length;
		
		
		
		assertEquals(esperado, cantidad + 1);
		
	}
}
