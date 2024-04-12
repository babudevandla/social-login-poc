package com.google.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.google.login.model.RolesVo;
import com.google.login.model.UsersVo;

@Repository("userDao")
public class UserRoleDao extends JdbcTemplate implements IUserRoleDao {

	@Autowired
	GenericService service;
	
	@SuppressWarnings("unchecked")
	public boolean createUser(UsersVo user) {
		
		Long id = (Long) service.insertType("insert into users (username,roleid) values (?,?)", new ScalarHandler<Long>(),
				user.getUsername(), user.getRoleId());
		
		return (id!=null);
	}



	@SuppressWarnings("unchecked")
	public List<RolesVo> getRoles(){
		
		List<RolesVo> roles = (List<RolesVo>) service.getTypes("select * from roles", RolesVo.class);
		
		return roles;
	}
	
/*	@Override
	public List<String> getRoles() {
		return (List<String>) executeReadOperation(new JdbcCallback() {
			@Override
			public Object performOperation(Connection con) throws SQLException {
				List<String> roles = new ArrayList<>();
				String query = "select distinct(ROLE) from user_roles";
				QueryRunner run = new QueryRunner();
				ResultSetHandler<List<String>> rsh = new ColumnListHandler<>();

				roles = run.query(con, query, rsh);
				return roles;
			}
		});
	}*/

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getRolesByUserId(String userId) {
		
		return (List<String>) service.getTypes("SELECT ro.role FROM roles ro, users u where ro.roleid=u.roleid and u.username=?", new ColumnListHandler<String>(), userId);
		
	}
	
	public Date getResetTokenDate(String userName, String token) {/*
		return (Date) executeReadOperation(new JdbcCallback() {
			@Override
			public Object performOperation(Connection con) throws SQLException {
				String query = "select restTokenDate from users where username=? and resetToken=?";
				
				QueryRunner run = new QueryRunner();
				ResultSetHandler<java.sql.Timestamp > rsh = new ScalarHandler<>();
				java.sql.Timestamp  resetTokenDate = (Timestamp) run.query(con, query, rsh, userName, token);
				
				if(resetTokenDate!=null){
					Date dateObj = new Date(resetTokenDate.getTime());
					
					return dateObj;
				}
				else{
					return null;
				}
			}
		});
	*/
	
		return null;
	}
	
	@Override
	public boolean checkUserExist(UsersVo user) {
		
		Long count = (Long) service.getTypes("select count(username) from users  where username=?",  new ScalarHandler<Long>(), user.getUsername());
		
		if (count > 0) {
			return true;
		}
		return false;
		
	}

	
	
	
	public static void main(String[] args) {
			String password = "test123";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);
			System.out.println(hashedPassword);
	}

	@Override
	public void logUnautherizedUser(String email, String remarks, String ip) {


		int result =(Integer)executeWriteOperation(new JdbcCallback() {
			@Override
			public Object performOperation(Connection con) throws SQLException {
				QueryRunner run = new QueryRunner();
				
				String uName=null;
				int noOfFialureAttempts =1;
				String selectQuery = "select userid, no_of_attempts from login_failed_dtls where userid =? and remarks=?";
				/*ResultSetHandler<String> rsh = new ScalarHandler<>();
				uName =run.query(con,selectQuery, rsh, email);*/
				
				try{
					PreparedStatement ps = con.prepareStatement(selectQuery);
					ps.setString(1, email);
					ps.setString(2, remarks);
					
					ResultSet rs = ps.executeQuery();
					while(rs.next()){
						uName =rs.getString("userid");
						noOfFialureAttempts= rs.getInt("no_of_attempts")+1;
					}
				}catch(SQLException e){
					System.out.println(e);
				}
				
				String query ="";
				
				java.sql.Timestamp currentDate = null;
				Calendar calendar = Calendar.getInstance();
				currentDate = new java.sql.Timestamp(calendar.getTime().getTime());
				
				if(StringUtils.isEmpty(uName)){
					query = "insert into login_failed_dtls values(?,?,?,?,?,?)";
					return run.update(con, query, email, currentDate,currentDate, noOfFialureAttempts,remarks, ip);
				}else{
					query = "update login_failed_dtls set updated=?, no_of_attempts=?, ip_adress=? where userid =? and remarks=? ";
					return run.update(con, query,currentDate, noOfFialureAttempts,ip, email,remarks);
				}
				
			}
		});
		//return result;
	}


	@Override
	public int updatePassword(String username, String password) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int updateUserToken(String token, String userName) {
		// TODO Auto-generated method stub
		return 0;
	}
}
