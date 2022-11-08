package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BrowserManager;
import utility.BrowserManager.EPConditions;

public class DashboardPage {

	WebDriver driver;
	
	By btnCancelButton = By.xpath("//tr[contains(@class,'appointment')]//td[@data-name='s_menu']//div[contains(@id,'rs-report-gear')]//ul//li[@data-title='Cancel Appointment']");
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSearchIcon() {
		return BrowserManager.waitFor(By.xpath("//span[@class='css-icon js-icon css-icon-sg-second-search']"), driver, EPConditions.CLICKABLE);
	}
	
	public WebElement getSearchField() {
		BrowserManager.waitFor(By.xpath("//div[@style='width: 260px; display: block;']"), driver, EPConditions.CLICKABLE);
		return BrowserManager.waitFor(By.xpath("(//input[@autocomplete='off'])[1]"), driver, EPConditions.CLICKABLE);
	}
	
	public void waitForMsgToDisappear() {
		BrowserManager.waitFor(By.xpath("//div[@id='mp-note-div' and @style='opacity: 0;']"), driver, EPConditions.PRESENCE);
	}
	
	public List<WebElement> getAllClientNameSearchSuggestions(){
		return driver.findElements(By.xpath("//div[@id='ac-main-div-rs-login-search']//table//tbody//tr//td"));
	}
	
	public void clickCancelAppointmentButton(){
		BrowserManager.waitFor(btnCancelButton, driver, EPConditions.CLICKABLE).click();
	}
}
