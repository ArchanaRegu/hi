package stepDefinition;

import java.time.Duration;
import java.time.Instant;

import org.testng.Assert;

import comPages.Dashpage;
import comPages.Loginpage;
import comUtils.DriverFactory;
import comUtils.ExcelReader;
import io.cucumber.java.en.*;

public class DashStepDefination {
	private Dashpage dashpage=new Dashpage(DriverFactory.getDriver());
    private Loginpage loginPage = new Loginpage(DriverFactory.getDriver());
	private ExcelReader excelnew=new ExcelReader();
	@When("Admin enter valid credentials and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {
		String username=excelnew.getCellData(1, 0);;
		String password=excelnew.getCellData(1, 1);
		System.out.println(username+" "+password);
		loginPage.Enter_username_password(username, password);
	}

	@Then("Admin should see dashboard")
	public void admin_should_see_dashboard() {
		loginPage.clcik_login();
		Assert.assertTrue(dashpage.disp_Dashbd());
	}
	@Then("Maximum navigation time in milliseconds, defaults to 30 seconds")
	public void navigatn_in_millisec() {
		Instant startTime=Instant.now();
		loginPage.clcik_login();
		Instant endTime=Instant.now();
		 long navigationTime = Duration.between(startTime, endTime).toMillis();
         System.out.println("Navigation Time: " + navigationTime + " milliseconds");
	}
	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) throws InterruptedException, Exception {
		loginPage.clcik_login();
		System.out.println(dashpage.httpcodestatus());
		int requirement=int1;
		Assert.assertEquals(int1,dashpage.httpcodestatus() );
	}
	@Then("Admin should see LMS -Learning management system as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
		loginPage.clcik_login();
		Assert.assertTrue(dashpage.disp_lms());
	}
	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
		loginPage.clcik_login();
		dashpage.text_alignment_lms();
	}
	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_navigation_bar_text() {
		loginPage.clcik_login();
		
	}
	
}
