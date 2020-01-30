package com.FreeCRM.Test_Classes;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.FreeCRM.Base_Class.Base_Class;
import com.FreeCRM.Page_Classes.FreeCRM_Page;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class FreeCRM_Page_Test extends Base_Class
{
	Logger log = Logger.getLogger(FreeCRM_Page_Test.class);
	FreeCRM_Page freecrm_page ;

	public FreeCRM_Page_Test() throws IOException
	{
		super();
	}
	@BeforeTest
	public void setup()
	{
		initialize_Browser();
		log.info("Calling the Browser from the Base class");
		freecrm_page = new FreeCRM_Page(driver);
	}

	@Test(priority = 1, description = "Verifying the Link & Text in the FreeCRM Page")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case 1:- Verifying the Link & Text in the FreeCRM Page")
	@Story("Story Name 1 : - To check link & Text in a Page")
	public void freeCRM_test_text()
	{
		log.info("Verifying the Link & Text in the FreeCRM Page");
		String text_page = freecrm_page.verify_text();

		log.info("Validating the Text in the Page: - "+text_page);
		if (text_page.equalsIgnoreCase("Free CRM Software in the Cloud"))
		{
			Assert.assertTrue(true);
			log.info("Test case passed");
		}
		else 
		{
			Assert.assertTrue(false);
			log.info("Test case failed");
		}
	}

	@Test(priority = 2, description = "Verifying the Sign up link in the Page")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case 2:- Verifying the Sign up link in the Page")
	@Story("Story Name 2 : - To check Sign up link in a Page")
	public void freeCrm_Signup_link() 
	{
		log.info("Verifying the Sign up link in the Page");
		String sign_up_text = freecrm_page.sign_up_link();

		log.info("Text in the Signup link: - "+sign_up_text);
		if (sign_up_text.equalsIgnoreCase("SIGN UP"))
		{
			Assert.assertTrue(true);
			log.info("Test case passed");
		}
		else 
		{
			Assert.assertTrue(false);
			log.info("Test case failed");
		}
	}

	@Test(priority = 3, description = "Getting & Verifying Title of the Page")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case 3:- Getting & Verifying Title of the Page")
	@Story("Story Name 3 : - To Verifying the Getting Title of a Page")
	public void freeCrm_getTitle() 
	{
		log.info("Getting & Verifying the Getting Title in the Page");
		String  Title_Page = freecrm_page.title_of_the_page();

		log.info("Title of the Page Current Page :-"+Title_Page);
		if (Title_Page.equalsIgnoreCase("Free CRM #1 cloud software for any business large or small"))
		{
			Assert.assertTrue(true);
			log.info("Test case passed");
		}
		else 
		{
			Assert.assertTrue(false);
			log.info("Test case failed");
		}
	}

	@Test(priority = 4, description = "Getting & Verifying the current URL of the Page")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case 4:- Getting & Verifying the current URL of the Page")
	@Story("Story Name 4 : - To Verifying the current URL of a Page")
	public void freeCrm_test_currentURL() 
	{
		log.info("Getting & Verifying the current URL in the Page");
		String URL_Page = freecrm_page.url_of_the_page();
		log.info("URL of the Current Page : - "+URL_Page);

		if (URL_Page.equalsIgnoreCase("https://freecrm.co.in/"))
		{
			Assert.assertTrue(true);
			log.info("Test case passed");
		}
		else 
		{
			Assert.assertTrue(false);
			log.info("Test case failed");
		}
	}

	@AfterTest
	public void teardown()
	{
		quit_browser();
	}
}