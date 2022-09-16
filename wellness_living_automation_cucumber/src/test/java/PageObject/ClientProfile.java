package PageObject;
import java.awt.event.KeyEvent;
import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;
import java.awt.Robot;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.AWTException;
public class ClientProfile {

	 WebDriver driver;

		public  ClientProfile(WebDriver driver) {
			
			this.driver = driver;
		}
		
//		public void closePopup() {
//			
//			WebElement updatepaymentElement =  driver.findElement(By.xpath("(//button[@title= 'Close'])[1]"));
//			 new WebDriverWait(driver,  Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(updatepaymentElement));
//			  		  
//			  updatepaymentElement.click(); 
			 
//		}
		
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
	
//			driver.findElement(By.xpath(("(//input[@value='View profile'])[1]"))).click();
		
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
			WebElement country_dropdown = driver.findElement(By.xpath("(//select[@class='css-width-300p'])[1]"));
			new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(country_dropdown));
			country_dropdown.click();
			
		}
            public void check_country() {
            	int sum=0;
//    			WebElement country_dropdown = driver.findElement(By.xpath("(//select[@class='css-width-300p'])[1]"));
//    			new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(country_dropdown));
//    			//country_dropdown.click();
    			List <WebElement> country_names=driver.findElements(By.xpath("(//select[@class='css-width-300p'])[1]"));
    			for(WebElement e : country_names) {
    				String country=e.getText();
    				if(country.equalsIgnoreCase(" Italy ")||country.equalsIgnoreCase( "Iceland")||country.equalsIgnoreCase("Denmark")||country.equalsIgnoreCase("Thailand")) {
    					sum=sum+1;
    				}
    				
    		}
    		
    			if(sum==4) {
    				System.out.println("All countries are present");
    			}
    			else {
    				System.out.println("Some countries are missing");
    			}
    		}
            
}


