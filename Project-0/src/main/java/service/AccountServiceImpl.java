package service;

import java.util.List;
import dao.AccountDao;
import dao.AccountDaoDatabaseImpl;
import exception.ApplicationException;
import exception.SystemException;
import model.AccountPojo;

public class AccountServiceImpl implements AccountService {

	AccountDao accountDao;

	public AccountServiceImpl() {
		accountDao = new AccountDaoDatabaseImpl();
	}



	public AccountDao getAccountDao() {
		return accountDao;
	}



	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	


	@Override
	public AccountPojo addAccount(AccountPojo accountPojo) throws SystemException, ApplicationException {
		
		AccountPojo returnAccountPojo = this.accountDao.addAccount(accountPojo);
		return returnAccountPojo;
	}

	@Override
	public AccountPojo updateAccount(AccountPojo accountPojo) throws SystemException, ApplicationException {
		
		AccountPojo validateAccountPojo = this.accountDao.updateAccount(accountPojo);
		return validateAccountPojo;
	}

	@Override
	public List<AccountPojo> getAllAccountData() throws SystemException {
		
		return accountDao.getAllAccountData();
	}


	@Override
	public AccountPojo getAAccountData(int accountId, double balance) throws SystemException {
		
		return null;
	}

	
	
}
