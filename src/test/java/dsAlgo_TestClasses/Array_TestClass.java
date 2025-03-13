package dsAlgo_TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Array_PageFactory;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_Utilities.DataProvider_Class;
import dsAlgo_Utilities.LoggerReader;

@Listeners(dsAlgo_Utilities.Listeners_Reporter.class)

public class Array_TestClass extends BaseClass{

	private String username;
    private String password;
	String ExpectedOutput;
	
	Array_PageFactory ArrayPage;
	Home_PageFactory homePageFactory;
	Login_PageFactory loginPageFactory;
	
	public Array_TestClass() throws IOException {
		Object[][] userLoginData = validLoginDataBaseClass();
	     this.username = userLoginData[0][0].toString();
        this.password = userLoginData[0][1].toString();
	
	}
	
	@Test(priority=1)
	public void LogIn() throws IOException, InterruptedException {
		ArrayPage = new Array_PageFactory();
		validLoginDataBase(username, password);
		 LoggerReader.info("User is logged in into Dsalgo portal");
		}
	
	@Test(priority=2)
	public void arrayDropdownList() throws InterruptedException, IOException {
		LogIn();
		ArrayPage.arrayDropdownSelection();
		 LoggerReader.info("User is navigate to Array page after selecting Array in dropdown");
	}
	
	@Test(priority=3)
	public void ArrayGetStarted() throws InterruptedException, IOException {
		LogIn();
		ArrayPage.arrayGetStartedBtn();
		 LoggerReader.info("User is navigate to Array page after clicking on GetStarted Button");
	}
	
	@Test(priority=4)
	public void arrayDisplayTitle() throws InterruptedException, IOException {	
		ArrayGetStarted();
		Assert.assertEquals(ArrayPage.arrayDisplayTitle(), true);
		 LoggerReader.info("User is validating Array page is displayed");
		
	}
	
	@Test(priority=5)
	public void ArrayInPythonLink() throws InterruptedException, IOException {
		ArrayGetStarted();
		Assert.assertEquals(ArrayPage.arrayInPythinLink(),true);
		 LoggerReader.info("User is validating Array In Python Link is enabled");
	}
	
	@Test(priority=6)
	public void NavigateTOArrayInPython() throws InterruptedException, IOException {
		ArrayGetStarted();
		ArrayPage.arrayInPythonClicked();
		 LoggerReader.info("User click on Array In Python page");
	}
	
	@Test(priority=7)
	public void validateArrayInPython() throws InterruptedException, IOException {
		NavigateTOArrayInPython();
		Assert.assertEquals(ArrayPage.ValidateArrayInPythonPage(),true);
		 LoggerReader.info("User is navigate to Array In Python page");
	}
	
	@Test(priority=8)
	public void ArrayInPythonTryHere() throws InterruptedException, IOException {
		NavigateTOArrayInPython();
		Assert.assertEquals(ArrayPage.arrayInPythinLink(),true);
		 LoggerReader.info("User is validating Array In Python page Try Here Button");
	}

	@Test(priority=9)
	public void ArrayInPythonTryHereBtn() throws InterruptedException, IOException {
		NavigateTOArrayInPython();
		ArrayPage.tryHereBtn();
		 LoggerReader.info("User is navigate to Array In Python page Try Here Button");
	}
	
	@Test(priority=10)
	public void ValidateArrayInPythonTryHereBtn() throws InterruptedException, IOException {
		ArrayInPythonTryHereBtn();
		Assert.assertEquals(ArrayPage.NavigateToTryHereBtn(),true);
		 LoggerReader.info("User is validating Array In Python page Try Here page navigated");
	}
	
	@Test(priority=11, dataProvider = "ArrayExcelData", dataProviderClass = DataProvider_Class.class)
	public void TestArrayInPythonCode(String pythonCode, String output) throws IOException, InterruptedException {
		ValidateArrayInPythonTryHereBtn();
		ExpectedOutput = output;
		String actualOutcome = ArrayPage.readExcel_forTryHereArray(pythonCode, output);
		Assert.assertEquals(actualOutcome, output);
		 LoggerReader.info("Testing the python code and validate the actual result with expected");
	}
	
