package Step_Defination;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Web_Pages.Login_page;
import io.cucumber.java.en.*;
import wellnessliving_utility.Base_class;

public class StepDefination {
Login_page login;
static WebDriver driver;	
	@Given("Log in as BO")
	public void log_in_as_BO() throws IOException {
		Base_class.Browser_init();
		Base_class.geturl("https://staging.wellnessliving.com/login-home.html");
		driver = Base_class.getdriver();
		
		login=new Login_page(driver);
		
		
		
		login.enter_email();
	    login.enter_pass();
	    login.Signin();
	}

//	@Then("Click on Dashboard")
//	public void click_on_Dashboard() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("Click on Setup button in the and of any appointmen line")
//	public void click_on_Setup_button_in_the_and_of_any_appointmen_line() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("Click on {string} option and confirm your choice")
//	public void click_on_option_and_confirm_your_choice(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("A message should appear {string} https:\\/\\/monosnap.com\\/file\\/2NfIqlWof9CssXGzoT5YGxJ928gY0O")
//	public void a_message_should_appear_https_monosnap_com_file_2NfIqlWof9CssXGzoT5YGxJ928gY0O(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("Find client's profile")
//	public void find_client_s_profile() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("Click on {string} on the side panel")
//	public void click_on_on_the_side_panel(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("Client's status for this appointment should be {string}")
//	public void client_s_status_for_this_appointment_should_be(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	
//	
	
}
