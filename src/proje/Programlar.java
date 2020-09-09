package proje;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Programlar {

	private Connection con = null;

	private Statement statement = null;
	private PreparedStatement preparedStatement = null;

	public ArrayList<Program> programlariGetir() {

		ArrayList<Program> programlar = new ArrayList<Program>();

		try {

			statement = (Statement) con.createStatement();
			String sorgu = "SELECT ad, sezon, bolum_sayisi, sure, imdb, img FROM `program`  where tip = \"dizi\" or tip = \"tv show\"";

			ResultSet rs = statement.executeQuery(sorgu);

			while (rs.next()) {

				String ad = rs.getString("ad");

				/*
				 * int tur1 = rs.getInt("tur1"); int tur2 = rs.getInt("tur2"); int tur3 =
				 * rs.getInt("tur3");
				 */

				/*
				 * String sql = "SELECT name FROM `turler` WHERE turID = " + tur1; ResultSet
				 * result = statement.executeQuery(sql);
				 * 
				 * while (result.next()) {
				 * 
				 * String tur_name = rs.getString("name"); System.out.println(tur_name); }
				 * 
				 */

				/*
				 * String sql1 = "SELECT name FROM `turler` WHERE turID = " + tur2; String sql2
				 * = "SELECT name FROM `turler` WHERE turID = " + tur3;
				 */

				int sezon = rs.getInt("sezon");
				int bolum_sayisi = rs.getInt("bolum_sayisi");
				int sure = rs.getInt("sure");
				float imdb = rs.getFloat("imdb");
				String img = rs.getString("img");
				img = "/" + img;

				// buradaki çýktýya 1 tane program eklemek için

				programlar.add(new Program(ad, sezon, bolum_sayisi, sure, imdb, img));

			}

			return programlar;

		} catch (Exception e) {
			return null;
		}

	}

	public ArrayList<Program> programlariGetirFilm() {

		ArrayList<Program> programlar = new ArrayList<Program>();

		try {

			statement = (Statement) con.createStatement();
			String sorgu = "SELECT ad, sezon, bolum_sayisi, sure, imdb, img FROM `program`  where tip = \"film\"";

			ResultSet rs = statement.executeQuery(sorgu);

			while (rs.next()) {

				String ad = rs.getString("ad");

				int sezon = rs.getInt("sezon");
				int bolum_sayisi = rs.getInt("bolum_sayisi");
				int sure = rs.getInt("sure");
				float imdb = rs.getFloat("imdb");
				String img = rs.getString("img");
				img = "/" + img;

				// buradaki çýktýya 1 tane program eklemek için

				programlar.add(new Program(ad, sezon, bolum_sayisi, sure, imdb, img));

			}

			return programlar;

		} catch (Exception e) {
			return null;
		}

	}

	// Ýsmine göre dizi arama yapýyoruz
	public ArrayList<Program> DiziArama(String ara) {

		ArrayList<Program> programlar = new ArrayList<Program>();

		ResultSet rs = null;

		// Select * from program where tip = 'dizi' and ad like '%ge%'

		String sorgu = "Select ad, sezon, bolum_sayisi, sure, imdb, img from program where (tip = "
				+ "'dizi' or tip = 'tv show') and ad like '%" + ara + "%'";

		//System.out.println(sorgu);

		try {

			preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
			rs = preparedStatement.executeQuery(sorgu);

			while (rs.next()) {

				String ad = rs.getString("ad");
				int sezon = rs.getInt("sezon");
				int bolum_sayisi = rs.getInt("bolum_sayisi");
				int sure = rs.getInt("sure");
				float imdb = rs.getFloat("imdb");
				String img = rs.getString("img");
				img = "/" + img;

				// buradaki çýktýya 1 tane program eklemek için

				programlar.add(new Program(ad, sezon, bolum_sayisi, sure, imdb, img));

			}

			return programlar;

		} catch (Exception ex) {
			// TODO: handle exception
			// JOptionPane.showMessageDialog(null, ex.getMessage());
			return null;
		}

		// System.out.println(sorgu);

		// String sonuc =

	}

	public ArrayList<Program> FilmArama_Tur(String ara) {

		ArrayList<Program> programlar = new ArrayList<Program>();

		ResultSet rs = null;

		// Select * from program where tip = 'dizi' and ad like '%ge%'

		// Select ad, sezon, bolum_sayisi, sure, imdb, img from program where tip =
		// 'dizi' and tur1 = 1 or tur2 = 1 or tur3 = 1

		String sorgu = "Select ad, sezon, bolum_sayisi, sure, imdb, img from program where tip = "
				+ "'film' and (tur1 = " + ara + " or tur2 = " + ara + " or tur3 = " + ara + ")";

		//System.out.println(sorgu);

		try {

			preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
			rs = preparedStatement.executeQuery(sorgu);

			while (rs.next()) {

				String ad = rs.getString("ad");
				int sezon = rs.getInt("sezon");
				int bolum_sayisi = rs.getInt("bolum_sayisi");
				int sure = rs.getInt("sure");
				float imdb = rs.getFloat("imdb");
				String img = rs.getString("img");
				img = "/" + img;

				// buradaki çýktýya 1 tane program eklemek için

				programlar.add(new Program(ad, sezon, bolum_sayisi, sure, imdb, img));

			}

			return programlar;

		} catch (Exception ex) {
			// TODO: handle exception
			// JOptionPane.showMessageDialog(null, ex.getMessage());
			return null;
		}

		// System.out.println(sorgu);

		// String sonuc =

	}

	public ArrayList<Program> DiziArama_Tur(String ara) {

		ArrayList<Program> programlar = new ArrayList<Program>();

		ResultSet rs = null;

		// Select * from program where tip = 'dizi' and ad like '%ge%'

		// Select ad, sezon, bolum_sayisi, sure, imdb, img from program where tip =
		// 'dizi' and tur1 = 1 or tur2 = 1 or tur3 = 1

		String sorgu = "Select ad, sezon, bolum_sayisi, sure, imdb, img from program where (tip = "
				+ "'dizi'  or tip = 'tv show') and (tur1 = " + ara + " or tur2 = " + ara + " or tur3 = " + ara + ")";

		//System.out.println(sorgu);

		try {

			preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
			rs = preparedStatement.executeQuery(sorgu);

			while (rs.next()) {

				String ad = rs.getString("ad");
				int sezon = rs.getInt("sezon");
				int bolum_sayisi = rs.getInt("bolum_sayisi");
				int sure = rs.getInt("sure");
				float imdb = rs.getFloat("imdb");
				String img = rs.getString("img");
				img = "/" + img;

				// buradaki çýktýya 1 tane program eklemek için

				programlar.add(new Program(ad, sezon, bolum_sayisi, sure, imdb, img));

			}

			return programlar;

		} catch (Exception ex) {
			// TODO: handle exception
			// JOptionPane.showMessageDialog(null, ex.getMessage());
			return null;
		}

		// System.out.println(sorgu);

		// String sonuc =

	}

	public ArrayList<Program> FilmArama(String ara) {

		ArrayList<Program> programlar = new ArrayList<Program>();

		ResultSet rs = null;

		// Select * from program where tip = 'dizi' and ad like '%ge%'

		String sorgu = "Select ad, sezon, bolum_sayisi, sure, imdb, img from program where tip = "
				+ "'film' and ad like '%" + ara + "%'";

		//System.out.println(sorgu);

		try {

			preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
			rs = preparedStatement.executeQuery(sorgu);

			while (rs.next()) {

				String ad = rs.getString("ad");
				int sezon = rs.getInt("sezon");
				int bolum_sayisi = rs.getInt("bolum_sayisi");
				int sure = rs.getInt("sure");
				float imdb = rs.getFloat("imdb");
				String img = rs.getString("img");
				img = "/" + img;

				// buradaki çýktýya 1 tane program eklemek için

				programlar.add(new Program(ad, sezon, bolum_sayisi, sure, imdb, img));

			}

			return programlar;

		} catch (Exception ex) {
			// TODO: handle exception
			// JOptionPane.showMessageDialog(null, ex.getMessage());
			return null;
		}

		// System.out.println(sorgu);

		// String sonuc =

	}

	// Kayýt sýrasýndaki 6 en yüksek puanlý filmi/diziyi getirir.
	public ArrayList<Program> secilenTurleriGetir1(String t1) {

		ArrayList<Program> programlar = new ArrayList<Program>();

		try {

			// SELECT * FROM `program` WHERE tip = 'film' ORDER BY imdb DESC LIMIT 2
			// SELECT * FROM `program` WHERE tip = 'film' and (tur1 = 5 or tur2 = 5 or tur3
			// = 5) ORDER BY imdb DESC LIMIT 2

			statement = (Statement) con.createStatement();
			String sorgu = "SELECT ad, sezon, bolum_sayisi, sure, imdb, img FROM `program`  where tip = \"film\" and (tur1 = " + t1 + " or tur2 = " + t1 + " or tur3 =" + t1 + ") ORDER BY imdb DESC LIMIT 2";

			//System.out.println(sorgu);
			ResultSet rs = statement.executeQuery(sorgu);

			while (rs.next()) {

				String ad = rs.getString("ad");

				/*
				 * int tur1 = rs.getInt("tur1"); int tur2 = rs.getInt("tur2"); int tur3 =
				 * rs.getInt("tur3");
				 */

				/*
				 * String sql = "SELECT name FROM `turler` WHERE turID = " + tur1; ResultSet
				 * result = statement.executeQuery(sql);
				 * 
				 * while (result.next()) {
				 * 
				 * String tur_name = rs.getString("name"); System.out.println(tur_name); }
				 * 
				 */

				/*
				 * String sql1 = "SELECT name FROM `turler` WHERE turID = " + tur2; String sql2
				 * = "SELECT name FROM `turler` WHERE turID = " + tur3;
				 */

				int sezon = rs.getInt("sezon");
				int bolum_sayisi = rs.getInt("bolum_sayisi");
				int sure = rs.getInt("sure");
				float imdb = rs.getFloat("imdb");
				String img = rs.getString("img");
				img = "/" + img;

				// buradaki çýktýya 1 tane program eklemek için

				programlar.add(new Program(ad, sezon, bolum_sayisi, sure, imdb, img));

			}

			return programlar;

		} catch (Exception e) {
			return null;
		}

	}

	public ArrayList<Program> secilenTurleriGetir2(String t2) {

		ArrayList<Program> programlar = new ArrayList<Program>();

		try {

			// SELECT * FROM `program` WHERE tip = 'film' ORDER BY imdb DESC LIMIT 2
			// SELECT * FROM `program` WHERE tip = 'film' and (tur1 = 5 or tur2 = 5 or tur3
			// = 5) ORDER BY imdb DESC LIMIT 2

			statement = (Statement) con.createStatement();
			String sorgu = "SELECT ad, sezon, bolum_sayisi, sure, imdb, img FROM `program`  where tip = \"film\" and (tur1 = " + t2 + " or tur2 = " + t2 + " or tur3 =" + t2 + ") ORDER BY imdb DESC LIMIT 2";

			//System.out.println(sorgu);
			ResultSet rs = statement.executeQuery(sorgu);

			while (rs.next()) {

				String ad = rs.getString("ad");

				/*
				 * int tur1 = rs.getInt("tur1"); int tur2 = rs.getInt("tur2"); int tur3 =
				 * rs.getInt("tur3");
				 */

				/*
				 * String sql = "SELECT name FROM `turler` WHERE turID = " + tur1; ResultSet
				 * result = statement.executeQuery(sql);
				 * 
				 * while (result.next()) {
				 * 
				 * String tur_name = rs.getString("name"); System.out.println(tur_name); }
				 * 
				 */

				/*
				 * String sql1 = "SELECT name FROM `turler` WHERE turID = " + tur2; String sql2
				 * = "SELECT name FROM `turler` WHERE turID = " + tur3;
				 */

				int sezon = rs.getInt("sezon");
				int bolum_sayisi = rs.getInt("bolum_sayisi");
				int sure = rs.getInt("sure");
				float imdb = rs.getFloat("imdb");
				String img = rs.getString("img");
				img = "/" + img;

				// buradaki çýktýya 1 tane program eklemek için

				programlar.add(new Program(ad, sezon, bolum_sayisi, sure, imdb, img));

			}

			return programlar;

		} catch (Exception e) {
			return null;
		}

	}

	public ArrayList<Program> secilenTurleriGetir3(String t3) {

		ArrayList<Program> programlar = new ArrayList<Program>();

		try {

			// SELECT * FROM `program` WHERE tip = 'film' ORDER BY imdb DESC LIMIT 2
			// SELECT * FROM `program` WHERE tip = 'film' and (tur1 = 5 or tur2 = 5 or tur3
			// = 5) ORDER BY imdb DESC LIMIT 2

			statement = (Statement) con.createStatement();
			String sorgu = "SELECT ad, sezon, bolum_sayisi, sure, imdb, img FROM `program`  where tip = \"film\" and (tur1 = " + t3 + " or tur2 = " + t3 + " or tur3 =" + t3 + ") ORDER BY imdb DESC LIMIT 2";

			//System.out.println(sorgu);
			ResultSet rs = statement.executeQuery(sorgu);

			while (rs.next()) {

				String ad = rs.getString("ad");

				/*
				 * int tur1 = rs.getInt("tur1"); int tur2 = rs.getInt("tur2"); int tur3 =
				 * rs.getInt("tur3");
				 */

				/*
				 * String sql = "SELECT name FROM `turler` WHERE turID = " + tur1; ResultSet
				 * result = statement.executeQuery(sql);
				 * 
				 * while (result.next()) {
				 * 
				 * String tur_name = rs.getString("name"); System.out.println(tur_name); }
				 * 
				 */

				/*
				 * String sql1 = "SELECT name FROM `turler` WHERE turID = " + tur2; String sql2
				 * = "SELECT name FROM `turler` WHERE turID = " + tur3;
				 */

				int sezon = rs.getInt("sezon");
				int bolum_sayisi = rs.getInt("bolum_sayisi");
				int sure = rs.getInt("sure");
				float imdb = rs.getFloat("imdb");
				String img = rs.getString("img");
				img = "/" + img;

				// buradaki çýktýya 1 tane program eklemek için

				programlar.add(new Program(ad, sezon, bolum_sayisi, sure, imdb, img));

			}

			return programlar;

		} catch (Exception e) {
			return null;
		}

	}
	
	
	
	public ArrayList<Program> listemdekileriGetir(String kullaniciID) {

		ArrayList<Program> programlar = new ArrayList<Program>();

		try {

			/*
			 * SELECT program.ad, kullanici_program.izleme_tarihi, kullanici_program.izleme_suresi, kullanici_program.bolum, kullanici_program.puan, program.img 
			 * FROM kullanici_program INNER JOIN program on kullanici_program.programID = program.programID WHERE kullanici_program.kullaniciID = 2
			 */
			
			statement = (Statement) con.createStatement();
			
			String sorgu = "SELECT program.ad, kullanici_program.izleme_tarihi, kullanici_program.izleme_suresi, kullanici_program.bolum, kullanici_program.puan, program.img" + 
					" FROM kullanici_program INNER JOIN program on kullanici_program.programID = program.programID WHERE kullanici_program.kullaniciID = " + kullaniciID + " ";
			
			//System.out.println(sorgu);

			ResultSet rs = statement.executeQuery(sorgu);

			while (rs.next()) {

				String ad = rs.getString("ad");
				String izleme_tarihi = rs.getString("izleme_tarihi");
				String izleme_suresi = rs.getString("izleme_suresi");
				int bolum = rs.getInt("bolum");
				int puan = rs.getInt("puan");
				String img = rs.getString("img");
				img = "/" + img;

				// buradaki çýktýya 1 tane program eklemek için

				programlar.add(new Program(ad, izleme_tarihi, izleme_suresi, bolum, puan, img));

			}

			return programlar;

		} catch (Exception e) {
			return null;
		}

	}
	
	
	

	public Programlar() {

		// "jdbc:mysql://localhost:3306/kutuphane
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
			// JOptionPane.showMessageDialog(null, "Baðlantý Baþarýlý...");

		} catch (SQLException ex) {

			System.out.println("Baðlantý Baþarýsýz...");
			// JOptionPane.showMessageDialog(null, "Baðlantý Baþarýsýz...");

		}

	}

	public static void main(String args[]) {

		Programlar prog = new Programlar();

	}

}
