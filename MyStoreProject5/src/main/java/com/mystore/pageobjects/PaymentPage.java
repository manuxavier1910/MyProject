package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath="//a[@title='Pay by bank wire']")
	WebElement paybybank;
	
	@FindBy(xpath="//a[@title='Pay by check.']")
	WebElement paybycheck;
	
	public PaymentPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummary clickOnPaymentByBank()
	{
		action.click(getDriver(), paybybank);
		return new OrderSummary();
	}
	
	public OrderSummary clickOnPaymentByCheck()
	{
		action.click(getDriver(), paybycheck);
		return new OrderSummary();
	}
	
}
