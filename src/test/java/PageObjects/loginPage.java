package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.BaseClass;
import Utilities.configReader;
import DriverFactory.abstractComponents;


public class loginPage extends abstractComponents {
	
	public static WebDriver driver=BaseClass.getdriver();
	public static WebDriverWait wait;
	String loginURL=configReader.getLoginPage();
	boolean isRequired;
	
	
	//Locators
	
	//@FindBy (xpath="//*[@id='id_username']")static WebElement user;
	@FindBy (xpath="//input[@id='id_username']")static WebElement user;
	@FindBy (xpath="//*[@id='id_password']")static WebElement pwd;
	@FindBy (xpath="//*[@value='Login']")WebElement login_button;
	@FindBy (xpath="//div[@class='alert alert-primary']")WebElement alert;
	@FindBy (xpath="//a[@href='/register']")WebElement register;
	@FindBy (xpath="//a[@href='/logout']")WebElement signout;
	
	
	//Constructor
	
	
	public loginPage() {
        
		
		PageFactory.initElements(driver, this);
	}

	public void login_page() {

		driver.get(loginURL);

	}
	
	public Boolean Login(String username, String password) {
   
		waitForElementToappear(user);
		
		user.clear();
		
		user.sendKeys(username);
		pwd.clear();
		pwd.sendKeys(password);

		// To check empty fields , we need to check "required" field is on an attribute
		if (username.isBlank()) {
			JavascriptExecutor js_user = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", user);
			return isRequired;
		} 
		else if (password.isBlank()) {
			JavascriptExecutor js_password = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_password.executeScript("return arguments[0].required;", pwd);
			return isRequired;

		}
		return isRequired;
	}
	
	// input fields empty -click login
		public void login_button() {

			login_button.click();

		}

		// login for excel sheet data
		public String click_login() {

			login_button.click();
			String msg = alert.getText();
			return msg;
		}

		public void register_link() {

			register.click();
		}

		public String register_page() {

			String Title = driver.getTitle();
			return Title;
		}

		public void signout() {
			
			signout.click();
		}

	}

