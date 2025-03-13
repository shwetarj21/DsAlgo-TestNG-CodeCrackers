package dsAlgo_TestClasses;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_PageFactory.Stack_PageFactory;
import dsAlgo_Utilities.LoggerReader;

@Listeners(dsAlgo_Utilities.Listeners_Reporter.class)
public class Stack_TestClass extends BaseClass {

	Home_PageFactory homePage;
	Login_PageFactory loginPage;
	Stack_PageFactory stackPage;

	private String username;
	private String password;

	public Stack_TestClass(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Factory(dataProvider = "validLoginDataBaseClass")
	public static Object[] createInstances(String username, String password) {
		return new Object[] { new Stack_TestClass(username, password) };
	}

	@Test
	public void callValidLogInData() throws InterruptedException {
		stackPage = new Stack_PageFactory();
		validLoginDataBase(username, password);
		stackPage.StackGetStarted();
		Assert.assertTrue(stackPage.Stacktitileisdisplayed());
		LoggerReader.info("Logging :::::: Click on GetStarted button under Stack section");
	}

	@Test (priority=1)
	public void OperationsInStack() throws IOException,InterruptedException { 
		callValidLogInData();
		stackPage.Operations_Click();
		Assert.assertTrue(stackPage.operationsinstacktitle());
		LoggerReader.info("Logging :::::: Click on Operations in Stack under Stack Page ");
	}

	@Test (priority=2)
	public void Implementation() throws IOException,InterruptedException { 
		callValidLogInData();
		stackPage.Implementation_Click();
		Assert.assertTrue(stackPage.implementationtitle());
		LoggerReader.info("Logging :::::: Click on Implementation under Stack Page");
	}

	@Test (priority=3)
	public void Stack_Applications() throws IOException,InterruptedException {
		callValidLogInData();
		stackPage.Stack_Applications_Click();
		Assert.assertTrue(stackPage.applicationtitle());
		LoggerReader.info("Logging :::::: Click on Application under Stack Page");
	}

		
	@Test(priority=4)

	public void checkErrorMessageWhenExecutingWithoutenteringCodeInOperationsInStackPage() throws IOException,InterruptedException {
		callValidLogInData();
		stackPage.Operations_Click();
		stackPage.TryHere_Click(); 
		stackPage.RunButton_Click(); 
		Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
		LoggerReader.error("Logging :::::: Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");	
	}
	
	@Test (priority=5 , dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	public void OperationsInStacktryeditor(String sheetName , int rowNumber) throws InterruptedException, IOException { 
		callValidLogInData();
		stackPage.Operations_Click();
		stackPage.TryHere_Click();
		stackPage.tryEditorWindow(sheetName,rowNumber);
		Assert.assertTrue(stackPage.RunButtonEnabled(), "Stack Page Run Button is Enabled");
		LoggerReader.info("Logging :::::: Stack Data Provider Try Editor page is enabled and operations are success");
	}
	
    @Test(priority = 6)
    public void navigatebacktoOperationsinstack() throws InterruptedException {
    callValidLogInData();
    stackPage.Operations_Click();
    stackPage.TryHere_Click(); 
    stackPage.navigateback();
    LoggerReader.info("User navigates back to Operations in stack page");
    }
	

	@Test (priority=7)

	public void checkErrorMessageWhenExecutingWithoutenteringCodeInImplementation() throws IOException,InterruptedException {
		callValidLogInData(); 
		stackPage.Implementation_Click();
		stackPage.TryHere_Click(); 
		stackPage.RunButton_Click(); 
		Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
		LoggerReader.error("Logging :::::: Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}
	
	@Test  (priority=8 , dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	public void Implementationtryeditor(String sheetName , int rowNumber) throws InterruptedException, IOException { 
		callValidLogInData();
		stackPage.Implementation_Click();
		stackPage.TryHere_Click();
		stackPage.tryEditorWindow(sheetName,rowNumber);
		Assert.assertTrue(stackPage.RunButtonEnabled(), "Stack Page Run Button is Enabled");
		LoggerReader.info("Logging :::::: Stack Data Provider Try Editor page is enabled and operations are success");
	}
	
	
    @Test(priority = 9)
    public void navigatebacktoImplementation() throws InterruptedException {
    callValidLogInData();
    stackPage.Implementation_Click();
    stackPage.TryHere_Click(); 
    stackPage.navigateback();
    LoggerReader.info("User navigates back to Implementation in stack page");
    }


	@Test(priority=10)

	public void checkErrorMessageWhenExecutingWithoutenteringCodeInApplication() throws IOException,InterruptedException {
		callValidLogInData();   
		stackPage.Stack_Applications_Click();
		stackPage.TryHere_Click(); 
		stackPage.RunButton_Click(); 
		Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
		LoggerReader.error("Logging :::::: Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}
	
	@Test (priority=11 , dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	public void Applicationtryeditor(String sheetName , int rowNumber) throws InterruptedException, IOException { 
		callValidLogInData();
		stackPage.Stack_Applications_Click();
		stackPage.TryHere_Click();
		stackPage.tryEditorWindow(sheetName,rowNumber);
		Assert.assertTrue(stackPage.RunButtonEnabled(), "Stack Page Run Button is Enabled");
		LoggerReader.info("Logging :::::: Stack Data Provider Try Editor page is enabled and operations are success");
	}
	
	   @Test(priority = 12)
	    public void navigatebacktoStackApplication() throws InterruptedException {
	    callValidLogInData();
	    stackPage.Stack_Applications_Click();
	    stackPage.TryHere_Click(); 
	    stackPage.navigateback();
	    LoggerReader.info("User navigates back to Stack Application in stack page");
	    }
	
	@Test(priority=13)
	public void navigateToOperationsInStackPracticeQuestions() throws IOException,InterruptedException { 
		callValidLogInData();
		stackPage.Operations_Click(); 
		stackPage.Practice_Questions_Click();
		Assert.assertFalse(stackPage.content().trim().isEmpty(), "Page is blank! Body does not contain text.");
	    Assert.assertFalse(stackPage.childelements().isEmpty(), "Page is not blank! Body contains child elements.");
		LoggerReader.error("Test failed: Expected to navigate to Practice Questions for Stack module, instead found the page blank!");
	}



}
