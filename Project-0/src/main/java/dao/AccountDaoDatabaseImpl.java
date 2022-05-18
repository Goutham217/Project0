package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import exception.ApplicationException;
import exception.SystemException;
import model.AccountPojo;

public class AccountDaoDatabaseImpl implements AccountDao{
	
	public AccountPojo addAccount(AccountPojo accountPojo)throws SystemException {
		
		Connection conn;
		
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			
			String query = "insert into account_details (account_id, user_id, balance, account_type)" + "values ('"+accountPojo.getAccountId()+"','"+accountPojo.getUserId()+"','"+accountPojo.getBalance()+"','"+accountPojo.getAccountType()+") returning account_id";
		
			ResultSet resultSet = stmt.executeQuery(query);
			resultSet.next();
			accountPojo.setAccountId(resultSet.getInt(1));
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}
		return accountPojo;
	}

	@Override
	public AccountPojo updateAccount(AccountPojo accountPojo) throws SystemException, ApplicationException {
		Connection conn;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "select * from account_details where account_id="+accountPojo.getAccountId()+" and balance='"+accountPojo.getBalance()+"'";
			
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				accountPojo.setBalance(rs.getDouble(3));
				accountPojo.setAccountType(rs.getString(4));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		
		return accountPojo;
	}

	@Override
	public void deleteAccount(int accountId) throws SystemException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AccountPojo> getAllAccountData() throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountPojo getAAccountData(int accountId) throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

}
