package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddCustomerModulePage {

    WebDriver ldriver ;

    public AddCustomerModulePage(WebDriver rdriver){
        ldriver = rdriver ;
        PageFactory.initElements(ldriver,this);
    }
    @FindBy(xpath = "//*[@id=\"one\"]/div/div[1]/div[1]/h3/a")@CacheLookup
    WebElement AddCustomerLink;
    @FindBy(xpath = "//label[@for='done']")@CacheLookup WebElement DoneButton;
    @FindBy(xpath = "//label[@for='pending']")@CacheLookup WebElement pendingButton;
    @FindBy(xpath = "//input[@id='fname']")@CacheLookup WebElement firstName_Field;
    @FindBy(xpath = "//input[@id='lname']")@CacheLookup WebElement lastName_Field;
    @FindBy(xpath = "//*[@id=\"email\"]")@CacheLookup WebElement email_Field;
    @FindBy(xpath = "//textarea[@id='message']")@CacheLookup WebElement address_Field;
    @FindBy(xpath = "//input[@id='telephoneno']")@CacheLookup WebElement phone_Field;
    @FindBy(xpath = "//input[@name='submit']")@CacheLookup WebElement submitButton_Field;
    @FindBy(xpath = "//input[@value='Reset']")@CacheLookup WebElement resetButon_Field;

    public void setFirstName_Field(String fName) {
        firstName_Field.sendKeys(fName);
    }

    public void setDoneButton() {
        DoneButton.click();
    }
    public void setPendingButton(){
        pendingButton.click();
    }
    public void setLastName_Field(String lName){
        lastName_Field.sendKeys(lName);
    }
    public void setEmail_Field(String email){
        email_Field.sendKeys(email);
    }
    public void setAddress_Field(String address){
        address_Field.sendKeys(address);
    }
    public void setPhone_Field(String phoneNum){
        phone_Field.sendKeys(phoneNum);
    }
    public void setSubmitButton_Field(){
        submitButton_Field.click();
    }
    public void setResestButon_Field(){
        resetButon_Field.click();
    }

}
