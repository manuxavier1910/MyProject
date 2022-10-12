package com.mystore.testcases;

//import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass{
	
	IndexPage indexpage = new IndexPage();
	
	@Test(groups="Smoke")
	public void verifyIndexPage()
	{
			String result = indexpage.getStoreTitle();
			String storeTitle = prop.getProperty("storetitle");
			Assert.assertEquals(result, storeTitle);
			Assert.assertFalse(indexpage.validateLogo());
	}
}
