package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EnvironmentManager{
public static WebDriver driver;
 public Properties prop;
 public String methodToCall;
public EnvironmentManager env;
 public EnvironmentManager(String methodtoChoice , WebDriver driver) throws IOException {
	 driver = this.driver;
	 methodToCall=methodtoChoice;
	
	 
 }
 public void DevEnvironment() throws IOException {
		prop = new Properties();
		   
	    String filepath = System.getProperty("user.dir")+"\\Resourses\\dev.properties";
	    FileInputStream file = new FileInputStream(filepath);
	    prop.load(file);
	   

	    System.out.println("m1");
	    }

	public void TestEnvironment() throws IOException {
		prop = new Properties();
		   
	    String filepath = System.getProperty("user.dir")+"\\Resourses\\prod.properties";
	    FileInputStream file = new FileInputStream(filepath);
	    prop.load(file);
	    

	    System.out.println("m2");
	}
	public void ProdEnvironment() throws IOException {
		prop = new Properties();
		   
	    String filepath = System.getProperty("user.dir")+"\\Resourses\\test.properties";
	    FileInputStream file = new FileInputStream(filepath);
	    prop.load(file);

	    System.out.println("m3");
	}

 public void callMethod() throws IOException {
	 switch (methodToCall) {
	 case "DevEnvironment" :
		 DevEnvironment();
		 break;
	 case "TestEnvironment":
		 TestEnvironment();
		 break;
	 case "ProdEnvironment":
		 ProdEnvironment();
		 break;
		 default :
			 System.out.println("parameters class is not working");
		break;
	 }
 }
public static void main(String[] args) throws IOException {
	
	
	
	EnvironmentManager myInstance = new EnvironmentManager("DevEnvironment", driver);
	
	myInstance.	m();
//String[] methodNames = {"DevEnvironment","TestEnvironment","ProdEnvironment"};
//	
//	for(String methodName :methodNames) {
//		try {
//			Method method = EnvironmentManager.class.getMethod(methodName);
//			method.invoke(myInstance);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//

}
public  init m() throws IOException {
	 String [] methodsToCall = {"DevEnvironment","TestEnvironment","ProdEnvironment"};
		
		for(String method:methodsToCall ) {
			EnvironmentManager obj = new EnvironmentManager(method, driver);
			obj.callMethod();
		}
		return new init();
}
}



