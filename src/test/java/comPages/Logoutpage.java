package comPages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Logoutpage {
	WebDriver driver;
	private By Logout=By.xpath("//span[@class='mat-button-wrapper' and text()='Logout']");
	public Logoutpage(WebDriver driver) {
		this.driver=driver;
	}
	public void click_logout() {
		WebElement logout=driver.findElement(Logout);
		logout.click();
	}
	
	public void navigate_driver_back() {
		String currentUrl = driver.getCurrentUrl();
		driver.navigate().back();
		String endurl = driver.getCurrentUrl();
		System.out.println("beforeurl:"+currentUrl+"  Afterurl:"+endurl);
	}
	public void navigate_url(String string) {
		driver.navigate().to(string);
	}public String get_current_url() {
		String url=driver.getCurrentUrl();
		return url;
	}
	public void find_error_while_navigating() {
		try {
			driver.navigate().back();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("msge:"+e.getMessage());
		}
	}
	public void find_alert_msg() {
		 
	            try {
	                Alert alert = driver.switchTo().alert();

	                String alertMessage = alert.getText();
	                System.out.println("Alert message: " + alertMessage);
	                alert.accept();

	            } catch (NoAlertPresentException e) {
	                System.out.println("No alert is present on the page.");
	            }

	       
	}
}
