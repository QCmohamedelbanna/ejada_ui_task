Feature: Add one of Products to cart and checkout by Logged In User

  Background:
    Given Users hit the Base URL
    When Users enter a username "standard_user" and a password "secret_sauce"
    When Users click on Login Button
    Then Users Login Successfully

  @CheckoutProductScenario
  Scenario: Users are able to add Product to Cart
    When Users select one of Products and click on Add to cart
    And Users click on shopping cart link
    Then Product should be added in the cart successfully
    When Users click on Checkout button
    Then Users should be redirected to Fill Information page and "Checkout: Your Information" label is displayed
    When Users fill all required fields FirstName "Mohamed", LastName "Elbanna" and Postal Code "123456"
    And Users click on Continue
    And Users should be redirected to Overview page and "Checkout: Overview" label is displayed
    And Users click on Finish Button
    Then Congratulation message "Thank you for your order!" should be displayed



