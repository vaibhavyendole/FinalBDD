package uiappfeatures;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
//		features = {"src\\test\\resources\\uiappfeature"},
		features = {"@target/failedrun.txt"},
		glue = {"uiappfeatures"},
		plugin = {
				"pretty",
				"html:target/amazontestreport/reports.html",
				"rerun:target/failedrun.txt"
				},
		publish = true
		)


public class AmazonFailedScenarioRunner extends AbstractTestNGCucumberTests {

}
