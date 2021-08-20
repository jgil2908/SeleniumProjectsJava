package steps;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java8.En;
import page_objects.GooglePage;
import page_objects.GoogleSearchResultPage;
import page_objects.WikipediaPage;

public class StepsGoogleWikipedia implements En{
	
	WebDriver driver;
	
	public StepsGoogleWikipedia() {
		
		Before(() -> {
			//Declarar el driver y navegar a la página
			//driver = new ChromeDriver();
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new ChromeOptions());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Ir a Google
			driver.get("https:google.com");
		});
		
		Given("Nos encontramos en la pagina de google", () -> {
			//Ejecutar las acciones
			GooglePage google_page = new GooglePage(driver);
			//Aceptar cookies
			google_page.accept_cookies();
		});
		
		When("Buscamos wikipedia y entramos en el primer resultado", () -> {
			GooglePage google_page = new GooglePage(driver);
			//Buscar un texto = wikipedia
			google_page.search_for_something("wikipedia");
			//Verificaremos que estamos en la página de resultados
			assertEquals("wikipedia - Buscar con Google", driver.getTitle());
			//Recuperar la página de resultados
			GoogleSearchResultPage search_page = new GoogleSearchResultPage(driver);
			//Ir al primer resultado de búsqueda
			search_page.click_on_first_result();
		});
		
		Then("El titulo del articulo bueno del dia es {string}", (String text) -> {
			//Comprobar el Título del "artículo bueno" de wikipedia
			WikipediaPage wikipedia_page = new WikipediaPage(driver);
			String articulo_bueno_title = wikipedia_page.getArticuloBuenoTitle();
			assertEquals(text, articulo_bueno_title);
		});
		
		After(() -> {
			driver.quit();
		});
	}
}
