package com.qait.automation.methodbasehristesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class timesheet {

	WebDriver browser;
	
	public timesheet(WebDriver driver)
	{
		this.browser=driver;
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
	

}
