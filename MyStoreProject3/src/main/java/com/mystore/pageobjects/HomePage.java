package com.mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath="//a[@title='Orders']")
	WebElement history;
	
	By history2 = By.xpath("//a[@title='Orders']");
		
	@FindBy(xpath="//a[@title='My wishlists']")
	WebElement wishlist;
	
	By wishlist2 = By.xpath("//a[@title='My wishlists']");
		
	@FindBy(xpath = "//span[text()='Maby Mathew']")
	WebElement user;
		
	public HomePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateWishList()
	{
		return action.isDisplayed(getDriver(), wishlist);
	}
	
	public boolean validateWishList2()
	{
		return action.isDisplayed2(getDriver(), wishlist2);
	}
	
	public boolean validateHistory()
	{
		return action.isDisplayed(getDriver(), history);
	}
	
	public boolean validateHistory2()
	{
		return action.isDisplayed2(getDriver(), history2);
	}
	
	public String validateCurrentUrl()
	{
		String url = getDriver().getCurrentUrl();
		return url;
	}
	
	public boolean validateUser()
	{
		return action.isDisplayed(getDriver(), user);
	}

}
