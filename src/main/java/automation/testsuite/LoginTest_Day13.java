package automation.testsuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.constant.CT_Account;
import automation.pageLocator.DashboardPage;
import automation.pageLocator.LoginPageFactory_Day14;
import automation.pageLocator.LoginPage_Day13;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;

public final class LoginTest_Day13 extends automation.common.CommonBase {
	@BeforeTest
	public void openSystemUnderTest() {
		driver = initChromeDriver(CT_Account.webURL);
	}

	@Test
	public void LoginSuccessfully_CorrectEmailPass() {
		LoginPage_Day13 loginPage = new LoginPage_Day13(driver);
		loginPage.LoginFunction("admin@demo.com","riseDemo");
		// Đợi 3s = implicitWait
		DashboardPage dashBoard = new DashboardPage(driver);
		assertTrue(driver.findElement(dashBoard.textDashboard).isDisplayed());
	}

	//Login fail, error message hiển thị khi truyền sai pass
	@Test
	  public void loginFail_IncorrectPass()
	  {
		  LoginPage_Day13 login = new LoginPage_Day13(driver);
		  login.LoginFunction("admin@demo.com", "riseDemo_Incorrect");
		// Kiểm tra text Authentication Fail error hiện lên khi login fail
		  WebElement txtError = driver.findElement(LoginPage_Day13.errorAuthentication);
		// Đợi 5s = implicitWait
		  assertTrue(txtError.isDisplayed());
	  }
	
	
	//Login fail, error message hiển thị khi truyền sai pass
		@Test
		  public void loginFail_IncorrectUser()
		  {
			  LoginPage_Day13 login = new LoginPage_Day13(driver);
			  login.LoginFunction("admin@demo.com", "riseDemo_Incorrect");
			// Kiểm tra text Authentication Fail error hiện lên khi login fail
			  WebElement txtError = driver.findElement(LoginPage_Day13.errorAuthentication);
			  assertTrue(txtError.isDisplayed());
		  }
	@AfterTest
	public void closeBrowserTest() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		quitDriver(driver);
	}
}