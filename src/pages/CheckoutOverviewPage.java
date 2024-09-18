package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {

	WebDriver driver;
	
	
	public CheckoutOverviewPage(WebDriver driver) {
		this.driver=driver;
	}
	//locators
	private By paymentInformation=By.xpath("//div[@class=\"summary_info\"]/div[text()=\"SauceCard #31337\"]");
	private By pageTitleStatus=By.xpath("//div[@class=\"header_secondary_container\"]/span");
	private By buttonName=By.id("finish");
	private By shippingInformation=By.xpath("//div[@class=\"summary_value_label\"][2]");
	private By itemTotal=By.xpath("//div[@class=\"summary_subtotal_label\"]");
	private By tax=By.xpath("//div[@class=\"summary_tax_label\"]");
	private By total=By.xpath("//div[@class=\"summary_info_label summary_total_label\"]");


	//actions
	
	public String getTitleStatus() {
		return driver.findElement(pageTitleStatus).getText();
	}
	public String isTextOfPaymentInformation() {
		return driver.findElement(paymentInformation).getText();
	}
	public String isNameOfButton() {
		return driver.findElement(buttonName).getText();
	}
	public String isShippingInformation() {
		return driver.findElement(shippingInformation).getText();
	}
	public String isItemTotal() {
		return driver.findElement(itemTotal).getText();
	}
	public String isTax() {
		return driver.findElement(tax).getText();
	}
	public String isTotal() {
		return driver.findElement(total).getText();
	}
	public void clickFinishButton() {
		 driver.findElement(buttonName).click();
	}
	public String isURLOfPageCorrect() {
    	return driver.getCurrentUrl();
    }
	public Double sum(Double a, Double b) {
		return a+b;
	}
	public String WebElementToSTring(By name) {
		String x= driver.findElement(name).getText();
		x=x.replaceAll("[Tax,:,$,Item,Total]","").trim();
		System.out.println(x);
		return x;
	}
	
	public Double getDouble(String x) {
        Double s=Double.parseDouble(x);
		return s;
	}
	
	public Double isSum() {
		return sum(getDouble(WebElementToSTring(itemTotal)),getDouble(WebElementToSTring(tax)));	
	}
	public Double getTotalDouble() {
		return getDouble(WebElementToSTring(total));
	}
	
}
