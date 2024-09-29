package uiappfeatures;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	//"C:\\Users\\admin\\eclipse-workspace\\MyBDD\\src\\test\\resources\\uiappfeature\\Homepage.feature"
	features = {"src\\test\\resources\\uiappfeature"},
	glue = {"uiappfeatures"},
	plugin = {"pretty", "html:target/amazontestreport/reports.html"}, // save report in target folder
	publish = true
)	

public class AmazonTestRunner extends AbstractTestNGCucumberTests{
	
}
