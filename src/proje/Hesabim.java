package proje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javax.swing.JTextField;

public class Hesabim extends JFrame {

	private JPanel contentPane;
	static String eposta;
	private JTextField txtHesabm;
	private JTextField kullanici_adi;
	private JTextField e_posta;
	private JTextField sifre;
	private JTextField dogum_tarihi;

	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	Statement st;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hesabim frame = new Hesabim(eposta);
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
	public Hesabim(String eposta) {

		// veritabanýna baðlantý iþlemleri

		// "jdbc:mysql://localhost:3306/netflix
		String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_name
				+ "?useUnicode=true&characterEncoding=utf8";

		try {

			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException ex) {

			System.out.println("Driver Bulunamadý....");

		}

		try {

			conn = (Connection) DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);
			System.out.println("Baðlantý Baþarýlý...");

		} catch (SQLException ex) {

			System.out.println("Baðlantý Baþarýsýz...");

		}

		System.out.println(eposta);

		setTitle("HESABIM");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 20, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("NETFL\u0130X");
		label.setBounds(52, 40, 134, 52);
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD, 28));
		contentPane.add(label);

		JButton btnNewButton = new JButton("Ana Sayfa");

		btnNewButton.setBorder(null);
		btnNewButton.setFocusPainted(false);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				setVisible(false);
				new KullaniciYonetimSayfasi(eposta).setVisible(true);
			}
		});

		// Menü Kýsmý
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(null);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(900, 40, 52, 52);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setBorder(null);
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		Image img11 = new ImageIcon(this.getClass().getResource("/hesap.png")).getImage();
		mnNewMenu.setIcon(new ImageIcon(img11));
		menuBar.add(mnNewMenu);

		JMenuItem mnýtmHesapBilgilerim = new JMenuItem("Hesap Bilgilerim");
		mnýtmHesapBilgilerim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Hesabim(eposta).setVisible(true);
			}
		});
		Image img12 = new ImageIcon(this.getClass().getResource("/hesap1.png")).getImage();
		mnýtmHesapBilgilerim.setIcon(new ImageIcon(img12));
		mnýtmHesapBilgilerim.setFont(new Font("Arial Black", Font.PLAIN, 12));
		mnNewMenu.add(mnýtmHesapBilgilerim);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.RED);
		mnNewMenu.add(separator);

		JMenuItem mnýtmOturumuKapat = new JMenuItem("Oturumu Kapat");
		Image img13 = new ImageIcon(this.getClass().getResource("/hesap2.png")).getImage();
		mnýtmOturumuKapat.setIcon(new ImageIcon(img13));
		mnýtmOturumuKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Frame frame = new Frame();

				if (JOptionPane.showConfirmDialog(frame, "Oturumu Kapatmak Ýstiyor Musunuz?", "Oturumu Kapat",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {

					// System.exit(0);
					setVisible(false);
					new Login().setVisible(true);

				}

			}
		});
		mnýtmOturumuKapat.setFont(new Font("Arial Black", Font.PLAIN, 12));
		mnNewMenu.add(mnýtmOturumuKapat);
		btnNewButton.setBounds(223, 50, 124, 42);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(btnNewButton);

		JButton btnDiziler = new JButton("Diziler");
		btnDiziler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				new Diziler(eposta).setVisible(true);

			}
		});
		btnDiziler.setForeground(Color.WHITE);
		btnDiziler.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDiziler.setFocusPainted(false);
		btnDiziler.setBorder(null);
		btnDiziler.setBackground(Color.BLACK);
		btnDiziler.setBounds(349, 50, 134, 42);
		contentPane.add(btnDiziler);

		JButton btnFilmler = new JButton("Filmler");
		btnFilmler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				new Filmler(eposta).setVisible(true);

			}
		});
		btnFilmler.setForeground(Color.WHITE);
		btnFilmler.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFilmler.setFocusPainted(false);
		btnFilmler.setBorder(null);
		btnFilmler.setBackground(Color.BLACK);
		btnFilmler.setBounds(484, 50, 134, 42);
		contentPane.add(btnFilmler);
		Image img10 = new ImageIcon(this.getClass().getResource("/avatar.png")).getImage();

		JButton btnListem = new JButton("Listem");
		btnListem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new Listem(eposta).setVisible(true);
			}
		});
		btnListem.setForeground(Color.WHITE);
		btnListem.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnListem.setFocusPainted(false);
		btnListem.setBorder(null);
		btnListem.setBackground(Color.BLACK);
		btnListem.setBounds(623, 50, 134, 42);
		contentPane.add(btnListem);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.RED));
		panel.setBackground(Color.BLACK);
		panel.setBounds(52, 140, 883, 471);
		contentPane.add(panel);
		panel.setLayout(null);

		txtHesabm = new JTextField();
		txtHesabm.setEditable(false);
		txtHesabm.setText("HESABIM");
		txtHesabm.setBorder(null);
		txtHesabm.setFont(new Font("Arial Black", Font.PLAIN, 24));
		txtHesabm.setForeground(Color.WHITE);
		txtHesabm.setBackground(Color.BLACK);
		txtHesabm.setHorizontalAlignment(SwingConstants.CENTER);
		txtHesabm.setBounds(243, 31, 401, 37);
		panel.add(txtHesabm);
		txtHesabm.setColumns(10);

		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblKullancAd.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblKullancAd.setForeground(Color.WHITE);
		lblKullancAd.setBackground(Color.BLACK);
		lblKullancAd.setBounds(240, 111, 140, 36);
		panel.add(lblKullancAd);

		JLabel lblEposta = new JLabel("E-Posta");
		lblEposta.setForeground(Color.WHITE);
		lblEposta.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblEposta.setBackground(Color.BLACK);
		lblEposta.setBounds(240, 166, 140, 36);
		panel.add(lblEposta);

		JLabel lblifre = new JLabel("\u015Eifre");
		lblifre.setForeground(Color.WHITE);
		lblifre.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblifre.setBackground(Color.BLACK);
		lblifre.setBounds(240, 222, 140, 36);
		panel.add(lblifre);

		JLabel lblDoumTarihi = new JLabel("Do\u011Fum Tarihi");
		lblDoumTarihi.setForeground(Color.WHITE);
		lblDoumTarihi.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblDoumTarihi.setBackground(Color.BLACK);
		lblDoumTarihi.setBounds(240, 283, 140, 29);
		panel.add(lblDoumTarihi);

		kullanici_adi = new JTextField();
		kullanici_adi.setEditable(false);
		kullanici_adi.setHorizontalAlignment(SwingConstants.CENTER);
		kullanici_adi.setFont(new Font("Arial Black", Font.PLAIN, 18));
		kullanici_adi.setColumns(10);
		kullanici_adi.setBackground(Color.GRAY);
		kullanici_adi.setBounds(452, 111, 250, 36);
		panel.add(kullanici_adi);

		e_posta = new JTextField();
		e_posta.setEditable(false);
		e_posta.setHorizontalAlignment(SwingConstants.CENTER);
		e_posta.setFont(new Font("Arial Black", Font.PLAIN, 18));
		e_posta.setColumns(10);
		e_posta.setBackground(Color.GRAY);
		e_posta.setBounds(452, 166, 250, 36);
		panel.add(e_posta);

		sifre = new JTextField();
		sifre.setEditable(false);
		sifre.setHorizontalAlignment(SwingConstants.CENTER);
		sifre.setFont(new Font("Arial Black", Font.PLAIN, 18));
		sifre.setColumns(10);
		sifre.setBackground(Color.GRAY);
		sifre.setBounds(452, 222, 250, 36);
		panel.add(sifre);

		dogum_tarihi = new JTextField();
		dogum_tarihi.setEditable(false);
		dogum_tarihi.setHorizontalAlignment(SwingConstants.CENTER);
		dogum_tarihi.setFont(new Font("Arial Black", Font.PLAIN, 18));
		dogum_tarihi.setColumns(10);
		dogum_tarihi.setBackground(Color.GRAY);
		dogum_tarihi.setBounds(452, 276, 250, 36);
		panel.add(dogum_tarihi);

		JLabel icon = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/hesabim.png")).getImage();
		icon.setIcon(new ImageIcon(img1));
		icon.setBounds(34, 329, 153, 119);
		panel.add(icon);

		try {

			String sorgu = "SELECT ad, email, sifre, dogum_tarihi FROM `kullanici` WHERE email = ?";

			pst = (PreparedStatement) conn.clientPrepareStatement(sorgu);
			pst.setString(1, eposta);

			rs = pst.executeQuery();

			System.out.println(sorgu);

			if (rs.next()) {

				String add1 = rs.getString("ad");
				kullanici_adi.setText(add1);

				String add2 = rs.getString("email");
				e_posta.setText(add2);

				String add3 = rs.getString("sifre");
				sifre.setText(add3);

				String add4 = rs.getString("dogum_tarihi");
				dogum_tarihi.setText(add4);

			} else {

				JOptionPane.showMessageDialog(null, "Hesap Bilgisi Yok");

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}
}
