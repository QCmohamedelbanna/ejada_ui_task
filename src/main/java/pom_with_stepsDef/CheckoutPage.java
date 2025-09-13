package pom_with_stepsDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utili.ScenariosContext;

public class CheckoutPage {
    private final ScenariosContext scenariosContext;

    public CheckoutPage(ScenariosContext scenariosContext) {
        this.scenariosContext = scenariosContext;
    }

    @Then("Users should be redirected to Fill Information page and {string} label is displayed")
    public void assertThatUsersRedirectedToFillInfoStep(String infoLabel){
        scenariosContext.stepsLabelInCheckoutPage = getStepsLabelInCheckoutPage();
        System.out.println("Checkout Info Label : " + scenariosContext.stepsLabelInCheckoutPage);
        Assert.assertEquals(scenariosContext.stepsLabelInCheckoutPage, infoLabel, "Checkout isn't working");
    }

    @When("Users fill all required fields FirstName {string}, LastName {string} and Postal Code {string}")
    public void usersFillRequiredFields(String firstName, String lastName, String postalCode){
        scenariosContext.actions.sendKeys(scenariosContext.checkoutPageLocators.firstNameFld,firstName);
        scenariosContext.actions.sendKeys(scenariosContext.checkoutPageLocators.lastNameFld,lastName);
        scenariosContext.actions.sendKeys(scenariosContext.checkoutPageLocators.postalCodeFld,postalCode);
    }

    @And("Users click on Continue")
    public void usersClickOnContinueBtn(){
        scenariosContext.actions.click(scenariosContext.checkoutPageLocators.continueBtn);
    }

    @And("Users should be redirected to Overview page and {string} label is displayed")
    public void assertThatUsersRedirectedToOverviewPage(String overviewLabel){
        scenariosContext.stepsLabelInCheckoutPage = getStepsLabelInCheckoutPage();
        System.out.println("Overview step label is: " + scenariosContext.stepsLabelInCheckoutPage);
        Assert.assertEquals(scenariosContext.stepsLabelInCheckoutPage,overviewLabel,
                "Users are not redirected to Overview step");
    }

    @And("Users click on Finish Button")
    public void usersClickOnFinishBtn(){
        scenariosContext.actions.click(scenariosContext.checkoutPageLocators.finishBtn);
    }

    @Then("Congratulation message {string} should be displayed")
    public void usersCompleteCheckoutSuccessfully(String congMsg){
        scenariosContext.congratulationMsg = getCongratulationMsg();
        System.out.println("Congratulation Msg is : " + scenariosContext.congratulationMsg);
        Assert.assertEquals(scenariosContext.congratulationMsg, congMsg, "Checkout process is failed");
    }

    public String getStepsLabelInCheckoutPage(){
        return scenariosContext.actions.getText(scenariosContext.checkoutPageLocators.InfoTxt);
    }

    public String getCongratulationMsg(){
        return scenariosContext.actions.getText(scenariosContext.checkoutPageLocators.congratulationMsg);
    }

}
