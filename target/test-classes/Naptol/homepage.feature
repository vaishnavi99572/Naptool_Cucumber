
@tag
Feature: Beauty & wellness

  @tag1
  Scenario: Navigate to homepage to beauty &wellness
    Given Naptool website url
   When User go to website and click on shoping categories
    When click on beauty & wellness
    Then click on beauty
    Then click on hand and nail care
    

  @tag2
  Scenario: Apply filters
    Given I am on hand and nail care page
    When I click on checkbox freeship and out of stock
    And I click on set button 
    Then I appli all the filters 
    And add to cart  the item
    
    
   
    