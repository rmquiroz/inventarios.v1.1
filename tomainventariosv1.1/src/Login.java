
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import usuarios.usuario;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import formularios.inicio;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setBackground(Color.DARK_GRAY);
		setTitle("SISTEMA DE GESTION DE INVENTARIOS COPYRIGHT SISTEMAS ERP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 352);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setIcon(new ImageIcon(Login.class.getResource("/imagenes/usuario3.png")));
		lblUsuario.setBounds(25, 100, 138, 34);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setIcon(new ImageIcon(Login.class.getResource("/imagenes/password.png")));
		lblContrasea.setBounds(25, 140, 152, 34);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblContrasea);

		txtusuario = new JTextField();
		txtusuario.setBounds(173, 109, 170, 20);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);

		txtpass = new JPasswordField();
		txtpass.setBounds(173, 149, 170, 20);
		contentPane.add(txtpass);

		JLabel lblSistemaDeToma = new JLabel("SISTEMA DE TOMA DE INVENTARIOS");
		lblSistemaDeToma.setBackground(Color.BLACK);
		lblSistemaDeToma.setBounds(148, 24, 531, 34);
		lblSistemaDeToma.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblSistemaDeToma);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setIcon(new ImageIcon(Login.class.getResource("/imagenes/candado.png")));
		btnIngresar.setBounds(10, 205, 159, 23);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresar();
			}
		});
		contentPane.add(btnIngresar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(Login.class.getResource("/imagenes/salir.png")));
		btnSalir.setBounds(223, 205, 152, 23);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salir();
			}
		});
		contentPane.add(btnSalir);
		
		JLabel lblSistemaDeToma_1 = new JLabel("Sistema de Toma de Inventarios Version 1.1 Copyright Desarrollo de Sistemas 4e Global SAPI de CV");
		lblSistemaDeToma_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblSistemaDeToma_1.setBounds(152, 299, 540, 14);
		contentPane.add(lblSistemaDeToma_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imagenes/inventario.png")));
		lblNewLabel.setBounds(505, 58, 152, 190);
		contentPane.add(lblNewLabel);
	}

	protected void ingresar() {
		String usuario = txtusuario.getText();
		String pass = String.valueOf(txtpass.getPassword());

		gestionusuario gestionusuario = new gestionusuario();

		usuarios.usuario usuario2 = new usuario();
		usuario2.setUsuario(usuario);
		usuario2.setPass(pass);

		usuarios.usuario usu = gestionusuario.obtenerusuario(usuario2);

		if (usu != null) {
			JOptionPane.showMessageDialog(contentPane, "Bienvenido de nuevo");
			
			this.dispose();
			//con esto muestro la ventana inicial
			inicio bienvenido = new inicio();
			bienvenido.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(contentPane, "Datos incorectos",
					"Error", JOptionPane.ERROR_MESSAGE);

		}

	}

	protected void salir() {
		System.exit(0);

	}
}
