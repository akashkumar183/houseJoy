package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import pageFile.HouseJoyBooking;
import pageFile.bean;

public class StepDefinations {

	bean bean = pageFile.bean.getInstance();
	WebDriver driver;
	HouseJoyBooking booking = new HouseJoyBooking(driver);

	
	@Before
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "config\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}

	@After
	public void quit() {
		driver.close();
	}

	@Then("^user go to the CarJoy website$")
	public void goToHouseJoyURl() throws Throwable {
		booking = new HouseJoyBooking(driver);
		booking.goToHouseJoyURl();
	}
	
	@Then("^user perform the login$")
	public void performLogin() throws Throwable {
		booking.performLogin();
	}
	
	@Then("^user validates the successful login$")
	public void validateLogin() throws Throwable {
		booking.validateLogin();
	}
	
	@Then("^user go to \"(.*)\" section$")
	public void goToServiceSection(String service) throws Throwable {
		booking.goToServiceSection(service);
	}
	
	@Then("^user validate the \"(.*)\" section is opened successfully$")
	public void validateServiceSection(String service) throws Throwable {
		booking.validateServiceSection(service);
	}
	
	@Then("^user select car quantity as \"(.*)\"$")
	public void selectCarQty(int qty) throws Throwable {
		booking.selectCarQty(qty);
	}
	
	@Then("^user add service to the cart and validate the \"(.*)\" services is added successfully in cart$")
	public void addServiceToCart(int no) throws Throwable {
		booking.addServiceToCart(no);
	}
	
	@Then("^user choose the address as \"(.*)\" for service$")
	public void chooseAddress(String address) throws Throwable {
		booking.chooseAddress(address);
	}
	
	@Then("^user schedule the service after \"(.*)\" days and at \"(.*)\"$")
	public void scheduleService(int days,String time) throws Throwable {
		booking.scheduleService(days,time);
	}
	
	@Then("^user validate the order summary page$")
	public void validateOrderSummar() throws Throwable {
		booking.validateOrderSummar();
	}
	
	@Then("^user book the order and validate order confirmation page$")
	public void bookOrderAndValidateConfrmationPage() throws Throwable {
		booking.bookOrderAndValidateConfrmationPage();
	}
	
	@Then("^user cancel the order$")
	public void cancelOrder() throws Throwable {
		booking.cancelOrder();
	}
}
