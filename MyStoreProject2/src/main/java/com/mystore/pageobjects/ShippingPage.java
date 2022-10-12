package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath="//input[@id='cgv']")
	WebElement clickoncheckbox;
	
	@FindBy(xpath="//button[@name='processCarrier']")
	WebElement clickoncheckout;
	
	public ShippingPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickOnCheckBox()
	{
		action.click(getDriver(), clickoncheckbox);
	}
	
	public PaymentPage clickOnCheckout()
	{
		action.click(getDriver(), clickoncheckout);
		return new PaymentPage();
	}

}
