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
import dsAlgo_BaseClass.BaseClass;
import dsAlgo_DriverFactory.Driver_Factory;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.TryEditor;


public class Stack_PageFactory extends BaseClass {

	WebDriver driver= Driver_Factory.getDriver();
	ConfigReader configFileReader=Driver_Factory.configReader();
	TryEditor readTryEditor = new TryEditor();

	@FindBy(xpath = "//a[contains(@href,'stack')]/..//a[text()='Get Started']")WebElement StackGetStarted;
	@FindBy(xpath = "//h4[@class='bg-secondary text-white']")WebElement Stacktitle;

	@FindBy(linkText = "Operations in Stack")WebElement OperationsinStacklink;
	@FindBy(xpath = "//a[@href='operations-in-stack']") WebElement OperationsInStack;
	@FindBy(xpath = "//p[contains(text(),'Operations in Stack')]")WebElement operationsinstacktitle;

	@FindBy(linkText = "Implementation")WebElement ImplementationLink;
	@FindBy(xpath = "//a[normalize-space()='Implementation']")WebElement Implementation;
	@FindBy(xpath = "//p[normalize-space()='Implementation']") WebElement implementationtitle;

	@FindBy(linkText = "Applications")WebElement ApplicationLink;
	@FindBy(xpath = "//a[normalize-space()='Applications']")WebElement Application;
	@FindBy(xpath = "//p[contains(text(),'Applications')]") WebElement applicationtitle;

	@FindBy(xpath = "//a[text()='Try here>>>']")WebElement TryHere;
	@FindBy(xpath = "//form[@id='answer_form']/div/div/div/textarea")WebElement StackTryEditor;
	@FindBy(className = "CodeMirror-scroll")WebElement textWindow;
	@FindBy(xpath = ".//textarea']")WebElement textArea;
	@FindBy(xpath = "//button[text()='Run']")WebElement RunButton;
	@FindBy(id = "output")WebElement OutputWindow;

	@FindBy(xpath = "//a[text()='Search the Stack']")WebElement PracticeQuestionsStack;
	@FindBy(xpath = "//a[@href='/stack/practice']")WebElement Practice_Questions;	
	@FindBy(xpath = "//a[text()='Data Structures']")WebElement Textconfirmforpracticequestion;
	@FindBy(xpath = "//a[normalize-space()='Search the stack']")WebElement stackpq;

	@FindBy(xpath = "//div[contains(@class, 'CodeMirror') and contains(@class, 'cm-s-default')]")WebElement codeMirror;
	@FindBy (tagName = "body") WebElement content;
    @FindBy(xpath = "./div") WebElement childelements;


	public Stack_PageFactory() {
		PageFactory.initElements(driver, this);
	}

	public void StackGetStarted() {
		StackGetStarted.click();
	}

	public boolean Stacktitileisdisplayed() {
		return Stacktitle.isEnabled();
	}

	public boolean OperationsinStacklinkEnabled() {
		return OperationsinStacklink.isEnabled();
	}

	public boolean ImplementationLinkEnabled() {
		return ImplementationLink.isEnabled();
	}

	public boolean ApplicationLinkEnabled() {
		return ApplicationLink.isEnabled();
	}

	public boolean operationsinstacktitle() {
		return operationsinstacktitle.isDisplayed();
	}

	public boolean implementationtitle() {
		return implementationtitle.isDisplayed();
	}

	public boolean applicationtitle() {
		return applicationtitle.isDisplayed();
	}

	public boolean RunButtonEnabled() {
		return RunButton.isEnabled();
	}

	public boolean OutputWindowDisplayed() {
		return OutputWindow.isDisplayed();
	}

	public boolean PracticeQuestionsStackDisplayed() {
		return PracticeQuestionsStack.isDisplayed();
	}

	public boolean RunButtonDisplayed() {
		return StackTryEditor.isDisplayed();
	}

	public boolean textconfirmpracticequestion() {
		return Textconfirmforpracticequestion.isDisplayed();
	}
	public boolean textWindow() {
		return textWindow.isDisplayed();
	}

	public boolean stackpq() {
		return stackpq.isDisplayed();
	}

	public void Operations_Click() {
		OperationsInStack.click();
	}

	public void Implementation_Click() {
		Implementation.click();
	}

	public void Stack_Applications_Click() {
		Application.click();
	}

	public void TryHere_Click() {
		TryHere.click();
	}

	public void RunButton_Click() {
		RunButton.click();
	}

	public void Practice_Questions_Click() {
		Practice_Questions.click();
	}
	
	public void navigateback() {
        driver.navigate().back();
    }
	
	public String content() {
		   String bodyText = content.getText();
		   return bodyText;
		   }
		      
		   public String childelements() {
		   String childelts = childelements.getText();
		   return childelts;
		   }


	 public void tryEditorWindow(String sheetName, int rowNumber) throws IOException, InterruptedException {
		   String[] editor = readTryEditor.excelTryEditor(sheetName, rowNumber);
		   Actions actions = new Actions(driver);
		   actions.moveToElement(codeMirror).click().perform();
		   WebElement textArea = codeMirror.findElement(By.xpath(".//textarea"));
		   textArea.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		   textArea.sendKeys(editor[0]);
		   RunButton.click();
		   try {
	            Alert alert = driver.switchTo().alert();
	           String get_alert_msg = alert.getText();
	            alert.accept();
	        } catch (NoAlertPresentException e) {
	        }
	      }
}
