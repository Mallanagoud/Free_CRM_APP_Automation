package com.FreeCRM.Page_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Story;

public class FreeCRM_Page 
{
	WebDriver driver ;
	public FreeCRM_Page(WebDriver W_driver) 
	{
		driver = W_driver;
		PageFactory.initElements(W_driver, this);
	}
	@FindBy(xpath = "//h1[text() = 'Free CRM Software in the Cloud']")
	@CacheLookup
	WebElement text_freeCrem_page ;

	@FindBy(xpath = "//span[text() = ' sign up']")
	@CacheLookup
	WebElement sign_up_link ;

	@Story("Verifing text in FreeCRM page ")
	public String verify_text() 
	{
		return text_freeCrem_page.getText();
	}

	@Story("Verifing Sign_Up link in FreeCRM page ")
	public String sign_up_link() 
	{
		return sign_up_link.getText();
	}
	
	@Story("Verifing Title of FreeCRM page ")
	public String title_of_the_page() 
	{
		return driver.getTitle();
	}
	
	@Story("Verifing URL of FreeCRM page ")
	public String url_of_the_page() 
	{
		return driver.getCurrentUrl();
	}
}