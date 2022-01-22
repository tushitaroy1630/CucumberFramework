@Regression
Feature: Test Login features

Background:
Given user should on login page 

@smoke
Scenario: valid login
When user enters valid credentials and press login button
Then user should landed on homepage
And logut button should be appear
And close the browser


Scenario: Invalid login
When user enters invalid credentials and press login button
Then error message should appear
And close the browser

@datadriven
Scenario Outline: Invalid login with multiple dataset
When user enters invalid userid as "<userid>" and invalid password as "<password>"  and press login button
Then error message should appear
And close the browser
Examples:
|userid | password|
|admin1 | 12345  |
|admin2 | 123456  |
|admin3 | 123457  |





