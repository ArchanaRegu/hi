package stepDefinition;

import java.io.IOException;

import org.testng.Assert;

import comPages.Loginpage;
import comUtils.DriverFactory;
import comUtils.ExcelReader;
import io.cucumber.java.en.*;

public class LoginWithBkgrd {
	private ExcelReader excelnew=new ExcelReader();
	private Loginpage loginPage = new Loginpage(DriverFactory.getDriver());
	@Given("Admin is in login Page")
	public void admin_is_in_login_page() {

		String title="LMS";
		Assert.assertEquals(loginPage.get_title(),title);

	}

	@When("Admin enter valid credentials  and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() throws Exception {
		String username=excelnew.getCellData(1, 0);;
		String password=excelnew.getCellData(1, 1);
		loginPage.Enter_username_password(username, password);
		loginPage.clcik_login();
	}
	 @When("Admin enter invalid credentials  and clicks login button")
	 public void admin_with_invalid() {
		 String username=excelnew.getCellData(2, 0);;
			String password=excelnew.getCellData(2, 1);
			System.out.println(username+" "+password);
			loginPage.Enter_username_password(username, password); 
			loginPage.clcik_login();
	 }
	 @Then("Error message please check Adminname\\/password")
	 public void error_message_admin_pwd() {
		 
		String ExpectedMessage="Invalid username and password Please try again";
		try {
		String Actualmsg=loginPage.error_message();
		Assert.assertEquals(ExpectedMessage, Actualmsg);
		
		}catch (Exception e) {
			System.out.println(e.getCause());
			Assert.assertTrue(false);
		}
		
	 }

	@Then("Admin should land on dashboard page \\( centre of the page will be empty , menu bar is present).")
	public void admin_should_land_on_dashboard_page_centre_of_the_page_will_be_empty_menu_bar_is_present() {
	   System.out.println(loginPage.get_title());
	}
	@When("Admin enter value only in password and clicks login button")
	public void only_pwd() {
		String username="";
		String password=excelnew.getCellData(4, 1);
		System.out.println(username+" "+password);
		loginPage.Enter_username_password(username, password);
		loginPage.clcik_login();
	}
	@When("Admin enter value only in Adminname and clicks login button") 
	public void only_adm() {
		String username=excelnew.getCellData(4, 0);
		String password="";
		System.out.println(username+" "+password);
		loginPage.Enter_username_password(username, password);
		loginPage.clcik_login();
	
		}
	@When("Admin enter valid credentials  and clicks login button through keyboard")
	public void enterValidCredentialsUsingKeyboard() {
		String username=excelnew.getCellData(1, 0);
		String password=excelnew.getCellData(1, 1);
		loginPage.EnterThroughKeyboardnLogin(username, password);
		loginPage.clcik_login();
	}
	@Then("Admin should land on dashboard page")
	public void navigated_dassboard() {
		loginPage.get_title();
	}
	@When("Admin enter valid credentials  and clicks login button through mouse")
	public void EnterdataUsingMouse() {
		String username=excelnew.getCellData(1, 0);
		String password=excelnew.getCellData(1, 1);
		loginPage.ClickThroughMouse(username, password);
		loginPage.clcik_login();
	}
}
