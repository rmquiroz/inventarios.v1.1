package conteos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import utilerias.postgresql;
public class Insersion {
	public static void main(String conteo, String cantidad, String codigo, String marbete,String usuario,String ubicacion,String almacen) {
		Connection con=postgresql.getConexion();
		try {						
			PreparedStatement psinsert = con.prepareStatement("insert into "+conteo+" values('"+codigo+"',"
+ "'"+marbete+"','"+cantidad+"',now(),'"+ubicacion+"','"+almacen+"',(SELECT id FROM usuarios WHERE usuario='"+usuario+"'))");
			psinsert.execute();
			System.out.println(" Termina Query.......");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}