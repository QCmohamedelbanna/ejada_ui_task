package pom_with_stepsDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utili.ScenariosContext;


public class ShoppingCartPage {
    private final ScenariosContext scenariosContext;


    public ShoppingCartPage(ScenariosContext scenariosContext) {
        this.scenariosContext = scenariosContext;
    }


    @And("Users click on shopping cart link")
    public void usersClickOnShoppingCartLink(){
        scenariosContext.actions.click(scenariosContext.inventoryLocators.shoppingCartBtn);
    }

    @Then("Product should be added in the cart successfully")
    public void checkThatProductAddedToCartSuccessfully(){
        scenariosContext.cartItemNameTxt = scenariosContext.actions.getText(scenariosContext.shoppingCartLocators.cartItemNameTxt);
        System.out.println("Product Name in the Shopping Cart is: " + scenariosContext.cartItemNameTxt);
        scenariosContext.cartItemPriceTxt = scenariosContext.actions.getText(scenariosContext.shoppingCartLocators.cartItemPriceTxt);
        System.out.println("Product Price in the Shopping Cart is: " + scenariosContext.cartItemPriceTxt);
        Assert.assertEquals(scenariosContext.itemNameTxt,scenariosContext.cartItemNameTxt,
                "Product Name isn't mapped well");
        Assert.assertEquals(scenariosContext.itemPriceTxt, scenariosContext.cartItemPriceTxt,
                "Product Price isn't mapped well");
    }

    @When("Users click on Checkout button")
    public void clickOnContinueBtn(){
        scenariosContext.actions.click(scenariosContext.shoppingCartLocators.checkoutBtn);

    }

}
