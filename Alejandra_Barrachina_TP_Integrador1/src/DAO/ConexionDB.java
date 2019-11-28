package DAO;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionDB {

	private Connection Conexion;
	private final String host = "jdbc:mysql://localhost:3306/";
	private final String user = "root";
	private final String password = "";
	private final String NombreDB = "sistemauniversitario?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	public Connection EstablecerConexion() {
		
		Connection Conexion = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Conexion = DriverManager.getConnection(host+NombreDB, user, password);
		} 
		catch (Exception e) {

			System.out.println("no conecto " + e);
		}
		
		return Conexion;
	}
	
	public ResultSet EstablecerConsulta(String Consulta){

		ResultSet rs=null;
		Statement st;
		
		try
		{
			st= Conexion.createStatement();
			rs= st.executeQuery(Consulta);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
}

