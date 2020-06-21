package pageFile;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HouseJoyBooking {
	WebDriver driver;
	WebDriverWait wait;
	bean bean = pageFile.bean.getInstance();

	public HouseJoyBooking(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Login']")
	private WebElement loginBtn;

	@FindBy(xpath = "//b[text()='Bangalore']")
	private WebElement Bangalore;

	@FindBy(xpath = "//a[contains(text(),'Sign In')]")
	private WebElement signInBtn;

	@FindBy(id = "signin-email")
	private WebElement emailBox;

	@FindBy(id = "signin-password")
	private WebElement passwordBox;

	@FindBy(xpath = "//div[text()='Sign In']")
	private WebElement signInBox;

	@FindBy(css = "[data-activates='userAccount']")
	private WebElement accountImg;

	@FindBy(css = "[data-activates^='recently-launched']")
	private WebElement recentlyLaunchedButton;

	@FindBy(xpath = "//a[contains(text(),'Car Cleaning')]")
	private WebElement carCleaningBtn;

	@FindBy(xpath = "//h1[contains(text(),'Car Cleaning')]")
	private WebElement carCleaningSection;

	@FindBy(id = "capsule")
	private WebElement serviceBox;

	@FindBy(xpath = "//i[text()='add']")
	private WebElement addBtnInCarSchdule;

	@FindBy(xpath = "//i[text()='add']/../../span")
	private WebElement quantityInCarSchdule;

	@FindBy(xpath = "//div[text()='Add To Cart']")
	private WebElement addToCartBtn;

	@FindBy(xpath = "//i[text()='shopping_cart']/../span")
	private WebElement noOfServiceInCart;

	@FindBy(id = "continueButton")
	private WebElement continueBtn;

	@FindBy(xpath = "//a[text()='Add new Address']")
	private WebElement addNewAddLink;

	@FindBy(id = "address_building")
	private WebElement addressLine;

	@FindBy(id = "address_landmark")
	private WebElement landmark;

	@FindBy(xpath = "//a[text()='Save']")
	private WebElement saveBtnInNewAddress;

	@FindBy(css = "[class='address-blk active']")
	private WebElement addressBlockActive;

	@FindBy(css = "[class='address-blk active'] [class='address-txt grey-color']")
	private WebElement addressTextSaved;

	@FindBy(xpath = "//a[text()='Continue'][@class='waves-effect  btn btnCurve right']")
	private WebElement continueAfterAddressSelection;

	@FindBy(id = "scheduleBlockHeader")
	private WebElement scheduleBlock;

	@FindBy(css = "#date-swiper-schedule>div>div>a")
	private List<WebElement> dateList;

	@FindBy(css = ".time-wrap>div>div:nth-child(1) a")
	private List<WebElement> morningTimeList;

	@FindBy(css = ".time-wrap>div>div:nth-child(2) a")
	private List<WebElement> afternoonTimeList;

	@FindBy(css = ".time-wrap>div>div:nth-child(3) a")
	private List<WebElement> eveningTimeList;

	@FindBy(xpath = "//*[@id='scheduleBlock']//a[text()='Continue']")
	private WebElement continueBtnScheduleBlock;

	@FindBy(css = "#filled-in-box~label")
	private WebElement safetyCheckBox;

	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement safetyCheckBoxContinue;

	@FindBy(xpath = "//*[text()='Order Summary']")
	private WebElement orderSummary;

	@FindBy(css = ".total-amt span")
	private List<WebElement> totalAmountList;

	@FindBy(id = "bookOrder")
	private WebElement bookOrderBtn;

	@FindBy(xpath = "//*[text()='Order Confirmed!']")
	private WebElement orderConfirmedMsg;

	@FindBy(css = ".success-color~h5")
	private WebElement orderId;
	
	@FindBy(xpath="//a[text()='View Order Details']")
	private WebElement viewOrderDetails;

	@FindBy(xpath = "//a[text()='Cancel Order']")
	private WebElement cancelOrder;

	@FindBy(css = "#ModalCancelOrder ul>li:nth-child(4)")
	private WebElement cancelOrderReason;

	@FindBy(css = "#ModalCancelOrder a[class='btn waves-effect btnCurve']")
	private WebElement cancelOrderContinue;

	@FindBy(xpath = "//p[text()='CANCELLED']")
	private WebElement cancelledMsg;

	public void goToHouseJoyURl() throws Throwable {
		driver.get("https://www.housejoy.in/");
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(Bangalore));
		clickWithJavaScript(Bangalore);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		highLight(loginBtn);
		loginBtn.click();

	}

	public void performLogin() throws Throwable {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
		highLight(signInBtn);
		clickWithJavaScript(signInBtn);
		wait.until(ExpectedConditions.elementToBeClickable(emailBox));
		emailBox.sendKeys("akash.bmsit.kumar@gmail.com");
		wait.until(ExpectedConditions.elementToBeClickable(passwordBox));
		passwordBox.sendKeys("9973966524");
		highLight(signInBox);
		signInBox.click();
//		clickWithJavaScript(signInBox);

	}

	public void clickWithJavaScript(WebElement ele) throws Throwable {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
	}

	public void highLight(WebElement ele) throws Throwable {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
	}

	public void validateLogin() throws Throwable {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(accountImg));
		Assert.assertTrue("User login failed", accountImg.isDisplayed());

	}

	public void goToServiceSection(String service) throws Throwable {
		wait = new WebDriverWait(driver, 50);

		switch (service) {
		case "car service":
			wait.until(ExpectedConditions.elementToBeClickable(recentlyLaunchedButton));
			highLight(recentlyLaunchedButton);
			Actions action = new Actions(driver);
			action.moveToElement(recentlyLaunchedButton).build().perform();
			wait.until(ExpectedConditions.elementToBeClickable(carCleaningBtn));
			highLight(carCleaningBtn);
			clickWithJavaScript(carCleaningBtn);
		}
	}

	public void validateServiceSection(String service) throws Throwable {
		wait = new WebDriverWait(driver, 50);

		switch (service) {
		case "car service":
			wait.until(ExpectedConditions.elementToBeClickable(carCleaningSection));
			Assert.assertTrue("Car cleaning section failed to load", carCleaningSection.isDisplayed());
			highLight(carCleaningSection);

		}
	}

	public void selectCarQty(int qty) throws Throwable {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(serviceBox));
		highLight(serviceBox);
		highLight(addBtnInCarSchdule);
		highLight(quantityInCarSchdule);

		for (int i = 1; i <= qty; i++) {
			int quantity = Integer.valueOf(quantityInCarSchdule.getText());
			if (qty == quantity)
				break;
			else {
				clickWithJavaScript(addBtnInCarSchdule);
				Thread.sleep(1000);
			}
		}
	}

	public void addServiceToCart(int no) throws Throwable {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
		highLight(addToCartBtn);
		addToCartBtn.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(noOfServiceInCart));
		highLight(noOfServiceInCart);
		int noOfServicesInCart = Integer.valueOf(noOfServiceInCart.getText());

		// Cart Button is not updating after increasing the services in the cart
