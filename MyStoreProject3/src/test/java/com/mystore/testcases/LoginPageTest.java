package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass{
	
	IndexPage indexpage = new IndexPage();
	LoginPage loginpage = new LoginPage();
	HomePage homepage = new HomePage();
	
	@Test(dataProvider="credentials", dataProviderClass=DataProviders.class, groups= {"Sanity","Smoke"})
	public void verifyLoginPage(String username, String password)
	{
		Log.startTestCase("verifyLoginPage");
		loginpage = indexpage.clickOnSignin();
		Log.info("Clicked on Signin");
		homepage = loginpage.login(username, password);
		Log.info("Verifying user is on home page");
		String homeUrl = prop.getProperty("homeurl");
		String currentUrl = homepage.validateCurrentUrl();
		Assert.assertEquals(currentUrl, homeUrl);
		Log.info("User Logged in");
		Log.endTestCase("verifyLoginPage");
	}

}
