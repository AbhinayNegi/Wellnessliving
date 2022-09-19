package PageObject;
import java.awt.event.KeyEvent;
import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;
import java.awt.Robot;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Generic_method;

import java.awt.AWTException;
public class ClientProfile {

	WebDriver driver;
	 public List <WebElement> country_names;

	public  ClientProfile(WebDriver driver) {

		this.driver = driver;
	}


	public void go_to_clientprofile() throws AWTException, InterruptedException  {

        WebElement search_btn = driver.findElement(By.xpath("//span[@class='text-label js-text-label']"));
		new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(search_btn));
		search_btn.click();
		Thread.sleep(2000);

		WebElement txt_field=driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		txt_field.sendKeys("A1 Client");
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.delay(200);

		

	}

	public void go_to_bill_accountbalances() {
		WebElement arrow_icon = driver.findElement(By.xpath("(//div[@class='css-far css-fa-chevron-up icon-state']) [3]"));
		arrow_icon.click();
		new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(arrow_icon));
		driver.findElement(By.xpath("//a[@class='js-item-title css-item-title  js-item--billing']")).click();

	}


	public void addcreditcard() {
		WebElement cc_btn= driver.findElement(By.cssSelector("#add-card"));
		new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(cc_btn));
		cc_btn.click();
	}

	public void country_click() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)", "");
		
		WebElement country_dropdown = driver.findElement(By.xpath("//span[@class='js-geo-country']"));
		//new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(country_dropdown));
		new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(country_dropdown));
		country_dropdown.click();
		country_dropdown.click();
		 country_names=driver.findElements(By.xpath("//ul[@class='chosen-results']//li"));
	}
	public void check_country() {

		int sum=0;
//		WebElement country_dropdown = driver.findElement(By.xpath("(//select[@class='css-width-300p'])[1]"));
//		new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(country_dropdown));
//		//country_dropdown.click();
		//List <WebElement> country_names=driver.findElements(By.xpath("(//select[@class='css-width-300p'])[1]"));
		for(WebElement e : country_names) {
			String country=e.getText();
			//System.out.println(country);
			if(country.equalsIgnoreCase("Italy")) {
				
				System.out.println("Italy is present");
				//||country.equalsIgnoreCase( "Iceland")||country.equalsIgnoreCase("Denmark")||country.equalsIgnoreCase("Thailand")) {
			}
			
			if(country.equalsIgnoreCase("Iceland")) {
				
				System.out.println("Iceland is present");
				//||country.equalsIgnoreCase( "Iceland")||country.equalsIgnoreCase("Denmark")||country.equalsIgnoreCase("Thailand")) {
			}
			
			if(country.equalsIgnoreCase("Denmark")) {
				
				System.out.println("Denmark is present");
				//||country.equalsIgnoreCase( "Iceland")||country.equalsIgnoreCase("Denmark")||country.equalsIgnoreCase("Thailand")) {
			}
			if(country.equalsIgnoreCase("Denmark")) {
				
				System.out.println("Thailand is present");
				//||country.equalsIgnoreCase( "Iceland")||country.equalsIgnoreCase("Denmark")||country.equalsIgnoreCase("Thailand")) {
			}
			
			
			}
			
	}
	
	
	public void purchases_click() {
		WebElement purchases=driver.findElement(By.xpath(("(//*[text()=' Purchases '])[2]")));
		new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(purchases));
		purchases.click();


	}
	public void advance_filter_click() {
		driver.findElement(By.xpath("//div[@data-title-backup='Filter']")).click();
	}
	public void filter_option_select() {
		WebElement select_all_checkbox=driver.findElement(By.xpath(("//*[text()=' Select All '][1]")));
		new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(select_all_checkbox));
		select_all_checkbox.click();
		WebElement apply=driver.findElement(By.xpath(" //*[text()='Apply ' or @class='js-advanced-filter-apply css-btn-filled css-btn-filled-primary']"));
		new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(apply));
		apply.click();
	}
	public void filter_applied() {
		String Total_item =driver.findElement(By.xpath("//*[text()='Total Items']")).getText();
		Assert.assertEquals(Total_item, "Total Items");
	}
}


