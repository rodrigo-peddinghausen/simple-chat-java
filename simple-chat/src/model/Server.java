package model;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Server extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private ServerSocket server = null;
	private Socket client = null;
	private JTextArea textArea;

	
	public Server() throws IOException {
		setBackground(Color.GRAY);

		setTitle("Servidor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textArea = new JTextArea();
		textArea.setForeground(Color.GREEN);
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setEditable(false);
		textArea.setBounds(6, 6, 438, 223);
		contentPane.add(textArea);

		textArea.append("Servidor escutando na porta 10000. \n");
		
		setVisible(true);
		run();
	}

	public void run() throws IOException {
		this.server = new ServerSocket(10000);

		this.client = server.accept();

		JOptionPane.showInternalMessageDialog(contentPane, "Cliente conectado");

		Scanner sc = new Scanner(client.getInputStream());
		while (sc.hasNextLine()) {
			textArea.append("Cliente: " + sc.nextLine());
			textArea.append("\n");
		}

		sc.close();
	}

}
