package Web_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import wellnessliving_utility.Base_class;

public class Login_page extends Base_class {

	WebDriver driver;
	Base_class obj= new Base_class(); 
	
	public Login_page(WebDriver driver2) {
		
		this.driver=driver2;
	
	}
 
	public void enter_email() throws IOException {
	
	WebElement Email=driver.findElement(By.name("login"));
	Email.sendKeys((CharSequence[]) Base_class.File_read().get(0));
	
	}
	public void enter_pass() throws IOException {
		WebElement pwd=driver.findElement(By.name("pwd"));
		pwd.sendKeys((CharSequence[]) Base_class.File_read().get(1));
		
		}
	public void Signin () {
		WebElement sign_btn=driver.findElement(By.name("b_submit"));
		sign_btn.click();
		}
	

}
