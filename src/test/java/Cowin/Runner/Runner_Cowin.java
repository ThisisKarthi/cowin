package Cowin.Runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Base.Cowin.Base_Class_Cowin;
import com.Property.ConfigurationHelper_Cowin;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src\\test\\java\\Cowin\\feature\\vaccine.feature", glue = "Cowin.stepdefinition")

public class Runner_Cowin {
	public static WebDriver driver;

	@BeforeClass
	public static void setUp() throws IOException {
		String browser = ConfigurationHelper_Cowin.getInstance().getBrowser();
		driver = Base_Class_Cowin.browserLaunch(browser);
		Base_Class_Cowin.maximize();
	}

	@AfterClass
	public static void tearDown() {
		driver.close();
	}
}
