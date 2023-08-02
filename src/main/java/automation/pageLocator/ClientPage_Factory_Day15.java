package automation.pageLocator;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.common.CommonBase;

public class ClientPage_Factory_Day15 extends CommonBase {
	@FindBy(xpath = "//a[@class='btn btn-default' and @title='Add client']")
	private WebElement btnAddClient;
	@FindBy(xpath = "//input[@type='radio' and @value='organization']")
	private WebElement radioOrg;
	@FindBy(xpath = "//input[@type='radio' and @value='person']")
	private WebElement radioPerson;
	@FindBy(xpath = "//input[@name='company_name']")
	private WebElement textCompanyName;
	@FindBy(xpath = "//div[@id='s2id_created_by']")
	private WebElement checkboxOwner;
	// Chọn 1 item thứ 3 trong dropdownlist tự customize (dropdownlist không dùng
	// thẻ chuẩn là select)
	@FindBy(xpath = "//ul[@id='select2-results-3']//li[3]")
	private WebElement ownerItem;
	// Chọn Richard Gray, xPath ="//div[text()='Richard Gray']"
	@FindBy(xpath = "//div[text()='Richard Gray']")
	private WebElement ownerItem2;
	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement textAddress;
	@FindBy(xpath = "//button[@class='btn btn-primary' and @type='submit']")
	private WebElement btnSave;
	@FindBy(xpath = "//span[text()='Total clients']")
	private WebElement totalClientCard;
	@FindBy(xpath = "//input[@type='search']")
	private WebElement textboxSearch;

	@FindBy(xpath = "//td[@class=' all']//a[text()='admin@demo.com']")
	private WebElement searchResult;

	public ClientPage_Factory_Day15(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void AddClient(String companyName, String address) {
		//DashboardPage.clientsLink.click();
		btnAddClient.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		radioPerson.click();
		textCompanyName.sendKeys(companyName);
		checkboxOwner.click();
		ownerItem2.click();
		textAddress.sendKeys(address);
		btnSave.click();
		// Dùng JavascriptExecutor để click vào totalClientCard
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", totalClientCard);
		textboxSearch.sendKeys(companyName);
		// dùng js để dừng việc load page
		((JavascriptExecutor) driver).executeScript("window.stop();");
		assertTrue(searchResult.isDisplayed());

	}

}
