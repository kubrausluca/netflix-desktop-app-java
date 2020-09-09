package proje;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AcilisEkrani extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcilisEkrani frame = new AcilisEkrani();
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
	public AcilisEkrani() {
		setTitle("NETFL\u0130X");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 20, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		
		Image img = new ImageIcon(this.getClass().getResource("/netflix.jpg")).getImage();
		
		JButton btnOturumA = new JButton("Oturum A\u00E7");
		
		btnOturumA.setBorder(null); 
		btnOturumA.setFocusPainted(false);
		
		btnOturumA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				new Login().setVisible(true);
				
			}
		});
		btnOturumA.setBackground(Color.RED);
		btnOturumA.setForeground(Color.WHITE);
		btnOturumA.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOturumA.setBounds(834, 32, 140, 30);
		contentPane.add(btnOturumA);
		label.setIcon(new ImageIcon(img));
		
		label.setBounds(0, 0, 994, 671);
		contentPane.add(label);
	}
}
