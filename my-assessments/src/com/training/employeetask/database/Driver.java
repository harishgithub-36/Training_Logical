package com.training.employeetask.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Driver {

	public static Connection createConnection() {
		Connection myConn = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://192.168.0.156/harish_test", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myConn;

	}

}
