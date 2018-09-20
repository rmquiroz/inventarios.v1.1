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
	public static int registros = 0;
	public static String url = "jdbc:postgresql://10.1.250.20:5932/openbravo";
	public static String inventarios= "jdbc:postgresql://10.1.250.24:5932/inventarios";
	public static String usuario="postgres";
	public static String contra="s3st2m1s4e";
  public static void main(String almacenes)
  {
	  try
	  {
		  Class.forName("org.postgresql.Driver");		  
		  Connection cn = DriverManager.getConnection(url, usuario, contra);
		  Connection co = DriverManager.getConnection(inventarios, usuario, contra);		  
		  System.out.println("Ejecutando Query.......");
		  ResultSet rs = null;
		  PreparedStatement ps = cn.prepareStatement("SELECT m_warehouse.name,m_locator.value,m_product.value AS codigo,"
+ "REPLACE(m_product.description,',',' ') AS descripcion,round(sum(m_storage_detail.qtyonhAND),2) AS cantidad,"
+ "REPLACE(REPLACE(c_uom.name, 'Unit', 'UNIDAD'),'Kilogram','KILOGRAMO') AS unidad,round(sum(CASE WHEN m_product.value "
+ "LIKE '1%' THEN 1*m_storage_detail.qtyonhAND WHEN m_product.value LIKE '2%' THEN 1*m_storage_detail.qtyonhAND "
+ "WHEN m_product.value LIKE '3%' THEN 1*m_storage_detail.qtyonhAND WHEN m_product.value LIKE '7%' THEN 1*"
+ "m_storage_detail.qtyonhAND WHEN m_product.value LIKE '8%' THEN 1*m_storage_detail.qtyonhAND WHEN m_product.value LIKE "
+ "'4%' THEN piezas_Caja::NUMERIC*m_storage_detail.qtyonhAND WHEN m_product.value LIKE '5%'  THEN piezas_pallet::NUMERIC*"
+ "m_storage_detail.qtyonhAND ELSE 1*m_storage_detail.qtyonhAND end ),2) AS piezas,  to_char(CASE WHEN (case when "
+ "m_Warehouse.name like '%4E BRANDS EUA%' THEN m_product.campoabcdeuno else to_Char(m_product.coststd) end) is null THEN "
+ "'FALTA VALUACION' ELSE (case when m_Warehouse.name like '%4E BRANDS EUA%' THEN m_product.campoabcdeuno else to_char("
+ "m_product.coststd) end)::varchar  END ) AS costostd,   (round(sum(CASE WHEN m_product.value LIKE '1%' THEN 1*"
+ "m_storage_detail.qtyonhAND   WHEN m_product.value LIKE '2%'  THEN 1*m_storage_detail.qtyonhAND WHEN m_product.value "
+ "LIKE '3%'  THEN 1*m_storage_detail.qtyonhAND  WHEN m_product.value LIKE '7%'  THEN 1*m_storage_detail.qtyonhAND WHEN "
+ "m_product.value LIKE '8%'  THEN 1*m_storage_detail.qtyonhAND WHEN m_product.value LIKE '4%'  THEN piezas_Caja::NUMERIC*"
+ "m_storage_detail.qtyonhAND  WHEN m_product.value LIKE '5%' THEN piezas_pallet::NUMERIC*m_storage_detail.qtyonhAND ELSE "
+ "1*m_storage_detail.qtyonhAND end ),2))*(case when m_Warehouse.name like '%4E BRANDS EUA%' THEN m_product.campoabcdeuno"
+ "::numeric else m_product.coststd end) AS std,chr(13) AS sp,to_char(now(),'DD-MM-YYYY HH:MI:SS') FROM m_storage_detail LEFT JOIN m_attributesetinstance ON "
+ "m_storage_detail.m_attributesetinstance_id=m_attributesetinstance.m_attributesetinstance_id,m_product,m_locator,"
+ "m_warehouse, c_uom  WHERE m_storage_detail.m_product_id = m_product.m_product_id AND m_storage_detail.qtyonhAND <> 0 "
+ "AND m_storage_detail.m_locator_id=m_locator.m_locator_id  AND m_locator.m_warehouse_id=m_warehouse.m_warehouse_id AND "
+ "c_uom.c_uom_id=m_product.c_uom_id  AND m_product.value NOT LIKE '9%' AND m_product.value NOT LIKE 'US%' AND "
+ "m_product.value NOT LIKE 'ES%' AND m_product.value NOT LIKE 'HERRA%' AND m_product.value NOT LIKE 'SERVI%' AND "
+ "m_warehouse.isactive='Y' AND m_warehouse.name similar to ('"+almacenes+"') AND m_Warehouse.name NOT LIKE '4E_MP TEMPORAL' "
+ "AND m_Warehouse.name NOT LIKE '4G_SMO m_productUCCION'  AND m_Warehouse.name NOT LIKE '4G_1D ADUANA' AND m_Warehouse.name NOT LIKE '4E_BRANDS' AND "
+ "m_Warehouse.name NOT LIKE '4G_1F REFACCIONES' AND m_Warehouse.name NOT LIKE 'ALMACEN_MERIDA' GROUP BY m_warehouse.name,"
+ "m_locator.value,m_product.value,m_product.description,unidad,categoria,m_product.upc,m_product.licenciante,"
+ "m_product.piezas_caja,m_product.piezas_pallet,c_uom.name,m_product.coststd,m_product.campoabcdeuno ORDER BY "
+ "m_warehouse.name,m_locator.value,codigo ASC");		 
		  rs = ps.executeQuery();		  
		  String valor = "",nombre="";		  		  
		  System.out.println(" Termina Consulta.......");
		  while (rs.next())
		  {
			  valor =valor +"" + rs.getString(10) + rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) 
+ ","+rs.getString(4)+ "," + rs.getString(5) + ","+ rs.getString(6) + "," + rs.getString(7) + "," + rs.getString(8) 
+ ","+rs.getString(9)+ " " ;
			  nombre=rs.getString(11);
		  }
		  valor=valor.replace("null"," ");
		  File folder = new File(almacenes.replace(" ","-").replace("|", "-")+"");
		  folder.mkdir();
		  PrintWriter in = new PrintWriter(folder+"/Inventario.csv");		  
		  in.write("ALMACEN,HUECO,CODIGO,DESCRIPCION,CANTIDAD,UNIDAD,PIEZAS,COSTO ESTANDAR,COSTO TOTAL ESTANDAR" + valor);            
		  in.close();		  
		  System.out.println("ESCRITURA TERMINADA");	
	  ////////////////////////////////TERMINA ESCRITURA DE ARCHIVO///////////////////////////////////
	  ////////////////////////////////COMIENZA LECTURA DE ARCHIVO////////////////////////////////////
		  String [] fields = null;		  
		  BufferedReader br = null;
		  ArrayList<String> arr=new ArrayList<String>();
		  br =new BufferedReader(new FileReader(folder+"/Inventario.csv"));
		  String line = br.readLine();
		  while (null!=line) 
		  {
			  fields = line.split(SEPARATOR);
			  System.out.println(Arrays.toString(fields));
			  fields = removeTrailingQuotes(fields);			  
			  arr.add(fields[0]);
			  arr.add(fields[1]);
			  arr.add(fields[2]);
			  arr.add(fields[3]);
			  arr.add(fields[4]);
			  arr.add(fields[5]);
			  arr.add(fields[6]);
			  arr.add(fields[7]);
			  arr.add(fields[8]);
			  line = br.readLine();
		  }
		  int a=9;
		  String val1 = null,val11=null;
		  String val2 = null,val22=null;
		  String val3 = null,val33=null;
		  String val4 = null;
		  String val5 = null;
		  String val6 = null;
		  String val7 = null;
		  String val8 = null;
		  String val9 = null;
	      /////////////////////////////////// TERMINA LECTURA DE ARCHIVO//////////////////////////////
		  Iterator<String> i = arr.iterator();		         
	      /////////////////////////////////// RECOLECTA DE DATOS DE CSV///////////////////////////////
		  while(i.hasNext())
		  {		    			    	   
			  String inter=(String)i.next();			  
			  if(a==9)
			  {
				  val1 =null;			    	
				  val11=null;
				  val1=inter;
				  a=8;			    		
			  }		    
			  else if(a==8)
			  {
				  val2 =null;
				  val22=null;
				  val2=inter;
				  a=7;			    		
			  }
			  else if(a==7)
			  {
				  val3 =null;
				  val33=null;
				  val3=inter;
				  a=6;			    		
			  }
			  else if(a==6)
			  {
				  val4 =null;
				  val4=inter;
				  a=5;			    		
			  }
			  else if(a==5)
			  {
				  val5 =null;
				  val5=inter;
				  a=4;			    		
			  }
			  else if(a==4)
			  {
				  val6 =null;
				  val6=inter;
				  a=3;			    		
			  }
			  else if(a==3)
			  {
				  val7 =null;
				  val7=inter;
				  a=2;			    		
			  }
			  else if(a==2)
			  {
				  val8 =null;
				  val8=inter;
				  a=0;			    		
			  }			  
			  else if(a==0)
			  {
				  a=9;
				  val9 =null;
				  val9=inter;
				  ps=cn.prepareStatement("SELECT m_warehouse_id FROM m_warehouse  WHERE name ='"+val1+"'");
				  rs=ps.executeQuery();
				  if(rs.next())
				  {
					  val11=rs.getString(1);
				  }
				  else { val11="";}
				  ps=cn.prepareStatement("SELECT m_locator_id FROM m_locator WHERE value ='"+val2+"'");
				  rs=ps.executeQuery();
				  if(rs.next())
				  {
					  val22=rs.getString(1);
				  }
				  else { val22="";}
				  ps=cn.prepareStatement("SELECT m_product_id FROM m_product WHERE value ='"+val3+"'");
				  rs=ps.executeQuery();
				  if(rs.next())
				  {
					  val33=rs.getString(1);
				  }
				  else { val33="";}
				  registros++;
					  ps=co.prepareStatement("insert into inventario_teorico values((SELECT upper(LOWER( REPLACE("
+ "CAST(uuid_generate_v4()AS varchar(50)),'-','')))),'"+val11+"','"+val1+"','"+val2+"','"+val22+"','"+val3+"','"+val33
+"','"+val4.replace("'","")+"','"+val5+"','"+val6+"','"+val7+"','"+val8+"','"+val9+"');");					  
					  ps.execute();				  													   						  
			  }				        
		  }
		  br.close();
		  cn.close();
		  co.close();
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