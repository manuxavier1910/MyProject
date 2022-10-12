package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummary;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	
	IndexPage indexpage = new IndexPage();
	SearchResultPage searchresultpage = new SearchResultPage();
	AddToCartPage addtocartpage = new AddToCartPage();
	OrderSummary ordersummary = new OrderSummary();
	OrderPage orderpage = new OrderPage();
	LoginPage loginpage = new LoginPage();
	HomePage homepage = new HomePage();
	
	@Test(groups="Regression")
	public void verifyProductPrice() throws InterruptedException
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
		Double unitprice = orderpage.getUnitPrice();
		System.out.println("Unitprice: "+unitprice);
		double totalprice = orderpage.getTotalPrice();
		System.out.println("Totalprice: "+totalprice);
		String shippingcharge = prop.getProperty("shippingcharge");
		int ship = Integer.parseInt(shippingcharge);
		System.out.println("Shipping charge: "+ship);
		int quant = Integer.parseInt(quantity);
		System.out.println("Quantity: "+quant);
		double total = (unitprice*quant)+ship;
		double expectedtotalprice = (unitprice*quant)+ship;
		System.out.println("Expected: "+expectedtotalprice);
		Assert.assertEquals(total, expectedtotalprice);
	}

}
