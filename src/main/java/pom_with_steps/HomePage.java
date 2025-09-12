package pom_with_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.HomePageLocators;
import locators.InventoryLocators;
import utili.SeleniumActions;
import org.testng.Assert;
import utili.SeleniumBase;

public class HomePage {

    SeleniumActions actions = new SeleniumActions();
    HomePageLocators homePageLocators = new HomePageLocators();
    InventoryLocators inventoryLocators = new InventoryLocators();
    SeleniumBase seleniumBase = new SeleniumBase();
    String getInventoryPageLabel;
    String getErrorMessage;

    @Given("Users hit the Base URL")
    public void initiate(){
        seleniumBase.setUp();
        seleniumBase.environmentSetup();
    }

    @When("Users enter a username {string} and a password {string}")
    public void enterUserName(String username, String password){
        actions.sendKeys(homePageLocators.usernameFld,username);
        actions.sendKeys(homePageLocators.passwordFld,password);
    }

    @When("Users click on Login Button")
    public void clickOnLoginBtn(){
        actions.click(homePageLocators.loginBtn);
    }


    @Then("Users Login Successfully")
    public void assetThatUserLoginSuccessfully(){
        getInventoryPageLabel = actions.getText(inventoryLocators.headerLabel);
        System.out.println("Inventory Label in the Header: " + getInventoryPageLabel);
        Assert.assertEquals(getInventoryPageLabel,"Swag Labs");
    }


    @Then("Validation message with error is displayed {string}")
    public void assertThatErrorMessageIsDisplayed(String errorMessage){
        getErrorMessage = actions.getText(homePageLocators.errorMsg);
        System.out.println("Error Message : " + getErrorMessage);
        Assert.assertTrue(actions.isDisplayed(homePageLocators.errorMsg),"Error isn't displayed");
        Assert.assertEquals(getErrorMessage,errorMessage);
    }





}
