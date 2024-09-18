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
		     //click on logout button
		menu.clickOnMenuIcon();
		//check that the logout button works
		menu.clickOnLogoutButton();
		//1.assert that URL of page is the correct one  
		assertEquals(URL.LOGIN, loginpage.isURLOfPageCorrect());
		//2.that you can interact with the username and password fields
		assertTrue(loginpage.isPasswordFieldEnabled());
		assertTrue(loginpage.isUsernameFieldEnabled());
		//3.assert that you can interact with the login button
		assertTrue(loginpage.isLoginButtonEnabled());

	}
}
