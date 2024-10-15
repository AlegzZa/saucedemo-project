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
		loginpage.authenticate(adminuser);
        assertEquals(Titles.PRODUCTS_PAGE_TITLE, productspage.isProductsPageTitle());
        menu.clickOnMenuIcon();
        menu.waitforLogoutToBeVisible();
        assertTrue(menu.LogoutButtonisDisplyed());   
	}
	
	@Test 
	public void loginWithLockedOutUser() {
		//2.Second Requirement: Login with locked-out-user
		adminuser.setUsername("locked_out_user");
		loginpage.authenticate(adminuser);
		
	
		assertEquals(Errors.ERROR_LOCKED_OUT_USER,loginpage.textOfErrorContainer());
		assertTrue(loginpage.isIconDisplayed());
		assertTrue(loginpage.isElementInListChangingAttributeValue());
		assertTrue(loginpage.isIconNextToErrorMessageDisplayed());					
	}
	@Test 

	public void loginInvalidOrMissingUsername() {
		//3.Third Requirement: Login with invalid/missing data (wrong user)
        String invalidUsernameData= adminuser.getUsername()+ RandomGenerator.stringValue(2);
        adminuser.setUsername(invalidUsernameData);
        loginpage.authenticate(adminuser);
        
		assertEquals(Errors.ERROR_INVALID_PASSWORD_OR_USERNAME,loginpage.textOfErrorContainer());
		
        loginpage.clickIconNextToErrorMessage();
		
		loginpage.clearUsername();
        adminuser.setUsername("");
        loginpage.authenticate(adminuser);

		assertTrue(loginpage.isValueAttributeEmptyUsername());
		assertEquals(Errors.ERROR_MISSING_USERNAME,loginpage.textOfErrorContainer());	
        
	}
	@Test                       //////////OPTIONAL///////////
	public void loginInvalidMissingPassword() {
		   //invalid password 
		String invalidPasswordData= adminuser.getPassword()+ RandomGenerator.integerValue(3);
		adminuser.setPassword(invalidPasswordData);
		loginpage.authenticate(adminuser);

		assertEquals(Errors.ERROR_INVALID_PASSWORD_OR_USERNAME,loginpage.textOfErrorContainer());

		loginpage.clickIconNextToErrorMessage();
		
		loginpage.clearPassword();
        adminuser.setPassword("");
        loginpage.authenticate(adminuser);

		assertTrue(loginpage.isValueAttributeEmpty());
		assertEquals(Errors.ERROR_MISSING_PASSWORD,loginpage.textOfErrorContainer());
			
	}
	
}
