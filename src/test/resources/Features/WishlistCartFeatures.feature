Feature: Adding items into Wishlist and Cart

  Scenario: Verify that the user can add four items into wishlist and add the lowest price item to the cart
    Given I go to website
    Given I add four different products to my wishlist
    When I view my wishlist table
    Then I find total four selected items in my wishlist
    Given I search for the lowest price item
    When I add the lowest price item to my cart
    Then I verify the item in my cart