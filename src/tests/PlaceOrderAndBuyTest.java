package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import test.data.Messages;
import test.data.Titles;
import test.data.URL;

public class PlaceOrderAndBuyTest extends BaseTest {

	
	//Fifth Requiremenet: 5.Create a booking for one product (open a product and check it's details, 
	//add it to cart and check it is on the cart, complete all details, 
	//check the order status and details, complete order and check provided data)
	@Test
	
	public void addProductToCartAndBuyIt() {
		loginpage.authenticate(adminuser);
		
		productspage.clickOnNameOfProduct();
        assertTrue(backtoproductspage.imageIsDisplayed());		
        assertEquals(product.getProduct(),backtoproductspage.returnNameOfProduct()); 
        assertEquals(product.getDetails(),backtoproductspage.returnTextWithDetails()); 
        assertEquals(product.getPrice(),backtoproductspage.returnPrice()); 
        
        backtoproductspage.addToCart();
        assertTrue(header.isRedIconOnCartDisplayed());
        assertEquals(Messages.NR_PRODUSE_RED_ICON_ON_CART,header.doesIconHoldNumberOfProducts());
        
        header.clickOnRedIconOnCart();
        assertEquals(Titles.YOUR_CART_PAGE_TITLE,yourcartpage.getTitleOfCartPage());
        assertTrue(yourcartpage.isSquareBoxWithNoOfProductsVisible());
        assertEquals(Messages.NR_PRODUSE_SQUARE_BOX,yourcartpage.getNumberOfProductsInSquareBox());
        assertEquals(product.getProduct(),yourcartpage.returnNameOfProduct()); 
        assertEquals(product.getDetails(),yourcartpage.returnTextWithDetails()); 
        assertEquals(product.getPrice(),yourcartpage.returnPrice());
        assertEquals(Messages.TITLE_OF_QUANTITY,yourcartpage.isQuantityTitle());
        assertEquals(Messages.TITLE_OF_DESCRIPTION,yourcartpage.isDescriptionTitle());
        assertTrue(yourcartpage.isCheckoutButtonDisplayed());
        assertEquals(URL.YOUR_CART, yourcartpage.isURLOfPageCorrect());
        
        yourcartpage.clickOnCheckoutButton();
        checkoutYourInformationPage.enterFirstName(client.getFirstName());
        checkoutYourInformationPage.enterLastName(client.getLastName());
        checkoutYourInformationPage.enterPostalCode(client.getPostCode());
        checkoutYourInformationPage.clickContinueButton();
           
        driver.navigate().back();
        adminuser.setFirstName("A");
        checkoutYourInformationPage.enterFirstName(adminuser.getFirstName());
        adminuser.setLastName("z");
        checkoutYourInformationPage.enterLastName(adminuser.getLastName());
        adminuser.setPassword("9");
        checkoutYourInformationPage.enterPostalCode(adminuser.getPostCode());
        checkoutYourInformationPage.clickContinueButton();
        
                
        driver.navigate().back();
        checkoutYourInformationPage.enterFirstName(adminuser.getFirstName());
        checkoutYourInformationPage.enterLastName(adminuser.getLastName());
        checkoutYourInformationPage.enterPostalCode(adminuser.getPostCode());
        checkoutYourInformationPage.clickContinueButton();
        
         
        assertEquals(orderdetails.getPaymentInformation(), checkoutoverviewpage.isTextOfPaymentInformation());
        assertEquals(orderdetails.getShippingInformation(), checkoutoverviewpage.isShippingInformation());
        assertEquals(orderdetails.getItemTotal(), checkoutoverviewpage.isItemTotal());
        assertEquals(orderdetails.getTax(), checkoutoverviewpage.isTax());
        assertEquals(orderdetails.getTotalPrice(), checkoutoverviewpage.isTotal());
        

        assertEquals(Titles.CHECKOUT_OVERVIEW,checkoutoverviewpage.getTitleStatus());
        assertEquals(Messages.FINISH_BUTTON, checkoutoverviewpage.isNameOfButton());
        assertEquals(URL.CHECKOUT_STEP_TWO, checkoutoverviewpage.isURLOfPageCorrect());

        assertEquals(checkoutoverviewpage.getTotalDouble(), checkoutoverviewpage.isSum());
        
        
        checkoutoverviewpage.clickFinishButton();
       
        assertEquals(Titles.CHECKOUT_COMPLETE,checkoutcompletepage.isTitleOfCompletedOrder());
        assertTrue(checkoutcompletepage.isCheckedIconDisplayed());
        assertEquals(Messages.THANK_YOU_EXCLAMATION,checkoutcompletepage.isThankYouSentence());
        assertEquals(Messages.TEXT_COMPLETE_ORDER,checkoutcompletepage.isText());
        assertEquals(Messages.BACK_HOME_BUTTON,checkoutcompletepage.isNameOfBackHomeButton());
        assertEquals(URL.CHECKOUT_COMPLETE, checkoutcompletepage.isURLOfPageCorrect());


	} 
	
}
