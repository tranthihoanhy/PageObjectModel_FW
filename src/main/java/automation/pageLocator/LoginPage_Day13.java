package automation.pageLocator;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage_Day13 {
	private WebDriver driver;
	private By textboxEmail = By.id("email");
	private By textboxPassword = By.id("password");
	private By buttonLogin = By.xpath("//button[@type='submit']");
	
	public static By errorAuthentication = By.xpath("//div[@class='alert alert-danger']");
	public LoginPage_Day13(WebDriver driver) {
		this.driver = driver;
	}
	
	public void LoginFunction(String email, String password) {
		WebElement txtEmail = driver.findElement(textboxEmail);
		if (txtEmail.isDisplayed()) {
			txtEmail.clear();
			txtEmail.sendKeys(email);
		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement txtPass = driver.findElement(textboxPassword);
		if (txtPass.isDisplayed()) {
			txtPass.clear();
			txtPass.sendKeys(password);
		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement btnSubmit = driver.findElement(buttonLogin);
		if (btnSubmit.isDisplayed()) {
			btnSubmit.click();
		}
	}
}
