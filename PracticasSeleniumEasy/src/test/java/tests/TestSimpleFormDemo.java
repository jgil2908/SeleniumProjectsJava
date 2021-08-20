package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page_objects.*;

public class TestSimpleFormDemo {
	
	WebDriver driver;
	String message = "Mensaje de prueba";
	Integer a = 15;
	Integer b = 20;
	
	@BeforeEach
	public void beforeScenario() {
		//Declarar el driver y navegar a la página
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Ir a Google
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		//driver.manage().window().maximize();
	}
	
	@Test
	public void SingleImputField() {
		System.out.println("Test SingleImputField");
		//Ejecutar las acciones
		SimpleFormDemoPage simple_form_demo_page = new SimpleFormDemoPage(driver);
		simple_form_demo_page.screenshot("SingleImputField", 0);
		//Introducir el texto y darle al bottón
		simple_form_demo_page.imput_message(message);
		simple_form_demo_page.screenshot("SingleImputField", 1);
		//Obtener el mensaje mostrado
		String message_output = simple_form_demo_page.output_message();
		//Verificamos que el mensaje mostrado es el que hemos introducido
		System.out.println("-- Message_imput: " + message);
		System.out.println("-- Message_output: " + message_output);
		assertEquals(message, message_output);
	}
	
	@Test
	public void TwoImputFields() {
		System.out.println("Test TwoImputFields");
		//Ejecutar las acciones
		SimpleFormDemoPage simple_form_demo_page = new SimpleFormDemoPage(driver);
		simple_form_demo_page.screenshot("TwoImputFields", 0);
		//Introducir los dos valores y darle al bottón
		simple_form_demo_page.imput_values(a.toString(), b.toString());
		simple_form_demo_page.screenshot("TwoImputFields", 1);
		//Obtener el valor mostrado
		String value_output = simple_form_demo_page.output_total();
		//Verificamos que el mensaje mostrado es el que hemos introducido
		System.out.println("-- Values_imput: " + a +", " + b);
		System.out.println("-- Value_output: " + value_output);
		assertEquals(a+b,Integer.parseInt(value_output));
	}
	
	@AfterEach
	public void afterScenario() {
		//Eliminar el driver
		driver.quit();
	}

}
