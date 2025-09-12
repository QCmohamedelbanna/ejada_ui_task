package locators;

import org.openqa.selenium.By;

public class InventoryLocators {
    public By headerLabel = By.cssSelector("div[class='header_label'] div");
    public By addToCartBtn = By.xpath("(//div[@class='pricebar']//button)[1]");
    public By itemNameTxt = By.xpath("(//div[@class='inventory_item_label']//div[@class='inventory_item_name '])[1]");
    public By itemPriceTxt = By.xpath("(//div[@class='pricebar']//div[@class='inventory_item_price'])[1]");
    public By shoppingCartBtn = By.cssSelector("a[class='shopping_cart_link']");


}
