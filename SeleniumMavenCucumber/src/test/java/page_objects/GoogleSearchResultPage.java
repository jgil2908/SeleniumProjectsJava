package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchResultPage extends BasePage{
	
	//En el temario est�n las capturas de como hemos llegado a dicho xpatch
	By first_result_url = By.xpath("(//div[@id='search']/descendant::div[@class='g'])[1]/descendant::a[1]");
		
	public GoogleSearchResultPage (WebDriver driver) {
		super(driver);
	}
	
	public void click_on_first_result() {
		this.driver.findElement(first_result_url).click();
	}

}
