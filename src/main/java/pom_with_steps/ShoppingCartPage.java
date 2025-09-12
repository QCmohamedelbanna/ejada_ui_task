package pom_with_steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import locators.InventoryLocators;
import locators.ShoppingCartLocators;
import org.testng.Assert;
import utili.SeleniumActions;

public class ShoppingCartPage {
    SeleniumActions actions = new SeleniumActions();
    InventoryPage inventoryPage = new InventoryPage();
    InventoryLocators inventoryLocators = new InventoryLocators();
    ShoppingCartLocators shoppingCartLocators = new ShoppingCartLocators();
    String cartItemNameTxt;
    String cartItemPriceTxt;



    @And("Users click on shopping cart link")
    public void usersClickOnShoppingCartLink(){
        actions.click(inventoryLocators.shoppingCartBtn);
    }

    @Then("Product should be added in the cart successfully")
    public void checkThatProductAddedToCartSuccessfully(){
        cartItemNameTxt = actions.getText(shoppingCartLocators.cartItemNameTxt);
        System.out.println("Product Name in the Shopping Cart is: " + cartItemNameTxt);
        cartItemPriceTxt = actions.getText(shoppingCartLocators.cartItemPriceTxt);
        System.out.println("Product Price in the Shopping Cart is: " + cartItemPriceTxt);
        Assert.assertEquals(inventoryPage.itemNameTxt,cartItemNameTxt,
                "Product Name isn't mapped well");
        Assert.assertEquals(inventoryPage.itemPriceTxt, cartItemPriceTxt,
                "Product Price isn't mapped well");
    }

}
