package dsAlgo_BaseClass;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import dsAlgo_DriverFactory.Driver_Factory;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.ExcelReader;
import dsAlgo_Utilities.Listeners_Reporter;

import dsAlgo_Utilities.LoggerReader;
import dsAlgo_PageFactory.Stack_PageFactory;
import com.aventstack.chaintest.plugins.ChainTestListener;

import dsAlgo_TestClasses.Stack_TestClass;

//@Listeners(Listeners_Test.class)
public class BaseClass {
    
   public WebDriver driver;  
    Home_PageFactory homePage;
	Login_PageFactory loginPage;

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {
        Driver_Factory driverFactory = new Driver_Factory();
        driverFactory.setUp(browser); 
        driver = Driver_Factory.getDriver();
        ChainTestListener.log("Browser factory setup");
//        Driver_Factory.getDriver(); // Ensures the driver is initialized properly
    }
//	
//	  public WebDriver driver;
//	    Home_PageFactory homePage;
//	    Login_PageFactory loginPage;
//
//	    @BeforeMethod
//	    public void setup() {
//	        driver = Driver_Factory.getDriver(); // Get driver directly from Driver_Factory
//	    }
	
    
    @DataProvider(name = "validLoginDataBaseClass")
    public static Object[][] validLoginDataBaseClass() throws IOException {
        String sheetName = "Login_Valid";
        int rowCount = 1;
        Object[][] userData = new Object[rowCount][2];
        for (int i = 0; i < rowCount; i++) {
            userData[i] = ExcelReader.excelDataRead(sheetName, i + 1);
        }
        return userData;
    }
    
 
	@Test(dataProvider = "validLoginDataBaseClass")
	public void validLoginDataBase(String username, String password) {
		homePage = new Home_PageFactory();
		loginPage = new Login_PageFactory();
		
		homePage.launchUrl();
		homePage.getStartedHomeBtnClick();
		loginPage.signInClick();
		loginPage.userNameLoginBtn.sendKeys(username);
		loginPage.passwordLoginBtn.sendKeys(password);
		loginPage.LoginBtnClick();
		
	} 
	
	@DataProvider(name = "pythoncode_tryeditor")
    public Object[][] getData() {
        return new Object[][] {
            { "TryEditor", 1 },  // Add the sheet name and row number here
            { "TryEditor", 2 },  // Another set of data
            { "TryEditor", 3 }
        };
    }
	
	

    @AfterMethod
    public void tearDown() {
        Driver_Factory driverFactory = new Driver_Factory();
        driverFactory.tearDown(); // Ensures driver is quit and removed properly
    }
	
    @AfterMethod
	public void takeScreenshotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE && driver != null) {
			LoggerReader.info("Test failed: " + result.getName() + ". Attaching screenshot to Allure.");
			Listeners_Reporter.attachScreenshotToAllure(driver);
	    }
	}
	
	        
	    }
    
    


