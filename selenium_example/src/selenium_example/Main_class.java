package selenium_example;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class Main_class {
	
	public static void main(String[] args) {

		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		String tituloEsperado = "Selenium - Wikipedia, la enciclopedia libre";
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try {
//PRÁCTICA: Mecanismos de Espera
			//driver.get("file://C:/Users/jgilb/Documents/Cursos OpenWebinars/Selenium con Java para principiantes/index_completo.html");
			
			/*WebElement buttonImplicitWait = driver.findElement(By.id("implicitWaitButton"));
			buttonImplicitWait.click();*/
			
			/*Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofSeconds(2))
					.ignoring(NoSuchElementException.class);
			WebElement buttonImplicitWait = wait.until(new Function<WebDriver, WebElement> () {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.id("implicitWaitButton"));
				}
			});
			buttonImplicitWait.click();*/
			
			/*//Creamos la instancia de WebDriverWait a la que llamaremos para esperar a que el elemento cumpla la condicion que establecemos
			WebDriverWait wait = new WebDriverWait(driver, 10); //Le podemos incluir el podding (cada cuanto mira)
			//Llamamos a la instancia wait y especificamos que esperamos (que al menos en 10 segundos) el elemento esté disponible para hacer click
			WebElement buttonExplicitWait = wait.until(ExpectedConditions.elementToBeClickable(By.id("explicitWaitButton")));
			buttonExplicitWait.click();*/
//PRÁCTICA: Rellenando Formularios 1 (TestBox)
			/*driver.get("https://www.wikipedia.es");
			WebElement searchBox = driver.findElement(By.id("searchInput"));
			WebElement searchButton = driver.findElement(By.id("searchButton"));
			Thread.sleep(2000);
			searchBox.sendKeys("selenium"); //Este métdo permite mandar teclas con Keys.
			Thread.sleep(2000);
			searchButton.click();
			String titulo = driver.getTitle();
			if(titulo.equals(tituloEsperado)) {
				System.out.println("El título coincide");
			} else {
				System.out.println("El título NO coincide");
			}*/
//PRÁCTICA: Rellenando Formularios 2 (TestBox)		
			/*driver.get("file://C:/Users/jgilb/Documents/Cursos OpenWebinars/Selenium con Java para principiantes/index_completo.html");
			WebElement usernameBox = driver.findElement(By.cssSelector("#username"));
			WebElement passwordBox = driver.findElement(By.xpath("//input[@id='password']"));
			WebElement loginButton = driver.findElement(By.cssSelector("button#botonLogin"));
			Thread.sleep(2000);
			usernameBox.sendKeys("usuario");
			passwordBox.sendKeys("password");
			loginButton.click();*/
//PRÁCTICA: Rellenando Formularios 3 (ComboBox)
			/*driver.get("file://C:/Users/jgilb/Documents/Cursos OpenWebinars/Selenium con Java para principiantes/index_completo.html");
			Select comboboxSimple = new Select(driver.findElement(By.id("combobox1")));
			comboboxSimple.selectByIndex(2);
			Thread.sleep(2000);
			Select comboboxMultiple = new Select(driver.findElement(By.id("combobox2")));
			comboboxMultiple.selectByIndex(0);
			comboboxMultiple.selectByValue("pera");
			comboboxMultiple.selectByVisibleText("Plátano");
			Thread.sleep(2000);
			//comboboxSimple.deselectByIndex(2); //Esta operacion da error, no se puede usar cuando es un combobox simple
			comboboxMultiple.deselectByIndex(1);
			WebElement bottonCombobox = driver.findElement(By.id("enviaComboboxes"));
			bottonCombobox.click();*/
//PRÁCTICA: Rellenando Formularios 4 (CheckBox)
			/*driver.get("file://C:/Users/jgilb/Documents/Cursos OpenWebinars/Selenium con Java para principiantes/index_completo.html");
			List<WebElement> listaCheckbox = driver.findElements(By.name("listaCompra"));
			for(WebElement elemento:listaCheckbox) {
				elemento.click();
				System.out.println(elemento.getAttribute("value")+" : "+elemento.isSelected());
				Thread.sleep(1000);
			}
			System.out.println("_--------_");
			listaCheckbox.get(0).click();
			listaCheckbox.get(3).click();
			for(WebElement elemento:listaCheckbox) {
				System.out.println(elemento.getAttribute("value")+" : "+elemento.isSelected());
			}
			WebElement bottonCheckbox = driver.findElement(By.id("enviaCheckboxes"));
			bottonCheckbox.click();*/
//PRÁCTICA: Rellenando Formularios 5 (RadioButton)
			/*driver.get("file://C:/Users/jgilb/Documents/Cursos OpenWebinars/Selenium con Java para principiantes/index_completo.html");
			WebElement aguaButton = driver.findElement(By.xpath("//input[@name='bebida' and @value='agua']"));
			aguaButton.click();
			Thread.sleep(1000);
			WebElement doradaButton = driver.findElement(By.cssSelector("[name^='com'][value$='ada']")); 
			//Expresión Regular para buscar el elemento cuyo name empieza por 'com' y value termina por 'ada'
			doradaButton.click();
			Thread.sleep(1000);
			WebElement bottonRadioButton = driver.findElement(By.id("enviaRadiobutton"));
			bottonRadioButton.click();*/
//PRÁCTICA: Rellenando Formularios 6 (Calendario)
			/*driver.get("file://C:/Users/jgilb/Documents/Cursos OpenWebinars/Selenium con Java para principiantes/index_completo.html");
			Thread.sleep(2000);
			WebElement calendario = driver.findElement(By.name("fecha"));
			//calendario.sendKeys("15121980");
			//calendario.sendKeys(Keys.TAB); //Para cambiar al campo de la hora
			//calendario.sendKeys("1030");
			//Lo mismo que arriba en una llamada
			calendario.sendKeys("15121980"+Keys.TAB+"1030");*/
//PRÁCTICA: Rellenando Formularios 7 (Alerts)
			driver.get("file://C:/Users/jgilb/Documents/Cursos OpenWebinars/Selenium con Java para principiantes/index_completo.html");
			Thread.sleep(2000);
			//ALERT SIMPLE (El Confirm es similar)
			//WebElement buttonAlertSimple = driver.findElement(By.id("buttonAlertSimple"));
			//buttonAlertSimple.click();
			//Thread.sleep(2000);
			//WebDriverWait wait = new WebDriverWait(driver,10);
			//Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			//alert.accept(); //Si intento escribir da un error porque el elemento no es interactuable y si se usa el dimiss funciona como aceptar
			//ALERT PROMPT
			WebElement buttonAlertPrompt = driver.findElement(By.id("buttonAlertPrompt"));
			buttonAlertPrompt.click();
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver,10);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert.sendKeys("Esto es el texto del alert");
			Thread.sleep(2000);
			alert.accept();

			Thread.sleep(5000);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			driver.quit();
		}

	}

}
