package com.google.login.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface JdbcCallback {

	public Object performOperation(Connection con) throws SQLException;

	
	}

