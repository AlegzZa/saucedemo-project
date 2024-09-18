package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BackToProductsPage {
      WebDriver driver;
      
      public BackToProductsPage(WebDriver driver) {
    	  this.driver=driver;
      }
      
    //locators  
      
    private By image=By.xpath("//div[@id=\"inventory_item_container\"]/descendant::img");
    private By titleOfProduct=By.xpath("//div[@id=\"inventory_item_container\"]/descendant::div[@class=\"inventory_details_name large_size\"]");
    private By details=By.xpath("//div[@id=\"inventory_item_container\"]/descendant::div[@class=\"inventory_details_desc large_size\"]");
    private By price=By.xpath("//div[@id=\"inventory_item_container\"]/descendant::div[@class=\"inventory_details_price\"]");
    private By addCartButton=By.xpath("//div[@id=\"inventory_item_container\"]/descendant::button[@id=\"add-to-cart-sauce-labs-backpack\"]");
    private By removeCartButton= By.xpath("//div[@id=\"inventory_item_container\"]/descendant::button[@id=\"remove-sauce-labs-backpack\"]");
    //actions
    public boolean imageIsDisplayed() {
     return	driver.findElement(image).isDisplayed();
    }
    public String returnNameOfProduct() {
    	return driver.findElement(titleOfProduct).getText();
    }
    public String returnPrice() {
    	return driver.findElement(price).getText();
    }
    public String returnTextWithDetails() {
    	return driver.findElement(details).getText();
    }
    
    public void addToCart() {
		 driver.findElement(addCartButton).click();
	}
	
	public void removeFromCart() {
		 driver.findElement(removeCartButton).click();	
	}
	
	public boolean didValueOfAttributeChangeAfterAddingProduct() {
		return driver.findElement(removeCartButton).getAttribute("id").contains("remove");
	}
	public boolean didValueOfAttributeChangeAfterRemovingProduct() {
		return driver.findElement(addCartButton).getAttribute("id").contains("add-to-cart");
	}
}



