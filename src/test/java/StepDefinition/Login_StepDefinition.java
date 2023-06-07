package StepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import PageObjects.loginPage;
import Utilities.configReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import Utilities.ExcelReader;

import Utilities.configReader;

public class Login_StepDefinition {
	
	loginPage login = new loginPage();
	static String username;
	static String password;
	static String message;
	Boolean isRequired;
	String Excelpath = configReader.getexcelfilepath();

	
	
   @Given("The user is on signin page")
	public void the_user_is_on_signin_page() {
	   login.login_page();
	}

	@When("The user clicks on register link on signin page")
	public void the_user_clicks_on_register_link_on_signin_page() {
		login.register_link();
	    
	}

	@Then("The user redirected to Registration page from signin page")
	public void the_user_redirected_to_registration_page_from_signin_page() {
		String Title = login.register_page();
		assertEquals(Title, "Registration", "Title do not match");
	}

	//invalid data from scenario outline
	
	@When("The user enter invalid {string} and {string}")
	public void the_user_enter_invalid_and(String username, String password) {
		isRequired = login.Login(username, password);
		assertTrue(isRequired);
	}

	@Then("click login button to verify")
	public void click_login_button_to_verify() {
		
		login.login_button();
	}

	// user read both invalid and valid data from excel

	@When("The user enter sheet {string} and {int}")
	public void the_user_enter_sheet_and(String sheetName, Integer rownumber) throws InvalidFormatException, IOException {
		
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = ExcelReader.getData(Excelpath, sheetName);
		username = testdata.get(rownumber).get("username");
		password = testdata.get(rownumber).get("password");
		message = testdata.get(rownumber).get("expectedmessage");

		
		if (username != null || password != null)
			login.Login(username, password);
	    
	}
	// user get an alert message when login with invalid data and login successfully
		// for valid data

	@Then("click login button")
	public void click_login_button() {
		String msg = login.click_login();
		
		assertEquals(msg, message);
	}

	@Given("The user is on signin page with valid username {string} and password {string}")
	public void the_user_is_on_signin_page_with_valid_username_and_password(String string, String string2) {
		login.Login(username, password);
	login.click_login();
	}

	// User clicks on signout
	
	@When("The user click signout button")
	public void the_user_click_signout_button() {
		login.Login(username, password);
		login.click_login();
	}

	@Then("The user redirected to homepage")
	public void the_user_redirected_to_homepage() {
	    login.signout();
	}


}
