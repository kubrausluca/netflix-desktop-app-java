package proje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class IzlemeEkrani extends JFrame {

	KullaniciIslemleri k_islemler = new KullaniciIslemleri();

	Connection conn;
	ResultSet rs;
	ResultSet rs2;
	PreparedStatement pst;
	Statement st;

	IzlemeEkrani frame;
	private JPanel contentPane;
	private JTextField title;
	private JTextField tip;
	private JTextField tur1;
	private JTextField imdb;
	private JTextField tur2;
	private JTextField tur3;
	private JTextField txtImdb;
	private JTextArea aciklama;
	private JButton btnDurdur;
	private static Timer timer;
	private static int count = 0;
	private static int ns = 0, sec1 = 0, min1 = 0;
	private String toplamSure;
	private String bolum_say;

	private JLabel dakika;
	private JLabel saniye;
	private JLabel salise;

	public static String programID;
	static String eposta;
	private String kullaniciPuani = null;
	private String izlenen_bolum = "1";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzlemeEkrani frame = new IzlemeEkrani(programID, eposta);
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
	public IzlemeEkrani(String string, String eposta) {

		ns = 0;
		sec1 = 0;
		min1 = 0;

		this.programID = string;
		this.eposta = eposta;

		System.out.println("***********************************");
		System.out.println("Ýzleme Ekraný");
		System.out.println(programID);
		System.out.println(eposta);
		System.out.println("***********************************");

		System.out.println(programID);
		System.out.println(string);

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

		setTitle("ÝZLEME EKRANI");
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

				/*
				 * if(btnDurdur.isSelected()) { setVisible(false); new
				 * KullaniciYonetimSayfasi(eposta).setVisible(true); } else {
				 * JOptionPane.showMessageDialog(null, "PROGRAMI DURDURUNUZ..."); }
				 */
			}
		});
		btnNewButton.setBounds(223, 50, 124, 42);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(btnNewButton);

		// Menü Kýsmý
		JMenuBar hesabim = new JMenuBar();
		hesabim.setBorder(null);
		hesabim.setBackground(Color.BLACK);
		hesabim.setBounds(885, 40, 52, 52);
		contentPane.add(hesabim);

		JMenu menuHesabim = new JMenu("");
		menuHesabim.setBorder(null);
		menuHesabim.setHorizontalAlignment(SwingConstants.CENTER);
		Image img11 = new ImageIcon(this.getClass().getResource("/hesap.png")).getImage();
		menuHesabim.setIcon(new ImageIcon(img11));
		hesabim.add(menuHesabim);

		JMenuItem hesapBilgileri = new JMenuItem("Hesap Bilgilerim");
		hesapBilgileri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Hesabim(eposta).setVisible(true);
			}
		});
		Image img12 = new ImageIcon(this.getClass().getResource("/hesap1.png")).getImage();
		hesapBilgileri.setIcon(new ImageIcon(img12));
		hesapBilgileri.setFont(new Font("Arial Black", Font.PLAIN, 12));
		menuHesabim.add(hesapBilgileri);

		JSeparator separator1 = new JSeparator();
		separator1.setForeground(Color.RED);
		menuHesabim.add(separator1);

		JMenuItem oturumKapat = new JMenuItem("Oturumu Kapat");
		Image img13 = new ImageIcon(this.getClass().getResource("/hesap2.png")).getImage();
		oturumKapat.setIcon(new ImageIcon(img13));
		oturumKapat.addActionListener(new ActionListener() {
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
		oturumKapat.setFont(new Font("Arial Black", Font.PLAIN, 12));
		menuHesabim.add(oturumKapat);

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
		panel.setToolTipText("");
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.RED));
		panel.setBackground(SystemColor.textText);
		panel.setBounds(52, 126, 884, 486);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "AF\u0130\u015E",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_1.setBounds(114, 130, 244, 205);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel resim = new JLabel("");
		resim.setBounds(43, 18, 150, 175);
		panel_1.add(resim);
		resim.setHorizontalAlignment(SwingConstants.CENTER);

		title = new JTextField();
		title.setEditable(false);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(108, 36, 653, 65);
		title.setBackground(SystemColor.textText);
		title.setBorder(null);
		title.setFont(new Font("Freestyle Script", Font.BOLD, 54));
		title.setForeground(SystemColor.textHighlightText);
		panel.add(title);
		title.setColumns(10);

		tip = new JTextField();
		tip.setBounds(436, 130, 143, 25);
		tip.setBorder(null);
		tip.setEditable(false);
		tip.setFont(new Font("Arial Black", Font.PLAIN, 16));
		tip.setForeground(SystemColor.controlLtHighlight);
		tip.setBackground(SystemColor.textText);
		tip.setColumns(10);
		panel.add(tip);

		imdb = new JTextField();
		imdb.setBounds(770, 130, 57, 25);
		imdb.setFont(new Font("Tahoma", Font.BOLD, 16));
		imdb.setBorder(null);
		imdb.setEditable(false);
		imdb.setBackground(SystemColor.textText);
		imdb.setForeground(SystemColor.controlLtHighlight);
		imdb.setColumns(10);
		panel.add(imdb);

		tur1 = new JTextField();
		tur1.setBounds(436, 169, 190, 20);
		tur1.setBorder(null);
		tur1.setBackground(SystemColor.textText);
		tur1.setForeground(SystemColor.controlLtHighlight);
		tur1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		tur1.setEditable(false);
		tur1.setColumns(10);
		panel.add(tur1);

		tur2 = new JTextField();
		tur2.setBounds(436, 197, 190, 20);
		tur2.setBorder(null);
		tur2.setEditable(false);
		tur2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		tur2.setForeground(SystemColor.controlLtHighlight);
		tur2.setBackground(SystemColor.textText);
		tur2.setColumns(10);
		panel.add(tur2);

		tur3 = new JTextField();
		tur3.setBounds(436, 223, 190, 20);
		tur3.setBorder(null);
		tur3.setFont(new Font("Arial Black", Font.PLAIN, 14));
		tur3.setForeground(SystemColor.controlLtHighlight);
		tur3.setBackground(SystemColor.textText);
		tur3.setEditable(false);
		tur3.setColumns(10);
		panel.add(tur3);

		dakika = new JLabel("00");
		dakika.setFont(new Font("Arial Black", Font.BOLD, 15));
		dakika.setHorizontalAlignment(SwingConstants.CENTER);
		dakika.setForeground(Color.WHITE);
		dakika.setBounds(735, 11, 40, 33);
		panel.add(dakika);

		JLabel label_1 = new JLabel(":");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		label_1.setBounds(765, 11, 22, 33);
		panel.add(label_1);

		saniye = new JLabel("00");
		saniye.setHorizontalAlignment(SwingConstants.CENTER);
		saniye.setForeground(Color.WHITE);
		saniye.setFont(new Font("Arial Black", Font.BOLD, 15));
		saniye.setBounds(777, 11, 40, 33);
		panel.add(saniye);

		salise = new JLabel("00");
		salise.setHorizontalAlignment(SwingConstants.CENTER);
		salise.setForeground(Color.WHITE);
		salise.setFont(new Font("Arial Black", Font.BOLD, 15));
		salise.setBounds(822, 11, 40, 33);
		panel.add(salise);

		JButton btnBilgi = new JButton("   Listem'e Ekle");
		btnBilgi.setFocusPainted(false);
		btnBilgi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				toplamSure = dakika.getText() + ":" + saniye.getText() + ":" + salise.getText();

				System.out.println(toplamSure);

				// LocalDate izlemeTarihi = LocalDate.now();
				Date izlemeTarihi = Date.valueOf(LocalDate.now());

				System.out.println("****************");
				System.out.println("Fonksiyondan gelen id = ");
				String kullaniciID = kullaniciIdGetir(eposta);
				System.out.println("Kullanýcý id = " + kullaniciID);
				System.out.println("Program ID = " + programID);
				System.out.println("Ýzleme Tarihi = " + izlemeTarihi);
				System.out.println("Ýzleme Süresi = " + toplamSure);
				System.out.println("Ýzlediði Bölüm = " + izlenen_bolum);
				System.out.println("Kullanýcý Puaný = " + kullaniciPuani);
				System.out.println("****************");

				boolean listEkle = k_islemler.listemeEkle(kullaniciID, programID, izlemeTarihi, toplamSure,
						izlenen_bolum, kullaniciPuani);

				if (listEkle) {

					JOptionPane.showMessageDialog(null, "LÝSTEM'E EKLENDÝ");
					new Listem(eposta);

				} else {
					JOptionPane.showMessageDialog(null, "LÝSTEM'E EKLENEMEDÝ...");
				}

			}
		});
		btnBilgi.setBounds(641, 390, 164, 33);
		btnBilgi.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnBilgi.setHorizontalAlignment(SwingConstants.LEFT);
		Image img2 = new ImageIcon(this.getClass().getResource("/ekle.png")).getImage();
		btnBilgi.setIcon(new ImageIcon(img2));
		btnBilgi.setBackground(Color.GRAY);
		panel.add(btnBilgi);

		timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				ns = ns + 1;
				if (ns == 60) {

					ns = 0;
					sec1 = sec1 + 1;

				}
				if (sec1 == 60) {

					sec1 = 0;
					min1 = min1 + 1;

				}
				if (ns <= 9) {
					salise.setText("0" + ns);
				} else {
					salise.setText("" + ns);
				}
				if (sec1 <= 9) {
					saniye.setText("0" + sec1);
				} else {
					saniye.setText(sec1 + "");
				}
				if (min1 <= 9) {
					dakika.setText("0" + min1);
				} else {
					dakika.setText(min1 + "");
				}

			}
		});

		JButton btnOynat = new JButton("   Oynat");
		btnOynat.setBounds(436, 390, 121, 33);
		btnOynat.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnOynat.setHorizontalAlignment(SwingConstants.LEFT);
		Image img1 = new ImageIcon(this.getClass().getResource("/oynat.png")).getImage();
		btnOynat.setIcon(new ImageIcon(img1));
		btnOynat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// setVisible(false);
				// new Listem(eposta).setVisible(true);
				btnOynat.setVisible(false);
				btnDurdur.setVisible(true);

				timer.start();

				/*
				 * if(btnOynat.isSelected()) { timer.start(); } else { timer.stop(); }
				 */
			}
		});
		btnOynat.setBackground(SystemColor.controlLtHighlight);
		panel.add(btnOynat);

		btnDurdur = new JButton("   Durdur");
		Image img4 = new ImageIcon(this.getClass().getResource("/durdur.png")).getImage();
		btnDurdur.setIcon(new ImageIcon(img4));
		btnDurdur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnDurdur.setVisible(false);
				btnOynat.setVisible(true);
				timer.stop();

			}
		});
		btnDurdur.setHorizontalAlignment(SwingConstants.LEFT);
		btnDurdur.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnDurdur.setBackground(Color.WHITE);
		btnDurdur.setBounds(436, 390, 121, 33);
		panel.add(btnDurdur);

		txtImdb = new JTextField();
		txtImdb.setBounds(705, 130, 57, 25);
		txtImdb.setBorder(null);
		txtImdb.setForeground(SystemColor.controlLtHighlight);
		txtImdb.setBackground(SystemColor.textText);
		txtImdb.setEditable(false);
		txtImdb.setFont(new Font("Arial Black", Font.PLAIN, 14));
		txtImdb.setHorizontalAlignment(SwingConstants.CENTER);
		txtImdb.setText("IMDB");
		txtImdb.setColumns(10);
		panel.add(txtImdb);

		JScrollPane scrollPane = new JScrollPane();
		// scrollPane.setBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(436, 270, 370, 65);
		panel.add(scrollPane);

		JTextArea aciklama = new JTextArea();
		aciklama.setRows(2);
		aciklama.setFont(new Font("Arial Black", Font.PLAIN, 14));
		aciklama.setEditable(false);
		aciklama.setBackground(SystemColor.textText);
		aciklama.setForeground(SystemColor.controlLtHighlight);
		scrollPane.setViewportView(aciklama);

		JLabel verilenPuan = new JLabel("");
		verilenPuan.setBackground(Color.GRAY);
		verilenPuan.setHorizontalAlignment(SwingConstants.CENTER);
		verilenPuan.setFont(new Font("Arial Black", Font.PLAIN, 13));
		verilenPuan.setForeground(Color.WHITE);
		verilenPuan.setBounds(260, 345, 29, 33);
		panel.add(verilenPuan);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBorder(null);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(165, 345, 95, 33);
		panel.add(menuBar);

		JMenu mnNewMenu = new JMenu("Puan Ver");
		mnNewMenu.setForeground(Color.WHITE);
		mnNewMenu.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.setBackground(Color.GRAY);
		Image img3 = new ImageIcon(this.getClass().getResource("/vote.png")).getImage();
		mnNewMenu.setIcon(new ImageIcon(img3));
		menuBar.add(mnNewMenu);
		mnNewMenu.setFont(new Font("Arial Black", Font.PLAIN, 12));

		JMenuItem menuItem = new JMenuItem("1");
		menuItem.setForeground(Color.BLACK);
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				kullaniciPuani = menuItem.getText();
				verilenPuan.setText(kullaniciPuani);
			}
		});
		menuItem.setHorizontalAlignment(SwingConstants.CENTER);
		menuItem.setFont(new Font("Arial Black", Font.PLAIN, 11));
		mnNewMenu.add(menuItem);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.RED);
		mnNewMenu.add(separator);

		JMenuItem menuItem_1 = new JMenuItem("2");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kullaniciPuani = menuItem_1.getText();
				verilenPuan.setText(kullaniciPuani);
			}
		});
		menuItem_1.setHorizontalAlignment(SwingConstants.CENTER);
		menuItem_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		mnNewMenu.add(menuItem_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.RED);
		mnNewMenu.add(separator_2);

		JMenuItem menuItem_2 = new JMenuItem("3");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kullaniciPuani = menuItem_2.getText();
				verilenPuan.setText(kullaniciPuani);
			}
		});
		menuItem_2.setHorizontalAlignment(SwingConstants.CENTER);
		menuItem_2.setFont(new Font("Arial Black", Font.PLAIN, 11));
		mnNewMenu.add(menuItem_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.RED);
		mnNewMenu.add(separator_1);

		JMenuItem menuItem_3 = new JMenuItem("4");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kullaniciPuani = menuItem_3.getText();
				verilenPuan.setText(kullaniciPuani);
			}
		});
		menuItem_3.setHorizontalAlignment(SwingConstants.CENTER);
		menuItem_3.setFont(new Font("Arial Black", Font.PLAIN, 11));
		mnNewMenu.add(menuItem_3);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.RED);
		mnNewMenu.add(separator_3);

		JMenuItem menuItem_4 = new JMenuItem("5");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kullaniciPuani = menuItem_4.getText();
				verilenPuan.setText(kullaniciPuani);
			}
		});
		menuItem_4.setHorizontalAlignment(SwingConstants.CENTER);
		menuItem_4.setFont(new Font("Arial Black", Font.PLAIN, 11));
		mnNewMenu.add(menuItem_4);

		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.RED);
		mnNewMenu.add(separator_4);

		JMenuItem menuItem_5 = new JMenuItem("6");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kullaniciPuani = menuItem_5.getText();
				verilenPuan.setText(kullaniciPuani);
			}
		});
		menuItem_5.setHorizontalAlignment(SwingConstants.CENTER);
		menuItem_5.setFont(new Font("Arial Black", Font.PLAIN, 11));
		mnNewMenu.add(menuItem_5);

		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(Color.RED);
		mnNewMenu.add(separator_5);

		JMenuItem menuItem_6 = new JMenuItem("7");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kullaniciPuani = menuItem_6.getText();
				verilenPuan.setText(kullaniciPuani);
			}
		});
		menuItem_6.setHorizontalAlignment(SwingConstants.CENTER);
		menuItem_6.setFont(new Font("Arial Black", Font.PLAIN, 11));
		mnNewMenu.add(menuItem_6);

		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(Color.RED);
		mnNewMenu.add(separator_6);

		JMenuItem menuItem_7 = new JMenuItem("8");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kullaniciPuani = menuItem_7.getText();
				verilenPuan.setText(kullaniciPuani);
			}
		});
		menuItem_7.setHorizontalAlignment(SwingConstants.CENTER);
		menuItem_7.setFont(new Font("Arial Black", Font.PLAIN, 11));
		mnNewMenu.add(menuItem_7);

		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(Color.RED);
		mnNewMenu.add(separator_7);

		JMenuItem menuItem_8 = new JMenuItem("9");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kullaniciPuani = menuItem_8.getText();
				verilenPuan.setText(kullaniciPuani);
			}
		});
		menuItem_8.setHorizontalAlignment(SwingConstants.CENTER);
		menuItem_8.setFont(new Font("Arial Black", Font.PLAIN, 11));
		mnNewMenu.add(menuItem_8);

		JSeparator separator_8 = new JSeparator();
		separator_8.setForeground(Color.RED);
		mnNewMenu.add(separator_8);

		JMenuItem menuItem_9 = new JMenuItem("10");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kullaniciPuani = menuItem_9.getText();
				verilenPuan.setText(kullaniciPuani);
			}
		});
		menuItem_9.setHorizontalAlignment(SwingConstants.CENTER);
		menuItem_9.setFont(new Font("Arial Black", Font.PLAIN, 11));
		mnNewMenu.add(menuItem_9);
		Image img5 = new ImageIcon(this.getClass().getResource("/sonraki.png")).getImage();

		JLabel lblBolum = new JLabel(" B\u00F6l\u00FCm Se\u00E7");
		Image img6 = new ImageIcon(this.getClass().getResource("/kalp.png")).getImage();
		lblBolum.setIcon(new ImageIcon(img6));
		lblBolum.setForeground(Color.WHITE);
		lblBolum.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblBolum.setBounds(138, 390, 104, 33);
		panel.add(lblBolum);

		JLabel bolum_sec = new JLabel("1");
		bolum_sec.setHorizontalAlignment(SwingConstants.CENTER);
		bolum_sec.setForeground(Color.WHITE);
		bolum_sec.setFont(new Font("Arial Black", Font.PLAIN, 13));
		bolum_sec.setBounds(252, 390, 22, 33);
		panel.add(bolum_sec);

		JButton yukari = new JButton("");
		yukari.setBackground(Color.BLACK);
		yukari.setBorder(null);
		yukari.setFocusPainted(false);
		Image img7 = new ImageIcon(this.getClass().getResource("/up.png")).getImage();
		yukari.setIcon(new ImageIcon(img7));
		yukari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * String bolum = bolum_sec.getText(); int sonraki = Integer.parseInt(bolum) +
				 * 1; // System.out.println(sonraki); izlenen_bolum = bolum;
				 * 
				 * if (sonraki <= Integer.parseInt(bolum_say)) {
				 * 
				 * bolum_sec.setText(String.valueOf(sonraki)); izlenen_bolum =
				 * String.valueOf(sonraki);
				 * 
				 * }
				 */

				String bolum = bolum_sec.getText();

				int guncelPuan = Integer.parseInt(bolum) + 1;

				// System.out.println(guncelPuan);

				if (guncelPuan <= Integer.parseInt(bolum_say)) {
					bolum = String.valueOf(guncelPuan);
					izlenen_bolum = bolum;
					bolum_sec.setText(bolum);
				}

			}
		});
		yukari.setBounds(290, 390, 35, 16);
		panel.add(yukari);

		JButton asagi = new JButton("");
		asagi.setBorder(null);
		asagi.setFocusPainted(false);
		asagi.setBackground(Color.BLACK);
		Image img8 = new ImageIcon(this.getClass().getResource("/down2.png")).getImage();
		asagi.setIcon(new ImageIcon(img8));
		asagi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bolum = bolum_sec.getText();

				int guncelPuan = Integer.parseInt(bolum) - 1;

				if (guncelPuan >= 1) {

					bolum = String.valueOf(guncelPuan);
					izlenen_bolum = bolum;
					bolum_sec.setText(bolum);
				}

			}
		});
		asagi.setBounds(290, 407, 35, 16);
		panel.add(asagi);

		JLabel label_2 = new JLabel(":");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		label_2.setBounds(809, 11, 22, 33);
		panel.add(label_2);

		btnDurdur.setVisible(false);
		String sorgu = "Select * from program where programID = ? ";

		try {

			pst = (PreparedStatement) conn.clientPrepareStatement(sorgu);
			pst.setString(1, programID);
			rs = pst.executeQuery();

			if (rs.next()) {

				String add1 = rs.getString("ad");
				title.setText(add1);

				String add2 = rs.getString("tip");
				tip.setText(add2);

				String add3 = rs.getString("imdb");
				imdb.setText(add3);

				String sql = "Select * from turler where turID = ? ";
				String add4 = rs.getString("tur1");
				pst = (PreparedStatement) conn.clientPrepareStatement(sql);
				pst.setString(1, add4);
				rs2 = pst.executeQuery();
				// System.out.println(rs2);

				if (rs2.next()) {
					String add = rs2.getString("name");
					// System.out.println(add);
					tur1.setText(add);
				} else {
					tur1.setText("");
				}

				String add5 = rs.getString("tur2");
				pst = (PreparedStatement) conn.clientPrepareStatement(sql);
				pst.setString(1, add5);
				rs2 = pst.executeQuery();
				// System.out.println(rs2);

				if (rs2.next()) {
					String add = rs2.getString("name");
					// System.out.println(add);
					tur2.setText(add);
				} else {
					tur2.setText("");
				}

				String add6 = rs.getString("tur3");
				pst = (PreparedStatement) conn.clientPrepareStatement(sql);
				pst.setString(1, add6);
				rs2 = pst.executeQuery();
				// System.out.println(rs2);

				if (rs2.next()) {
					String add = rs2.getString("name");
					// System.out.println(add);
					tur3.setText(add);
				} else {
					tur3.setText("");
				}

				bolum_say = rs.getString("bolum_sayisi");

				String add7 = rs.getString("aciklama");
				aciklama.setText(add7);

				// Resim ekleme

				String add8 = rs.getString("img");
				System.out.println(add8);
				Image img = new ImageIcon(this.getClass().getResource("/" + add8)).getImage();
				resim.setIcon(new ImageIcon(img));

				rs.close();
				pst.close();

			} else {

				JOptionPane.showMessageDialog(null, "Kitap Bulunamadý");

			}

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
		} finally {
			try {
				rs.close();
				pst.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	// epostasýný bildiðimiz kullanýcýnýn id'sini getiriyoruz
	public String kullaniciIdGetir(String eposta) {

		// System.out.println("Kullanýcý id Getir");
		// System.out.println(eposta);

		// SELECT id FROM `kullanici` WHERE email = 'mustafa@gmail.com'

		String id = null;

		try {

			st = (Statement) conn.createStatement();
			String sorgu = "SELECT id FROM `kullanici`  where email = \"" + eposta + "\"";
			// System.out.println(sorgu);

			ResultSet rs = st.executeQuery(sorgu);

			while (rs.next()) {

				id = rs.getString("id");
				return id;

			}

			return id;

		} catch (Exception e) {
			return null;
		}

	}
}
