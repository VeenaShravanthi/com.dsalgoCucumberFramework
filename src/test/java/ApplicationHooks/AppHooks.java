package ApplicationHooks;

import java.io.ByteArrayInputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import DriverFactory.BaseClass;
import Utilities.configReader;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class AppHooks {

	private static WebDriver driver;
	private static BaseClass driverfactory;
	static Scenario scenario;

	@BeforeAll
	public static void before() throws Throwable {
		// Get browser Type from config file
		// Loggerload.info("Loading Config file");
		configReader.init_prop();
		String browser = configReader.getBrowserType();

		// Initialize driver from driver factory
		driverfactory = new BaseClass();
		driver = driverfactory.init_driver(browser);
		// Loggerload.info("Initializing driver for : "+browser);

	}

//	@Before
//	public void scenario(Scenario scenario) {
//		Loggerload.info("===============================================================================================");
//		Loggerload.info(scenario.getSourceTagNames() +" : "+scenario.getName());
//		Loggerload.info("-----------------------------------------------------------------------------------------------");
//		
//	}
	@AfterStep
	public void afterstep(Scenario scenario) {
		if (scenario.isFailed()) {
			// Loggerload.error("Steps Failed , Taking Screenshot");
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "My screenshot");
			Allure.addAttachment("Myscreenshot",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

		}
	}

	@AfterAll
	public static void after() {
		// Loggerload.info("Closing Driver");
		driverfactory.closeallDriver();
	}
}
