package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import test.data.Users;

public class LoginPage  {
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	//Locators
	
    private By usernameInput= By.id("user-name");
    private By passwordInput= By.id("password");
    private By loginButton= By.id("login-button");
    private By errorContainer= By.xpath("//div[@class=\"error-message-container error\"]/h3");
    private By changingState = By.xpath("//div[@class=\"form_group\"]/input[@class=\"input_error form_input error\"]");
    private By redXIcon= By.xpath("//div[@class=\"form_group\"]/*[2]//*[name()=\"path\"]");
    private By xIconNextToMessage=By.xpath("//div[@class=\"error-message-container error\"]//*[name()=\"path\"]");
    private By valueEmptyNoPassword= By.xpath("//div[@class=\"form_group\"][2]/input[@class=\"input_error form_input error\"]");
    private By valueEmptyNoUsername=By.xpath("//div[@class=\"form_group\"][1]/input[@class=\"input_error form_input error\"]");
	//Actions
	
    public void enterUsername(String username) {
    	 driver.findElement(usernameInput).sendKeys(username);
    }
    
    public void enterPassword(String password) {
    	driver.findElement(passwordInput).sendKeys(password);
    }
    
    public void clickLoginButton() {
    	driver.findElement(loginButton).click();
    }	
    
    public String textOfErrorContainer() {
    	return driver.findElement(errorContainer).getText();
    }
    
    public List<WebElement> placeElementsInList(By name) { ///////de facut utilitara?????????????????????????????????????/??!!1
    	List<WebElement> listElements=driver.findElements(name);
    	return listElements;
    }
    
    public boolean isElementInListChangingAttributeValue(){
    	for(WebElement listAttribute:placeElementsInList(changingState)) {
    		if(listAttribute.getAttribute("class").contains("input_error form_input error")) {
    			//System.out.println(placeElementsInList(changingState).size());
    			return true;
    		}
    	}
    	return  false;
    }
    public boolean isIconDisplayed(){
    	for(WebElement listIcon:placeElementsInList(redXIcon)) {
    		if(listIcon.isDisplayed()) {
    			//System.out.println(placeElementsInList(redXIcon).size());
    			return true;
    		}
    	}
    	return  false;
    }
    
    public boolean isIconNextToErrorMessageDisplayed() {
    	return driver.findElement(xIconNextToMessage).isDisplayed();
    }
    
    public boolean isValueAttributeEmpty() {
    return driver.findElement(valueEmptyNoPassword).getAttribute("value").isEmpty();
    }
    
    public boolean isValueAttributeEmptyUsername() {
        return driver.findElement(valueEmptyNoUsername).getAttribute("value").isEmpty();
        }
        
    public void clearPassword() {
    	driver.findElement(passwordInput).sendKeys(Keys.CONTROL,"a",Keys.DELETE);;
    }
    public void clickIconNextToErrorMessage() {
    	Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(xIconNextToMessage)).click();
        builder.perform();
    }
   
    
    public void clearUsername() {
    	driver.findElement(usernameInput).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
    }
    
    public boolean isLoginButtonEnabled() {
    	return driver.findElement(loginButton).isEnabled();
    }

    public boolean isUsernameFieldEnabled() {
    	return driver.findElement(usernameInput).isEnabled();
    }
    public boolean isPasswordFieldEnabled() {  
        return	driver.findElement(passwordInput).isEnabled();
    }  

    public String isURLOfPageCorrect() {
    	return driver.getCurrentUrl();
    }
    //Behavior

    public void authenticate(Users adminuser) {
    	enterUsername(adminuser.getUsername());
    	enterPassword(adminuser.getPassword());
    	clickLoginButton();
    }


}
