package page_objects;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class BasePage {
	
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitle() {
		return this.driver.getTitle();
	}
	
	public void screenshot(String test, int id) {
		try {
			FileOutputStream fileOutput = new FileOutputStream ("C:\\Users\\jgilb\\Pictures\\Evidencias\\"+test+"_Evidencia"+id+".png");
			BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput);
			bufferedOutput.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			bufferedOutput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
