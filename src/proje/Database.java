package proje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Database {

	// sadece veri taban� bilgilerimizin tutuldu�u k�s�m

	public static final String kullanici_adi = "root";		// her yerden ula�abilelim(static) ama hi�bir yerden de�i�tirilmesin(final)
	public static final String parola = "";
	
	public static final String db_name = "netflix2";
	public static final String host = "localhost";
	public static final int port = 3306;
	
	
	
}
