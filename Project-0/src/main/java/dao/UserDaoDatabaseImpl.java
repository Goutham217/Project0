package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import exception.ApplicationException;
import exception.SystemException;
import model.UserPojo;

public class UserDaoDatabaseImpl implements UserDao {
	
	public UserPojo addUser(UserPojo userPojo)throws ApplicationException {
		
		Connection conn;
	
		try {
			conn = DBUtil.makeConnection();
			
			Statement stmt = conn.createStatement();
			
			String query = "insert into customer_details (user_password, user_firstname, user_lastname, user_accounttype, user_removed)" + "values('"+userPojo.getUserPassword()+"','"+userPojo.getUserFirstName()+"','"+userPojo.getUserLastName()+"', '"+userPojo.getUserAccountType()+"',"+userPojo.isUserRemoved()+") returning user_id"; 


			ResultSet resultSet = stmt.executeQuery(query);		
			resultSet.next();
			userPojo.setUserId(resultSet.getInt(1));
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(e.getMessage());
		}
		return userPojo;
	}

	@Override
	public UserPojo updateUser(UserPojo userPojo) throws ApplicationException {
		
		Connection conn;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "select * from customer_details where user_id="+userPojo.getUserId()+" and user_password='"+userPojo.getUserPassword()+"' and user_removed=false";
			
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				userPojo.setUserFirstName(rs.getString(3));
				userPojo.setUserLastName(rs.getString(4));
				userPojo.setUserAccountType(rs.getString(5));
				userPojo.setUserRemoved(rs.getBoolean(6));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		
		return userPojo;
	
	}

	@Override
	public List<UserPojo> getAllUserData() throws SystemException {
		
		return null;
	}

	@Override
	public UserPojo getAUserData(int userId, String userName, String userPassword) throws SystemException {
		
		return null;
	}

	@Override
	public UserPojo getAUserData(int userAccountNo) {
		
		return null;
	}

	@Override
	public void exitApplication() {
		DBUtil.closeConnection();
		
	}

}
