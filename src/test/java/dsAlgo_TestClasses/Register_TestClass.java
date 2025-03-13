package dsAlgo_TestClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dsAlgo_DriverFactory.Driver_Factory;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_PageFactory.Register_PageFactory;
import dsAlgo_Utilities.DataProvider_Class;
import dsAlgo_Utilities.Listeners_Reporter;
import dsAlgo_Utilities.LoggerReader;

@Listeners(dsAlgo_Utilities.Listeners_Reporter.class)

public class Register_TestClass {

	WebDriver driver;

	Home_PageFactory homePage;
	Login_PageFactory loginPage;
	Register_PageFactory registerPage;

	@BeforeMethod
	@Parameters("browser")
	public void setup(@Optional("chrome") String browser) {
		Driver_Factory driverFactory = new Driver_Factory();
		driverFactory.setUp(browser);
		driver = Driver_Factory.getDriver();

		homePage = new Home_PageFactory();
		loginPage = new Login_PageFactory();
		registerPage = new Register_PageFactory();

		homePage.launchUrl();
		homePage.getStartedHomeBtnClick();
	}

	@Test(priority=1, dataProvider = "registerUserName", dataProviderClass = DataProvider_Class.class)
	public void registerOnlyUsername(String username, String password, String passwordConfirmation, String message) {
		registerPage.registerLinkClick();
		registerPage.userNameRegisterBtn.sendKeys(username);
		registerPage.passwordRegisterBtn.sendKeys(password);
		registerPage.passwordConfirmRegisterBtn.sendKeys(passwordConfirmation);
		registerPage.registerBtnClick();
		String actualmessage = loginPage.getPopUpMessage();
		Assert.assertEquals(actualmessage, message, "message dont match");
		LoggerReader.info("User registers only with username");
	}

	@Test(priority=2, dataProvider = "registerPassword", dataProviderClass = DataProvider_Class.class)
	public void registerOnlyPassword(String username, String password, String passwordConfirmation, String message) {
		registerPage.registerLinkClick();
		registerPage.userNameRegisterBtn.sendKeys(username);
		registerPage.passwordRegisterBtn.sendKeys(password);
		registerPage.passwordConfirmRegisterBtn.sendKeys(passwordConfirmation);
		registerPage.registerBtnClick();
		String actualmessage = loginPage.getPopUpMessage();
		Assert.assertEquals(actualmessage, message, "message dont match");
		LoggerReader.info("User registers only with password");
	}

	@Test(priority=3, dataProvider = "registerInvalidUserName", dataProviderClass = DataProvider_Class.class)
	public void registerInvalidUser(String username, String password, String passwordConfirmation, String message) {
		registerPage.registerLinkClick();
		registerPage.userNameRegisterBtn.sendKeys(username);
		registerPage.passwordRegisterBtn.sendKeys(password);
		registerPage.passwordConfirmRegisterBtn.sendKeys(passwordConfirmation);
		registerPage.registerBtnClick();
		String invalidMsg = registerPage.invalidMessage.getText();
		Assert.assertEquals(invalidMsg, message);
		LoggerReader.info("User registers with invalid username");
	}

	@Test(priority=4, dataProvider = "registerInvalidPassword", dataProviderClass = DataProvider_Class.class)
	public void registerInvalidPass(String username, String password, String passwordConfirmation, String message) {
		registerPage.registerLinkClick();
		registerPage.userNameRegisterBtn.sendKeys(username);
		registerPage.passwordRegisterBtn.sendKeys(password);
		registerPage.passwordConfirmRegisterBtn.sendKeys(passwordConfirmation);
		registerPage.registerBtnClick();
		String invalidMsg = registerPage.invalidMessage.getText();
		Assert.assertEquals(invalidMsg, message);
		LoggerReader.info("User registers with invalid password");
	}

	@Test(priority=5, dataProvider = "registerBlankFields", dataProviderClass = DataProvider_Class.class)
	public void registerBlankFld(String username, String password, String passwordConfirmation, String message) {
		registerPage.registerLinkClick();
		registerPage.userNameRegisterBtn.sendKeys(username);
		registerPage.passwordRegisterBtn.sendKeys(password);
		registerPage.passwordConfirmRegisterBtn.sendKeys(passwordConfirmation);
		registerPage.registerBtnClick();
		String actualmessage = loginPage.getPopUpMessage();
		Assert.assertEquals(actualmessage, message, "message dont match");
		LoggerReader.info("User registers with blank fields");
	}

	@Test(priority=6, dataProvider = "registerValidData", dataProviderClass = DataProvider_Class.class)
	public void registerValid(String username, String password, String passwordConfirmation, String message) {
		registerPage.registerLinkClick();
		registerPage.userNameRegisterBtn.sendKeys(username);
		registerPage.passwordRegisterBtn.sendKeys(password);
		registerPage.passwordConfirmRegisterBtn.sendKeys(passwordConfirmation);
		registerPage.registerBtnClick();
		String successMsg = registerPage.successMessage.getText();
		Assert.assertTrue(successMsg.contains(message));
		LoggerReader.info("User registers with valid credentials");
	}

	@Test(priority=7, dataProvider = "registerBugPassword", dataProviderClass = DataProvider_Class.class)
	public void registerBugPass(String username, String password, String passwordConfirmation, String message) {
		registerPage.registerLinkClick();
		registerPage.userNameRegisterBtn.sendKeys(username);
		registerPage.passwordRegisterBtn.sendKeys(password);
		registerPage.passwordConfirmRegisterBtn.sendKeys(passwordConfirmation);
		registerPage.registerBtnClick();
		Assert.fail("Error message should be displayed for password when special characters other than '@/./+/-/_' are given. But user is allowed to Register.");
		LoggerReader.info("User registers with incorrect password");
	}

	@AfterMethod
	public void tearDown() {
		Driver_Factory driverFactory = new Driver_Factory();
		driverFactory.tearDown(); 
	}

	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE && driver != null) {
			LoggerReader.info("Test failed: " + result.getName() + ". Attaching screenshot to Allure.");
			Listeners_Reporter.attachScreenshotToAllure(driver);
		   }
	  }
}
