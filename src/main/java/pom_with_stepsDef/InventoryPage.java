package pom_with_stepsDef;

import io.cucumber.java.en.When;

import utili.ScenariosContext;


public class InventoryPage {

    private final ScenariosContext scenariosContext;

    public InventoryPage(ScenariosContext scenariosContext) {
        this.scenariosContext = scenariosContext;
    }

    @When("Users select one of Products and click on Add to cart")
    public void usersClickOnAddProduct(){
        scenariosContext.actions.click(scenariosContext.inventoryLocators.addToCartBtn);
        scenariosContext.labelTxtOnBtn = scenariosContext.actions.getText(scenariosContext.inventoryLocators.addToCartBtn);
        System.out.println("Label Txt is: " +  scenariosContext.labelTxtOnBtn);
        scenariosContext.softAssert.assertEquals(scenariosContext.labelTxtOnBtn,"Remove","Product isn't added to the Cart");
        scenariosContext.itemNameTxt =  catchItemNameTxt();
        System.out.println("Item Name text is: " + scenariosContext.itemNameTxt );
        scenariosContext.itemPriceTxt = catchItemPriceTxt();
        System.out.println("Item Price text is: " + scenariosContext.itemPriceTxt);
    }

    public String catchItemNameTxt(){
        return scenariosContext.actions.getText(scenariosContext.inventoryLocators.itemNameTxt);
    }
    public String catchItemPriceTxt(){
        return scenariosContext.actions.getText(scenariosContext.inventoryLocators.itemPriceTxt);
    }
}
