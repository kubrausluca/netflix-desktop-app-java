package proje;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	
	KullaniciIslemleri k_islemler = new KullaniciIslemleri();

	private JPanel contentPane;
	private JTextField txtEposta;
	private JLabel lblEposta;
	private JLabel lblParola;
	private JPasswordField passwordField;
	private JLabel label;
	static String eposta;

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
		setTitle("OTURUM A\u00C7");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 20, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEposta = new JTextField();
		txtEposta.setBounds(406, 245, 285, 36);
		txtEposta.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtEposta.setHorizontalAlignment(SwingConstants.CENTER);
		txtEposta.setBackground(Color.GRAY);
		contentPane.add(txtEposta);
		txtEposta.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(403, 327, 288, 36);
		passwordField.setBackground(Color.GRAY);
		contentPane.add(passwordField);
		
		JLabel lblNetflix = new JLabel("NETFL\u0130X");
		lblNetflix.setBounds(21, 28, 169, 52);
		lblNetflix.setHorizontalAlignment(SwingConstants.CENTER);
		lblNetflix.setForeground(Color.RED);
		lblNetflix.setFont(new Font("Tahoma", Font.BOLD, 28));
		contentPane.add(lblNetflix);
		
		JButton btnOturumA = new JButton("Oturum A\u00E7");
		btnOturumA.setBorder(null); 
		btnOturumA.setFocusPainted(false);
		btnOturumA.setBounds(332, 421, 359, 36);
		btnOturumA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				

				eposta = txtEposta.getText();
				String parola = new String(passwordField.getPassword());
				
				boolean girisBasarili = k_islemler.kullaniciGirisYap(eposta, parola);   
				
				if (girisBasarili) {
					
					JOptionPane.showMessageDialog(null, "GÝRÝÞ BAÞARILI");
					//mesaj_yazisi.setText("Giriþ Baþarýlý");
					setVisible(false);
					
					/*
					Loading ob = new Loading();
					ob.setUpLoading();
					ob.setVisible(true);
					*/
					
					
					setVisible(false);
					new KullaniciYonetimSayfasi(eposta).setVisible(true);
					
					
				} else {
					JOptionPane.showMessageDialog(null, "KULLANICI BULUNAMADI...\nÞÝMDÝ KAYDOLUN...");
					setVisible(false);
					new KayitSayfasi().setVisible(true);
					//mesaj_yazisi.setText("Giriþ Baþarýsýz");
				}
				
				
				
			}
		});
		btnOturumA.setBackground(Color.RED);
		btnOturumA.setForeground(Color.WHITE);
		btnOturumA.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(btnOturumA);
		
		lblEposta = new JLabel("E-posta");
		lblEposta.setBounds(315, 244, 90, 36);
		lblEposta.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEposta.setForeground(Color.WHITE);
		contentPane.add(lblEposta);
		
		lblParola = new JLabel("Parola");
		lblParola.setBounds(315, 327, 90, 36);
		lblParola.setForeground(Color.WHITE);
		lblParola.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblParola);
		
		label = new JLabel("Oturum A\u00E7");
		label.setBounds(315, 105, 376, 59);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 28));
		label.setBackground(Color.BLACK);
		contentPane.add(label);
		
		JButton btnKaytOl = new JButton("\u015Eimdi Kaydol >");
		btnKaytOl.setBorder(null); 
		btnKaytOl.setFocusPainted(false);
		btnKaytOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new KayitSayfasi().setVisible(true);
				
			}
		});
		btnKaytOl.setForeground(Color.WHITE);
		btnKaytOl.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnKaytOl.setBackground(Color.DARK_GRAY);
		btnKaytOl.setBounds(332, 481, 359, 36);
		contentPane.add(btnKaytOl);
	}
}
