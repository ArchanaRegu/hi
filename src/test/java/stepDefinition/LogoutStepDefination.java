package stepDefinition;

import org.testng.Assert;

import comPages.Dashpage;
import comPages.Loginpage;
import comPages.Logoutpage;
import comUtils.DriverFactory;
import comUtils.ExcelReader;
import io.cucumber.java.en.*;

public class LogoutStepDefination {
	private Loginpage loginPage = new Loginpage(DriverFactory.getDriver());
	private Logoutpage logoutpage=new Logoutpage(DriverFactory.getDriver());
	private Dashpage dashpage=new Dashpage(DriverFactory.getDriver());
	private ExcelReader excelnew=new ExcelReader();
	@When("Admin gives the correct LMS portal URL and login with correct credentials.")
	public void admin_gives_the_correct_lms_portal_url_and_login_with_correct_credentials() {
		DriverFactory.getDriver()
		.get("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com");
		String username=excelnew.getCellData(1, 0);
		String password=excelnew.getCellData(1, 1);
		loginPage.Enter_username_password(username, password);
		loginPage.clcik_login();
	}
@Given("Admin is in dashboard page")
public void admin_is_in_dashboard_page() throws InterruptedException {
	Thread.sleep(2000);
    System.out.println(loginPage.get_title());
	System.out.println("after login:"+logoutpage.get_current_url());

}

@When("Admin clicks on the logout in the menu bar")
public void admin_clicks_on_the_logout_in_the_menu_bar() {
	
    logoutpage.click_logout();
}

@Then("Admin should be redirected to login page")
public void admin_should_be_redirected_to_login_page() {
    System.out.println("after logout:"+logoutpage.get_current_url());
}
@Given("Admin is in login page")
public void admin_is_in_login_page() throws InterruptedException {
	Thread.sleep(2000);
	System.out.println(logoutpage.get_current_url());
	
}

@When("Admin clicks  browser back button")
public void admin_clicks_browser_back_button() throws InterruptedException {
	logoutpage.navigate_driver_back();
	Thread.sleep(2000);
	System.out.println(logoutpage.get_current_url());
	
}

@Then("Admin should receive error message")
public void admin_should_receive_error_message() {
	try {
			DriverFactory.getDriver().navigate().back();
			throw new AssertionError("Test failed, Expected exception error");
	}catch (Exception e) {
		System.out.println("Test passed: Expected exception error");
	}
}}