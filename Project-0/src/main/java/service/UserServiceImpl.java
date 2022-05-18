package service;

import java.util.List;
import dao.UserDao;
import dao.UserDaoDatabaseImpl;
import exception.ApplicationException;
import exception.SystemException;
import model.UserPojo;

public class UserServiceImpl implements UserService {
	
	UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoDatabaseImpl();
	}
	

	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public UserPojo addUser(UserPojo userPojo)throws ApplicationException, SystemException {
		UserPojo returnUserPojo = this.userDao.addUser(userPojo);
		return returnUserPojo;
	}

	@Override
	public UserPojo updateUser(UserPojo userPojo)throws ApplicationException, SystemException {
		
		UserPojo validateUserPojo = this.userDao.updateUser(userPojo);
		
		return validateUserPojo;
	}

	@Override
	public List<UserPojo> getAllUserData() throws SystemException {
		
		return userDao.getAllUserData();
	}

	@Override
	public UserPojo getAUserData(int userAccountNo, String userName, String userPassword)throws SystemException {
		
		return userDao.getAUserData(userAccountNo, userName, userPassword) ;
	}


	@Override
	public void exitApplication() {
		userDao.exitApplication();
		
	}


}
