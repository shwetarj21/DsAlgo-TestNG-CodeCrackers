package dsAlgo_PageFactory;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import dsAlgo_BaseClass.BaseClass;
import org.openqa.selenium.interactions.Actions;
import dsAlgo_DriverFactory.Driver_Factory;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.TryEditor;

public class Array_PageFactory extends BaseClass {

	WebDriver driver = Driver_Factory.getDriver();
	ConfigReader configFileReader = Driver_Factory.configReader();
	TryEditor readTryEditor = new TryEditor();

	String get_alert_msg;
	String expectedOutput;
	String errorMsg;

	String ExpectedFromTestcaseOne;
	String output;
	@FindBy(xpath = "//h4[text()='Array']")
	WebElement arrayDisplayTitle;
	@FindBy(xpath = "//h5[text()='Array']/..//a[text()='Get Started']")
	WebElement arrayGetStartedBtn;
	@FindBy(xpath = "//div[@class='navbar-nav']/div/a")
	WebElement dropdownSelection;
	@FindBy(xpath = "//div[@class='navbar-nav']/div/div/a[1]")
	WebElement dropdownSelectArray;
	@FindBy(xpath = "//a[text()='Arrays in Python']")
	WebElement arrayInPython;
	@FindBy(xpath = "//p[text()='Arrays in Python']")
	WebElement arrayInPythonPage;
	@FindBy(xpath = "//a[text()= 'Try here>>>']")
	WebElement tryHereArrayInPython;
	@FindBy(xpath = "//div[@class='CodeMirror-scroll']")
	WebElement TryHereTextArea;
	@FindBy(xpath = "//button[text()='Run']")
	WebElement RunBtnArray;
	@FindBy(id = "output")
	WebElement textOutput;
	@FindBy(xpath = "//a[text()='Arrays Using List']")
	WebElement arrayUsingList;
	@FindBy(xpath = "//p[text()='Arrays Using List']")
	WebElement arrayUsingListNmeDisplay;
	@FindBy(xpath = "//a[text()='Basic Operations in Lists']")
	WebElement basicOprList;
	@FindBy(xpath = "//a[text()='Basic Operations in Lists']")
	WebElement basicOprListPage;
	@FindBy(xpath = "//p[text()='Applications of Array']")
	WebElement applOfArrayDisplay;
	@FindBy(xpath = "//a[text()='Applications of Array']")
	WebElement applOfArrayLink;
	@FindBy(xpath = "//a[text()='Practice Questions']")
	WebElement practiceQuePage;
	@FindBy(xpath = "//a[text()='Search the array']")
	WebElement searchArray;
	@FindBy(xpath = "//pre[@id='output']")
	WebElement searchArrayOutput;
	@FindBy(className = "question")
	WebElement searchArrayPageDisplay;
	@FindBy(xpath = "//a[text()='Max Consecutive Ones']")
	WebElement maxConsOne;
	@FindBy(xpath = "//a[@href='/question/3']")
	WebElement evenNumFind;
	@FindBy(xpath = "//a[text()='Squares of  a Sorted Array']")
	WebElement SortedArray;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitBtn;
	@FindBy(xpath = "//*[@id=\"answer_form\"]/div/div/div[6]/div[1]/div/div")
	WebElement textArea;
	@FindBy(xpath = "('.//textarea')")
	WebElement text_area;
	@FindBy(className = "cm-def")
	WebElement codeTextLine;

	public Array_PageFactory() {

		PageFactory.initElements(driver, this);
	}

	public void arrayGetStartedBtn() {
		arrayGetStartedBtn.click();
	}

	public boolean arrayDisplayTitle() {

		return arrayDisplayTitle.isDisplayed();
	}

	public void arrayDropdownSelection() {

		dropdownSelection.click();
		dropdownSelectArray.click();
	}

	public boolean arrayInPythinLink() {

		return arrayInPython.isEnabled();
	}

	public void arrayInPythonClicked() {

		arrayInPython.click();
	}

	public boolean ValidateArrayInPythonPage() {

		return arrayInPythonPage.isDisplayed();

	}

	public void tryHereBtn() {
		tryHereArrayInPython.click();
	}

	public boolean NavigateToTryHereBtn() {
		return RunBtnArray.isDisplayed();
	}

	public String readExcel_forTryHereArray(String pythonCode, String output) throws IOException, InterruptedException {

		String actualOutput = "";
		expectedOutput = output;
		try {

			TryHereTextArea.sendKeys(pythonCode);
			WebElement codeMirror = driver.findElement(
					By.xpath("//div[contains(@class, 'CodeMirror') and contains(@class, 'cm-s-default')]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(codeMirror).click().perform();
			WebElement textArea = codeMirror.findElement(By.xpath(".//textarea"));
			textArea.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			textArea.sendKeys(pythonCode);
			enterCodePractice(pythonCode, textArea);
			RunBtnArray.click();

			try {
				Alert alert = driver.switchTo().alert();
				get_alert_msg = alert.getText();
				alert.accept();
				actualOutput = get_alert_msg;
			} catch (NoAlertPresentException e) {
				actualOutput = textOutput.getText();
			} catch (UnhandledAlertException e) {
				actualOutput = e.getMessage();
			}
		} finally {
		}
		return actualOutput;
	}

	public void enterCodePractice(String code, WebElement textArea) {
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").sendKeys(Keys.DELETE).keyUp(Keys.CONTROL).perform();
		String[] str1 = code.split("\n");
		for (int i = 0; i < str1.length; i++) {
			if (str1[i].equalsIgnoreCase("\\b")) {
				textArea.sendKeys(Keys.BACK_SPACE);
			} else {
				textArea.sendKeys(str1[i]);
				textArea.sendKeys(Keys.RETURN);
			}
		}
	}

	public void arrayUsingListlink() {

		arrayUsingList.click();
	}

	public boolean arrayUsingListPageDisplay() {

		return arrayUsingListNmeDisplay.isDisplayed();
	}

	public void BasicOperationListLink() {

		basicOprList.click();
	}

	public boolean InBasicOprPage() {
		return basicOprListPage.isDisplayed();
	}

	public void RunBtnForNoCodeError() {
		RunBtnArray.click();
	}

	public boolean applcationOfArrayDisplay() {

		return applOfArrayDisplay.isDisplayed();
	}

	public void ApplicationOfArrayClick() {
		applOfArrayLink.click();

	}

	public boolean InPracticeQuePage() {
		return SortedArray.isDisplayed();
	}

	public void PracticeQuePage() {
		practiceQuePage.click();
	}

	public void SearchArrayClick() {
		searchArray.click();
	}

	public boolean displayTryHereText() {
		return searchArrayPageDisplay.isDisplayed();
	}

	public void RunbtnwithoutCode() {

		new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").sendKeys(Keys.DELETE).keyUp(Keys.CONTROL).perform();
		RunBtnArray.click();

	}

	public String SubmitbtnwithoutCode() {

		new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").sendKeys(Keys.DELETE).keyUp(Keys.CONTROL).perform();
		submitBtn.click();
		String Actual_output = searchArrayOutput.getText();
		return Actual_output;
	}

	public void clickOnMaxConsecutive() {

		maxConsOne.click();
	}

	public void FindEvenNumber() {

		evenNumFind.click();
	}

	public void SortedArray() {

		SortedArray.click();
	}

}