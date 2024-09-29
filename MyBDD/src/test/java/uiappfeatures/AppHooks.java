package uiappfeatures;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import drivermanager.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.PropReader;

public class AppHooks {
	
	PropReader prop;
	WebDriver driver;
	
	@Before
	public void launchBrowser() throws IOException
	{
		DriverFactory df = new DriverFactory();
		prop = new PropReader();
		String browserName = prop.readPropData("browser"); // browser name coming from proprties files
		
		//use system class
		String cmdBrowserName= System.getProperty("cliBrowser"); // browser name coming from command prompt
		System.out.println("BrowserName from cmd Prompt recieed: "+cmdBrowserName);
		if(cmdBrowserName != null)
		{
			browserName = cmdBrowserName;
		}
		driver = df.initBrowser(browserName);
		driver.manage().window().maximize();
	}
	
	@After(order = 2)
	public void FailedScreenshot(Scenario scenario)
	{
		boolean scenarioStatus = scenario.isFailed();
		
		if(scenarioStatus)
		{
			String nameOfScenario = scenario.getName(); // Name of failed Scenario - Same name we are using for screenshot File name
			String modifiedScenarioName = nameOfScenario.replaceAll(" ", "_"); 	// Replace the blank places to underscore in screenshot File Name
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] source = ts.getScreenshotAs(OutputType.BYTES);    // We will capture the screenshot in form of byte
		
			// In the Cucumber we capture screenshot using methods - 1) BYTE 2) String. (File type not used in cucumber)
			
			scenario.attach(source, "image/png",  modifiedScenarioName);
		}
	}
	
	@After (order = 1 )
	public void tearDown()
	{
		driver.quit();
	}
}
