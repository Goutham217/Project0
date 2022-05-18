package service;

import java.util.List;

import exception.ApplicationException;
import exception.SystemException;
import model.UserPojo;

public interface UserService {
	
	UserPojo addUser(UserPojo userPojo)throws SystemException, ApplicationException;; //Create
	
	UserPojo updateUser(UserPojo userPojo)throws SystemException, ApplicationException;; // Update
	
	List<UserPojo> getAllUserData()throws SystemException; // Read
	
	UserPojo getAUserData(int accountNo, String userName, String userPassword )throws SystemException; //Read

	void exitApplication();

}
