package stepDefinition;

import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cookBean.Cook;
import cookBean.Msg;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class TestClass {
	WebDriver driver;
	private Cook cook;
	private Msg msg;
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Users\\sbigasia\\Desktop\\chromedriver_win32\\chromedriver.exe" );
		
		driver= new ChromeDriver();		
	}
	@Given("^User is on Recipe Class Registration$")
	public void user_is_on_Recipe_Class_Registration() throws Throwable {
		cook=new Cook(driver);
	    driver.get("D:\\Subhanshu\\Spring Boot Sps 3.9\\OnlineCookingSchool2\\HTMl Files\\Recipe_class_registration.html");
	    Thread.sleep(2000);
	}

	@When("^User clicks on hyperlink Download our Recipe class Brochure$")
	public void user_clicks_on_hyperlink_Download_our_Recipe_class_Brochure() throws Throwable {
	    cook.setBrochure();
	    Thread.sleep(2000);
	}

	@Then("^Recipe class brochure should be send to user's registered mail id$")
	public void recipe_class_brochure_should_be_send_to_user_s_registered_mail_id() throws Throwable {
	    
	}

	@Given("^User is on Recipe clas brochure page$")
	public void user_is_on_Recipe_clas_brochure_page() throws Throwable {
		msg=new Msg(driver);
	    driver.get("D:\\Subhanshu\\Spring Boot Sps 3.9\\OnlineCookingSchool2\\HTMl Files\\msg.html");
	    Thread.sleep(2000);
	}

	@When("^User clicks on hyperlink Go Back to Registration$")
	public void user_clicks_on_hyperlink_Go_Back_to_Registration() throws Throwable {
	    msg.setAn();
	    Thread.sleep(2000);
	}

	@Then("^User should be navigated to Recipe_class_registration\\.html page$")
	public void user_should_be_navigated_to_Recipe_class_registration_html_page() throws Throwable {
	    
	}

	@Given("^User is on Recipe_class_registration\\.html$")
	public void user_is_on_Recipe_class_registration_html() throws Throwable {
		cook=new Cook(driver);
		driver.get("D:\\Subhanshu\\Spring Boot Sps 3.9\\OnlineCookingSchool2\\HTMl Files\\Recipe_class_registration.html");
	}

	@When("^User does not enters any data in First Name field$")
	public void user_does_not_enters_any_data_in_First_Name_field() throws Throwable {
	    cook.setFname("");
	    cook.setSubmit();
	    Thread.sleep(5000);
	}

	@Then("^First Name field is invalid$")
	public void first_Name_field_is_invalid() throws Throwable {
	    String expected="First Name must be filled out";
	    String actual=driver.switchTo().alert().getText();
	    Assert.assertEquals(expected, actual);
	    driver.switchTo().alert().accept();
	}

	@When("^User enters null in Last Name field$")
	public void user_enters_null_in_Last_Name_field() throws Throwable {
		cook.setFname("Subhanshu");
		cook.setLname("");
		cook.setSubmit();
		Thread.sleep(2000);
	    
	}

	@Then("^Last Name field is invalid$")
	public void last_Name_field_is_invalid() throws Throwable {
		String expected="Last Name must be filled out";
	    String actual=driver.switchTo().alert().getText();
	    Assert.assertEquals(expected, actual);
	    driver.switchTo().alert().accept();
	    Thread.sleep(2000);
	}

	@When("^User enters some data in Email field$")
	public void user_enters_some_data_in_Email_field() throws Throwable {
		cook.setFname("Subhanshu");
		cook.setLname("Bigasia");
		cook.setEmail("example@gmail.com");
		Thread.sleep(2000);
	    
	}

	@Then("^Email field is Valid$")
	public void email_field_is_Valid() throws Throwable {
	   
	}

	@When("^User enters non numeric value in Mobile field$")
	public void user_enters_non_numeric_value_in_Mobile_field() throws Throwable {
		cook.setFname("Subhanshu");
		cook.setLname("Bigasia");
		cook.setEmail("example@gmail.com");
		cook.setMobile("asdasda");
		cook.setSubmit();
		Thread.sleep(2000);
	}

	@Then("^Mobile field is invalid$")
	public void mobile_field_is_invalid() throws Throwable {
		String expected="Enter numeric value";
	    String actual=driver.switchTo().alert().getText();
	    Assert.assertEquals(expected, actual);
	    driver.switchTo().alert().accept();
	    Thread.sleep(2000);
	   
	}

	@When("^User enters (\\d+) digit numeric character in Mobile field$")
	public void user_enters_digit_numeric_character_in_Mobile_field(int arg1) throws Throwable {
		cook.setFname("Subhanshu");
		cook.setLname("Bigasia");
		cook.setEmail("example@gmail.com");
		cook.setMobile("9856452847");
		cook.setSubmit();
	}

	@Then("^Mobile field is valid$")
	public void mobile_field_is_valid() throws Throwable {
	    
	}

	@When("^User selects Non-Veg from Category of recipes interested dropdown field$")
	public void user_selects_Non_Veg_from_Category_of_recipes_interested_dropdown_field() throws Throwable {
		cook.setFname("Subhanshu");
		cook.setLname("Bigasia");
		cook.setEmail("example@gmail.com");
		cook.setMobile("9856452847");
		cook.setCategory("Non-Veg");
		Thread.sleep(2000);
	}

	@Then("^Non-Veg should be send as value of Category of recipes interested dropdown field$")
	public void non_Veg_should_be_send_as_value_of_Category_of_recipes_interested_dropdown_field() throws Throwable {
	    Assert.assertEquals("Non-Veg",cook.getCategory().getText());
	    Thread.sleep(2000);
	}

	@When("^User selects Mumbai from City dropdown field$")
	public void user_selects_Mumbai_from_City_dropdown_field() throws Throwable {
		cook.setFname("Subhanshu");
		cook.setLname("Bigasia");
		cook.setEmail("example@gmail.com");
		cook.setMobile("9856452847");
		cook.setCategory("Non-Veg");
		cook.setCity("Mumbai");
	    
	}

	@Then("^Mumbai should be send as value of City dropdown field$")
	public void mumbai_should_be_send_as_value_of_City_dropdown_field() throws Throwable {
		Assert.assertEquals("Mumbai",cook.getCity().getText());
	    
	}

	@When("^User selects in house training from Mode of Learning dropdown field$")
	public void user_selects_in_house_training_from_Mode_of_Learning_dropdown_field() throws Throwable {
		cook.setFname("Subhanshu");
		cook.setLname("Bigasia");
		cook.setEmail("example@gmail.com");
		cook.setMobile("9856452847");
		cook.setCategory("Non-Veg");
		cook.setCity("Mumbai");
		cook.setMode("in house training");
	    	}

	@Then("^In house Training should be send as value of Mode of Learning field$")
	public void in_house_Training_should_be_send_as_value_of_Mode_of_Learning_field() throws Throwable {
	    Assert.assertEquals("In house training",cook.getMode().getText());
	}

	@When("^User selects (\\d+) Months from Interested Course duration dropdown field$")
	public void user_selects_Months_from_Interested_Course_duration_dropdown_field(int arg1) throws Throwable {
		cook.setFname("Subhanshu");
		cook.setLname("Bigasia");
		cook.setEmail("example@gmail.com");
		cook.setMobile("9856452847");
		cook.setCategory("Non-Veg");
		cook.setCity("Mumbai");
		cook.setMode("in house training");
		cook.setDuration("6 months");
	}

	@Then("^(\\d+) Months should be send as value of Interested Course duration dropdown field$")
	public void months_should_be_send_as_value_of_Interested_Course_duration_dropdown_field(int arg1) throws Throwable {
	    Assert.assertEquals("6 months",cook.getDuration().getAttribute("value"));
	}

	@When("^User does not enters any data in Your Enquiry field$")
	public void user_does_not_enters_any_data_in_Your_Enquiry_field() throws Throwable {
		cook.setFname("Subhanshu");
		cook.setLname("Bigasia");
		cook.setEmail("example@gmail.com");
		cook.setMobile("9856452847");
		cook.setCategory("Non-Veg");
		cook.setCity("Mumbai");
		cook.setMode("in house training");
		cook.setDuration("6 months");
		cook.setEnquiry("");
		cook.setSubmit();
	}

	@Then("^Your Enquiry field is invalid$")
	public void your_Enquiry_field_is_invalid() throws Throwable {
		String expected="Enquiry details must be filled out";
		String actual=driver.switchTo().alert().getText();
		Assert.assertEquals(expected, actual);
		driver.switchTo().alert().accept();
	    
	}

	@When("^User clicks on Enquire Now$")
	public void user_clicks_on_Enquire_Now() throws Throwable {
		cook.setFname("Subhanshu");
		cook.setLname("Bigasia");
		cook.setEmail("example@gmail.com");
		cook.setMobile("9856452847");
		cook.setCategory("Non-Veg");
		cook.setCity("Mumbai");
		cook.setMode("in house training");
		cook.setDuration("6 months");
		cook.setEnquiry("Hello this is enquiry");
		cook.setSubmit();
	    
	}

	@Then("^Form should be submitted with valid data and message should be displayed$")
	public void form_should_be_submitted_with_valid_data_and_message_should_be_displayed() throws Throwable {
	   cook.setSubmit();
	}


}
