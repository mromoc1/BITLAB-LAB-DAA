package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.jupiter.api.Test;

import Modelo.BaseDeDatos;

class Agregar {

	@Test
	public void testAgregar() {
		/**
		 * Tabla 1 
		 * Antes del agregado
		 */
		JTable tabla = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Rut");
		modelo.addColumn("Nombre");
		modelo.addColumn("Nivel");
		modelo.addColumn("Mail");
		tabla.setModel(BaseDeDatos.CargarDatosRegistros(modelo));
		int numFil = tabla.getRowCount();
		
		
		/**
		 * Tabla 2
		 * Despues del agregado
		 */
		JTable tabla2 = new JTable();
		DefaultTableModel modelo2 = new DefaultTableModel();
		modelo2.addColumn("Rut");
		modelo2.addColumn("Nombre");
		modelo2.addColumn("Nivel");
		modelo2.addColumn("Mail");
		/**
		 * El metodo agregar no permite repetidos, hay que variar la primera variable
		 */
		BaseDeDatos.RegistrarAlumno("333333433", "NOMBRE", "5", "MAIL");
		tabla2.setModel(BaseDeDatos.CargarDatosRegistros(modelo2));
		int esperado = tabla2.getRowCount();
		/**
		 * Se espera que el valor esperado sea igual al numero de filas +1
		 */
		assertEquals(esperado, numFil + 1);
	}
}
