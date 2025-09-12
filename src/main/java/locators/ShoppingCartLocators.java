package locators;

import org.openqa.selenium.By;

public class ShoppingCartLocators {

    public By cartItemNameTxt = By.cssSelector("div[class='cart_item_label'] div[class='inventory_item_name']");
    public By cartItemPriceTxt = By.cssSelector("div[class='item_pricebar'] div[class='inventory_item_price']");
    public By checkoutBtn = By.id("checkout");
}
