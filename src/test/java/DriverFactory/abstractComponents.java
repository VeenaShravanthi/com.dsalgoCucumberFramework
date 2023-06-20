package DriverFactory;


	import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ExcelReader;
import Utilities.configReader;


	public class abstractComponents {

		public static WebDriverWait wait;
		public static WebDriver driver=BaseClass.getdriver();
		String Excelpath = configReader.getexcelfilepath();
		String code;
		String result;


		public abstractComponents() {

			this.wait = wait;

		}

		public void waitForElementToappear(WebElement user) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(user));
		}

		public void ActionClass(WebElement e, String s) {
			Actions a = new Actions(driver);
			a.sendKeys(e, s).build().perform();

		}
		public String getCodefromExcel(String sheetname, int rownumber) throws InvalidFormatException, IOException {
			Utilities.ExcelReader reader = new Utilities.ExcelReader();
			List<Map<String, String>> testdata = reader.getData(Excelpath, sheetname);
			code = testdata.get(rownumber).get("pythonCode");
			result = testdata.get(rownumber).get("Result");
			return code;
		}
		public void enterCode(String code, WebElement element) {

			new Actions(driver).sendKeys(element, code).perform();
		}
		
		public void enterCodePractice(String code, WebElement element) {
			new Actions(driver).keyDown(Keys.COMMAND).sendKeys("a").sendKeys(Keys.DELETE).keyUp(Keys.COMMAND).perform();
			String[] str1 = code.split("\n");
			for (int i = 0; i < str1.length; i++) {
				if (str1[i].equalsIgnoreCase("\\b")) {
					element.sendKeys(Keys.BACK_SPACE);
				} else {
					element.sendKeys(str1[i]);
					element.sendKeys(Keys.RETURN);
				}
			}
		}
			public String getResultfromExcel(String sheetname, int rownumber) throws InvalidFormatException, IOException {
				ExcelReader reader = new ExcelReader();
				List<Map<String, String>> testdata = reader.getData(Excelpath, sheetname);
				result = testdata.get(rownumber).get("Result");
				
				return result;
			}
	}



