package dsAlgo_TestClasses;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_PageFactory.Tree_PageFactory;
import dsAlgo_Utilities.LoggerReader;

@Listeners(dsAlgo_Utilities.Listeners_Reporter.class)

public class Tree_TestClass extends BaseClass{
	private String username;
    private String password;
    
	Home_PageFactory homePage;
	Login_PageFactory loginPage;
    Tree_PageFactory treePage = new Tree_PageFactory();

	public Tree_TestClass(String username, String password) {
    this.username = username;
    this.password = password;
    }

	@Factory(dataProvider = "validLoginDataBaseClass")
    public static Object[] createInstances(String username, String password) {
    return new Object[] { new Tree_TestClass(username, password) };
    }
	
       @Test
	   public void callValidLogInData() throws InterruptedException {
	   treePage = new Tree_PageFactory();
	   validLoginDataBase(username, password);
	   treePage.GetStartedTree();
	   Thread.sleep(2000);
	   LoggerReader.info("User clicks on Get Started under Tree section");
	   }
	
	    @Test(priority = 1)
	    public void OverviewOfTrees() throws InterruptedException {
	    callValidLogInData();
	    Thread.sleep(3000);
        Assert.assertEquals(treePage.OverviewOfTrees_linkenabled(), true);
        treePage.OverviewOfTrees();
        LoggerReader.info("User is on Tree page");
        }
	 
	    @Test(priority = 2)
	    public void OverviewOfTreesTryhere() throws InterruptedException {
	    callValidLogInData();
		Thread.sleep(3000);
        treePage.OverviewOfTrees();
        treePage.Tryhere();
        LoggerReader.info("User clicks on Tryhere button in the Overview Of Trees page");
       }
	    
