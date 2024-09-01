
@tag
Feature: Body care

  @tag1
  Scenario: Validate  the naptool website
    Given The URL of naptool e commerce website
    When The user is navigate to shoping category
    When User is click on beauty & wellness option
    And yet user  will click on Beauty option
    And User will click on bodycare option
   

  @tag2
  Scenario Outline: validate the body care option
    Given The url of body care page url
    When then user is aplying some filter
    Then User is add to cart the product
    And user will be able to navigate the parent tab


