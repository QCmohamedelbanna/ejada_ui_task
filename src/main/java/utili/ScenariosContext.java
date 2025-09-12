package utili;

import locators.HomePageLocators;
import locators.InventoryLocators;
import locators.ShoppingCartLocators;

public class ScenariosContext {
    public final SeleniumActions actions;
    public final SeleniumBase seleniumBase;
    public final InventoryLocators inventoryLocators;
    public final ShoppingCartLocators shoppingCartLocators;
    public final HomePageLocators homePageLocators;
    public String itemNameTxt;
    public String itemPriceTxt;

    public ScenariosContext() {
        this.actions = new SeleniumActions();
        this.seleniumBase = new SeleniumBase();
        this.inventoryLocators  = new InventoryLocators();
        this.shoppingCartLocators = new ShoppingCartLocators();
        this.homePageLocators = new HomePageLocators();

    }

}
