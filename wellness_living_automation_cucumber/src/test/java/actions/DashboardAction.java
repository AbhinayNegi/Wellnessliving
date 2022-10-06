package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObject.ChooseLocationPage;
import utility.BrowserManager;
import utility.BrowserManager.EPConditions;

public class DashboardAction {

	public static void changeData(WebDriver driver, By nextArrow) {
		WebElement e = BrowserManager.waitFor(nextArrow, driver, EPConditions.CLICKABLE);
		e.click();
	}
}
