package dsAlgo_TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_PageFactory.Queue_PageFactory;
import dsAlgo_Utilities.LoggerReader;

@Listeners(dsAlgo_Utilities.Listeners_Reporter.class)
public class Queue_TestClass extends BaseClass {


	Home_PageFactory homePage;
	Login_PageFactory loginPage;
	Queue_PageFactory queuePage;

	private String username;
	private String password;


	public Queue_TestClass(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Factory(dataProvider = "validLoginDataBaseClass")
	public static Object[] createInstances(String username, String password) {
		return new Object[] { new Queue_TestClass(username, password) };
	}

	@Test
	public void callValidLogInData() throws InterruptedException {
		queuePage = new Queue_PageFactory();
		validLoginDataBase(username, password);
		queuePage.QueueGetStarted();
		
		Assert.assertTrue(queuePage.Queuetitileisdisplayed());
		LoggerReader.info("Logging :::::: Click on GetStarted button under Queue section");
	}

	@Test (priority=1)
	public void ImplementationofQueueinPython() throws IOException,InterruptedException { 
		callValidLogInData();
		queuePage.Implementation_Of_Queue_In_Python_Click();
		
		Assert.assertTrue(queuePage.implementationofqueuetitle());
		LoggerReader.info("Logging :::::: Click on Implementation of Queue in Python under Queue Section");
	}

	@Test (priority=2)
	public void Implementationusingcollectionsdeque() throws IOException,InterruptedException { 
		callValidLogInData();
		queuePage.Implementation_Using_Collection_deque_Click();
		
		Assert.assertTrue(queuePage.implementationcollectiontitle());
		LoggerReader.info("Logging :::::: Click on Implementation using Collections deque under Queue Section");
	}

	@Test (priority=3)
	public void Implementationusingarray() throws IOException,InterruptedException { 
		callValidLogInData();
		queuePage.Implementation_Using_Array_Click();
		
		Assert.assertTrue(queuePage.implementationusingarraytitle());
		LoggerReader.info("Logging :::::: Click on Implementation using Array under Queue Section");
	}

	@Test (priority=4)
	public void Queueoperations() throws IOException,InterruptedException { 
		callValidLogInData();
		queuePage.Queue_Operations_Click();
		
		Assert.assertTrue(queuePage.queueoperationstitle());
		LoggerReader.info("Logging :::::: Click on Queue Operations under Queue Section");
	}
	
	@Test(priority=5)

	public void checkErrorMessageWhenExecutingWithoutenteringCodeInImplementationofqueueinpython() throws IOException,InterruptedException {
		callValidLogInData();
		queuePage.Implementation_Of_Queue_In_Python_Click();
		queuePage.TryHere_Click(); 
		queuePage.RunButton_Click(); 
		Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
		LoggerReader.error("Logging :::::: Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}

	@Test (priority=6 , dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	public void ImplementationofQueueinPythontryeditor(String sheetName , int rowNumber) throws InterruptedException, IOException { 
		callValidLogInData();
		queuePage.Implementation_Of_Queue_In_Python_Click();
		queuePage.TryHere_Click();
		
		queuePage.tryEditorWindow(sheetName,rowNumber);
		Assert.assertTrue(queuePage.RunButtonEnabled(),"Queue Page Run Button is Enabled");
		LoggerReader.info("Logging :::::: Queue Data Provider Try Editor page is enabled and operations are success");
	}
	
	  @Test(priority = 7)
	    public void navigatebacktoImplementationofqueueinpython() throws InterruptedException {
	    callValidLogInData();
	    queuePage.Implementation_Of_Queue_In_Python_Click();
	    queuePage.TryHere_Click(); 
	    queuePage.navigateback();
	    LoggerReader.info("User navigates back to Operations in stack page");
	    }
	  
		@Test(priority=8)

		public void checkErrorMessageWhenExecutingWithoutenteringCodeInImplementationusingcollectionsdeque() throws IOException,InterruptedException {
			callValidLogInData();
			queuePage.Implementation_Using_Collection_deque_Click();
			queuePage.TryHere_Click(); 
			queuePage.RunButton_Click(); 
			Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
			LoggerReader.error("Logging ::::::Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
		}

	
	@Test (priority=9 , dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	public void Implementationusingcollectionsdequetryeditor(String sheetName , int rowNumber) throws InterruptedException, IOException { 
		callValidLogInData();
		queuePage.Implementation_Using_Collection_deque_Click();
		queuePage.TryHere_Click();
		
		queuePage.tryEditorWindow(sheetName,rowNumber);
		Assert.assertTrue(queuePage.RunButtonEnabled(),"Queue Page Run Button is Enabled");
		LoggerReader.info("Logging :::::: Queue Data Provider Try Editor page is enabled and operations are success");
	}
	
	  @Test(priority = 10)
	    public void navigatebacktoImplementationcollection() throws InterruptedException {
	    callValidLogInData();
	    queuePage.Implementation_Using_Collection_deque_Click();
	    queuePage.TryHere_Click(); 
	    queuePage.navigateback();
	    LoggerReader.info("User navigates back to Operations in stack page");
	    }

		@Test(priority=11)

		public void checkErrorMessageWhenExecutingWithoutenteringCodeInImplementationusingarray() throws IOException,InterruptedException {
			callValidLogInData();
			queuePage.Implementation_Using_Array_Click();
			queuePage.TryHere_Click(); 
			queuePage.RunButton_Click(); 
			Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
			LoggerReader.error("Logging :::::: Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
		}


	@Test (priority=12 , dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	public void Implementationusingarraytryeditor(String sheetName , int rowNumber) throws InterruptedException, IOException { 
		callValidLogInData();
		queuePage.Implementation_Using_Array_Click();
		queuePage.TryHere_Click();
		
		queuePage.tryEditorWindow(sheetName,rowNumber);
		Assert.assertTrue(queuePage.RunButtonEnabled(),"Queue Page Run Button is Enabled");
		LoggerReader.info("Logging :::::: Queue Data Provider Try Editor page is enabled and operations are success");
	}
	
	  @Test(priority = 13)
	    public void navigatebacktoImplementationusingarray() throws InterruptedException {
	    callValidLogInData();
	    queuePage.Implementation_Using_Array_Click();
	    queuePage.TryHere_Click(); 
	    queuePage.navigateback();
	    LoggerReader.info("User navigates back to Operations in stack page");
	    }
	
		@Test(priority=14)

		public void checkErrorMessageWhenExecutingWithoutenteringCodeInQueueoperations() throws IOException,InterruptedException {
			callValidLogInData();
			queuePage.Queue_Operations_Click();
			queuePage.TryHere_Click(); 
			queuePage.RunButton_Click(); 
			Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
			LoggerReader.error("Logging :::::: Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
		}


	@Test (priority=15 , dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	public void Queueoperationstryeditor(String sheetName , int rowNumber) throws InterruptedException, IOException { 
		callValidLogInData();
		queuePage.Queue_Operations_Click();
		queuePage.TryHere_Click();
		
		queuePage.tryEditorWindow(sheetName,rowNumber);
		Assert.assertTrue(queuePage.RunButtonEnabled(),"Queue Page Run Button is Enabled");
		LoggerReader.info("Logging :::::: Queue Data Provider Try Editor page is enabled and operations are success");
	}

	 @Test(priority = 16)
	    public void navigatebacktoQueueoperations() throws InterruptedException {
	    callValidLogInData();
	    queuePage.Queue_Operations_Click();
	    queuePage.TryHere_Click(); 
	    queuePage.navigateback();
	    LoggerReader.info("User navigates back to Operations in stack page");
	    }

	  @Test(priority=17)
	  public void navigateToImplementationofQueueinPythonPracticeQuestions() throws IOException,InterruptedException { 
		  callValidLogInData();
		  queuePage.Implementation_Of_Queue_In_Python_Click();
		  queuePage.Practice_Questions_Click();
		  Assert.assertFalse(queuePage.content().trim().isEmpty(), "Page is blank! Body does not contain text.");
		    Assert.assertFalse(queuePage.childelements().isEmpty(), "Page is not blank! Body contains child elements.");
			LoggerReader.error("Test failed: Expected to navigate to Practice Questions for Queue module, instead found the page blank!");
	  }
	
}


