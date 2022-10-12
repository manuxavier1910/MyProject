package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath="//a[@class='product_img_link']")
	WebElement product1;
	
	public SearchResultPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable()
	{
		return action.isDisplayed(getDriver(), product1);
		
	}
	
	public AddToCartPage clickOnProduct()
	{
		action.click(getDriver(), product1);
		return new AddToCartPage();
	}
	
	

}
