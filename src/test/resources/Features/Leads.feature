@Regression1
Feature: Test Lead features

Background:
Given user should on login page
When user enters valid credentials and press login button

@smoke
Scenario: Create lead with mandatory fields
Given user should be create lead page
When user enter lastname and company name and click on save button
Then lead should be created successfully
And user need to click on logout
And close the browser


