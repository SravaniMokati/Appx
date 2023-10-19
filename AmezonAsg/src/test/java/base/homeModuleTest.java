package base;

import ObjectRepository.ProductSelection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import ObjectRepository.AddingCart;
import ObjectRepository.HomePage;
import ObjectRepository.Password;
import ObjectRepository.ProductClick;
import ObjectRepository.SignInEmail;
import test.exelMethods;
import test.reporting;
public class homeModuleTest extends init {

WebDriver driver;
Properties prop;
private static Logger logger=LogManager.getLogger(homeModuleTest.class);
@Parameters({"environment"})
@BeforeClass(alwaysRun=true)

public void browser(String environment) throws IOException {
	EnvironmentManager myInstance = new EnvironmentManager(environment,driver);
	myInstance.m();
	driver=BrowserIntialization(environment);
	driver.get("https://www.amazon.in/?tag=msndeskstdin-21&ref=pd_sl_5mvnwh4xd3_b&adgrpid=1315017517456642&hvadid=82188861834005&hvnetw=o&hvqmt=b&hvbmt=bb&hvdev=c&hvlocint=&hvlocphy=157546&hvtargid=kwd-82189475779885:loc-90&hydadcr=5902_2377547");
		logger.info("browser is open");
}
	@Test
	public void ProductSelection() throws IOException {
		logger.info("Strating the E-commerce scenarion test.");
		
		HomePage homepage = new HomePage(driver);
		homepage.PageValidation();
		exelMethods Exel = new exelMethods();
		ArrayList<String> ForExel =Exel.exel("Details", "ProductSelection");
		SignInEmail singinMail=homepage.signlink();
		singinMail.getEmailId(ForExel.get(1));
		Password password=singinMail.getContinue();
		password.getPassword(ForExel.get(2));
		password.ClickSignin();
		homepage.SearchBox(ForExel.get(3));
		ProductSelection productSelection=homepage.SearchSymbol();
		ProductClick productClick=productSelection.ProductSelectionInfo();
		AddingCart addingCart=productClick.Quantity(ForExel.get(4));
		addingCart.AddCartValidation();
		addingCart.GetHelloSignin();
	}
	@AfterTest
	public void tearDown() {
	driver.quit();	
	}
	
}
