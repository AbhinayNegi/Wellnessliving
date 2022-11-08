package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BrowserManager;
import utility.BrowserManager.EPConditions;

public class ChooseLocationPage {

	WebDriver driver;
	
	By btnFlowerIcon = By.xpath("(//a)[1]");
	By btnDashboard = By.xpath("//a[contains(text(),'Dashboard')]");
	By btndashboardTwo = By.xpath("//div[contains(text(),'Dashboard 2')]");
	
	List<WebElement> appointments;
	
	public ChooseLocationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getFlowerButton() {
		//new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@role='dialog']//div//a[contains(text(),'Update')]")));
		return BrowserManager.waitFor(btnFlowerIcon, driver, EPConditions.VISIBLE);
	}
	
	public WebElement getDashboardButton() {
		
		//Waiting for flower menu animation
		//BrowserManager.waitFor(By.xpath("//div[@style='height: 475px; top: 0px; display: block; left: 0px;']"), driver, EPConditions.VISIBLE);
		
		return BrowserManager.waitFor(btnDashboard, driver, EPConditions.CLICKABLE);
	}
	
	public WebElement getDashboardTwoButton() {
		return BrowserManager.waitFor(btndashboardTwo, driver, EPConditions.CLICKABLE);
	}
	
	public List<WebElement> getUnconfirmedAppointments(){
		
		BrowserManager.waitFor(By.xpath("//table[@class='rs-report-collection-schedule-prospect table-zero']//tr"), driver, EPConditions.VISIBLE);
		//return driver.findElements(By.xpath("//tbody//tr[contains(@class,'appointment  js-content-row') and //td//a[text()='Unconfirmed']]")); // investigate further for this xpath
		//driver.findElements(By.xpath("//tbody//tr[contains(@class,'appointment  js-content-row')]//td//a[text()='Unconfirmed']"));
		return driver.findElements(By.xpath("//a[text()='Unconfirmed']//ancestor::tr[contains(@class,'appointment')]")); // investigate further for this xpath
	}
	
	public List<WebElement> getAnyAppointments(){
		
		BrowserManager.waitFor(By.xpath("//table[@class='rs-report-collection-schedule-prospect table-zero']//tr"), driver, EPConditions.VISIBLE);
		//return driver.findElements(By.xpath("//tbody//tr[contains(@class,'appointment  js-content-row') and //td//a[text()='Unconfirmed']]")); // investigate further for this xpath
		//driver.findElements(By.xpath("//tbody//tr[contains(@class,'appointment  js-content-row')]//td//a[text()='Unconfirmed']"));
		return driver.findElements(By.xpath("//tr[contains(@class,'appointment')]")); // investigate further for this xpath
	}
	
	public List<WebElement> getUnconfirmedThreeDotButton() {
		//return BrowserManager.waitFor(By.xpath("(//tbody//tr[contains(@class,'appointment  js-content-row')])[1]//td[5]//a[2]"), driver, EPConditions.CLICKABLE);
		BrowserManager.waitFor(By.xpath("(//tbody//tr[contains(@class,'appointment  js-content-row')])//td[5]//a[2]"), driver, EPConditions.CLICKABLE);
		//driver.findElements(By.xpath("//tbody//tr[contains(@class,'appointment  js-content-row')]//td//a[text()='Unconfirmed']//following-sibling::a"));
		return driver.findElements(By.xpath("//a[text()='Unconfirmed']//ancestor::tr[contains(@class,'appointment')]//td[@data-name='s_menu']//a[contains(@id,'rs-report-gear')]"));
	}
	
	public List<WebElement> getAnyThreeDotButton() {
		//return BrowserManager.waitFor(By.xpath("(//tbody//tr[contains(@class,'appointment  js-content-row')])[1]//td[5]//a[2]"), driver, EPConditions.CLICKABLE);
		BrowserManager.waitFor(By.xpath("(//tbody//tr[contains(@class,'appointment  js-content-row')])//td[5]//a[2]"), driver, EPConditions.CLICKABLE);
		//driver.findElements(By.xpath("//tbody//tr[contains(@class,'appointment  js-content-row')]//td//a[text()='Unconfirmed']//following-sibling::a"));
		return driver.findElements(By.xpath("//tr[contains(@class,'appointment')]//td[@data-name='s_menu']//a[contains(@id,'rs-report-gear')]"));
	}
	
