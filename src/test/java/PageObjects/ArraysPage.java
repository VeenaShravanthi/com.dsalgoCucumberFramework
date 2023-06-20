package PageObjects;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.BaseClass;
import DriverFactory.abstractComponents;
import Utilities.configReader;



public class ArraysPage {

		public  WebDriver driver=BaseClass.getdriver();
		abstractComponents ac = new abstractComponents();
		
		String tryEditorURL=configReader.tryEditorURL();
		
		//Homepage
		@FindBy (xpath="//a[@href='data-structures-introduction']")WebElement getstart_datastructures;
		@FindBy (xpath="//a[@href='array']")WebElement getstart_array;
		@FindBy (xpath="//*[@id='navbarCollapse']//a[contains(text(), 'Data Structures')]")WebElement dropdown;
		@FindBy (xpath="//*[@id='navbarCollapse']//a[contains(@href, '/array')]")WebElement dropdown_array;
		
		//ArrayPage
		@FindBy (xpath="//a[@href='arrays-in-python']")WebElement arraysInPythonLink;
		
		@FindBy (xpath="//a[@href='/tryEditor']")WebElement TryHereLink;
		@FindBy (xpath="//*[@id='answer_form']")WebElement answerform;
		@FindBy (xpath="//textarea[@tabindex='0']")WebElement editorInput;
		@FindBy (xpath="//*[@id='answer_form']/button")WebElement runButton;
		@FindBy (xpath="//*[@class='button']")WebElement submitButton;
		@FindBy (id="output")WebElement output; 
		
		public ArraysPage() {

			PageFactory.initElements(driver, this);
		}
		
		public  void dropdown_arrayClick()
		{
			dropdown.click();
			dropdown_array.click();
		}
		
		public void getStartedArray()
		{
			getstart_array.click();

		}
		
		public String ArrayPageTitle()
		{
			String title = driver.getTitle();
			return title;
		}
		
		public void ClickOnArraysInPython()
		{
			arraysInPythonLink.click();
		}
		
		public void clickOnTryhereLink(String btname,String destname)
		{
			TryHereLink.click();
		}
		public void enterPythonCode(String sheetname, int rownumber) throws InvalidFormatException, IOException {
			String code = ac.getCodefromExcel(sheetname, rownumber);
			ac.enterCode(code, editorInput);

	}

		public String getExpectedResult(String sheetname, int rownumber) throws InvalidFormatException, IOException {
			String expectedResult = ac.getResultfromExcel(sheetname, rownumber);
			return expectedResult;
		}
		public String getActualResult() {
			ac.waitForElementToappear(output);
			return output.getText();

		}

		public void navigateTotryEditor() {

			driver.get(tryEditorURL);

		}
		public void clickOnRunButton() {
			runButton.click();

		}

		public String getErrorText() {
			
			String errorMsg = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			return errorMsg;
		}
		public void navigateTo(String pagename) {
			String urlName = configReader.geturl(pagename);
			driver.get(urlName);
		}

			
		}
	

