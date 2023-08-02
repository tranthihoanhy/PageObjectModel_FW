package alert_windows_iframe;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class AlertSenKeys extends CommonBase {
	@BeforeTest
	public void openPage() {
		driver = initChromeDriver("http://demo.automationtesting.in/Alerts.html");
	}
	@Test
	public void TestAlert02() {
		driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']")).click();
		pause(2000);
		driver.findElement(By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']"))
				.click();
		// Nhấn sendKeys vào ô text
		driver.switchTo().alert().sendKeys("CodeStar Automation Test with HoanTran");
		pause(2000);
		driver.switchTo().alert().accept();
		pause(2000);
	}
	@AfterTest
	public void closePage() {
		quitDriver(driver);
	}
}
