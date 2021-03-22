package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBd {
		
	public static Connection getConnection() {
		try {

			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/academyaccenture", "root",
					"12345");
			return conexao;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
