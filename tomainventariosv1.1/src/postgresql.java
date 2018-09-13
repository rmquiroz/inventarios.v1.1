import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class postgresql {
public static Connection getConexion(){

		Connection con=null;
		try {
			Class.forName("org.postgresql.Driver");
			String url =  "jdbc:postgresql://10.1.250.24:5932/inventarios";
			String usuario="postgres";
			String pass="s3st2m1s4e";
			
				con=	DriverManager.getConnection(url,usuario,pass);
				
		} catch (ClassNotFoundException e) {
			
			System.out.println("Conexion Fallida DRIVER------>>>");
			
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Conexion BD NO CONECTA------>>>");
			e.printStackTrace();
		}
		return con;
		
	
}
}
/*
try
{
     
	String remplazado = null;
    ResultSet rs = null;
    String a="";

Class.forName("org.postgresql.Driver");
//String url = "jdbc:postgresql://10.1.250.20:5932/openbravo";
String url =  "jdbc:postgresql://201.149.89.163:5932/openbravo";
Connection cn = DriverManager.getConnection(url, "postgres", "s3st2m1s4e"); */