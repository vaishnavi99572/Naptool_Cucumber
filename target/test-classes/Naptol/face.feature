
@tag
Feature: Validate the Face care feature
 
  @tag1
  Scenario: Navigate Naptool website to face care feature
    Given The url of website naptool 
    When The user will click on shoping categories
    When The user click on beauty and wellness category
    And Select beauty option
    And In beauty page select Facecare option
    

  @tag2
  Scenario Outline: Face care Category
  Given The url of face care page
  When User is applying some filters on face care page
  And select a product
  Then Add to cart this product
  Then User will navigate back 