package diferenciasC;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import correo.EmailUtility;
public class diferenciasC
{
	public static final String SEPARATOR=",";
	public static final String QUOTE=",";
	public static int registros = 0;
	public static String url = "jdbc:postgresql://10.1.250.20:5932/openbravo";
	public static String inventarios= "jdbc:postgresql://10.1.250.24:5932/inventarios";
	public static String usuario="postgres";
	public static String contra="s3st2m1s4e";
	public static int fecha=0;
	public static String mensaje="";
	public static int hoy=0;
	static String resultMessage = "";
  public static String main(String almacenes)
  {
	  try
	  {
		  Class.forName("org.postgresql.Driver");		  
		  
		  Connection co = DriverManager.getConnection(inventarios, usuario, contra);		  
		  System.out.println("Ejecutando Query.......");
		  ResultSet rs = null;
		  mensaje="NO RESTAN UBICACIONES POR CONTABILIZAR";
		  PreparedStatement ps= co.prepareStatement("select loc.marbete,loc.hueco from ubicaciones as loc left outer join (select marbete,codigo,cantidad,"
+ "ubicacion from primerconteo where almacen similar to ('"+almacenes+"')  and fecha between now()::date- integer '20' and now()) as primer on "
+ "loc.hueco=primer.ubicacion where loc.almacen similar to ('"+almacenes+"') and primer.codigo is null "); 
				  		  rs=ps.executeQuery();
				  		  System.out.println("UNO");
				  		  if(rs.next())
				  		  {
				  			  WritableWorkbook wb = Workbook.createWorkbook(new File("FaltantesdePrimerConteo.xls"));
				  			  WritableFont wf = new WritableFont(WritableFont.TAHOMA, 10, WritableFont.NO_BOLD);
				  			  WritableCellFormat cf = new WritableCellFormat(wf);
				  			  String almacene[]=almacenes.split("\\|");
				  			  for(int x=0;x<almacene.length;x++)
				  			  {
				  				  
				  				  WritableSheet ws = wb.createSheet(almacene[x], x);
				  				  ps= co.prepareStatement("select loc.marbete,loc.hueco from ubicaciones as loc left outer join (select marbete,codigo,cantidad,"
+ "ubicacion from primerconteo where almacen similar to ('"+almacene[x]+"')  and fecha between now()::date- integer '20' and now()) as primer on "
+ "loc.hueco=primer.ubicacion where loc.almacen similar to ('"+almacene[x]+"') and primer.codigo is null "); 
				  				  rs=ps.executeQuery();
				  				System.out.println("DOS");
				  				  ArrayList<String> col=new ArrayList<String>(); 
				  				  while (rs.next())
				  				  {
				  					  col.add(rs.getString(1));
				  					  col.add(rs.getString(2));
				  					  col.add("sp");
				  					  
				  				  }
				  				  Iterator<String> i = col.iterator();
				  				  int column = 0;
				  				  int row = 0;
				  				  Label ec1 = new Label(column, row, "MARBETE", cf);	        
				  				  ws.addCell(ec1);
				  				  column++;
				  				  Label ec2 = new Label(column, row, "HUECO", cf);
				  				  ws.addCell(ec2);
				  				  row = 1;
				  				  column = 0;
				  				  while (i.hasNext())
				  				  {
				  					  String campo = (String)i.next();
				  					  if (campo == null) 
				  					  {
				  						  campo = " ";
				  					  }
				  					  if (campo.equals("sp"))
				  					  {
				  						  i.remove();
				  						  row++;
				  						  column = 0;
				  					  }
				  					  else
				  					  {
				  						  Label l1 = new Label(column, row, campo, cf);
				  						  ws.addCell(l1);
				  						  column++;
				  					  }
				  				  }						  
				  			  }
				  			 
				  			wb.write();
				  			wb.close();
				  			mensaje="HAY HUECOS FALTANTES POR CONTABILIZAR";
				  		  }
				  		  ps= co.prepareStatement("select loc.marbete,loc.hueco from ubicaciones as loc left outer join (select marbete,codigo,cantidad,ubicacion from "
+ "segundoconteo where almacen similar to '("+almacenes+")' and fecha between now()::date- integer '20' and now()) as segundo on loc.hueco=segundo.ubicacion where "
+ "loc.almacen similar TO '("+almacenes+")' and segundo.codigo is null "); 
				  		  rs=ps.executeQuery();
				  		System.out.println("TRES");
				  		  if(rs.next())
				  		  {
				  			  WritableWorkbook wb = Workbook.createWorkbook(new File("FaltantesdeSegundoConteo.xls"));
				  			  WritableFont wf = new WritableFont(WritableFont.TAHOMA, 10, WritableFont.NO_BOLD);
				  			  WritableCellFormat cf = new WritableCellFormat(wf);
				  			  String almacene[]=almacenes.split("\\|");
				  			  for(int x=0;x<almacene.length;x++)
				  			  {
				  				  WritableSheet ws = wb.createSheet(almacene[x], x);
				  				  ps= co.prepareStatement("select loc.marbete,loc.hueco from ubicaciones as loc left outer join (select marbete,codigo,cantidad,"
+ "ubicacion from segundoconteo where almacen similar to ('"+almacene[x]+"')  and fecha between now()::date- integer '20' and now()) as segundo on "
+ "loc.hueco=segundo.ubicacion where loc.almacen similar to ('"+almacene[x]+"') and segundo.codigo is null "); 
				  				  rs=ps.executeQuery();
				  				System.out.println("CUATRO");
				  				  ArrayList<String> col=new ArrayList<String>(); 
				  				  while (rs.next())
				  				  {
				  					  col.add(rs.getString(1));
				  					  col.add(rs.getString(2));
				  					  col.add("sp");
				  					System.out.println("CINCO");
				  				  }
				  				  Iterator<String> i = col.iterator();
				  				  int column = 0;
				  				  int row = 0;
				  				  Label ec1 = new Label(column, row, "MARBETE", cf);	        
				  				  ws.addCell(ec1);
				  				  column++;
				  				  Label ec2 = new Label(column, row, "HUECO", cf);
				  				  ws.addCell(ec2);
				  				  row = 1;
				  				  column = 0;
				  				  while (i.hasNext())
				  				  {
				  					  String campo = (String)i.next();
				  					  if (campo == null) 
				  					  {
				  						  campo = " ";
				  					  }
				  					  if (campo.equals("sp"))
				  					  {
				  						  i.remove();
				  						  row++;
				  						  column = 0;
				  					  }
				  					  else
				  					  {
				  						  Label l1 = new Label(column, row, campo, cf);
				  						  ws.addCell(l1);
				  						  column++;
				  					  }
				  					
				  				  }
				  				System.out.println("SIETE");
				  			  }	
				  			  wb.write();
				  			wb.close();
				  			mensaje="HAY HUECOS FALTANTES POR CONTABILIZAR";
				  		  }
				  		  co.close();
				  						  				  		  
				  		  
	  } catch(Exception e)
		  {
		  
		  System.out.println("Error:"+e);
		  }
	  System.out.print("Registros:" +registros);	  
	  return mensaje;
  }
  
}