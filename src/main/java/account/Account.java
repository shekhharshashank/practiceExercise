package account;

import java.util.HashMap;

public class Account {

	/** The account number. */
	private String accountNumber;
	
	/** The name. */
	private String name;
	
	/** The balance. */
	private double balance;
	
	/** The statements. */
	private HashMap<String, Object> statements;

	/**
	 * Instantiates a new account.
	 *
	 * @param accountNumber the account number
	 * @param name the name
	 */
	public Account(String accountNumber, String name) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = 0.0;
		statements = new HashMap<String, Object>();
		statements.put("Name: "+name, "");
		statements.put("Account: "+accountNumber,"" );
		
	}

	/**
	 * Deposits.
	 *
	 * @param code the code
	 * @param amount the amount
	 */
	public void deposits(String code, Double amount) {
		statements.put(code, amount);
		balance = balance + amount;
		statements.put("Balance: "+String.format("%.2f",balance),  "");
	}

	/**
	 * Withdrawals.
	 *
	 * @param code the code
	 * @param amount the amount
	 * @throws Exception the exception
	 */
	public void withDrawals(String code, Double amount) throws Exception {
		statements.put(code, amount);
		if (balance >= amount) {
			balance = balance - amount;
			statements.put("Balance: "+String.format("%.2f",balance),  "");
		} else {
			throw new Exception("Insufficent Balance");
		}

	}
	
	
	/**
	 * Gets the statement details.
	 *
	 * @return the statement details
	 */
	public HashMap<String, Object> getStatementDetails() {
		return statements;
	}
}