	public List<WebElement> getCheckedInOption() {
		//return BrowserManager.waitFor(By.xpath("(//tbody//tr[contains(@class,'appointment  js-content-row')])//td[5]//div//ul//li[1]"), driver, EPConditions.CLICKABLE);
		//return driver.findElements(By.xpath("//tbody//tr[contains(@class,'appointment  js-content-row')]//td//a[text()='Unconfirmed']//following-sibling::div//ul//li[1]"));
		return driver.findElements(By.xpath("//a[text()='Unconfirmed']//ancestor::tr[contains(@class,'appointment')]//td[@data-name='s_menu']//div[contains(@id,'rs-report-gear')]//ul//li[@data-title='Checked-In']"));
	}
	
	public WebElement getCheckInMsg() {
		
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("mp-note-frame")));
		return BrowserManager.waitFor(By.xpath("//div[@id='mp-note-text']//div"), driver, EPConditions.VISIBLE);
	}
	
	public void waitForMsgToDisappear() {
		BrowserManager.waitFor(By.xpath("//div[@id='mp-note-div' and @style='opacity: 0;']"), driver, EPConditions.PRESENCE);
	}
	
	public List<WebElement> getClientNameButton(String name) {
		
		//return driver.findElements(By.xpath("//a[text()='Checked-in']//parent::td//parent::tr[contains(@class, 'appointment  js-content-row')]//td[@data-name='s_visit_stat']//a[contains(@class,'18')]"));
		return driver.findElements(By.xpath("(//a[text()='Checked-in']//ancestor::tr[contains(@class,'appointment')]//td[@data-name='s_visit_stat']//div//div//following-sibling::div//a[text()='"+name+"'])[1]"));
		//return driver.findElements(By.xpath("((//a[text()='Checked-in']//ancestor::tr[contains(@class,'appointment')])["+index+"]//td[@data-name='s_visit_stat']//div)[3]//a[contains(@class,'18')]"));
	}
	
	public List<WebElement> getUnconfirmedClientsName(String index){
		return driver.findElements(By.xpath("(//a[text()='Unconfirmed']//ancestor::tr[contains(@class,'appointment')]//td[@data-name='s_visit_stat']//div//div//following-sibling::div//a[@class='css-nowrap css-font-size-18'])["+index+"]"));
	}
	
	public List<WebElement> getAnyClientsName(String index){
		return driver.findElements(By.xpath("(//tr[contains(@class,'appointment')]//td[@data-name='s_visit_stat']//div//div//following-sibling::div//a[@class='css-nowrap css-font-size-18'])["+index+"]"));
	}
	
	public List<WebElement> getUnconfirmedClientNoShowOptions(){
		return driver.findElements(By.xpath("//a[text()='Unconfirmed']//ancestor::tr[contains(@class,'appointment')]//td[@data-name='s_menu']//div[contains(@id,'rs-report-gear')]//ul//li[@data-title='No Show']"));
	}
	
	public List<WebElement> getAnyClientNoShowOptions(){
		return driver.findElements(By.xpath("//tr[contains(@class,'appointment')]//td[@data-name='s_menu']//div[contains(@id,'rs-report-gear')]//ul//li[@data-title='No Show']"));
	}
	
	public void waitForNowShowConfirmationDialogBox() {
		BrowserManager.waitFor(By.xpath("//div[@class='css-appointment-view-panel']"), driver, EPConditions.VISIBLE);
	}
	
	public WebElement getReasonInput() {
		return BrowserManager.waitFor(By.xpath("//input[@placeholder='Enter reason']"), driver, EPConditions.CLICKABLE);
	}
	
	public WebElement getNoShowReasonDialogBoxConfirmButton() {
		return BrowserManager.waitFor(By.xpath("//button[@onclick='Wl_Appointment_Cancel_Confirm.submit(this);']"), driver, EPConditions.CLICKABLE);	
	}
	public WebElement getAttendanceButton() {
		return BrowserManager.waitFor(By.xpath("(//a[contains(@class, 'profile-attendance')])[2]"),driver, EPConditions.CLICKABLE);
	}
	
	public WebElement getUpComingScheduleButton() {
		return BrowserManager.waitFor(By.xpath("(//a[contains(text(),'Upcoming Schedule')])[2]"), driver, EPConditions.CLICKABLE);
	}
	
	public WebElement getAttendanceHistoryButton() {
		return BrowserManager.waitFor(By.xpath("(//a[contains(text(),'Attendance History')])[2]"),driver, EPConditions.CLICKABLE);
	}
	
	public List<WebElement> getAttendedStatus() {
		return driver.findElements(By.xpath("//tr[@class='e   js-content-row'][1]//td[@data-name='o_status']"));
	}
	
	public List<WebElement> getScheduleStatus() {
		return driver.findElements(By.xpath("//tr[@class='e   js-content-row'][1]//td[@data-name='o_status']"));
	}
}
