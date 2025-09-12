package pom_with_steps;

import io.cucumber.java.en.When;
import locators.InventoryLocators;
import org.testng.asserts.SoftAssert;
import utili.ScenariosContext;
import utili.SeleniumActions;

public class InventoryPage {

    private final ScenariosContext scenariosContext;
    SeleniumActions actions = new SeleniumActions();
    private final InventoryLocators inventoryLocators = new InventoryLocators();
    String labelTxtOnBtn;
    SoftAssert softAssert = new SoftAssert();

    public InventoryPage(ScenariosContext scenariosContext) {
        this.scenariosContext = scenariosContext;
    }

    @When("Users select one of Products and click on Add to cart")
    public void usersClickOnAddProduct(){
        actions.click(inventoryLocators.addToCartBtn);
        labelTxtOnBtn = actions.getText(inventoryLocators.addToCartBtn);
        System.out.println("Label Txt is: " +  labelTxtOnBtn);
        softAssert.assertEquals(labelTxtOnBtn,"Remove","Product isn't added to the Cart");
        scenariosContext.itemNameTxt =  catchItemNameTxt();
        System.out.println("Item Name text is: " + scenariosContext.itemNameTxt );
        scenariosContext.itemPriceTxt = catchItemPriceTxt();
        System.out.println("Item Price text is: " + scenariosContext.itemPriceTxt);
    }

    public String catchItemNameTxt(){
        return actions.getText(inventoryLocators.itemNameTxt);
    }
    public String catchItemPriceTxt(){
        return actions.getText(inventoryLocators.itemPriceTxt);
    }
}
