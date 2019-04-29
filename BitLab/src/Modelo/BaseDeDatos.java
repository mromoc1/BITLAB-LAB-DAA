package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BaseDeDatos {
	private static SimpleDateFormat formatohora= new SimpleDateFormat("HH:mm:ss");
	private static SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
	
	public static Boolean EstaRegistrado (String rut) {
		PreparedStatement ps;
		ResultSet rs;
		Boolean estaregistrado = false;
		String query = "SELECT * FROM public.alumnos_registrados WHERE rut = ? ";
		try {
			
			if(BDConnection.conectar() != null){
				ps = BDConnection.conectar().prepareStatement(query);
				ps.setInt(1,Integer.parseInt(rut));
				rs = ps.executeQuery();
				if(rs.next()) {
					estaregistrado = true;
				}
			}else{
				JOptionPane.showMessageDialog(null, "Error en la coneccion","Aviso",JOptionPane.ERROR_MESSAGE);
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return estaregistrado;
	}
	
	public static void RegistrarAlumno(String rut, String nombre, String nivel, String mail) {
		
		PreparedStatement ps;
		String consulta = "INSERT INTO public.alumnos_registrados ( rut , nombre , nivel , mail ) VALUES (?,?,?,?)";
		try {
			if(BDConnection.conectar() != null){
				ps= BDConnection.conectar().prepareStatement(consulta);
				ps.setInt(1,Integer.parseInt(rut));
				ps.setString(2, nombre);
				ps.setInt(3, Integer.parseInt(nivel));
				ps.setString(4, mail);
				if(ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente","Aviso",JOptionPane.INFORMATION_MESSAGE);
					ps.close();
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "Error en la coneccion","Aviso",JOptionPane.ERROR_MESSAGE);
				return;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void AnotarHoraIngreso(String rut, String maquina) {
		
		Date date = new Date();
		
		PreparedStatement ps;
		String consulta = "INSERT INTO public.bitacora_de_ingreso ( rut , fecha , horaingreso , horasalida , maquina) VALUES (?,?,?,?,?)";
		
		try {
			if(BDConnection.conectar() != null){
				ps = BDConnection.conectar().prepareStatement(consulta);
				ps.setInt(1, Integer.parseInt(rut));
				ps.setString(2, ""+formatofecha.format(date));
				ps.setString(3, ""+formatohora.format(date));
				ps.setString(4, "0");
				ps.setString(5, maquina);
				if(ps.executeUpdate() > 0) {
					ps.close();
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "Error en la coneccion","Aviso",JOptionPane.ERROR_MESSAGE);
				return;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static void AnotarHoraSalida(String rut) {
		Date date = new Date();
		
		PreparedStatement ps;
		String consulta = "UPDATE public.bitacora_de_ingreso SET horasalida = ? WHERE rut = ?  AND horasalida = ?";
				
		try {
			if(BDConnection.conectar() != null){
				ps = BDConnection.conectar().prepareStatement(consulta);
				ps.setString(1, ""+formatohora.format(date));
				ps.setInt(2, Integer.parseInt(rut));
				ps.setString(3, "0");
				if(ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Hora de salida ingresada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "Error en la coneccion","Aviso",JOptionPane.ERROR_MESSAGE);
				return;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void ActualizarInfo(String rut, String mail, String nombre, String nivel) {
		PreparedStatement ps;
		String consulta = "UPDATE public.alumnos_registrados SET nombre = ?, mail = ?, nivel = ? WHERE rut = ? ";
				
		try {
			if(BDConnection.conectar() != null){
				ps = BDConnection.conectar().prepareStatement(consulta);
				ps.setString(1,nombre );
				ps.setString(2,mail );
				ps.setInt(3,Integer.parseInt(nivel));
				ps.setInt(4,Integer.parseInt(rut));
				
				if(ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Informacion actualizada correctamente","Aviso",JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "Error en la coneccion","Aviso",JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void EliminarAlumno(String rut) {
		PreparedStatement ps;
		String consulta = "DELETE FROM public.alumnos_registrados WHERE rut = ?";
		try {
			if(BDConnection.conectar() != null){
				ps = BDConnection.conectar().prepareStatement(consulta);
				ps.setInt(1,Integer.parseInt(rut));
				if(ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Se ha Eliminado con exito","Aviso",JOptionPane.INFORMATION_MESSAGE);
					ps.close();
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "Error en la coneccion","Aviso",JOptionPane.ERROR_MESSAGE);
				return;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static DefaultTableModel CargarDatosRegistros(DefaultTableModel modelo) {
		String[] datos = new String[4];
		
		PreparedStatement ps;
		ResultSet rs;
		String query = "SELECT * FROM public.alumnos_registrados";
		try {
			if(BDConnection.conectar() != null){
				ps = BDConnection.conectar().prepareStatement(query);
				rs = ps.executeQuery();
				while(rs.next()) {
					datos[0] = rs.getString(1);
					datos[1] = rs.getString(2);
					datos[2] = rs.getString(3);
					datos[3] = rs.getString(4);
					modelo.addRow(datos);
					
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "Error en la coneccion","Aviso",JOptionPane.ERROR_MESSAGE);
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return modelo;
	}
	
	public static DefaultTableModel CargarDatosBitacora(DefaultTableModel modelo) {
		String[] datos = new String[5];
		
		PreparedStatement ps;
		ResultSet rs;
		String query = "SELECT * FROM public.bitacora_de_ingreso";
		try {
			if(BDConnection.conectar() != null){
				ps = BDConnection.conectar().prepareStatement(query);
				rs = ps.executeQuery();
				while(rs.next()) {
					datos[0] = rs.getString(1);
					datos[1] = rs.getString(2);
					datos[2] = rs.getString(3);
					datos[3] = rs.getString(4);
					datos[4] = rs.getString(5);
					modelo.addRow(datos);
					
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "Error en la coneccion","Aviso",JOptionPane.ERROR_MESSAGE);
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return modelo;
	}
	
	public static Boolean coincide(String contraseña) {
		
		PreparedStatement ps;
		ResultSet rs;
		String consulta = "SELECT * FROM public.admin WHERE contraseña = ?";
		try {
			
			
			if(BDConnection.conectar() != null){
				ps = BDConnection.conectar().prepareStatement(consulta);
				
				ps.setString(1, contraseña);
				rs = ps.executeQuery();
				if(rs.next()) {
					return true;
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "Error en la coneccion","Aviso",JOptionPane.ERROR_MESSAGE);
				return null;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}
	
	public static void importarRegistro() {
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
			
			PreparedStatement ps;
			String query = "INSERT INTO public.alumnos_registrados (rut , nombre , nivel , mail) VALUES (?,?,?,?) ";
			try {
				
				if(BDConnection.conectar() != null){
					ps = BDConnection.conectar().prepareStatement(query);
					FileInputStream file = new FileInputStream(url);
					if(archivo.getName().endsWith("xlsx")) {
						libro = new XSSFWorkbook(file);
					}else {
						libro = new HSSFWorkbook(file);
					}
					Sheet sheet = libro.getSheetAt(0);
					int numFilas = sheet.getLastRowNum();
					
					for(int i = 1; i<=numFilas;i++) {
						Row fila = sheet.getRow(i);
						if(!BaseDeDatos.EstaRegistrado(Integer.toString((int)fila.getCell(0).getNumericCellValue()))) {
							ps.setInt(1, (int)(fila.getCell(0).getNumericCellValue()));
							ps.setString(2, fila.getCell(1).getStringCellValue());
							ps.setInt(3, (int)(fila.getCell(2).getNumericCellValue()));
							ps.setString(4, fila.getCell(3).getStringCellValue());
							ps.execute();
						}	
					}
					JOptionPane.showMessageDialog(null, "Se ha importado con exito","Aviso",JOptionPane.INFORMATION_MESSAGE);
					
				}else{
					JOptionPane.showMessageDialog(null, "Error en la coneccion","Aviso",JOptionPane.ERROR_MESSAGE);
					return;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		else {
			JOptionPane.showMessageDialog(null, "Hubo un error con el Archivo", "Aviso", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void exportarRegistro() {
		Workbook wb;
		
		JTable tabla = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		
		modelo.addColumn("Rut");
		modelo.addColumn("Nombre");
		modelo.addColumn("Nivel");
		modelo.addColumn("Mail");
		tabla.setModel(BaseDeDatos.CargarDatosRegistros(modelo));
		
		int numFila = tabla.getRowCount();
		int numCol = tabla.getColumnCount();
		JFileChooser jf = new JFileChooser();
		File archivo;
		
		if(jf.showDialog(null, "Guardar Archivo") == JFileChooser.APPROVE_OPTION) {
			archivo = jf.getSelectedFile();
			
			if(archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")) {
				
				if(archivo.getName().endsWith("xls")) {
					wb = new HSSFWorkbook();
				}else {
					wb = new XSSFWorkbook();
				}
				Sheet hoja = wb.createSheet("Hoja");
				try {
					if(BDConnection.conectar() != null){
						for(int i = -1; i<numFila;i++) {
							Row fila = hoja.createRow(i+1);
							for(int j=0; j<numCol ; j++) {
								Cell celda = fila.createCell(j);
								if(i == -1) {
									celda.setCellValue(String.valueOf(tabla.getColumnName(j)));
								}else {
									
									if(isNumeric(String.valueOf(tabla.getValueAt(i,j)))) {
										celda.setCellValue(Double.parseDouble(String.valueOf(tabla.getValueAt(i,j))));
									}else {
										celda.setCellValue(String.valueOf(tabla.getValueAt(i,j)));
									}
									
									
								}
								wb.write(new FileOutputStream(archivo));
							}
						}
						JOptionPane.showMessageDialog(null, "Se ha exportado con exito","Aviso",JOptionPane.INFORMATION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "Error en la coneccion","Aviso",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}catch(Exception e) {}
				
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese un formato valido", "Aviso", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static void exportarBitacora() {
		Workbook wb;
		
		JTable tabla = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		
		modelo.addColumn("Rut");
		modelo.addColumn("Fecha");
		modelo.addColumn("Hora Ingreso");
		modelo.addColumn("Hora Salida");
		modelo.addColumn("Maquina");
		tabla.setModel(BaseDeDatos.CargarDatosBitacora(modelo));
		
		int numFila = tabla.getRowCount();
		int numCol = tabla.getColumnCount();
		JFileChooser jf = new JFileChooser();
		File archivo;
		
		if(jf.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
			archivo = jf.getSelectedFile();
			
			if(archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")) {
				
				if(archivo.getName().endsWith("xls")) {
					wb = new HSSFWorkbook();
				}else {
					wb = new XSSFWorkbook();
				}
				Sheet hoja = wb.createSheet("Hoja");
				try {
					if(BDConnection.conectar() != null){
						for(int i = -1; i<numFila;i++) {
							Row fila = hoja.createRow(i+1);
							for(int j=0; j<numCol ; j++) {
								Cell celda = fila.createCell(j);
								if(i == -1) {
									celda.setCellValue(String.valueOf(tabla.getColumnName(j)));
								}else {
									
									if(isNumeric(String.valueOf(tabla.getValueAt(i,j)))) {
										celda.setCellValue(Double.parseDouble(String.valueOf(tabla.getValueAt(i,j))));
									}else {
										celda.setCellValue(String.valueOf(tabla.getValueAt(i,j)));
									}
									
									
								}
								wb.write(new FileOutputStream(archivo));
							}
						}
						JOptionPane.showMessageDialog(null, "Se ha exportado con exito","Aviso",JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Error en la coneccion","Aviso",JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					
				}catch(Exception e) {}
				
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese un formato valido", "Aviso", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
	}
	
}
