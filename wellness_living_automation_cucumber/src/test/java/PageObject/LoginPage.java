package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.BrowserManager;

public class LoginPage {

	
	WebDriver driver;

	public  LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	
		this.driver = driver;
	}
	
	public void enterEmail(String email) {
		
		WebElement email_field = driver.findElement(By.xpath("//input[@id='template-passport-login']"));
		email_field.sendKeys(email);
	}
	
public void enterPasswd(String passwd) {
		
		WebElement email_field = driver.findElement(By.xpath("//input[@id='template-passport-password']"));
		email_field.sendKeys(passwd);
	}
	

public void signin() {
	WebElement signinBtn = driver.findElement(By.xpath("//button[@name='b_submit' and text()=' Sign in ']"));
	signinBtn.click();
}
	
	
	
}
