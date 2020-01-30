package com.FreeCRM.Page_Classes;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.FreeCRM.Base_Class.Base_Class;

public class Login_Page extends Base_Class
{
	public Login_Page() throws IOException 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	@CacheLookup
	WebElement login_link ;

	@FindBy(name = "email")
	@CacheLookup
	WebElement username ;

	@FindBy(name = "password")
	@CacheLookup
	WebElement Password ;

	@FindBy(xpath = "//div[@class = 'ui fluid large blue submit button']")
	@CacheLookup
	WebElement login_button;
	
	public Home_page Valid_login(String email , String password) throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
		//login_link.click();
	 	username.sendKeys(email);
	 	Password .sendKeys(password);
	 	login_button.click();
		return new Home_page();
	}
}
