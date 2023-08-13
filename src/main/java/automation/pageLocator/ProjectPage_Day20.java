package automation.pageLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import automation.common.CommonBase;

public class ProjectPage_Day20 extends CommonBase{
	private By projectLink = By.xpath("//span[text()='Projects']");
	private By btnAddProject = By.xpath("//a[@class='btn btn-default' and @title='Add project']");
	// Add new project
	private By txtTitle = By.id("title");
	private By dropdownProjectType = By.id("select2-chosen-9");
	private By optionInternalProject=By.xpath("//ul[@id='select2-results-9']/li[2]");
	private By startDate = By.id("start_date");
	private By startDay=By.xpath("//td[@class='day' and text()='1']");
	private By enddate = By.id("deadline");
	private By deadlineDay=By.xpath("//td[@class='day' and text()='31']");
	// Tìm đến xPath của input có attribute là autocomplete
	private By projectLabelTextBox = By.xpath("(//div[@class=' col-md-9']//input[contains(@id,'s2id_autogen')])[4]");
	
	private By btnSaveAndContinue = By.id("save-and-continue-button");
	private By dropdownMember = By.id("s2id_user_id");
	private By memberOption = By.xpath("//ul[@class='select2-results' and @role ='listbox']//li[2]");
	private By taskTitle = By.id("title");
	private By closeButton = By.xpath("(//button[@type='button' and normalize-space()='Close'])[1]");
	// View project
	private By projectName = By.xpath("(//tbody//td[@class=' all']//a)[1]");
	public ProjectPage_Day20(WebDriver driver) {
		this.driver = driver;
	}

	public void AddNewProjectSuccessfully(WebDriver driver, String title) {
		click(projectLink);
		click(btnAddProject);
		type(txtTitle,title);
		click(dropdownProjectType);
		click(optionInternalProject);
		click(startDate);
		click(startDay);
		click(enddate);
		click(deadlineDay);
		// Chọn giá trị là Urgent trong autocomplete input field
		type(projectLabelTextBox,"Urgent");
		driver.findElement(projectLabelTextBox).sendKeys(Keys.TAB);
		
		click(btnSaveAndContinue);	
		click(dropdownMember);
		click(memberOption);
		click(btnSaveAndContinue);
		type(taskTitle, "Add project successfully");
		click(closeButton);
	}
}
