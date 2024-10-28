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
import comUtils.ExcelReader;
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
	private ExcelReader excelnew=new ExcelReader();
	    @Before("@runBeforeHook")
	    public void setUp() {
	    	loginPage.launchBrowser();
	    	DriverFactory.getDriver()
			.get("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com");
			String username=excelnew.getCellData(1, 0);
			String password=excelnew.getCellData(1, 1);
			loginPage.Enter_username_password(username, password);
			loginPage.clcik_login();
	    }
	    @After
		public void AfterScenario(Scenario scenario) throws IOException {
			if(scenario.isFailed()) {
				byte[] screenshot=((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Failed Screenshot",new ByteArrayInputStream(screenshot));
			}
			DriverFactory.getDriver().quit();
		}
		@AfterStep
		public void AddScreenShot(Scenario scenario) throws IOException {
			if(scenario.isFailed()) {
				File sourcepath=((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
				byte[] fileContent=FileUtils.readFileToByteArray(sourcepath);
				scenario.attach(fileContent, "image/png", "image");
			}}
   
}
