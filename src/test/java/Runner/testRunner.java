package Runner;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"html:target/cucumber.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, // reporting purpose
		
          publish=true,
         monochrome = false, // console output
			
		features = { "src/test/resources/Features" }, // location of feature files
		tags="",// tags from feature file,
		glue = { "StepDefinition", "ApplicationHooks" }// location of step definition files
		
		) // tags from feature file

public class testRunner extends AbstractTestNGCucumberTests {
	@DataProvider(parallel = false)
	public Object[][] scenarios() {		
		return super.scenarios();
	}

}
