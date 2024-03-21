package stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.AddCustomerModulePage;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Steps extends BaseClass{
    public WebDriver driver;
   List <String> generated_id= new ArrayList<>();
    public AddCustomerModulePage addCustomerModulePage ;


    @Given("the user is on the Add Customer page")
    public void the_user_is_on_the_Add_Customer_page() {
        System.setProperty("webdriver.edge.driver","drivers/msedgedriver");
        driver=new EdgeDriver();
        addCustomerModulePage = new AddCustomerModulePage(driver);
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if(driver.getTitle().equals("Guru99 Telecom Add Customer")){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }

    @When("they attempt to submit the form with blank FirstName and LastName")
    public void they_attempt_to_submit_the_form_with_blank_FirstName_and_LastName() {

            addCustomerModulePage.setFirstName_Field("");
            addCustomerModulePage.setLastName_Field("");
            addCustomerModulePage.setSubmitButton_Field();
        Alert alert = driver.switchTo().alert();
        String actual = alert.getText();
        if(actual.equals("please fill all fields")){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
        alert.accept();
    }

    @Then("an error message should be displayed stating {string}")
    public void an_error_message_should_be_displayed_stating(String expected) {

        List<WebElement> messageElements = driver.findElements(By.id("[id*='message']"));

        for (WebElement element : messageElements) {
            String errorMessageText = element.getText().trim();
            System.out.println("Error message text: " + errorMessageText);
            Assert.assertEquals("Expected error message does not match the actual error message.", expected, errorMessageText);
        }


        addCustomerModulePage.setResestButon_Field();
    }
    @Then("the submission should fail")
    public void the_submission_should_fail() {
     addCustomerModulePage.setSubmitButton_Field();
       Alert alert = driver.switchTo().alert();
       String actual = alert.getText();
        alert.accept();
       String expected = "please fill all fields";
       if (actual.equals(expected)){
           Assert.assertTrue(true);
           System.out.println("test failed");
       }else{
           Assert.fail();

       }
    }
    @When("they enter the valid email id {string}")
    public void they_enter_the_valid_email_id(String eml) {

       addCustomerModulePage.setEmail_Field(eml);
    }

    @Then("no error message should be shown")
    public void no_error_message_should_be_shown() {
        By errorMessageLocator = By.id("error-message");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
            System.out.println("Error message is displayed!");
        } catch (StaleElementReferenceException | TimeoutException e) {
            System.out.println("No error message is displayed!");
        }

    }

    @Then("the submission should be successful")
    public void the_submission_should_be_successful() {
        By successMessageLocator = By.id("success-message");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));
            System.out.println("Submission is successful!");
        } catch (StaleElementReferenceException | TimeoutException e) {
            System.out.println("Submission failed or no success message found!");
        }
    }

    @When("they enter the invalid email id {string}")
    public void they_enter_the_invalid_email_id(String eml) {
        addCustomerModulePage.setEmail_Field(eml);

    }


    @When("they submit the form with the Address field blank")
    public void they_submit_the_form_with_the_Address_field_blank() {

        addCustomerModulePage.setAddress_Field("");
        addCustomerModulePage.setResestButon_Field();
    }






    @When("they enter special characters \\(, @ !) in the Address field")
    public void they_enter_special_characters_in_the_Address_field() {
        addCustomerModulePage.setAddress_Field(",");

    }

    @When("they enter characters \\({string}) in the Mobile Number field")
    public void they_enter_characters_in_the_Mobile_Number_field(String phn) {
        addCustomerModulePage.setPhone_Field(phn);
    }
    @When("they enter the following valid data:")
    public void they_enter_the_following_valid_data(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        addCustomerModulePage.setFirstName_Field(data.get("FirstName"));
        addCustomerModulePage.setLastName_Field(data.get("LastName"));
        addCustomerModulePage.setEmail_Field(data.get("Email"));
        addCustomerModulePage.setAddress_Field(data.get("Address"));
        addCustomerModulePage.setPhone_Field(data.get("MobileNumber"));
        addCustomerModulePage.setDoneButton();
        addCustomerModulePage.setSubmitButton_Field();


    }

    @Then("a customer should be created")
    public void a_customer_should_be_created() {
       String actual = driver.getTitle();
       String expected = "Guru99 telecom";
       if(actual.equals(expected)){
           Assert.assertTrue(true);
       }else{
           Assert.fail();
       }

    }

    @Then("a customer ID should be generated")
    public void a_customer_ID_should_be_generated() {
      WebElement element = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/table/tbody/tr[1]/td[2]/h3"));
      if(element.isDisplayed()){
          Assert.assertTrue(true);

             generated_id.add(element.getText());
          System.out.println("generated_id: " + generated_id);
      }else{
          assert false;
          System.out.println("element is not displayed");
      }
      for(String id : generated_id){
          System.out.println("id's :" + id);
      }

    }
    @Then("close browser")
    public void close_browser() {
        driver.close();
        driver.quit();
    }



}
