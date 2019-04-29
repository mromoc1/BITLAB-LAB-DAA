package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import Modelo.BaseDeDatos;

class Importar {

	@Test
	public void testImportar() {
		/**
		 * Cuenta las filas dentro de la base de datos
		 */
		JTable tabla = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Rut");
		modelo.addColumn("Nombre");
		modelo.addColumn("Nivel");
		modelo.addColumn("Mail");
		tabla.setModel(BaseDeDatos.CargarDatosRegistros(modelo));
		int numFilantesdeimportar = tabla.getRowCount();
		/**
		 * Guarda el numero de Filas que va a importar desde el archivo
		 */
		Workbook libro;
		String url;
		JFileChooser jf = new JFileChooser();
		
		jf.setDialogTitle("Seleccione Archivo");
        jf.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
        jf.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xls"));
		
		jf.showOpenDialog(null);
		File archivo = jf.getSelectedFile();
		url = archivo.getAbsolutePath();
		if(archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")) {
			try {
				FileInputStream file = new FileInputStream(url);
				if(archivo.getName().endsWith("xlsx")) {
					libro = new XSSFWorkbook(file);
				}else {
					libro = new HSSFWorkbook(file);
				}
				Sheet sheet = libro.getSheetAt(0);
				int numerodefilasdelarchivo = sheet.getLastRowNum();
				
				BaseDeDatos.importarRegistro();
				
				/**
				 * Cuenta nuevamente las filas dentro de la base de datos
				 */
				JTable tabla2 = new JTable();
				DefaultTableModel modelo2 = new DefaultTableModel();
				modelo2.addColumn("Rut");
				modelo2.addColumn("Nombre");
				modelo2.addColumn("Nivel");
				modelo2.addColumn("Mail");
				tabla2.setModel(BaseDeDatos.CargarDatosRegistros(modelo2));
				int numerodefilasdespuesdeimportar = tabla2.getRowCount();
				
				/**
				 * Es correcto si el numero de filas del archivo menos el numero de filas despues de importar
				 * es igual al numero de filas que habia antes de importar
				 */
				assertEquals(numFilantesdeimportar, numerodefilasdelarchivo - numerodefilasdespuesdeimportar);
				/**
				 * Recordar seleccionar en ambas ventanas el mismo archivo
				 * Recordar que no pueden haber repetidos, contaria antes de importar desde el archivo
				 * pero no se agregaria en a base de datos
				 */
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
		else {
			JOptionPane.showMessageDialog(null, "Hubo un error con el Archivo", "Aviso", JOptionPane.ERROR_MESSAGE);
		}
	}

}
