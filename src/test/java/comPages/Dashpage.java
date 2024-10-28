package comPages;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashpage {
private By dashboard=By.cssSelector(".mat-toolbar");
private By lms=By.xpath("//span[contains(.,'LMS - Learning Management System')]");
private By program=By.xpath("//span[@class='mat-button-wrapper' and text()='Program']");
private By batch=By.xpath("//span[@class='mat-button-wrapper' and text()='Batch']");
private By Clas=By.xpath("//span[@class='mat-button-wrapper' and text()='Class']");
private By Logout=By.xpath("//span[@class='mat-button-wrapper' and text()='Logout']");
private By list_nbars=By.cssSelector("span.mat-button-wrapper");
private WebDriver driver;
public Dashpage(WebDriver driver) {
	this.driver=driver;
}
public boolean disp_Dashbd() {
	WebElement Dash=driver.findElement(dashboard);
	return Dash.isDisplayed();
}
public String lms_spelling() {
	WebElement lms_disp=driver.findElement(lms);
	return lms_disp.getText();
}
public String pro_spelling() {
	WebElement prog=driver.findElement(program);
	return prog.getText();
}public String batch_spelling() {
	WebElement bat=driver.findElement(batch);
	return bat.getText();
	}
public String clas_spelling() {
	WebElement cla=driver.findElement(Clas);
	return cla.getText();
}

public boolean disp_lms() {
	WebElement lms_disp=driver.findElement(lms);
	return lms_disp.isDisplayed();
}
public boolean disp_program() {
	WebElement prog=driver.findElement(program);
	return prog.isDisplayed();
}
public boolean disp_batch() {
	WebElement bat=driver.findElement(batch);
	return bat.isDisplayed();
}
public boolean disp_class() {
	WebElement cla=driver.findElement(Clas);
	return cla.isDisplayed();
}
public boolean click_logout() {
	WebElement logot=driver.findElement(Logout);
	return logot.isDisplayed();
}
public int httpcodestatus() throws Exception, InterruptedException {
	HttpClient client = HttpClient.newHttpClient();

    // Create a HttpRequest with HEAD method
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/"))
        .method("HEAD", HttpRequest.BodyPublishers.noBody()) // Replacing URL usage
        .build();

    // Send the request and receive response
    HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding()); // No body expected

    // Get response code
    int r = response.statusCode();
    System.out.println("Http code: " + r);
    return r;
}
public void text_alignment_lms() {
	WebElement lms_disp=driver.findElement(lms);
	textAlign_withWebElement(lms_disp);
}
public void text_alignment_logout() {
	WebElement logot=driver.findElement(Logout);
	textAlign_withWebElement(logot);
}
public void textAlign_withWebElement(WebElement string) {
     // JavaScript to get the computed 'text-align' property of the element
     String script = "return window.getComputedStyle(arguments[0]).getPropertyValue('text-align');";

     // Execute the JavaScript and get the 'text-align' property value
     JavascriptExecutor js = (JavascriptExecutor) driver;
     String textAlign = (String) js.executeScript(script, string);

     // Print the 'text-align' property value
     System.out.println("Text Alignment: " + textAlign+"  Stringname:"+string.getText());
}public List<String> ListToFind_place() {
	List<String>DashboardNames=new ArrayList<>();
	List<WebElement> topics=driver.findElements(list_nbars);
	for(WebElement Array_name:topics) {
		String arrayName=Array_name.getText();
		DashboardNames.add(arrayName);
	}
	return DashboardNames;
	
}

}
