package wellnessliving_utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Web_Pages.Login_page;

public class Base_class {
	static WebDriver driver;

	public static String user = "User";
	public static String pass = "password";

	public static void Browser_init() {

		driver = new ChromeDriver();

	}

	public static List File_read() throws IOException {
		
		List<String> list=new ArrayList<String>(); 
       Properties prop = new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\wellnessliving\\target\\Config.properties");
		//Properties prop = new Properties();
		prop.load(fis);
		user = prop.getProperty("User");     // reading data from property file "base.properties"
		pass = prop.getProperty("password");
		list.add(user);
		list.add(pass);
       return list;
	}
	

	public static void geturl(String url) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static WebDriver getdriver() {
		return driver;
	}

}




