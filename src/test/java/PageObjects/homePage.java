package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DriverFactory.BaseClass;
import Utilities.configReader;


public class homePage {
	public static WebDriver driver=BaseClass.getdriver();
	String URL = configReader.getApplicationUrl();
	String homeURL = configReader.getHomePage();

	

	// 1. By Locators: OR

	// GetStarted Page
	private @FindBy(xpath = "//button[@class='btn']") WebElement getstartedBtn;

	// Alert Message
	private @FindBy(xpath = "//div[@class='alert alert-primary']") WebElement alert_msg;

	// Home Page..GetStartedBtn
	private @FindBy(xpath = "//a[@href='data-structures-introduction']")
	WebElement getstart_datastructures;
	private @FindBy(xpath = "//a[@href='array']")
	WebElement getstart_array;
	private @FindBy(xpath = "//a[@href='linked-list']")
	WebElement getstart_linkedlist;
	private @FindBy(xpath = "//a[@href='stack']")
	WebElement getstart_stack;
	private @FindBy(xpath = "//a[@href='queue']")
	WebElement getstart_queue;
	private @FindBy(xpath = "//a[@href='tree']")
	WebElement getstart_tree;
	private @FindBy(xpath = "//a[@href='graph']")
	WebElement getstart_graph;

	// DropDown options

	private @FindBy(xpath = "//a[@href='#']")
	WebElement dropdown;
	private @FindBy(xpath = "//div[@class='dropdown-menu show']")
	WebElement dropdown_array;
	private @FindBy(xpath = "//*[@id='navbarCollapse']//a[2]")
	WebElement dropdown_linkedlist;
	private @FindBy(xpath = "//*[@id='navbarCollapse']//a[3]")
	WebElement dropdown_stack;
	private @FindBy(xpath = "//*[@id='navbarCollapse']//a[4]")
	WebElement dropdown_queue;
	private @FindBy(xpath = "//*[@id='navbarCollapse']//a[5]")
	WebElement dropdown_tree;
	private @FindBy(xpath = "//*[@id='navbarCollapse']//a[6]")
	WebElement dropdown_graph;

	// sigin
	private @FindBy(xpath = "//a[@href='/login']")
	WebElement signin;
	// register
	private @FindBy(xpath = "//a[@href='/register']")
	WebElement register;

	// 2. Constructor of the page class:
	public homePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void dsalgopage() {

		driver.get(URL);

	}

	public void getStartedButton() {

		getstartedBtn.click();

	}

	public String getPageTitle() {

		String title = driver.getTitle();
		return title;

	}

	public String alert() {

		String msg = alert_msg.getText();
		return msg;

	}

	// Home page Elements
	public void homepage() {

		driver.get(homeURL);

	}

	public void getStarted_home(String string) {

		switch (string) {
		case "Datastructures":

			getstart_datastructures.click();
			break;
		case "Arrays":
			getstart_array.click();
			break;
		case "Linkedlist":
			getstart_linkedlist.click();
			break;
		case "Stack":
			getstart_stack.click();
			break;
		case "Queue":
			getstart_queue.click();
			break;
		case "Tree":

			getstart_tree.click();
			break;
		case "Graph":

			getstart_graph.click();
			break;
		}
	}

	// Dropdown
	public void dropdown(String string) {

		dropdown.click();
		switch (string) {
		case "Arrays":

			dropdown_array.click();
			break;
		case "Linkedlist":

			dropdown_linkedlist.click();
			break;
		case "Stack":

			dropdown_stack.click();
			break;
		case "Queue":

			dropdown_queue.click();
			break;
		case "Tree":

			dropdown_tree.click();
			break;
		case "Graph":

			dropdown_graph.click();
			break;
		}

	}

	// Signin
	public void signin_link() {
		signin.click();
	}

	public String login_page() {
		String title = driver.getTitle();
		return title;
	}

	// Register
	public void register_link() {

		register.click();

	}

	public String register_page() {
		String title = driver.getTitle();
		return title;
	}

}
