package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Generic_method {

	public static void selectValueFromDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
}
