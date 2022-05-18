package service;

import java.util.List;

import exception.ApplicationException;
import exception.SystemException;
import model.AccountPojo;


public interface AccountService {
	
	AccountPojo addAccount(AccountPojo accountPojo)throws SystemException,ApplicationException; ; //Create
	
	AccountPojo updateAccount(AccountPojo accountPojo)throws SystemException,ApplicationException; ; // Update
	
	List<AccountPojo> getAllAccountData()throws SystemException ; // Read
	
	AccountPojo getAAccountData(int accountId, double balance )throws SystemException ; //Read

}
