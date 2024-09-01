
@tag
Feature: Hair care

  @tag1
  Scenario: Navigate the naptool website haircare page
    Given website Url
    And Navigate the shoping category
    When Click on Beauty & wellness option
    And select beauty option
    Then select Hair care option

  @tag2
  Scenario Outline: Hair care category
    Given The URL of hair care page
    When User perform some slection on checkbok
    Then User slect the product
    And User will add to cart the product
    Then Naviagates back to parent tab
