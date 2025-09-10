import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom.HomePage;
import utili.SeleniumBase;

import java.time.Duration;

public class TestBases {

    SeleniumBase seleniumBase = new SeleniumBase();
    HomePage homePage = new HomePage();


    @BeforeTest
    public void initiate(){
        seleniumBase.setUp();
        seleniumBase.environmentSetup();
    }

    @Test
    public void loginSuccessfully(){
        homePage.loginSuccessfully();
    }
}
