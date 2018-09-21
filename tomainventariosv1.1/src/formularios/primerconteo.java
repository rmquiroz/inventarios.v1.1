package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.SwingConstants;

import primerconteo.primer;

public class primerconteo extends JFrame {

	public static LinkedList contenedor=new LinkedList();
	
	private JPanel contentPane;
	private JTextField txtbuscar;
	private JTextField txtcodigo;
	private JTextField txtcantidad;
	private JTextField txtdescripcion;
	private JTextField textField;
	private JTextField txtuom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					primerconteo frame = new primerconteo();
					frame.setVisible(true);
					frame.setIconImage(new ImageIcon(getClass().getResource("/imagenes/4e.jpg")).getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public primerconteo() {
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 468);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setForeground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtuom = new JTextField();
		txtuom.setFont(new Font("Dialog", Font.PLAIN, 11));
		txtuom.setEditable(false);
		txtuom.setColumns(10);
		txtuom.setBounds(520, 235, 78, 21);
		contentPane.add(txtuom);
		
		JLabel UOM = new JLabel("UOM:");
		UOM.setVerticalAlignment(SwingConstants.BOTTOM);
		UOM.setFont(new Font("Dialog", Font.PLAIN, 14));
		UOM.setBounds(481, 236, 63, 19);
		contentPane.add(UOM);
		
		txtdescripcion = new JTextField();
		txtdescripcion.setEditable(false);
		txtdescripcion.setFont(new Font("Dialog", Font.PLAIN, 11));
		txtdescripcion.setColumns(10);
		txtdescripcion.setBounds(112, 236, 359, 21);
		contentPane.add(txtdescripcion);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 855, 21);
		contentPane.add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBar.add(mnArchivo);
		
		JMenuItem mntmRegresar = new JMenuItem("Regresar");
		mntmRegresar.setIcon(new ImageIcon(primerconteo.class.getResource("/imagenes/regresar.png")));
		mntmRegresar.setFont(new Font("Dialog", Font.PLAIN, 12));
		mntmRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				formularios.inicio inicio= new formularios.inicio();
				inicio.setVisible(true);
				
			}
		});
		mnArchivo.add(mntmRegresar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(primerconteo.class.getResource("/imagenes/salir.png")));
		mntmSalir.setFont(new Font("Dialog", Font.PLAIN, 12));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setVerticalAlignment(SwingConstants.TOP);
		btnBuscar.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Nombre =txtbuscar.getText();
				
				
			}
		});
		btnBuscar.setBounds(628, 85, 89, 28);
		contentPane.add(btnBuscar);
		
		txtbuscar = new JTextField();
		txtbuscar.setFont(new Font("Dialog", Font.PLAIN, 11));
		txtbuscar.setColumns(10);
		txtbuscar.setBounds(163, 87, 336, 23);
		contentPane.add(txtbuscar);
		
		JLabel lblNewLabel = new JLabel("Primer Conteo");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 32, 855, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de Marbete:");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(24, 88, 148, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ubicaci\u00F3n");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel_2.setBounds(173, 119, 489, 42);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(342, 142, 106, 28);
		contentPane.add(label);
		
		JLabel lblCodigo = new JLabel("Codigo: ");
		lblCodigo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCodigo.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblCodigo.setBounds(24, 203, 73, 21);
		contentPane.add(lblCodigo);
		
		txtcodigo = new JTextField();
		txtcodigo.setFont(new Font("Dialog", Font.PLAIN, 11));
		txtcodigo.setBounds(112, 204, 106, 21);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		
	
		final JButton btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String codigo = txtcodigo.getText();
				Connection con = null;
				try {
					Class.forName("org.postgresql.Driver");
					String url = "jdbc:postgresql://10.1.250.20:5932/openbravo";
					String usuario = "postgres";
					String pass = "s3st2m1s4e";
					

					con = DriverManager.getConnection(url, usuario, pass);
					
					 ResultSet rs = null;
					 PreparedStatement ps = con.prepareStatement("SELECT description,uom.name from m_product as prod,c_uom as uom  where prod.c_uom_id=uom.c_uom_id and prod.value like '"+codigo+"'");
					 rs = ps.executeQuery();
				      System.out.println(" Termina Query.......");
					 
				      rs.next();
				      
				      txtdescripcion.setText(rs.getString(1));
				      txtuom.setText(rs.getString(2));
				      
				      txtdescripcion.setEditable(false);
				      txtcodigo.setEditable(false);
				      
				      btnValidar.setEnabled(false); 
					 
				} catch (ClassNotFoundException e) {

					System.out.println("Conexion Fallida DRIVER------>>>");

					e.printStackTrace();
				} catch (SQLException e) {
					System.out.println("Conexion BD NO CONECTA------>>>");
					e.printStackTrace();
				}
			}
		});
		btnValidar.setVerticalAlignment(SwingConstants.TOP);
		btnValidar.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnValidar.setBounds(236, 202, 89, 28);
		contentPane.add(btnValidar);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDescripcion.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblDescripcion.setBounds(24, 235, 87, 23);
		contentPane.add(lblDescripcion);
		
		JLabel lblNewLabel_4 = new JLabel("Cantidad:");
		lblNewLabel_4.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(275, 286, 63, 19);
		contentPane.add(lblNewLabel_4);
		
		txtcantidad = new JTextField();
		txtcantidad.setFont(new Font("Dialog", Font.PLAIN, 11));
		txtcantidad.setBounds(344, 286, 114, 20);
		contentPane.add(txtcantidad);
		txtcantidad.setColumns(10);
		
		JButton btnConfirmarConteo = new JButton("Confirmar Conteo");
		btnConfirmarConteo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			
				
				
			}
		});
		btnConfirmarConteo.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnConfirmarConteo.setVerticalAlignment(SwingConstants.TOP);
		btnConfirmarConteo.setBounds(342, 374, 155, 28);
		contentPane.add(btnConfirmarConteo);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(primerconteo.class.getResource("/imagenes/fondo.jpg")));
		lblNewLabel_5.setBounds(0, 0, 855, 429);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setFont(new Font("Candara", Font.PLAIN, 12));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(173, 121, 359, 21);
		contentPane.add(textField);
	}
}
