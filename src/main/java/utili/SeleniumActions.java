package utili;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class SeleniumActions extends SeleniumBase{

    public SeleniumActions() {
    }

    public List<WebElement> findElements(By path) {
        wait.until(ExpectedConditions.elementToBeClickable(path));
        return driver.findElements(path);
    }

    public void click(By path) {
        wait.until(ExpectedConditions.elementToBeClickable(path));
        driver.findElement(path).click();
    }

    public void sendKeys(By path, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(path));
        driver.findElement(path).clear();
        driver.findElement(path).sendKeys(text);
    }

    public String getText(By path) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(path));
        WebElement GetText = driver.findElement(path);
        return GetText.getText();
    }


    public boolean isDisplayed(By path) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new NoSuchElementException(e);
        }
        WebElement isDisplayed = driver.findElement(path);
        return isDisplayed.isDisplayed();
    }
}
