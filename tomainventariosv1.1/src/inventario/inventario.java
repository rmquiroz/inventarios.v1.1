package inventario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import correo.EmailUtility;
public class inventario
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
	private static String host="smtp.gmail.com";
    private static String port="25";
    private static String user="informesob3@4eglobal.com";
    private static String pass="S1st3mas43S1st3mas43";
    static String resultMessage = "";
  public static String main(String almacenes)
  {
	  try
	  {
		  Class.forName("org.postgresql.Driver");		  
		  Connection cn = DriverManager.getConnection(url, usuario, contra);
		  Connection co = DriverManager.getConnection(inventarios, usuario, contra);		  
		  System.out.println("Ejecutando Query.......");
		  ResultSet rs = null;
		  PreparedStatement ps= co.prepareStatement("SELECT (CASE WHEN max(extract(doy FROM fecha)) IS NULL THEN 0.0 ELSE "
+ "max(extract(doy FROM fecha)) END)::NUMERIC+to_char(now(),'YYYY')::numeric,extract(doy FROM now())+to_char(now(),'YYYY')::numeric FROM "
+ "inventario_teorico WHERE almacen similar to ('"+almacenes+"')");
		  rs=ps.executeQuery();
		  if(rs.next())
		  {
			  fecha=rs.getInt(1);
			  hoy=rs.getInt(2);
		  }
		  if(hoy-2>=fecha)
		  {
			  System.out.println("ENTRA AL IF");
			  ps = cn.prepareStatement("SELECT m_warehouse.name,m_locator.value,m_product.value AS codigo,"
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
			  in.write("ALMACEN,HUECO,CODIGO,DESCRIPCION,CANTIDAD,UNIDAD,PIEZAS,COSTO ESTANDAR,COSTO TOTAL ESTANDAR" 
+ valor);            
			  in.close();
			  System.out.println("ESCRITURA TERMINADA");	
	  ////////////////////////////////TERMINA ESCRITURA DE ARCHIVO///////////////////////////////////		  		  		  		  		 
			  ps = cn.prepareStatement("SELECT REPLACE(cli.name,',','') as Tercero,rem.documentno,prod.value AS "
+ "Codigo_interno,REPLACE(prod.name,',','') AS nombre_producto,reml.description AS desclin,prod.categoria AS cat,"
+ "prod.subcategoria AS subcat,case when m_attributesetinstance.description is null then '-' else m_attributesetinstance."
+ "description end as atributo,reml.movementqty AS cantidad, uom.name as UOM,rem.updated AS fecha_movimiento,CASE WHEN "
+ "rem.description = NULL THEN '-' ELSE REPLACE(REPLACE(REPLACE(replace(rem.description,CHR(10),' '),CHR(13),'-'),'  ',"
+ "''),',','') END AS descripcion, REPLACE(loc.value,',','') as hueco,alm.name,case when rem.docstatus like 'CO' then '"
+ "COMPLETADO' else case when rem.docstatus like 'DR' then 'BORRADOR' ELSE '' END END as estatus,usuario.name as usuario,"
+ "case when rem.documentno similar to '(RLE|REM)%' and cli.name similar to  '%(4E DE MEXICO SA DE CV|4E GLOBAL, S.A.P.I "
+ "DE C.V)%' then (case when split_part((replace(rem.description,CHR(10),'|')),'|',2) is null then '-' else split_part(("
+ "replace(rem.description,CHR(10),'|')),'|',2) end) else '-' end as monta, to_char(rem.movementdate,'YYYY-MM-DD') as "
+ "fecha,replace(org.name,',',' ') as organizacion, 'sp' AS sp from m_inout AS rem,m_product AS prod,c_uom as uom,"
+ "m_locator AS loc,c_bpartner as cli,m_warehouse as alm,ad_user as usuario,ad_org as org,m_inoutline AS reml left join "
+ "m_attributesetinstance on reml.m_attributesetinstance_id=m_attributesetinstance.m_attributesetinstance_id where rem."
+ "c_bpartner_id=cli.c_bpartner_id and reml.m_inout_id=rem.m_inout_id and reml.m_product_id=prod.m_product_id and "
+ "prod.c_uom_id=uom.c_uom_id and reml.m_locator_id=loc.m_locator_id and rem.c_bpartner_id=cli.c_bpartner_id and loc."
+ "m_warehouse_id=alm.m_warehouse_id and rem.createdby=usuario.ad_user_id AND alm.name similar to ('"+almacenes+"') and "
+ "rem.ad_org_id=org.ad_org_id ORDER by movementdate desc LIMIT 1");
			  rs = ps.executeQuery();
			  ArrayList<String> col=new ArrayList<String>(); 
			  while (rs.next())
			  {
				  col.add(rs.getString(1));
				  col.add(rs.getString(2));
				  col.add(rs.getString(3));
				  col.add(rs.getString(4));
				  col.add(rs.getString(5));
				  col.add(rs.getString(6));
				  col.add(rs.getString(7));
				  col.add(rs.getString(8));
				  col.add(rs.getString(9));
				  col.add(rs.getString(10));
				  col.add(rs.getString(11));
				  col.add(rs.getString(12));
				  col.add(rs.getString(13));
				  col.add(rs.getString(14));
				  col.add(rs.getString(15));
				  col.add(rs.getString(16));
				  col.add(rs.getString(17));
				  col.add(rs.getString(18));
				  col.add(rs.getString(19));
				  col.add(rs.getString(20));
			  }
			  WritableWorkbook wb = Workbook.createWorkbook(new File(folder+"/Ultimoscambios_almacen.xls"));
			  WritableSheet ws = wb.createSheet("ReporteEntradas-salidas:", 0);		  
			  WritableFont wf = new WritableFont(WritableFont.TAHOMA, 10, WritableFont.NO_BOLD);
			  WritableCellFormat cf = new WritableCellFormat(wf);	        
			  int column = 0;
			  int row = 0;
			  Iterator<String> i = col.iterator();	        
			  Label ec1 = new Label(column, row, "TERCERO", cf);	        
			  ws.addCell(ec1);
			  column++;
			  Label ec2 = new Label(column, row, "NO_DOCUMENTO", cf);
			  ws.addCell(ec2);
			  column++;
			  Label ec3 = new Label(column, row, "CODIGO INTERNO", cf);
			  ws.addCell(ec3);
			  column++;
			  Label ec4 = new Label(column, row, "NOMBRE_PRODUCTO", cf);
			  ws.addCell(ec4);
			  column++;
			  Label ec5 = new Label(column, row, "DESCRIPCION DE LINEA", cf);
			  ws.addCell(ec5);
			  column++;
			  Label ec6 = new Label(column, row, "CATEGORIA", cf);
			  ws.addCell(ec6);
			  column++;
			  Label ec7 = new Label(column, row, "SUBCATEGORIA", cf);
			  ws.addCell(ec7);
			  column++;
			  Label ec8 = new Label(column, row, "ATRIBUTO", cf);
			  ws.addCell(ec8);
			  column++;
			  Label ec9 = new Label(column, row, "CANTIDAD", cf);
			  ws.addCell(ec9);
			  column++;
			  Label ec10 = new Label(column, row, "UOM", cf);
			  ws.addCell(ec10);
			  column++;
			  Label ec11 = new Label(column, row, "FECHA_MOVIMIENTO", cf);
			  ws.addCell(ec11);
			  column++;
			  Label ec12 = new Label(column, row, "DESCRIPCION", cf);
			  ws.addCell(ec12);
			  column++;
			  Label ec13 = new Label(column, row, "HUECO", cf);
			  ws.addCell(ec13);
			  column++;
			  Label ec14 = new Label(column, row, "ALMACEN", cf);
			  ws.addCell(ec14);
			  column++;
			  Label ec15 = new Label(column, row, "STATUS", cf);
			  ws.addCell(ec15);
			  column++;
			  Label ec16 = new Label(column, row, "USUARIO", cf);
			  ws.addCell(ec16);
			  column++;
			  Label ec17 = new Label(column, row, "MONTACARGAS", cf);
			  ws.addCell(ec17);
			  column++;
			  Label ec18 = new Label(column, row, "FECHA", cf);
			  ws.addCell(ec18);
			  column++;
			  Label ec19 = new Label(column, row, "ORGANIZACION", cf);
			  ws.addCell(ec19);		  
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
			  int iteracion;
			  String[] alma=new String[9];
			  System.out.println("ALMACENES"+almacenes);
			  alma=almacenes.split("\\|");
			  iteracion=alma.length;
			  for(int x=0;x<iteracion;x++)
			  {
				  ps = cn.prepareStatement("SELECT mov.documentno AS folio_documento,replace(mov.name,',','') AS "
+ "nombre_documento,"
+ "mov.updated AS fecha_movimiento, replace(mov.description,',','') AS descripcion,m_attributeinstance.value,prod.value,"
+ "replace(prod.name,',',''), movl.description,movl.movementqty, uom.name,alm.name AS Almacen_Salida,loc.value AS "
+ "hueco_salida,alm1.name AS Almacen_Entrada, loc1.value AS hueco_entrada, case when mov.processed = 'Y' then 'PROCESADO' "
+ "ELSE CASE WHEN mov.processed = 'N' then 'NO PROCESADO' ELSE '' END END AS estatus,usuario.name AS usuario FROM "
+ "m_movement AS mov, m_movementline AS movl LEFT JOIN m_attributesetinstance ON movl.m_attributesetinstance_id="
+ "m_attributesetinstance.m_attributesetinstance_id LEFT JOIN m_attributeinstance ON m_attributesetinstance."
+ "m_attributesetinstance_id=m_attributeinstance.m_attributesetinstance_id,m_product AS prod,c_uom as uom,m_locator as loc,"
+ "m_locator as loc1, ad_user as usuario,m_warehouse AS alm, m_warehouse AS alm1 WHERE movl.m_movement_id=mov."
+ "m_movement_id AND movl.m_product_id=prod.m_product_id AND prod.c_uom_id=uom.c_uom_id AND mov.createdby=usuario."
+ "ad_user_id AND movl.m_locator_id=loc.m_locator_id AND movl.m_locatorto_id=loc1.m_locator_id AND loc.m_warehouse_id=alm."
+ "m_warehouse_id AND loc1.m_warehouse_id=alm1.m_warehouse_id AND alm.name similar to ('"+alma[x]+"') ORDER BY mov."
+ "updated DESC LIMIT 1");
				  WritableSheet ws2 = wb.createSheet("Movimientos"+alma[x], 0+x);
				  System.out.println("LLEGAMOS HASTA AQUI "+alma[x]+x);
				  rs = ps.executeQuery();
				  ArrayList<String> col2=new ArrayList<String>();
				  String doc="";
				  while (rs.next())
				  {	
					  doc=rs.getString(2);
				  }
				  ps = cn.prepareStatement("SELECT mov.documentno AS folio_documento,replace(mov.name,',','') AS nombre_"
+ "documento,mov.updated AS fecha_movimiento, replace(mov.description,',','') AS descripcion,m_attributeinstance.value,"
+ "prod.value,replace(prod.name,',',''), movl.description,movl.movementqty, uom.name,alm.name AS Almacen_Salida,loc.value "
+ "AS hueco_salida,alm1.name AS Almacen_Entrada, loc1.value AS hueco_entrada, case when mov.processed = 'Y' then "
+ "'PROCESADO' ELSE CASE WHEN mov.processed = 'N' then 'NO PROCESADO' ELSE '' END END AS estatus,usuario.name AS usuario "
+ "FROM m_movement AS mov, m_movementline AS movl LEFT JOIN m_attributesetinstance ON movl.m_attributesetinstance_id="
+ "m_attributesetinstance.m_attributesetinstance_id LEFT JOIN m_attributeinstance ON m_attributesetinstance."
+ "m_attributesetinstance_id=m_attributeinstance.m_attributesetinstance_id,m_product AS prod,c_uom as uom,m_locator as "
+ "loc,m_locator as loc1, ad_user as usuario,m_warehouse AS alm, m_warehouse AS alm1 WHERE movl.m_movement_id=mov."
+ "m_movement_id AND movl.m_product_id=prod.m_product_id AND prod.c_uom_id=uom.c_uom_id AND mov.createdby=usuario."
+ "ad_user_id AND movl.m_locator_id=loc.m_locator_id AND movl.m_locatorto_id=loc1.m_locator_id AND loc.m_warehouse_id="
+ "alm.m_warehouse_id AND loc1.m_warehouse_id=alm1.m_warehouse_id AND mov.name='"+doc+"' ORDER BY mov.updated DESC ");
				  System.out.println("Consulta "+ps);
				  rs = ps.executeQuery();
				  while (rs.next())
				  {
					  col2.add(rs.getString(1));
					  col2.add(rs.getString(2));
					  col2.add(rs.getString(3));
					  col2.add(rs.getString(4));
					  col2.add(rs.getString(5));
					  col2.add(rs.getString(6));
					  col2.add(rs.getString(7));
					  col2.add(rs.getString(8));
					  col2.add(rs.getString(9));
					  col2.add(rs.getString(10));
					  col2.add(rs.getString(11));
					  col2.add(rs.getString(12));
					  col2.add(rs.getString(13));
					  col2.add(rs.getString(14));
					  col2.add(rs.getString(15));
					  col2.add(rs.getString(16));               
					  col2.add("sp");          		      
				  }
				  System.out.println("Consulta2 "+ps);
				  column = 0;
				  row = 0;
				  Iterator<String> i2 = col2.iterator();	        
				  Label ecs1 = new Label(column, row, "FOLIO DOCUMENTO", cf);	        
				  ws2.addCell(ecs1);
				  column++;
				  Label ecs2 = new Label(column, row, "NOMBRE DOCUMENTO", cf);
				  ws2.addCell(ecs2);
				  column++;
				  Label ecs3 = new Label(column, row, "FECHA DOCUMENTO", cf);
				  ws2.addCell(ecs3);
				  column++;
				  Label ecs4 = new Label(column, row, "DESCRIPCION MOVIMIENTO", cf);
				  ws2.addCell(ecs4);
				  column++;
				  Label ecs5 = new Label(column, row, "ATRIBUTOS", cf);
				  ws2.addCell(ecs5);
				  column++;
				  Label ecs6 = new Label(column, row, "CODIGO PRODUCTO", cf);
				  ws2.addCell(ecs6);
				  column++;
				  Label ecs7 = new Label(column, row, "PRODUCTO", cf);
				  ws2.addCell(ecs7);
				  column++;
				  Label ecs8 = new Label(column, row, "ATRIBUTO", cf);
				  ws2.addCell(ecs8);
				  column++;
				  Label ecs9 = new Label(column, row, "CANTIDAD", cf);
				  ws2.addCell(ecs9);
				  column++;
				  Label ecs10 = new Label(column, row, "UOM", cf);
				  ws2.addCell(ecs10);
				  column++;
				  Label ecs11 = new Label(column, row, "FECHA_MOVIMIENTO", cf);
				  ws2.addCell(ecs11);
				  column++;
				  Label ecs12 = new Label(column, row, "DESCRIPCION", cf);
				  ws2.addCell(ecs12);
				  column++;
				  Label ecs13 = new Label(column, row, "HUECO", cf);
				  ws2.addCell(ecs13);
				  column++;
				  Label ecs14 = new Label(column, row, "ALMACEN", cf);
				  ws2.addCell(ecs14);
				  column++;
				  Label ecs15 = new Label(column, row, "STATUS", cf);
				  ws2.addCell(ecs15);
				  column++;
				  Label ecs16 = new Label(column, row, "USUARIO", cf);
				  ws2.addCell(ecs16);
				  column++;
				  Label ecs17 = new Label(column, row, "MONTACARGAS", cf);
				  ws2.addCell(ecs17);
				  column++;
				  Label ecs18 = new Label(column, row, "FecsHA", cf);
				  ws2.addCell(ecs18);
				  column++;
				  Label ecs19 = new Label(column, row, "ORGANIZACION", cf);
				  ws2.addCell(ecs19);				  
				  row = 1;
				  column = 0;
				  while (i2.hasNext())
				  {
					  String campo = (String)i2.next();
					  if (campo == null) 
					  {
						  campo = " ";
					  }
					  if (campo.equals("sp"))
					  {
						  i2.remove();
						  row++;
						  column = 0;
					  }
					  else
					  {
						  Label l1 = new Label(column, row, campo, cf);
						  ws2.addCell(l1);
						  column++;
					  }				  
				  }			 		  
			  }	  		  
			  wb.write();
			  wb.close();
			  	   		  
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
			  Iterator<String> 	s = arr.iterator();		         
	      /////////////////////////////////// RECOLECTA DE DATOS DE CSV///////////////////////////////
			  while(s.hasNext())
			  {		
				  
				  String inter=(String)s.next();			  
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
					  ResultSet rs1=null;
					  PreparedStatement pas=cn.prepareStatement("SELECT m_warehouse_id FROM m_warehouse  WHERE name ='"+val1+"'");
					  rs1=pas.executeQuery();
					  System.out.println("CERO");
					  if(rs1.next())
					  {
						  val11=rs1.getString(1);
					  }
					  else 
					  { 
						  val11="";
					  }
					  ps=cn.prepareStatement("SELECT m_locator_id FROM m_locator WHERE value ='"+val2+"'");
					  rs=ps.executeQuery();
					  System.out.println("UNO");
					  if(rs.next())
					  {
						  val22=rs.getString(1);
					  }
					  else 
					  { 
						  val22="";
					  }
					  ps=cn.prepareStatement("SELECT m_product_id FROM m_product WHERE value ='"+val3+"'");
					  rs=ps.executeQuery();
					  System.out.println("DOS");
					  if(rs.next())
					  {
						  val33=rs.getString(1);
					  }
					  else 
					  { 
						  val33="";
					  }
					  registros++;
					  ps=co.prepareStatement("insert into inventario_teorico values((SELECT upper(LOWER( REPLACE("
+ "CAST(uuid_generate_v4()AS varchar(50)),'-','')))),'"+val11+"','"+val1+"','"+val2+"','"+val22+"','"+val3+"','"+val33
+"','"+val4.replace("'","")+"','"+val5+"','"+val6+"','"+val7+"','"+val8+"','"+val9+"',now());");
					  System.out.println("Inserta"+ps);
					  ps.execute();				  													   						  
				  }				        
			  }
			  br.close();
			  mensaje="Carga exitosa";
			  String recipient = "rquiroz@4eglobal.com lmartinez@4eglobal.com";			  
			  String direcciones[]=recipient.split(" ");
			  System.out.println(""+direcciones.length);
			  String alm=almacenes.replace(" ","-").replace("|", "-")+"";			 
			  String subject = "ALERTA ERP: SE HAN DETENIDO ALMACENES";
			  String content = "SE HAN INICIADO CONTEOS DE ALMACENES";		        
			  System.out.println("Recopilación de datos lista " +recipient+", "+ subject + ", "+content);    		    
			  try 
			  {
				  EmailUtility.sendEmail(host, port, user, pass, recipient, subject,content,alm);
			  } catch (AddressException e) 
			  {
				  e.printStackTrace();
			  } catch (MessagingException e) 
			  {				
				  e.printStackTrace();
			  }
			  resultMessage = "The e-mail was sent successfully";
			  System.out.println("Enviado"+alm);		  		  			  
		  }
		  else
		  {
			  mensaje="Almacen cargado en rango de tiempo inválido";
		  } 
		  cn.close();
		  co.close();
	  } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  System.out.print("Registros:" +registros);	  
	  return mensaje;
  }
/////////////////////////////////////METODO DE SEPARACIÓN CORRECTA DE ARCHIVO CSV////////////////////////////
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