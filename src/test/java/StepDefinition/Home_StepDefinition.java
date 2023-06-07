package StepDefinition;

import static org.testng.Assert.assertEquals;

import DriverFactory.BaseClass;
import PageObjects.homePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Home_StepDefinition {
	homePage home = new homePage(BaseClass.getdriver());

	// User launch DsAlgo page
	@Given("The user opens DS Algo portal link")
	public void the_user_opens_ds_algo_portal_link() throws Exception {
		home.dsalgopage();

	}

	@When("The user clicks the {string} button")
	public void the_user_clicks_the_button(String string) {

		home.getStartedButton();

	}

	@Then("The user should be redirected to homepage")
	public void the_user_should_be_redirected_to_homepage() {
		String Title = home.getPageTitle();
		assertEquals(Title, "NumpyNinja", "Title do not match");

	}

	// The user tried to access link - click without login in home page
	@Given("The user is on Home page")
	public void the_user_is_on_home_page() {
		home.homepage();
	}

	// user click Getstarted link on home page
	@When("The user clicks on Get Started link on homepage {string} without login")
	public void the_user_clicks_on_get_started_link_on_homepage_without_login(String string) {
		home.getStarted_home(string);
	}

	@Then("The user get warning message {string}")
	public void the_user_get_warning_message(String string) {

		String alert = home.alert();

		assertEquals(alert, string, "Title do not match");

	}

	// User clicks drop down
	@When("The user clicks on dropdown {string}")
	public void the_user_clicks_on_dropdown(String string) {
		home.dropdown(string);
	}

	@When("The user clicks on dropdown")
	public void the_user_clicks_on_dropdown() {

	}

	// User click on sign in
	@When("The user clicks on signin link")
	public void the_user_clicks_on_signin_link() {
		home.signin_link();
	}

	@Then("The user redirected to login page")
	public void the_user_redirected_to_login_page() {
		String Title = home.login_page();

		assertEquals(Title, "Login", "Title do not match");

	}

	// USer click on Register
	@When("The user clicks on register link")
	public void the_user_clicks_on_register_link() {

		home.register_link();
	}

	@Then("The user redirected to Registration page")
	public void the_user_redirected_to_registration_page() {
		String Title = home.register_page();

		assertEquals(Title, "Registration", "Title do not match");

	}

}