	@Test(priority= 12)
	public void ArrayUsingList() throws InterruptedException, IOException {
		ArrayGetStarted();
		ArrayPage.arrayUsingListlink();
		 LoggerReader.info("User is navigatate to Array Using List Page");
	}
	
	@Test(priority= 13)
	public void validateArrayUsingListpage() throws InterruptedException, IOException {
		ArrayUsingList();
		Assert.assertEquals(ArrayPage.arrayUsingListPageDisplay(),true);
		 LoggerReader.info("User is Validating array using list page");
	}
	
	@Test(priority= 14)
	public void TryHereArrayUsingbtn() throws InterruptedException, IOException {
		ArrayUsingList();
		ArrayPage.tryHereBtn();
		 LoggerReader.info("User is navigatate to testing the Python codeafter clicking on Try Here");
	}

	@Test(priority= 15,dataProvider = "ArrayExcelData",dataProviderClass =DataProvider_Class.class)
	public void TestArrayUsingListCode(String pythonCode, String output) throws IOException, InterruptedException {
		TryHereArrayUsingbtn();
		ExpectedOutput = output;
		String actualOutcome = ArrayPage.readExcel_forTryHereArray(pythonCode, output);
		Assert.assertEquals(actualOutcome, output);
		 LoggerReader.info("Testing the python code and validate the actual result with expected");
	}
	
	@Test(priority= 16)
	public void BasicOperationList() throws InterruptedException, IOException {
		ArrayGetStarted();
		ArrayPage.BasicOperationListLink();
		 LoggerReader.info("User is clicking on Basic operation list");
	}
	
	@Test(priority= 17)
	public void NavigateToBasicOperationListPage() throws InterruptedException, IOException {
		BasicOperationList();
		Assert.assertEquals(ArrayPage.InBasicOprPage(),true);
		 LoggerReader.info("User is navigatate to Basic Operation List Page");
	}
	
	@Test(priority= 18)
	public void TryHereBasicOprList() throws InterruptedException, IOException {
		BasicOperationList();
		ArrayPage.tryHereBtn();
		LoggerReader.info("User is clicking on Try here button of Basic Operation List Page");
	}

	@Test(priority= 19,dataProvider = "ArrayExcelData",dataProviderClass =DataProvider_Class.class)
	public void TestForBasicOprListCode(String pythonCode, String output) throws IOException, InterruptedException {
		TryHereBasicOprList();
		//ExpectedOutput = output;
		String actualOutcome = ArrayPage.readExcel_forTryHereArray(pythonCode, output);
		Assert.assertEquals(actualOutcome, output);
		 LoggerReader.info("Testing the python code and validate the actual result with expected");
	}
	
	@Test(priority= 20)
	public void BasicOprListRunBtnWithoutCode() throws InterruptedException, IOException {
		TryHereBasicOprList();
		ArrayPage.RunBtnForNoCodeError();
		Assert.assertEquals("","Enter code in text area");
		LoggerReader.error("Checking error message after clicking run button without entering code");
	}
	
	
	@Test(priority= 21)
	public void ApplicationOfArray()  throws InterruptedException, IOException {
		BasicOperationList();
		ArrayPage.ApplicationOfArrayClick();
		 LoggerReader.info("User is clicking on to Application of Array Page");
	}
	
	@Test(priority= 22)
	public void NAvigateToApplicationOfArray() throws InterruptedException, IOException {
		ApplicationOfArray();
		Assert.assertEquals(ArrayPage.applcationOfArrayDisplay(),true);
		 LoggerReader.info("validating user is navigating to Application of Array Page");
	}

	@Test(priority= 23)
	public void TryHereApplicationOfArray() throws InterruptedException, IOException {
		ApplicationOfArray();
		ArrayPage.tryHereBtn();
		 LoggerReader.info("User is navigating to Try Here page of Application of Array Page");
	}
	
	@Test(priority=24,dataProvider = "ArrayExcelData",dataProviderClass =DataProvider_Class.class)
	public void TestApplicationOfArrayCode(String pythonCode, String output) throws IOException, InterruptedException {
		TryHereApplicationOfArray();
		ExpectedOutput = output;
		String actualOutcome = ArrayPage.readExcel_forTryHereArray(pythonCode, output);
		Assert.assertEquals(actualOutcome, output);
		 LoggerReader.info("Testing the python code and validate the actual result with expected");
	}
	
