package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement loginbutton;
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement reg_email;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement createaccountbutton;
	
	public LoginPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String username, String passcode)
	{
		action.type(email, username);
		action.type(password, passcode);
		action.click(getDriver(), loginbutton);
		return new HomePage();
	}
	
	public AddressPage login1(String username, String passcode)
	{
		action.type(email, username);
		action.type(password, passcode);
		action.click(getDriver(), loginbutton);
		return new AddressPage();
	}
	
	public AccountCreationPage register(String newuser)
	{
		action.type(reg_email, newuser);
		action.click(getDriver(), createaccountbutton);
		return new AccountCreationPage();
	}
	

}
