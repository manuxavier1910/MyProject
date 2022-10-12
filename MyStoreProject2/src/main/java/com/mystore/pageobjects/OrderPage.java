package com.mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath="//span[@id='product_price_1_3_0']")
	WebElement unitprice;
	
	@FindBy(xpath="//span[@id='total_price']")
	WebElement totalprice;
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement proceedtocheckout;
	
	public OrderPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice()
	{
		String up = unitprice.getText();
		String uprice = up.replaceAll("[^a-zA-Z0-9]", "");
		double finalunitprice = Double.parseDouble(uprice);
		return finalunitprice/100;
//		return 16.51;
	}
	
	public double getTotalPrice()
	{
		String tp = totalprice.getText();
		String tprice = tp.replaceAll("[^a-zA-Z0-9]", "");
		double finaltotalprice = Double.parseDouble(tprice);
		return finaltotalprice/100;
//		return 49.53;
	}
	
	public LoginPage clickOnCheckout()
	{
		action.click(getDriver(), proceedtocheckout);
		return new LoginPage();
	}
	
	

}
