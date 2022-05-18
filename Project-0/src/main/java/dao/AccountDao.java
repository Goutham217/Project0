package dao;

import java.util.List;

import exception.ApplicationException;
import exception.SystemException;
import model.AccountPojo;


public interface AccountDao {
	
	AccountPojo addAccount(AccountPojo accountPojo)throws SystemException,ApplicationException ; //Create
	
	AccountPojo updateAccount(AccountPojo accountPojo)throws SystemException, ApplicationException ; // Update
	
	void deleteAccount(int accountId)throws SystemException ; // Delete
	
	List<AccountPojo> getAllAccountData()throws SystemException ; // Read
	
	AccountPojo getAAccountData(int accountId )throws SystemException ; //Read

}
