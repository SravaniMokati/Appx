package ObjectRepository;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInEmail {
	private WebDriver driver;
	private static Logger logger=LogManager.getLogger(SignInEmail.class);
	 @FindBy (id="ap_email")
	   private WebElement EmailOrPhonenumber;
	    
	  @FindBy (id="continue")
	     private WebElement btncontinue;
	  
	  public SignInEmail(WebDriver driver) { //driver.
	        this.driver=driver;
	        PageFactory.initElements(driver,this);
	    }
	  
	  public void getEmailId(String EnterEmailOrPhonenumber) {  
		  logger.info("navigated to"+ driver.getTitle()+ driver.getCurrentUrl());
		  
		  EmailOrPhonenumber.sendKeys(EnterEmailOrPhonenumber);
	  }
	  
	  public Password getContinue() {
		  btncontinue.click();
		return new Password(driver);
		
	  }
	 

}
