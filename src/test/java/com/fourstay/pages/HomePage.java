package com.fourstay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class HomePage {
	
	public HomePage(){
		PageFactory.initElements(Driver.getInstance(), this);
	}

	
	@FindBy(css = ".not-login")
	public WebElement loginLink;

	@FindBy(id = "email")
	public WebElement email;

	@FindBy(id = "key")
	public WebElement password;

	@FindBy(id = "btn-login")
	public WebElement loginBtn;

	@FindBy(id = "iLocName")
	public WebElement schoolName;

	@FindBy(id = "rentoutfrom2")
	public WebElement startDate;

	@FindBy(id = "rentoutto2")
	public WebElement endDate;

	@FindBy(id = "search")
	public WebElement search;
	
	
	@FindBy(xpath="//li[@class='btn menu btn-log zl-margin not-login'][2]")
	public WebElement signUp;

	

	//@FindBy(id = "FirstName")
	public WebElement FirstName;

	//@FindBy(id ="LastName")
	public WebElement LastName;
	
	@FindBy(xpath="(//input[@type='Email'])[3]")
	public WebElement signUpEmail;

	@FindBy(xpath="(//input[@type='password'])[2]")
	public WebElement signUpPassword;
	
	@FindBy(id = "btn-signup")
	public WebElement signupBTN;
	
	



}
