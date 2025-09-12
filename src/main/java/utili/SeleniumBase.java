package utili;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class SeleniumBase {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    private static final Properties properties = new Properties();


    public SeleniumBase(){}

    public WebDriver seleniumSetup(){
        String browser = getBrowser("browser").toLowerCase();
        switch (browser){
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
        }
        wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        driver.manage().window().maximize();
        return driver;
    }

    public void environmentSetup(){
        String value = SeleniumConfig.getBase_URL();
        driver.get(value);
    }

    public static String getBrowser(String key) {
        try {
            FileInputStream file = new FileInputStream("src/main/resources/cross-browser.properties");
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
        return properties.getProperty(key);
    }

}
