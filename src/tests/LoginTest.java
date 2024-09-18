package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import config.RandomGenerator;
import test.data.Errors;
import test.data.Titles;

public class LoginTest extends BaseTest {
	
	@Test 
	public void loginValidData() {
		//1.First Requirement: Login with valid data (standard user)
		//login
		loginpage.authenticate(adminuser);
		//Assert login success
			//1.page title is that of the page we logged in to
        assertEquals(Titles.PRODUCTS_PAGE_TITLE, productspage.isProductsPageTitle());
        	//2.logout button is displayed 
        menu.clickOnMenuIcon();
        menu.waitforLogoutToBeVisible();
        assertTrue(menu.LogoutButtonisDisplyed());   
	}
	
	@Test 
	public void loginWithLockedOutUser() {
		//2.Second Requirement: Login with locked-out-user
		//login with locked_out_user data
		adminuser.setUsername("locked_out_user");
		loginpage.authenticate(adminuser);
		
		//Assert elements that appear after entering locked_out_user data
			//1.error text
		assertEquals(Errors.ERROR_LOCKED_OUT_USER,loginpage.textOfErrorContainer());
		    //2.red icons with an x are displayed for both username and password
		assertTrue(loginpage.isIconDisplayed());
		    //3.attribute value is changing, when the login is invalid, for both username and password
		assertTrue(loginpage.isElementInListChangingAttributeValue());
		    //4.red button next to the error message is displayed
		assertTrue(loginpage.isIconNextToErrorMessageDisplayed());					
	}
	
	@Test 

	public void loginInvalidOrMissingUsername() {
		//3.Third Requirement: Login with invalid/missing data (wrong user)
		     //login with invalid username
        String invalidUsernameData= adminuser.getUsername()+ RandomGenerator.stringValue(2);
        adminuser.setUsername(invalidUsernameData);
        loginpage.authenticate(adminuser);
        
		//Assert elements that appear after invalid data
		assertEquals(Errors.ERROR_INVALID_PASSWORD_OR_USERNAME,loginpage.textOfErrorContainer());
		
		//click on  red x button next to error message to make the message and button disappear;
        loginpage.clickIconNextToErrorMessage();
		
             //login with missing username
		loginpage.clearUsername();
        adminuser.setUsername("");
        loginpage.authenticate(adminuser);

		//Assert that password data is missing
		assertTrue(loginpage.isValueAttributeEmptyUsername());
		assertEquals(Errors.ERROR_MISSING_USERNAME,loginpage.textOfErrorContainer());	
        
	}
	@Test                       //////////OPTIONAL///////////
	public void loginInvalidMissingPassword() {
		   //invalid password 
		String invalidPasswordData= adminuser.getPassword()+ RandomGenerator.integerValue(3);
		adminuser.setPassword(invalidPasswordData);
		loginpage.authenticate(adminuser);

		//Assert elements that appear after invalid data
		assertEquals(Errors.ERROR_INVALID_PASSWORD_OR_USERNAME,loginpage.textOfErrorContainer());

		//click on  red x button next to error message to make the message and button disappear;
		loginpage.clickIconNextToErrorMessage();
		
		    //no password
		loginpage.clearPassword();
        adminuser.setPassword("");
        loginpage.authenticate(adminuser);

		//Assert that password data is missing
		assertTrue(loginpage.isValueAttributeEmpty());
		assertEquals(Errors.ERROR_MISSING_PASSWORD,loginpage.textOfErrorContainer());
			
	}
	
}
