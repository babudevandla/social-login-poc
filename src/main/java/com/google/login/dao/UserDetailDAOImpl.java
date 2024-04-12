package com.google.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.google.login.model.UserTowFactAuth;
import com.google.login.model.UsersVo;

@Repository("userDetailDAO")
public class UserDetailDAOImpl extends JdbcTemplate implements UserDetailDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDetailDAOImpl.class);
	
	@Autowired
	GenericService service;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("UserDetailDAOImpl::loadUserByUsername::username::"+username);
		
		UsersVo user = null;
		
		ResultSetHandler<UsersVo> rsh = new BeanHandler<>(UsersVo.class);
		user = (UsersVo) service.getTypes("select u.username, ro.role as userRole from users u join roles ro where u.roleid=ro.roleid and u.username=?", 
				rsh, username);
		
		if(user!=null) {
			Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
	        
	         authorities.add(new SimpleGrantedAuthority(user.getUserRole()));
	        
			if(null!=authorities && authorities.size()>0){
	        	user.setAuthorities(authorities);
			}
			
		}
		
		logger.info("UserDetailDAOImpl::loadUserByUsername::user details::"+user);
		
		return user;
	}
	
	
	public UserTowFactAuth getUserDetails(String username) throws UsernameNotFoundException {
		logger.info("UserDetailDAOImpl::user tow factor authentication dtails for::username::"+username);
		return (UserTowFactAuth) executeReadOperation(new JdbcCallback() {
			@Override
			public Object performOperation(Connection con) throws SQLException {
				UserTowFactAuth user2fa = null;
				List<String> roles;
				String user_query = "select username, secret, twofaenabled from user_two_fact_auth_dtls where username=?";
				QueryRunner run = new QueryRunner();
				ResultSetHandler<UserTowFactAuth> rsh = new BeanHandler<>(UserTowFactAuth.class);
				user2fa = run.query(con, user_query, rsh, username);
		       
				logger.info("UserDetailDAOImpl::loadUserByUsername::user tow factor authentication details::"+username);
				return user2fa;
			}
		});
	}
	
	/*public User getUserDetails(String username) throws UsernameNotFoundException {
		logger.info("UserDetailDAOImpl::loadUserByUsername::username::"+username);
		return (User) executeReadOperation(new JdbcCallback() {
			@Override
			public Object performOperation(Connection con) throws SQLException {
				User user = null;
				List<String> roles;
				String user_query = "select u.username, u.password,u.enabled,u.accountNonExpired,u.accountNonLocked,u.credentialsNonExpired"
						+ ",ur.role as authority, u.secret, u.twofaenabled "
						+ "from users u join user_roles ur where u.username=ur.username and  u.username=?";
				String user_roles="select  role from user_roles where username=?";
				QueryRunner run = new QueryRunner();
				ResultSetHandler<User> rsh = new BeanHandler<>(User.class);
				ResultSetHandler<List<String>> rolersh = new ColumnListHandler<>() ;
				user = run.query(con, user_query, rsh, username);
				//user =getUser(con, user_query, username);
				roles= run.query(con, user_roles,rolersh,username);
		        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		        for(String role: roles){
		            authorities.add(new SimpleGrantedAuthority(role));
		        }
		        if(null!=authorities && authorities.size()>0){
		        	user.setAuthorities(authorities);
				}
				System.out.println("UserDetailDAOImpl::loadUserByUsername::user details::"+user);
				logger.info("UserDetailDAOImpl::loadUserByUsername::user details::"+user);
				return user;
			}
		});
	}*/

	/*protected User getUser(Connection con, String user_query,
			String username) {

		return 	(User) executeReadOperation(c->{
			User user =new User();
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			try{
				ps=c.prepareStatement(user_query);
				ps.setString(1, username);
				rs = ps.executeQuery();
				
				while(rs.next()){
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
				}
			}catch(SQLException e){e.printStackTrace();}
			
			return user;
			
		});
	}
*/
	@Override
	public Integer updateSecretCode(UserTowFactAuth user) {

		return  (Integer) executeWriteOperation(new JdbcCallback() {
			@Override
			public Object performOperation(Connection con) throws SQLException {
				String query="update user_two_fact_auth_dtls set secret=? where username=?";
				Integer result=null;
				PreparedStatement ps = null;
				try{
					
					ps=con.prepareStatement(query);
					ps.setString(1, user.getSecret());
					ps.setString(2, user.getUsername());
					result =ps.executeUpdate();
				}catch(SQLException e){e.printStackTrace();}
				finally{
					ps.close();
				}
				
				return result;
			}
		});
		
	}

	@Override
	public Integer EnableTwoFa(UserTowFactAuth user) {

		return  (Integer) executeWriteOperation(new JdbcCallback() {
			@Override
			public Object performOperation(Connection con) throws SQLException {
				String query="update user_two_fact_auth_dtls set twofaenabled=? where username=?";
				Integer result=null;
				PreparedStatement ps = null;
				try{
					
					ps=con.prepareStatement(query);
					ps.setBoolean(1, true);
					ps.setString(2, user.getUsername());
					result =ps.executeUpdate();
				}catch(SQLException e){e.printStackTrace();}
				finally{
					ps.close();
				}
				
				return result;
			}
		});
		
	}

	@Override
	public Integer insertUserDetails(UserTowFactAuth user) {
		// TODO Auto-generated method stub
		
		return  (Integer) executeWriteOperation(new JdbcCallback() {
			@Override
			public Object performOperation(Connection con) throws SQLException {
				String query="insert into user_two_fact_auth_dtls (username) values(?)";
				Integer result=null;
				PreparedStatement ps = null;
				try{
					
					ps=con.prepareStatement(query);
					ps.setString(1, user.getUsername());
					/*ps.setString(2, user.getSecret());
					ps.setString(3, "");*/
					result =ps.executeUpdate();
				}catch(SQLException e){e.printStackTrace();}
				finally{
					ps.close();
				}
				
				return result;
			}
		});
		
		
	}
}
