package locators;

import org.openqa.selenium.By;

public class CheckoutPageLocators {

    public By InfoTxt = By.cssSelector("span[class='title']");
    public By firstNameFld = By.id("first-name");
    public By lastNameFld = By.id("last-name");
    public By postalCodeFld = By.id("postal-code");
    public By continueBtn = By.id("continue");
    public By finishBtn = By.id("finish");
    public By congratulationMsg = By.cssSelector("div[id='checkout_complete_container'] h2"); //Thank you for your order!
}
