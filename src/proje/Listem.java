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
import java.awt.event.MouseAdapter;
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

import proje.TavsiyeEkrani.LabelRenderer;

public class Listem extends JFrame {

	private JPanel contentPane;
	DefaultTableModel model;
	Connection conn;
	PreparedStatement pst;
	Statement st;

	// veritabaný iþlemleri gerçekleþtireceðimiz için KullaniciIslemleri sýnýfýndan
	// obje oluþturuyoruz

	Programlar programlar = new Programlar();

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
					Listem frame = new Listem(eposta);
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
	public Listem(String eposta) {
		this.eposta = eposta;

		System.out.println("Listem");
		System.out.println(eposta);

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

		setTitle("LÝSTEM");
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
		hesabim.setBounds(900, 40, 52, 52);
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
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.RED));
		panel.setBackground(Color.BLACK);
		panel.setBounds(52, 140, 883, 501);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 863, 479);
		panel.add(scrollPane);

		program_table = new JTable();
		program_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {

				String dewamke = model.getValueAt(program_table.getSelectedRow(), 0).toString();

				String progID = programIdGetir(dewamke);
				System.out.println("Program ýd = " + progID);
				System.out.println("Eposta = " + eposta);

				setVisible(false);
				new IzlemeEkrani2(progID, eposta).setVisible(true);

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
				new String[] { "ADI", "ÝZLEME TARÝHÝ", "ÝZLEME SÜRESÝ", "BÖLÜM", "PUANINIZ", "AFÝÞ" }));
		program_table.getColumnModel().getColumn(0).setPreferredWidth(240);
		program_table.getColumnModel().getColumn(1).setPreferredWidth(95);
		program_table.getColumnModel().getColumn(2).setPreferredWidth(95);
		program_table.getColumnModel().getColumn(3).setPreferredWidth(35);
		program_table.getColumnModel().getColumn(4).setPreferredWidth(35);
		program_table.getColumnModel().getColumn(5).setPreferredWidth(120);
		program_table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalTextPosition(DefaultTableCellRenderer.CENTER);

		program_table.getColumn("AFÝÞ").setCellRenderer(new LabelRenderer());

		program_table.setForeground(SystemColor.window);
		program_table.setBorder(new LineBorder(Color.RED, 2));
		program_table.setBackground(SystemColor.activeCaptionText);

		model = (DefaultTableModel) program_table.getModel();
		listemiGoruntule();

	}

	class LabelRenderer implements TableCellRenderer {

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {

			javax.swing.table.TableColumn tc = table.getColumn("AFÝÞ");
			tc.setMinWidth(100);
			return (Component) value;

		}

	}

	// epostasýný bildiðimiz kullanýcýnýn id'sini getiriyoruz
	public String kullaniciIdGetir(String eposta) {

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

	public void listemiGoruntule() {

		model.setRowCount(0);

		ArrayList<Program> prog = new ArrayList<Program>();

		// System.out.println(eposta);

		String id = kullaniciIdGetir(eposta);
		System.out.println(id);

		prog = programlar.listemdekileriGetir(id);

		if (prog != null) {

			// kitaplar tablosuna deðerler ekleme

			for (Program ekle : prog) {

				// Programlarýn resimlerini ekleme kýsmý

				JLabel imageLabel = new JLabel();

				String path = ekle.getImg();

				ImageIcon imageicon = new ImageIcon("img" + path);
				// ImageIcon imageicon = new ImageIcon("img/harry_olum.jpg");
				Image image = imageicon.getImage();
				imageLabel.setIcon(imageicon);

				String izleme_tarihi = "  " + ekle.getIzleme_tarihi();
				String ad = ekle.getAd();
				String izleme_suresi = "  " + ekle.getIzleme_suresi() + " dk";
				String bolum = "      " + ekle.getBolum();
				String puan = "    " + ekle.getPuan();

				Object[] eklenecek = { ad, izleme_tarihi, izleme_suresi, bolum, puan, imageLabel };

				model.addRow(eklenecek);

			}

		}

	}

}
