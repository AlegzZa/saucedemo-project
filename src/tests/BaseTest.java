package tests;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import components.Header;
import components.Menu;
import pages.BackToProductsPage;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import pages.CheckoutYourInformationPage;
import pages.LoginPage;
import test.data.OrderDetailsFinal;
import test.data.Products;
import test.data.URL;
import test.data.Users;
import pages.ProductsPage;
import pages.YourCartPage;

public class BaseTest {
	static WebDriver driver;
	public static LoginPage loginpage;
	public static ProductsPage productspage;
	public static Menu menu;
	public static Header header;
	public static BackToProductsPage backtoproductspage;
	public static YourCartPage yourcartpage;
	public static CheckoutYourInformationPage checkoutYourInformationPage;
	public static CheckoutOverviewPage checkoutoverviewpage;
	public static CheckoutCompletePage checkoutcompletepage;
	
	public  Users adminuser = new Users("adminuser");
	public Users client= new Users("client");
	public Products product= new Products("product");
	public OrderDetailsFinal orderdetails=new OrderDetailsFinal("orderDetails");
	
	@Before
	public void before() {
		
	System.setProperty("webdriver.chorme.driver","src/resource/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    loginpage= new LoginPage(driver);
	productspage= new ProductsPage(driver);
	menu= new Menu(driver);
	backtoproductspage= new BackToProductsPage(driver);
	header=new Header(driver);
	yourcartpage= new YourCartPage(driver);
	checkoutYourInformationPage= new CheckoutYourInformationPage(driver);
	checkoutoverviewpage= new CheckoutOverviewPage(driver);
	checkoutcompletepage=new CheckoutCompletePage(driver);
	
	driver.navigate().to(URL.LOGIN);

	}
	@After
	public void after() {
		//driver.close();
	    driver.quit();
	}
	
}
