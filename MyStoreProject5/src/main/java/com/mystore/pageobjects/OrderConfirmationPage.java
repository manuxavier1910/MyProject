package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(xpath="//p[@class='cheque-indent']")
	WebElement message;
	
	public OrderConfirmationPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public String validateMessage()
	{
		String mes  = message.getText();
		return mes;
	}

}
