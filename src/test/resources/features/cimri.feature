Feature: Search Functionality

  Scenario: User searches for a product and views product details
    Given the user opens the app
    When the user searches for "Laptop"
    And clicks on the filter button
    And selects the sorting option as Highest Price
    And clicks on the 10th product in the results
    Then the Go to Seller button should be displayed on the product detail page