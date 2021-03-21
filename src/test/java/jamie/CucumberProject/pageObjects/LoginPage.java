package jamie.CucumberProject.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import jamie.CucumberProject.helpers.BasePage;

public class LoginPage extends BasePage {
	

	private static final String PAGE_BODY_XPATH = "//div[@class='she-login-container']";
	
	private static final String TEXT_BOX_XPATH = PAGE_BODY_XPATH + "//label[@for='%s']/../input";
	private static final String LOGIN_BUTTON_XPATH = PAGE_BODY_XPATH + "//button[@id='login']";
	
	
	@FindBy(xpath = LOGIN_BUTTON_XPATH)
	WebElement loginButton;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterDetailsIntoTextBox(String textBoxName, String details) {
		WebElement textBox = driver.findElement(By.xpath(String.format(TEXT_BOX_XPATH, textBoxName)));
		wait.until(ExpectedConditions.elementToBeClickable(textBox));
		textBox.clear();
		textBox.sendKeys(details);
	}
	
	public void clickLoginButton() {
		waitForElementToAppear(By.xpath(LOGIN_BUTTON_XPATH));
		loginButton.click();
	}

}
