package tests;

import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

public class ProductsTest extends BaseTest {
	 @Before @Override
	    public void before() {
	    super.before();
	    loginpage.authenticate(adminuser);
	 }
	@Test
	public void addAndRemoveToCartProductsPage() {
		//Fourth Requirement: Add and remove a product from the cart 
		    //add to cart
		productspage.addToCart();
		//1.assert that a red icon appears on cart 
		assertTrue(header.isRedIconOnCartDisplayed());
		//2.assert that there is a change in value of an attribute
      	assertTrue(productspage.didValueOfAttributeChangeAfterAddingProduct());
		    //remove from cart
		productspage.removeFromCart();
        //2.assert that there is a change in value of an attribute
		assertTrue(productspage.didValueOfAttributeChangeAfterRemovingProduct());
		//3.assert that the red icon  has disappeared
		assertTrue(header.isWaitForInvisibility());
	}
	
	@Test 
	public void addAndRemoveToCartBackToProductsPage() {
		//Fourth Requirement: Add and remove a product from the cart 
	    //open a product
		productspage.clickOnNameOfProduct();
		    //add to cart
		backtoproductspage.addToCart();
		//1.assert that a red icon appears on cart 
		assertTrue(header.isRedIconOnCartDisplayed());
		//2.assert that there is a change in value of an attribute
      	assertTrue(backtoproductspage.didValueOfAttributeChangeAfterAddingProduct());
		    //remove from cart
		backtoproductspage.removeFromCart();
        //2.assert that there is a change in value of an attribute
		assertTrue(backtoproductspage.didValueOfAttributeChangeAfterRemovingProduct());
		//3.assert that the red icon  has disappeared
	    assertTrue(header.isWaitForInvisibility());
	}
	@Test
	public void addAndRemoveToCartYourCartPage() {
		//Fourth Requirement: Add and remove a product from the cart 
		//add a product to cart
        productspage.addToCart();
        //click on the red icon on the cart
        header.clickOnRedIconOnCart();
        //2.assert that there is a change in value of an attribute
     	assertTrue(yourcartpage.didValueOfAttributeChangeAfterAddingProduct());
     	 //remove from cart
     	yourcartpage.removeFromCart();
     	//3.assert that the red icon  has disappeared
	    assertTrue(header.isWaitForInvisibility());
	    //4.assert that the Remove Button has disappeared
     	assertTrue(yourcartpage.isWaitForInvisibilityRemoveButton());
     	
     	}
		
	
	@Test
	public void sortDropDownMenu() {
		//Sixth  Requirement:Filter products based on all options.
		    //assert that sort function of the drop-down menu is working
		assertTrue(productspage.isListSortedFromAToZ());
		assertTrue(productspage.isListSortedFromZToA());
		assertTrue(productspage.isListSortedFromLowestToHighestPrice());
		assertTrue(productspage.isListSortedFromHighestToLowestPrice());

	}
}