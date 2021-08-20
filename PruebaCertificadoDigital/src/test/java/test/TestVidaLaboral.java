package test;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class TestVidaLaboral {

	WebDriver driver;
	ChromeOptions options;
	By accept_cookies_button = By.xpath("//*[@id=\"cookies\"]/div/div/div/button");
	By vidaLaboral_link = By.linkText("Vida laboral e informes");
	By informeVidaLaboral_link = By.linkText("Informe de tu vida laboral");
	By solicitarInforme_button = By.xpath("//*[@id=\"content\"]/div[2]/div[2]/section/div[3]/div/div/div/button[1]");
	By certificadoDigital_button = By.xpath("//*[@id=\"P017_login2\"]/button");
	
	@BeforeEach
	public void beforeScenario() {
		options = new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		driver = new ChromeDriver(options);
		driver.get("https://portal.seg-social.gob.es/wps/portal/importass/importass");
		driver.manage().window().maximize();
		driver.findElement(accept_cookies_button).click();
	}
	
	@Test
	public void descargaVidaLaboral() {
		screenshot("VidaLaboral_0");
		//Pulsar en el link de "Vida laboral e informes"
		WebElement vidaLaboral_link_element = driver.findElement(vidaLaboral_link);
		vidaLaboral_link_element.click();
		screenshot("VidaLaboral_1");
		//Pulsar en el link de "Informe de tu vida laboral"
		WebElement informeVidaLaboral_link_element = driver.findElement(informeVidaLaboral_link);
		informeVidaLaboral_link_element.click();
		screenshot("VidaLaboral_2");
		//Pulsar en el botón "Solicitar informe"
		WebElement solicitarInforme_button_element = driver.findElement(solicitarInforme_button);
		solicitarInforme_button_element.click();
		screenshot("VidaLaboral_3");
		//Pulsar en el botón "Certificado Digital"
		WebElement certificadoDigital_button_element = driver.findElement(certificadoDigital_button);
		certificadoDigital_button_element.click();
		//screenshot("VidaLaboral_4");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterEach
	public void afterScenario() {
		driver.quit();
	}
	
	public void screenshot(String test) {
		try {
			FileOutputStream fileOutput = new FileOutputStream ("C:\\Users\\jgilb\\Pictures\\Evidencias\\"+test+".png");
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
