package pages;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
	
	@FindBy(xpath ="//a[@id='nav-cart']")
	private WebElement cartIcon;
	
	@FindBy(xpath ="//a[text()='Amazon miniTV']")	//*[@class='nav-a  '][2]
	private WebElement minitvIcon;
	
	@FindBy(xpath ="//span[contains(text(),'Web Series')]")
	private WebElement MiniTVHomepage;
		
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	public Homepage(WebDriver driver)
	{
		this.driver = driver; // Local Variable transfer to global
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		PageFactory.initElements(driver, this);	
	}	
	public String fetchTitle() 
	{
		String title = driver.getTitle();
		return title; 
	}
	
	public boolean verifiyCartIcon()
	{
		boolean isDisplaying = cartIcon.isDisplayed();
		return isDisplaying;
	}
	
	public void enteringMiniTV()
	{
		wait.until(ExpectedConditions.visibilityOf(minitvIcon));
		minitvIcon.click();
	}
	
	public boolean miniTVpage()
	{
		wait.until(ExpectedConditions.visibilityOf(MiniTVHomepage));
		boolean isMiniTVdisplayed = MiniTVHomepage.isDisplayed();
		return isMiniTVdisplayed;
	}
}
