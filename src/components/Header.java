package components;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {
   WebDriver driver;
	
	public Header(WebDriver driver) {
		this.driver=driver;
	}
	
	//locators
	private By redIconOnCart=By.xpath("//div[@id=\"shopping_cart_container\"]/a/span[ text()=\"1\"]");

	//actions
	public boolean isRedIconOnCartDisplayed() {
		return driver.findElement(redIconOnCart).isDisplayed();
	}
	public String doesIconHoldNumberOfProducts() {
		return driver.findElement(redIconOnCart).getText();
	}
	public void clickOnRedIconOnCart() {
		driver.findElement(redIconOnCart).click();
	}
	public Boolean isWaitForInvisibility() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(redIconOnCart));
	}
	
}

