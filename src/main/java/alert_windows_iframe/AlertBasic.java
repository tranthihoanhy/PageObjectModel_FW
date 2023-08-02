package alert_windows_iframe;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class AlertBasic extends CommonBase {
	@BeforeTest
	public void openPage() {
		driver = initChromeDriver("http://demo.guru99.com/test/delete_customer.php");
	}
	@Test
	public void TestAlert01() {
		driver.findElement(By.name("cusid")).sendKeys("123456");
		driver.findElement(By.name("submit")).submit();
		// Khai báo chuyển hướng đến Alert với đối tượng
		Alert alert = driver.switchTo().alert();
		// Get message trên alert
		String alertMessage = driver.switchTo().alert().getText();
		// Hiện ra trên Console nội dung của alert message
		System.out.println(alertMessage);
		pause(2000);
		// accept() = nhấn Ok button
		// driver.switchTo().alert().accept(); //Cách 1
		alert.accept(); // Cách 2
		// Nhấn Cancel button
		// alert.dismiss();
		pause(2000);
	}

	@AfterTest
	public void closePage() {
		quitDriver(driver);
	}
}
