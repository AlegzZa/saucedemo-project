package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import test.data.Errors;
import test.data.URL;

public class LogoutTest extends BaseTest{
      
	@Before @Override
	public void before() {
		super.before();
		loginpage.authenticate(adminuser);
	}
	//Seventh Requirement: Log out
	@Test @Ignore //////////////TEST SIMULATES A LOGGED OUT USER AFTER AN EXPIRED SESSION OF 10 MINUTES/////////////////
	
	public void doesLogoutAfterExpiredSessionWork() throws InterruptedException {
		Thread.sleep(600000);
		productspage.clickOnNameOfProduct();
		assertEquals(Errors.ERROR_LOGGED_OUT_USER,loginpage.textOfErrorContainer());
	}
	@Test 
	public void doesLogoutWork() {
		menu.clickOnMenuIcon();
		menu.clickOnLogoutButton();
		assertEquals(URL.LOGIN, loginpage.isURLOfPageCorrect());
		assertTrue(loginpage.isPasswordFieldEnabled());
		assertTrue(loginpage.isUsernameFieldEnabled());
		assertTrue(loginpage.isLoginButtonEnabled());

	}
}
