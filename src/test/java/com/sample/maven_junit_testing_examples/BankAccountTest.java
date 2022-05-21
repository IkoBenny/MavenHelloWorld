package com.sample.maven_junit_testing_examples;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountTest {
	@Test
	@Order(4)
	@DisplayName("Test Successful withdraw 300$")
	public void testWithdraw() {
		BankAccount bankAccount = new BankAccount(500, -1000);
		bankAccount.withdraw(300);
		assertEquals(200, bankAccount.getBalance());
	}
	
	@Test
	@Order(3)
	@DisplayName("Test Successful deposit 500$")
	public void testDeposit() {
		BankAccount bankAccount = new BankAccount(400, 0);
		assertEquals(900, bankAccount.deposit(500));
	}
	
	@Test
	@Order(2)
	@DisplayName("Test if bank account is active after creation")
	public void testIsActive() {
		BankAccount bankAccount = new BankAccount(200, 0);
		assertTrue(bankAccount.isActive());
	}
	
	@Test
	@Order(1)
	@DisplayName("Test if account holder name is not null")
	public void testGetHolderName() {
		BankAccount bankAccount = new BankAccount(20,20);
		bankAccount.setHolderName("Mr. Skilled Tester");
		assertNotNull(bankAccount.getHolderName());
	}
	
	@Test
	@DisplayName("Test that we can't withdraw below minimum balance")
	public void testNoWithdrawBelowMinimum() {
		BankAccount bankAccount = new BankAccount(500, -1000);
		assertThrows(RuntimeException.class, () -> bankAccount.withdraw(2000));
	}
	
	@Test
	@DisplayName("Test for no exceptions for withdraw and deposit")
	public void testWithdrawAndDepositWithoutExceptions() {
		BankAccount bankAccount = new BankAccount(500, -1000);
		assertAll(()-> bankAccount.deposit(200), ()-> bankAccount.withdraw(450) );
	}
	
	@Test
	@DisplayName("Test speed of the deposit") 
	public void testDepositSpeed(){
		BankAccount bankAccount = new BankAccount(400, 0);
		assertTimeout(Duration.ofNanos(1), () -> bankAccount.deposit(200));
	}
	
	@Test
	@DisplayName("Test account activation after creation")
	public void testBankAccountActive( ) {
		BankAccount bankAccount = new BankAccount(1200,0);
		assumeTrue(bankAccount != null);
		assumingThat(bankAccount != null, ()-> assertTrue(bankAccount.isActive()));
	}
	
}
