package pom_with_stepsDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utili.ScenariosContext;

import org.testng.Assert;


public class HomePage {
    private final ScenariosContext scenariosContext;
    String getInventoryPageLabel;
    String getErrorMessage;

    public HomePage(ScenariosContext scenariosContext) {
        this.scenariosContext = scenariosContext;
    }

    @Given("Users hit the Base URL")
    public void initiate(){
        scenariosContext.seleniumBase.seleniumSetup();
        scenariosContext.seleniumBase.environmentSetup();
    }

    @When("Users enter a username {string} and a password {string}")
    public void enterUserName(String username, String password){
        scenariosContext.actions.sendKeys(scenariosContext.homePageLocators.usernameFld,username);
        scenariosContext.actions.sendKeys(scenariosContext.homePageLocators.passwordFld,password);
    }

    @When("Users click on Login Button")
    public void clickOnLoginBtn(){
        scenariosContext.actions.click(scenariosContext.homePageLocators.loginBtn);
    }


    @Then("Users Login Successfully")
    public void assetThatUserLoginSuccessfully(){
        getInventoryPageLabel = scenariosContext.actions.getText(scenariosContext.inventoryLocators.headerLabel);
        System.out.println("Inventory Label in the Header: " + getInventoryPageLabel);
        Assert.assertEquals(getInventoryPageLabel,"Swag Labs");
    }


    @Then("Validation message with error is displayed {string}")
    public void assertThatErrorMessageIsDisplayed(String errorMessage){
        getErrorMessage = scenariosContext.actions.getText(scenariosContext.homePageLocators.errorMsg);
        System.out.println("Error Message : " + getErrorMessage);
        Assert.assertTrue(scenariosContext.actions.isDisplayed(scenariosContext.homePageLocators.errorMsg),"Error isn't displayed");
        Assert.assertEquals(getErrorMessage,errorMessage);
    }





}
