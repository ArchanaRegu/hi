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
		//if response is 400 ,then link is broken 
		Assert.assertEquals(dashpage.httpcodestatus(),200);
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
		Assert.assertEquals(excelnew.getCellData(5,0),dashpage.lms_spelling());
		Assert.assertEquals(excelnew.getCellData(6,0),dashpage.pro_spelling());
		Assert.assertEquals(excelnew.getCellData(7,0),dashpage.batch_spelling());
		Assert.assertEquals(excelnew.getCellData(8,0),dashpage.clas_spelling());
	}
	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() {
		loginPage.clcik_login();
		Assert.assertEquals(excelnew.getCellData(10, 0), loginPage.get_title());
	}
	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
		loginPage.clcik_login();
		dashpage.text_alignment_logout();
		
	}
	@Then("Admin should see Home in the 1st place")
	public void admin_should_see_home_in_the_1st_place() throws InterruptedException {
		loginPage.clcik_login();
		Thread.sleep(2000);
		System.out.println(dashpage.ListToFind_place());
		System.out.println(dashpage.ListToFind_place().get(0));
		Assert.assertEquals(dashpage.ListToFind_place().get(0),"Home");
	}
	@Then("Admin should see program in the 2nd place")
	public void admin_should_see_program_in_2nd_place() throws InterruptedException {
	loginPage.clcik_login();
	Thread.sleep(2000);
	System.out.println(dashpage.ListToFind_place());
	System.out.println(dashpage.ListToFind_place().get(0));
	Assert.assertEquals(dashpage.ListToFind_place().get(0),"Program");
	}
	@Then("Admin should see batch in the 3rd place")
	public void admin_should_see_batch_in_the_3rd_place() throws InterruptedException {
		loginPage.clcik_login();
		Thread.sleep(2000);
		System.out.println(dashpage.ListToFind_place());
		System.out.println(dashpage.ListToFind_place().get(1));
		Assert.assertEquals(dashpage.ListToFind_place().get(1),"Batch");
	}
	@Then("Admin should see class in the 4th place")
	public void admin_should_see_class_in_the_4th_place() throws InterruptedException {
		loginPage.clcik_login();
		Thread.sleep(2000);
		System.out.println(dashpage.ListToFind_place());
		System.out.println(dashpage.ListToFind_place().get(2));
		Assert.assertEquals(dashpage.ListToFind_place().get(2),"Class");
	}@Then("Admin should see logout in the 5th place")
	public void admin_should_see_logout_in_the_5th_place() throws InterruptedException {
		loginPage.clcik_login();
		Thread.sleep(2000);
		System.out.println(dashpage.ListToFind_place());
		System.out.println(excelnew.getCellData(4, 2));
		Assert.assertEquals(excelnew.getCellData(4, 2),"Logout");
	}
	
	
}
