package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import automation.common.CommonBase;

public class DashboardPage extends CommonBase{
	 public static By textDashboard = By.xpath("//ul[@id='sidebar-menu']/descendant::span[text()='Dashboard']");
	 public DashboardPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

	}