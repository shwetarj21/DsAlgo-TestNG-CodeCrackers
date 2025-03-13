package dsAlgo_TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.DataStructure_PageFactory;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_Utilities.DataProvider_Class;
import dsAlgo_Utilities.LoggerReader;

@Listeners(dsAlgo_Utilities.Listeners_Reporter.class)

public class DataStructure_TestClass extends BaseClass {

	private String username;
	private String password;
	String ExpectedOutput;
	DataStructure_PageFactory dsPage;
	Home_PageFactory homePageFactory;
	Login_PageFactory loginPageFactory;

	public DataStructure_TestClass() throws IOException {

		Object[][] userLoginData = validLoginDataBaseClass();
		this.username = userLoginData[0][0].toString();
		this.password = userLoginData[0][1].toString();

	}

	@Test(priority = 1)
	public void LogIn() throws IOException, InterruptedException {
		dsPage = new DataStructure_PageFactory();
		validLoginDataBase(username, password);
		LoggerReader.info("User is logged in into Dsalgo portal");

	}

	@Test(priority = 2)
	public void NavigateToTimeComplexity() throws InterruptedException, IOException {
		LogIn();

		dsPage.getStartedDataStructureBtn();
		Assert.assertEquals(dsPage.timeComplexityBtnEnabled(), true);
		dsPage.timecomplexityButtonClick();
		Assert.assertEquals(dsPage.timecomplexityPageEnable(), true);
		dsPage.tryhereButtonClick();
		LoggerReader.info("User is navigated to Try Here button of Time Complexity");

	}
	
	@Test(priority = 3, dataProvider = "ExcelDataDataStructure", dataProviderClass = DataProvider_Class.class)
	public void test(String pythonCode, String output) throws IOException, InterruptedException {
		NavigateToTimeComplexity();
		ExpectedOutput = output;
		String actualOutcome = dsPage.readExcel_fortryhere(pythonCode, output);
		Assert.assertEquals(actualOutcome, output);
		LoggerReader.info("Testing the python code and validate the actual result with expected");
	}

	@Test(priority = 4)
	public void clickRunBtnWithoutCode() throws InterruptedException, IOException {
		NavigateToTimeComplexity();
		dsPage.runBtnClickNoCode();
		Assert.assertEquals(ExpectedOutput, dsPage.errorMessageForRun());
		LoggerReader.error("Checking error message after clicking run button without entering code");
	}

	@Test(priority = 5)
	public void NavigateToPracticeQuestionPage() throws InterruptedException, IOException {
		NavigateToTimeComplexity();
		dsPage.practiceQuestion();
		LoggerReader.error("Checking error message after clicking Practice question Page link");
	}

	@Test(priority = 6)
	public void dataStructureDropDown() throws IOException, InterruptedException {
		LogIn();
		dsPage.DataStructureDropDown();
		boolean element = dsPage.datastructureIntropageDisplayed();
		Assert.assertTrue(element);
		LoggerReader.error("Checking error message after clicking Data Structure Dropdown");
	}
}