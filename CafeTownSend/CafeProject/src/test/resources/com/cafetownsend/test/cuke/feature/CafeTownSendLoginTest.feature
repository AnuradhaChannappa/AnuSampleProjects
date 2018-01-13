@CafeTownSendFeature
Feature: CafeTownSend feature test scenarios

@unitTest1
Scenario: Test for successful login
Given I go to "Cafe Townsend Login Page"
When I Enter "Luke" as Username
And I Enter "Skywalker" as Password
And I click on "Login" Button
Then I verify the page

@unitTest2
Scenario: Test for Edit and delete Button
Given I go to "Cafe Townsend Login" Page
When I Enter "Luke" as Username
And I Enter "Skywalker" as Password
And I click on "Login" Button
And I select employee "Lilly Potter"
Then I verify the Edit Delete Button

@unitTest3
Scenario: Test create functionality
Given I go to "Cafe Townsend Login" Page
When I Enter "Luke" as Username
And I Enter "Skywalker" as Password
And I click on "Login" Button
And I click on "Create" Button
And I Enter "Harsha" as FirstName
And I Enter "Vardhan" as LastName
And I Enter "2009-11-13" as StartDate
And I Enter "harsha@yahoo.com" as Email
And I click on "Add" Button on Create Page
Then I verify "Harsha Vardhan" Employee

@unitTest4
Scenario: Test Delete functionality on main page
Given I go to "Cafe Townsend Login" Page
When I Enter "Luke" as Username
And I Enter "Skywalker" as Password
And I click on "Login" Button
And I select employee "Harsha Vardhan"
And I click on "Delete" Button
And I click "ok" on Alert 
Then I verify "Harsha Vardhan" Employee
And I click on "logout" Button

@unitTest5
Scenario: Test Edit functionality
Given I go to "Cafe Townsend Login" Page
When I Enter "Luke" as Username
And I Enter "Skywalker" as Password
And I click on "Login" Button
And I select employee "Harsha Vardhan"
And I click on "Edit" Button
Then I verify "Harsha Vardhan" employee details

@unitTest6
Scenario: Test Delete functionality from Edit Page
Given I go to "Cafe Townsend Login" Page
When I Enter "Luke" as Username
And I Enter "Skywalker" as Password
And I click on "Login" Button
And I select employee "Harsha Vardhan"
And I click on "Edit" Button
And I click on "Delete" Button on Edit Page
And I click "ok" on Alert 
Then I verify "Harsha Vardhan" Employee
