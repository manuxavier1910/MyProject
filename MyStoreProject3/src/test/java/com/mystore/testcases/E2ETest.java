package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummary;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class E2ETest extends BaseClass{
	
	IndexPage indexpage = new IndexPage();
	SearchResultPage searchresultpage = new SearchResultPage();
	AddToCartPage addtocartpage = new AddToCartPage();
	OrderSummary ordersummary = new OrderSummary();
	OrderPage orderpage = new OrderPage();
	LoginPage loginpage = new LoginPage();
	HomePage homepage = new HomePage();
	AddressPage addresspage = new AddressPage();
	ShippingPage shippingpage = new ShippingPage();
	PaymentPage paymentpage = new PaymentPage();
	OrderConfirmationPage orderconfirmationpage = new OrderConfirmationPage();
	
	@Test(groups= "Regression")
	public void e2etest() throws InterruptedException
	{
		String product1 = prop.getProperty("product1");
		searchresultpage = indexpage.searchProduct(product1);
		addtocartpage = searchresultpage.clickOnProduct();
		String quantity = prop.getProperty("quantity");
		Assert.assertTrue(addtocartpage.enterQuantity(quantity));
		String size = prop.getProperty("size");
		Assert.assertTrue(addtocartpage.selectSize(size));
		addtocartpage.clickAddToCart();
		Thread.sleep(1000);
		orderpage = addtocartpage.clickOnCheckout();
		Thread.sleep(1000);
		loginpage = orderpage.clickOnCheckout();
		Thread.sleep(5000);
		addresspage = loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(8000);
		shippingpage = addresspage.clickOnCheckout();
		Thread.sleep(1000);
		shippingpage.clickOnCheckBox();
		Thread.sleep(1000);
		paymentpage = shippingpage.clickOnCheckout();
		Thread.sleep(1000);
		ordersummary = paymentpage.clickOnPaymentByBank();
		Thread.sleep(1000);
		orderconfirmationpage = ordersummary.clickOnConfirmOrder();
		Thread.sleep(1000);
		String actual = orderconfirmationpage.validateMessage();
		System.out.println("Actual message: "+actual);
		String expected = "Your order on My Store is complete.";
		System.out.println("Expected message: "+expected);
		Assert.assertEquals(actual, expected);
	}

}
