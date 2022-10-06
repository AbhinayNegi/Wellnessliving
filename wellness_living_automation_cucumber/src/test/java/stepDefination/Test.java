package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	WebDriver driver;
	
    @org.testng.annotations.Test
    public void ByPixel() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Launch the application		
        driver.get("http://demo.guru99.com/test/guru99home/");

        // This  will scroll down the page by  1000 pixel vertical		
        WebElement e = driver.findElement(By.xpath("(//div//a)[102]"));
        Point p = e.getLocation();
        String y = String.valueOf(p.y + 500);
        js.executeScript("window.scrollBy(0,"+y+")");
    }
}
