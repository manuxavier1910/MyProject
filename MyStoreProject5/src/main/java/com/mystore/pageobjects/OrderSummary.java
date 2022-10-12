package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderSummary extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath="//button[@class='button btn btn-default button-medium']")
	WebElement confirmorder;
	
	public OrderSummary()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderConfirmationPage clickOnConfirmOrder()
	{
		action.click(getDriver(), confirmorder);
		return new OrderConfirmationPage();
	}

}
