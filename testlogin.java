package com.qait.automation.methodbasehristesting;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testlogin {
	WebDriver chrome;
	login loginform;
	timesheet ts;
	String usernameid="txtUserName";
	String userpasswordid="txtPassword";
	@BeforeClass
	public void open_hris()
	{
		chrome = new ChromeDriver();
		loginform=new login(chrome);
		ts=new timesheet(chrome);
		loginform.openhris();
	}
	
	
	@Test
	public void login_with_incorrect_credentials()
	{
		loginform.loginmethod(usernameid,userpasswordid,"dasdsa", "dsada");
		Assert.assertTrue(loginform.gettext(loginform.getelement(".alert-error","css")).contains("Invalid Login"));
		//assert.assertTrue(loginform.gettext(loginform.getelement(".alert-error","css")).contains("Invalid Login"));
	}

	
	@Test(dependsOnMethods= {"login_with_incorrect_credentials"})
	public void login_with_no_password()
	{
		loginform.loginmethod(usernameid,userpasswordid,"Nikhilsinghal", "");
		Assert.assertTrue(loginform.getattri(loginform.getelement(userpasswordid,"id"),"style").contains("red"));
	}
	
	
	@Test(dependsOnMethods= {"login_with_no_password"})
	public void login_with_correct_pasword()
	{
		loginform.loginmethod(usernameid,userpasswordid,"Nikhilsinghal","Nikhil@321#");
		
		Assert.assertTrue(ts.gettext(ts.getelement("m-0","class")).contains("Timesheet"));
		
		
	}
}
