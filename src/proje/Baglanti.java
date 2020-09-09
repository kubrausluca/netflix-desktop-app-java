package proje;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Baglanti {

	private Connection con = null;

	private Statement statement = null;

	public Baglanti() {

		// "jdbc:mysql://localhost:3306/netflix
		// String url = "jdbc:mysql://" + host + ":" + port + "/" + db_name +
		// "?useUnicode=true&characterEncoding=utf8";

		String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_name
				+ "?useUnicode=true&characterEncoding=utf8";

		try {

			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException ex) {

			System.out.println("Driver Bulunamad�....");

		}

		try {

			//con = (Connection) DriverManager.getConnection(url, kullanici_adi, parola);
			con = (Connection) DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);
			// System.out.println("Ba�lant� Ba�ar�l�...");
			JOptionPane.showMessageDialog(null, "Ba�lant� Ba�ar�l�...");

		} catch (SQLException ex) {

			// System.out.println("Ba�lant� Ba�ar�s�z...");
			JOptionPane.showMessageDialog(null, "Ba�lant� Ba�ar�s�z...");

		}

	}

	public static void main(String args[]) {

		Baglanti baglanti = new Baglanti();

	}

}
