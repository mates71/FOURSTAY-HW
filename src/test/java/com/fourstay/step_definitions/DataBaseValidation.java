package com.fourstay.step_definitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.fourstay.pages.GeneralAccountPage;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.UserAccountPage;
import com.fourstay.utilities.DBUtilIty;
import com.fourstay.utilities.DBUtilIty.DBType;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DataBaseValidation {

	WebDriver driver = Driver.getInstance();
	HomePage homePage = new HomePage();
	UserAccountPage userAccountPage = new UserAccountPage();
	GeneralAccountPage generalAccountPage = new GeneralAccountPage();
	String actualName, expectedFirstName;
	String actualLastName, expectedLasName;
	String actualEmail, expectedEmail, capturedEmail;
	String actualPhoneNumber, expectedPhoneNumber;

	@When("^I am entering \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_am_entering_and(String emailFromExam, String passwordPromExam) throws Throwable {

		Thread.sleep(2000);
		homePage.email.sendKeys(emailFromExam);
		// sking@testmail.com---- orgiginal
		// sking----- feature file
		capturedEmail = emailFromExam.replace("testmail.com", "");
		homePage.password.sendKeys(passwordPromExam);

	}

	@When("^I click login button$")
	public void i_click_login_button() throws Throwable {
		Thread.sleep(2000);
		homePage.loginBtn.click();

	}

	@When("^I click edit profile$")
	public void i_click_edit_profile() throws Throwable {
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.moveToElement(userAccountPage.picture).perform();
		//userAccountPage.picture.click();
		Thread.sleep(3000);
		userAccountPage.editProfile.click();

	}

	@When("^I capture first name,last name,email,phone number$")
	public void i_capture_first_name_last_name_email_phone_number() throws Throwable {

		actualName = generalAccountPage.accountFirstN.getAttribute("value");
		actualLastName = generalAccountPage.accountLastN.getAttribute("value");
		actualEmail = generalAccountPage.accountEmail.getAttribute("value");
		actualPhoneNumber = generalAccountPage.accountPhone.getAttribute("value");
		System.out.println(actualName);

		System.out.println("first Name " + actualName + "\n" + "Last Name " +
		 actualLastName + "\n" + "Email " + "\n"+actualEmail+
		 "actualPhoneNumber " + "\n" + actualPhoneNumber);

	}

	@When("^I connect database and capture first name,last name,email,phone number$")
	public void i_connect_database_and_capture_first_name_last_name_email_phone_number() throws Throwable {
	
		String query = "select first_name,last_name,phone_number,lower(email) from employees";
		DBUtilIty.establishConnection(DBType.MYSQL);
		List<String[]> databaseValue = DBUtilIty.runSQLQuery(query);
		DBUtilIty.closeConnections();

		for (int i = 0; i < databaseValue.size(); i++) {

			if (databaseValue.get(i)[3].equals(capturedEmail)) {

				expectedFirstName = databaseValue.get(i)[0];
				expectedLasName = databaseValue.get(i)[1];
				expectedEmail = databaseValue.get(i)[2];
				expectedPhoneNumber = databaseValue.get(i)[3].replace(".", "");
				 System.out.println(expectedEmail);
			}
		}
	}

	@Then("^verify the info from UI and Database are the same$")
	public void verify_the_info_from_UI_and_Database_are_the_same() throws Throwable {

		Assert.assertEquals(actualName, expectedFirstName);
		Assert.assertEquals(actualLastName, expectedLasName);
		Assert.assertEquals(actualEmail, expectedEmail);
		Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber);
		
	}

}
