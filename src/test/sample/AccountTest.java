package test.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.sample.Account;

class AccountTest {

	private static Account account;
	private static final float INITIAL_ACCOUNT_BALANACE = 5000;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Create account.");
		account = new Account(INITIAL_ACCOUNT_BALANACE);
	}

//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}

	@BeforeEach
	void setUp() throws Exception {
		account.setBalance(INITIAL_ACCOUNT_BALANACE);
	}

//	@AfterEach
//	void tearDown() throws Exception {
//	}

	@Test
	@DisplayName("Abfrage des Kontostands liefert den richtigen Betrag")
	public void testAccountBalance() {
		double balanceBefore = account.getBalance();
		account.deposit(0);
		assertEquals(balanceBefore, account.getBalance());
	}

	@Test
	@DisplayName("Zwei Einzahlungen werden als Summe gebucht")
	public void depositTest() {
		account.deposit(500);
		account.deposit(200);
		assertEquals(INITIAL_ACCOUNT_BALANACE + 500 + 200, account.getBalance());
	}

	@Test
	@DisplayName("Einzahlung von 0 ändert nicht den Kontostand")
	public void depositZeroTest() {
		// arrange
		double balanceBefore = account.getBalance();
		// act
		account.deposit(0);
		// assert
		assertEquals(balanceBefore, account.getBalance());
	}

	@Test
	@DisplayName("Mehr Geld abheben als auf Konto vorhanden")
	public void tooLowBalanceTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			account.withdraw(account.getBalance() + 1);
		});
	}
}