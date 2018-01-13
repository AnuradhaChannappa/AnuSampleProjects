@SMOKE
Feature: Testing different requests on the Twitter application


Scenario: Check if the twitter search endpoint works
When I send a GET request to the twitter endpoint,then I must get back a valid status code "200"


Scenario Outline: List all the tweets for hipages
     
     When I search for <noOfTweets> tweets containing <searchTweet>
     Then I verify that the tweets are listed

    Examples: 
      | searchTweet | noOfTweets |    
      | @hipages    |   2        |
      | #hipages    |   2        |
      |  hipges     |   2        |
 
Scenario: Check if the twitter timeline endpoint works
When I send a GET request to the twitter endpoint,then I must get back a valid status code "200"

