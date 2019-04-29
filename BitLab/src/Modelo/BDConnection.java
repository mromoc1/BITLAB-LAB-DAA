package Modelo;
import java.sql.*;
import javax.swing.JOptionPane;

public class BDConnection {	
	
	private static String Controlador = "org.postgresql.Driver";
	private static String Url;
	private static String User;
	private static String Pass;
	
	public static void Inicializarvariables(String contraseña, String nombreusuario, String puerto) {
		Pass = contraseña;
		User = nombreusuario;
		Url = "jdbc:postgresql://localhost:"+puerto+"/Laboratorio";
	}
	
	public static Connection conectar() {
		Connection con = null;
		try {
			Class.forName(Controlador);
			con = DriverManager.getConnection(Url,User,Pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			//JOptionPane.showMessageDialog(null, "Error en la conexion","Aviso",JOptionPane.ERROR_MESSAGE);
		}
		return con;
	}
	
	
	
	

}
