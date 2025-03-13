package dsAlgo_TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.LinkedList_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_Utilities.LoggerReader;
import dsAlgo_Utilities.TryEditor;

@Listeners(dsAlgo_Utilities.Listeners_Reporter.class)

public class LinkedList_TestClass extends BaseClass {

	private String username;
	private String password;

	Home_PageFactory homePage;
	Login_PageFactory loginPage;
	LinkedList_PageFactory linkedListPage;
	TryEditor tryEditor;

	public LinkedList_TestClass(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Factory(dataProvider = "validLoginDataBaseClass", dataProviderClass = BaseClass.class)
	public static Object[] linkedListFactory(String username, String password) {
		return new Object[] { new LinkedList_TestClass(username, password) };
	}

	@Test(priority = 1)
	public void callValidLogInData() throws InterruptedException {
		linkedListPage = new LinkedList_PageFactory();
		validLoginDataBase(username, password);
		linkedListPage.getStartedLinkedListBtnClick();
		boolean isDisplayed = linkedListPage.linkedListTitleDisplayed();
		Assert.assertTrue(isDisplayed, "Linked List title is not displayed");
		LoggerReader.info("User is in Linked List page");
	}

	@Test(priority = 2)
	public void introductionNavigation() throws InterruptedException {
		callValidLogInData();
		linkedListPage.introductionLinkClick();
		boolean isDisplayed = linkedListPage.introductionTitleDisplayed();
		Assert.assertTrue(isDisplayed, "Introduction Link is not displayed");
		LoggerReader.info("User is in Linked List page - Introduction link");
	}

	@Test(priority = 3, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	public void introductionTryHere(String sheetName, int rowNumber) throws InterruptedException, IOException {
		callValidLogInData();
		linkedListPage.introductionLinkClick();
		linkedListPage.tryHereBtnClick();
		linkedListPage.tryEditorWindow(sheetName, rowNumber);
		boolean isDisplayed = linkedListPage.runBtnDisplayed();
		Assert.assertTrue(isDisplayed, "Try Here window is not displayed");
		LoggerReader.info("User is in Linked List page - Introduction link - Try Here window");
	}

	@Test(priority = 4)
	public void clickRunWithNoCodeIntroductionTryHere() throws IOException, InterruptedException {
		callValidLogInData();
		linkedListPage.introductionLinkClick();
		linkedListPage.tryHereBtnClick();
		linkedListPage.runBtnClick();
		Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
		LoggerReader.info("User is in Linked List page - Introduction link - Try Here window");
	}

	@Test(priority = 5)
	public void creatingLinkedListNavigation() throws InterruptedException {
		callValidLogInData();
		linkedListPage.creatingLinkedListLinkClick();
		boolean isDisplayed = linkedListPage.creatingLinkedListTitleDisplayed();
		Assert.assertTrue(isDisplayed, "Creating Linked List Link is not displayed");
		LoggerReader.info("User is in Linked List page - Creating Linked List link");
	}

	@Test(priority = 6, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	public void creatingLinkedListTryHere(String sheetName, int rowNumber) throws InterruptedException, IOException {
		callValidLogInData();
		linkedListPage.creatingLinkedListLinkClick();
		linkedListPage.tryHereBtnClick();
		linkedListPage.tryEditorWindow(sheetName, rowNumber);
		boolean isDisplayed = linkedListPage.runBtnDisplayed();
		Assert.assertTrue(isDisplayed, "Try Here window is not displayed");
		LoggerReader.info("User is in Linked List page - Creating Linked List link - Try Here window");
	}

	@Test(priority = 7)
	public void clickRunWithNoCodeCreatingLinkedListTryHere() throws IOException, InterruptedException {
		callValidLogInData();
		linkedListPage.creatingLinkedListLinkClick();
		linkedListPage.tryHereBtnClick();
		linkedListPage.runBtnClick();
		Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
		LoggerReader.info("User is in Linked List page - Creating Linked List link - Try Here window");
	}

	@Test(priority = 8)
	public void typesOfLinkedListNavigation() throws InterruptedException {
		callValidLogInData();
		linkedListPage.typesOfLinkedListLinkClick();
		boolean isDisplayed = linkedListPage.typesOfLinkedListTitleDisplayed();
		Assert.assertTrue(isDisplayed, "Types Of Linked List Link is not displayed");
		LoggerReader.info("User is in Linked List page - Types Of Linked List link");
	}

	@Test(priority = 9, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	public void typesOfLinkedListTryHere(String sheetName, int rowNumber) throws InterruptedException, IOException {
		callValidLogInData();
		linkedListPage.typesOfLinkedListLinkClick();
		linkedListPage.tryHereBtnClick();
		linkedListPage.tryEditorWindow(sheetName, rowNumber);
		boolean isDisplayed = linkedListPage.runBtnDisplayed();
		Assert.assertTrue(isDisplayed, "Try Here window is not displayed");
		LoggerReader.info("User is in Linked List page - Types Of Linked List link - Try Here window");
	}

	@Test(priority = 10)
	public void clickRunWithNoCodeTypesOfLinkedListTryHere() throws IOException, InterruptedException {
		callValidLogInData();
		linkedListPage.typesOfLinkedListLinkClick();
		linkedListPage.tryHereBtnClick();
		linkedListPage.runBtnClick();
		Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
		LoggerReader.info("User is in Linked List page - Types Of Linked List link - Try Here window");
	}

	@Test(priority = 11)
	public void implementLinkedListNavigation() throws InterruptedException {
		callValidLogInData();
		linkedListPage.implementLinkedListLinkClick();
		boolean isDisplayed = linkedListPage.implementLinkedListTitleDisplayed();
		Assert.assertTrue(isDisplayed, "Implement Linked List in Python Link is not displayed");
		LoggerReader.info("User is in Linked List page - Implement Linked List in Python link");
	}

	@Test(priority = 12, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	public void implementLinkedListTryHere(String sheetName, int rowNumber) throws InterruptedException, IOException {
		callValidLogInData();
		linkedListPage.implementLinkedListLinkClick();
		linkedListPage.tryHereBtnClick();
		linkedListPage.tryEditorWindow(sheetName, rowNumber);
		boolean isDisplayed = linkedListPage.runBtnDisplayed();
		Assert.assertTrue(isDisplayed, "Try Here window is not displayed");
		LoggerReader.info("User is in Linked List page - Implement Linked List in Python link - Try Here window");
	}

	@Test(priority = 13)
	public void clickRunWithNoCodeImplementLinkedListTryHere() throws IOException, InterruptedException {
		callValidLogInData();
		linkedListPage.implementLinkedListLinkClick();
		linkedListPage.tryHereBtnClick();
		linkedListPage.runBtnClick();
		Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
		LoggerReader.info("User is in Linked List page - Implement Linked List in Python link - Try Here window");
	}

	@Test(priority = 14)
	public void traversalNavigation() throws InterruptedException {
		callValidLogInData();
		linkedListPage.traversalLinkClick();
		boolean isDisplayed = linkedListPage.traversalTitleDisplayed();
		Assert.assertTrue(isDisplayed, "Traversal Link is not displayed");
		LoggerReader.info("User is in Linked List page - Traversal link");
	}

	@Test(priority = 15, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	public void traversalTryHere(String sheetName, int rowNumber) throws InterruptedException, IOException {
		callValidLogInData();
		linkedListPage.traversalLinkClick();
		linkedListPage.tryHereBtnClick();
		linkedListPage.tryEditorWindow(sheetName, rowNumber);
		boolean isDisplayed = linkedListPage.runBtnDisplayed();
		Assert.assertTrue(isDisplayed, "Try Here window is not displayed");
		LoggerReader.info("User is in Linked List page - Traversal link - Try Here window");
	}

	@Test(priority = 16)
	public void clickRunWithNoCodeTraversalTryHere() throws IOException, InterruptedException {
		callValidLogInData();
		linkedListPage.traversalLinkClick();
		linkedListPage.tryHereBtnClick();
		linkedListPage.runBtnClick();
		Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
		LoggerReader.info("User is in Linked List page - Traversal link - Try Here window");
	}

	@Test(priority = 17)
	public void insertionNavigation() throws InterruptedException {
		callValidLogInData();
		linkedListPage.insertionLinkClick();
		boolean isDisplayed = linkedListPage.insertionTitleDisplayed();
		Assert.assertTrue(isDisplayed, "Insertion Link is not displayed");
		LoggerReader.info("User is in Linked List page - Insertion link");
	}

	@Test(priority = 18, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	public void insertionTryHere(String sheetName, int rowNumber) throws InterruptedException, IOException {
		callValidLogInData();
		linkedListPage.insertionLinkClick();
		linkedListPage.tryHereBtnClick();
		linkedListPage.tryEditorWindow(sheetName, rowNumber);
		boolean isDisplayed = linkedListPage.runBtnDisplayed();
		Assert.assertTrue(isDisplayed, "Try Here window is not displayed");
		LoggerReader.info("User is in Linked List page - Insertion link - Try Here window");
	}

	@Test(priority = 19)
	public void clickRunWithNoCodeInsertionTryHere() throws IOException, InterruptedException {
		callValidLogInData();
		linkedListPage.insertionLinkClick();
		linkedListPage.tryHereBtnClick();
		linkedListPage.runBtnClick();
		Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
		LoggerReader.info("User is in Linked List page - Insertion link - Try Here window");
	}

	@Test(priority = 20)
	public void deletionNavigation() throws InterruptedException {
		callValidLogInData();
		linkedListPage.deletionLinkClick();
		boolean isDisplayed = linkedListPage.deletionTitleDisplayed();
		Assert.assertTrue(isDisplayed, "Deletion Link is not displayed");
		LoggerReader.info("User is in Linked List page - Deletion link");
	}

	@Test(priority = 21, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	public void deletionTryHere(String sheetName, int rowNumber) throws InterruptedException, IOException {
		callValidLogInData();
		linkedListPage.deletionLinkClick();
		linkedListPage.tryHereBtnClick();
		linkedListPage.tryEditorWindow(sheetName, rowNumber);
		boolean isDisplayed = linkedListPage.runBtnDisplayed();
		Assert.assertTrue(isDisplayed, "Try Here window is not displayed");
		LoggerReader.info("User is in Linked List page - Deletion link - Try Here window");
	}

	@Test(priority = 22)
	public void clickRunWithNoCodeDeletionTryHere() throws IOException, InterruptedException {
		callValidLogInData();
		linkedListPage.deletionLinkClick();
		linkedListPage.tryHereBtnClick();
		linkedListPage.runBtnClick();
		Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
		LoggerReader.info("User is in Linked List page - Deletion link - Try Here window");
	}

	@Test(priority = 23)
	public void practiceQuestionsNavigation() throws InterruptedException {
		callValidLogInData();
		linkedListPage.deletionLinkClick();
		linkedListPage.practiceQuestionsLinkClick();
		Thread.sleep(2000);
		boolean isDisplayed = linkedListPage.practiceQuestionsLinkDisplayed();
		Assert.assertTrue(isDisplayed, "Practice Questions not displayed");
		LoggerReader.info("User is in Linked List page - Practice Questions Page");
	}
}
