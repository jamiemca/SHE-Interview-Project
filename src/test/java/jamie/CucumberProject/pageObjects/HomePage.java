package jamie.CucumberProject.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import jamie.CucumberProject.helpers.BasePage;

public class HomePage extends BasePage {
	
	
	private static final String PAGE_BODY_XPATH = "//div[@id='main-content']";
	private static final String HEADER_CONTAINER_XPATH = PAGE_BODY_XPATH + "//div[contains(@class, 'headercontainer')]";
	
	private static final String USER_MENU_XPATH = HEADER_CONTAINER_XPATH + "//a[contains(@class, 'she-user-name')]";
	private static final String LOG_OUT_XPATH = HEADER_CONTAINER_XPATH + "//a[contains(text(), 'Log Out')]";
	private static final String HEADER_OPTION_XPATH = HEADER_CONTAINER_XPATH + "//a[contains(text(), '%s')]";
	
	
	@FindBy(xpath = USER_MENU_XPATH)
	WebElement userMenu;
	
	@FindBy(xpath = LOG_OUT_XPATH)
	WebElement logOut;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void selectHeaderMenuOption(String menuName) {
		WebElement headerMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(HEADER_OPTION_XPATH, menuName))));
		headerMenu.click();
	}
	
	public void selectHeaderMenuOptionWithHover(String firstMenuName, String secondMenuName) {
		waitForElementToAppear(By.xpath(String.format(HEADER_OPTION_XPATH, firstMenuName)));
		Actions builder = new Actions(driver);
		WebElement firstMenu = driver.findElement(By.xpath(String.format(HEADER_OPTION_XPATH, firstMenuName)));
		builder.moveToElement(firstMenu).perform();
		waitForElementToAppear(By.xpath(String.format(HEADER_OPTION_XPATH, secondMenuName)));
		WebElement secondMenu = driver.findElement(By.xpath(String.format(HEADER_OPTION_XPATH, secondMenuName)));
		secondMenu.click();
	}
	
	public void logOut() {
		waitForElementToAppear(By.xpath(USER_MENU_XPATH));
		userMenu.click();
		waitForElementToAppear(By.xpath(LOG_OUT_XPATH));
		logOut.click();
	}

}
