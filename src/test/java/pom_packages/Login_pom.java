package pom_packages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_class.TDD_Base;

public class Login_pom extends TDD_Base {
	
	@FindBy(name="username")WebElement Uname;
	@FindBy(name="password")WebElement password;
	@FindBy(css="[type=submit]")WebElement Login;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")WebElement forgot;
	
	public Login_pom() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void username(String name) { Uname.sendKeys(name);}
	public void password(String name) {password.sendKeys(name);}
	public void login() {Login.click();}
	public void forgot(String name) {forgot.click();}
	
	public String verify() {
		return driver.getTitle();
		
	}

}
