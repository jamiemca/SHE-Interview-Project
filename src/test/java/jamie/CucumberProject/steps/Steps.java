package jamie.CucumberProject.steps;

import static org.junit.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jamie.CucumberProject.pageObjects.AirEmissionsPage;
import jamie.CucumberProject.pageObjects.HomePage;
import jamie.CucumberProject.pageObjects.LoginPage;
import jamie.CucumberProject.pageObjects.NewAirEmissionsPage;

public class Steps {
	
	protected WebDriver driver;
	private String description;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\java\\jamie\\CucumberProject\\resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}
	
	@After
	public void teardown() {
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
		this.driver = null;
	}
	
	@Given("^the user has logged into the application$")
	public void userHasLoggedIntoApplication() throws Throwable {
		String url = "https://stirling.she-development.net/automation";
		String username = "JamieM";
		String password = "1234!JamieM";
		
		driver.get(url);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterDetailsIntoTextBox("username", username);
		loginPage.enterDetailsIntoTextBox("password", password);
		loginPage.clickLoginButton();
	}
	
	@And("^the air emissions module is selected$")
	public void airEmissionsModuleIsSelected() {
		HomePage homePage = new HomePage(driver);
		homePage.selectHeaderMenuOption("Modules");
		homePage.selectHeaderMenuOptionWithHover("Environment", "Air Emissions");
	}
	
	@When("^a new record is created$")
	public void newRecordIsCreated() {
		AirEmissionsPage airEmissionsPage = new AirEmissionsPage(driver);
		NewAirEmissionsPage newAirEmissionsPage = airEmissionsPage.clickNewRecordButton();
		
		description = RandomStringUtils.randomAlphabetic(10);
		newAirEmissionsPage.enterDescription(description);
		newAirEmissionsPage.selectSampleDateAsToday();
		newAirEmissionsPage.saveAndClose();
	}
	
	@And("^the record is deleted$")
	public void recordIsDeleted() {
		AirEmissionsPage airEmissionsPage = new AirEmissionsPage(driver);
		
		if(!airEmissionsPage.isRecordFound(description)) {
			do {
				airEmissionsPage.goToNextPage();
				
			} while(!airEmissionsPage.isRecordFound(description));
		}
		airEmissionsPage.deleteRecord(description);
		airEmissionsPage.confirmDelete();
	}
	
	@Then("^the deletion is verified and the user logs out$")
	public void deletionIsVerifiedAndUserLogsOut() {
		AirEmissionsPage airEmissionsPage = new AirEmissionsPage(driver);
		Integer numberOfPages = Integer.valueOf(airEmissionsPage.getNumberOfPages());
		assertFalse("Record has not been deleted", airEmissionsPage.isRecordFound(description));
		
		if(numberOfPages > 1) {
			numberOfPages = numberOfPages - 1;
			do {
				airEmissionsPage.goToPreviousPage();
				assertFalse("Record has not been deleted", airEmissionsPage.isRecordFound(description));
				numberOfPages = numberOfPages - 1;
				
			} while(numberOfPages > 1);
		}
		HomePage homePage = new HomePage(driver);
		homePage.logOut();
	}

}
