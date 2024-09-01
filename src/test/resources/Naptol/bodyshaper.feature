
@tag
Feature: Validate naptool website
 

  @tag1
  Scenario: Validate beauty & wellness section under bodyshaper and slimmer category
    Given The website URL of naptool 
    When The user click on shoping categories
    When The user clicks on beauty and wellness option
    And The user will click on beauty option
    Then The user click on body shaper and slimmer option

  @tag2
    Scenario: Body shaper and slimmer page
    Given The url of body shaper and slimmer page
    Then The user will apply the filters
    And Add to cart 
    
    

   
