package jamie.CucumberProject.testRunner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
			features = "src/test/java/jamie/CucumberProject/featureFiles/Interview.feature",
			glue = {"jamie.CucumberProject.steps"},
			tags = ("@jm"),
			plugin = {"pretty",
					"html:target/reports/test-report",
					"json:target/results/cucumber.json",
					"junit:target/results/cucumber.xml"
			},
			monochrome = true,
			dryRun = false,
			strict = false
 )

public class TestRunner {

}