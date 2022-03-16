package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.logging.Logger;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement mapWebElement(By locator){
        WebElement val = driver.findElement(locator);
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        action.moveToElement(val).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(val));
        return val;
    }

    public List<WebElement> mapWebElements(By locator){
        return driver.findElements(locator);
    }

}
