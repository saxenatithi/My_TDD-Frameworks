package test_class;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base_class.TDD_Base;
import pom_packages.Login_pom;
import testdata_parameterization.ExcelData_driven;

public class Login_test extends TDD_Base{
	Login_pom pom;
	
	public Login_test() {
		super();
	}
	
	@BeforeMethod
	public void initsetup(){
		initial(); snaps("Login_test");
		pom=new Login_pom();
		}

	@Test(priority = 1)
	public void verify() {
		String check=pom.verify();
		System.out.println(check);
		Assert.assertEquals(check, "OrangeHRM");
		}
	
	@DataProvider
	public Object[][] Data(){
		Object result[][]=ExcelData_driven.viewdata("Sheet1");
		return result;
	}
	
	@Test(priority = 2, dataProvider="Data")
	public void username(String username, String password) throws InterruptedException {
		pom.username(username);
		pom.password(password);
		Thread.sleep(5000);
		//pom.login();
		}
	
	@AfterMethod 
	public void close() { driver.close(); }
		 

}
