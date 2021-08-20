package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SimpleFormDemoPage extends BasePage{
	
	By message_imput = By.id("user-message");
	By show_message_button = By.xpath("//*[@id=\"get-input\"]/button");
	By message_output = By.id("display");
	
	By a_imput = By.id("sum1");
	By b_imput = By.id("sum2");
	By get_total_button = By.xpath("//*[@id=\"gettotal\"]/button");
	By displya_value = By.id("displayvalue");
	
	public SimpleFormDemoPage(WebDriver driver) {
		super(driver);		
	}
	
	public void screenshot(String test, int id) {
		super.screenshot(test,id);
	}
	
	public void imput_message(String message) {
		WebElement message_imput_element = this.driver.findElement(message_imput);
		message_imput_element.sendKeys(message);
		WebElement show_message_button_element = this.driver.findElement(show_message_button);
		show_message_button_element.click();
	}
	
	public String output_message () {
		WebElement message_output_element = this.driver.findElement(message_output);
		return message_output_element.getText();
	}
	
	public void imput_values (String a, String b) {
		WebElement imput_a_element = this.driver.findElement(a_imput);
		WebElement imput_b_element = this.driver.findElement(b_imput);
		imput_a_element.sendKeys(a);
		imput_b_element.sendKeys(b);
		WebElement get_total_button_element = this.driver.findElement(get_total_button);
		get_total_button_element.click();
	}
	
	public String output_total () {
		WebElement total_output_element = this.driver.findElement(displya_value);
		return total_output_element.getText();
	}

}
