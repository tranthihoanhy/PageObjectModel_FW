package automation.testsuite;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.pageLocator.DashboardPage;
import automation.pageLocator.LoginPageFactory_Day14;

public class LoginTestFactory_Day14 extends CommonBase{
	@BeforeTest
	public void openSystemUnderTest() {
		driver = initChromeDriver("https://techydevs.com/demos/themes/html/trizen-demo/trizen/index.html");
	}

	@Test
	public void TestLoginSuccessfully_CorrectEmailPassword() {
		LoginPageFactory_Day14 factory = new LoginPageFactory_Day14(driver);
		factory.LoginFunction("admin@demo.com","riseDemo");
		DashboardPage dashBoard = new DashboardPage(driver);
		assertTrue(driver.findElement(dashBoard.textDashboard).isDisplayed());
	}

	@AfterTest
	public void closeBrowserTest() {
		quitDriver(driver);
	}
}
