package stepDefination;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import PageObject.AddClientPage;
import PageObject.CancelAppointmentPage;
import PageObject.ChooseLocationPage;
import PageObject.ClientProfile;
import PageObject.DashboardPage;
import PageObject.LoginPage;
import actions.DashboardAction;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import utility.BrowserManager;
import utility.Generic_method;
import utility.BrowserManager.EPConditions;

public class StepDefinition {

	int appointmentIndex = 0;
	String clientName;
	WebDriver driver;

	List<WebElement> upcomming;
	List<WebElement> history;
	String upcommingStatus;
	String historyStatus;

	LoginPage loginPage;
	AddClientPage addClientPage;
	ClientProfile clientprofilepage;
	ChooseLocationPage locationPage;
	DashboardPage dashboardPage;
	CancelAppointmentPage cPage;

	Scenario scenario;

	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

	@Given("Open the {string} browser and go to {string}")
	public void open_the_browser_and_go_to(String browser, String url) {
		// Write code here that turns the phrase above into concrete actions
		BrowserManager.setDriver(browser);
		driver = BrowserManager.getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);

		BrowserManager.setLC(driver);
		System.out.println("The scenario name is : " + scenario.getName());

	}

	@Then("Verify {string} heading is there")
	public void verify_heading_is_there(String string) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("pass");
	}

	@Then("Enter {string} in Email")
	public void enter_in_email(String email) {
		// Write code here that turns the phrase above into concrete actions
		loginPage = BrowserManager.getLoginPage();
		loginPage.enterEmail(email);
	}

	@Then("Enter {string} in password")
	public void enter_in_password(String passwd) {
		// Write code here that turns the phrase above into concrete actions
		loginPage.enterPasswd(passwd);
	}

	@When("click on Sign In button")
	public void click_on_sign_in_button() {
		// Write code here that turns the phrase above into concrete actions
		loginPage.signin();

	}

	@Given("Verify the BO name will display")
	public void verify_the_bo_name_will_display() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("pass");
		addClientPage = BrowserManager.getClientPage();
		addClientPage.closePopup();
		// addClientPage.closeMigrationPopUp().click();
	}

	@When("Click on the Add client tab")
	public void click_on_the_add_client_tab() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		addClientPage = BrowserManager.getClientPage();
		Thread.sleep(3000);
		addClientPage.clickAddClient();

	}

	@Given("Verify {string} page is open")
	public void verify_page_is_open(String string) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("pass");
	}

	@Then("^Enter First Name (.*)$")
	public void enter_first_name(String firstname) {
		// Write code here that turns the phrase above into concrete actions
		addClientPage.enterFirstName(firstname);
	}

	@Then("^Enter Last Name (.*)$")
	public void enter_last_name(String lasttname) {
		// Write code here that turns the phrase above into concrete actions
		addClientPage.enterlast(lasttname);
	}

	@Then("^Enter  (.*) in the Email")
	public void enter_in_the_email(String email) {
		// Write code here that turns the phrase above into concrete actions
		addClientPage.enterEmail(email);
	}

	@Then("Click on Create Account")
	public void click_on_create_account() {
		// Write code here that turns the phrase above into concrete actions
		addClientPage.createAccount();
	}

	@Then("Open client profile")
	public void open_client_profile() throws InterruptedException, AWTException {
		clientprofilepage = BrowserManager.getClientProfile();
		clientprofilepage.go_to_clientprofile();
	}

	@Then("Go to Account -> Billing & Account Balance")
	public void go_to_account_billing_account_balance() {
		clientprofilepage.go_to_bill_accountbalances();
	}

	@Then("Click on the Add credit card button")
	public void click_on_the_add_credit_card_button() {
		clientprofilepage.addcreditcard();

	}

	@Then("Open  Country dropdown")
	public void open_country_dropdown() {
		clientprofilepage.country_click();
	}

	@Then("There presented new options: Italy, Iceland,Denmark,Thailand")
	public void there_presented_new_options_italy_iceland_denmark_thailand() {
		clientprofilepage.check_country();

	}

	@Then("Click on Purchases tab on the side panel")
	public void click_on_purchases_tab_on_the_side_panel() {
		clientprofilepage.go_to_bill_accountbalances();
		clientprofilepage.purchases_click();
	}

	@Then("Click on Advanced Filter -> Select any options")
	public void click_on_advanced_filter_select_any_options() {
		clientprofilepage.advance_filter_click();
		clientprofilepage.filter_option_select();
	}

	@Then("It should display respective result")
	public void it_should_display_respective_result() {
		clientprofilepage.filter_applied();
	}

	/**
	 * @author Abhinay Singh Negi
	 */
	@Then("Click on Dashboard")
	public void click_on_dashboard() throws InterruptedException {

		locationPage = new ChooseLocationPage(BrowserManager.getDriver());

		Thread.sleep(4000);
		locationPage.getFlowerButton().click();
		locationPage.getDashboardButton().click();

		locationPage.getDashboardTwoButton().click();

	}

	@Then("Scroll down to Daily tracker")
	public void scroll_down_to_daily_tracker() throws InterruptedException {
		System.out.println("This no show scenario called by: " + scenario.getName());

		locationPage = new ChooseLocationPage(BrowserManager.getDriver());
		BrowserManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		boolean canChangeDate = true;
		driver = BrowserManager.getDriver();

		// BrowserManager.waitFor(By.xpath("(//div[@class='css-wl-report-filter-advance-load']//div[@class='circle-12
		// load-item'])[2]"), driver, EPConditions.INVISIBLE);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		List<WebElement> appointments = null;

		if (scenario.getName().contains("No show") || scenario.getName().contains("Cancel Appointment")) { // this block will get any appointments whether it is unconfirmed or not
			while (canChangeDate) {
				appointments = locationPage.getAnyAppointments();
				if (appointments.size() != 0) {
					break;
				}
				DashboardAction.changeData(driver, By.xpath("(//span[@data-title-backup='Next'])[1]"));
			}

			if (appointments.size() != 0) {

				WebElement e = appointments.get(appointmentIndex);
				Point p = e.getLocation();
				String y = String.valueOf(p.y - 500);

				js.executeScript("window.scrollBy(0," + y + ");");
			} else {
				System.out.println("No available appointments");
			}
		} else {
			while (canChangeDate) {
				appointments = locationPage.getUnconfirmedAppointments();
				if (appointments.size() != 0) {
					break;
				}
				DashboardAction.changeData(driver, By.xpath("(//span[@data-title-backup='Next'])[1]"));
			}

			if (appointments.size() != 0) {

				WebElement e = appointments.get(appointmentIndex);
				Point p = e.getLocation();
				String y = String.valueOf(p.y - 500);

				js.executeScript("window.scrollBy(0," + y + ");");
			} else {
				System.out.println("No available appointments");
			}
		}

	}

	@Then("Click on Setup button in the end of any appointment line http:\\/\\/screencast.com\\/t\\/oPQjJK8wf")
	public void click_on_setup_button_in_the_end_of_any_appointment_line_http_screencast_com_t_o_p_qj_jk8wf()
			throws InterruptedException {

		if(scenario.getName().contains("No show")|| scenario.getName().contains("Cancel Appointment")) {
			clientName = locationPage.getAnyClientsName(Integer.toString(appointmentIndex + 1)).get(0).getText();
			locationPage.getAnyThreeDotButton().get(appointmentIndex).click();
		} else {
			clientName = locationPage.getUnconfirmedClientsName(Integer.toString(appointmentIndex + 1)).get(0).getText();
			locationPage.getUnconfirmedThreeDotButton().get(appointmentIndex).click();
		}
		
	}

	@Then("Click on {string} option")
	public void click_on_option(String string) {
		dashboardPage = new DashboardPage(driver);
		
		if(string.equals("Cancel Appointment")) {
			dashboardPage.clickCancelAppointmentButton();
		}else if(string.equals("Checked-in")) {
			System.out.println("Xpath is : " + locationPage.getCheckedInOption().get(0).getAttribute("xpath"));
			locationPage.getCheckedInOption().get(appointmentIndex).click();
		}
		
	}

	@Given("A message should appear {string}")
	public void a_message_should_appear(String string) {

		if (string.equals("Client marked as no show")) {
			String msg = locationPage.getCheckInMsg().getText();
			locationPage.waitForMsgToDisappear();
			System.out.println("worked");
			// assertEquals(msg, string);

			driver.switchTo().defaultContent();
		} else {
			String msg = locationPage.getCheckInMsg().getText();

			assertEquals(msg, string);

			driver.switchTo().defaultContent();
		}
	}

	@Given("Click on the client's name on ATTENDANCE column")
	public void click_on_the_client_s_name_on_attendance_column() {
		// locationPage.getClientNameButton().get(0).click();
		locationPage.getClientNameButton(clientName).get(appointmentIndex).click();
	}

	@Given("Clients profile appears")
	public void clients_profile_appears() {
		System.err.println("Profiles appears");
	}

	@Then("Click on {string} on the side panel")
	public void click_on_on_the_side_panel(String string) {

		if(scenario.getName().contains("No show")) {
			locationPage.getAttendanceButton().click();

			locationPage.getUpComingScheduleButton().click();
			upcomming = locationPage.getScheduleStatus();

			if (upcomming.size() != 0) {
				System.out.println("Status: " + upcomming.get(0).getText());
				upcommingStatus = upcomming.get(0).getText();
			}

			locationPage.getAttendanceHistoryButton().click();
			history = locationPage.getAttendedStatus();

			if (history.size() != 0) {
				System.out.println("Status: " + history.get(0).getText());
				historyStatus = history.get(0).getText();
			}
			System.err.println("Clicked on attendence button");
		} else {
			driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
			locationPage.getAttendanceButton().click();

			locationPage.getUpComingScheduleButton().click();
			upcomming = locationPage.getScheduleStatus();
		}
		

		if (upcomming.size() != 0) {
			System.out.println("Status: " + upcomming.get(0).getText());
			upcommingStatus = upcomming.get(0).getText();
		}

		locationPage.getAttendanceHistoryButton().click();
		history = locationPage.getAttendedStatus();

		if (history.size() != 0) {
			System.out.println("Status: " + history.get(0).getText());
			historyStatus = history.get(0).getText();
		}
		System.err.println("Clicked on attendence button");
	}
	// @Then("Click on {string} on the side panel")
	// public void click_on_on_the_side_panel(String string) {
	// locationPage.getAttendanceButton().click();
	// System.err.println("Clicked on attendence button");
	// //locationPage.getAttendanceHistoryButton().click();
	// }

	@Given("Clients status for this appointment should be {string}")
	public void clients_status_for_this_appointment_should_be(String string) {

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(upcommingStatus, string);
		softAssert.assertEquals(historyStatus, string);
	}

	@When("Click on Setup button in the and of any appointmen line")
	public void click_on_setup_button_in_the_and_of_any_appointmen_line() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Click on {string} option and confirm your choice")
	public void click_on_option_and_confirm_your_choice(String string) {
		locationPage.getAnyClientNoShowOptions().get(0).click();
		locationPage.waitForNowShowConfirmationDialogBox();
		locationPage.getReasonInput().sendKeys("Random reason");
		locationPage.getNoShowReasonDialogBoxConfirmButton().click();
		System.out.println("No show");
	}

	@When("Find clients profile")
	public void find_clients_profile() throws InterruptedException {
		dashboardPage = new DashboardPage(driver);

		dashboardPage.getSearchIcon().click();
		dashboardPage.getSearchField().sendKeys(clientName);
		Thread.sleep(2000);
		dashboardPage.getAllClientNameSearchSuggestions().get(0).click();
	}
	
	@Then("STEP {int} Confirmation")
	public void step_confirmation(Integer int1) {
	    
	}

	@When("Click {string} button")
	public void click_button(String string) {
	    cPage = new CancelAppointmentPage(driver);
	    cPage.clickYesButton();
	}

	@Then("STEP {int} Reason")
	public void step_reason(Integer int1) {
	    
	}

	@When("Select reason and click {string} button")
	public void select_reason_and_click_button(String string) {
	    cPage.clickReasonNextButton();
	}

	@Then("STEP {int} Notification")
	public void step_notification(Integer int1) {
	    
	}

	@Then("{string} check box is checked and click on {string} button")
	public void check_box_is_checked_and_click_on_button(String string, String string2) {
	    cPage.verifyCheckBoxAndClickOnNextButton();
	}

	@Then("The appointment should be successfully canceled")
	public void the_appointment_should_be_successfully_canceled() {
		cPage.checkMsg();
	}

	@Then("A mail of {string} type should be sent to client\\(s)")
	public void a_mail_of_type_should_be_sent_to_client_s(String string) {
	    
	}

}
