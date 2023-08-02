package alert_windows_iframe;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.HashSet;
import java.util.Set;
import automation.common.CommonBase;

public class WindowsPopup_ExplicitWait extends CommonBase {
	@BeforeTest
	public void openBrowser() {
		driver = initFirefoxDriverTest("https://demo.guru99.com/popup.php");
	}
	@Test
	public void TestPopupWindow() {
		click(By.xpath("//*[contains(@href,'popup.php')]"));
		// Lưu lại lớp window đầu tiên
		String mainWindow = driver.getWindowHandle();
		// Lấy ra tất cả các tab windows đang open bằng hàm getWindowHandles
		// Set là một Collection để lưu các phần tử giá trị KHÔNG trùng lặp.
		Set<String> windows = driver.getWindowHandles();
		// Cách duyệt từng phần tử không trùng lặp trong Collection (Set) ta dùng foreach
		for (String window : windows) {
			System.out.println(window);
			if (!mainWindow.equals(window)) {
				// So sánh nếu window nào khác window Chính (đầu tiên) thì chuyển qua để thao tác
				driver.switchTo().window(window);
				pause(2000);
				System.out.println("Đã chuyển đến lớp Window con");
				// Một số hàm hỗ trợ
				System.out.println("Title: " + driver.switchTo().window(window).getTitle());
				System.out.println("CurentTitle: " + driver.switchTo().window(window).getCurrentUrl());
				type(By.name("emailid"),"testdemo@gmail.com");
				click(By.name("btnLogin"));
				// Get text trang sau khi Submit
				String text = driver.findElement(By.xpath("//table//td//h2")).getText();
				System.out.println(text);
				Assert.assertEquals(text, "Access details to demo site.");
				// Closing the Child Window.
				driver.close();
			}
		}
		// Switching to Parent window (Main Window)
		driver.switchTo().window(mainWindow);
		System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());
	}

	@Test
	public void forEach() {
		Set<String> setA = new HashSet<String>();
		setA.add("Java");
		setA.add("Python");
		setA.add("C#");
		setA.add("PHP");
		for (String element : setA) {
			System.out.println(element);
		}
	}
}
