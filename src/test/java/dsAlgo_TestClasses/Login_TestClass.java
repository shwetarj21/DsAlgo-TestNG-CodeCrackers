package dsAlgo_TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;


import dsAlgo_Utilities.DataProvider_Class;

public class Login_TestClass extends BaseClass {

	Home_PageFactory homePage;
	Login_PageFactory loginPage;

	@BeforeMethod
	public void initPageObjects() {
		homePage = new Home_PageFactory();
		loginPage = new Login_PageFactory();
		homePage.launchUrl();
		homePage.getStartedHomeBtnClick();
	}
	
	@Test(dataProvider = "validLoginData", dataProviderClass = DataProvider_Class.class)
	public void validLogInData(String username, String password, String message) {
		loginPage.signInClick();
		loginPage.userNameLoginBtn.sendKeys(username);
		loginPage.passwordLoginBtn.sendKeys(password);
		loginPage.LoginBtnClick();
		String loggedInMsg = loginPage.loggedInMessage.getText();
		//Assert.assertEquals(loggedInMsg, message);
	} 

	@Test(dataProvider = "logOutData", dataProviderClass = DataProvider_Class.class)
	public void loginLogOut(String username, String password, String message) {
		loginPage.signInClick();
		loginPage.userNameLoginBtn.sendKeys(username);
		loginPage.passwordLoginBtn.sendKeys(password);
		loginPage.LoginBtnClick();
		loginPage.signOutBtnClick();
		String loggedOutMsg = loginPage.loggedOutMessage.getText();
		Assert.assertEquals(loggedOutMsg, message);
	}
	@Test(dataProvider = "invalidLoginData", dataProviderClass = DataProvider_Class.class)
	public void invalidLogIn(String username, String password, String message) {
		loginPage.signInClick();
	    loginPage.userNameLoginBtn.sendKeys(username);
		loginPage.passwordLoginBtn.sendKeys(password);
		loginPage.LoginBtnClick(); 
		String invalidMsg = loginPage.invalidMessage.getText();
		Assert.assertEquals(invalidMsg, message);
	}
	
	@Test(dataProvider = "loginBlank", dataProviderClass = DataProvider_Class.class)
	public void loginBlankFields(String username, String password, String message) throws InterruptedException {
		loginPage.signInClick();
		Thread.sleep(2000);
	    loginPage.userNameLoginBtn.sendKeys(username);
		loginPage.passwordLoginBtn.sendKeys(password);
		Thread.sleep(2000);
		loginPage.LoginBtnClick(); 
		String actualmessage = loginPage.getPopUpMessage();
		Assert.assertEquals(actualmessage, message,"message dont match");
	}

}
