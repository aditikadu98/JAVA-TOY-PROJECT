package database_connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtility extends DbCredential {

	public static Connection getNetwork() throws Exception {
		try {

			Class.forName(driverName);
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			throw new Exception(e);

		}

	}

}