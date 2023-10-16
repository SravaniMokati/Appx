package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {
	private WebDriver driver;
	public void actions(WebElement helloiSignin) {
		Actions a= new Actions(driver);
		a.moveToElement( helloiSignin).build().perform();

	}
}
