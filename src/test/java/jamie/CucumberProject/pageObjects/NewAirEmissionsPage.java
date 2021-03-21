package jamie.CucumberProject.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import jamie.CucumberProject.helpers.BasePage;

public class NewAirEmissionsPage extends BasePage {
	
	
	private static final String PAGE_BODY_XPATH = "//body[contains(@class, 'AirEmissions') and contains(@class, 'Create')]";
	
	private static final String DESCRIPTION_FIELD_XPATH = PAGE_BODY_XPATH + "//textarea[@id='SheAirEmissions_Description']";
	private static final String SAMPLE_DATE_CALENDAR_XPATH = PAGE_BODY_XPATH + "//button[contains(@class, 'ui-datepicker-trigger')]";
	private static final String TODAYS_DATE_CALENDAR_XPATH = "//a[contains(@class, 'ui-state-highlight')]";
	
	private static final String SAVE_AND_CLOSE_BUTTON_XPATH = PAGE_BODY_XPATH + "//button[@value='Close']";
	
	
	@FindBy(xpath = DESCRIPTION_FIELD_XPATH)
	WebElement descriptionField;
	
	@FindBy(xpath = SAMPLE_DATE_CALENDAR_XPATH)
	WebElement calendarButton;
	
	@FindBy(xpath = TODAYS_DATE_CALENDAR_XPATH)
	WebElement todaysDate;
	
	@FindBy(xpath = SAVE_AND_CLOSE_BUTTON_XPATH)
	WebElement saveAndClose;
	

	public NewAirEmissionsPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterDescription(String text) {
		waitForElementToAppear(By.xpath(DESCRIPTION_FIELD_XPATH));
		descriptionField.clear();
		descriptionField.sendKeys(text);
	}
	
	public void selectSampleDateAsToday() {
		waitForElementToAppear(By.xpath(SAMPLE_DATE_CALENDAR_XPATH));
		scrollToElement(calendarButton);
		calendarButton.click();
		waitForElementToAppear(By.xpath(TODAYS_DATE_CALENDAR_XPATH));
		todaysDate.click();
	}
	
	public void saveAndClose() {
		waitForElementToAppear(By.xpath(SAMPLE_DATE_CALENDAR_XPATH));
		saveAndClose.click();
	}

}
