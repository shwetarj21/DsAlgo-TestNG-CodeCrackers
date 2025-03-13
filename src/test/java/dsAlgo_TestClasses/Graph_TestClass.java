package dsAlgo_TestClasses;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_Utilities.LoggerReader;
import dsAlgo_PageFactory.Graph_PageFactory;

@Listeners(dsAlgo_Utilities.Listeners_Reporter.class)

public class Graph_TestClass extends BaseClass{

	private String username;
    private String password;
    
	Home_PageFactory homePage;
	Login_PageFactory loginPage;
    Graph_PageFactory graphPage = new Graph_PageFactory();

	public Graph_TestClass(String username, String password) {
    this.username = username;
    this.password = password;
    }

	@Factory(dataProvider = "validLoginDataBaseClass")
    public static Object[] createInstances(String username, String password) {
    return new Object[] { new Graph_TestClass(username, password) };
    }
	
	    @Test
	    public void callValidLogInData() throws InterruptedException {
	    graphPage = new Graph_PageFactory();
	    validLoginDataBase(username, password);
	    graphPage.GetStartedGraph();
	    Thread.sleep(2000);
	    LoggerReader.info("User clicks on Get Started under Graph section"); 
	    }
	
	    @Test(priority = 1)
	    public void Graph() throws InterruptedException {
	    callValidLogInData();
	    Thread.sleep(3000);
        Assert.assertEquals(graphPage.Graph_linkenabled(), true);
        graphPage.Graph();
        LoggerReader.info("User is on Graph page");       
        }
	 
	    @Test(priority = 2)
	    public void GraphTryhere() throws InterruptedException {
	    callValidLogInData();
		Thread.sleep(3000);
		graphPage.Graph();
		graphPage.Tryhere();
		LoggerReader.info("User clicks on Tryhere button in the Graph page"); 
       }
	   
	    @Test(priority = 3)
	    public void checkErrorMessageWhenExecutingWithoutenteringCodeInGraphPage() throws IOException,InterruptedException {
	    callValidLogInData();
	    graphPage.Graph();
	    graphPage.Tryhere(); 
	    graphPage.RunButton(); 
	    Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
	    LoggerReader.error("Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    }

       @Test(priority = 4, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	    public void GraphTryeditor(String sheetName, int rowNumber) throws IOException, InterruptedException {
	    callValidLogInData();
	    graphPage.Graph();
	    graphPage.Tryhere();
		Thread.sleep(4000);
		graphPage.tryEditorWindow(sheetName,rowNumber);
		Assert.assertEquals(graphPage.RunbuttonEnabled(), true);
		LoggerReader.info("User enters valid and invalid python code in the Tryeditor section of Graph page"); 
	    }
	    
	    @Test(priority = 5)
	    public void navigatebacktoGraph() throws InterruptedException {
	    callValidLogInData();
	    graphPage.Graph();
	    graphPage.Tryhere();
	    graphPage.navigateback();
	    LoggerReader.info("User navigates back to Graph page");
	    }
	   
        @Test(priority = 6)
	    public void GraphRepresentations() throws InterruptedException {
	    callValidLogInData();
	    Thread.sleep(3000);
        Assert.assertEquals(graphPage.GraphRepresentations_linkenabled(), true);
        graphPage.GraphRepresentations();
        LoggerReader.info("User is on Graph Representations page");
       }
	 
	    @Test(priority = 7)
	    public void GraphRepresentationsTryhere() throws InterruptedException {
	    callValidLogInData();
		 Thread.sleep(3000);
		 graphPage.GraphRepresentations();
		 graphPage.Tryhere();
		 LoggerReader.info("User clicks on Tryhere button in the Graph Representations page");
       }
	    
	    @Test(priority = 8)
	    public void checkErrorMessageWhenExecutingWithoutenteringCodeInGraphRepresentationsPage() throws IOException,InterruptedException {
	    callValidLogInData();
	    graphPage.GraphRepresentations();
	    graphPage.Tryhere(); 
	    graphPage.RunButton(); 
	    Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
	    LoggerReader.error("Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    }
	    
	    @Test(priority = 9, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	    public void GraphRepresentationsTryeditor(String sheetName, int rowNumber) throws IOException, InterruptedException {
	    callValidLogInData();
	    graphPage.GraphRepresentations();
	    graphPage.Tryhere();
		Thread.sleep(4000);
		graphPage.tryEditorWindow(sheetName,rowNumber);
		Assert.assertEquals(graphPage.RunbuttonEnabled(), true);
		LoggerReader.info("User enters valid and invalid python code in the Tryeditor section of Graph Representations page"); 
	    }
	    
	    @Test(priority = 10)
	    public void navigatebacktoGraphRepresentations() throws InterruptedException {
	    callValidLogInData();
	    graphPage.GraphRepresentations();
	    graphPage.Tryhere();
	    graphPage.navigateback();
	    LoggerReader.info("User navigates back to Graph Representations page");
	    }
	    
	    @Test(priority = 11)
	    public void PracticeQuestions() throws InterruptedException {
	    callValidLogInData();
		graphPage.GraphRepresentations();
		graphPage.PracticeQuestions(); 
	    LoggerReader.info("User is navigated to Practice Questions Page");
	    }
	    
	    @Test(priority = 12)
	    public void PracticeQuestionspageisblank() throws InterruptedException {
	    callValidLogInData();
		graphPage.GraphRepresentations();
		graphPage.PracticeQuestions(); 
        Assert.assertFalse(graphPage.content().trim().isEmpty(), "Page is blank! Body does not contain text.");
	    Assert.assertFalse(graphPage.childelements().isEmpty(), "Page is not blank! Body contains child elements.");
		LoggerReader.error("Test failed: Expected to navigate to Practice Questions for Graph module, instead found the page blank!");
	    }
}
