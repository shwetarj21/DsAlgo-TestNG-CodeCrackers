package dsAlgo_TestClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dsAlgo_DriverFactory.Driver_Factory;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_Utilities.Listeners_Reporter;


@Listeners(dsAlgo_Utilities.Listeners_Reporter.class)
public class Home_TestClass {
	
	WebDriver driver;
	Home_PageFactory homePage;
	public static final String expectedHomeMessage = "You are not logged in";

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {
        Driver_Factory driverFactory = new Driver_Factory();
        driverFactory.setUp(browser); 
        driver = Driver_Factory.getDriver();
//        Driver_Factory.getDriver(); // Ensures the driver is initialized properly
        
        homePage = new Home_PageFactory();
		homePage.launchUrl();
		homePage.getStartedHomeBtnClick();
    }

//	@BeforeMethod
//	public void launchHome() {
//		homePage = new Home_PageFactory(driver);
//		homePage.launchUrl();
//		homePage.getStartedHomeBtnClick();
//	}

	@Test
	public void arraysClick() {
		homePage.dataStructureDropDownClick();
		homePage.arraysBtnClick();
		assertMessage();
	}

	@Test
	public void linkedListClick() {
		homePage.dataStructureDropDownClick();
		homePage.linkedListBtnClick();
		assertMessage();
	}

	@Test
	public void stackClick() {
		homePage.dataStructureDropDownClick();
		homePage.stackBtnClick();
		assertMessage();
	}

	@Test

	public void queueClick() {
		homePage.dataStructureDropDownClick();
		homePage.queueBtnClick();
		assertMessage();
	}

	@Test
	public void treeClick() {
		homePage.dataStructureDropDownClick();
		homePage.treeBtnClick();
		assertMessage();
	}

	@Test
	public void graphClick() {
		homePage.dataStructureDropDownClick();
		homePage.graphBtnClick();
		assertMessage();
	}

	public void assertMessage() {
		String homeText = homePage.getHomeLogMessage();
		Assert.assertEquals(homeText, expectedHomeMessage);
	}
	
    @AfterMethod
    public void tearDown() {
        Driver_Factory driverFactory = new Driver_Factory();
        driverFactory.tearDown(); // Ensures driver is quit and removed properly
    }
}
