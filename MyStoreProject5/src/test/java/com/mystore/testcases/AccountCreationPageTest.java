package com.mystore.testcases;

import java.text.SimpleDateFormat;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass{
	
	IndexPage indexpage = new IndexPage();
	LoginPage loginpage = new LoginPage();
	HomePage homepage = new HomePage();
	AccountCreationPage accountcreationpage = new AccountCreationPage();
	
	@Test(groups="Sanity", dataProvider="accountcreation", dataProviderClass=DataProviders.class)
	public void verifyAccountCreationPage(String email, String fname, String lname, String password, String address, String city, String state, String zip, String country, String mobile, String alias)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		String t = timeStamp.replace(".", "");
		loginpage = indexpage.clickOnSignin();
		accountcreationpage = loginpage.register(t+email);
		Assert.assertTrue(accountcreationpage.validateAccountCreatePage());
		accountcreationpage.createAccount(fname,lname,password,address,city,state,zip,country,mobile,alias);
		Assert.assertTrue(homepage.validateWishList2());
		Assert.assertTrue(homepage.validateHistory2());
	}
}
