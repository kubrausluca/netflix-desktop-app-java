package proje;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class KullaniciIslemleri {

	private Connection con = null;

	private Statement statement = null;
	private PreparedStatement preparedStatement = null;

	public boolean kullaniciGirisYap(String email, String parola) {

		System.out.println(email);
		System.out.println(parola);

		try {

			String sorgu = "Select * from kullanici where email = ? and sifre = ?";

			preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

			preparedStatement.setString(1, email);
			preparedStatement.setString(2, parola);

			System.out.println(sorgu);

			ResultSet rs = preparedStatement.executeQuery();

			return rs.next();

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	public boolean kullaniciKayit(String ad, String email, String sifre, Date dogum_tarihi) {

		try {

			// Yeni kullanýcý ekleme
			// INSERT INTO `kullanici`(`id`, `ad`, `email`, `sifre`, `dogum_tarihi`) VALUES
			// (null, "mustafa", "mustafa@gmail.com", "5696", "2020-20-02")
			String sorgu = "INSERT INTO `kullanici`(`id`, `ad`, `email`, `sifre`, `dogum_tarihi`)  VALUES (null, ?, ?, ?, ?)";

			preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

			preparedStatement.setString(1, ad);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, sifre);
			preparedStatement.setDate(4, dogum_tarihi);

			System.out.println(sorgu);

			int rs = preparedStatement.executeUpdate();

			return true;

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	public boolean kayitKontrol(String email) {

		System.out.println(email);

		try {

			String sorgu = "Select * from kullanici where email = ?";

			preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

			preparedStatement.setString(1, email);

			System.out.println(sorgu);

			ResultSet rs = preparedStatement.executeQuery();

			return rs.next();

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	public boolean kayitKontrol2(String email, String sifre) {

		System.out.println(email);
		System.out.println(sifre);

		try {

			String sorgu = "Select * from kullanici where email = ? and sifre = ?";

			preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

			preparedStatement.setString(1, email);
			preparedStatement.setString(2, sifre);

			System.out.println(sorgu);

			ResultSet rs = preparedStatement.executeQuery();

			return rs.next();

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	// Listem'e kayýt ekleme
	public boolean listemeEkle(String kullaniciID, String programID, Date izlemeTarihi, String izleme_suresi,
			String bolum, String puan) {

		System.out.println(kullaniciID);
		System.out.println(programID);
		System.out.println(izlemeTarihi);
		System.out.println(izleme_suresi);
		System.out.println(bolum);
		System.out.println(puan);

		try {

			// INSERT INTO `kullanici_program`(`kullaniciID`, `programID`, `izleme_tarihi`,
			// `izleme_suresi`, `bolum`, `puan`)
			// VALUES (1,1,2020-05-05,"00:02:18",1,5)

			preparedStatement = null;

			/*
			 * String sorgu =
			 * "INSERT INTO  `kullanici_program`(`kullaniciID`, `programID`, `izleme_tarihi`, `izleme_suresi`, `bolum`, `puan`)"
			 * + "  VALUES( " + kullaniciID + ", " + programID + ", \"" + izlemeTarihi +
			 * "\", \"" + izleme_suresi + "\", " + bolum + ", " + puan + ")";
			 */

			String sorgu = "INSERT INTO  `kullanici_program`(`kullaniciID`, `programID`, `izleme_tarihi`, `izleme_suresi`, `bolum`, `puan`)"
					+ "  VALUES(?, ?, ?, ?, ?, ?)";

			preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

			preparedStatement.setString(1, kullaniciID);
			preparedStatement.setString(2, programID);
			preparedStatement.setDate(3, izlemeTarihi);
			preparedStatement.setString(4, izleme_suresi);
			preparedStatement.setString(5, bolum);
			preparedStatement.setString(6, puan);

			System.out.println(sorgu);

			int rs = preparedStatement.executeUpdate();

			return true;

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	// Listem'den kayýt çýkarma
	public boolean listemdenCikar(String kullaniciID, String programID) {

		System.out.println(kullaniciID);
		System.out.println(programID);

		try {

			preparedStatement = null;

			/*
			 * String sorgu =
			 * "DELETE FROM `kullanici_program` WHERE kullaniciID = 1 and programID = 15"
			 */

			String sorgu = "DELETE FROM `kullanici_program` WHERE kullaniciID = ? and programID = ?";

			preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

			preparedStatement.setString(1, kullaniciID);
			preparedStatement.setString(2, programID);

			System.out.println(sorgu);

			int rs = preparedStatement.executeUpdate();

			return true;

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	public KullaniciIslemleri() {

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

	}

	public static void main(String args[]) {

		KullaniciIslemleri ki = new KullaniciIslemleri();

	}

}
