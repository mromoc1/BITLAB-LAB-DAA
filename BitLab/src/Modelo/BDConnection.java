package Modelo;
import java.sql.*;
import javax.swing.JOptionPane;

public class BDConnection {

	
	private static final String Controlador = "org.postgresql.Driver";
	private static final String Url = "jdbc:postgresql://localhost:5432/Laboratorio";
	private static final String User = "postgres";
	private static final String Pass = "contrase";
	
	public static Connection conectar() {
		Connection con = null;
		try {
			Class.forName(Controlador);
			con = DriverManager.getConnection(Url,User,Pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la coneccion","Aviso",JOptionPane.ERROR_MESSAGE);
		}
		return con;
	}
	
	
	
	

}
