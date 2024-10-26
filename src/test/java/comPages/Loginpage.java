package comPages;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import comUtils.DriverFactory;
import comUtils.configReader;
import io.cucumber.java.Before;

public class Loginpage {
	WebDriver driver;
	Dashpage dashobj=new Dashpage(driver);
	private By logo=By.xpath("//img[@class='images']");
	private By app_name=By.xpath("//p[text()='Please login to LMS application']");
	private By user=By.xpath("//div[@class='mat-form-field-infix ng-tns-c78-0']");
	private By user_name=By.cssSelector("#username");
	private By pwd=By.xpath("//div[@class='mat-form-field-infix ng-tns-c78-1']");
	private By password=By.cssSelector("#password");
	private By Login_btn=By.xpath("//span[text()='Login']");
	private By no_texts=By.cssSelector(".cdk-text-field-autofill-monitored");
	private By error_msg=By.cssSelector("#errormessage");
	private DriverFactory driverFactory;
	private configReader configReader;
	Properties prop;
    
	
public Loginpage(WebDriver driver) {
	this.driver=driver;
}

public void launchBrowser() {
	configReader = new configReader();
	prop = configReader.init_prop();
	String browserName = prop.getProperty("browser");
	driverFactory = new DriverFactory();
	driver = driverFactory.init_driver(browserName);
	
}

public int num_List_Text() {
	List<WebElement>textboxes=driver.findElements(no_texts);
	System.out.println(textboxes.size());
	return textboxes.size();
}
public String get_title() {
	return driver.getTitle();
}
public boolean dis_logo() {
	WebElement Logo=driver.findElement(logo);
	System.out.println("This is innerhtml:"+Logo.getText());
	return Logo.isDisplayed();	
}
public String dis_appName() {
	WebElement appName=driver.findElement(app_name);
	
	return appName.getText();
}
public boolean dis_user() {
	WebElement Userwithstar=driver.findElement(user);
	return Userwithstar.isDisplayed();
}public boolean dis_pwd() {
	WebElement pwdwithstar=driver.findElement(pwd);
	return pwdwithstar.isDisplayed();
}public void Enter_username_password(String u_name,String pwd) {
	WebElement Username=driver.findElement(user_name);
	WebElement Password=driver.findElement(password);
	Username.sendKeys(u_name);
	Password.sendKeys(pwd);
	
}
public void clcik_login() {
	driver.findElement(Login_btn).click();
}
public boolean dis_login_btn() {
	WebElement Login_button=driver.findElement(Login_btn);
	return Login_button.isDisplayed();
	
}
public void textLocation() {
	WebElement login=driver.findElement(Login_btn);
	Point locatn=login.getLocation();
	System.out.println(locatn);
}
public void text_alignment_Loginbtn() {
	WebElement element=driver.findElement(Login_btn);
	// Update with the correct selector
	dashobj.textAlign_withWebElement(element);
	
}
    
public String color_of_Admin() {
	
	WebElement element=driver.findElement(user);
	String script = "return window.getComputedStyle(arguments[0]).getPropertyValue('color');";

    // Execute the JavaScript and get the 'color' property value
    JavascriptExecutor js = (JavascriptExecutor) driver;
    String color = (String) js.executeScript(script, element);

    // Print the 'color' property value
    System.out.println("Element Color: " + color);
    String colorName = getColorNameFromRGBA(color);
    System.out.println("Element Color Name: " + colorName);
    return colorName;
}
public String color_of_password() {
	
	WebElement element=driver.findElement(pwd);
	String script = "return window.getComputedStyle(arguments[0]).getPropertyValue('color');";

    // Execute the JavaScript and get the 'color' property value
    JavascriptExecutor js = (JavascriptExecutor) driver;
    String color = (String) js.executeScript(script, element);

    // Print the 'color' property value
    System.out.println("Element Color: " + color);
    String colorName = getColorNameFromRGBA(color);
    System.out.println("Element Color Name: " + colorName);
    return colorName;
}
private static String getColorNameFromRGBA(String rgba) {
    Map<String, String> colorMap = createColorMap();

    // Look up the color name in the map
    return colorMap.getOrDefault(rgba, "Unknown Color");
}
private static Map<String, String> createColorMap() {
    Map<String, String> colorMap = new HashMap<>();
    colorMap.put("rgba(0, 0, 0, 0.87)", "gray");
    colorMap.put("#000000", "Black");
    colorMap.put("#FFFFFF", "White");
    colorMap.put("#FF0000", "Red");
    colorMap.put("#00FF00", "Lime");
    colorMap.put("#0000FF", "Blue");
    colorMap.put("#FFFF00", "Yellow");
    colorMap.put("#FFA500", "Orange");
    colorMap.put("#A52A2A", "Brown");
    colorMap.put("#800080", "Purple");
    colorMap.put("#008080", "Teal");
    // Adding gray color
    
    return colorMap;
}
public String error_message() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	WebElement errorMessage=driver.findElement(error_msg);
	String Err_Msg=errorMessage.getText();
	return Err_Msg;
}
public void EnterThroughKeyboardnLogin(String uname,String passwd) {
	Actions action=new Actions(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	WebElement Username=driver.findElement(user_name);
	WebElement Password=driver.findElement(password);
	WebElement login_btn=driver.findElement(Login_btn);
	System.out.println(uname+"  "+passwd);
	action.moveToElement(Username).click();
	action.moveToElement(Username).sendKeys(uname).perform();
	action.moveToElement(Password).sendKeys(Keys.TAB);
	action.moveToElement(Password).sendKeys(passwd).perform();
	action.moveToElement(login_btn).sendKeys(Keys.ENTER).perform();
}
public void ClickThroughMouse(String uname,String passwd) {
	Actions action=new Actions(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	WebElement Username=driver.findElement(user_name);
	WebElement Password=driver.findElement(password);
	WebElement login_btn=driver.findElement(Login_btn);
	action.moveToElement(Username).click();
	action.moveToElement(Username).sendKeys(uname).perform();
	action.moveToElement(Password).click();
	action.moveToElement(Password).sendKeys(passwd).perform();
	System.out.println(uname+"  "+passwd);
	action.moveToElement(login_btn).click().perform();
}
public void teardown() {
	driver.quit();
}
}
