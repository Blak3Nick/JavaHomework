package account;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {

	BankAccount bankAccount;
	
	@Before
	public void setUp() throws Exception {
		bankAccount = new BankAccount();
	}

	@Test
	public void testDeposit() {
		bankAccount.deposit(100);
		assertEquals(bankAccount.balance, 100, 0.0);
	}

	@Test
	public void testWithdraw() {
		bankAccount.withdraw(100);
		assertEquals(bankAccount.balance, -100, 0.0);
	}

}
