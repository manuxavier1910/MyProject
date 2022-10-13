package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass{
	
	IndexPage indexpage = new IndexPage();
	LoginPage loginpage = new LoginPage();
	HomePage homepage = new HomePage();
	
	@Test(groups="Smoke")
	public void verifyHomePage()
	{
		loginpage = indexpage.clickOnSignin();
		String userName = prop.getProperty("username");
		String password = prop.getProperty("password");
		homepage = loginpage.login(userName, password);
		Assert.assertTrue(homepage.validateWishList());
		Assert.assertTrue(homepage.validateHistory());
		Assert.assertTrue(homepage.validateUser());
	}
}
