package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import automation.pageLocator.DashboardPage;
import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.pageLocator.ClientPage_Factory_Day15;
import automation.pageLocator.LoginPageFactory_Day14;
import automation.pageLocator.LoginPage_Day13;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class ClientTestFactory_Day15 extends CommonBase{
	@BeforeTest
	public void openSystemUnderTest() {
		driver = initChromeDriver(CT_Account.webURL);
	}
	
	@Test
	public void AddClientSuccessFully() {
		LoginPageFactory_Day14 loginPage = new LoginPageFactory_Day14(driver);
		loginPage.LoginFunction("admin@demo.com","riseDemo");
		DashboardPage dashBoard = new DashboardPage(driver);
		assertTrue(driver.findElement(dashBoard.textDashboard).isDisplayed());
		ClientPage_Factory_Day15 clientPage = new ClientPage_Factory_Day15(driver);
		clientPage.AddClient("admin@demo.com","Melbourne");
	}

	@AfterTest
	public void closeBrowserTest() {
		quitDriver(driver);
	}
}
