package model;

import java.util.List;

public class UserPojo {

	
	private int userId;
	private String userPassword;
	private String userFirstName;
	private String userLastName;
	private List<AccountPojo> accountPojo;
	private String userAccountType;
	private boolean userRemoved;

	public UserPojo() {
		
	}

	public UserPojo(int userId, String userPassword, String userFirstName, String userLastName,
			List<AccountPojo> accountPojo, String userAccountType, boolean userRemoved) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.accountPojo = accountPojo;
		this.userAccountType = userAccountType;
		this.userRemoved = userRemoved;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public List<AccountPojo> getAccountPojo() {
		return accountPojo;
	}

	public void setAccountPojo(List<AccountPojo> accountPojo) {
		this.accountPojo = accountPojo;
	}

	public String getUserAccountType() {
		return userAccountType;
	}

	public void setUserAccountType(String userAccountType) {
		this.userAccountType = userAccountType;
	}

	public boolean isUserRemoved() {
		return userRemoved;
	}

	public void setUserRemoved(boolean userRemoved) {
		this.userRemoved = userRemoved;
	}

	@Override
	public String toString() {
		return "UserPojo [userId=" + userId + ", userPassword=" + userPassword + ", userFirstName=" + userFirstName
				+ ", userLastName=" + userLastName + ", accountPojo=" + accountPojo + ", userAccountType="
				+ userAccountType + ", userRemoved=" + userRemoved + "]";
	}


	
}
