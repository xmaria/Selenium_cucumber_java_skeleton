package stepDefinitons;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import CucumberTest.LoginPage;
import cucumber.api.java.After;

public class LoginSteps {

	@Given("^I launch facebook login url$")
	public void i_launch_facebook_login_url() throws Throwable {
		LoginPage.launchUrl();
	    
	}

	@Then("^I am on facebook login page$")
	public void i_am_on_facebook_login() throws Throwable {
	   LoginPage.verifyLoginPageLoads();
	}

	@When("^I should be able to enter username ans password$")
	public void i_should_be_able_to_enter_username_ans_password() throws Throwable {
	    LoginPage.enterLoginCreds();
	}

	@When("^I click on \"([^\"]*)\"$")
	public void i_click_on(String arg1) throws Throwable {
	    LoginPage.clickButton(arg1);
	}

	@Then("^I should be able to see Homepage$")
	public void i_should_be_able_to_see_Homepage() throws Throwable {
	    LoginPage.verifyHomePageLoads();
	}

	@Given("^I am on facebook Homepage$")
	public void i_am_on_facebook_Homepage() throws Throwable {
	   LoginPage.verifyHomePageLoads();
	}

	@After
	public void tearDown() throws Exception {
		LoginPage.teardown();

	}



}
