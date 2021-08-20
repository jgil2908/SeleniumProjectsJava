package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page_objects.*;

public class TestSelenium {
	
	WebDriver driver;
	
	@BeforeEach
	public void beforeScenario() {
		//Declarar el driver y navegar a la página
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Ir a Google
		driver.get("https:google.com");
	}
	
	@Test
	public void testA() {
		//Ejecutar las acciones
		GooglePage google_page = new GooglePage(driver);
		//Aceptar cookies
		google_page.accept_cookies();
		//Buscar un texto = wikipedia
		google_page.search_for_something("wikipedia");
		//Verificaremos que estamos en la página de resultados
		assertEquals("wikipedia - Buscar con Google", driver.getTitle());
		//Recuperar la página de resultados
		GoogleSearchResultPage search_page = new GoogleSearchResultPage(driver);
		//Ir al primer resultado de búsqueda
		search_page.click_on_first_result();
		//Comprobar el Título del "artículo bueno" de wikipedia
		WikipediaPage wikipedia_page = new WikipediaPage(driver);
		String articulo_bueno_title = wikipedia_page.getArticuloBuenoTitle();
		assertEquals("Anexo:Discografía de Sepultura", articulo_bueno_title);
	}
	
	@AfterEach
	public void afterScenario() {
		//Eliminar el driver
		driver.quit();
	}

}
