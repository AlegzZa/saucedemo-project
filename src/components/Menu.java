package components;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Menu {
     WebDriver driver;
     
     
     public Menu(WebDriver driver) {
    	 this.driver=driver;
     }
   
     //locators
     private By logoutButton= By.xpath("//div[@class=\"bm-menu\"]/descendant::a[text()=\"Logout\"]");
     private By menuIcon=By.id("react-burger-menu-btn");
     
     //actions
     public void clickOnLogoutButton() {
    	 driver.findElement(logoutButton).click();
     }
     public boolean LogoutButtonisDisplyed() {
    	return driver.findElement(logoutButton).isDisplayed();
     }
     
     public void clickOnMenuIcon() {
    	 driver.findElement(menuIcon).click();
     }
     
     public void waitforLogoutToBeVisible() { 
    	 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
     }
}
