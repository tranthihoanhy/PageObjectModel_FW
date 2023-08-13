package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.pageLocator.DashboardPage;
import automation.pageLocator.LoginPage;
import automation.common.CommonBase;
import automation.constant.CT_Account;

public class LoginTest extends CommonBase{
  WebDriver driver;
  @BeforeTest
  public void openChromeDriver()
  {
	  driver = initChromeDriver(CT_Account.webURL);
  }
  
  // Login successfully khi truyền đúng email và password
  @Test
  public void loginSuccessfully()
  {
	  LoginPage login = new LoginPage(driver);
	  login.Login("admin@demo.com", "riseDemo");
	  // Kiểm tra text của trang Dashboard được hiển thị sau khi đăng nhập thành công
	  DashboardPage dashBoard = new DashboardPage(driver);
	WebElement titleDashboard = driver.findElement(dashBoard.textDashboard);
	assertTrue(titleDashboard.isDisplayed());
  }
  
//Login fail, error message hiển thị khi truyền sai pass
  @Test
  public void loginFail_IncorrectPass()
  {
	  LoginPage login = new LoginPage(driver);
	  login.Login("admin@demo.com", "riseDemo_Incorrect");
	// Kiểm tra text Authentication Fail error hiện lên khi login fail
	  WebElement txtError = driver.findElement(LoginPage.errorAuthentication);
	  assertTrue(txtError.isDisplayed());
  }
  
  @AfterTest
  public void closeChromeBrowser()
  {
	  quitDriver(driver);
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
}
