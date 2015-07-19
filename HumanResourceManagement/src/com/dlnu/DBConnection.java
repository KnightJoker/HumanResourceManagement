package com.dlnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static Connection cn;
	public static Statement st;
	public static ResultSet rs;

	public static boolean joinDB() {
		boolean joinFlag;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "system";
		String pass = "123456";
		try {
			joinFlag = true;
			Class.forName(driver);
			cn = DriverManager.getConnection(url, user, pass);
			st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			return joinFlag;
		} catch (SQLException e) {
			e.printStackTrace();
			joinFlag = false;
			return joinFlag;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			joinFlag = false;
			return joinFlag;
		}
	}

	public static boolean executeSQL(String sqlstring) {
		boolean executeFlag;
		try {
			st.execute(sqlstring);
			executeFlag = true;
		} catch (Exception e) {
			executeFlag = false;
			e.printStackTrace();
		}
		return executeFlag;
	}

	public static boolean query(String sqlstring) {
		try {
			rs = st.executeQuery(sqlstring);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
