package com.FreeCRM.Test_Classes;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.FreeCRM.Base_Class.Base_Class;
import com.FreeCRM.Page_Classes.Home_page;
import com.FreeCRM.Page_Classes.Login_Page;

public class Login_Page_Test extends Base_Class
{
	Logger log = Logger.getLogger(Login_Page_Test.class);
	Login_Page login_page ;
	Home_page home_page ; 

	public Login_Page_Test() throws IOException 
	{
		super();
		login_page = new Login_Page();
	}
 
	@BeforeTest
	public void setup()
	{
		log.info("Opening the Browser");
		initialize_Browser();	
	}

	@Test(priority = 1, description = "Verifing the Title of the Login Page")
	public void verify_title()
	{
		log.info("Verifing the Title of the Login Page");
		String title = driver.getTitle();
		System.out.println("Title of the Login Page :  -"+title);
		Assert.assertEquals("Free CRM #1 cloud software for any business large or small",title);
	}

	@Test(priority = 2 , description = "Login to FreeCRM with Valid username & Password")
	public void login_To_FreeCRM_with_Valid_credentials() throws InterruptedException
	{
		home_page = login_page.Valid_login(config_prop.getProperty("Username"), config_prop.getProperty("Password"));	
		System.out.println("Login is Successful");
	}

	public void teardown()
	{
		quit_browser();	
	}
}