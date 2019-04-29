package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.jupiter.api.Test;

import Modelo.BaseDeDatos;

class Eliminar {

	@Test
	public void testEliminar() {
		/**
		 * Tabla 1 
		 * Antes de eliminar
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
		 * Despues de eliminar
		 */
		JTable tabla2 = new JTable();
		DefaultTableModel modelo2 = new DefaultTableModel();
		modelo2.addColumn("Rut");
		modelo2.addColumn("Nombre");
		modelo2.addColumn("Nivel");
		modelo2.addColumn("Mail");
		/**
		 * Ingresar rut de alumno registrado
		 */
		BaseDeDatos.EliminarAlumno("333333433");
		tabla2.setModel(BaseDeDatos.CargarDatosRegistros(modelo2));
		int esperado = tabla2.getRowCount();

		assertEquals(esperado, numFil - 1);
		
	}
}
