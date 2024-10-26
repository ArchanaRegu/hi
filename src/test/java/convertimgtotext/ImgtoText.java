package convertimgtotext;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.asprise.ocr.Ocr;
import com.google.common.io.Files;

import comUtils.DriverFactory;
import comUtils.configReader;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ImgtoText {
	WebDriver driver;
	private DriverFactory driverFactory;
	private configReader configReader;
	Properties prop;
	@BeforeMethod
	public void lunchchrome() {
		configReader = new configReader();
		prop = configReader.init_prop();
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
	}
	public class OCRWithSelenium {
		  public void main(String[] args) throws IOException, TesseractException {

		        // Initialize the WebDriver
		        WebDriver driver = new ChromeDriver();

		        try {
		            // Navigate to the webpage
		            driver.get("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com");

		            // Locate the image or element that contains the text you want to extract
		            WebElement imageElement = driver.findElement(By.xpath("//img[@class='images']"));

		            // Capture the screenshot of the element
		            File screenshot = imageElement.getScreenshotAs(OutputType.FILE);

		            // Define the path where the screenshot will be saved
		            File screenshotLocation = new File("screenshot.png");

		            // Use FileUtils to copy the screenshot to the target location
		            FileUtils.copyFile(screenshot, screenshotLocation);

		            // Initialize Tesseract instance
		            Tesseract tesseract = new Tesseract();
		            tesseract.setDatapath("/path/to/tessdata"); // Set the path to your tessdata folder

		            // Perform OCR on the saved screenshot
		            String extractedText = tesseract.doOCR(screenshotLocation);

		            // Print the extracted text
		            System.out.println("Extracted Text: " + extractedText);

		            // Verify if the extracted text matches the expected text
		            String expectedText = "Your expected text here";
		            if (extractedText.contains(expectedText)) {
		                System.out.println("Text verification passed.");
		            } else {
		                System.out.println("Text verification failed.");
		            }

		        } finally {
		            // Close the browser
		            driver.quit();
		        }
	    }
}}