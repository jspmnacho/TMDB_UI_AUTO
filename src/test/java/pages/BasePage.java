package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
/*
    public List<WebElement> mapWebElements(By locator){
        List val = driver.findElements(locator);
        for(int i= 0; i<val.size(); i++){
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(val.get(i)));
            i++;
        }
        return driver.findElements((By) val);
    }
*/
}