	    @Test(priority = 3)
	    public void checkErrorMessageWhenExecutingWithoutenteringCodeInOverviewOfTreesPage() throws IOException,InterruptedException {
	    callValidLogInData();
	    treePage.OverviewOfTrees();
	    treePage.Tryhere(); 
	    treePage.RunButton(); 
	    Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
	    LoggerReader.error("Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    }


	    @Test(priority = 4, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	    public void OverviewOfTreesTryeditor(String sheetName, int rowNumber) throws IOException, InterruptedException {
	    callValidLogInData();
		treePage.OverviewOfTrees();
		treePage.Tryhere();
		Thread.sleep(4000);
	    treePage.tryEditorWindow(sheetName,rowNumber);
	    Assert.assertEquals(treePage.RunbuttonEnabled(), true);
		LoggerReader.info("User enters valid and invalid python code in the Tryeditor section of Overview Of Trees page");
        }
	    
	    @Test(priority = 5)
	    public void navigateback() throws InterruptedException {
	    callValidLogInData();
		treePage.OverviewOfTrees();
		treePage.Tryhere();
		treePage.navigateback();
		LoggerReader.info("User navigates back to Overview Of Trees page");
	    }
	    
	    @Test(priority = 6)
	    public void Terminologies() throws InterruptedException {
	    callValidLogInData();
		Thread.sleep(3000);
        Assert.assertEquals(treePage.Terminologies_linkenabled(), true);
        treePage.Terminologies();
        LoggerReader.info("User is on Overview Of Trees page");
        }
	    
	    @Test(priority = 7)
	    public void TerminologiesTryhere() throws InterruptedException {
	    callValidLogInData();
		treePage.Terminologies();
	    treePage.Tryhere();
	    LoggerReader.info("User clicks on Tryhere button in the Terminologies page");
	    }
	    
	    @Test(priority = 8)
	    public void checkErrorMessageWhenExecutingWithoutenteringCodeInTerminologiesPage() throws IOException,InterruptedException {
	    callValidLogInData();
	    treePage.Terminologies();
	    treePage.Tryhere(); 
	    treePage.RunButton(); 
	    Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
	    LoggerReader.error("Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    }
	    
	    @Test(priority = 9, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	    public void TerminologiesTryeditor(String sheetName, int rowNumber) throws IOException, InterruptedException {
	    callValidLogInData();
	 	treePage.Terminologies();
	 	treePage.Tryhere();	
	    treePage.tryEditorWindow(sheetName,rowNumber);
	    Assert.assertEquals(treePage.RunbuttonEnabled(), true);
		LoggerReader.info("User enters valid and invalid python code in the Tryeditor section of Terminologies page");
	    }
	   
    	
	    @Test(priority = 10)
	    public void navigatebacktoTerminologies() throws InterruptedException {
	    callValidLogInData();
 		treePage.Terminologies();
 	    treePage.Tryhere();
		treePage.navigateback();
		LoggerReader.info("User navigates back to Terminologies page");
	    }
		
	    @Test(priority = 11)
	    public void TypesOfTrees() throws InterruptedException {
	    callValidLogInData();
	    Assert.assertEquals(treePage.TypesOfTrees_linkenabled(), true);
		treePage.TypesOfTrees();
		LoggerReader.info("User is on Terminologies page");
	    }
	    
	    @Test(priority = 12)
	    public void TypesOfTreesTryhere() throws InterruptedException {
	    callValidLogInData();
		treePage.TypesOfTrees();
	    treePage.Tryhere();
	    LoggerReader.info("User clicks on Tryhere button in the Types Of Trees page");
	    }
	    
	    @Test(priority = 13)
	    public void checkErrorMessageWhenExecutingWithoutenteringCodeInTypesOfTreesPage() throws IOException,InterruptedException {
	    callValidLogInData();
	    treePage.TypesOfTrees();
	    treePage.Tryhere(); 
	    treePage.RunButton(); 
	    Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
	    LoggerReader.error("Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    }
	    
	    @Test(priority = 14, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	    public void TypesOfTreesTryeditor(String sheetName, int rowNumber) throws IOException, InterruptedException {
	    callValidLogInData();
		treePage.TypesOfTrees();
	    treePage.Tryhere();
		treePage.tryEditorWindow(sheetName,rowNumber);
		Assert.assertEquals(treePage.RunbuttonEnabled(), true);
		LoggerReader.info("User enters valid and invalid python code in the Tryeditor section of Types Of Trees page");
	    }
	    
	    @Test(priority = 15)
	    public void navigatebacktoTypesOfTrees() throws InterruptedException{
	    callValidLogInData();
		treePage.TypesOfTrees();
	    treePage.Tryhere();
		treePage.navigateback();
		LoggerReader.info("User navigates back to Types Of Trees page");
	    }
		
	    @Test(priority = 16)
	    public void TreeTraversals() throws InterruptedException {
	    callValidLogInData();
	    Assert.assertEquals(treePage.TreeTraversals_linkenabled(), true);
		treePage.TreeTraversals();
		LoggerReader.info("User is on Types Of Trees page");
	    }
	    
	    @Test(priority = 17)
	    public void TreeTraversalsTryhere() throws InterruptedException {
	    callValidLogInData();
		treePage.TreeTraversals();
	    treePage.Tryhere();
	    LoggerReader.info("User clicks on Tryhere button in the Tree Traversals page");
	    }
	    
	    @Test(priority = 18)
	    public void checkErrorMessageWhenExecutingWithoutenteringCodeInTreeTraversalsPage() throws IOException,InterruptedException {
	    callValidLogInData();
	    treePage.TreeTraversals();
	    treePage.Tryhere(); 
	    treePage.RunButton(); 
	    Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
	    LoggerReader.error("Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    }
	    
	    @Test(priority = 19, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	    public void TreeTraversalsTryeditor(String sheetName, int rowNumber) throws IOException, InterruptedException {
	    callValidLogInData();
		treePage.TreeTraversals();
	    treePage.Tryhere();
		treePage.tryEditorWindow(sheetName,rowNumber);
		Assert.assertEquals(treePage.RunbuttonEnabled(), true);
		LoggerReader.info("User enters valid and invalid python code in the Tryeditor section of Tree Traversals page");
		}
	    
	    @Test(priority = 20)
	    public void navigatebacktoTreeTraversals() throws InterruptedException{
	    callValidLogInData();
		treePage.TreeTraversals();
	    treePage.Tryhere();
		treePage.navigateback(); 
		LoggerReader.info("User navigates back to Tree Traversals page");
	    }
		
	    @Test(priority = 21)
	    public void TraversalsIllustration() throws InterruptedException {
	    callValidLogInData();
	    Assert.assertEquals(treePage.TraversalsIllustration_linkenabled(), true);
		treePage.TraversalsIllustration();
		LoggerReader.info("User is on Tree Traversals page");
	    }

	    @Test(priority = 22)
	    public void TraversalsIllustrationTryhere() throws InterruptedException {
	    callValidLogInData();
	    treePage.TraversalsIllustration();
	    treePage.Tryhere();
	    LoggerReader.info("User clicks on Tryhere button in the Traversals Illustration page"); 

	    }
		
	    @Test(priority = 23)
	    public void checkErrorMessageWhenExecutingWithoutenteringCodeInTraversalsIllustrationPage() throws IOException,InterruptedException {
	    callValidLogInData();
	    treePage.TraversalsIllustration();
	    treePage.Tryhere(); 
	    treePage.RunButton(); 
	    Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
	    LoggerReader.error("Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    }
	    
	    @Test(priority = 24, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	    public void TraversalsIllustrationTryeditor(String sheetName, int rowNumber) throws IOException, InterruptedException {
	    callValidLogInData();
	    treePage.TraversalsIllustration();
	    treePage.Tryhere();
		treePage.tryEditorWindow(sheetName,rowNumber);
		Assert.assertEquals(treePage.RunbuttonEnabled(), true);
		LoggerReader.info("User enters valid and invalid python code in the Tryeditor section of Traversals Illustration page");
	    }

		
	    @Test(priority = 25)
	    public void navigatebacktoTraversalsIllustration() throws InterruptedException{
	    callValidLogInData();
	    treePage.TraversalsIllustration();
	    treePage.Tryhere();
		treePage.navigateback(); 
		LoggerReader.info("User navigates back to Traversals Illustration page");
	    }
		
	    @Test(priority = 26)
	    public void BinaryTrees() throws InterruptedException {
	    callValidLogInData();
	    Assert.assertEquals(treePage.BinaryTrees_linkenabled(), true);
		treePage.BinaryTrees();
		LoggerReader.info("User is on Traversals Illustration page");
	    }
	    
	    
	    @Test(priority = 27)
	    public void BinaryTreesTryhere() throws InterruptedException {
	    callValidLogInData();
	    treePage.BinaryTrees();
	    treePage.Tryhere();
	    LoggerReader.info("User clicks on Tryhere button in the Binary Trees page");
	    }
		
	    @Test(priority = 28)
	    public void checkErrorMessageWhenExecutingWithoutenteringCodeInBinaryTreesPage() throws IOException,InterruptedException {
	    callValidLogInData();
	    treePage.BinaryTrees();
	    treePage.Tryhere(); 
	    treePage.RunButton(); 
	    Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
	    LoggerReader.error("Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    }
	    
	    @Test(priority = 29, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	    public void BinaryTreesTryeditor(String sheetName, int rowNumber) throws IOException, InterruptedException {
	    callValidLogInData();
	    treePage.BinaryTrees();
	    treePage.Tryhere();
		treePage.tryEditorWindow(sheetName,rowNumber);
		Assert.assertEquals(treePage.RunbuttonEnabled(), true);
		LoggerReader.info("User enters valid and invalid python code in the Tryeditor section of Binary Trees page");
		}

		
	    @Test(priority = 30)
	    public void navigatebacktoBinaryTrees() throws InterruptedException{
	    callValidLogInData();
	    treePage.BinaryTrees();
	    treePage.Tryhere();
		treePage.navigateback();
		LoggerReader.info("User navigates back to Binary Trees page");
	    }
		
	    @Test(priority = 31)
	    public void TypesOfBinaryTrees() throws InterruptedException {
	    callValidLogInData();
	    Assert.assertEquals(treePage.TypesOfBinaryTrees_linkenabled(), true);
	    treePage.TypesOfBinaryTrees();
	    LoggerReader.info("User is on Binary Trees page");
	    }
	    
	    
	    @Test(priority = 32)
	    public void TypesOfBinaryTreesTryhere() throws InterruptedException {
	    callValidLogInData();
	    treePage.TypesOfBinaryTrees();
	    treePage.Tryhere();
	    LoggerReader.info("User clicks on Tryhere button in the Types Of Binary Trees page");
	    }
		
	    @Test(priority = 33)
	    public void checkErrorMessageWhenExecutingWithoutenteringCodeInTypesOfBinaryTreesPage() throws IOException,InterruptedException {
	    callValidLogInData();
	    treePage.TypesOfBinaryTrees();
	    treePage.Tryhere(); 
	    treePage.RunButton(); 
	    Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
	    LoggerReader.error("Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    }
	    
	    @Test(priority = 34, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	    public void TypesOfBinaryTreesTryeditor(String sheetName, int rowNumber) throws IOException, InterruptedException {
	    callValidLogInData();
	    treePage.TypesOfBinaryTrees();
	    treePage.Tryhere();
		treePage.tryEditorWindow(sheetName,rowNumber);
		Assert.assertEquals(treePage.RunbuttonEnabled(), true);
		LoggerReader.info("User enters valid and invalid python code in the Tryeditor section of Types Of Binary Trees page");
	    }
	    
	    @Test(priority = 35)
	    public void navigatebacktoTypesOfBinaryTrees() throws InterruptedException{
	    callValidLogInData();
	    treePage.TypesOfBinaryTrees();
	    treePage.Tryhere();
		treePage.navigateback();
		LoggerReader.info("User navigates back to Types Of Binary Trees page");
	    }
	    
	    @Test(priority = 36)
	    public void ImplementationInPython() throws InterruptedException {
	    callValidLogInData();
	    Assert.assertEquals(treePage.ImplementationInPython_linkenabled(), true);
	    treePage.ImplementationInPython();
	    LoggerReader.info("User is on Types Of Binary Trees page");
	    }
	    
	    
	    @Test(priority = 37)
	    public void ImplementationInPythonTryhere() throws InterruptedException {
	    callValidLogInData();
	    treePage.ImplementationInPython();
	    treePage.Tryhere();
	    LoggerReader.info("User clicks on Tryhere button in the Types Of Binary Trees page"); 
	    }
		
	    @Test(priority = 38)
	    public void checkErrorMessageWhenExecutingWithoutenteringCodeInImplementationInPythonPage() throws IOException,InterruptedException {
	    callValidLogInData();
	    treePage.ImplementationInPython();
	    treePage.Tryhere(); 
	    treePage.RunButton(); 
	    Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
	    LoggerReader.error("Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    }
	    
	    @Test(priority = 39, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	    public void ImplementationInPythonTryeditor(String sheetName, int rowNumber) throws IOException, InterruptedException {
	    callValidLogInData();
	    treePage.ImplementationInPython();
	    treePage.Tryhere();
		treePage.tryEditorWindow(sheetName,rowNumber);
		Assert.assertEquals(treePage.RunbuttonEnabled(), true);
		LoggerReader.info("User enters valid and invalid python code in the Tryeditor section of Types Of Binary Trees page");
	    }
	    
	    @Test(priority = 40)
	    public void navigatebacktoImplementationInPython() throws InterruptedException{
	    callValidLogInData();
	    treePage.ImplementationInPython();
	    treePage.Tryhere();
		treePage.navigateback();
		LoggerReader.info("User navigates back to Types Of Binary Trees page");
	    }
	    
	    @Test(priority = 41)
	    public void BinaryTreeTraversals() throws InterruptedException {
	    callValidLogInData();
	    Assert.assertEquals(treePage.BinaryTreeTraversals_linkenabled(), true);
	    treePage.BinaryTreeTraversals();
	    LoggerReader.info("User is on Types Of Binary Trees page");
	    }
	    
	    
	    @Test(priority = 42)
	    public void BinaryTreeTraversalsTryhere() throws InterruptedException {
	    callValidLogInData();
	    treePage.BinaryTreeTraversals();
	    treePage.Tryhere();
	    LoggerReader.info("User clicks on Tryhere button in the Binary Tree Traversals page"); 
	    }
		
	    @Test(priority = 43)
	    public void checkErrorMessageWhenExecutingWithoutenteringCodeInBinaryTreeTraversalsPage() throws IOException,InterruptedException {
	    callValidLogInData();
	    treePage.BinaryTreeTraversals();
	    treePage.Tryhere(); 
	    treePage.RunButton(); 
	    Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
	    LoggerReader.error("Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    }
	    
	    @Test(priority = 44, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	    public void BinaryTreeTraversalsTryeditor(String sheetName, int rowNumber) throws IOException, InterruptedException {
	    callValidLogInData();
	    treePage.BinaryTreeTraversals();
	    treePage.Tryhere();
		treePage.tryEditorWindow(sheetName,rowNumber);
		Assert.assertEquals(treePage.RunbuttonEnabled(), true);
		LoggerReader.info("User enters valid and invalid python code in the Tryeditor section of Binary Tree Traversals page");
	    }
	    
	    @Test(priority = 45)
	    public void navigatebacktoBinaryTreeTraversals() throws InterruptedException{
	    callValidLogInData();
	    treePage.BinaryTreeTraversals();
	    treePage.Tryhere();
		treePage.navigateback(); 
		LoggerReader.info("User navigates back to Binary Tree Traversals page");
	    }
	    
	    @Test(priority = 46)
	    public void ImplementationOfBinaryTrees() throws InterruptedException {
	    callValidLogInData();
	    Assert.assertEquals(treePage.ImplementationOfBinaryTrees_linkenabled(), true);
	    treePage.ImplementationOfBinaryTrees();
	    LoggerReader.info("User is on Binary Tree Traversals page");
	    }
	    
	    
	    @Test(priority = 47)
	    public void ImplementationOfBinaryTreesTryhere() throws InterruptedException {
	    callValidLogInData();
	    treePage.ImplementationOfBinaryTrees();
	    treePage.Tryhere();
	    LoggerReader.info("User clicks on Tryhere button in the Implementation Of Binary Trees page"); 
	    }
		
	    @Test(priority = 48)
	    public void checkErrorMessageWhenExecutingWithoutenteringCodeInImplementationOfBinaryTreesPage() throws IOException,InterruptedException {
	    callValidLogInData();
	    treePage.ImplementationOfBinaryTrees();
	    treePage.Tryhere(); 
	    treePage.RunButton(); 
	    Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
	    LoggerReader.error("Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    }
	    
	    @Test(priority = 49, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	    public void ImplementationOfBinaryTreesTryeditor(String sheetName, int rowNumber) throws IOException, InterruptedException {
	    callValidLogInData();
	    treePage.ImplementationOfBinaryTrees();
	    treePage.Tryhere();
		treePage.tryEditorWindow(sheetName,rowNumber);
		Assert.assertEquals(treePage.RunbuttonEnabled(), true);
		LoggerReader.info("User enters valid and invalid python code in the Tryeditor section of Implementation Of Binary Trees page");
	    }
	    
	    @Test(priority = 50)
	    public void navigatebacktoImplementationOfBinaryTrees() throws InterruptedException{
	    callValidLogInData();
	    treePage.ImplementationOfBinaryTrees();
	    treePage.Tryhere();
		treePage.navigateback();
		LoggerReader.info("User navigates back to Implementation Of Binary Trees page");
	    }

	    @Test(priority = 51)
	    public void ApplicationsOfBinaryTrees() throws InterruptedException {
	    callValidLogInData();
	    Assert.assertEquals(treePage.ApplicationsOfBinaryTrees_linkenabled(), true);
	    treePage.ApplicationsOfBinaryTrees();
	    LoggerReader.info("User is on Implementation Of Binary Trees page");
	    }
	    
	    @Test(priority = 52)
	    public void ApplicationsOfBinaryTreesTryhere() throws InterruptedException {
	    callValidLogInData();
	    treePage.ApplicationsOfBinaryTrees();
	    treePage.Tryhere();
	    LoggerReader.info("User clicks on Tryhere button in the Applications Of Binary Trees page"); 
	    }
		
	    @Test(priority = 53)
	    public void checkErrorMessageWhenExecutingWithoutenteringCodeInApplicationsOfBinaryTreesPage() throws IOException,InterruptedException {
	    callValidLogInData();
	    treePage.ApplicationsOfBinaryTrees();
	    treePage.Tryhere(); 
	    treePage.RunButton(); 
	    Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
	    LoggerReader.error("Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    }
	    
	    @Test(priority = 54, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	    public void ApplicationsOfBinaryTreesTryeditor(String sheetName, int rowNumber) throws IOException, InterruptedException {
	    callValidLogInData();
	    treePage.ApplicationsOfBinaryTrees();
	    treePage.Tryhere();
		treePage.tryEditorWindow(sheetName,rowNumber);
		Assert.assertEquals(treePage.RunbuttonEnabled(), true);
		LoggerReader.info("User enters valid and invalid python code in the Tryeditor section of Applications Of Binary Trees page");
	    }
	    
	    @Test(priority = 55)
	    public void navigatebacktoApplicationsOfBinaryTrees() throws InterruptedException{
	    callValidLogInData();
	    treePage.ApplicationsOfBinaryTrees();
	    treePage.Tryhere();
		treePage.navigateback();
		LoggerReader.info("User navigates back to Applications Of Binary Trees page");
	    }
	    
	    @Test(priority = 56)
	    public void BinarySearchTrees() throws InterruptedException {
	    callValidLogInData();
	    Assert.assertEquals(treePage.BinarySearchTrees_linkenabled(), true);
	    treePage.BinarySearchTrees();
	    LoggerReader.info("User is on Applications Of Binary Trees page");
	    }
	    
	    @Test(priority = 57)
	    public void BinarySearchTreesTryhere() throws InterruptedException {
	    callValidLogInData();
	    treePage.BinarySearchTrees();
	    treePage.Tryhere();
	    LoggerReader.info("User clicks on Tryhere button in the Binary Search Trees page");
	    }
		
	    @Test(priority = 58)
	    public void checkErrorMessageWhenExecutingWithoutenteringCodeInBinarySearchTreesPage() throws IOException,InterruptedException {
	    callValidLogInData();
	    treePage.BinarySearchTrees();
	    treePage.Tryhere(); 
	    treePage.RunButton(); 
	    Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
	    LoggerReader.error("Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    }
	    
	    @Test(priority = 59, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	    public void BinarySearchTreesTryeditor(String sheetName, int rowNumber) throws IOException, InterruptedException {
	    callValidLogInData();
	    treePage.BinarySearchTrees();
	    treePage.Tryhere();
		treePage.tryEditorWindow(sheetName,rowNumber);
		Assert.assertEquals(treePage.RunbuttonEnabled(), true);
		LoggerReader.info("User enters valid and invalid python code in the Tryeditor section of Binary Search Trees page");
	    }
   
	    @Test(priority = 60)
	    public void navigatebacktoBinarySearchTrees() throws InterruptedException{
	    callValidLogInData();
	    treePage.BinarySearchTrees();
	    treePage.Tryhere();
		treePage.navigateback(); 
		LoggerReader.info("User navigates back to Binary Search Trees page");
	    }

	    @Test(priority = 61)
	    public void ImplementationOfBST() throws InterruptedException {
	    callValidLogInData();
	    Assert.assertEquals(treePage.ImplementationOfBST_linkenabled(), true);
	    treePage.ImplementationOfBST();
	    LoggerReader.info("User is on Binary Search Trees page");
	    }
	    
	    @Test(priority = 62)
	    public void ImplementationOfBSTTryhere() throws InterruptedException {
	    callValidLogInData();
	    treePage.ImplementationOfBST();
	    treePage.Tryhere();
	    LoggerReader.info("User clicks on Tryhere button in the Implementation Of BST page"); 
	    }
		
	    @Test(priority = 63)
	    public void checkErrorMessageWhenExecutingWithoutenteringCodeInImplementationOfBSTPage() throws IOException,InterruptedException {
	    callValidLogInData();
	    treePage.ImplementationOfBST();
	    treePage.Tryhere(); 
	    treePage.RunButton(); 
	    Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
	    LoggerReader.error("Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    }
	    
	    @Test(priority = 64, dataProvider = "pythoncode_tryeditor", dataProviderClass = BaseClass.class)
	    public void ImplementationOfBSTTryeditor(String sheetName, int rowNumber) throws IOException, InterruptedException {
	    callValidLogInData();
	    treePage.ImplementationOfBST();
	    treePage.Tryhere();
		treePage.tryEditorWindow(sheetName,rowNumber);
		Assert.assertEquals(treePage.RunbuttonEnabled(), true);
		LoggerReader.info("User enters valid and invalid python code in the Tryeditor section of Implementation Of BST page");
	    }
	    
	    @Test(priority = 65)
	    public void navigatebacktoImplementationOfBST() throws InterruptedException{
	    callValidLogInData();
	    treePage.ImplementationOfBST();
	    treePage.Tryhere();
		treePage.navigateback(); 
		LoggerReader.info("User navigates back to Implementation Of BST page");
	    }
	    
	    @Test(priority = 66)
	    public void PracticeQuestions() throws InterruptedException {
	    callValidLogInData();
		treePage.ImplementationOfBST();
		treePage.PracticeQuestions(); 
		LoggerReader.info("User is navigated to Practice Questions Page");
		}
	    
	    @Test(priority = 67)
	    public void PracticeQuestionspageisblank() throws InterruptedException {
	    callValidLogInData();
	    treePage.ImplementationOfBST();
		treePage.PracticeQuestions(); 
        Assert.assertFalse(treePage.content().trim().isEmpty(), "Page is blank! Body does not contain text.");
	    Assert.assertFalse(treePage.childelements().isEmpty(), "Page is not blank! Body contains child elements.");
		LoggerReader.error("Test failed: Expected to navigate to Practice Questions for Graph module, instead found the page blank!");
	    }

}

