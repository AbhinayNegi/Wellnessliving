package StepDefination;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import PageObject.AddClientPage;
import PageObject.ClientProfile;
import PageObject.LoginPage;
import io.cucumber.java.en.*;
import utility.BrowserManager;

public class StepDefinition {
	WebDriver driver ;
	LoginPage loginPage;
	AddClientPage addClientPage;
	ClientProfile clientprofilepage;
	@Given("Open the {string} browser and go to {string}")
	public void open_the_browser_and_go_to(String browser, String url) {
	    // Write code here that turns the phrase above into concrete actions
		  BrowserManager.setDriver(browser);
		    driver = BrowserManager.getDriver();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		    driver.get(url);
		  
		   BrowserManager.setLC(driver);
		   
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
		clientprofilepage=BrowserManager.getClientProfile();
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

	
}
