package automation.testsuite;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import automation.pageLocator.DashboardPage;
import automation.common.CommonBase;
import automation.pageLocator.LoginPageFactory_Day14;
import automation.pageLocator.ProjectPage_Day20;

public class ProjectTest_Day20 extends CommonBase{
	
	@BeforeTest
	public void openSystemUnderTest() {
		driver = initChromeDriver("https://rise.fairsketch.com/signin");
	}
	
	@Test
	public void AddProjectSuccessFully () {
		LoginPageFactory_Day14 loginPage = new LoginPageFactory_Day14(driver);
		loginPage.LoginFunction("admin@demo.com","riseDemo");
		DashboardPage dashBoard = new DashboardPage(driver);
		assertTrue(driver.findElement(dashBoard.textDashboard).isDisplayed());
		ProjectPage_Day20 projectPage = new ProjectPage_Day20(driver);
		projectPage.AddNewProjectSuccessfully(driver, "Final Project Test");
	}

	@AfterTest
	public void closeBrowserTest() {
		//quitDriver(driver);
	}
}
