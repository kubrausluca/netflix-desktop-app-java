package proje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.PSSParameterSpec;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.PasswordField;

import javax.swing.UIManager;
import java.awt.SystemColor;

public class KayitSayfasi extends JFrame {
	
	KullaniciIslemleri k_islemler = new KullaniciIslemleri();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KayitSayfasi frame = new KayitSayfasi();
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
	public KayitSayfasi() {
		setTitle("Kayýt Sayfasý");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 20, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField txtEposta = new JTextField();
		txtEposta.setBounds(327, 245, 364, 36);
		txtEposta.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtEposta.setHorizontalAlignment(SwingConstants.CENTER);
		txtEposta.setBackground(Color.GRAY);
		contentPane.add(txtEposta);
		txtEposta.setColumns(10);
		
		JLabel lblNetflix = new JLabel("NETFL\u0130X");
		lblNetflix.setBounds(21, 28, 169, 52);
		lblNetflix.setHorizontalAlignment(SwingConstants.CENTER);
		lblNetflix.setForeground(new Color(255, 0, 0));
		lblNetflix.setFont(new Font("Tahoma", Font.BOLD, 34));
		contentPane.add(lblNetflix);
		
		
		
		JLabel lblEposta = new JLabel("E-posta");
		lblEposta.setBounds(235, 245, 90, 36);
		lblEposta.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEposta.setForeground(Color.WHITE);
		contentPane.add(lblEposta);
		
		JLabel lblKaytOl = new JLabel("S\u0131n\u0131rs\u0131z film, dizi ve \u00E7ok");
		lblKaytOl.setBounds(315, 105, 376, 36);
		lblKaytOl.setHorizontalAlignment(SwingConstants.CENTER);
		lblKaytOl.setForeground(Color.WHITE);
		lblKaytOl.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblKaytOl.setBackground(Color.BLACK);
		contentPane.add(lblKaytOl);
		
		JButton button = new JButton("Oturum A\u00E7");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				new Login().setVisible(true);
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setFocusPainted(false);
		button.setBorder(null);
		button.setBackground(Color.RED);
		button.setBounds(844, 45, 140, 30);
		contentPane.add(button);
		
		JLabel lblDahaFazlas = new JLabel("daha fazlas\u0131.");
		lblDahaFazlas.setHorizontalAlignment(SwingConstants.CENTER);
		lblDahaFazlas.setForeground(Color.WHITE);
		lblDahaFazlas.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblDahaFazlas.setBackground(Color.BLACK);
		lblDahaFazlas.setBounds(315, 148, 376, 36);
		contentPane.add(lblDahaFazlas);
		
		JLabel arkaplan = new JLabel("");
		
		Image img = new ImageIcon(this.getClass().getResource("/kaydol.jpg")).getImage();
		arkaplan.setIcon(new ImageIcon(img));
		
		arkaplan.setBounds(0, 441, 994, 230);
		contentPane.add(arkaplan);
		
		
		///////////////////////////////////////////////////////////////////////////
		
		JLabel kayit2_txt = new JLabel("\u00DCyeli\u011Finizi ba\u015Flatmak i\u00E7in");
		kayit2_txt.setVisible(false);
		kayit2_txt.setHorizontalAlignment(SwingConstants.CENTER);
		kayit2_txt.setForeground(Color.WHITE);
		kayit2_txt.setFont(new Font("Tahoma", Font.BOLD, 28));
		kayit2_txt.setBackground(Color.BLACK);
		kayit2_txt.setBounds(315, 105, 376, 36);
		contentPane.add(kayit2_txt);
		
		JLabel kayit2_txt2 = new JLabel("bir parola olu\u015Fturun.");
		kayit2_txt2.setVisible(false);
		kayit2_txt2.setHorizontalAlignment(SwingConstants.CENTER);
		kayit2_txt2.setForeground(Color.WHITE);
		kayit2_txt2.setFont(new Font("Tahoma", Font.BOLD, 28));
		kayit2_txt2.setBackground(Color.BLACK);
		kayit2_txt2.setBounds(315, 152, 376, 36);
		contentPane.add(kayit2_txt2);
		
		
		
		JPasswordField passwordField2 = new JPasswordField();
		passwordField2.setVisible(false);
		passwordField2.setBackground(Color.GRAY);
		passwordField2.setBounds(327, 320, 364, 36);
		contentPane.add(passwordField2);
		
		
		JButton btnDevam = new JButton("DEVAM ET >");
		btnDevam.setVisible(false);
		btnDevam.setBorder(null); 
		btnDevam.setFocusPainted(false);
		btnDevam.setBounds(413, 395, 214, 36);
		btnDevam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				// Burada e-mail ve þifreyi alýyoruz
				
				String e_posta = txtEposta.getText();
				String sifre = passwordField2.getText();
				
				boolean girisBasarili = k_islemler.kayitKontrol2(e_posta, sifre);   
				
				if (sifre.equals(""))
				{
					JOptionPane.showMessageDialog(null, "ÞÝFRE ALANI BOÞ BIRAKILAMAZ...");
				}
				
				else if (girisBasarili) {
					
					JOptionPane.showMessageDialog(null, "BU E-MAÝL KULLANILMAKTA...");
					//mesaj_yazisi.setText("Giriþ Baþarýsýz");
					
					
				} else {
					
					
					/*
					Loading ob = new Loading();
					ob.setUpLoading();
					ob.setVisible(true);
					*/

					//System.out.println(txtEposta.getText());
					//System.out.println(passwordField2.getText());
					
					
					
					setVisible(false);
					new KayitSayfasi2(txtEposta.getText(), passwordField2.getText()).setVisible(true);
				}
				
			}
		});
		btnDevam.setBackground(Color.RED);
		btnDevam.setForeground(Color.WHITE);
		btnDevam.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(btnDevam);
		
		
	
		JLabel lblParola = new JLabel("Parola");
		lblParola.setVisible(false);
		lblParola.setForeground(Color.WHITE);
		lblParola.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblParola.setBounds(235, 319, 91, 36);
		contentPane.add(lblParola);
		
		
		
		
		JButton btnKaydol = new JButton("\u015Eimdi Kaydol >");
		btnKaydol.setBorder(null); 
		btnKaydol.setFocusPainted(false);
		btnKaydol.setBounds(378, 320, 250, 36);
		btnKaydol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String e_posta = txtEposta.getText();
				
				boolean girisBasarili = k_islemler.kayitKontrol(e_posta);   
				
				if (txtEposta.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "E-POSTA ADRESÝ GÝRÝNÝZ...");
					setVisible(true);
				}
				
				else if (girisBasarili) {
					
					JOptionPane.showMessageDialog(null, "BU E-MAÝL KULLANILMAKTA...");
					//mesaj_yazisi.setText("Giriþ Baþarýsýz");
					
					
				} else {
					
					arkaplan.setVisible(false);
					btnKaydol.setVisible(false);
					lblDahaFazlas.setVisible(false);
					lblKaytOl.setVisible(false);
					
					txtEposta.setEditable(false);
					kayit2_txt.setVisible(true);
					kayit2_txt2.setVisible(true);
					lblParola.setVisible(true);
					passwordField2.setVisible(true);
					btnDevam.setVisible(true);
					
					/*
					Loading ob = new Loading();
					ob.setUpLoading();
					ob.setVisible(true);
					*/
					
					
				}
				
			}
		});
		btnKaydol.setBackground(Color.RED);
		btnKaydol.setForeground(Color.WHITE);
		btnKaydol.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(btnKaydol);
		
		
		
		
	}
}
