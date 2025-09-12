package pom_with_steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.testng.Assert;
import utili.ScenariosContext;


public class ShoppingCartPage {
    private final ScenariosContext scenariosContext;
    String cartItemNameTxt;
    String cartItemPriceTxt;

    public ShoppingCartPage(ScenariosContext scenariosContext) {
        this.scenariosContext = scenariosContext;
    }


    @And("Users click on shopping cart link")
    public void usersClickOnShoppingCartLink(){
        scenariosContext.actions.click(scenariosContext.inventoryLocators.shoppingCartBtn);
    }

    @Then("Product should be added in the cart successfully")
    public void checkThatProductAddedToCartSuccessfully(){
        cartItemNameTxt = scenariosContext.actions.getText(scenariosContext.shoppingCartLocators.cartItemNameTxt);
        System.out.println("Product Name in the Shopping Cart is: " + cartItemNameTxt);
        cartItemPriceTxt = scenariosContext.actions.getText(scenariosContext.shoppingCartLocators.cartItemPriceTxt);
        System.out.println("Product Price in the Shopping Cart is: " + cartItemPriceTxt);
        Assert.assertEquals(scenariosContext.itemNameTxt,cartItemNameTxt,
                "Product Name isn't mapped well");
        Assert.assertEquals(scenariosContext.itemPriceTxt, cartItemPriceTxt,
                "Product Price isn't mapped well");
    }

}
