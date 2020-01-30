package com.FreeCRM.Base_Class;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.FreeCRM.Util_Classes.Test_Util_Class;

public class Base_Class 
{
	public static Properties config_prop; 
	public static WebDriver driver; 
	static final String log4j_config = "F:\\Selenium\\FreeCRM_Automation\\src\\main\\resources\\com\\FreeCRM\\Resources\\log4j.properties";
	Logger log = Logger.getLogger(Base_Class.class);
	public Base_Class() throws IOException
	{
		config_prop = new Properties();
		FileInputStream input_stream = new FileInputStream(new File("F:\\Selenium\\FreeCRM_Automation\\src\\main\\java\\com\\FreeCRM\\Config_Files\\config.properties"));
		config_prop.load(input_stream);
	}

	public void initialize_Browser()
	{
		PropertyConfigurator.configure(log4j_config);
		String Browser_Name = config_prop.getProperty("Browser");
		log.info("Browser Name : - "+Browser_Name);

		if (Browser_Name.equals("chrome")) 
		{	
			System.setProperty("webdriver.chrome.driver" , "F:\\Selenium\\FreeCRM_Automation\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Chrome Browser Opened");
		}
		else if (Browser_Name.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver" , "F:\\Selenium\\FreeCRM_Automation\\Drivers\\chromedriver.exe");
			driver = new FirefoxDriver();	
			log.info("Firefox Browser Opened");
		}
		else if(Browser_Name.equals("interner Explorer")) 
		{
			System.setProperty("webdriver.ie.driver" , "F:\\Selenium\\FreeCRM_Automation\\Drivers\\chromedriver.exe");
			driver = new InternetExplorerDriver();
			log.info("Internet Explorer Browser Opened");
		}
		else
		{
			log.info("No Browser Found to Execute the Scripts");
		}
		log.info("Deleting the All Cookies");
		driver.manage().deleteAllCookies();
		log.info("Maximizing the Window of the Browser");
		driver.manage().window().maximize();
		log.info("Page load Timeout");
		driver.manage().timeouts().pageLoadTimeout(Test_Util_Class.Page_Load_Timeout, TimeUnit.SECONDS);
		log.info("Implicit wait");
		driver.manage().timeouts().implicitlyWait(Test_Util_Class.Implicit_Timeout, TimeUnit.SECONDS);
		String Url_Application = config_prop.getProperty("Appication_URL");
		log.info("URL of the Application : - "+Url_Application);
		driver.get(Url_Application);
		log.info("Opening the URL in the Browser");
	}	
	public void quit_browser()
	{
		log.info("Closing the Opened Browser");
		driver.quit();	
	}
}
