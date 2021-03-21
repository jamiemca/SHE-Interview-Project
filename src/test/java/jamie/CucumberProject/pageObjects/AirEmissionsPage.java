package jamie.CucumberProject.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import jamie.CucumberProject.helpers.BasePage;

public class AirEmissionsPage extends BasePage {
	
	
	private static final String PAGE_BODY_XPATH = "//section[@role='main']";
	
	private static final String NEW_RECORD_BUTTON_XPATH = PAGE_BODY_XPATH + "//a[contains(@class, 'create_record')]";
	
	private static final String ALL_RECORDS_XPATH = PAGE_BODY_XPATH + "//div[contains(@class, 'item-box')]";
	private static final String RECORD_WITH_DESCRIPTION_XPATH = ALL_RECORDS_XPATH + "//span[contains(text(), 'Description')]/../a[text()=\"%s\"]";
	private static String MANAGE_RECORD_XPATH = RECORD_WITH_DESCRIPTION_XPATH + "/ancestor::div[contains(@class, 'list_layout')]//button";
	private static String DELETE_RECORD_XPATH = MANAGE_RECORD_XPATH + "/ancestor::div[contains(@class, 'list_layout')]//a[contains(@id, 'cogDelete')]";
	
	private static final String DELETE_POPUP_XPATH = "//div[@aria-describedby='deleteDialog']";
	private static final String CONFIRM_DELETE_BUTTON_XPATH = DELETE_POPUP_XPATH + "//button[contains(text(), 'Confirm')]";
	
	private static final String NEXT_PAGE_XPATH = PAGE_BODY_XPATH + "//div[@class='pageCountSummary']/following-sibling::div//li[@class='page-next']";
	private static final String PREVIOUS_PAGE_XPATH = PAGE_BODY_XPATH + "//div[@class='pageCountSummary']/following-sibling::div//li[@class='page-prev']";
	private static final String NUMBER_OF_PAGES_XPATH = PAGE_BODY_XPATH + "//div[@class='pageCountSummary']/following-sibling::div//input[@class='pageGoToCustomNumber']";
	
	
	@FindBy(xpath = NEW_RECORD_BUTTON_XPATH)
	WebElement newRecordButton;
	
	@FindBy(xpath = CONFIRM_DELETE_BUTTON_XPATH)
	WebElement confirmDelete;
	
	@FindBy(xpath = NEXT_PAGE_XPATH)
	WebElement nextPage;
	
	@FindBy(xpath = PREVIOUS_PAGE_XPATH)
	WebElement previousPage;
	
	@FindBy(xpath = NUMBER_OF_PAGES_XPATH)
	WebElement numberOfPages;
	

	public AirEmissionsPage(WebDriver driver) {
		super(driver);
	}
	
	public NewAirEmissionsPage clickNewRecordButton() {
		waitForElementToAppear(By.xpath(NEW_RECORD_BUTTON_XPATH));
		newRecordButton.click();
		return PageFactory.initElements(driver, NewAirEmissionsPage.class);
	}
	
	public boolean isRecordFound(String recordDescription) {
		MANAGE_RECORD_XPATH = "(" + MANAGE_RECORD_XPATH + ")[last()]";
		return isElementPresent(By.xpath(String.format(MANAGE_RECORD_XPATH, recordDescription)), driver);
	}
	
	public void deleteRecord(String recordDescription) {
		MANAGE_RECORD_XPATH = "(" + MANAGE_RECORD_XPATH + ")[last()]";
		WebElement manageRecord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(MANAGE_RECORD_XPATH, recordDescription))));
		scrollToElement(manageRecord);
		manageRecord.click();
		DELETE_RECORD_XPATH = "(" + DELETE_RECORD_XPATH + ")[last()]";
		WebElement deleteRecord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(DELETE_RECORD_XPATH, recordDescription))));
		deleteRecord.click();
	}
	
	public void confirmDelete() {
		waitForElementToAppear(By.xpath(CONFIRM_DELETE_BUTTON_XPATH));
		confirmDelete.click();
	}
	
	public void goToNextPage() {
		waitForElementToAppear(By.xpath(NEXT_PAGE_XPATH));
		nextPage.click();
	}
	
	public void goToPreviousPage() {
		waitForElementToAppear(By.xpath(PREVIOUS_PAGE_XPATH));
		previousPage.click();
	}
	
	public String getNumberOfPages() {
		return numberOfPages.getAttribute("value");
	}

}
