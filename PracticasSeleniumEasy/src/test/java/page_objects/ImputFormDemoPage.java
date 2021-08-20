package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ImputFormDemoPage extends BasePage{
	
	By firstname_imput = By.name("first_name");
	By lastname_imput = By.name("last_name");
	By email_imput = By.name("email");
	By phone_imput = By.name("phone");
	By address_imput = By.name("address");
	By city_imput = By.name("city");
	By state_select = By.name("state");
	By zipcode_imput = By.name("zip");
	By website_imput = By.name("website");
	By hosting_radiobutton = By.className("col-md-4");
	By projectdescription_textarea = By.name("comment");
	By send_button = By.className("btn btn-default");
	
	public ImputFormDemoPage(WebDriver driver) {
		super(driver);		
	}

}
