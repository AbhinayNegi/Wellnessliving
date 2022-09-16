package PageObject;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddClientPage {
	
	WebDriver driver;

	public  AddClientPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	
		this.driver = driver;
	}
	
	public void closePopup() {
		
		/*
		 * WebElement bannerElement =
		 * driver.findElement(By.xpath("//input[@value='Not Now']"));
		 * if(bannerElement.isEnabled()) { new WebDriverWait(driver,
		 * Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(bannerElement)
		 * ); bannerElement.click(); }
		 */
		
		
		
		  WebElement updatepaymentElement =  driver.findElement(By.xpath("(//button[@title= 'Close'])[1]"));
		 new WebDriverWait(driver,  Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(  updatepaymentElement));
		  		  
		  updatepaymentElement.click(); 
		 
	}
	
	public void clickAddClient() {
		WebElement addClientElement = driver.findElement(By.xpath("(//span[normalize-space()='Add Client'])[1]"));
		new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(addClientElement));
		addClientElement.click();
	}
	
	public void enterFirstName(String firstname) {
		WebElement firsrtName = driver.findElement(By.xpath("//input[@name='s_firstname']"));
		new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(firsrtName));
		firsrtName.sendKeys(firstname);
	}

	
	public void enterlast(String lastname) {
		WebElement lastName = driver.findElement(By.xpath("//input[@name='s_lastname']"));
		new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(lastName));
		lastName.sendKeys(lastname);
	}

	public void enterEmail(String email) {
		WebElement emailID = driver.findElement(By.xpath("//input[@name='a_user[s_mail]']"));
		new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(emailID));
		emailID.sendKeys(email);
	}
	
	//button[normalize-space()='Create Account']
	
	public void createAccount() {
		//driver.switchTo().frame(0);
		//WebElement createbtn = driver.findElement(By.cssSelector("button[type='submit']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
		WebElement element =  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[type='submit']")));
		js.executeScript("arguments[0].click();", element);
	
		
		
		/*
		 * WebElement createbtn = driver.findElement(By.linkText("Cancel")); new
		 * WebDriverWait(driver,
		 * Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(createbtn));
		 * 
		 * Actions builder = new Actions(driver); Actions mouseOverHome = builder
		 * .moveToElement(createbtn).click(); mouseOverHome.perform();
		 * //createbtn.click();
		 */	}
}
