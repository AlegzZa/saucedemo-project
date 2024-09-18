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
		    //log in
		loginpage.authenticate(adminuser);
		
		    //open a product
		productspage.clickOnNameOfProduct();
		//1.assert that image is displayed
        assertTrue(backtoproductspage.imageIsDisplayed());		
        //2.assert that title of the product  is  that of the the desired one
        assertEquals(product.getProduct(),backtoproductspage.returnNameOfProduct()); 
        //3.assert that text of details is correct
        assertEquals(product.getDetails(),backtoproductspage.returnTextWithDetails()); 
        //4.assert that  the price is correct
        assertEquals(product.getPrice(),backtoproductspage.returnPrice()); 
        
		    //add product on the cart
        backtoproductspage.addToCart();
        //1.assert that the red icon on the cart is displayed
        assertTrue(header.isRedIconOnCartDisplayed());
        //2.assert that the number of products is showed on the red icon on the cart
        assertEquals(Messages.NR_PRODUSE_RED_ICON_ON_CART,header.doesIconHoldNumberOfProducts());
        
            //click on the red icon on the cart to get to Your Cart page
        header.clickOnRedIconOnCart();
            //check that the details on the page are correct
        //1.assert that the  page title is correct
        assertEquals(Titles.YOUR_CART_PAGE_TITLE,yourcartpage.getTitleOfCartPage());
        //2.assert that the square box that holds the number of products is displayed
        assertTrue(yourcartpage.isSquareBoxWithNoOfProductsVisible());
        //3.assert that the square box  holds the  correct number of products 
        assertEquals(Messages.NR_PRODUSE_SQUARE_BOX,yourcartpage.getNumberOfProductsInSquareBox());
        //4.assert that title of product  is that of the desired one
        assertEquals(product.getProduct(),yourcartpage.returnNameOfProduct()); 
        //5.assert that text of details is correct
        assertEquals(product.getDetails(),yourcartpage.returnTextWithDetails()); 
        //6.assert that  the price is correct
        assertEquals(product.getPrice(),yourcartpage.returnPrice());
        //7. assert that the title of quantity is the correct one
        assertEquals(Messages.TITLE_OF_QUANTITY,yourcartpage.isQuantityTitle());
        //8. assert that the title of description is the correct one
        assertEquals(Messages.TITLE_OF_DESCRIPTION,yourcartpage.isDescriptionTitle());
        //9.assert that checkout button is displayed;
        assertTrue(yourcartpage.isCheckoutButtonDisplayed());
        //10.assert that URL is correct 
        assertEquals(URL.YOUR_CART, yourcartpage.isURLOfPageCorrect());
        
             //click on checkout button
        yourcartpage.clickOnCheckoutButton();
            //send personal details of a client that is not the logged in user
        checkoutYourInformationPage.enterFirstName(client.getFirstName());
        checkoutYourInformationPage.enterLastName(client.getLastName());
        checkoutYourInformationPage.enterPostalCode(client.getPostCode());
        checkoutYourInformationPage.clickContinueButton();
           
           //try to send details just a letter/number to see if you can log in
        driver.navigate().back();
        adminuser.setFirstName("A");
        checkoutYourInformationPage.enterFirstName(adminuser.getFirstName());
        adminuser.setLastName("z");
        checkoutYourInformationPage.enterLastName(adminuser.getLastName());
        adminuser.setPassword("9");
        checkoutYourInformationPage.enterPostalCode(adminuser.getPostCode());
        checkoutYourInformationPage.clickContinueButton();
        
            //send personal details of the logged in user
        driver.navigate().back();
        checkoutYourInformationPage.enterFirstName(adminuser.getFirstName());
        checkoutYourInformationPage.enterLastName(adminuser.getLastName());
        checkoutYourInformationPage.enterPostalCode(adminuser.getPostCode());
        checkoutYourInformationPage.clickContinueButton();
        
           //check if the details of the order are correct
        //assert details of order before completing the ordering process
        assertEquals(orderdetails.getPaymentInformation(), checkoutoverviewpage.isTextOfPaymentInformation());
        assertEquals(orderdetails.getShippingInformation(), checkoutoverviewpage.isShippingInformation());
        assertEquals(orderdetails.getItemTotal(), checkoutoverviewpage.isItemTotal());
        assertEquals(orderdetails.getTax(), checkoutoverviewpage.isTax());
        assertEquals(orderdetails.getTotalPrice(), checkoutoverviewpage.isTotal());

           //check status of order
        //1.assert title of the page - part of the status evaluation 
        assertEquals(Titles.CHECKOUT_OVERVIEW,checkoutoverviewpage.getTitleStatus());
        //2.assert that name of the button is finish- part of the status evaluation
        assertEquals(Messages.FINISH_BUTTON, checkoutoverviewpage.isNameOfButton());
        //3.assert that URL is correct 
        assertEquals(URL.CHECKOUT_STEP_TWO, checkoutoverviewpage.isURLOfPageCorrect());

           //assert that total = item price +tax 
        assertEquals(checkoutoverviewpage.getTotalDouble(), checkoutoverviewpage.isSum());
        
        
          //click on finish button
        checkoutoverviewpage.clickFinishButton();
          //assert the success of the completed order
        //1.assert that the title of the page is correct
        assertEquals(Titles.CHECKOUT_COMPLETE,checkoutcompletepage.isTitleOfCompletedOrder());
        //2.assert that the icon of the page is displayed
        assertTrue(checkoutcompletepage.isCheckedIconDisplayed());
        //3.assert that the thank you exclamation is correct
        assertEquals(Messages.THANK_YOU_EXCLAMATION,checkoutcompletepage.isThankYouSentence());
        //4.assert that the text under the exclamation is correct
        assertEquals(Messages.TEXT_COMPLETE_ORDER,checkoutcompletepage.isText());
        //5.assert that the text of the button is back home
        assertEquals(Messages.BACK_HOME_BUTTON,checkoutcompletepage.isNameOfBackHomeButton());
        //6.assert that the URL is correct
        assertEquals(URL.CHECKOUT_COMPLETE, checkoutcompletepage.isURLOfPageCorrect());


	} 
	
}
