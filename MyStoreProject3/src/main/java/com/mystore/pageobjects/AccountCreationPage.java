package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath="//h1[@class='page-heading']")
	WebElement createaccounttext;
	
	@FindBy(xpath="//input[@id='id_gender2']")
	WebElement genderradiobutton;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	WebElement customer_fname;
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	WebElement customer_lname;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement customer_password;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement customer_address;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement customer_city;
	
	@FindBy(xpath="//select[@id='id_state']")
	WebElement customer_state;
	
	@FindBy(xpath="//input[@id='postcode']")
	WebElement customer_zip;
	
	@FindBy(xpath="//select[@id='id_country']")
	WebElement customer_country;
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	WebElement customer_mobile;
	
	@FindBy(xpath="//input[@id='alias']")
	WebElement customer_alias;
	
	@FindBy(xpath="//span[text()='Register']")
	WebElement customer_register;
	
	public AccountCreationPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateAccountCreatePage()
	{
		return action.isDisplayed(getDriver(), createaccounttext);
	}
	
	public HomePage createAccount(String fname, String lname, String pass, String address, String city, String state, String zip, String country, String mob, String alias)
	{
		action.click(getDriver(), genderradiobutton);
		action.type(customer_fname, fname);
		action.type(customer_lname, lname);
		action.type(customer_password, pass);
		action.type(customer_address, address);
		action.type(customer_city, city);
		action.selectByVisibleText(state, customer_state);
		action.type(customer_zip, zip);
		action.selectByVisibleText(country, customer_country);
		action.type(customer_mobile, mob);
		action.type(customer_alias, alias);
		action.click(getDriver(), customer_register);
		return new HomePage();
	}
	
}