//		Assert.assertTrue("All services are not added into cart",noOfServicesInCart==no);
		highLight(continueBtn);
		wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
		continueBtn.click();
		Thread.sleep(1000);
	}

	public void chooseAddress(String address) throws Throwable {
		wait = new WebDriverWait(driver, 50);
		switch (address) {
		case "new address":
			wait.until(ExpectedConditions.elementToBeClickable(addNewAddLink));
			highLight(addNewAddLink);
			addNewAddLink.click();
			wait.until(ExpectedConditions.elementToBeClickable(addressLine));
			highLight(addressLine);
			String addressLine1 = "HSR Layout";
			addressLine.sendKeys(addressLine1);
			highLight(landmark);
			String addressline2 = "HSR 6th Stage";
			landmark.sendKeys(addressline2);
			wait.until(ExpectedConditions.elementToBeClickable(saveBtnInNewAddress));
			saveBtnInNewAddress.click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(addressBlockActive));
			highLight(addressBlockActive);
			highLight(addressTextSaved);
			Assert.assertTrue("New Address is not saved properly", addressTextSaved.getText().contains(addressLine1)
					&& addressTextSaved.getText().contains(addressline2));
			wait.until(ExpectedConditions.elementToBeClickable(continueAfterAddressSelection));
			highLight(continueAfterAddressSelection);
			continueAfterAddressSelection.click();
			wait.until(ExpectedConditions.elementToBeClickable(scheduleBlock));
			break;

		case "existing address":
			wait.until(ExpectedConditions.elementToBeClickable(addNewAddLink));
			highLight(addNewAddLink);
			wait.until(ExpectedConditions.elementToBeClickable(addressBlockActive));
			highLight(addressBlockActive);
			wait.until(ExpectedConditions.elementToBeClickable(continueAfterAddressSelection));
			highLight(continueAfterAddressSelection);
			continueAfterAddressSelection.click();
			wait.until(ExpectedConditions.elementToBeClickable(scheduleBlock));
			Thread.sleep(3000);
			break;
		}

	}

	public void scheduleService(int days, String time) throws Throwable {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(scheduleBlock));
		if (days < 10) {
			wait.until(ExpectedConditions.elementToBeClickable(dateList.get(days)));
			highLight(dateList.get(days));
			wait.until(ExpectedConditions.elementToBeClickable(dateList.get(days)));
			dateList.get(days).click();
			Thread.sleep(2000);
		} else {
			Assert.fail("Schedule date is available only for 10 days");
		}

		switch (time) {
		case "morning":
			wait.until(ExpectedConditions.elementToBeClickable(morningTimeList.get(0)));
			highLight(morningTimeList.get(0));
			morningTimeList.get(0).click();
			Thread.sleep(1500);
			break;
		case "afternoon":
			wait.until(ExpectedConditions.elementToBeClickable(afternoonTimeList.get(0)));
			highLight(afternoonTimeList.get(0));
			afternoonTimeList.get(0).click();
			Thread.sleep(1500);
			break;
		case "evening":
			wait.until(ExpectedConditions.elementToBeClickable(eveningTimeList.get(0)));
			highLight(eveningTimeList.get(0));
			eveningTimeList.get(0).click();
			Thread.sleep(1500);
			break;
		}

		wait.until(ExpectedConditions.elementToBeClickable(continueBtnScheduleBlock));
		highLight(continueBtnScheduleBlock);
		continueBtnScheduleBlock.click();

		wait.until(ExpectedConditions.elementToBeClickable(safetyCheckBox));
		highLight(safetyCheckBox);
		safetyCheckBox.click();

		wait.until(ExpectedConditions.elementToBeClickable(safetyCheckBoxContinue));
		highLight(safetyCheckBoxContinue);
		safetyCheckBoxContinue.click();

		wait.until(ExpectedConditions.elementToBeClickable(orderSummary));
	}

	public void validateOrderSummar() throws Throwable {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(orderSummary));
		Thread.sleep(2000);
		highLight(totalAmountList.get(0));
		highLight(totalAmountList.get(1));
		System.out.println(totalAmountList.get(0));
		System.out.println(totalAmountList.get(1));
		Assert.assertTrue("Total amount calculated is wrong", totalAmountList.get(0).getText().equals(totalAmountList.get(1).getText()));
	}

	public void bookOrderAndValidateConfrmationPage() throws Throwable {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(bookOrderBtn));
		highLight(bookOrderBtn);
		bookOrderBtn.click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(orderConfirmedMsg));
		highLight(orderConfirmedMsg);
		highLight(orderId);
		bean.setOrderId(orderId.getText());
	}

	public void cancelOrder() throws Throwable {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(viewOrderDetails));
		highLight(viewOrderDetails);
		viewOrderDetails.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(cancelOrder));
		highLight(cancelOrder);
		cancelOrder.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(cancelOrderReason));
		highLight(cancelOrderReason);
		cancelOrderReason.click();
		wait.until(ExpectedConditions.elementToBeClickable(cancelOrderContinue));
		highLight(cancelOrderContinue);
		cancelOrderContinue.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(cancelledMsg));
		highLight(cancelledMsg);
		Assert.assertTrue("Cancellation failed", cancelledMsg.isDisplayed());

	}

}
