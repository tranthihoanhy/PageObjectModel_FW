package alert_windows_iframe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class IFrame_ExplicitWait extends CommonBase {
	@BeforeTest
	public void openPage() {
		driver = initChromeDriver("https://codestar.vn/");
	}

	@Test
	public void handleIFrame(){
		System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
		scrollToElement(By.xpath("//h2[text()='Đội ngũ giảng viên']"));
		int index = findIFrame();
		driver.switchTo().frame(index);
		type(By.id("account_phone"),"0979535822");
		click(By.xpath("//button[text()='Gửi ngay']"));
	}
}
