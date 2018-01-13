@HealthDirectFeature
Feature: Health Direct home page search feature test scenarios

@SearchValid
Scenario: Test for successful serach
Given the user is on the Health Direct home page
When the user looks up the suggestion for 'asthma'
Then they should see the suggestion 'asthma'

@SearchTextBold
Scenario: Test the serach word to be bold
Given the user is on the Health Direct home page
When the user looks up the suggestion for 'asthma'
Then they should see the suggestions with 'asthma' as bold

@SearchInvalid
Scenario: Test for invalid serach
Given the user is on the Health Direct home page
When the user looks up the suggestion for 'xyz'
Then they should not see any suggestions

@SearchValidAndSelect
Scenario: Test for valid suggestion select
Given the user is on the Health Direct home page
When the user looks up the suggestion for 'asthma'
And they see the suggestion 'asthma'
And they click on 'anti-asthmatic agents' option
Then verify the search result page

@ValidatePlaceholderText
Scenario: Test for placeholder text and tool tip
Given the user is on the Health Direct home page
When the user mouse over the search field
Then verify placeholder and tooltip



