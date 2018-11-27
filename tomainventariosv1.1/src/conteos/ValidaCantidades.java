package conteos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilerias.postgresql;
public class ValidaCantidades {
	public static String main(String marbete,String codigo,String cantidad) {
		String alhu="0";
		Connection con=postgresql.getConexion();
		try {			
			ResultSet rs = null;
			PreparedStatement ps= con.prepareStatement("SELECT "
+ "(marbete||'.'||codigo||'.'||round(cantidad::numeric,2)) "
+ "from primerconteo where "
+ "(marbete||'.'||codigo||'.'||round(cantidad::numeric,2))='"+marbete+"."+codigo+".'||round('"+cantidad+"'::numeric,2) "
+ "UNION "
+ "SELECT "
+ "(marbete||'.'||codigo||'.'||round(cantidad::numeric,2)) "
+ "from SEGUNDOCONTEO where "
+ "(marbete||'.'||codigo||'.'||round(cantidad::numeric,2))='"+marbete+"."+codigo+".'||round('"+cantidad+"'::numeric,2) ");
								
			rs = ps.executeQuery();
			while(rs.next()){
				alhu=rs.getString(1);
			}
			System.out.println(" Termina Query.......");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alhu;
	}
}