package pages;


import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ProductsPage {
	WebDriver driver;
	

	public ProductsPage(WebDriver driver) {
		this.driver=driver;
	}

	//Locators
	private By pageTitle =By.xpath("//div[@class=\"header_secondary_container\"]/span[text()=\"Products\"]");
	private By addCartButton=By.xpath("//div[@id=\"inventory_container\"]/descendant::button[@id=\"add-to-cart-sauce-labs-backpack\"]");
	private By removeCartButton=By.xpath("//div[@id=\"inventory_container\"]/descendant::button[@id=\"remove-sauce-labs-backpack\"][1]");
	private By nameOfProduct= By.xpath("//a[@id=\"item_4_title_link\"]/div[text()=\"Sauce Labs Backpack\"]");
	private By selectDropDown= By.xpath("//select[@class=\"product_sort_container\"]");
	private By listTitleItems=By.xpath("//div[@class=\"inventory_item\"]/div/descendant::div[@class=\"inventory_item_name\"]");
	private By listPriceOfItems=By.xpath("//div[@class=\"inventory_item\"]/div/descendant::div[@class=\"inventory_item_price\"]");	
	
	
	//Actions
	public String isProductsPageTitle() {
	   return driver.findElement(pageTitle).getText(); 	
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
	public void clickOnNameOfProduct() {
		 driver.findElement(nameOfProduct).click();
	}
	public Select clickSelectDropDown() {
		 Select dropDownProduct=new Select(driver.findElement(selectDropDown));
		 return dropDownProduct;	 
	}	 
	
	public List<String>	 listOfStringFromWebElements(By name){
		List <String>listaStringuri=new ArrayList<>();
        List <WebElement> lista=new ArrayList<>(driver.findElements(name));
		for(WebElement list:lista) {
			listaStringuri.add(list.getText());
		}
		return listaStringuri;
	}
	
	public boolean isListSortedFromAToZ() {
		List<String> newList= new ArrayList<>();
		Collections.sort(newList);
		return isSortedFromAToZ().equals(newList);
	}
	
	public List<String> isSortedFromAToZ(){
		clickSelectDropDown().selectByIndex(0);
		return listOfStringFromWebElements(listTitleItems);
	}
	public boolean isListSortedFromZToA() {
		List<String> newList= new ArrayList<>();
		Collections.sort(newList,Collections.reverseOrder());
		return isSortedFromZToA().equals(newList);
	}

	public List<String> isSortedFromZToA(){
		clickSelectDropDown().selectByIndex(1);
		return listOfStringFromWebElements(listTitleItems) ;
	}


	public List<Double> isListSortedFromLowestToHighestPrice() {
		List<Double> newList= isSortedFromLowestToHighestPrice();
		Collections.sort(newList);
		return newList;
	}

	public List<Double> isSortedFromLowestToHighestPrice(){
		clickSelectDropDown().selectByIndex(2);
		return createANewListDouble(listPriceOfItems);
	}
	public boolean isListSortedFromHighestToLowestPrice() {
		List<Double> newList= isSortedFromHighestToLowest();
		Collections.sort(newList,Collections.reverseOrder());
		return  isSortedFromHighestToLowest().equals(newList);
	}
	
	public List<Double> isSortedFromHighestToLowest(){
		clickSelectDropDown().selectByIndex(3);
		return createANewListDouble(listPriceOfItems) ;
	}
	public List<Double> createANewListDouble(By name){
		List<Double> newList= new ArrayList<>();
		for(String item:listOfStringFromWebElements(name)) {
			newList.add(Double.valueOf(item.replaceAll("[$]","").trim()));
		}
		return newList;
	}
	

}
