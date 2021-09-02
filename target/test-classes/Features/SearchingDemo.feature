Feature: Search for table and empty the cart.

  @test
  Scenario: searching for tables.
    Given The user navigate to url and landed on webstaurant store home page
    When User enter "stainless work table" and click on search button
    Then User verify the "Table" in the title
    And The user add the last found in the cart and empty the cart
    Then verify the cart is empty


