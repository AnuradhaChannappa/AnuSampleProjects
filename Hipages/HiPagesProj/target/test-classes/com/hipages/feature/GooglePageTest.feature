@SMOKE
Feature: Google home page test scenarios

@validateSearchField
Scenario: Test google search field
Given the user is on Google search page
When the user enters text "hipages"
Then verify the search result

@validateSearchByVoice
Scenario: Test google voice search mouse over
Given the user is on Google search page
When the user mouse over voice search
Then Verify the mouse over text

@validateGoogleSearchButtons
Scenario: Test google serach buttons
Given the user is on Google search page
Then verify google search buttons

@ValidateHeaderFields
Scenario: Test google serach buttons
Given the user is on Google search page
Then verify google header buttons
