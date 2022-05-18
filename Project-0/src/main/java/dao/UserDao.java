package dao;

import java.util.List;

import exception.ApplicationException;
import exception.SystemException;
import model.UserPojo;

public interface UserDao {
	
	UserPojo addUser(UserPojo userPojo)throws SystemException, ApplicationException; //Create
	
	UserPojo updateUser(UserPojo userPojo)throws SystemException, ApplicationException; // Update
	
	List<UserPojo> getAllUserData()throws SystemException; // Read
	
	UserPojo getAUserData(int userId, String userName, String userPassword )throws SystemException; //Read

	UserPojo getAUserData(int userAccountNo);
	
	void exitApplication();

}
