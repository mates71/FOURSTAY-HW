package com.fourstay.step_definitions;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.UserAccountPage;
import com.fourstay.utilities.BrowserUtilities;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class STAYTEST_3 {
	WebDriver driver=Driver.getInstance();
	HomePage homepage=new HomePage();
	UserAccountPage userAccountPage=new UserAccountPage();
	String name, lastName;
	
	
	@Given("^the user is on the FourStay sign up dialog$")
	public void the_user_is_on_the_FourStay_sign_up_dialog() throws Throwable {
		driver.get(ConfigurationReader.getProperty("url"));
		homepage.signUp.click();
		
	}

	@Given("^the user enters enter first name \"([^\"]*)\" and last name \"([^\"]*)\"$")
	public void the_user_enters_enter_first_name_and_last_name(String nameFromFeature, String lastNameFromFeature) throws Throwable {
		homepage.FirstName.sendKeys(nameFromFeature);
		homepage.LastName.sendKeys(lastNameFromFeature);
		name=nameFromFeature;
		lastName=lastNameFromFeature;
	}

	@Given("^the user enters any unregistered email and password$")
	public void the_user_enters_any_unregistered_email_and_password() throws Throwable {
		
		homepage.signUpEmail.sendKeys(randomEmail());
		homepage.signUpPassword.sendKeys("password123");
		System.out.println(randomEmail());
		
	}

	@Given("^click on the Sign up button$")
	public void click_on_the_Sign_up_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		homepage.signupBTN.click();
	}

	@When("^the user goes the account details page$")
	public void the_user_goes_the_account_details_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		BrowserUtilities.waitForPageLoad();
		Thread.sleep(2000);
		userAccountPage.message.isDisplayed();
	}

	@Then("^first name \"([^\"]*)\" and last name \"([^\"]*)\" should be displayed in the right fields$")
	public void first_name_and_last_name_should_be_displayed_in_the_right_fields(String arg1, String arg2) throws Throwable {
		String fullName=name+" "+lastName;
		Assert.assertEquals(fullName, userAccountPage.nameValue.getText());
	    // Write code here that turns the phrase above into concrete actions
	}
	
	public static String randomEmail(){
		String myEmail=LocalDateTime.now().toString().replaceAll("-", "").replaceAll(":", "").replaceAll("\\.", "");
		return myEmail+"jhonSmith@gmail.com";
		

		
		
		
		
	}

}
