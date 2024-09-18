package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourCartPage {
	WebDriver driver;
	
	public YourCartPage(WebDriver driver) {
		this.driver=driver;
	}
	//locators
	private By pageTitleCart=By.xpath("//div[@class=\"header_secondary_container\"]/span");
	private By squareBoxWithNumberOfProducts=By.xpath("//div[@class=\"cart_contents_container\"]/descendant::div[@class=\"cart_quantity\"]");
	private By titleOfProduct=By.xpath("//div[@id=\"cart_contents_container\"]/descendant::div[@class=\"inventory_item_name\"]");
	private By details=By.xpath("//div[@id=\"cart_contents_container\"]/descendant::div[@class=\"inventory_item_desc\"]");
	private By price=By.xpath("//div[@id=\"cart_contents_container\"]/descendant::div[@class=\"inventory_item_price\"]");
	private By quantityTitle= By.xpath("//div[@class=\"cart_list\"]/div[@class=\"cart_quantity_label\"]");
	private By descriptionTitle= By.xpath("//div[@class=\"cart_list\"]/div[@class=\"cart_desc_label\"]");
	private By checkOutButton= By.id("checkout");
	private By removeCartButton=By.xpath("//div[@id=\"cart_contents_container\"]/descendant::button[@id=\"remove-sauce-labs-backpack\"]");
	
	//actions
	public String getTitleOfCartPage() {
		return driver.findElement(pageTitleCart).getText();
	}
	public boolean isSquareBoxWithNoOfProductsVisible() {
		return driver.findElement(squareBoxWithNumberOfProducts).isDisplayed();
	}
	public String getNumberOfProductsInSquareBox() {
		return driver.findElement(squareBoxWithNumberOfProducts).getText();
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
	public String isQuantityTitle() {
		return driver.findElement(quantityTitle).getText();
	}
	public String isDescriptionTitle() {
		return driver.findElement(descriptionTitle).getText();
	}
	public boolean isCheckoutButtonDisplayed() {
		return driver.findElement(checkOutButton).isDisplayed();
	}
	public void clickOnCheckoutButton() {
		driver.findElement(checkOutButton).click();
	}
	public String isURLOfPageCorrect() {
    	return driver.getCurrentUrl();
    }
	public void removeFromCart() {
		 driver.findElement(removeCartButton).click();	
	}
	public boolean didValueOfAttributeChangeAfterAddingProduct() {
		return driver.findElement(removeCartButton).getAttribute("id").contains("remove");
	}
	public void waitClickRemoveButton() {
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	 wait.until(ExpectedConditions.elementToBeClickable(removeCartButton));
	}
	public Boolean isWaitForInvisibilityRemoveButton() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(removeCartButton));
	}
}