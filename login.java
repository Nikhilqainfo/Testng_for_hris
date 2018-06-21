package com.qait.automation.methodbasehristesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class login {
	WebDriver browser;
	public login(WebDriver driver)
	{
		this.browser=driver;
	}
	
	public void openhris()
	{
		browser.get("https://hris.qainfotech.com/login.php");
	}
	
	
	public WebElement getelement(String val,String method)
	{
		if(method.equals("id"))
		{
		return browser.findElement(By.id(val));
		}
		else if(method.equals("css"))
		{
			return browser.findElement(By.cssSelector(val));
		}
		else if(method.equals("class"))
		{
			
			return browser.findElement(By.className(val));
		}
		return null;
	}
	
	
	public String gettext(WebElement element)
	{
		return element.getText();
	}
	
	
	public String getattri(WebElement element,String Attribute)
	{
		return element.getAttribute(Attribute);
	}
	
	public void loginmethod(String usernameid,String userpassword,String username, String password)
	{
		getelement(usernameid,"id").clear();
		getelement(usernameid,"id").sendKeys(username);
		getelement(userpassword,"id").clear();
		getelement(userpassword,"id").sendKeys(password);
		getelement("txtPassword","id").submit();
	
	}
	
	
}
