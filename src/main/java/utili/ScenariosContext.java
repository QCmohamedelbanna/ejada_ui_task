package utili;

import locators.CheckoutPageLocators;
import locators.HomePageLocators;
import locators.InventoryLocators;
import locators.ShoppingCartLocators;
import org.testng.asserts.SoftAssert;

public class ScenariosContext {
    public final SeleniumActions actions;
    public final SeleniumBase seleniumBase;
    public final InventoryLocators inventoryLocators;
    public final ShoppingCartLocators shoppingCartLocators;
    public final HomePageLocators homePageLocators;
    public final CheckoutPageLocators checkoutPageLocators;
    public SoftAssert softAssert;

    public String itemNameTxt;
    public String itemPriceTxt;
    public String stepsLabelInCheckoutPage;
    public String labelTxtOnBtn;
    public String cartItemNameTxt;
    public String cartItemPriceTxt;
    public String congratulationMsg;


    public ScenariosContext() {
        this.actions = new SeleniumActions();
        this.seleniumBase = new SeleniumBase();
        this.inventoryLocators  = new InventoryLocators();
        this.shoppingCartLocators = new ShoppingCartLocators();
        this.homePageLocators = new HomePageLocators();
        this.checkoutPageLocators = new CheckoutPageLocators();
        this.softAssert = new SoftAssert();


    }

}
