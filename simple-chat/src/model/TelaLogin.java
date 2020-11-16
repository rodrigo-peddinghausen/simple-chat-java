package model;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JLabel lblHost;
	private JTextField txtHost;
	private JLabel lblDoor;
	private JTextField txtDoor;
	private JButton btnConnect;

	
	public TelaLogin() {
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.GRAY);
	
		Handler listener = new Handler();
		
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 197, 233);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new LineBorder(new Color(192, 192, 192), 4, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblHost = new JLabel("Host");
		lblHost.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblHost.setBounds(28, 27, 61, 16);
		contentPane.add(lblHost);
		
		txtHost = new JTextField();
		txtHost.setText("127.0.0.1");
		txtHost.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		txtHost.setBounds(28, 55, 130, 26);
		contentPane.add(txtHost);
		txtHost.setColumns(10);
		
		lblDoor = new JLabel("Porta");
		lblDoor.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblDoor.setBounds(28, 93, 61, 16);
		contentPane.add(lblDoor);
		
		txtDoor = new JTextField();
		txtDoor.setText("10000");
		txtDoor.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		txtDoor.setColumns(10);
		txtDoor.setBounds(28, 121, 130, 26);
		contentPane.add(txtDoor);
		
		btnConnect = new JButton("Conectar");
		btnConnect.setForeground(new Color(0, 0, 0));
		btnConnect.setBackground(new Color(100, 149, 237));
		btnConnect.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnConnect.setBounds(28, 159, 130, 29);
		contentPane.add(btnConnect);
		btnConnect.addActionListener(listener);
		
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnConnect) {
				String host = txtHost.getText();
				int door = Integer.parseInt(txtDoor.getText());
				
				try {
					new Cliente(host, door);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	
				dispose();
				
			}
		}
		
	}
}
