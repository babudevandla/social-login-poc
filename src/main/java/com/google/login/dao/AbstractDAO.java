package com.google.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.google.login.controller.AdminLoginController;


public class AbstractDAO implements ApplicationContextAware{

	Logger logger=Logger.getLogger(AdminLoginController.class.getName());
	@Autowired
	private BasicDataSource dataSource = null;
	
	ApplicationContext context;
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context=context;		
	}
	
	public BasicDataSource getDataSource() {
		if(dataSource==null)
			dataSource = (BasicDataSource)context.getBean("dataSource");
		return dataSource;
	}

	
	public void setDataSource(BasicDataSource dataSource) {
		logger.info(new Date() + ": Setting the datasource for "+dataSource.getUrl() +" with the user "+dataSource.getUsername());
		this.dataSource = dataSource;
	}
	protected void close(PreparedStatement stmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		if(stmt!= null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		rs = null;
		stmt = null;
		

	}
	

	@Deprecated
	protected void close(Connection connection,PreparedStatement stmt,ResultSet rs){
		close(stmt, rs);
		if(connection!=null){
			try {
				 connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		rs = null;
		stmt = null;
		connection = null;

	}
	
	protected void close(Statement stmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		if(stmt!= null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		rs = null;
		stmt = null;		
	}
}
