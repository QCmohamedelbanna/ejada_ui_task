package pom_with_steps;

import io.cucumber.java.en.When;
import locators.InventoryLocators;
import org.testng.asserts.SoftAssert;
import utili.SeleniumActions;

public class InventoryPage {

    SeleniumActions actions = new SeleniumActions();
    InventoryLocators inventoryLocators = new InventoryLocators();
    String labelTxtOnBtn;
    public String itemNameTxt;
    public String itemPriceTxt;
    SoftAssert softAssert = new SoftAssert();

    @When("Users select one of Products and click on Add to cart")
    public void usersClickOnAddProduct(){
        actions.click(inventoryLocators.addToCartBtn);
        labelTxtOnBtn = actions.getText(inventoryLocators.addToCartBtn);
        System.out.println("Label Txt is: " +  labelTxtOnBtn);
        softAssert.assertEquals(labelTxtOnBtn,"Remove","Product isn't added to the Cart");
        itemNameTxt = catchItemNameTxt();
        itemPriceTxt = catchItemPriceTxt();

    }

    public String getItemNameTxt(){
       return itemNameTxt;
    }

    public String getItemPriceTxt(){
        return itemPriceTxt;
    }

    public String catchItemNameTxt(){
        return actions.getText(inventoryLocators.itemNameTxt);
    }
    public String catchItemPriceTxt(){
        return actions.getText(inventoryLocators.itemPriceTxt);
    }
}
