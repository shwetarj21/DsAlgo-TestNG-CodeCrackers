package dsAlgo_PageFactory;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsAlgo_DriverFactory.Driver_Factory;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.TryEditor;

public class LinkedList_PageFactory {

	WebDriver driver= Driver_Factory.getDriver();
	ConfigReader configFileReader=Driver_Factory.configReader();
	TryEditor readTryEditor = new TryEditor();
	
	String get_alert_msg;
	String expectedOutput;
	String errorMsg;

	@FindBy(xpath = "//div[h5[text()='Linked List']]//a[text()='Get Started']") WebElement getStartedLinkedListBtn;
	@FindBy(xpath = "//h4[text()='Linked List']") WebElement linkedListTitle;
	@FindBy(linkText = "Introduction") WebElement introductionLink;
	@FindBy(xpath = "//a[text()='Creating Linked LIst']") WebElement creatingLinkedListLink;
	@FindBy(linkText = "Types of Linked List") WebElement typesOfLinkedListLink;
	@FindBy(linkText = "Implement Linked List in Python") WebElement implementLinkedListLink;
	@FindBy(linkText = "Traversal") WebElement traversalLink;
	@FindBy(linkText = "Insertion") WebElement insertionLink;
	@FindBy(linkText = "Deletion")	WebElement deletionLink;

	@FindBy(xpath = "//p[text()='Introduction']") WebElement introductionTitle;
	@FindBy(xpath = "//p[text()='Creating Linked LIst']") WebElement creatingLinkedListTitle;
	@FindBy(xpath = "//p[text()='Types of Linked List']") WebElement typesOfLinkedListTitle;
	@FindBy(xpath = "//p[text()='Implement Linked List in Python']") WebElement implementLinkedListTitle;
	@FindBy(xpath = "//p[text()='Traversal']") WebElement traversalTitle;
	@FindBy(xpath = "//p[text()='Insertion']") WebElement insertionTitle;
	@FindBy(xpath = "//p[text()='Deletion']") WebElement deletionTitle;

	@FindBy(xpath = "//a[text()='Try here>>>']") WebElement tryHereBtn;
	@FindBy(xpath = "//div[@class='CodeMirror-scroll']") WebElement tryHereAreaDs;
	@FindBy(className = "CodeMirror-scroll") WebElement textWindow;
	@FindBy(xpath = "//button[text()='Run']") WebElement runBtn;
	@FindBy(xpath = "//pre[@id='output']") WebElement textOutput;
	@FindBy(xpath = "//div[contains(@class, 'CodeMirror') and contains(@class, 'cm-s-default')]") WebElement codeMirror;

	@FindBy(linkText = "Practice Questions") WebElement practiceQuestionsLink;

	public LinkedList_PageFactory() {
		PageFactory.initElements(driver, this);
	}
	
	public void getStartedLinkedListBtnClick() {
		getStartedLinkedListBtn.click();
	}

	public boolean linkedListTitleDisplayed() {
		return linkedListTitle.isDisplayed();
	}

	public void introductionLinkClick() {
		introductionLink.click();
	}

	public void creatingLinkedListLinkClick() {
		creatingLinkedListLink.click();
	}

	public void typesOfLinkedListLinkClick() {
		typesOfLinkedListLink.click();
	}

	public void implementLinkedListLinkClick() {
		implementLinkedListLink.click();
	}

	public void traversalLinkClick() {
		traversalLink.click();
	}

	public void insertionLinkClick() {
		insertionLink.click();
	}

	public void deletionLinkClick() {
		deletionLink.click();
	}

	public boolean introductionTitleDisplayed() {
		return introductionTitle.isDisplayed();
	}

	public boolean creatingLinkedListTitleDisplayed() {
		return creatingLinkedListTitle.isDisplayed();
	}

	public boolean typesOfLinkedListTitleDisplayed() {
		return typesOfLinkedListTitle.isDisplayed();
	}

	public boolean implementLinkedListTitleDisplayed() {
		return implementLinkedListTitle.isDisplayed();
	}

	public boolean traversalTitleDisplayed() {
		return traversalTitle.isDisplayed();
	}

	public boolean insertionTitleDisplayed() {
		return insertionTitle.isDisplayed();
	}

	public boolean deletionTitleDisplayed() {
		return deletionTitle.isDisplayed();
	}

	public void tryHereBtnClick() {
		tryHereBtn.click();
	}

	public void runBtnClick() {
		runBtn.click();
	}

	public boolean runBtnDisplayed() {
		return runBtn.isDisplayed();
	}

	public void practiceQuestionsLinkClick() {
		practiceQuestionsLink.click();
	}

	public boolean practiceQuestionsLinkDisplayed() {
		return practiceQuestionsLink.isDisplayed();
	}

	public void tryEditorBox() {
		tryHereAreaDs.click();
	}

	public boolean textWindow() {
		return textWindow.isDisplayed();
	}
	
	public void tryEditorWindow(String sheetName, int rowNumber) throws IOException, InterruptedException {
		String[] editor = readTryEditor.excelTryEditor(sheetName, rowNumber);
		Actions actions = new Actions(driver);
		actions.moveToElement(codeMirror).click().perform();
		WebElement textArea = codeMirror.findElement(By.xpath(".//textarea"));
		textArea.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		textArea.sendKeys(editor[0]);
		runBtn.click();
		try {
	         Alert alert = driver.switchTo().alert();
	        String get_alert_msg = alert.getText();
	         alert.accept();
	    } catch (NoAlertPresentException e) {
	    }		
	}
}