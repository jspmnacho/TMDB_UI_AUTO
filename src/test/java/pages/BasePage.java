package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement mapWebElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement val = driver.findElement(locator);
        Actions action = new Actions(driver);
        action.moveToElement(val).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(val));
        return val;
    }

    public List<WebElement> mapWebElements(By locator){
        return driver.findElements(locator);
    }
/*
    public List<WebElement> mapWebElements(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        List elements = driver.findElements(locator);
        for(int i= 0; i<elements.size(); i++){
            System.out.println(driver.findElements(locator).get(i));
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(locator).get(i)));
        }
        return elements;
    }
*/
}
