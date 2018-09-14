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
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnArchivo.add(mntmCerrarSesion);
		
		mnArchivo.add(mntmSalir);
		
		JMenu mnCapturaDeInventario = new JMenu("Inventario");
		menuBar.add(mnCapturaDeInventario);
		
		JMenuItem mntmNuevaCaptura = new JMenuItem("Consultar Inventario");
		mnCapturaDeInventario.add(mntmNuevaCaptura);
		
		JMenuItem mntmCapturaDeInventario = new JMenuItem("Captura de Inventario 1er Conteo");
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
		mnCapturaDeInventario.add(mntmCapturaDeInventario_1);
		
		JMenuItem mntmCapturaDeInventario_2 = new JMenuItem("Captura de Inventario 3er Conteo");
		mnCapturaDeInventario.add(mntmCapturaDeInventario_2);
		
		JMenu mnInformes = new JMenu("Informes");
		menuBar.add(mnInformes);
		
		JMenuItem mntmGeneracionDeMarbetes = new JMenuItem("Generacion de Marbetes");
		mnInformes.add(mntmGeneracionDeMarbetes);
		
		JMenuItem mntmInformeDeer = new JMenuItem("Informe Comparativo");
		mnInformes.add(mntmInformeDeer);
		
		JMenuItem mntmFaltantesYSobrantes = new JMenuItem("Faltantes y Sobrantes");
		mnInformes.add(mntmFaltantesYSobrantes);
		
		JMenuItem menuItem = new JMenuItem("");
		mnInformes.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSistemaDeToma = new JLabel("SISTEMA DE TOMA DE INVENTARIO VENTANA PRINCIPAL");
		lblSistemaDeToma.setForeground(Color.DARK_GRAY);
		lblSistemaDeToma.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSistemaDeToma.setBounds(121, 28, 641, 58);
		contentPane.add(lblSistemaDeToma);
		
		JLabel lblDesarrolloDeSistemas = new JLabel("DESARROLLO DE SISTEMAS ERP");
		lblDesarrolloDeSistemas.setIcon(new ImageIcon(inicio.class.getResource("/imagenes/ob3.png")));
		lblDesarrolloDeSistemas.setBounds(244, 134, 351, 186);
		contentPane.add(lblDesarrolloDeSistemas);
	}
}
