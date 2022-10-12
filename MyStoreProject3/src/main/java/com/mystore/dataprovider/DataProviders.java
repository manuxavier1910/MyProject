package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

import com.mystore.utility.NewExcelLibrary;

public class DataProviders {
	
	NewExcelLibrary obj = new NewExcelLibrary();
	
	@DataProvider(name = "credentials")
	public Object[][] getCredentials() {
		// Totals rows count
		int rows = obj.getRowCount("Credentials");
		System.out.println(rows);
		// Total Columns
		int column = obj.getColumnCount("Credentials");
		System.out.println(column);
		int actRows = rows - 1;
		System.out.println(actRows);

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Credentials", j, i + 2);
			}
		}
		return data;
	}
	
	@DataProvider(name = "accountcreation")
	public Object[][] getNewAccountData() {
		// Totals rows count
		int rows = obj.getRowCount("AccountCreation");
		System.out.println(rows);
		// Total Columns
		int column = obj.getColumnCount("AccountCreation");
		System.out.println(column);
		int actRows = rows - 1;
		System.out.println(actRows);

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("AccountCreation", j, i + 2);
			}
		}
		return data;
	}

}
