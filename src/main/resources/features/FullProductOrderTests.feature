Feature: Add one of Products to cart and checkout by Logged In User

  Background:
    Given Users hit the Base URL
    When Users enter a username "standard_user" and a password "secret_sauce"
    And Users click on Login Button
    Then Users Login Successfully

  Scenario: Users are able to add Product to Cart
    When Users select one of Products and click on Add to cart
    And Users click on shopping cart link
    Then Product should be added in the cart successfully


