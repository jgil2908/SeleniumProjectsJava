package test;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestTimvroom {

	WebDriver driver;
	JavascriptExecutor js;
	By answer1_imput = By.id("answer1");
	By name_imput = By.id("name");
	By occupation_select = By.id("occupation");
	By blue_box = By.className("bluebox");
	By answer4_imput = By.id("answer4");
	By click_me_link = By.linkText("click me");
	By red_box = By.id("redbox");
	By answer6_imput = By.id("answer6");
	By answer8_imput = By.id("answer8");
	By wrotebook_radio = By.xpath("//*[@id=\"testform\"]/input[2]");
	By answer10_imput = By.id("answer10");
	By green_box = By.id("greenbox");
	By orange_box = By.id("orangebox");
	By answer11_imput = By.id("answer11");
	By ishere = By.id("ishere");
	By answer13_imput = By.id("answer13");
	By purple_box = By.id("purplebox");
	By answer14_imput = By.id("answer14");
	By click_then_link = By.linkText("click then wait");
	By click_after_link = By.linkText("click after wait");
	By submit_button = By.id("submitbutton");
	By checkresults_button = By.id("checkresults");
	By ok_span = By.xpath("//span[starts-with(@id, 'ok_')]");
	
	@BeforeEach
	public void beforeScenario() {
		//Declarar el driver y navegar a la página
		driver = new ChromeDriver();
		//Ir a timvroom
		driver.get("http://timvroom.com/selenium/playground/");
		//driver.manage().window().maximize();
		js = (JavascriptExecutor) driver;
	}
	
	@Test
	public void pruebaTimvroom() {
		//driver.manage().window().setPosition(new Point(0,answer1_imput_element.getLocation().getY()));
		//1. Agarre el título de la página y coloque el texto del título en el espacio de respuesta n. ° 1
		WebElement answer1_imput_element = driver.findElement(answer1_imput);
		answer1_imput_element.sendKeys(driver.getTitle());		
		this.screenshot("pruebaTimvroom_Tarea1");
		//2. Complete la sección de nombre del formulario para ser Kilgore Trout
		WebElement name_imput_element = driver.findElement(name_imput);
		name_imput_element.sendKeys("Kilgore Trout");	
		this.screenshot("pruebaTimvroom_Tarea2");
		//3. Establecer ocupación en el formulario para Autor de ciencia ficción
		Select occupation_select_element = new Select(driver.findElement(occupation_select));
		occupation_select_element.selectByValue("scifiauthor");
		this.screenshot("pruebaTimvroom_Tarea3");
		//4. Cuente el número de blue_boxes en la página tras el formulario e ingrese en el cuadro de respuesta # 4
		List<WebElement> blue_box_elements = driver.findElements(blue_box);
		Integer blue_box_count = blue_box_elements.size();
		WebElement answer4_imput_element = driver.findElement(answer4_imput);
		answer4_imput_element.sendKeys(blue_box_count.toString());
		this.screenshot("pruebaTimvroom_Tarea4");
		//5. Haga clic en el enlace que dice "haga clic en mí"
		WebElement click_me_link_element = driver.findElement(click_me_link);
		click_me_link_element.click();
		this.screenshot("pruebaTimvroom_Tarea5");
		//6. Busque el recuadro rojo en su página, busque la clase que se le aplica y entre en el recuadro de respuesta n. ° 6
		WebElement red_box_element = driver.findElement(red_box);
		WebElement answer6_imput_element = driver.findElement(answer6_imput);
		answer6_imput_element.sendKeys(red_box_element.getAttribute("class"));
		this.screenshot("pruebaTimvroom_Tarea6");
		//7. Ejecute la función de JavaScript como: ran_this_js_function() desde su secuencia de comandos de Selenium
		js.executeScript("ran_this_js_function()");
		this.screenshot("pruebaTimvroom_Tarea7");
		//8. Ejecute la función de JavaScript como: got_return_from_js_function() de su secuencia de comandos de Selenium, tome el valor devuelto y colóquelo en el espacio de respuesta n. ° 8
		WebElement answer8_imput_element = driver.findElement(answer8_imput);
		String output = js.executeScript("return got_return_from_js_function()").toString();
		answer8_imput_element.sendKeys(output);
		this.screenshot("pruebaTimvroom_Tarea8");
		//9. ¿Marcar el botón de radio en el formulario para el libro escrito? a sí
		WebElement wrotebook_radio_element = driver.findElement(wrotebook_radio);
		wrotebook_radio_element.click();
		this.screenshot("pruebaTimvroom_Tarea9");
		//10. Obtenga el texto del cuadro rojo y colóquelo en el espacio de respuesta n. ° 10
		WebElement answer10_imput_element = driver.findElement(answer10_imput);
		answer10_imput_element.sendKeys(red_box_element.getText());
		this.screenshot("pruebaTimvroom_Tarea10");
		//11. ¿Qué caja está en la parte superior? naranja o verde: coloque el color correcto en el espacio de respuesta n. ° 11
		WebElement green_box_element = driver.findElement(green_box);
		WebElement orange_box_element = driver.findElement(orange_box);
		WebElement answer11_imput_element = driver.findElement(answer11_imput);
		if(green_box_element.getLocation().getY()<orange_box_element.getLocation().getY())
			answer11_imput_element.sendKeys("green");
		else
			answer11_imput_element.sendKeys("orange");
		this.screenshot("pruebaTimvroom_Tarea11");
		//12. Establezca el ancho del navegador en 850 y la altura en 650
		driver.manage().window().setSize(new Dimension(850,650));
		this.screenshot("pruebaTimvroom_Tarea12");
		//13. Escriba en el espacio de respuesta 13 sí o no, dependiendo de si el elemento por id "ishere" está en la página
		List<WebElement> ishere_elements = driver.findElements(ishere);
		WebElement answer13_imput_element = driver.findElement(answer13_imput);
		if (ishere_elements.isEmpty())
			answer13_imput_element.sendKeys("no");
		else
			answer13_imput_element.sendKeys("yes");
		this.screenshot("pruebaTimvroom_Tarea13");
		//14. Escriba en el espacio de respuesta 14 sí o no, dependiendo de si el elemento con la identificación de purplebox es visible
		WebElement purple_box_element = driver.findElement(purple_box);
		WebElement answer14_imput_element = driver.findElement(answer14_imput);
		if (purple_box_element.isDisplayed())
			answer14_imput_element.sendKeys("yes");
		else
			answer14_imput_element.sendKeys("no");
		this.screenshot("pruebaTimvroom_Tarea14");
		//15. Juego de espera: haga clic en el enlace con el texto del enlace de 'haga clic y luego espere', se producirá una espera aleatoria (hasta 10 segundos)
		//y luego se agregará un nuevo enlace con el texto del enlace de 'haga clic después de esperar' - 
		//haga clic en este nuevo enlace dentro de 500 ms de lo que parece pasar esta prueba
		WebElement click_then_link_element = driver.findElement(click_then_link);
		click_then_link_element.click();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.ignoring(NoSuchElementException.class);
		WebElement click_after_link_element = wait.until(new Function<WebDriver, WebElement> () {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(click_after_link);
			}
		});
		click_after_link_element.click(); 
		//this.screenshot("pruebaTimvroom_Tarea15"); -> No se puede hacer porque se cierra el Alert		
		//16. Haga clic en Aceptar en la confirmación después de completar la tarea 15
		WebDriverWait wait1 = new WebDriverWait(driver,10);
		Alert alert = wait1.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		this.screenshot("pruebaTimvroom_Tarea16");
		//17. Haga clic en el botón enviar en el formulario
		WebElement submit_button_element = driver.findElement(submit_button);
		submit_button_element.click();
		this.screenshot("pruebaTimvroom_Tarea17");
		//Comprobar resultados
		WebElement checkresults_button_element = driver.findElement(checkresults_button);
		checkresults_button_element.click();
		js.executeScript("window.scrollTo(0,0)");
		this.screenshot("pruebaTimvroom_CheckResults");	
		this.printResults();
	}
	
	@AfterEach
	public void afterScenario() {
		//Eliminar el driver
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
	
	public void printResults() {
		List<WebElement> ok_span_element = driver.findElements(ok_span);
		System.out.println("RESULTADOS:");
		for(WebElement elemento:ok_span_element) {
			System.out.println(elemento.getAttribute("id")+": "+elemento.getText());
		}
	}
	
}

