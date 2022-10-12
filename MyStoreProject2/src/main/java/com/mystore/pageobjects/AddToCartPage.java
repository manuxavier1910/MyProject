package com.mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass{

	Action action = new Action();
	
	@FindBy(xpath="//input[@id='quantity_wanted']")
	WebElement quantity;
	
	@FindBy(xpath="//select[@id='group_1']")
	WebElement size;
	
	@FindBy(xpath="//button[@class='exclusive']")
	WebElement addtocartbutton;
	
	@FindBy(xpath="//*[@id=\\\"layer_cart\\\"]/div[1]/div[1]/h2")
	WebElement success2;
	
	By success = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2");
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	WebElement checkout; 
	
	public AddToCartPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean enterQuantity(String quant)
	{
		return action.type(quantity, quant);
	}
	
	public boolean selectSize(String sizes)
	{
		return action.selectByVisibleText(sizes, size);
	}
	
	public void clickAddToCart()
	{
		action.click(getDriver(), addtocartbutton);
	}
	
	public boolean validateAddToCart()
	{
		action.fluentWait(getDriver(), success2, 50);
		return action.isDisplayed2(getDriver(), success);
	}
	
	public OrderPage clickOnCheckout()
	{
//		action.JSClick(driver, checkout);
//		action.click(driver, checkout);
		action.click1(checkout, "Proceed to checkout");
		return new OrderPage();
	}
}
