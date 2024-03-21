package stepDefinition;

import org.openqa.selenium.WebDriver;
import pageObject.AddCustomerModulePage;

import java.util.HashMap;
import java.util.Map;

public class BaseClass {
   public WebDriver ldriver ;
   AddCustomerModulePage addCustomerModulePage ;
    public void getTitle(){
        ldriver.getTitle();
    }

    public static Map<String, String> getValidCustomerData() {
        Map<String, String> customerData = new HashMap<>();
        customerData.put("FirstName", "Tim");
        customerData.put("LastName", "Rogers");
        customerData.put("Email", "email@gmail.com");
        customerData.put("Address", "101 Park Lane NY");
        customerData.put("MobileNumber", "1234567890");
        customerData.put("BackgroundCheck", "DONE");

        return customerData;
    }
}
