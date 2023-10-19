package base;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
public class init {
	
	public WebDriver driver;
	public Properties prop;
	

   public WebDriver BrowserIntialization(String environment ) throws IOException {
	
	
	   prop = new Properties();
	   String filepath  =System.getProperty("user.dir");
		FileInputStream file = new FileInputStream(filepath+"\\Resourses\\"+environment+".properties");
		prop.load(file);
	   
	   
	String Browser;
    Browser	=prop.getProperty("browser");
    if(Browser==null) {
     Browser=prop.getProperty("Browser");
        }
    
    if(Browser.equalsIgnoreCase("edge")) {
    	 driver = new 	EdgeDriver();

    }else if (Browser.equalsIgnoreCase("firefox")) {
    	driver = new 	FirefoxDriver();
    }else {
    	driver = new 	ChromeDriver();
    }
    
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	return driver;
}

public String ScreenShot(WebDriver driver,String testcasename) throws IOException {
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String path =System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
	FileHandler.copy(src, new File(path));
	return path;
}

}
