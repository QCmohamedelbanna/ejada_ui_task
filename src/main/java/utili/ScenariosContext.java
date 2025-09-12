package utili;

public class ScenariosContext {
    private final SeleniumActions actions;
    public String itemNameTxt;
    public String itemPriceTxt;
    public ScenariosContext(SeleniumActions actions) {
        this.actions = actions;
    }

}
