package stepDefinition;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import comPages.Loginpage;
import comUtils.DriverFactory;
import comUtils.configReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hooks {
//	private DriverFactory driverFactory;
	public WebDriver driver;
	private Loginpage loginPage = new Loginpage(DriverFactory.getDriver());
//	@After
//	public void Teardown() {
//		loginPage.teardown();
//	}
//	private configReader configReader;
//	Properties prop;
//	@Before(order = 0)
//	public void getProperty() {
//		configReader = new configReader();
//		prop = configReader.init_prop();
//	}
//
//	@Before(order = 1)
//	public void launchBrowser() {
//		String browserName = prop.getProperty("browser");
//		driverFactory = new DriverFactory();
//		driver = driverFactory.init_driver(browserName);
//		
//	}
//	@After
//	public void AfterScenario(Scenario scenario) throws IOException {
//		if(scenario.isFailed()) {
//			byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//			Allure.addAttachment("Failed Screenshot",new ByteArrayInputStream(screenshot));
//		}
//		driver.quit();
//	}
//	@AfterStep
//	public void AddScreenShot(Scenario scenario) throws IOException {
//		if(scenario.isFailed()) {
//			File sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			byte[] fileContent=FileUtils.readFileToByteArray(sourcepath);
//			scenario.attach(fileContent, "image/png", "image");
//		}}
}
