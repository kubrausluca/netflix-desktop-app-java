package proje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class KullaniciYonetimSayfasi extends JFrame {

	private JPanel contentPane;
	static String eposta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KullaniciYonetimSayfasi frame = new KullaniciYonetimSayfasi(eposta);
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
	public KullaniciYonetimSayfasi(String eposta) {
		
		this.eposta = eposta;
		
		System.out.println("Kullanýcý Yönetim Sayfasý");
		System.out.println(eposta);
		
		setTitle("KULLANICI YÖNETÝM SAYFASI");
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

		/////////////////////////////////////////////////////////

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBounds(52, 114, 902, 546);
		contentPane.add(tabbedPane);

		// 1. Sayfa Baþlangýcý

		JPanel sayfa1 = new JPanel();
		sayfa1.setForeground(Color.BLACK);
		sayfa1.setBackground(Color.BLACK);
		tabbedPane.addTab("        1. Sayfa       ", null, sayfa1, null);
		sayfa1.setLayout(null);

		JPanel panel_0 = new JPanel();
		panel_0.setLayout(null);
		panel_0.setToolTipText("");
		panel_0.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_0.setBackground(Color.BLACK);
		panel_0.setBounds(10, 33, 170, 200);
		sayfa1.add(panel_0);

		JButton button0 = new JButton("");
		Image img = new ImageIcon(this.getClass().getResource("/recep.jpg")).getImage();
		button0.setIcon(new ImageIcon(img));
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/*
				 * IzlemeEkrani izle = new IzlemeEkrani(); izle.programID = "1";
				 */
				setVisible(false);
				new IzlemeEkrani("1", eposta).setVisible(true);

			}
		});
		button0.setBounds(10, 11, 150, 178);
		panel_0.add(button0);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("");
		panel_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(187, 33, 170, 200);
		sayfa1.add(panel_1);

		JButton button1 = new JButton("");
		Image img1 = new ImageIcon(this.getClass().getResource("/creed.jpg")).getImage();
		button1.setIcon(new ImageIcon(img1));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("2", eposta).setVisible(true);
			}
		});
		button1.setBounds(10, 11, 150, 178);
		panel_1.add(button1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setToolTipText("");
		panel_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(363, 33, 170, 200);
		sayfa1.add(panel_2);

		JButton button2 = new JButton("");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("3", eposta).setVisible(true);
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/alacakaranlýk.jpg")).getImage();
		button2.setIcon(new ImageIcon(img2));
		button2.setBounds(10, 11, 150, 178);
		panel_2.add(button2);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setToolTipText("");
		panel_3.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(539, 33, 170, 200);
		sayfa1.add(panel_3);

		JButton button3 = new JButton("");
		Image img3 = new ImageIcon(this.getClass().getResource("/2kule.jpg")).getImage();
		button3.setIcon(new ImageIcon(img3));
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("4", eposta).setVisible(true);
			}
		});
		button3.setBounds(10, 11, 150, 178);
		panel_3.add(button3);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setToolTipText("");
		panel_4.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(717, 33, 170, 200);
		sayfa1.add(panel_4);

		JButton button4 = new JButton("");
		Image img4 = new ImageIcon(this.getClass().getResource("/maske.jpg")).getImage();
		button4.setIcon(new ImageIcon(img4));
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("5", eposta).setVisible(true);
			}
		});
		button4.setBounds(10, 11, 150, 178);
		panel_4.add(button4);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setToolTipText("");
		panel_5.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(10, 290, 170, 200);
		sayfa1.add(panel_5);

		JButton button5 = new JButton("");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("6", eposta).setVisible(true);
			}
		});
		Image img5 = new ImageIcon(this.getClass().getResource("/kara_sovalye1.jpg")).getImage();
		button5.setIcon(new ImageIcon(img5));
		button5.setBounds(10, 11, 150, 178);
		panel_5.add(button5);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setToolTipText("");
		panel_6.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_6.setBackground(Color.BLACK);
		panel_6.setBounds(187, 290, 170, 200);
		sayfa1.add(panel_6);

		JButton button6 = new JButton("");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("7", eposta).setVisible(true);
			}
		});
		Image img6 = new ImageIcon(this.getClass().getResource("/sherlock.jpg")).getImage();
		button6.setIcon(new ImageIcon(img6));
		button6.setBounds(10, 11, 150, 178);
		panel_6.add(button6);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setToolTipText("");
		panel_7.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_7.setBackground(Color.BLACK);
		panel_7.setBounds(363, 290, 170, 200);
		sayfa1.add(panel_7);

		JButton button7 = new JButton("");
		Image img7 = new ImageIcon(this.getClass().getResource("/kralýn_donusu.jpg")).getImage();
		button7.setIcon(new ImageIcon(img7));
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("8", eposta).setVisible(true);
			}
		});
		button7.setBounds(10, 11, 150, 178);
		panel_7.add(button7);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setToolTipText("");
		panel_8.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_8.setBackground(Color.BLACK);
		panel_8.setBounds(539, 290, 170, 200);
		sayfa1.add(panel_8);

		JButton button8 = new JButton("");
		Image img8 = new ImageIcon(this.getClass().getResource("/transformers.jpg")).getImage();
		button8.setIcon(new ImageIcon(img8));
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("9", eposta).setVisible(true);
			}
		});
		button8.setBounds(10, 11, 150, 178);
		panel_8.add(button8);

		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setToolTipText("");
		panel_9.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_9.setBackground(Color.BLACK);
		panel_9.setBounds(717, 290, 170, 200);
		sayfa1.add(panel_9);

		JButton button9 = new JButton("");
		Image img9 = new ImageIcon(this.getClass().getResource("/baslangic.jpg")).getImage();
		button9.setIcon(new ImageIcon(img9));
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("10", eposta).setVisible(true);
			}
		});
		button9.setBounds(10, 11, 150, 178);
		panel_9.add(button9);

		// 2. Sayfa Baþlangýcý

		JPanel sayfa2 = new JPanel();
		tabbedPane.addTab("        2. Sayfa        ", null, sayfa2, null);
		sayfa2.setBackground(Color.BLACK);
		sayfa2.setLayout(null);

		JPanel panel_00 = new JPanel();
		panel_00.setLayout(null);
		panel_00.setToolTipText("");
		panel_00.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_00.setBackground(Color.BLACK);
		panel_00.setBounds(10, 33, 170, 200);
		sayfa2.add(panel_00);

		JButton button00 = new JButton("");
		Image iimg = new ImageIcon(this.getClass().getResource("/interstellar.jpg")).getImage();
		button00.setIcon(new ImageIcon(iimg));
		button00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/*
				 * IzlemeEkrani izle = new IzlemeEkrani(); izle.programID = "1";
				 */
				setVisible(false);
				new IzlemeEkrani("11", eposta).setVisible(true);

			}
		});
		button00.setBounds(10, 11, 150, 178);
		panel_00.add(button00);

		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setToolTipText("");
		panel_11.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_11.setBackground(Color.BLACK);
		panel_11.setBounds(187, 33, 170, 200);
		sayfa2.add(panel_11);

		JButton button11 = new JButton("");
		Image iimg1 = new ImageIcon(this.getClass().getResource("/harry_olum.jpg")).getImage();
		button11.setIcon(new ImageIcon(iimg1));
		button11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("12", eposta).setVisible(true);
			}
		});
		button11.setBounds(10, 11, 150, 178);
		panel_11.add(button11);

		JPanel panel_22 = new JPanel();
		panel_22.setLayout(null);
		panel_22.setToolTipText("");
		panel_22.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_22.setBackground(Color.BLACK);
		panel_22.setBounds(363, 33, 170, 200);
		sayfa2.add(panel_22);

		JButton button22 = new JButton("");
		button22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("13", eposta).setVisible(true);
			}
		});
		Image iimg2 = new ImageIcon(this.getClass().getResource("/jurassic_world.jpg")).getImage();
		button22.setIcon(new ImageIcon(iimg2));
		button22.setBounds(10, 11, 150, 178);
		panel_22.add(button22);

		JPanel panel_33 = new JPanel();
		panel_33.setLayout(null);
		panel_33.setToolTipText("");
		panel_33.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_33.setBackground(Color.BLACK);
		panel_33.setBounds(539, 33, 170, 200);
		sayfa2.add(panel_33);

		JButton button33 = new JButton("");
		Image iimg3 = new ImageIcon(this.getClass().getResource("/fantastik_canavarlar.jpg")).getImage();
		button33.setIcon(new ImageIcon(iimg3));
		button33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("14", eposta).setVisible(true);
			}
		});
		button33.setBounds(10, 11, 150, 178);
		panel_33.add(button33);

		JPanel panel_44 = new JPanel();
		panel_44.setLayout(null);
		panel_44.setToolTipText("");
		panel_44.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_44.setBackground(Color.BLACK);
		panel_44.setBounds(717, 33, 170, 200);
		sayfa2.add(panel_44);

		JButton button44 = new JButton("");
		Image iimg4 = new ImageIcon(this.getClass().getResource("/ninja1.jpg")).getImage();
		button44.setIcon(new ImageIcon(iimg4));
		button44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("15", eposta).setVisible(true);

			}
		});
		button44.setBounds(10, 11, 150, 178);
		panel_44.add(button44);

		JPanel panel_55 = new JPanel();
		panel_55.setLayout(null);
		panel_55.setToolTipText("");
		panel_55.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_55.setBackground(Color.BLACK);
		panel_55.setBounds(10, 290, 170, 200);
		sayfa2.add(panel_55);

		JButton button55 = new JButton("");
		button55.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("16", eposta).setVisible(true);
			}
		});
		Image iimg5 = new ImageIcon(this.getClass().getResource("/kuþlarla_dans.jpg")).getImage();
		button55.setIcon(new ImageIcon(iimg5));
		button55.setBounds(10, 11, 150, 178);
		panel_55.add(button55);

		JPanel panel_66 = new JPanel();
		panel_66.setLayout(null);
		panel_66.setToolTipText("");
		panel_66.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_66.setBackground(Color.BLACK);
		panel_66.setBounds(187, 290, 170, 200);
		sayfa2.add(panel_66);

		JButton button66 = new JButton("");
		button66.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("17", eposta).setVisible(true);
			}
		});
		Image iimg6 = new ImageIcon(this.getClass().getResource("/mission_blue.jpg")).getImage();
		button66.setIcon(new ImageIcon(iimg6));
		button66.setBounds(10, 11, 150, 178);
		panel_66.add(button66);

		JPanel panel_77 = new JPanel();
		panel_77.setLayout(null);
		panel_77.setToolTipText("");
		panel_77.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_77.setBackground(Color.BLACK);
		panel_77.setBounds(363, 290, 170, 200);
		sayfa2.add(panel_77);

		JButton button77 = new JButton("");
		Image iimg7 = new ImageIcon(this.getClass().getResource("/mercan.jpg")).getImage();
		button77.setIcon(new ImageIcon(iimg7));
		button77.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("18", eposta).setVisible(true);
			}
		});
		button77.setBounds(10, 11, 150, 178);
		panel_77.add(button77);

		JPanel panel_88 = new JPanel();
		panel_88.setLayout(null);
		panel_88.setToolTipText("");
		panel_88.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_88.setBackground(Color.BLACK);
		panel_88.setBounds(539, 290, 170, 200);
		sayfa2.add(panel_88);

		JButton button88 = new JButton("");
		Image iimg8 = new ImageIcon(this.getClass().getResource("/dream_big.jpg")).getImage();
		button88.setIcon(new ImageIcon(iimg8));
		button88.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IzlemeEkrani("19", eposta).setVisible(true);
			}
		});
		button88.setBounds(10, 11, 150, 178);
		panel_88.add(button88);

		JPanel panel_99 = new JPanel();
		panel_99.setLayout(null);
		panel_99.setToolTipText("");
		panel_99.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_99.setBackground(Color.BLACK);
		panel_99.setBounds(717, 290, 170, 200);
		sayfa2.add(panel_99);

		JButton button99 = new JButton("");
		Image iimg9 = new ImageIcon(this.getClass().getResource("/aydaki_adam.jpg")).getImage();
		button99.setIcon(new ImageIcon(iimg9));
		button99.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IzlemeEkrani("20", eposta).setVisible(true);
			}
		});
		button99.setBounds(10, 11, 150, 178);
		panel_99.add(button99);

		// 3. Sayfa

		JPanel sayfa3 = new JPanel();
		tabbedPane.addTab("        3. Sayfa       ", null, sayfa3, null);
		sayfa3.setBackground(Color.BLACK);
		sayfa3.setLayout(null);

		JPanel panel_000 = new JPanel();
		panel_000.setLayout(null);
		panel_000.setToolTipText("");
		panel_000.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_000.setBackground(Color.BLACK);
		panel_000.setBounds(10, 33, 170, 200);
		sayfa3.add(panel_000);

		JButton button000 = new JButton("");
		Image iiimg = new ImageIcon(this.getClass().getResource("/plastik_okyanus.jpg")).getImage();
		button000.setIcon(new ImageIcon(iiimg));
		button000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/*
				 * IzlemeEkrani izle = new IzlemeEkrani(); izle.programID = "1";
				 */
				setVisible(false);
				new IzlemeEkrani("21", eposta).setVisible(true);

			}
		});
		button000.setBounds(10, 11, 150, 178);
		panel_000.add(button000);

		JPanel panel_111 = new JPanel();
		panel_111.setLayout(null);
		panel_111.setToolTipText("");
		panel_111.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_111.setBackground(Color.BLACK);
		panel_111.setBounds(187, 33, 170, 200);
		sayfa3.add(panel_111);

		JButton button111 = new JButton("");
		Image iiimg1 = new ImageIcon(this.getClass().getResource("/rakam_tahmin.jpg")).getImage();
		button111.setIcon(new ImageIcon(iiimg1));
		button111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("22", eposta).setVisible(true);
			}
		});
		button111.setBounds(10, 11, 150, 178);
		panel_111.add(button111);

		JPanel panel_222 = new JPanel();
		panel_222.setLayout(null);
		panel_222.setToolTipText("");
		panel_222.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_222.setBackground(Color.BLACK);
		panel_222.setBounds(363, 33, 170, 200);
		sayfa3.add(panel_222);

		JButton button222 = new JButton("");
		button222.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("23", eposta).setVisible(true);
			}
		});
		Image iiimg2 = new ImageIcon(this.getClass().getResource("/efsaneyim.jpg")).getImage();
		button222.setIcon(new ImageIcon(iiimg2));
		button222.setBounds(10, 11, 150, 178);
		panel_222.add(button222);

		JPanel panel_333 = new JPanel();
		panel_333.setLayout(null);
		panel_333.setToolTipText("");
		panel_333.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_333.setBackground(Color.BLACK);
		panel_333.setBounds(539, 33, 170, 200);
		sayfa3.add(panel_333);

		JButton button333 = new JButton("");
		Image iiimg3 = new ImageIcon(this.getClass().getResource("/arif216.jpg")).getImage();
		button333.setIcon(new ImageIcon(iiimg3));
		button333.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("24", eposta).setVisible(true);
			}
		});
		button333.setBounds(10, 11, 150, 178);
		panel_333.add(button333);

		JPanel panel_444 = new JPanel();
		panel_444.setLayout(null);
		panel_444.setToolTipText("");
		panel_444.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_444.setBackground(Color.BLACK);
		panel_444.setBounds(717, 33, 170, 200);
		sayfa3.add(panel_444);

		JButton button444 = new JButton("");
		Image iiimg4 = new ImageIcon(this.getClass().getResource("/pk.jpg")).getImage();
		button444.setIcon(new ImageIcon(iiimg4));
		button444.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("25", eposta).setVisible(true);

			}
		});
		button444.setBounds(10, 11, 150, 178);
		panel_444.add(button444);

		JPanel panel_555 = new JPanel();
		panel_555.setLayout(null);
		panel_555.setToolTipText("");
		panel_555.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_555.setBackground(Color.BLACK);
		panel_555.setBounds(10, 290, 170, 200);
		sayfa3.add(panel_555);

		JButton button555 = new JButton("");
		button555.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("26", eposta).setVisible(true);
			}
		});
		Image iiimg5 = new ImageIcon(this.getClass().getResource("/orumcek1.jpg")).getImage();
		button555.setIcon(new ImageIcon(iiimg5));
		button555.setBounds(10, 11, 150, 178);
		panel_555.add(button555);

		JPanel panel_666 = new JPanel();
		panel_666.setLayout(null);
		panel_666.setToolTipText("");
		panel_666.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_666.setBackground(Color.BLACK);
		panel_666.setBounds(187, 290, 170, 200);
		sayfa3.add(panel_666);

		JButton button666 = new JButton("");
		button666.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("27", eposta).setVisible(true);
			}
		});
		Image iiimg6 = new ImageIcon(this.getClass().getResource("/jurassic_park.jpg")).getImage();
		button666.setIcon(new ImageIcon(iiimg6));
		button666.setBounds(10, 11, 150, 178);
		panel_666.add(button666);

		JPanel panel_777 = new JPanel();
		panel_777.setLayout(null);
		panel_777.setToolTipText("");
		panel_777.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_777.setBackground(Color.BLACK);
		panel_777.setBounds(363, 290, 170, 200);
		sayfa3.add(panel_777);

		JButton button777 = new JButton("");
		Image iiimg7 = new ImageIcon(this.getClass().getResource("/frankenstein.jpg")).getImage();
		button777.setIcon(new ImageIcon(iiimg7));
		button777.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("28", eposta).setVisible(true);
			}
		});
		button777.setBounds(10, 11, 150, 178);
		panel_777.add(button777);

		JPanel panel_888 = new JPanel();
		panel_888.setLayout(null);
		panel_888.setToolTipText("");
		panel_888.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_888.setBackground(Color.BLACK);
		panel_888.setBounds(539, 290, 170, 200);
		sayfa3.add(panel_888);

		JButton button888 = new JButton("");
		Image iiimg8 = new ImageIcon(this.getClass().getResource("/gezegenimiz.jpg")).getImage();
		button888.setIcon(new ImageIcon(iiimg8));
		button888.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IzlemeEkrani("29", eposta).setVisible(true);
			}
		});
		button888.setBounds(10, 11, 150, 178);
		panel_888.add(button888);

		JPanel panel_999 = new JPanel();
		panel_999.setLayout(null);
		panel_999.setToolTipText("");
		panel_999.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_999.setBackground(Color.BLACK);
		panel_999.setBounds(717, 290, 170, 200);
		sayfa3.add(panel_999);

		JButton button999 = new JButton("");
		Image iiimg9 = new ImageIcon(this.getClass().getResource("/72sevimli.jpg")).getImage();
		button999.setIcon(new ImageIcon(iiimg9));
		button999.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IzlemeEkrani("30", eposta).setVisible(true);
			}
		});
		button999.setBounds(10, 11, 150, 178);
		panel_999.add(button999);

		// 4. Sayfa

		JPanel sayfa4 = new JPanel();
		tabbedPane.addTab("        4. Sayfa       ", null, sayfa4, null);
		sayfa4.setBackground(Color.BLACK);
		sayfa4.setLayout(null);

		JPanel panel_0000 = new JPanel();
		panel_0000.setLayout(null);
		panel_0000.setToolTipText("");
		panel_0000.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_0000.setBackground(Color.BLACK);
		panel_0000.setBounds(10, 33, 170, 200);
		sayfa4.add(panel_0000);

		JButton button0000 = new JButton("");
		Image iiiimg = new ImageIcon(this.getClass().getResource("/kuscular.jpg")).getImage();
		button0000.setIcon(new ImageIcon(iiiimg));
		button0000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/*
				 * IzlemeEkrani izle = new IzlemeEkrani(); izle.programID = "1";
				 */
				setVisible(false);
				new IzlemeEkrani("31", eposta).setVisible(true);

			}
		});
		button0000.setBounds(10, 11, 150, 178);
		panel_0000.add(button0000);

		JPanel panel_1111 = new JPanel();
		panel_1111.setLayout(null);
		panel_1111.setToolTipText("");
		panel_1111.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_1111.setBackground(Color.BLACK);
		panel_1111.setBounds(187, 33, 170, 200);
		sayfa4.add(panel_1111);

		JButton button1111 = new JButton("");
		Image iiiimg1 = new ImageIcon(this.getClass().getResource("/marsta_kesif.jpg")).getImage();
		button1111.setIcon(new ImageIcon(iiiimg1));
		button1111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("32", eposta).setVisible(true);
			}
		});
		button1111.setBounds(10, 11, 150, 178);
		panel_1111.add(button1111);

		JPanel panel_2222 = new JPanel();
		panel_2222.setLayout(null);
		panel_2222.setToolTipText("");
		panel_2222.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_2222.setBackground(Color.BLACK);
		panel_2222.setBounds(363, 33, 170, 200);
		sayfa4.add(panel_2222);

		JButton button2222 = new JButton("");
		button2222.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("33", eposta).setVisible(true);
			}
		});
		Image iiiimg2 = new ImageIcon(this.getClass().getResource("/pandemic.jpg")).getImage();
		button2222.setIcon(new ImageIcon(iiiimg2));
		button2222.setBounds(10, 11, 150, 178);
		panel_2222.add(button2222);

		JPanel panel_3333 = new JPanel();
		panel_3333.setLayout(null);
		panel_3333.setToolTipText("");
		panel_3333.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_3333.setBackground(Color.BLACK);
		panel_3333.setBounds(539, 33, 170, 200);
		sayfa4.add(panel_3333);

		JButton button3333 = new JButton("");
		Image iiiimg3 = new ImageIcon(this.getClass().getResource("/pokemon.jpg")).getImage();
		button3333.setIcon(new ImageIcon(iiiimg3));
		button3333.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("34", eposta).setVisible(true);
			}
		});
		button3333.setBounds(10, 11, 150, 178);
		panel_3333.add(button3333);

		JPanel panel_4444 = new JPanel();
		panel_4444.setLayout(null);
		panel_4444.setToolTipText("");
		panel_4444.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_4444.setBackground(Color.BLACK);
		panel_4444.setBounds(717, 33, 170, 200);
		sayfa4.add(panel_4444);

		JButton button4444 = new JButton("");
		Image iiiimg4 = new ImageIcon(this.getClass().getResource("/sirinler.jpg")).getImage();
		button4444.setIcon(new ImageIcon(iiiimg4));
		button4444.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("35", eposta).setVisible(true);

			}
		});
		button4444.setBounds(10, 11, 150, 178);
		panel_4444.add(button4444);

		JPanel panel_5555 = new JPanel();
		panel_5555.setLayout(null);
		panel_5555.setToolTipText("");
		panel_5555.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_5555.setBackground(Color.BLACK);
		panel_5555.setBounds(10, 290, 170, 200);
		sayfa4.add(panel_5555);

		JButton button5555 = new JButton("");
		button5555.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("36", eposta).setVisible(true);
			}
		});
		Image iiiimg5 = new ImageIcon(this.getClass().getResource("/charlie.jpg")).getImage();
		button5555.setIcon(new ImageIcon(iiiimg5));
		button5555.setBounds(10, 11, 150, 178);
		panel_5555.add(button5555);

		JPanel panel_6666 = new JPanel();
		panel_6666.setLayout(null);
		panel_6666.setToolTipText("");
		panel_6666.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_6666.setBackground(Color.BLACK);
		panel_6666.setBounds(187, 290, 170, 200);
		sayfa4.add(panel_6666);

		JButton button6666 = new JButton("");
		button6666.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("37", eposta).setVisible(true);
			}
		});
		Image iiiimg6 = new ImageIcon(this.getClass().getResource("/alvin.jpg")).getImage();
		button6666.setIcon(new ImageIcon(iiiimg6));
		button6666.setBounds(10, 11, 150, 178);
		panel_6666.add(button6666);

		JPanel panel_7777 = new JPanel();
		panel_7777.setLayout(null);
		panel_7777.setToolTipText("");
		panel_7777.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_7777.setBackground(Color.BLACK);
		panel_7777.setBounds(363, 290, 170, 200);
		sayfa4.add(panel_7777);

		JButton button7777 = new JButton("");
		Image iiiimg7 = new ImageIcon(this.getClass().getResource("/scooby.jpg")).getImage();
		button7777.setIcon(new ImageIcon(iiiimg7));
		button7777.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("38", eposta).setVisible(true);
			}
		});
		button7777.setBounds(10, 11, 150, 178);
		panel_7777.add(button7777);

		JPanel panel_8888 = new JPanel();
		panel_8888.setLayout(null);
		panel_8888.setToolTipText("");
		panel_8888.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_8888.setBackground(Color.BLACK);
		panel_8888.setBounds(539, 290, 170, 200);
		sayfa4.add(panel_8888);

		JButton button8888 = new JButton("");
		Image iiiimg8 = new ImageIcon(this.getClass().getResource("/kung_fu.jpg")).getImage();
		button8888.setIcon(new ImageIcon(iiiimg8));
		button8888.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IzlemeEkrani("39", eposta).setVisible(true);
			}
		});
		button8888.setBounds(10, 11, 150, 178);
		panel_8888.add(button8888);

		JPanel panel_9999 = new JPanel();
		panel_9999.setLayout(null);
		panel_9999.setToolTipText("");
		panel_9999.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_9999.setBackground(Color.BLACK);
		panel_9999.setBounds(717, 290, 170, 200);
		sayfa4.add(panel_9999);

		JButton button9999 = new JButton("");
		Image iiiimg9 = new ImageIcon(this.getClass().getResource("/bean.jpg")).getImage();
		button9999.setIcon(new ImageIcon(iiiimg9));
		button9999.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IzlemeEkrani("40", eposta).setVisible(true);
			}
		});
		button9999.setBounds(10, 11, 150, 178);
		panel_9999.add(button9999);

		// 5. Sayfa
		JPanel sayfa5 = new JPanel();
		tabbedPane.addTab("        5. Sayfa       ", null, sayfa5, null);
		sayfa5.setBackground(Color.BLACK);
		sayfa5.setLayout(null);

		JPanel panel_00000 = new JPanel();
		panel_00000.setLayout(null);
		panel_00000.setToolTipText("");
		panel_00000.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_00000.setBackground(Color.BLACK);
		panel_00000.setBounds(10, 33, 170, 200);
		sayfa5.add(panel_00000);

		JButton button00000 = new JButton("");
		Image iiiiimg = new ImageIcon(this.getClass().getResource("/shrek.jpg")).getImage();
		button00000.setIcon(new ImageIcon(iiiiimg));
		button00000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				setVisible(false);
				new IzlemeEkrani("41", eposta).setVisible(true);

			}
		});
		button00000.setBounds(10, 11, 150, 178);
		panel_00000.add(button00000);

		JPanel panel_11111 = new JPanel();
		panel_11111.setLayout(null);
		panel_11111.setToolTipText("");
		panel_11111.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_11111.setBackground(Color.BLACK);
		panel_11111.setBounds(187, 33, 170, 200);
		sayfa5.add(panel_11111);

		JButton button11111 = new JButton("");
		Image iiiiimg1 = new ImageIcon(this.getClass().getResource("/mega_zeka.jpg")).getImage();
		button11111.setIcon(new ImageIcon(iiiiimg1));
		button11111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("42", eposta).setVisible(true);
			}
		});
		button11111.setBounds(10, 11, 150, 178);
		panel_11111.add(button11111);

		JPanel panel_22222 = new JPanel();
		panel_22222.setLayout(null);
		panel_22222.setToolTipText("");
		panel_22222.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_22222.setBackground(Color.BLACK);
		panel_22222.setBounds(363, 33, 170, 200);
		sayfa5.add(panel_22222);

		JButton button22222 = new JButton("");
		button22222.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("43", eposta).setVisible(true);
			}
		});
		Image iiiiimg2 = new ImageIcon(this.getClass().getResource("/bizi_hatirla.jpg")).getImage();
		button22222.setIcon(new ImageIcon(iiiiimg2));
		button22222.setBounds(10, 11, 150, 178);
		panel_22222.add(button22222);

		JPanel panel_33333 = new JPanel();
		panel_33333.setLayout(null);
		panel_33333.setToolTipText("");
		panel_33333.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_33333.setBackground(Color.BLACK);
		panel_33333.setBounds(539, 33, 170, 200);
		sayfa5.add(panel_33333);

		JButton button33333 = new JButton("");
		Image iiiiimg3 = new ImageIcon(this.getClass().getResource("/delibal.jpg")).getImage();
		button33333.setIcon(new ImageIcon(iiiiimg3));
		button33333.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("44", eposta).setVisible(true);
			}
		});
		button33333.setBounds(10, 11, 150, 178);
		panel_33333.add(button33333);

		JPanel panel_44444 = new JPanel();
		panel_44444.setLayout(null);
		panel_44444.setToolTipText("");
		panel_44444.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_44444.setBackground(Color.BLACK);
		panel_44444.setBounds(717, 33, 170, 200);
		sayfa5.add(panel_44444);

		JButton button44444 = new JButton("");
		Image iiiiimg4 = new ImageIcon(this.getClass().getResource("/kardesim_benim.jpg")).getImage();
		button44444.setIcon(new ImageIcon(iiiiimg4));
		button44444.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("45", eposta).setVisible(true);

			}
		});
		button44444.setBounds(10, 11, 150, 178);
		panel_44444.add(button44444);

		JPanel panel_55555 = new JPanel();
		panel_55555.setLayout(null);
		panel_55555.setToolTipText("");
		panel_55555.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_55555.setBackground(Color.BLACK);
		panel_55555.setBounds(10, 290, 170, 200);
		sayfa5.add(panel_55555);

		JButton button55555 = new JButton("");
		button55555.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("46", eposta).setVisible(true);
			}
		});
		Image iiiiimg5 = new ImageIcon(this.getClass().getResource("/dangal.jpg")).getImage();
		button55555.setIcon(new ImageIcon(iiiiimg5));
		button55555.setBounds(10, 11, 150, 178);
		panel_55555.add(button55555);

		JPanel panel_66666 = new JPanel();
		panel_66666.setLayout(null);
		panel_66666.setToolTipText("");
		panel_66666.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_66666.setBackground(Color.BLACK);
		panel_66666.setBounds(187, 290, 170, 200);
		sayfa5.add(panel_66666);

		JButton button66666 = new JButton("");
		button66666.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("47", eposta).setVisible(true);
			}
		});
		Image iiiiimg6 = new ImageIcon(this.getClass().getResource("/yercekimi.jpg")).getImage();
		button66666.setIcon(new ImageIcon(iiiiimg6));
		button66666.setBounds(10, 11, 150, 178);
		panel_66666.add(button66666);

		JPanel panel_77777 = new JPanel();
		panel_77777.setLayout(null);
		panel_77777.setToolTipText("");
		panel_77777.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_77777.setBackground(Color.BLACK);
		panel_77777.setBounds(363, 290, 170, 200);
		sayfa5.add(panel_77777);

		JButton button77777 = new JButton("");
		Image iiiiimg7 = new ImageIcon(this.getClass().getResource("/jaws.jpg")).getImage();
		button77777.setIcon(new ImageIcon(iiiiimg7));
		button77777.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("48", eposta).setVisible(true);
			}
		});
		button77777.setBounds(10, 11, 150, 178);
		panel_77777.add(button77777);

		JPanel panel_88888 = new JPanel();
		panel_88888.setLayout(null);
		panel_88888.setToolTipText("");
		panel_88888.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_88888.setBackground(Color.BLACK);
		panel_88888.setBounds(539, 290, 170, 200);
		sayfa5.add(panel_88888);

		JButton button88888 = new JButton("");
		Image iiiiimg8 = new ImageIcon(this.getClass().getResource("/da_vinci.jpg")).getImage();
		button88888.setIcon(new ImageIcon(iiiiimg8));
		button88888.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IzlemeEkrani("49", eposta).setVisible(true);
			}
		});
		button88888.setBounds(10, 11, 150, 178);
		panel_88888.add(button88888);

		JPanel panel_99999 = new JPanel();
		panel_99999.setLayout(null);
		panel_99999.setToolTipText("");
		panel_99999.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_99999.setBackground(Color.BLACK);
		panel_99999.setBounds(717, 290, 170, 200);
		sayfa5.add(panel_99999);

		JButton button99999 = new JButton("");
		Image iiiiimg9 = new ImageIcon(this.getClass().getResource("/marwel.jpg")).getImage();
		button99999.setIcon(new ImageIcon(iiiiimg9));
		button99999.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IzlemeEkrani("50", eposta).setVisible(true);
			}
		});
		button99999.setBounds(10, 11, 150, 178);
		panel_99999.add(button99999);

		// 6. Sayfa
		JPanel sayfa6 = new JPanel();
		tabbedPane.addTab("        6. Sayfa       ", null, sayfa6, null);
		sayfa6.setBackground(Color.BLACK);
		sayfa6.setLayout(null);

		JPanel panel_000000 = new JPanel();
		panel_000000.setLayout(null);
		panel_000000.setToolTipText("");
		panel_000000.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_000000.setBackground(Color.BLACK);
		panel_000000.setBounds(10, 33, 170, 200);
		sayfa6.add(panel_000000);

		JButton button000000 = new JButton("");
		Image iiiiiimg = new ImageIcon(this.getClass().getResource("/ejderhalar.jpg")).getImage();
		button000000.setIcon(new ImageIcon(iiiiiimg));
		button000000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				setVisible(false);
				new IzlemeEkrani("51" , eposta).setVisible(true);

			}
		});
		button000000.setBounds(10, 11, 150, 178);
		panel_000000.add(button000000);

		JPanel panel_111111 = new JPanel();
		panel_111111.setLayout(null);
		panel_111111.setToolTipText("");
		panel_111111.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_111111.setBackground(Color.BLACK);
		panel_111111.setBounds(187, 33, 170, 200);
		sayfa6.add(panel_111111);

		JButton button111111 = new JButton("");
		Image iiiiiimg1 = new ImageIcon(this.getClass().getResource("/ertugrul.jpg")).getImage();
		button111111.setIcon(new ImageIcon(iiiiiimg1));
		button111111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("52", eposta).setVisible(true);
			}
		});
		button111111.setBounds(10, 11, 150, 178);
		panel_111111.add(button111111);

		JPanel panel_222222 = new JPanel();
		panel_222222.setLayout(null);
		panel_222222.setToolTipText("");
		panel_222222.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_222222.setBackground(Color.BLACK);
		panel_222222.setBounds(363, 33, 170, 200);
		sayfa6.add(panel_222222);

		JButton button222222 = new JButton("");
		button222222.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("53", eposta).setVisible(true);
			}
		});
		Image iiiiiimg2 = new ImageIcon(this.getClass().getResource("/trol_avcilari.jpg")).getImage();
		button222222.setIcon(new ImageIcon(iiiiiimg2));
		button222222.setBounds(10, 11, 150, 178);
		panel_222222.add(button222222);

		JPanel panel_333333 = new JPanel();
		panel_333333.setLayout(null);
		panel_333333.setToolTipText("");
		panel_333333.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_333333.setBackground(Color.BLACK);
		panel_333333.setBounds(539, 33, 170, 200);
		sayfa6.add(panel_333333);

		JButton button333333 = new JButton("");
		Image iiiiiimg3 = new ImageIcon(this.getClass().getResource("/himym.jpg")).getImage();
		button333333.setIcon(new ImageIcon(iiiiiimg3));
		button333333.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("54", eposta).setVisible(true);
			}
		});
		button333333.setBounds(10, 11, 150, 178);
		panel_333333.add(button333333);

		JPanel panel_444444 = new JPanel();
		panel_444444.setLayout(null);
		panel_444444.setToolTipText("");
		panel_444444.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_444444.setBackground(Color.BLACK);
		panel_444444.setBounds(717, 33, 170, 200);
		sayfa6.add(panel_444444);

		JButton button444444 = new JButton("");
		Image iiiiiimg4 = new ImageIcon(this.getClass().getResource("/leyla_mecnun.jpg")).getImage();
		button444444.setIcon(new ImageIcon(iiiiiimg4));
		button444444.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("55", eposta).setVisible(true);

			}
		});
		button444444.setBounds(10, 11, 150, 178);
		panel_444444.add(button444444);

		JPanel panel_555555 = new JPanel();
		panel_555555.setLayout(null);
		panel_555555.setToolTipText("");
		panel_555555.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_555555.setBackground(Color.BLACK);
		panel_555555.setBounds(10, 290, 170, 200);
		sayfa6.add(panel_555555);

		JButton button555555 = new JButton("");
		button555555.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("56", eposta).setVisible(true);
			}
		});
		Image iiiiiimg5 = new ImageIcon(this.getClass().getResource("/beni_boyle_sev.jpg")).getImage();
		button555555.setIcon(new ImageIcon(iiiiiimg5));
		button555555.setBounds(10, 11, 150, 178);
		panel_555555.add(button555555);

		JPanel panel_666666 = new JPanel();
		panel_666666.setLayout(null);
		panel_666666.setToolTipText("");
		panel_666666.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_666666.setBackground(Color.BLACK);
		panel_666666.setBounds(187, 290, 170, 200);
		sayfa6.add(panel_666666);

		JButton button666666 = new JButton("");
		button666666.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("57", eposta).setVisible(true);
			}
		});
		Image iiiiiimg6 = new ImageIcon(this.getClass().getResource("/patron_bebek.jpg")).getImage();
		button666666.setIcon(new ImageIcon(iiiiiimg6));
		button666666.setBounds(10, 11, 150, 178);
		panel_666666.add(button666666);

		JPanel panel_777777 = new JPanel();
		panel_777777.setLayout(null);
		panel_777777.setToolTipText("");
		panel_777777.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_777777.setBackground(Color.BLACK);
		panel_777777.setBounds(363, 290, 170, 200);
		sayfa6.add(panel_777777);

		JButton button777777 = new JButton("");
		Image iiiiiimg7 = new ImageIcon(this.getClass().getResource("/atiye.jpg")).getImage();
		button777777.setIcon(new ImageIcon(iiiiiimg7));
		button777777.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("58", eposta).setVisible(true);
			}
		});
		button777777.setBounds(10, 11, 150, 178);
		panel_777777.add(button777777);

		JPanel panel_888888 = new JPanel();
		panel_888888.setLayout(null);
		panel_888888.setToolTipText("");
		panel_888888.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_888888.setBackground(Color.BLACK);
		panel_888888.setBounds(539, 290, 170, 200);
		sayfa6.add(panel_888888);

		JButton button888888 = new JButton("");
		Image iiiiiimg8 = new ImageIcon(this.getClass().getResource("/masa_kocaAyi.jpg")).getImage();
		button888888.setIcon(new ImageIcon(iiiiiimg8));
		button888888.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IzlemeEkrani("59", eposta).setVisible(true);
			}
		});
		button888888.setBounds(10, 11, 150, 178);
		panel_888888.add(button888888);

		JPanel panel_999999 = new JPanel();
		panel_999999.setLayout(null);
		panel_999999.setToolTipText("");
		panel_999999.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_999999.setBackground(Color.BLACK);
		panel_999999.setBounds(717, 290, 170, 200);
		sayfa6.add(panel_999999);

		JButton button999999 = new JButton("");
		Image iiiiiimg9 = new ImageIcon(this.getClass().getResource("/sunger_bob.jpg")).getImage();
		button999999.setIcon(new ImageIcon(iiiiiimg9));
		button999999.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IzlemeEkrani("60", eposta).setVisible(true);
			}
		});
		button999999.setBounds(10, 11, 150, 178);
		panel_999999.add(button999999);
		
		
		// 7. Sayfa
		JPanel sayfa7 = new JPanel();
		tabbedPane.addTab("        7. Sayfa        ", null, sayfa7, null);
		sayfa7.setBackground(Color.BLACK);
		sayfa7.setLayout(null);
		
		JPanel panel_0000000 = new JPanel();
		panel_0000000.setLayout(null);
		panel_0000000.setToolTipText("");
		panel_0000000.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_0000000.setBackground(Color.BLACK);
		panel_0000000.setBounds(10, 33, 170, 200);
		sayfa7.add(panel_0000000);
		
		JButton button0000000 = new JButton("");
		Image iiiiiiimg = new ImageIcon(this.getClass().getResource("/stranger_things.jpg")).getImage();
		button0000000.setIcon(new ImageIcon(iiiiiiimg));
		button0000000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				new IzlemeEkrani("61", eposta).setVisible(true);
				
			}
		});
		button0000000.setBounds(10, 11, 150, 178);
		panel_0000000.add(button0000000);
		
		JPanel panel_1111111 = new JPanel();
		panel_1111111.setLayout(null);
		panel_1111111.setToolTipText("");
		panel_1111111.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_1111111.setBackground(Color.BLACK);
		panel_1111111.setBounds(187, 33, 170, 200);
		sayfa7.add(panel_1111111);
		
		JButton button1111111 = new JButton("");
		Image iiiiiiimg1 = new ImageIcon(this.getClass().getResource("/originals.jpg")).getImage();
		button1111111.setIcon(new ImageIcon(iiiiiiimg1));
		button1111111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("62", eposta).setVisible(true);
			}
		});
		button1111111.setBounds(10, 11, 150, 178);
		panel_1111111.add(button1111111);
		
		JPanel panel_2222222 = new JPanel();
		panel_2222222.setLayout(null);
		panel_2222222.setToolTipText("");
		panel_2222222.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_2222222.setBackground(Color.BLACK);
		panel_2222222.setBounds(363, 33, 170, 200);
		sayfa7.add(panel_2222222);
		
		JButton button2222222 = new JButton("");
		button2222222.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("63", eposta).setVisible(true);
			}
		});
		Image iiiiiiimg2 = new ImageIcon(this.getClass().getResource("/angry_birds.jpg")).getImage();
		button2222222.setIcon(new ImageIcon(iiiiiiimg2));
		button2222222.setBounds(10, 11, 150, 178);
		panel_2222222.add(button2222222);
		
		JPanel panel_3333333 = new JPanel();
		panel_3333333.setLayout(null);
		panel_3333333.setToolTipText("");
		panel_3333333.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_3333333.setBackground(Color.BLACK);
		panel_3333333.setBounds(539, 33, 170, 200);
		sayfa7.add(panel_3333333);
		
		JButton button3333333 = new JButton("");
		Image iiiiiiimg3 = new ImageIcon(this.getClass().getResource("/criminal.jpg")).getImage();
		button3333333.setIcon(new ImageIcon(iiiiiiimg3));
		button3333333.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("64", eposta).setVisible(true);
			}
		});
		button3333333.setBounds(10, 11, 150, 178);
		panel_3333333.add(button3333333);
		
		
		JPanel panel_4444444 = new JPanel();
		panel_4444444.setLayout(null);
		panel_4444444.setToolTipText("");
		panel_4444444.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_4444444.setBackground(Color.BLACK);
		panel_4444444.setBounds(717, 33, 170, 200);
		sayfa7.add(panel_4444444);
		
		JButton button4444444 = new JButton("");
		Image iiiiiiimg4 = new ImageIcon(this.getClass().getResource("/beyblade.jpg")).getImage();
		button4444444.setIcon(new ImageIcon(iiiiiiimg4));
		button4444444.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("65", eposta).setVisible(true);
				
			}
		});
		button4444444.setBounds(10, 11, 150, 178);
		panel_4444444.add(button4444444);
		
		
		JPanel panel_5555555 = new JPanel();
		panel_5555555.setLayout(null);
		panel_5555555.setToolTipText("");
		panel_5555555.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_5555555.setBackground(Color.BLACK);
		panel_5555555.setBounds(10, 290, 170, 200);
		sayfa7.add(panel_5555555);
		
		JButton button5555555 = new JButton("");
		button5555555.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("66", eposta).setVisible(true);
			}
		});
		Image iiiiiiimg5 = new ImageIcon(this.getClass().getResource("/sonic.jpg")).getImage();
		button5555555.setIcon(new ImageIcon(iiiiiiimg5));
		button5555555.setBounds(10, 11, 150, 178);
		panel_5555555.add(button5555555);
		
		JPanel panel_6666666 = new JPanel();
		panel_6666666.setLayout(null);
		panel_6666666.setToolTipText("");
		panel_6666666.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_6666666.setBackground(Color.BLACK);
		panel_6666666.setBounds(187, 290, 170, 200);
		sayfa7.add(panel_6666666);
		
		JButton button6666666 = new JButton("");
		button6666666.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("67", eposta).setVisible(true);
			}
		});
		Image iiiiiiimg6 = new ImageIcon(this.getClass().getResource("/kung_fu_dizi.jpg")).getImage();
		button6666666.setIcon(new ImageIcon(iiiiiiimg6));
		button6666666.setBounds(10, 11, 150, 178);
		panel_6666666.add(button6666666);
		
		JPanel panel_7777777 = new JPanel();
		panel_7777777.setLayout(null);
		panel_7777777.setToolTipText("");
		panel_7777777.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_7777777.setBackground(Color.BLACK);
		panel_7777777.setBounds(363, 290, 170, 200);
		sayfa7.add(panel_7777777);
		
		JButton button7777777 = new JButton("");
		Image iiiiiiimg7 = new ImageIcon(this.getClass().getResource("/blacklist.jpg")).getImage();
		button7777777.setIcon(new ImageIcon(iiiiiiimg7));
		button7777777.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("68", eposta).setVisible(true);
			}
		});
		button7777777.setBounds(10, 11, 150, 178);
		panel_7777777.add(button7777777);
		
		JPanel panel_8888888 = new JPanel();
		panel_8888888.setLayout(null);
		panel_8888888.setToolTipText("");
		panel_8888888.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_8888888.setBackground(Color.BLACK);
		panel_8888888.setBounds(539, 290, 170, 200);
		sayfa7.add(panel_8888888);
		
		JButton button8888888 = new JButton("");
		Image iiiiiiimg8 = new ImageIcon(this.getClass().getResource("/dunyanin.jpg")).getImage();
		button8888888.setIcon(new ImageIcon(iiiiiiimg8));
		button8888888.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IzlemeEkrani("69", eposta).setVisible(true);
			}
		});
		button8888888.setBounds(10, 11, 150, 178);
		panel_8888888.add(button8888888);
		
		JPanel panel_9999999 = new JPanel();
		panel_9999999.setLayout(null);
		panel_9999999.setToolTipText("");
		panel_9999999.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_9999999.setBackground(Color.BLACK);
		panel_9999999.setBounds(717, 290, 170, 200);
		sayfa7.add(panel_9999999);
		
		JButton button9999999 = new JButton("");
		Image iiiiiiimg9 = new ImageIcon(this.getClass().getResource("/car_masters.jpg")).getImage();
		button9999999.setIcon(new ImageIcon(iiiiiiimg9));
		button9999999.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IzlemeEkrani("70", eposta).setVisible(true);
			}
		});
		button9999999.setBounds(10, 11, 150, 178);
		panel_9999999.add(button9999999);
		
		
		
		// 8. Sayfa
		JPanel sayfa8 = new JPanel();
		tabbedPane.addTab("        8. Sayfa       ", null, sayfa8, null);
		sayfa8.setBackground(Color.BLACK);
		sayfa8.setLayout(null);
		
		
		JPanel panel_00000000 = new JPanel();
		panel_00000000.setLayout(null);
		panel_00000000.setToolTipText("");
		panel_00000000.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_00000000.setBackground(Color.BLACK);
		panel_00000000.setBounds(10, 33, 170, 200);
		sayfa8.add(panel_00000000);
		
		JButton button00000000 = new JButton("");
		Image iiiiiiiimg = new ImageIcon(this.getClass().getResource("/tasarimlar.jpg")).getImage();
		button00000000.setIcon(new ImageIcon(iiiiiiiimg));
		button00000000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				new IzlemeEkrani("71", eposta).setVisible(true);
				
			}
		});
		button00000000.setBounds(10, 11, 150, 178);
		panel_00000000.add(button00000000);
		
		JPanel panel_11111111 = new JPanel();
		panel_11111111.setLayout(null);
		panel_11111111.setToolTipText("");
		panel_11111111.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_11111111.setBackground(Color.BLACK);
		panel_11111111.setBounds(187, 33, 170, 200);
		sayfa8.add(panel_11111111);
		
		JButton button11111111 = new JButton("");
		Image iiiiiiiimg1 = new ImageIcon(this.getClass().getResource("/basketball.jpg")).getImage();
		button11111111.setIcon(new ImageIcon(iiiiiiiimg1));
		button11111111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("72", eposta).setVisible(true);
			}
		});
		button11111111.setBounds(10, 11, 150, 178);
		panel_11111111.add(button11111111);
		
		JPanel panel_22222222 = new JPanel();
		panel_22222222.setLayout(null);
		panel_22222222.setToolTipText("");
		panel_22222222.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_22222222.setBackground(Color.BLACK);
		panel_22222222.setBounds(363, 33, 170, 200);
		sayfa8.add(panel_22222222);
		
		JButton button22222222 = new JButton("");
		button22222222.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("73", eposta).setVisible(true);
			}
		});
		Image iiiiiiiimg2 = new ImageIcon(this.getClass().getResource("/big_family.jpg")).getImage();
		button22222222.setIcon(new ImageIcon(iiiiiiiimg2));
		button22222222.setBounds(10, 11, 150, 178);
		panel_22222222.add(button22222222);
		
		JPanel panel_33333333 = new JPanel();
		panel_33333333.setLayout(null);
		panel_33333333.setToolTipText("");
		panel_33333333.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 0, 0)));
		panel_33333333.setBackground(Color.BLACK);
		panel_33333333.setBounds(539, 33, 170, 200);
		sayfa8.add(panel_33333333);
		
		JButton button33333333 = new JButton("");
		Image iiiiiiiimg3 = new ImageIcon(this.getClass().getResource("/kulubeler.jpg")).getImage();
		button33333333.setIcon(new ImageIcon(iiiiiiiimg3));
		button33333333.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IzlemeEkrani("74", eposta).setVisible(true);
			}
		});
		button33333333.setBounds(10, 11, 150, 178);
		panel_33333333.add(button33333333);
		

	}
}
