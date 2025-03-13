package dsAlgo_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsAlgo_DriverFactory.Driver_Factory;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.TryEditor;

public class Register_PageFactory {
	
	WebDriver driver= Driver_Factory.getDriver();
	ConfigReader configFileReader=Driver_Factory.configReader();
	TryEditor readTryEditor = new TryEditor();
	
	@FindBy ( xpath = "//a[text()=' Register ']") WebElement registerLink;	
	@FindBy (id = "id_username") public WebElement userNameRegisterBtn;
	@FindBy (id = "id_password1") public WebElement passwordRegisterBtn;
	@FindBy (id = "id_password2") public WebElement passwordConfirmRegisterBtn;
	@FindBy (xpath = "//input[@type='submit']") WebElement registerBtn;
	@FindBy ( xpath = "//div[contains(text(),'Account Created')]") public WebElement successMessage;
	@FindBy ( xpath = "//div[contains(text(),'password_mismatch')]") public WebElement invalidMessage;
	
	public Register_PageFactory() {
		PageFactory.initElements(driver, this);
	}
	
	public void registerLinkClick() {
		registerLink.click();
	}
	
	public void registerBtnClick() {
		registerBtn.click();
	}
	
	public void userNameRegisterBtnClick() {
		userNameRegisterBtn.click();
	}
	
	public void passwordRegisterBtnClick() {
		passwordRegisterBtn.click();
	}
	
	public void passwordConfirmRegisterBtnClick() {
		passwordConfirmRegisterBtn.click();
	}
}