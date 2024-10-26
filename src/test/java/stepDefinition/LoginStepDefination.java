package stepDefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.testng.Assert;

import comPages.Loginpage;
import comUtils.DriverFactory;
import comUtils.ExcelReader;
import io.cucumber.java.en.*;

public class LoginStepDefination {
	private Loginpage loginPage = new Loginpage(DriverFactory.getDriver());
	private ExcelReader excelnew=new ExcelReader();
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
		loginPage.launchBrowser();
	}
	@When("Admin gives the correct LMS portal URL")
	public void Admin_with_correctURL() {
		
			DriverFactory.getDriver()
					.get("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com");
           
		}
	@Then("Admin should land on the login page")
	public void Admin_should_land_loginpage() {
		String Expected_title="LMS";
		String actual_title=loginPage.get_title();
		Assert.assertEquals(Expected_title, actual_title);
		
	}
	@When("User enters username and password and clicks Login_btn.")
	public void user_enters_username_and_password_and_clicks_login_btn() throws IOException {
		String username=excelnew.getCellData(1, 0);;
		String password=excelnew.getCellData(1, 1);
		loginPage.Enter_username_password(username, password);
		loginPage.clcik_login();
	}
	
	@When("Admin gives the invalid LMS portal URL")
	public void admingives_the_invalid_lms_portal_url() throws MalformedURLException, IOException {
		try {
		DriverFactory.getDriver()
		.get("https://lms-frontend-haathon-oct24-173fe394c05.hrouapp.com");
		}
		catch (Exception e) {
			e.getCause();
		}
	}

	@Then("Admin should recieve {int} page not found error")
	public void admin_should_recieve_page_not_found_error(Integer int1) throws IOException, InterruptedException  {
		HttpClient client = HttpClient.newHttpClient();

        // Create a HttpRequest with HEAD method
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com"))
            .method("HEAD", HttpRequest.BodyPublishers.noBody()) // Replacing URL usage
            .build();

        // Send the request and receive response
        HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding()); // No body expected

        // Get response code
        int r = response.statusCode();
        System.out.println("Http code: " + r);
		
		}
	@Then("Admin should see logo on the left  side")
	public void logo_display() {
		Assert.assertTrue(loginPage.dis_logo());
	}
	@Then("Admin should see {string}")
	public void admin_should_see(String string) {
		Assert.assertEquals(string, loginPage.dis_appName());
	}
	@Then("Admin should see {int} text field")
	public void admin_should_see_text_field(Integer int1) {
		Assert.assertEquals(loginPage.num_List_Text(),int1);
	}
	@Then("Admin should see  LMS - Learning Management System")
	public void admin_should_see_lms_learning_management_system() {
		System.out.println("should implement at the end");
	}
	@Then("Admin should {string} in the first text field")
	public void admin_should_in_the_first_text_field(String string) {
		Assert.assertTrue(loginPage.dis_user());
	}
	@Then("Admin should {string} in the second text field")
	public void password_display() {
		Assert.assertTrue(loginPage.dis_pwd());
	}
	@Then("Admin should see login button")
	public void login_button() {
		Assert.assertTrue(loginPage.dis_login_btn());
	}
   @Then("Admin should see login button on the centre of the page")
   public void login_at_center() {
	  loginPage.text_alignment_Loginbtn(); 
   }
   @Then("Admin should see Admin in gray color")
   public void ADmin_graycolor() {
	   String actual=loginPage.color_of_Admin();
	   Assert.assertEquals(actual, "gray");
   }
   @Then("Admin should see password in gray color")
   public void password_graycolor() {
	   String actual=loginPage.color_of_password();
	   Assert.assertEquals(actual, "gray");
   }
}
