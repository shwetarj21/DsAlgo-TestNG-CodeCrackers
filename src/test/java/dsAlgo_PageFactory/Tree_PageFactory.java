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


	public class Tree_PageFactory extends BaseClass{
		   WebDriver driver = Driver_Factory.getDriver();
		   ConfigReader configFileReader = Driver_Factory.configReader();
           TryEditor readTryEditor = new TryEditor();
		   		   				 
           @FindBy (xpath = "//a[@href='tree']") WebElement getstartedTree; 
           @FindBy (xpath = "//a[text()='Overview of Trees']") WebElement overviewoftrees;
		   @FindBy (xpath = "//a[normalize-space()='Overview of Trees']") WebElement OverviewofTrees_link;
		   @FindBy (xpath = "//a[text()='Terminologies']") WebElement terminologies;
		   @FindBy (xpath = "//a[normalize-space()='Terminologies']") WebElement Terminologies_link;
		   @FindBy (xpath = "//a[text()='Types of Trees']") WebElement typesoftrees;
		   @FindBy (xpath = "//a[normalize-space()='Types of Trees']") WebElement TypesofTrees_link;
		   @FindBy (xpath = "//a[text()='Tree Traversals']") WebElement treetraversals;
		   @FindBy (xpath = "//a[normalize-space()='Tree Traversals']") WebElement TreeTraversals_link;
		   @FindBy (xpath = "//a[normalize-space()='Traversals-Illustration']") WebElement traversalsillustration;
		   @FindBy (xpath = "//a[normalize-space()='Traversals-Illustration']") WebElement TraversalsIllustration_link;
		   @FindBy (xpath = "//a[text()='Binary Trees']") WebElement binarytrees;
		   @FindBy (xpath = "//a[normalize-space()='Binary Trees']") WebElement BinaryTrees_link;
		   @FindBy (xpath = "//a[text()='Types of Binary Trees']") WebElement typesofbinarytrees;
		   @FindBy (xpath = "//a[normalize-space()='Types of Binary Trees']") WebElement TypesofBinaryTrees_link;
		   @FindBy (xpath = "//a[text()='Implementation in Python']") WebElement implementationinpython;
		   @FindBy (xpath = "//a[normalize-space()='Implementation in Python']") WebElement ImplementationinPython_link;
		   @FindBy (xpath = "//a[text()='Binary Tree Traversals']") WebElement binarytreetraversals;
		   @FindBy (xpath = "//a[normalize-space()='Binary Tree Traversals']") WebElement BinaryTreeTraversals_link;
		   @FindBy (xpath = "//a[text()='Implementation of Binary Trees']") WebElement implementationofbinarytrees;
		   @FindBy (xpath = "//a[normalize-space()='Implementation of Binary Trees']") WebElement ImplementationofBinaryTrees_link;
		   @FindBy (xpath = "//a[text()='Applications of Binary trees']") WebElement applicationsofbinarytrees;
		   @FindBy (xpath = "//a[normalize-space()='Applications of Binary trees']") WebElement ApplicationsofBinarytrees_link;
		   @FindBy (xpath = "//a[text()='Binary Search Trees']") WebElement binarysearchtrees;
		   @FindBy (xpath = "//a[normalize-space()='Binary Search Trees']") WebElement BinarySearchTrees_link;
		   @FindBy (xpath = "//a[text()='Implementation Of BST']") WebElement implementationofBST;
		   @FindBy (xpath = "//a[normalize-space()='Implementation Of BST']") WebElement ImplementationOfBST_link;
		   @FindBy (xpath = "//a[text()='Practice Questions']") WebElement practicequestions;
		   @FindBy (xpath = "//a[text()='Try here>>>']") WebElement tryhere;
		   @FindBy (xpath = "//button[text()='Run']") WebElement RunButton;
		   @FindBy (xpath="//button[@type='button']") WebElement RunButtonenabled;
           @FindBy (className = "CodeMirror-scroll") WebElement textWindow;
           @FindBy (xpath = "//div[contains(@class, 'CodeMirror') and contains(@class, 'cm-s-default')]") WebElement codeMirror;
           @FindBy (xpath = ".//textarea']") WebElement textArea;
           @FindBy (xpath = "//h4[@class='bg-secondary text-white']") WebElement PageTitle;
           @FindBy (xpath ="//a[contains(@class, 'dropdown-item') and contains(@href, '/tree')]") WebElement Treedropdown;
           @FindBy (xpath ="//a[contains (@class, 'list-group-item') and contains (@href, '/question/1')]") WebElement Practicequestiontext;      
           @FindBy (tagName = "body") WebElement content;
           @FindBy(xpath = "./div") WebElement childelements;
    
           
           public Tree_PageFactory() {
		   PageFactory.initElements(driver, this);
		   }
           
           public void GetStartedTree() {
	    	getstartedTree.click();
	        }

		    public boolean OverviewOfTrees_linkenabled() {
			return OverviewofTrees_link.isEnabled();
		    }
		
	        public void OverviewOfTrees() {
	    	overviewoftrees.click();
	        }
	       
	       	public boolean Terminologies_linkenabled() {
			return Terminologies_link.isEnabled();
			}
	       
	       public void Terminologies() {
	       terminologies.click();
	       }
	       
	       public boolean TypesOfTrees_linkenabled() {
		   return TypesofTrees_link.isEnabled();
		   }
	       
	       public void TypesOfTrees() {
	       typesoftrees.click();
	       }

	       public boolean TreeTraversals_linkenabled() {
		   return TreeTraversals_link.isEnabled();
		   }

	       public void TreeTraversals() {
	       treetraversals.click();
	       }

	       public boolean TraversalsIllustration_linkenabled() {
		   return TraversalsIllustration_link.isEnabled();
		   }

	       public void TraversalsIllustration() {
	       traversalsillustration.click();
	       }

	       public boolean BinaryTrees_linkenabled() {
		   return BinaryTrees_link.isEnabled();
		   }
	    	 
	       public void BinaryTrees() {
	       binarytrees.click();
	       }

	       public boolean TypesOfBinaryTrees_linkenabled() {
		   return TypesofBinaryTrees_link.isEnabled();
		   }

	       public void TypesOfBinaryTrees() {
	       typesofbinarytrees.click();
	       }

	       public boolean ImplementationInPython_linkenabled() {
		   return ImplementationinPython_link.isEnabled();
		   }

	       public void ImplementationInPython() {
	       implementationinpython.click();
	       }

	       public boolean BinaryTreeTraversals_linkenabled() {
		   return BinaryTreeTraversals_link.isEnabled();
		   }

	       public void BinaryTreeTraversals() {
	       binarytreetraversals.click();
	       }

	       public boolean ImplementationOfBinaryTrees_linkenabled() {
		   return ImplementationofBinaryTrees_link.isEnabled();
		   }
	       
	       public void ImplementationOfBinaryTrees() {
	       implementationofbinarytrees.click();
	       }

	       public boolean ApplicationsOfBinaryTrees_linkenabled() {
		   return ApplicationsofBinarytrees_link.isEnabled();
		   }

	       public void ApplicationsOfBinaryTrees() {
	       applicationsofbinarytrees.click();
	       }

	       public boolean BinarySearchTrees_linkenabled() {
		   return BinarySearchTrees_link.isEnabled();
		   }

	       public void BinarySearchTrees() {
	       binarysearchtrees.click();
	       }

	       public boolean ImplementationOfBST_linkenabled() {
		   return ImplementationOfBST_link.isEnabled();
		   }

	       public void ImplementationOfBST() {
	       implementationofBST.click();
	       }

	       public void PracticeQuestions() {
	       practicequestions.click();
	       }
	       
	       public void Tryhere() {
	       tryhere.click();
	       }
	       
	       public void RunButton() {
	       RunButton.click();
	       }
	       
	       public boolean RunbuttonEnabled() {
	       return RunButtonenabled.isEnabled();   
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

