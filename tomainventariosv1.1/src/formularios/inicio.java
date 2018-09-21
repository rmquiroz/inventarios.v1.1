package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Insets;

public class inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application. VERSION CON CAMBIO 232
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("hola");
					inicio frame = new inicio();
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
	public inicio() {
		setTitle("VENTANA PRINCIPAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 468);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(0, 200, 0, 0));
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo     ");
		mnArchivo.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(inicio.class.getResource("/imagenes/salir.png")));
		mntmSalir.setFont(new Font("Dialog", Font.PLAIN, 12));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.setFont(new Font("Dialog", Font.PLAIN, 12));
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnArchivo.add(mntmCerrarSesion);
		
		mnArchivo.add(mntmSalir);
		
		JMenu mnCapturaDeInventario = new JMenu("Inventario     ");
		mnCapturaDeInventario.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBar.add(mnCapturaDeInventario);
		
		JMenuItem mntmNuevaCaptura = new JMenuItem("Consultar Inventario");
		mntmNuevaCaptura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				formularios.inventarioform  inventarios = new formularios.inventarioform();
				inventarios.setVisible(true);
			}
				
			
		});
		mntmNuevaCaptura.setIcon(new ImageIcon(inicio.class.getResource("/imagenes/buscar.png")));
		mntmNuevaCaptura.setFont(new Font("Dialog", Font.PLAIN, 12));
		mnCapturaDeInventario.add(mntmNuevaCaptura);
		
		JMenuItem mntmCapturaDeInventario = new JMenuItem("Captura de Inventario 1er Conteo");
		mntmCapturaDeInventario.setIcon(new ImageIcon(inicio.class.getResource("/imagenes/uno.png")));
		mntmCapturaDeInventario.setFont(new Font("Dialog", Font.PLAIN, 12));
		mntmCapturaDeInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				//con esto muestro la ventana inicial
				formularios.primerconteo primerconteo = new formularios.primerconteo();
				primerconteo.setVisible(true);
			}
		});
		mnCapturaDeInventario.add(mntmCapturaDeInventario);
		
		JMenuItem mntmCapturaDeInventario_1 = new JMenuItem("Captura de Inventario 2do Conteo");
		mntmCapturaDeInventario_1.setIcon(new ImageIcon(inicio.class.getResource("/imagenes/dos.png")));
		mntmCapturaDeInventario_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		mnCapturaDeInventario.add(mntmCapturaDeInventario_1);
		
		JMenuItem mntmCapturaDeInventario_2 = new JMenuItem("Captura de Inventario 3er Conteo");
		mntmCapturaDeInventario_2.setIcon(new ImageIcon(inicio.class.getResource("/imagenes/tres.png")));
		mntmCapturaDeInventario_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		mnCapturaDeInventario.add(mntmCapturaDeInventario_2);
		
		JMenu mnInformes = new JMenu("Informes");
		mnInformes.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBar.add(mnInformes);
		
		JMenuItem mntmGeneracionDeMarbetes = new JMenuItem("Generacion de Marbetes");
		mntmGeneracionDeMarbetes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				//con esto muestro la ventana inicial
				formularios.generarmarbete generarmarbete = new formularios.generarmarbete();
				generarmarbete.setVisible(true);
				
			}
		});
		mntmGeneracionDeMarbetes.setIcon(new ImageIcon(inicio.class.getResource("/imagenes/tag.png")));
		mntmGeneracionDeMarbetes.setFont(new Font("Dialog", Font.PLAIN, 12));
		mnInformes.add(mntmGeneracionDeMarbetes);
		
		JMenuItem mntmInformeDeer = new JMenuItem("Informe Comparativo");
		mntmInformeDeer.setIcon(new ImageIcon(inicio.class.getResource("/imagenes/informe.png")));
		mntmInformeDeer.setFont(new Font("Dialog", Font.PLAIN, 12));
		mnInformes.add(mntmInformeDeer);
		
		JMenuItem mntmFaltantesYSobrantes = new JMenuItem("Faltantes y Sobrantes");
		mntmFaltantesYSobrantes.setIcon(new ImageIcon(inicio.class.getResource("/imagenes/inventariofinal.png")));
		mntmFaltantesYSobrantes.setFont(new Font("Dialog", Font.PLAIN, 12));
		mnInformes.add(mntmFaltantesYSobrantes);
		
		JMenuItem menuItem = new JMenuItem("");
		mnInformes.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSistemaDeToma = new JLabel("SISTEMA DE TOMA DE INVENTARIO VENTANA PRINCIPAL");
		lblSistemaDeToma.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemaDeToma.setForeground(Color.WHITE);
		lblSistemaDeToma.setFont(new Font("Dialog", Font.PLAIN, 26));
		lblSistemaDeToma.setBounds(0, 11, 855, 58);
		contentPane.add(lblSistemaDeToma);
		
		JLabel lblDesarrolloDeSistemas = new JLabel("      DESARROLLO  DE  SISTEMAS  ERP");
		lblDesarrolloDeSistemas.setForeground(Color.WHITE);
		lblDesarrolloDeSistemas.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblDesarrolloDeSistemas.setIcon(new ImageIcon(inicio.class.getResource("/imagenes/ob3.png")));
		lblDesarrolloDeSistemas.setBounds(145, 115, 560, 186);
		contentPane.add(lblDesarrolloDeSistemas);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(inicio.class.getResource("/imagenes/fondo.jpg")));
		lblNewLabel.setBounds(0, 0, 855, 408);
		contentPane.add(lblNewLabel);
	}
}
