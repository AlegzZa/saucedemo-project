package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage {
	WebDriver driver;
	
	public CheckoutYourInformationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//locators
	private By firstNameInput=By.id("first-name");
	private By lastNameInput=By.id("last-name");
	private By zipCode=By.id("postal-code");
	private By continueButton= By.id("continue");
	
	
	//actions
	public void enterFirstName(String firstName) {
		 driver.findElement(firstNameInput).sendKeys(firstName);
	}
	public void enterLastName(String lastName) {
		 driver.findElement(lastNameInput).sendKeys(lastName);
	}
	public void enterPostalCode(String postalCode) {
		 driver.findElement(zipCode).sendKeys(postalCode);
	}
	public void clickContinueButton() {
		driver.findElement(continueButton).click();
	}
	
	
	
}


