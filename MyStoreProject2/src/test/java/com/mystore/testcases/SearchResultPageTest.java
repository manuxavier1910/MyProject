package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass{
	
	IndexPage indexpage = new IndexPage();
	SearchResultPage searchresultpage = new SearchResultPage();
	
	@Test(groups="Smoke")
	public void verifySearchResultPage()
	{
		String product1 = prop.getProperty("product1");
		searchresultpage = indexpage.searchProduct(product1);
		Assert.assertTrue(searchresultpage.isProductAvailable());
		
	}

}
