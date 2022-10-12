package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderSummary;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass{
	
	IndexPage indexpage = new IndexPage();
	SearchResultPage searchresultpage = new SearchResultPage();
	AddToCartPage addtocartpage = new AddToCartPage();
	OrderSummary ordersummary = new OrderSummary();
	
	@Test(groups= {"Regression","Sanity"})
	public void verifyAddToCartPage()
	{
		String product1 = prop.getProperty("product1");
		searchresultpage = indexpage.searchProduct(product1);
		addtocartpage = searchresultpage.clickOnProduct();
		String quantity = prop.getProperty("quantity");
		Assert.assertTrue(addtocartpage.enterQuantity(quantity));
		String size = prop.getProperty("size");
		Assert.assertTrue(addtocartpage.selectSize(size));
		addtocartpage.clickAddToCart();
		Assert.assertTrue(addtocartpage.validateAddToCart());
	}
}
