$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:features/AddCustomerModule.feature");
formatter.feature({
  "name": "Add Customer Module link https://demo.guru99.com/telecom/addcustomer.php",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "the user is on the Add Customer page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinition.Steps.the_user_is_on_the_Add_Customer_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify that FirstName and LastName cannot be Blank",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    },
    {
      "name": "@Test1"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "they attempt to submit the form with blank FirstName and LastName",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinition.Steps.they_attempt_to_submit_the_form_with_blank_FirstName_and_LastName()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an error message should be displayed stating \"Customer name must not be blank\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.Steps.an_error_message_should_be_displayed_stating(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the submission should fail",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinition.Steps.the_submission_should_fail()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "close browser",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinition.Steps.close_browser()"
});
formatter.result({
  "status": "passed"
});
});