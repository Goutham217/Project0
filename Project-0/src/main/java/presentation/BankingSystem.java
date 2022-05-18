package presentation;

import java.util.Scanner;
import dao.AccountDao;
import dao.UserDao;
import exception.ApplicationException;
import exception.SystemException;
import model.AccountPojo;
import model.UserPojo;
import service.AccountService;
import service.AccountServiceImpl;
import service.UserService;
import service.UserServiceImpl;

public class BankingSystem {
	


	public static void main(String[] args) throws ApplicationException {
		
		
		UserService userService = new UserServiceImpl();
		AccountService accountService = new AccountServiceImpl();
		Scanner scan = new Scanner(System.in);
		
		int option = 0;

		String ch = "y";
		
		while("y".equals(ch)){
		
		System.out.println("********************************************");
		System.out.println("Welcome to Revature Banking Application");
		System.out.println("1. Register as new user");
		System.out.println("2. Login with Credentials");
		System.out.println("3. Exit");
		System.out.println("********************************************");
		System.out.println("Enter your Option");
		System.out.println("********************************************");
		option = Integer.parseInt(scan.nextLine());
		System.out.println("********************************************");
		switch(option) {
		
			case 1:
			
			
				UserPojo registerUserPojo = new UserPojo();
				AccountPojo registerAccountPojo = new AccountPojo();
				
				System.out.println("Enter user first_name:");
				registerUserPojo.setUserFirstName(scan.nextLine());
				
				System.out.println("Enter user last name:");
				registerUserPojo.setUserLastName(scan.nextLine());
				
				System.out.println("Enter user password:");
				registerUserPojo.setUserPassword(scan.nextLine());
				
				 
					System.out.println("**********************************");
					System.out.println("Choose the type of banking account:");
					System.out.println("**********************************");
					System.out.println("1. Checking");
					System.out.println("2. Savings");
					System.out.println("**********************************");
					System.out.println("Enter your option:");
				int typeOption = Integer.parseInt(scan.nextLine());
				System.out.println("**********************************");
				
				if(typeOption == 1) {
					
					registerUserPojo.setUserAccountType("checking");
					registerAccountPojo.setAccountType("checking");
					registerAccountPojo.setBalance(0);
					System.out.println("Your user ID is___" +registerUserPojo.getUserId());
					System.out.println("Initial Balance is__" +registerAccountPojo.getBalance());
					System.out.println();
					System.out.println("Registered Successfully Login with Credentials");
					System.out.println("*****************************");
					
				}
				else if(typeOption == 2) {
					
					registerUserPojo.setUserAccountType("savings");
					registerAccountPojo.setAccountType("savings");
					registerAccountPojo.setBalance(0);
					System.out.println("Your user ID is___" +registerUserPojo.getUserId());
					System.out.println("Initial Balance is__" +registerAccountPojo.getBalance() );
					System.out.println("*****************************");
					System.out.println("Registered Successfully Login with Credentials");
					System.out.println("*****************************");
					
					}
				
				 
				registerUserPojo.setUserRemoved(false);
				UserPojo returnedUserPojo = null;
				try {
				returnedUserPojo = userService.addUser(registerUserPojo);
				} catch (SystemException e1) {
					
					System.out.println("**********************************");
					System.out.println("Sorry!! There is some issue with the database...");
					System.out.println("Please try after sometime....");
					System.out.println("**********************************");
				
				e1.printStackTrace();
				}
				 
					break;
		
		
				

			case 2:
				UserPojo userLoginPojo = new UserPojo();
				AccountPojo accountLoginPojo = new AccountPojo();
				
				System.out.println("Enter user id:");
				userLoginPojo.setUserId(Integer.parseInt(scan.nextLine()));
				
				
				System.out.println("Enter user password:");
				userLoginPojo.setUserPassword(scan.nextLine());
				
				UserPojo returnedLoginUserPojo = null;
				try {
					returnedLoginUserPojo = userService.addUser(userLoginPojo);
				} catch (SystemException e) {
					System.out.println("**********************************");
					System.out.println("Sorry!! There is some issue with the database...");
					System.out.println("Please try after sometime....");
					System.out.println("**********************************");
					
					break;
				}
				
				
				String userType = returnedLoginUserPojo.getUserAccountType();
				int userId = returnedLoginUserPojo.getUserId();
				if(userType !=null && userType.equals("checking")) {
					System.out.println("**********************************");
					System.out.println("You have logged into your Checking Account");
					scan.nextLine();
					
				}else if(userType!=null && userType.equals("savings")) {
					System.out.println("**********************************");
					System.out.println("You have logged into your Savings Account");
					
				}else if(userId== 0){
					System.out.println("**********************************");
					System.out.println("Login failed!!");
					System.out.println("**********************************");
				}
			
				
				System.out.println("*****************************");
				System.out.println("Login Successful");
				System.out.println("*****************************");
				System.out.println("Select an option to proceed further");
				System.out.println("4.Withdraw");
				System.out.println("5.Deposit");
				System.out.println("6.Check Balance");
				System.out.println("7.View Transaction History");
				System.out.println("8.Exit");
				System.out.println("*****************************");
				System.out.println("Input: ");
				option = Integer.parseInt(scan.nextLine());
				
			
			switch (option) {
				case 4:

				System.out.println("4.Enter Amount to Withdraw");
				option = Integer.parseInt(scan.nextLine());	
				System.out.println("*****************************");
				System.out.println("Amount Withdrawn Successfully");
				System.out.println("*****************************");
				System.exit(0);
				break;
				
				
				case 5: 
				System.out.println("5.Enter Amount to Deposit");
				option = Integer.parseInt(scan.nextLine());
				System.out.println("*****************************");
				System.out.println("Amount Deposited Successfully");
				System.out.println("*****************************");
				System.exit(0);
				break;
				
				
				
				case 6: 
				System.out.println("6.Check Balance");
				option = Integer.parseInt(scan.nextLine());
				System.out.println("*****************************");
				System.out.println("Your Current Account Balance is");
				System.out.println("*****************************");
				System.exit(0);
				break;
				
				
				case 7: 
				System.out.println("Your Transaction History");
				option = Integer.parseInt(scan.nextLine());
				System.out.println("*****************************");
				System.out.println("Your Current Statement");
				System.out.println("*****************************");
				System.exit(0);
				break;
			
				
				case 8: 
					System.out.println("8.Thank you for using Revature Banking Application!!");
					System.exit(0);
					
					break;
				
			case 3:
				System.out.println("*******************************************************************");
				System.out.println("Thank you for using Revature Banking Application!!");
				System.out.println("*******************************************************************");
				System.exit(0);
				
		
		
		default:
			
		}
		
	}
		System.out.println("********************************************");
		System.out.println("Welcome to Revature Banking Application");
		System.out.println("1. Register as new user");
		System.out.println("2. Login with Credentials");
		System.out.println("3. Exit");
		System.out.println("********************************************");
		System.out.println("Enter your Option");
		System.out.println("********************************************");
		option = Integer.parseInt(scan.nextLine());
		System.out.println("********************************************");
		}
	
	}
}
	

		
	




