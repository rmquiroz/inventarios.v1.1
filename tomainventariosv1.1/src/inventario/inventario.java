package inventario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import jxl.JXLException;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
public class inventario
{
	public static final String SEPARATOR=",";
	public static final String QUOTE=",";
	static int registros = 0;
	public static String url = "jdbc:postgresql://10.1.250.20:5932/openbravo";
  public static void main()
  {
	  try
	  {
		  Class.forName("org.postgresql.Driver");
		  
		  Connection cn = DriverManager.getConnection(url, "postgres", "s3st2m1s4e");            
		  System.out.println("Ejecutando Query.......");
		  ResultSet rs = null;
		  PreparedStatement ps = cn.prepareStatement("SELECT m_warehouse.name,m_locator.value,m_product.value AS codigo,"
+ "REPLACE(m_product.description,',',' ') AS descripcion,  m_product.categoria AS categoria,"
+ "m_product.subcategoria AS sub,m_product.upc,m_product.licenciante,m_product.piezas_caja,m_product.piezas_pallet,"
+ "round(sum(m_storage_detail.qtyonhAND),2) AS cantidad,"
+ "REPLACE(REPLACE(c_uom.name, 'Unit', 'UNIDAD'),'Kilogram', 'KILOGRAMO') AS unidad,"
+ "round(sum(CASE WHEN m_product.value LIKE '1%' THEN 1*m_storage_detail.qtyonhAND WHEN m_product.value LIKE '2%' "
+ "THEN 1*m_storage_detail.qtyonhAND  WHEN m_product.value LIKE '3%'  THEN 1*m_storage_detail.qtyonhAND  WHEN "
+ "m_product.value LIKE '7%'  THEN 1*m_storage_detail.qtyonhAND   WHEN m_product.value LIKE '8%'  THEN "
+ "1*m_storage_detail.qtyonhAND  WHEN m_product.value LIKE '4%'  THEN piezas_Caja::NUMERIC*m_storage_detail.qtyonhAND "
+ "WHEN m_product.value LIKE '5%'  THEN piezas_pallet::NUMERIC*m_storage_detail.qtyonhAND ELSE "
+ "1*m_storage_detail.qtyonhAND end ),2) AS piezas,  to_char(CASE WHEN (case when m_Warehouse.name like "
+ "'%4E BRANDS EUA%' THEN m_product.campoabcdeuno else to_Char(m_product.coststd) end) is null THEN 'FALTA VALUACION' "
+ "ELSE (case when m_Warehouse.name like '%4E BRANDS EUA%' THEN m_product.campoabcdeuno else "
+ "to_char(m_product.coststd) end)::varchar  END ) AS costostd,   (round(sum(CASE WHEN m_product.value LIKE '1%' THEN "
+ "1*m_storage_detail.qtyonhAND   WHEN m_product.value LIKE '2%'  THEN 1*m_storage_detail.qtyonhAND WHEN "
+ "m_product.value LIKE '3%'  THEN 1*m_storage_detail.qtyonhAND  WHEN m_product.value LIKE '7%'  THEN "
+ "1*m_storage_detail.qtyonhAND WHEN m_product.value LIKE '8%'  THEN 1*m_storage_detail.qtyonhAND WHEN "
+ "m_product.value LIKE '4%'  THEN piezas_Caja::NUMERIC*m_storage_detail.qtyonhAND  WHEN m_product.value LIKE '5%' "
+ "THEN piezas_pallet::NUMERIC*m_storage_detail.qtyonhAND ELSE 1*m_storage_detail.qtyonhAND end ),2))*(case when "
+ "m_Warehouse.name like '%4E BRANDS EUA%' THEN m_product.campoabcdeuno::numeric else m_product.coststd end) AS std,"
+ "chr(13) AS sp  FROM m_storage_detail LEFT JOIN m_attributesetinstance ON "
+ "m_storage_detail.m_attributesetinstance_id=m_attributesetinstance.m_attributesetinstance_id,m_product,m_locator,"
+ "m_warehouse, c_uom  WHERE m_storage_detail.m_product_id = m_product.m_product_id  AND "
+ "m_storage_detail.qtyonhAND <> 0 AND m_storage_detail.m_locator_id=m_locator.m_locator_id  AND "
+ "m_locator.m_warehouse_id=m_warehouse.m_warehouse_id AND c_uom.c_uom_id=m_product.c_uom_id  AND m_product.value NOT "
+ "LIKE '9%'   AND m_product.value NOT LIKE 'US%' AND m_product.value NOT LIKE 'ES%' AND m_product.value NOT LIKE "
+ "'HERRA%'  AND m_product.value NOT LIKE 'SERVI%' AND m_warehouse.isactive='Y' AND m_Warehouse.name NOT LIKE "
+ "'4E_MP TEMPORAL'  AND m_Warehouse.name NOT LIKE '4G_SMO m_productUCCION'  AND m_Warehouse.name NOT LIKE "
+ "'4G_1D ADUANA' AND m_Warehouse.name NOT LIKE '4E_BRANDS' AND m_Warehouse.name NOT LIKE '4G_1F REFACCIONES'  AND "
+ "m_Warehouse.name NOT LIKE 'ALMACEN_MERIDA' GROUP BY m_warehouse.name,m_locator.value,m_product.value,"
+ "m_product.description,  unidad,categoria,sub,m_product.upc,m_product.licenciante,m_product.piezas_caja,"
+ "m_product.piezas_pallet,c_uom.name,m_product.coststd,m_product.campoabcdeuno  ORDER BY m_warehouse.name,"
+ "m_locator.value,codigo ASC");		 
		  rs = ps.executeQuery();		  
		  String valor = "";		  
		  System.out.println(" Termina Consulta.......");
		  while (rs.next())
		  {
			  valor =valor +"" + rs.getString(16) + rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) 
+ ","+rs.getString(4)+ "," + rs.getString(5) + ","+ rs.getString(6) + "," + rs.getString(7) + "," + rs.getString(8) 
+ ","+rs.getString(9)+ "," + rs.getString(10)+ ","+rs.getString(11) + "," + rs.getString(12) + ","+ rs.getString(13) 
+ ","+rs.getString(14)+ ","+ rs.getString(15) + "";
		  }
		  valor=valor.replace("null","");
		  PrintWriter in = new PrintWriter("Inventario.csv");
		  PrintWriter out = new PrintWriter("Salida.csv");
		  in.write("ALMACEN,HUECO,CODIGO,DESCRIPCION,CATEGORIA,SUBCATEGORIA,UPC,LICENCIANTE,PIEZAS POR CAJA,"
+"PIEZAS POR PALLET,CANTIDAD,UNIDAD,PIEZAS,COSTO,COSTO TOTAL ESTANDAR" + valor);            
		  in.close();		  
		  System.out.println("ESCRITURA TERMINADA");	
	  ////////////////////////////////TERMINA ESCRITURA DE ARCHIVO///////////////////////////////////
	  ////////////////////////////////COMIENZA LECTURA DE ARCHIVO////////////////////////////////////
		  String [] fields = null;		  
		//File fichero = new File("/home/sistemas/Documentos/ruta.csv");
		//  File fichero = new File("/opt/carga_rutas/cargas.csv");
		  BufferedReader br = null;
		  ArrayList<String> arr=new ArrayList<String>();
		  br =new BufferedReader(new FileReader("Inventario.csv"));
		  //br =new BufferedReader(new FileReader("C:\\Users\\Admin\\Documents\\ruta.csv"));
		  String line = br.readLine();
		  while (null!=line) 
		  {
			  fields = line.split(SEPARATOR);
			  System.out.println(Arrays.toString(fields));
			  fields = removeTrailingQuotes(fields);
			  System.out.println(Arrays.toString(fields));
			  arr.add(fields[0]);
			  arr.add(fields[1]);			  
			  line = br.readLine();
		  }
		  int a=3;
		  String insertar1 = null,insertar2=null,insertar3=null,insertar4=null,val3=null,val1 = null,val2 = null;
	      /////////////////////////////////// TERMINA LECTURA DE ARCHIVO//////////////////////////////
		  Iterator<String> i = arr.iterator();		         
	      /////////////////////////////////// RECOLECTA DE DATOS DE CSV///////////////////////////////
		  while(i.hasNext())
		  {		    			    	   
			  String inter=(String)i.next();
			  System.out.println(inter);
			  if(a==3)
			  {
				  val1 = "";			    	
				  val1=inter;
				  a=1;			    		
			  }		      
			  else if(a==1)
			  {
				  a=3;
				  val3="";			    	
				  val3=inter;		        	 				     		       	      		       	     				  					  				       	       	
					  out.print("insert into prueba values('"+val1+"','"+val3+"');\n");				  
				  System.out.println("Registro insertado ");													   				    		        	
			  }				        
		  }
		  cn.close();
	  }catch (Exception e)
	  {
		  System.out.println(" "+e );
	  }
	  System.out.print("Registros:" +registros);			                                             
  }
///////////////////////////////////////METODO DE SEPARACIÓN CORRECTA DE ARCHIVO CSV////////////////////////////
  public static String[] removeTrailingQuotes(String[] fields)
	{
		String result[] = new String[fields.length];
		for (int i=0;i<result.length;i++)
		{
			result[i] = fields[i].replaceAll("^"+QUOTE, "").replaceAll(QUOTE+"$", "");
		}
		return result;
	}
}