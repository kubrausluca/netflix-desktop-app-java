package proje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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

public class TavsiyeEkrani extends JFrame {

	private JPanel contentPane;
	DefaultTableModel model;


	Programlar programlar = new Programlar();

	private JTextField textArama;
	private JTable program_table;
	static String tur1;
	static String tur2;
	static String tur3;
	static String eposta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TavsiyeEkrani frame = new TavsiyeEkrani(eposta, tur1, tur2, tur3);
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
	public TavsiyeEkrani(String eposta,  String tur1, String tur2, String tur3) {

		System.out.println("Yönetim Sayfasý");
		System.out.println(eposta);
		System.out.println(tur1);
		System.out.println(tur2);
		System.out.println(tur3);

		setTitle("TAVSÝYE EKRANI");
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

		JButton btnNewButton = new JButton("Giri\u015F Yap");
		btnNewButton.setBounds(810, 50, 124, 42);

		btnNewButton.setBorder(null);
		btnNewButton.setFocusPainted(false);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				setVisible(false);
				new KullaniciYonetimSayfasi(eposta).setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.RED));
		panel.setBackground(Color.BLACK);
		panel.setBounds(52, 120, 883, 471);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 863, 449);
		panel.add(scrollPane);

		program_table = new JTable();
		program_table.setFont(new Font("Tahoma", Font.BOLD, 18));
		program_table.setEnabled(false);
		program_table.setColumnSelectionAllowed(true);
		program_table.setCellSelectionEnabled(true);

		// Tablonun satýr uzunluðunu ayarladýk
		program_table.setRowHeight(175);

		// program_table.getColumnModel().getColumn(4).setPreferredWidth(150);

		scrollPane.setViewportView(program_table);
		program_table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "ADI", "SEZON", "B\u00D6L\u00DCM SAYISI", "S\u00DCRE", "\u0130MDB", "AFÝÞ" }));
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
		AltiTurGetir1(tur1);
		AltiTurGetir2(tur2);
		AltiTurGetir3(tur3);
		
	}

	class LabelRenderer implements TableCellRenderer {

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {

			javax.swing.table.TableColumn tc = table.getColumn("AFÝÞ");
			tc.setMinWidth(100);
			return (Component) value;

		}

	}

	public void AltiTurGetir1(String tur1) {

		model.setRowCount(0);

		ArrayList<Program> prglar = new ArrayList<Program>();

		prglar = programlar.secilenTurleriGetir1(tur1);

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
				String ad = "    " + ekle.getAd();
				String sezon = "  " + ekle.getSezon() + " sezon";
				String bolum = "  " + ekle.getBolum_sayisi() + " bölüm";
				String imdb = "    " + ekle.getImdb();

				Object[] eklenecek = { ad, sezon, bolum, sure, imdb, imageLabel };

				model.addRow(eklenecek);

			}

		}

	}

	public void AltiTurGetir2(String tur2) {

		model.setRowCount(2);

		ArrayList<Program> prglar = new ArrayList<Program>();

		prglar = programlar.secilenTurleriGetir2(tur2);

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
				String ad = "    " + ekle.getAd();
				String sezon = "  " + ekle.getSezon() + " sezon";
				String bolum = "  " + ekle.getBolum_sayisi() + " bölüm";
				String imdb = "    " + ekle.getImdb();

				Object[] eklenecek = { ad, sezon, bolum, sure, imdb, imageLabel };

				model.addRow(eklenecek);

			}

		}

	}

	public void AltiTurGetir3(String tur3) {

		model.setRowCount(4);

		ArrayList<Program> prglar = new ArrayList<Program>();

		prglar = programlar.secilenTurleriGetir3(tur3);

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
				String ad = "    " + ekle.getAd();
				String sezon = "  " + ekle.getSezon() + " sezon";
				String bolum = "  " + ekle.getBolum_sayisi() + " bölüm";
				String imdb = "    " + ekle.getImdb();

				Object[] eklenecek = { ad, sezon, bolum, sure, imdb, imageLabel };

				model.addRow(eklenecek);

			}

		}

	}

	

}
