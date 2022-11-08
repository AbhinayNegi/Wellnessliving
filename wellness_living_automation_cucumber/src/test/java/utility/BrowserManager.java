package utility;

import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.AddClientPage;
import PageObject.ClientProfile;
import PageObject.LoginPage;

public class BrowserManager {
	public static ChromeDriver chromeDriver;
	public static EdgeDriver edgeDriver;
	public static FirefoxDriver firefoxDriver;
	
	public static enum EPConditions {
		VISIBLE, CLICKABLE, PRESENCE, STALENESS, INVISIBLE
	}
	
	static WebDriverWait wait;

	private static WebDriver webDriver;
	//private static WebDriverWait wait;

	public static void setDriver(String browser) {

		System.out.println("setDriver " + browser);

		if (browser.equals("Chrome")) {
			
			ChromeOptions c = new ChromeOptions();
			c.addArguments("--start-maximized");
			c.addArguments("--disable-extension");
			c.addArguments("disable-media-stream");
			//c.addArguments("headless");
			
			webDriver = new ChromeDriver(c);
			
		} else if (browser.equals("Firefox")) {
//			ProfilesIni ini = new ProfilesIni();
//			FirefoxProfile profile = ini.getProfile("Testing");
//			FirefoxOptions op = new FirefoxOptions();
//			op.setProfile(profile);
			
			webDriver = new FirefoxDriver();
		} else if (browser.equals("Edge")) {
			webDriver = new EdgeDriver();
			webDriver.manage().window().maximize();
		}

	}

	public static void navigateTo(String url) {
		webDriver.get(url);
	}

	public static void close() {
		webDriver.close();
	}
	
	public static WebDriver getDriver() {
		if(webDriver != null) {
			return webDriver;
		}
		return null;
	}
	
	public static WebElement fluentWait(final String path) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver t) {

				return webDriver.findElement(By.cssSelector(path));
			}
		});
		return element;
	}
	
	public static void reEnterDetails(By selectorPath, String value) {
		WebElement e = webDriver.findElement(selectorPath);
		e.clear();
		e.sendKeys(value);
	}
	
	public static String getElementAttribute(By selctorPath) {
		return webDriver.findElement(selctorPath).getAttribute("value");
	} // remove these methods.
	
	public static WebElement waitFor(By locator, WebDriver tempDriver, EPConditions epConditions) {
		wait = new WebDriverWait(tempDriver, Duration.ofSeconds(20));

		switch (epConditions) {
		case CLICKABLE:
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		case VISIBLE:
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		case PRESENCE:
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		case INVISIBLE:
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			return null;
		default:
			return null;
		}
	}
	
	public static void click(WebElement e, WebDriver tempDriver) {
		wait = new WebDriverWait(tempDriver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(e)).click();;
	}
	public static void click(By e, WebDriver tempDriver) {
		wait = new WebDriverWait(tempDriver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(e)).click();;
	}
	
	public static void getCapability(String browser) throws IOException {
		if(browser.equals("Chrome")) {
			chromeDriver = new ChromeDriver();
			Capabilities cap = chromeDriver.getCapabilities();
			System.out.println(cap.asMap());
		}
		else if(browser.equals("Firefox")) {
			firefoxDriver = new FirefoxDriver();
			Capabilities cap = firefoxDriver.getCapabilities();
			System.err.println(cap.asMap());
		}
		else if(browser.equals("Edge")) {
			edgeDriver = new EdgeDriver();
			Capabilities cap = edgeDriver.getCapabilities();
			System.out.println(cap.asMap());
			
		}
		
	}
	
	public static void frameWait(By locator, WebDriver tempDriver) {
		wait = new WebDriverWait(tempDriver, Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	public static LoginPage loginPage;
	public static AddClientPage clientpage;
	public static ClientProfile ClientProfile;
	public static void  setLC(WebDriver tempDriver) {
		loginPage = new LoginPage(tempDriver);
		clientpage = new AddClientPage(tempDriver);
		ClientProfile=new ClientProfile(tempDriver);
	}
	public static LoginPage   getLoginPage() {
	 return loginPage;
	}
	
	public static AddClientPage  getClientPage() {
		 return clientpage;
		}
	public static ClientProfile getClientProfile() {
		return ClientProfile;
		
	}
}



