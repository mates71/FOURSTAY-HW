package com.fourstay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class UserAccountPage {
	
	public UserAccountPage(){
		PageFactory.initElements(Driver.getInstance(), this);

}
	@FindBy(css =".user-name")
	public WebElement accountHolder;
	
	@FindBy(css=".user-name.ng-binding")
	public WebElement nameValue;
	
	@FindBy(css="h3.row.zrl-margin.headings-with-icon.ng-binding")
	public WebElement message;
	
	@FindBy (css = "li.nav-gravicon .dropdown-toggle")
	public WebElement picture;
	
	@FindBy (linkText = "Edit Profile")
	public WebElement editProfile;


}