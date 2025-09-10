package pom;

import locators.HomePageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utili.SeleniumActions;

import java.time.Duration;

public class HomePage {

    SeleniumActions actions = new SeleniumActions();
    HomePageLocators homePageLocators = new HomePageLocators();



    public void loginSuccessfully(){
        actions.sendKeys(homePageLocators.usernameFld,"standard_user");
        actions.sendKeys(homePageLocators.passwordFld,"secret_sauce");
        actions.click(homePageLocators.loginBtn);
    }

}
