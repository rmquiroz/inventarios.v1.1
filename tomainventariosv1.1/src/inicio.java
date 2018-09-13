import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 468);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSistemaDeToma = new JLabel("SISTEMA DE TOMA DE INVENTARIO VENTANA PRINCIPAL");
		lblSistemaDeToma.setForeground(Color.YELLOW);
		lblSistemaDeToma.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSistemaDeToma.setBounds(123, 11, 641, 58);
		contentPane.add(lblSistemaDeToma);
	}

}
