@tag
Feature: Validate the Eye care

  @tag1
  Scenario: Navigate the naptool website to the eye care category
    Given The URL of naptool Website
    When  User will click on shoiping category
    And User will click on beauty and wellness 
    And User will click on beauty option
   	Then User will click on Eye care
    
  @tag2
  Scenario Outline: Validate the eyecare category
  	Given The url of Eye care 
  	When The user is applying brand and discout filter
  	And Select the product according to filter
  	And Add to cart the product
  	Then Navigate back to the current tab
