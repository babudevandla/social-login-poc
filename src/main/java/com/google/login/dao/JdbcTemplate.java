package com.google.login.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.google.login.controller.AdminLoginController;
import com.google.login.exception.NestJDBCException;

public abstract class JdbcTemplate extends AbstractDAO {
	
	Logger logger=Logger.getLogger(AdminLoginController.class.getName());
	

	public Object executeWriteOperation(JdbcCallback jdbcCallback)
			throws NestJDBCException {
		Object object = null;
		Connection con = null;
		try {
			try {
				con = getConnectionForUpdate();
				con.setAutoCommit(false);
				object = jdbcCallback.performOperation(con);
				con.commit();
				con.setAutoCommit(true);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			try{con.rollback();}catch(SQLException e2){e2.printStackTrace();};
			logger.warn("transaction rolled back "+ e);
			e.printStackTrace();
			throw new NestJDBCException(e);
		} finally {
			//close(con, null, null);
			closeConnection(con);
		}
		return object;
	}
	
	private void closeConnection(Connection con){
		try{if(con!=null)con.close();}catch(SQLException e){}
	}
	public Object executeReadOperation(JdbcCallback jdbcCallback)
			throws NestJDBCException {
		Object object = null;
		Connection con = null;
		try {
			try {
				con = getConnectionForSelect();
				object = jdbcCallback.performOperation(con);	
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			logger.error("Exception in  executeReadOperation"+ e);
			e.printStackTrace();
			throw new NestJDBCException(e);
		} finally {
			closeConnection(con);
		}
		return object;
	}
	
	private Connection getConnectionForSelect() throws SQLException, ClassNotFoundException{
		Connection connection = getDataSource().getConnection();
		connection.setReadOnly(true);
		return connection;
	}
	
	private Connection getConnectionForUpdate() throws SQLException, ClassNotFoundException{

		Connection connection = getDataSource().getConnection();
		if(connection.isReadOnly())
			connection.setReadOnly(false);

		return connection;
	}
	
	
}

