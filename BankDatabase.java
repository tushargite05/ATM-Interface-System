import java.util.ArrayList;

// BankDatabase.java
// Represents the bank account information database 

public class BankDatabase
{
   static ArrayList<Account> accounts = new ArrayList<Account>() ; // array of Accounts
   
   
   
   // no-argument BankDatabase constructor initializes accounts
   public BankDatabase()
   {
      //The original array has been changed into an arraylist, this makes it easier to add/delete from the database
      Account accounts1 = new Account("Tushar Gite", 1800340407, 11111, 30000.0, 50000.0, 0);
      Account accounts2 = new Account("Pranav Pawar", 1800340423, 22222, 20000.0, 30000.0, 0);
      Account accounts3 = new Account("Anurag Kotwal", 1800340454, 33333, 100000.0, 102000.0, 0);
      Account accounts4 = new Account("Manager", 5252, 00000, 0, 0, 1);
      accounts.add(accounts1);
      accounts.add(accounts2);
      accounts.add(accounts3);
      accounts.add(accounts4);
   } // end no-argument BankDatabase constructor
   
   // retrieve Account object containing specified account number
   public Account getAccount(int accountnumber)
   {
      // loop through accounts searching for matching account number
      for (Account currentAccount : accounts)
      {
         // return current account if match found
         if (currentAccount.getAccountNumber() == accountnumber)
            return currentAccount;
      } // end for

      return null; // if no matching account was found, return null
   } // end method getAccount
   
   private Account getAccountpin(int PIN)
   {
      // loop through accounts searching for matching account number
      for (Account currentAccount : accounts)
      {
         // return current account if match found
         if (currentAccount.GetPin() == PIN)
            return currentAccount;
      } // end for

      return null; // if no matching account was found, return null
   } //

   // determine whether user-specified account number and PIN match
   // those of an account in the database
   public boolean authenticateUser(int userPIN)
   {
      // attempt to retrieve the account with the account number
      Account userAccount = getAccountpin(userPIN);

      // if account exists, return result of Account method validatePIN
      if (userAccount != null)
         return userAccount.validatePIN(userPIN);
      else
         return false; // account number not found, so return false
   } // end method authenticateUser

   // return available balance of Account with specified account number
   public double getAvailableBalance(int userAccountNumber)
   {
      return getAccount(userAccountNumber).getAvailableBalance();
   } // end method getAvailableBalance

   // return total balance of Account with specified account number
   public double getTotalBalance(int userAccountNumber)
   {
      return getAccount(userAccountNumber).getTotalBalance();
   } // end method getTotalBalance

   // credit an amount to Account with specified account number
   public void credit(int userAccountNumber, double amount)
   {
      getAccount(userAccountNumber).credit(amount);
   } // end method credit

   // debit an amount from Account with specified account number
   public void debit(int userAccountNumber, double amount)
   {
      getAccount(userAccountNumber).debit(amount);
   } // end method debit
   public int getadmin(int userAccountNumber)
   {
	   return getAccountpin(userAccountNumber).getISadmin();  
   }
   
   public static Iterator createIterator() {
		return new AccountIterator(accounts);
	}
   
  public int getaccpin(int PIN){
	   for (Account currentAccount : accounts)
	      {
	         // return current account if match found
	         if (currentAccount.GetPin() == PIN)
	            return currentAccount.getAccountNumber();
	         else
	        	 return 1;
	      } // end for
	return PIN;
   }
   
  public static void Adduser(){
	  String name = Screen.Inputfield1.getText();
	  int accountnumber = Integer.parseInt( Screen.Inputfield2.getText() );
	  int pin = Integer.parseInt( Screen.Inputfield4.getText() );
	  int balance = Integer.parseInt( Screen.Inputfield3.getText() );
	  
	  Account newaccount = new Account(name, accountnumber, pin, balance, balance, 0);
	 accounts.add(newaccount);
	 
	 Screen.Inputfield1.setText("");
	 Screen.Inputfield2.setText("");
	 Screen.Inputfield3.setText("");
	 Screen.Inputfield4.setText("");
  }

public static void Deleteuser(int position) {
	accounts.remove(position);
	
}
   
   
   
   
} 