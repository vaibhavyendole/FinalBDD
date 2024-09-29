package uiappfeatures;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import drivermanager.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Homepage;

public class HomePageSteps {
	Homepage homepage = new Homepage(DriverFactory.getDriver());
	
	@Given("I am at the landing page")
	public void i_am_at_the_landing_page() {
	WebDriver driver = DriverFactory.getDriver();
	driver.get("https://www.amazon.in/");
	}

	@Then("page title should contains {string}")
	public void page_title_should_contains(String string) {
	    
	   String ActualTitle = homepage.fetchTitle();
	   
	   boolean isPresent = ActualTitle.contains(string);
	   
	   Assert.assertEquals(isPresent, true);
	}

	@Then("cart icon should get display")
	public void cart_icon_should_get_display() {
	   boolean isDisplaying = homepage.verifiyCartIcon();
	   Assert.assertEquals(isDisplaying, true);
	}

	@When("I clicked on MiniTV icon")
	public void i_clicked_on_mini_tv_icon() {
	    homepage.enteringMiniTV();
	}

	@Then("MiniTV homepage should open")
	public void mini_tv_homepage_should_open() {
	  boolean isDisplayingMiniTV = homepage.miniTVpage();
	  Assert.assertEquals(isDisplayingMiniTV, true);
	}
}
