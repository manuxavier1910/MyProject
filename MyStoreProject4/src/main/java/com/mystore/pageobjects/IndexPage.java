package com.mystore.pageobjects;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	
	Action action = new Action();
	
//	@FindBy(xpath="//a[@class='login']")
//	WebElement signin;
	
	By signin = By.xpath("//a[@class='login']");
		
	By logo = By.xpath("//img[@class='logo img-responsive']");
		
//	@FindBy(xpath="//input[@class='search_query form-control ac_input']")
//	WebElement search;
	
	By search = By.xpath("//input[@class='search_query form-control ac_input']");
	
//	@FindBy(xpath="//button[@class='btn btn-default button-search']")
//	WebElement searchbutton;
	
	By searchbutton = By.xpath("//button[@class='btn btn-default button-search']");
	
	public IndexPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSignin()
	{
		action.implicitWait(getDriver(), 30);
		action.click2(getDriver(), signin);
		action.implicitWait(getDriver(), 30);
		return new LoginPage();
	}
	
	public boolean validateLogo()
	{
		return action.isDisplayed2(getDriver(), logo);
	}
	
	public String getStoreTitle()
	{
		String title = getDriver().getTitle();
		return title;
	}
	
	public SearchResultPage searchProduct(String productName)
	{
		action.type2(search, productName);
		action.click2(getDriver(), searchbutton);
		return new SearchResultPage();
	}
	

}
