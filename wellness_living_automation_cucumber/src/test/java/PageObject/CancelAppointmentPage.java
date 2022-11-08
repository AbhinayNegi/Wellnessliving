package PageObject;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BrowserManager;
import utility.BrowserManager.EPConditions;

public class CancelAppointmentPage {

	WebDriver driver;

	By txtConfirmation = By.xpath("//div[@class='step current confirm']");

	By btnYes = By.xpath("//input[@value='Yes']");
	By btnNext = By.xpath("//input[@value='Next']");
	By checkBoxSendEmail = By.xpath("//input[@name='is_inform_mail']");
	By btnComplete = By.xpath("//input[@value='Complete']");

	public CancelAppointmentPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickYesButton() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		WebElement btnYes = BrowserManager.waitFor(this.btnYes, driver, EPConditions.CLICKABLE);
		jsExecutor.executeScript("arguments[0].scrollIntoView();", btnYes);

		btnYes.click();
	}

	public void clickReasonNextButton() {
		BrowserManager.waitFor(btnNext, driver, EPConditions.CLICKABLE).click();
	}

	public void verifyCheckBoxAndClickOnNextButton() {
		WebElement checkBox = BrowserManager.waitFor(checkBoxSendEmail, driver, EPConditions.PRESENCE);

		assertTrue(checkBox.isSelected());
		BrowserManager.click(btnComplete, driver);
	}

	public void checkMsg() {

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("mp-note-frame")));
		WebElement e = BrowserManager.waitFor(By.xpath("//div[@id='mp-note-text']//div"), driver, EPConditions.VISIBLE);
		
		System.out.println(e.getText());
	}
}
