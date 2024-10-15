package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
	WebDriver driver;
	
	public CheckoutCompletePage(WebDriver driver){
		this.driver=driver;
	}
	//locators
	private By completePageTitle= By.xpath("//div[@class=\"header_secondary_container\"]/span");
	private By checkedIcon= By.xpath("//div[@id=\"checkout_complete_container\"]/img");
	private By exclamation= By.xpath("//div[@id=\"checkout_complete_container\"]/h2");
	private By text= By.xpath("//div[@id=\"checkout_complete_container\"]/div");
	private By backHomeButton= By.id("back-to-products");
	
    //actions
	public String isTitleOfCompletedOrder() {
		return driver.findElement(completePageTitle).getText();
	}
	public String isThankYouSentence() {
		return driver.findElement(exclamation).getText();
	}
	public String isText() {
		return driver.findElement(text).getText();
	}
	public String isNameOfBackHomeButton() {
		return driver.findElement(backHomeButton).getText();
	}
	public void clickFinishButton() {
		 driver.findElement(backHomeButton).click();
	}
	public boolean isCheckedIconDisplayed() {
		return driver.findElement(checkedIcon).isDisplayed();
	}
	public String isURLOfPageCorrect() {
    	return driver.getCurrentUrl();
    	
    }
}
