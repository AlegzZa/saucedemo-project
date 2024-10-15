package tests;

import static org.junit.Assert.assertEquals;
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
		productspage.addToCart();
		assertTrue(header.isRedIconOnCartDisplayed());
      	assertTrue(productspage.didValueOfAttributeChangeAfterAddingProduct());
		productspage.removeFromCart();
		assertTrue(productspage.didValueOfAttributeChangeAfterRemovingProduct());
		assertTrue(header.isWaitForInvisibility());
	}	
	@Test 
	public void addAndRemoveToCartBackToProductsPage() {
		//Fourth Requirement: Add and remove a product from the cart 
		productspage.clickOnNameOfProduct();
		backtoproductspage.addToCart();
		assertTrue(header.isRedIconOnCartDisplayed());
      	assertTrue(backtoproductspage.didValueOfAttributeChangeAfterAddingProduct());
		backtoproductspage.removeFromCart();
		assertTrue(backtoproductspage.didValueOfAttributeChangeAfterRemovingProduct());
	    assertTrue(header.isWaitForInvisibility());
	}
	@Test
	public void addAndRemoveToCartYourCartPage() {
		//Fourth Requirement: Add and remove a product from the cart 
        productspage.addToCart();
        header.clickOnRedIconOnCart();
     	assertTrue(yourcartpage.didValueOfAttributeChangeAfterAddingProduct());
     	yourcartpage.removeFromCart();
	    assertTrue(header.isWaitForInvisibility());
     	assertTrue(yourcartpage.isWaitForInvisibilityRemoveButton());
     	
     	}	
	@Test
	public void sortDropDownMenu() {
		//Sixth  Requirement:Filter products based on all options.
		assertTrue(productspage.isListSortedFromAToZ());
		assertTrue(productspage.isListSortedFromZToA());
		assertEquals(productspage.isSortedFromLowestToHighestPrice(),productspage.isListSortedFromLowestToHighestPrice());
		assertTrue(productspage.isListSortedFromHighestToLowestPrice());

	}
}