	@Test(priority= 25)
	public void ApplicationOfArrayRunBtnWithoutCode() throws InterruptedException, IOException {
		TryHereApplicationOfArray();
		ArrayPage.RunBtnForNoCodeError();
		Assert.assertEquals("","Enter code in text area");
		LoggerReader.error("Checking error message after clicking run button without entering code");
	}
	@Test(priority= 26)
	public void PracticeQuestionLink() throws InterruptedException, IOException {
		ApplicationOfArray();
		ArrayPage.PracticeQuePage();
		 LoggerReader.info("User is clicking to Practice question Page");
	}
	
	@Test(priority= 27)
	public void NavigateToPracticeQuestion() throws InterruptedException, IOException {
		PracticeQuestionLink();
		Assert.assertEquals(ArrayPage.InPracticeQuePage(),true);
		 LoggerReader.info("User is navigate to Practice question Page");
	}
	
	@Test(priority= 28)
	public void searchTheArrayPage() throws InterruptedException, IOException {
		PracticeQuestionLink();
		ArrayPage.SearchArrayClick();
		 LoggerReader.info("User is clicking on Search the array page");
		
	}
	
	@Test(priority= 29)
	public void NavigateToSearchTheArrayTextArea() throws InterruptedException, IOException {
		searchTheArrayPage();
		Assert.assertEquals(ArrayPage.displayTryHereText(),true);
		 LoggerReader.info("User is Navigating To Search The Array TextArea");
		
	}
	
	@Test(priority=30,dataProvider = "ArrayExcelData",dataProviderClass =DataProvider_Class.class)
	public void TestSearchArrayCode(String pythonCode, String output) throws IOException, InterruptedException {
		NavigateToSearchTheArrayTextArea();
		ExpectedOutput = output;
		String actualOutcome = ArrayPage.readExcel_forTryHereArray(pythonCode, output);
		Assert.assertEquals(actualOutcome, output);
		 LoggerReader.info("Testing the python code and validate the actual result with expected");
	}
	
	@Test(priority= 31)
	public void clickSearchArrayRunBtnWithoutCode() throws InterruptedException, IOException {
		NavigateToSearchTheArrayTextArea();
		ArrayPage.RunbtnwithoutCode();	
		Assert.assertEquals("","Enter valid code");
		LoggerReader.error("Checking error message after clicking run button without entering code");
	}

	@Test(priority= 32)
	public void clickSubmitBtnSearchArrayWithoutCode() throws InterruptedException, IOException {
		NavigateToSearchTheArrayTextArea();
		searchTheArrayPage();	
		ArrayPage.SubmitbtnwithoutCode();
		LoggerReader.error("Checking error message after clicking Submit button without entering code");
		Assert.assertEquals("Error occurred during submission",ArrayPage.SubmitbtnwithoutCode());
	}
	
	@Test(priority= 33)
	public void MaxConsOne() throws InterruptedException, IOException {
		PracticeQuestionLink();
		ArrayPage.clickOnMaxConsecutive();
		LoggerReader.info("User is clicking on MaxConsecutive");
	
	}
	
	@Test(priority= 34)
	public void NavigateToMaxConsOneTextArea() throws InterruptedException, IOException {
		MaxConsOne();
		Assert.assertEquals(ArrayPage.displayTryHereText(),true);
		LoggerReader.info("User is Navigate To MaxConsecutive One TextArea");
		
	}
	
	@Test(priority=35,dataProvider = "ExcelDataMaxConsOne",dataProviderClass =DataProvider_Class.class)
	public void TestMaxConsOneCode(String pythonCode, String output) throws IOException, InterruptedException {
		MaxConsOne();
		ExpectedOutput = output;

		String actualOutcome = ArrayPage.readExcel_forTryHereArray(pythonCode, output);
		Assert.assertEquals(actualOutcome, output);
		 LoggerReader.info("Testing the python code and validate the actual result with expected");
	}

