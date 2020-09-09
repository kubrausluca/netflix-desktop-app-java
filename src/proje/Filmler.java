package proje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import proje.Diziler.LabelRenderer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Filmler extends JFrame {

	DefaultTableModel model;
	Connection conn;
	PreparedStatement pst;
	Statement st;

	// veritabaný iþlemleri gerçekleþtireceðimiz için KullaniciIslemleri sýnýfýndan
	// obje oluþturuyoruz

	Programlar programlar = new Programlar();

	private JPanel contentPane;
	private JTextField textArama;
	private JTable program_table;
	static String eposta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Filmler frame = new Filmler(eposta);
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
	public Filmler(String eposta) {

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

		System.out.println("Filmler");
		System.out.println(eposta);

		setTitle("FÝLMLER");
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

		JLabel lblFilmler = new JLabel("Filmler");
		lblFilmler.setForeground(Color.WHITE);
		lblFilmler.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFilmler.setBounds(52, 122, 134, 42);
		contentPane.add(lblFilmler);

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

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(null);
		menuBar.setBackground(Color.BLACK);
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 29));
		menuBar.setBounds(185, 122, 134, 42);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("T\u00DCRLER");

		Image img = new ImageIcon(this.getClass().getResource("/down.png")).getImage();
		mnNewMenu.setIcon(new ImageIcon(img));
		// mnNewMenu.setIcon(new ImageIcon("C:\\Yazlab-2.1\\Netflix\\img\\arama.png"));

		mnNewMenu.setBorder(null);
		mnNewMenu.setForeground(Color.WHITE);
		mnNewMenu.setBackground(Color.BLACK);
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		menuBar.add(mnNewMenu);

		JMenuItem menuItem = new JMenuItem("Aksiyon ve Macera");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(menuItem.getText());
				dinamikAra_Tur("1");
			}
		});

		mnNewMenu.add(menuItem);

		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);

		JMenuItem menuItem_1 = new JMenuItem("Anime");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(menuItem_1.getText());
				dinamikAra_Tur("13");
			}
		});
		mnNewMenu.add(menuItem_1);

		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);

		JMenuItem menuItem_2 = new JMenuItem("Belgesel");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(menuItem_2.getText());
				dinamikAra_Tur("2");
			}
		});
		mnNewMenu.add(menuItem_2);

		JSeparator separator_2 = new JSeparator();
		mnNewMenu.add(separator_2);

		JMenuItem menuItem_3 = new JMenuItem("Bilim Kurgu ve Fantastik");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(menuItem_3.getText());
				dinamikAra_Tur("3");
			}
		});
		mnNewMenu.add(menuItem_3);

		JSeparator separator_3 = new JSeparator();
		mnNewMenu.add(separator_3);

		JMenuItem menuItem_4 = new JMenuItem("Bilim ve Do\u011Fa");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(menuItem_4.getText());
				dinamikAra_Tur("4");
			}
		});
		mnNewMenu.add(menuItem_4);

		JSeparator separator_4 = new JSeparator();
		mnNewMenu.add(separator_4);

		JMenuItem menuItem_5 = new JMenuItem("\u00C7ocuk ve Aile");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(menuItem_5.getText());
				dinamikAra_Tur("5");
			}
		});
		mnNewMenu.add(menuItem_5);

		JSeparator separator_5 = new JSeparator();
		mnNewMenu.add(separator_5);

		JMenuItem menuItem_6 = new JMenuItem("Drama");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(menuItem_6.getText());
				dinamikAra_Tur("6");
			}
		});
		mnNewMenu.add(menuItem_6);

		JSeparator separator_6 = new JSeparator();
		mnNewMenu.add(separator_6);

		JMenuItem menuItem_7 = new JMenuItem("Gerilim");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(menuItem_7.getText());
				dinamikAra_Tur("7");
			}
		});
		mnNewMenu.add(menuItem_7);

		JSeparator separator_7 = new JSeparator();
		mnNewMenu.add(separator_7);

		JMenuItem menuItem_8 = new JMenuItem("Komedi");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(menuItem_8.getText());
				dinamikAra_Tur("8");
			}
		});
		mnNewMenu.add(menuItem_8);

		JSeparator separator_8 = new JSeparator();
		mnNewMenu.add(separator_8);

		JMenuItem menuItem_9 = new JMenuItem("Korku");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(menuItem_9.getText());
				dinamikAra_Tur("9");
			}
		});
		mnNewMenu.add(menuItem_9);

		JSeparator separator_9 = new JSeparator();
		mnNewMenu.add(separator_9);

		JMenuItem menuItem_10 = new JMenuItem("Reality Program");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(menuItem_10.getText());
				dinamikAra_Tur("11");
			}
		});
		mnNewMenu.add(menuItem_10);

		JSeparator separator_10 = new JSeparator();
		mnNewMenu.add(separator_10);

		JMenuItem menuItem_11 = new JMenuItem("Romantizm");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(menuItem_11.getText());
				dinamikAra_Tur("10");
			}
		});
		mnNewMenu.add(menuItem_11);

		textArama = new JTextField();
		textArama.setHorizontalAlignment(SwingConstants.CENTER);
		textArama.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textArama.setForeground(Color.WHITE);
		textArama.setBackground(Color.BLACK);
		textArama.setBounds(349, 122, 248, 42);
		contentPane.add(textArama);
		textArama.setColumns(10);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(Color.BLACK);
		Image img1 = new ImageIcon(this.getClass().getResource("/arama.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img1));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setFocusPainted(false);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String ara = textArama.getText();

				dinamikAra_Ad(ara);

			}
		});
		btnNewButton_1.setBounds(596, 121, 50, 43);
		contentPane.add(btnNewButton_1);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.RED));
		panel.setBackground(Color.BLACK);
		panel.setBounds(52, 189, 883, 471);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 863, 449);
		panel.add(scrollPane);

		program_table = new JTable();
		program_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String dewamke = model.getValueAt(program_table.getSelectedRow(), 0).toString();

				String progID = programIdGetir(dewamke);
				System.out.println("Program ýd = " + progID);
				System.out.println("Eposta = " + eposta);

				setVisible(false);
				new IzlemeEkrani(progID, eposta).setVisible(true);

			}
		});
		program_table.setFont(new Font("Tahoma", Font.BOLD, 18));
		program_table.setColumnSelectionAllowed(true);
		program_table.setCellSelectionEnabled(true);

		// Tablonun satýr uzunluðunu ayarladýk
		program_table.setRowHeight(175);

		// program_table.getColumnModel().getColumn(4).setPreferredWidth(150);

		scrollPane.setViewportView(program_table);
		program_table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ADI", "SEZON", "B\u00D6L\u00DCM SAYISI", "S\u00DCRE", "\u0130MDB", "AF\u0130\u015E" }));
		program_table.getColumnModel().getColumn(0).setPreferredWidth(240);
		program_table.getColumnModel().getColumn(1).setPreferredWidth(65);
		program_table.getColumnModel().getColumn(2).setPreferredWidth(65);
		program_table.getColumnModel().getColumn(3).setPreferredWidth(65);
		program_table.getColumnModel().getColumn(4).setPreferredWidth(65);
		program_table.getColumnModel().getColumn(5).setPreferredWidth(120);
		program_table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalTextPosition(DefaultTableCellRenderer.CENTER);

		program_table.getColumn("AFÝÞ").setCellRenderer(new LabelRenderer());

		program_table.setForeground(SystemColor.window);
		program_table.setBorder(new LineBorder(Color.RED, 2));
		program_table.setBackground(SystemColor.activeCaptionText);

		model = (DefaultTableModel) program_table.getModel();
		programlariGoruntule();

	}

	class LabelRenderer implements TableCellRenderer {

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {

			javax.swing.table.TableColumn tc = table.getColumn("AFÝÞ");
			tc.setMinWidth(100);
			return (Component) value;

		}

	}

	public void programlariGoruntule() {

		model.setRowCount(0);

		ArrayList<Program> prog = new ArrayList<Program>();

		prog = programlar.programlariGetirFilm();

		if (prog != null) {

			// kitaplar tablosuna deðerler ekleme

			for (Program ekle : prog) {

				// Filmlerin resimlerini ekleme kýsmý

				JLabel imageLabel = new JLabel();

				String path = ekle.getImg();

				ImageIcon imageicon = new ImageIcon("img" + path);
				// ImageIcon imageicon = new ImageIcon("img/harry_olum.jpg");
				Image image = imageicon.getImage();
				imageLabel.setIcon(imageicon);

				// System.out.println(ekle.getImg());
				// System.out.println(ekle.getSure());

				String sure = "  " + ekle.getSure() + " dk";
				String ad = ekle.getAd();
				String sezon = "  " + ekle.getSezon() + " seri";
				String bolum = "  " + ekle.getBolum_sayisi() + " bölüm";
				String imdb = "    " + ekle.getImdb();

				Object[] eklenecek = { ad, sezon, bolum, sure, imdb, imageLabel };

				model.addRow(eklenecek);

			}

		}

	}

	public void dinamikAra_Ad(String ara) {

		model.setRowCount(0);

		ArrayList<Program> prglar = new ArrayList<Program>();

		prglar = programlar.FilmArama(ara);

		if (prglar != null) {

			// kitaplar tablosuna deðerler ekleme

			for (Program ekle : prglar) {

				// Filmlerin resimlerini ekleme kýsmý

				JLabel imageLabel = new JLabel();

				String path = ekle.getImg();

				ImageIcon imageicon = new ImageIcon("img" + path);
				// ImageIcon imageicon = new ImageIcon("img/harry_olum.jpg");
				Image image = imageicon.getImage();
				imageLabel.setIcon(imageicon);

				// System.out.println(ekle.getImg());
				// System.out.println(ekle.getSure());

				String sure = "  " + ekle.getSure() + " dk";
				String ad = ekle.getAd();
				String sezon = "  " + ekle.getSezon() + " seri";
				String bolum = "  " + ekle.getBolum_sayisi() + " bölüm";
				String imdb = "    " + ekle.getImdb();

				Object[] eklenecek = { ad, sezon, bolum, sure, imdb, imageLabel };

				model.addRow(eklenecek);

			}

		}

	}

	public void dinamikAra_Tur(String ara) {

		model.setRowCount(0);

		ArrayList<Program> prglar = new ArrayList<Program>();

		prglar = programlar.FilmArama_Tur(ara);

		if (prglar != null) {

			// kitaplar tablosuna deðerler ekleme

			for (Program ekle : prglar) {

				// Filmlerin resimlerini ekleme kýsmý

				JLabel imageLabel = new JLabel();

				String path = ekle.getImg();

				ImageIcon imageicon = new ImageIcon("img" + path);
				// ImageIcon imageicon = new ImageIcon("img/harry_olum.jpg");
				Image image = imageicon.getImage();
				imageLabel.setIcon(imageicon);

				// System.out.println(ekle.getImg());
				// System.out.println(ekle.getSure());

				String sure = "  " + ekle.getSure() + " dk";
				String ad = ekle.getAd();
				String sezon = "  " + ekle.getSezon() + " sezon";
				String bolum = "  " + ekle.getBolum_sayisi() + " bölüm";
				String imdb = "    " + ekle.getImdb();

				Object[] eklenecek = { ad, sezon, bolum, sure, imdb, imageLabel };

				model.addRow(eklenecek);

			}

		}

	}

	// adýný bildiðimiz programýn id'sini getiriyoruz
	public String programIdGetir(String programAdi) {

		String id = null;

		try {

			System.out.println("******************************************");
			st = (Statement) conn.createStatement();
			String sorgu = "SELECT programID FROM `program`  where ad = \"" + programAdi + "\"";
			System.out.println(sorgu);

			ResultSet rs = st.executeQuery(sorgu);

			while (rs.next()) {

				id = rs.getString("programID");
				return id;

			}

			return id;

		} catch (Exception e) {
			return null;
		}
	}

}
