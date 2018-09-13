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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 404);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(32, 113, 88, 34);
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasea.setBounds(32, 185, 117, 34);
		contentPane.add(lblContrasea);

		txtusuario = new JTextField();
		txtusuario.setBounds(142, 122, 170, 20);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);

		txtpass = new JPasswordField();
		txtpass.setBounds(142, 192, 170, 25);
		contentPane.add(txtpass);

		JLabel lblSistemaDeToma = new JLabel("SISTEMA DE TOMA DE INVENTARIOS");
		lblSistemaDeToma.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSistemaDeToma.setBounds(121, 11, 531, 34);
		contentPane.add(lblSistemaDeToma);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresar();
			}
		});
		btnIngresar.setBounds(91, 234, 106, 23);
		contentPane.add(btnIngresar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salir();
			}
		});
		btnSalir.setBounds(264, 331, 89, 23);
		contentPane.add(btnSalir);
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
