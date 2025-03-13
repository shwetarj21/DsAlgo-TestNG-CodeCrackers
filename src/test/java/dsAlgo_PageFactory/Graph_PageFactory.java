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

public class Graph_PageFactory {

	   WebDriver driver = Driver_Factory.getDriver();
	   ConfigReader configFileReader = Driver_Factory.configReader();
	   
	   @FindBy (xpath = "//a[contains(@href,'graph')]/..//a[text()='Get Started']") WebElement getstartedGraph;
	   @FindBy (xpath = "//a[@class='list-group-item']/..//a[text()='Graph']") WebElement graphlink;
	   @FindBy (linkText = "Graph") WebElement Graph_link;
       @FindBy (xpath = "//a[text()='Graph Representations']") WebElement graphrepresentations;
	   @FindBy (xpath = "//a[normalize-space()='Graph Representations']") WebElement GraphRepresentations_link;
	   @FindBy (xpath ="//a[text()='Try here>>>']") WebElement tryhere;
	   @FindBy (xpath = "//a[text()='Practice Questions']") WebElement practicequestions;
	   @FindBy (xpath="//button[text()='Run']") WebElement RunButton;
	   @FindBy (xpath="//button[@type='button']") WebElement RunButtonenabled;
	   @FindBy (xpath = "//div[contains(@class, 'CodeMirror') and contains(@class, 'cm-s-default')]") WebElement codeMirror;
       @FindBy (xpath = ".//textarea']") WebElement textArea;
       @FindBy (className = "CodeMirror-scroll") WebElement textWindow;
       @FindBy (tagName = "body") WebElement content;
       @FindBy(xpath = "./div") WebElement childelements;
       
	   TryEditor readTryEditor = new TryEditor(); 
	
	   public Graph_PageFactory() {
	   PageFactory.initElements(driver, this);
	   }
	   
       public void GetStartedGraph() {
       getstartedGraph.click();
       }
     
       public boolean Graph_linkenabled() {
	   return Graph_link.isEnabled();
	   }
     
       public void Graph() {
       graphlink.click();
       }
       
       public boolean RunbuttonEnabled() {
       return RunButtonenabled.isEnabled();   
       }
       
       public boolean GraphRepresentations_linkenabled() {
       return GraphRepresentations_link.isEnabled();
       }
      
       public void GraphRepresentations() {
       graphrepresentations.click(); 
       }

       public void PracticeQuestions() throws InterruptedException {
       practicequestions.click();
       }
     
       public void Tryhere() {
  	   tryhere.click();
       }
     
       public void RunButton() {
  	   RunButton.click();
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
		   RunButton();
		   try {
	            Alert alert = driver.switchTo().alert();
	            String get_alert_msg = alert.getText();
	            alert.accept();
	            System.out.println("Alert Is:"+ get_alert_msg);
	            }   
		        catch (NoAlertPresentException e) {
	            System.out.println("No alert present: " + e.getMessage());
	        }		
	      }
       
       public void navigateback() {
           driver.navigate().back();
       }
}


