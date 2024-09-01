
@tag
Feature: To validate the beauty and wellness of naptool website

  @tag1
  Scenario: Beauty and wellness of naptool
    Given URL of website
    When I click on shoping categries
    When I find beauty and wellness and click on it
    And I click on a beauty category
    Then I find makeup option and click on it
   

  @tag2
  Scenario Outline: Title of your scenario outline
    Given URL of makeup 
    When User is applying some filters
    And User is add the product in cart 
    Then User is switch back to parent tab
