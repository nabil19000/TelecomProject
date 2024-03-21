Feature: Add Customer Module link https://demo.guru99.com/telecom/addcustomer.php
  Background:
    Given the user is on the Add Customer page
  @smoke @Test1 @regression
  Scenario: Verify that FirstName and LastName cannot be Blank
    When they attempt to submit the form with blank FirstName and LastName
    Then an error message should be displayed stating "Customer name must not be blank"
    And the submission should fail
    And close browser
@Test2 @regression
  Scenario: Enter a valid email id
    When they enter the valid email id "email@gmail.com"
    Then no error message should be shown
    And the submission should be successful
    And close browser
@Test3 @regression @smoke
  Scenario: Enter an INVALID valid email id
    When they enter the invalid email id "test.test.com"
    Then an error message should be displayed stating "Email-ID is not valid"
    And the submission should fail
    And close browser
  @Test4 @regression
  Scenario: Leave Address Field Blank
    When they submit the form with the Address field blank
    Then an error message should be displayed stating "Address Field must not be blank"
    And the submission should fail
    And close browser
  @Test5 @regression @sanity
  Scenario: Enter Special Characters in Address Field
    When they enter special characters (, @ !) in the Address field
    Then an error message should be displayed stating "Special characters are not allowed"
    And the submission should fail
    And close browser
 @Test6@regression
  Scenario: Enter characters in Mobile Number Field
    When they enter characters ("aaaaaaaaaaaa") in the Mobile Number field
    Then an error message should be displayed stating "Characters are not allowed"
    And the submission should fail
    And close browser
@Test7@regression@smoke
  Scenario Outline: Create a customer with Valid Data and Background Check DONE
    When they enter the following valid data:
      | FirstName        | <FirstName>       |
      | LastName         | <LastName>        |
      | Email            | <Email>           |
      | Address          | <Address>         |
      | MobileNumber     | <MobileNumber>    |
      | Background Check | <BackgroundCheck> |

    Then a customer should be created
    And a customer ID should be generated
    And the submission should be successful
    And close browser
  Examples:
    | FirstName | LastName | Email               | Address       | MobileNumber | BackgroundCheck |
    | Nabil     | algeria  | email2024@gmail.com | 3451 ranch tx | 546376487    | DONE            |
    | bob       | steve    | steve23@gmail.com   | 34 ranch tx   | 546355555    | PENDING         |