	@Test(priority= 36)
	public void clickRunBtnMaxConsOneWithoutCode() throws InterruptedException, IOException {
		NavigateToMaxConsOneTextArea();
		ArrayPage.RunbtnwithoutCode();
		Assert.assertEquals("","Enter valid code");
		LoggerReader.error("Checking error message after clicking run button without entering code");
		
	}
	@Test(priority= 37)
	public void clickSubmitBtnMaxConsOneWithoutCode() throws InterruptedException, IOException {
		NavigateToMaxConsOneTextArea();
		ArrayPage.SubmitbtnwithoutCode();
		Assert.assertEquals(ArrayPage.SubmitbtnwithoutCode(),"Error occurred during submission");
		LoggerReader.error("Checking error message after clicking Submit button without entering code");
	}
	
	@Test(priority= 38)
	public void EvenNumDigits() throws InterruptedException, IOException {
		PracticeQuestionLink();
		ArrayPage.FindEvenNumber();
		LoggerReader.info("User is clicking on Even Number digits Digits link");
		
	}
	
	@Test(priority= 39)
	public void NavigateToEvenNumDigits() throws InterruptedException, IOException {
		EvenNumDigits();
	Assert.assertEquals(ArrayPage.displayTryHereText(),true);
	LoggerReader.info("User is Navgate to Even Number digits Digits link");
	}
	
	@Test(priority=40,dataProvider = "ExcelDataMaxConsOne",dataProviderClass =DataProvider_Class.class)
	public void TestEvenNumDigitsCode(String pythonCode, String output) throws IOException, InterruptedException {
		NavigateToEvenNumDigits();
		ExpectedOutput = output;
		String actualOutcome = ArrayPage.readExcel_forTryHereArray(pythonCode, output);
		Assert.assertEquals(actualOutcome, output);
		 LoggerReader.info("Testing the python code and validate the actual result with expected");
	}
	
	@Test(priority=41)
	public void clickRunBtnEvenNumDigitsWithoutCode() throws InterruptedException, IOException {
		NavigateToEvenNumDigits();
		ArrayPage.RunbtnwithoutCode();
		Assert.assertEquals("","Enter valid code");
		LoggerReader.error("Checking error message after clicking run button without entering code for Even Num Digits");
		
	}
	@Test(priority= 42)
	public void clickSubmitBtnEvenNumDigitsWithoutCode() throws InterruptedException, IOException {
		NavigateToEvenNumDigits();
		ArrayPage.SubmitbtnwithoutCode();
		Assert.assertEquals(ArrayPage.SubmitbtnwithoutCode(),"Error occurred during submission");
		LoggerReader.error("Checking error message after clicking Submit button without entering code for Even Num Digits");
	}
	
	@Test(priority=43)
	public void SortedArray() throws InterruptedException, IOException {
		PracticeQuestionLink();		
	ArrayPage.SortedArray();
	LoggerReader.info("User is clicking on sorted array page");
	
	}
	
	@Test(priority= 44)
	public void NavigateToSortedArray() throws InterruptedException, IOException {
		SortedArray();
	Assert.assertEquals(ArrayPage.displayTryHereText(),true);
	LoggerReader.info("User is Navigate To Sorted Array");
	}
	
	@Test(priority=45,dataProvider ="ExcelDataSortedArray",dataProviderClass=DataProvider_Class.class)
	public void TestSortedArrayCode(String pythonCode, String output) throws IOException, InterruptedException {
		NavigateToSortedArray();
		ExpectedOutput = output;
		String actualOutcome = ArrayPage.readExcel_forTryHereArray(pythonCode, output);
		Assert.assertEquals(actualOutcome, output);
		 LoggerReader.info("Testing the python code and validate the actual result with expected");
	}
	
	@Test(priority= 46)
	public void clickRunBtnSortedArrayWithoutCode() throws InterruptedException, IOException {
		NavigateToSortedArray();
		ArrayPage.RunbtnwithoutCode();
		Assert.assertEquals("","Enter valid code");
		LoggerReader.error("Checking error message after clicking run button without entering code fro sorted Array");
	}
	@Test(priority= 47)
	public void clickSubmitBtnSortedArrayWithoutCode() throws InterruptedException, IOException {
		NavigateToSortedArray();
		ArrayPage.SubmitbtnwithoutCode();
		Assert.assertEquals(ArrayPage.SubmitbtnwithoutCode(),"Error occurred during submission");
		LoggerReader.error("Checking error message after clicking Submit button without entering code for sorted Array");
	}
}
