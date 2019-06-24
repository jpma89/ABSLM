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

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	public void testAssetNotNull() {
		assertNotNull(new Object(), "Objekt sollte nicht null sein");
	}
	
	@Test
	public void testAssetNotSame() {
		assertNotSame(new Object(), new Object(), "Die zwei Objekte sollten nicht identisch sein");
	}
	
	@Test
	public void testAssetNull() {
		assertNull(null, "Sollte null sein");
	}
	
	@Test
	@DisplayName("Einzahlung von 0 ändert nicht den Kontostand")
	public void depositZeroTest() {
		//arrange
		Account account = new Account(0);
		double balanceBefore = account.getBalance();
		//act
		account.deposit(0);
		//assert
		assertEquals(balanceBefore, account.getBalance());
	}
}