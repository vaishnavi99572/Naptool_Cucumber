
@tag
Feature: Foot Care categosy of Naptool website
  

  @tag1
  Scenario: Navigate Naptool website to the foot care category
    Given The URL of naptool website
    And Click on the Shoping Category
    When User will click on beauty and wellness category
    And User will click on beauty 
    Then User will click on Foot care

  @tag2
  Scenario Outline: Validate the  Foot Care category
     Given The URL of foot care 
     When User will apply brand and some other filters
     And User select the product
     Then Add the selected product to the cart
     And User will navigate back to parent tab