package dsAlgo_PageFactory;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_DriverFactory.Driver_Factory;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.TryEditor;

public class DataStructure_PageFactory extends BaseClass {

	WebDriver driver = Driver_Factory.getDriver();
	ConfigReader configFileReader = Driver_Factory.configReader();
	TryEditor readTryEditor = new TryEditor();

	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	WebElement dataStructureGetstarted;
	@FindBy(xpath = "//h4[text()='Data Structures-Introduction']")
	WebElement dataStructureInroDisplay;
	@FindBy(xpath = "//a[text()='Data Structures']")
	WebElement DatatructureDropdown;
	@FindBy(xpath = "//a[@href='time-complexity']")
	WebElement timeComplexityBtn;
	@FindBy(xpath = "//p[text()='Time Complexity']")
	WebElement timeComplexityPage;
	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement tryhereBtnDs;
	@FindBy(xpath = "//div[@class='CodeMirror-scroll']")
	WebElement tryhereAreaDs;
	@FindBy(className = "CodeMirror-scroll")
	WebElement tryhereareaEnabled;
	@FindBy(xpath = "//button[text()='Run']")
	WebElement RunBtnDs;
	@FindBy(xpath = "//a[@href='/data-structures-introduction/practice']")
	WebElement practiceQueDs;
	@FindBy(xpath = "//pre[@id='output']")
	WebElement textOutput;
	@FindBy(xpath = "//div[contains(@class, 'CodeMirror') and contains(@class, 'cm-s-default')]") WebElement codeMirror;
	
	String get_alert_msg;
	String expectedOutput;
	String errorMsg;

	public DataStructure_PageFactory() {
		PageFactory.initElements(driver, this);
	}

	public void getStartedDataStructureBtn() {
		dataStructureGetstarted.click();
	}

	public void DataStructureDropDown() {
		DatatructureDropdown.click();
	}

	public boolean datastructureIntropageDisplayed() {
		return dataStructureInroDisplay.isDisplayed();
	}

	public boolean timeComplexityBtnEnabled() throws InterruptedException {
		System.out.println("I am in timeComplexityBtnEnabled page ");
		return timeComplexityBtn.isEnabled();
	}

	public void timecomplexityButtonClick() throws InterruptedException {
		timeComplexityBtn.click();
	}

	public boolean timecomplexityPageEnable() {
		return timeComplexityPage.isDisplayed();
	}

	public void tryhereButtonClick() {
		tryhereBtnDs.click();

	}

	public void tryEditorBox() {
		tryhereAreaDs.click();
	}
	public boolean runBtnDisplayed() {
		return RunBtnDs.isDisplayed();
	}
	
	public String readExcel_fortryhere(String pythonCode, String output) throws IOException {
		String actualOutput = "";
		expectedOutput = output;
		try {
			tryhereAreaDs.sendKeys(pythonCode);

			WebElement codeMirror = driver.findElement(
					By.xpath("//div[contains(@class, 'CodeMirror') and contains(@class, 'cm-s-default')]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(codeMirror).click().perform();
			WebElement textArea = codeMirror.findElement(By.xpath(".//textarea"));
			textArea.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			textArea.sendKeys(pythonCode);

			RunBtnDs.click();

			try {
				Alert alert = driver.switchTo().alert();
				get_alert_msg = alert.getText();
				alert.accept();
				actualOutput = get_alert_msg;
				System.out.println("Alert Is:" + get_alert_msg);
			} catch (NoAlertPresentException e) {
				actualOutput = textOutput.getText();
			} catch (UnhandledAlertException e) {
				actualOutput = e.getMessage();
			}
		} finally {

		}
		return actualOutput;
	}

//	public String readExcel_fortryhere(String pythonCode, String output) throws IOException {
//		String actualOutput = "";
//		expectedOutput = output;
//		try {
//			tryhereAreaDs.sendKeys(pythonCode);
//
//			WebElement codeMirror = driver.findElement(
//					By.xpath("//div[contains(@class, 'CodeMirror') and contains(@class, 'cm-s-default')]"));
//			Actions actions = new Actions(driver);
//			actions.moveToElement(codeMirror).click().perform();
//			WebElement textArea = codeMirror.findElement(By.xpath(".//textarea"));
//			textArea.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//			textArea.sendKeys(pythonCode);
//
//			RunBtnDs.click();
//
//			try {
//				Alert alert = driver.switchTo().alert();
//				get_alert_msg = alert.getText();
//				alert.accept();
//				actualOutput = get_alert_msg;
//				System.out.println("Alert Is:" + get_alert_msg);
//			} catch (NoAlertPresentException e) {
//				actualOutput = textOutput.getText();
//			} catch (UnhandledAlertException e) {
//				actualOutput = e.getMessage();
//			}
//		} finally {
//
//		}
//		return actualOutput;
//	}

	public void runBtnClickNoCode() {

		RunBtnDs.click();
		errorMsg = textOutput.getText();
	}

	public String errorMessageForRun() {
		errorMsg = textOutput.getText();
		System.out.println("Error message is " + errorMsg);
		return errorMsg;
	}

	public void practiceQuestion() {

		practiceQueDs.click();
	}
}
