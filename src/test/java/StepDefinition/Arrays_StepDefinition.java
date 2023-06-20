package StepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import PageObjects.ArraysPage;
import Utilities.configReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.tlh.ach;
import Utilities.Loggerload;


public class Arrays_StepDefinition {
	
	
	
	ArraysPage arrayPage = new ArraysPage();
	String Excelpath = configReader.getexcelfilepath();
	static String expectedMsg;


	@When("The user select Array item from the drop down menu")
	public void the_user_select_array_item_from_the_drop_down_menu() {
		Loggerload.info("The user select Array item from the drop down menu");
		arrayPage.dropdown_arrayClick();
	}

	@Then("The user be directed to {string} Data Structure Page")
	public void the_user_be_directed_to_data_structure_page(String  pagename) {
		
		Loggerload.info("User redirected to " + pagename + " Page ");

		String Title = arrayPage.ArrayPageTitle();
		Loggerload.info("Title of current page is : " + Title);

		assertEquals(Title, pagename, "Title do not match");

	}

	@When("The user clicks Arrays in Python link")
	public void the_user_clicks_arrays_in_python_link() {
	    
		
		arrayPage.ClickOnArraysInPython();
	}

	@Then("The user should be redirected to {string} page")
	public void the_user_should_be_redirected_to_page(String pagename) {
		
		Loggerload.info("User redirected to " + pagename + " Page ");
		String Title = arrayPage.ArrayPageTitle();
		Loggerload.info("Title of current page is : " + Title);
		assertEquals(Title, pagename, "Title do not match");
	}
	// @TS_array_04
	@When("The user clicks {string} button on {string} page")
	public void the_user_clicks_button_on_page(String btname, String destname) throws InvalidFormatException, IOException {
		
	 arrayPage.clickOnTryhereLink(btname,destname);

	}

	@Then("The user should be redirected to a page having an tryEditor with a Run button to test")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test() {
		
		
		Loggerload.info("User redirected to a page having an tryEditor with a Run button to test");
		String Title = arrayPage.ArrayPageTitle();
		Loggerload.info("Title of current page is : " + Title);
		assertEquals(Title, "Assessment", "Title do not match");
	   
	}
	// @TS_array_05
	
	@Given("The user is in a page having an tryEditor with a Run button to test")
	public void the_user_is_in_a_page_having_an_try_editor_with_a_run_button_to_test() {
	   
		Loggerload.info("The user is in a page having an tryEditor with a Run button to test");
		arrayPage.navigateTotryEditor();
		String Title = arrayPage.ArrayPageTitle();
		Loggerload.info("Title of current page is : " + Title);
		
	
		
	}

	@When("The user enter valid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_valid_python_code_in_try_editor_from_sheet_and(String sheetname, Integer rownumber) throws InvalidFormatException, IOException {
		
		Loggerload.info("The user enter valid python code in tryEditor from sheetname :" + sheetname
				+ " and row number : " + rownumber);
		arrayPage.enterPythonCode(sheetname, rownumber);
		expectedMsg = arrayPage.getExpectedResult(sheetname, rownumber);

	}

	@When("The user clicks on run button")
	public void the_user_clicks_on_run_button() {
	    arrayPage.clickOnRunButton();
	}

	@Then("The user should be presented with Run result")
	public void the_user_should_be_presented_with_run_result() {
		String actualMsg = arrayPage.getActualResult();
		Loggerload.info("Actual result  : " + actualMsg);
		assertEquals(actualMsg, expectedMsg, "Result do not match");
	    
	}
	// @TS_array_06
	
	@When("The user enter python code with invalid syntax in tryEditor from sheet {string} and {int}")
	public void the_user_enter_python_code_with_invalid_syntax_in_try_editor_from_sheet_and(String  sheetname, Integer rownumber) throws InvalidFormatException, IOException {
		
		Loggerload.info("The user enter valid python code in tryEditor from sheetname :" + sheetname
				+ " and row number : " + rownumber);
		arrayPage.enterPythonCode(sheetname, rownumber);

	}

	@Then("The user should be presented with error message as {string}")
	public void the_user_should_be_presented_with_error_message_as(String string) {
		String actualMsg = arrayPage.getErrorText();
		Loggerload.info("Actual Error message is  : " + actualMsg);
		assertEquals(actualMsg,"NameError: name 'hello' is not defined on line 1", "Result do not match");
	}

}