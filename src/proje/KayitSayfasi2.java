package proje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;

public class KayitSayfasi2 extends JFrame {

	KullaniciIslemleri k_islemler = new KullaniciIslemleri();

	private Connection con = null;

	private Statement statement = null;
	private PreparedStatement preparedStatement = null;

	private JPanel contentPane;
	private JTextField txt_tur1;
	private JTextField txt_tur2;
	private JTextField txt_tur3;
	static String eposta;
	static String parola;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KayitSayfasi2 frame = new KayitSayfasi2(eposta, parola);
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
	public KayitSayfasi2(String eposta, String parola) {

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

			con = (Connection) DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);
			System.out.println("Baðlantý Baþarýlý...");

		} catch (SQLException ex) {

			System.out.println("Baðlantý Baþarýsýz...");

		}

		System.out.println(eposta);
		System.out.println(parola);

		setTitle("Kayýt Sayfasý");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 20, 1000, 700);
		contentPane = new JPanel();
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextField ad_3 = new JTextField();
		ad_3.setBounds(457, 245, 225, 36);
		ad_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		ad_3.setHorizontalAlignment(SwingConstants.CENTER);
		ad_3.setBackground(Color.GRAY);
		contentPane.add(ad_3);
		ad_3.setColumns(10);

		JLabel lblNetflix = new JLabel("NETFL\u0130X");
		lblNetflix.setBounds(21, 28, 169, 52);
		lblNetflix.setHorizontalAlignment(SwingConstants.CENTER);
		lblNetflix.setForeground(new Color(255, 0, 0));
		lblNetflix.setFont(new Font("Tahoma", Font.BOLD, 34));
		contentPane.add(lblNetflix);

		JLabel ad_txt_3 = new JLabel("Ad\u0131n\u0131z");
		ad_txt_3.setBounds(265, 245, 91, 36);
		ad_txt_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		ad_txt_3.setForeground(Color.WHITE);
		contentPane.add(ad_txt_3);

		JLabel text1_3 = new JLabel("Hesap Olu\u015Fturmak \u0130\u00E7in");
		text1_3.setBounds(315, 105, 376, 36);
		text1_3.setHorizontalAlignment(SwingConstants.CENTER);
		text1_3.setForeground(Color.WHITE);
		text1_3.setFont(new Font("Tahoma", Font.BOLD, 28));
		text1_3.setBackground(Color.BLACK);
		contentPane.add(text1_3);

		JButton button = new JButton("Oturum A\u00E7");
		button.setBounds(844, 45, 140, 30);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				setVisible(false);
				new Login().setVisible(true);

			}
		});

		JLabel text2_3 = new JLabel("L\u00FCtfen Bilgilerinizi Giriniz");
		text2_3.setBounds(315, 152, 376, 36);
		text2_3.setHorizontalAlignment(SwingConstants.CENTER);
		text2_3.setForeground(Color.WHITE);
		text2_3.setFont(new Font("Tahoma", Font.BOLD, 28));
		text2_3.setBackground(Color.BLACK);
		contentPane.add(text2_3);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setFocusPainted(false);
		button.setBorder(null);
		button.setBackground(Color.RED);
		contentPane.add(button);

		JLabel tarih_txt_3 = new JLabel("Do\u011Fum Tarihi");
		tarih_txt_3.setBounds(265, 305, 169, 36);
		tarih_txt_3.setForeground(Color.WHITE);
		tarih_txt_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(tarih_txt_3);

		JDateChooser tarih_3 = new JDateChooser();
		tarih_3.setDateFormatString("d-MM-yyyy");
		tarih_3.setBounds(457, 305, 225, 36);
		tarih_3.getCalendarButton().setBackground(Color.GRAY);
		tarih_3.setForeground(Color.GRAY);
		tarih_3.setBackground(Color.GRAY);
		tarih_3.setDateFormatString("d-MM-yyyy");
		JTextFieldDateEditor editor = (JTextFieldDateEditor) tarih_3.getDateEditor();
		editor.setEditable(false);
		this.getContentPane().add(tarih_3);
		this.repaint();
		contentPane.add(tarih_3);

		JButton btnKaydol_3 = new JButton("KAYDI TAMAMLA");
		btnKaydol_3.setBounds(395, 555, 214, 36);
		btnKaydol_3.setBorder(null);
		btnKaydol_3.setFocusPainted(false);
		btnKaydol_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				String kullanici_ad = ad_3.getText();
				String email = eposta;
				String sifre = parola;
				java.sql.Date dogum_tarihi = new java.sql.Date(tarih_3.getDate().getTime());

				System.out.println("**********************************");
				System.out.println(kullanici_ad);
				System.out.println(email);
				System.out.println(sifre);
				System.out.println(dogum_tarihi);

				boolean kayit = k_islemler.kullaniciKayit(kullanici_ad, email, sifre, dogum_tarihi);

				if (kayit) {

					setVisible(false);

					JOptionPane.showMessageDialog(null, "KAYIT ÝÞLEMÝ BAÞARIYLA GERÇEKLEÞTÝ.");

					// setVisible(false);
					// new Login().setVisible(true);

					String tur1 = turNumarasiGetir(txt_tur1.getText());
					String tur2 = turNumarasiGetir(txt_tur2.getText());
					String tur3 = turNumarasiGetir(txt_tur3.getText());
					/*
					System.out.println("******************************************");
					System.out.println(tur1);
					System.out.println(tur2);
					System.out.println(tur3);
					*/

					setVisible(false);
					new TavsiyeEkrani(eposta, tur1, tur2, tur3).setVisible(true);

				} else {

					JOptionPane.showMessageDialog(null, "KAYIT ÝÞLEMÝ BAÞARISIZ OLDU...\nLÜTFEN TEKRAR DENEYÝNÝZ...");

				}

			}
		});
		btnKaydol_3.setBackground(Color.RED);
		btnKaydol_3.setForeground(Color.WHITE);
		btnKaydol_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(btnKaydol_3);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(null);
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(262, 365, 150, 36);
		contentPane.add(menuBar);

		JMenu mnSec = new JMenu("T\u00FCr 1");
		mnSec.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/arama.png")).getImage();
		mnSec.setIcon(new ImageIcon(img));
		mnSec.setForeground(Color.WHITE);
		mnSec.setFont(new Font("Tahoma", Font.BOLD, 20));
		menuBar.add(mnSec);

		JMenuItem mnýtmAksiyon = new JMenuItem("Aksiyon ve Macera");
		mnýtmAksiyon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String aksiyon = mnýtmAksiyon.getText();
				txt_tur1.setText(aksiyon);

			}
		});
		mnSec.add(mnýtmAksiyon);

		JSeparator separator = new JSeparator();
		mnSec.add(separator);

		JMenuItem mnýtmAnime = new JMenuItem("Anime");
		mnýtmAnime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String anime = mnýtmAnime.getText();
				txt_tur1.setText(anime);
			}
		});
		mnSec.add(mnýtmAnime);

		JSeparator separator_1 = new JSeparator();
		mnSec.add(separator_1);

		JMenuItem mnýtmBelgesel = new JMenuItem("Belgesel");
		mnýtmBelgesel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String belgesel = mnýtmBelgesel.getText();
				txt_tur1.setText(belgesel);
			}
		});
		mnSec.add(mnýtmBelgesel);

		JSeparator separator_2 = new JSeparator();
		mnSec.add(separator_2);

		JMenuItem mnýtmBilimKurguVe = new JMenuItem("Bilim Kurgu ve Fantastik");
		mnýtmBilimKurguVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bilim = mnýtmBilimKurguVe.getText();
				txt_tur1.setText(bilim);
			}
		});
		mnSec.add(mnýtmBilimKurguVe);

		JSeparator separator_3 = new JSeparator();
		mnSec.add(separator_3);

		JMenuItem mnýtmBilimVeDoa = new JMenuItem("Bilim ve Do\u011Fa");
		mnýtmBilimVeDoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bilimD = mnýtmBilimVeDoa.getText();
				txt_tur1.setText(bilimD);
			}
		});
		mnSec.add(mnýtmBilimVeDoa);

		JSeparator separator_4 = new JSeparator();
		mnSec.add(separator_4);

		JMenuItem mnýtmocukVeAile = new JMenuItem("\u00C7ocuk ve Aile");
		mnýtmocukVeAile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cocuk = mnýtmocukVeAile.getText();
				txt_tur1.setText(cocuk);
			}
		});
		mnSec.add(mnýtmocukVeAile);

		JSeparator separator_5 = new JSeparator();
		mnSec.add(separator_5);

		JMenuItem mnýtmDrama = new JMenuItem("Drama");
		mnýtmDrama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String drama = mnýtmDrama.getText();
				txt_tur1.setText(drama);
			}
		});
		mnSec.add(mnýtmDrama);

		JSeparator separator_6 = new JSeparator();
		mnSec.add(separator_6);

		JMenuItem mnýtmGerilim = new JMenuItem("Gerilim");
		mnýtmGerilim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gerilim = mnýtmGerilim.getText();
				txt_tur1.setText(gerilim);
			}
		});
		mnSec.add(mnýtmGerilim);

		JSeparator separator_7 = new JSeparator();
		mnSec.add(separator_7);

		JMenuItem mnýtmKomedi = new JMenuItem("Komedi");
		mnýtmKomedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String komedi = mnýtmKomedi.getText();
				txt_tur1.setText(komedi);
			}
		});
		mnSec.add(mnýtmKomedi);

		JSeparator separator_8 = new JSeparator();
		mnSec.add(separator_8);

		JMenuItem mnýtmKorku = new JMenuItem("Korku");
		mnýtmKorku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String korku = mnýtmKorku.getText();
				txt_tur1.setText(korku);
			}
		});
		mnSec.add(mnýtmKorku);

		JSeparator separator_9 = new JSeparator();
		mnSec.add(separator_9);

		JMenuItem mnýtmRealityProgram = new JMenuItem("Reality Program");
		mnýtmRealityProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String reality = mnýtmRealityProgram.getText();
				txt_tur1.setText(reality);
			}
		});
		mnSec.add(mnýtmRealityProgram);

		JSeparator separator_10 = new JSeparator();
		mnSec.add(separator_10);

		JMenuItem mnýtmRomantizm = new JMenuItem("Romantizm");
		mnýtmRomantizm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String romantizm = mnýtmRomantizm.getText();
				txt_tur1.setText(romantizm);
			}
		});
		mnSec.add(mnýtmRomantizm);

		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setForeground(Color.WHITE);
		menuBar_1.setBorder(null);
		menuBar_1.setBackground(Color.BLACK);
		menuBar_1.setBounds(262, 420, 150, 36);
		contentPane.add(menuBar_1);

		JMenu mnTr = new JMenu("T\u00FCr 2");
		mnTr.setIcon(new ImageIcon(img));
		mnTr.setHorizontalAlignment(SwingConstants.CENTER);
		mnTr.setForeground(Color.WHITE);
		mnTr.setFont(new Font("Tahoma", Font.BOLD, 20));
		menuBar_1.add(mnTr);

		JMenuItem menuItem = new JMenuItem("Aksiyon ve Macera");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aksiyon = menuItem.getText();
				txt_tur2.setText(aksiyon);
			}
		});
		mnTr.add(menuItem);

		JSeparator separator_11 = new JSeparator();
		mnTr.add(separator_11);

		JMenuItem menuItem_1 = new JMenuItem("Anime");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String anime = menuItem_1.getText();
				txt_tur2.setText(anime);
			}
		});
		mnTr.add(menuItem_1);

		JSeparator separator_12 = new JSeparator();
		mnTr.add(separator_12);

		JMenuItem menuItem_2 = new JMenuItem("Belgesel");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String belgesel = menuItem_2.getText();
				txt_tur2.setText(belgesel);
			}
		});
		mnTr.add(menuItem_2);

		JSeparator separator_13 = new JSeparator();
		mnTr.add(separator_13);

		JMenuItem menuItem_3 = new JMenuItem("Bilim Kurgu ve Fantastik");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bilim = menuItem_3.getText();
				txt_tur2.setText(bilim);
			}
		});
		mnTr.add(menuItem_3);

		JSeparator separator_14 = new JSeparator();
		mnTr.add(separator_14);

		JMenuItem menuItem_4 = new JMenuItem("Bilim ve Do\u011Fa");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String doga = menuItem_4.getText();
				txt_tur2.setText(doga);
			}
		});
		mnTr.add(menuItem_4);

		JSeparator separator_15 = new JSeparator();
		mnTr.add(separator_15);

		JMenuItem menuItem_5 = new JMenuItem("\u00C7ocuk ve Aile");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cocuk = menuItem_5.getText();
				txt_tur2.setText(cocuk);
			}
		});
		mnTr.add(menuItem_5);

		JSeparator separator_16 = new JSeparator();
		mnTr.add(separator_16);

		JMenuItem menuItem_6 = new JMenuItem("Drama");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String drama = menuItem_6.getText();
				txt_tur2.setText(drama);
			}
		});
		mnTr.add(menuItem_6);

		JSeparator separator_17 = new JSeparator();
		mnTr.add(separator_17);

		JMenuItem menuItem_7 = new JMenuItem("Gerilim");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gerilim = menuItem_7.getText();
				txt_tur2.setText(gerilim);
			}
		});
		mnTr.add(menuItem_7);

		JSeparator separator_18 = new JSeparator();
		mnTr.add(separator_18);

		JMenuItem menuItem_8 = new JMenuItem("Komedi");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String komedi = menuItem_8.getText();
				txt_tur2.setText(komedi);
			}
		});
		mnTr.add(menuItem_8);

		JSeparator separator_19 = new JSeparator();
		mnTr.add(separator_19);

		JMenuItem menuItem_9 = new JMenuItem("Korku");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String korku = menuItem_9.getText();
				txt_tur2.setText(korku);
			}
		});
		mnTr.add(menuItem_9);

		JSeparator separator_20 = new JSeparator();
		mnTr.add(separator_20);

		JMenuItem menuItem_10 = new JMenuItem("Reality Program");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String reality = menuItem_10.getText();
				txt_tur2.setText(reality);
			}
		});
		mnTr.add(menuItem_10);

		JSeparator separator_21 = new JSeparator();
		mnTr.add(separator_21);

		JMenuItem menuItem_11 = new JMenuItem("Romantizm");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String romantizm = menuItem_11.getText();
				txt_tur2.setText(romantizm);
			}
		});
		mnTr.add(menuItem_11);

		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setForeground(Color.WHITE);
		menuBar_2.setBorder(null);
		menuBar_2.setBackground(Color.BLACK);
		menuBar_2.setBounds(262, 469, 150, 36);
		contentPane.add(menuBar_2);

		JMenu mnTr_1 = new JMenu("T\u00FCr 3");
		mnTr_1.setIcon(new ImageIcon(img));
		mnTr_1.setHorizontalAlignment(SwingConstants.CENTER);
		mnTr_1.setForeground(Color.WHITE);
		mnTr_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		menuBar_2.add(mnTr_1);

		JMenuItem menuItem_12 = new JMenuItem("Aksiyon ve Macera");
		menuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aksiyon = menuItem_12.getText();
				txt_tur3.setText(aksiyon);
			}
		});
		mnTr_1.add(menuItem_12);

		JSeparator separator_22 = new JSeparator();
		mnTr_1.add(separator_22);

		JMenuItem menuItem_13 = new JMenuItem("Anime");
		menuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String anime = menuItem_13.getText();
				txt_tur3.setText(anime);
			}
		});
		mnTr_1.add(menuItem_13);

		JSeparator separator_23 = new JSeparator();
		mnTr_1.add(separator_23);

		JMenuItem menuItem_14 = new JMenuItem("Belgesel");
		menuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String belgesel = menuItem_14.getText();
				txt_tur3.setText(belgesel);
			}
		});
		mnTr_1.add(menuItem_14);

		JSeparator separator_24 = new JSeparator();
		mnTr_1.add(separator_24);

		JMenuItem menuItem_15 = new JMenuItem("Bilim Kurgu ve Fantastik");
		menuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bilim = menuItem_15.getText();
				txt_tur3.setText(bilim);
			}
		});
		mnTr_1.add(menuItem_15);

		JSeparator separator_25 = new JSeparator();
		mnTr_1.add(separator_25);

		JMenuItem menuItem_16 = new JMenuItem("Bilim ve Do\u011Fa");
		menuItem_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String doga = menuItem_16.getText();
				txt_tur3.setText(doga);
			}
		});
		mnTr_1.add(menuItem_16);

		JSeparator separator_26 = new JSeparator();
		mnTr_1.add(separator_26);

		JMenuItem menuItem_17 = new JMenuItem("\u00C7ocuk ve Aile");
		menuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cocuk = menuItem_17.getText();
				txt_tur3.setText(cocuk);
			}
		});
		mnTr_1.add(menuItem_17);

		JSeparator separator_27 = new JSeparator();
		mnTr_1.add(separator_27);

		JMenuItem menuItem_18 = new JMenuItem("Drama");
		menuItem_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String drama = menuItem_18.getText();
				txt_tur3.setText(drama);
			}
		});
		mnTr_1.add(menuItem_18);

		JSeparator separator_28 = new JSeparator();
		mnTr_1.add(separator_28);

		JMenuItem menuItem_19 = new JMenuItem("Gerilim");
		menuItem_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gerilim = menuItem_19.getText();
				txt_tur3.setText(gerilim);
			}
		});
		mnTr_1.add(menuItem_19);

		JSeparator separator_29 = new JSeparator();
		mnTr_1.add(separator_29);

		JMenuItem menuItem_20 = new JMenuItem("Komedi");
		menuItem_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String komedi = menuItem_20.getText();
				txt_tur3.setText(komedi);
			}
		});
		mnTr_1.add(menuItem_20);

		JSeparator separator_30 = new JSeparator();
		mnTr_1.add(separator_30);

		JMenuItem menuItem_21 = new JMenuItem("Korku");
		menuItem_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String korku = menuItem_21.getText();
				txt_tur3.setText(korku);
			}
		});
		mnTr_1.add(menuItem_21);

		JSeparator separator_31 = new JSeparator();
		mnTr_1.add(separator_31);

		JMenuItem menuItem_22 = new JMenuItem("Reality Program");
		menuItem_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String reality = menuItem_22.getText();
				txt_tur3.setText(reality);
			}
		});
		mnTr_1.add(menuItem_22);

		JSeparator separator_32 = new JSeparator();
		mnTr_1.add(separator_32);

		JMenuItem menuItem_23 = new JMenuItem("Romantizm");
		menuItem_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String romantizm = menuItem_23.getText();
				txt_tur3.setText(romantizm);
			}
		});
		mnTr_1.add(menuItem_23);

		txt_tur1 = new JTextField();
		txt_tur1.setEditable(false);
		txt_tur1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_tur1.setFont(new Font("Tahoma", Font.BOLD, 16));
		txt_tur1.setColumns(10);
		txt_tur1.setBackground(Color.GRAY);
		txt_tur1.setBounds(457, 365, 225, 36);
		contentPane.add(txt_tur1);

		txt_tur2 = new JTextField();
		txt_tur2.setEditable(false);
		txt_tur2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_tur2.setFont(new Font("Tahoma", Font.BOLD, 16));
		txt_tur2.setColumns(10);
		txt_tur2.setBackground(Color.GRAY);
		txt_tur2.setBounds(457, 420, 225, 36);
		contentPane.add(txt_tur2);

		txt_tur3 = new JTextField();
		txt_tur3.setEditable(false);
		txt_tur3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_tur3.setFont(new Font("Tahoma", Font.BOLD, 16));
		txt_tur3.setColumns(10);
		txt_tur3.setBackground(Color.GRAY);
		txt_tur3.setBounds(457, 469, 225, 36);
		contentPane.add(txt_tur3);

		/*
		 * JLabel arkaplan = new JLabel("");
		 * 
		 * Image img = new
		 * ImageIcon(this.getClass().getResource("/kaydol.jpg")).getImage();
		 * arkaplan.setIcon(new ImageIcon(img));
		 * 
		 * arkaplan.setBounds(149, 430, 994, 230); contentPane.add(arkaplan);
		 */

	}

	public String turNumarasiGetir(String tur) {

		// SELECT turID FROM `turler` WHERE name = "Aksiyon ve Macera"

		String id = null;

		try {

			statement = (Statement) con.createStatement();
			String sorgu = "SELECT turID FROM `turler`  where name = \"" +  tur + "\"";
			System.out.println(sorgu);

			ResultSet rs = statement.executeQuery(sorgu);

			while (rs.next()) {

				id = rs.getString("turID");
				return id;

			}

			return id;

		} catch (Exception e) {
			return null;
		}

	}
}
