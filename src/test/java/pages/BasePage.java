package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement mapWebElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement val = driver.findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(val));
        return val;
    }

    public List<WebElement> mapWebElements(By locator){
        List val = driver.findElements(locator);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return val;
    }

  /*  public List<WebElement> mapWebElements(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        List elements = driver.findElements(locator);
        for(int i= 0; i<elements.size(); i++){
            System.out.println(driver.findElements(locator).get(i));
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(locator).get(i)));
        }
        return elements;
    }
*/
    public void assertionsEquals(String actual, String expected) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void assertionsTrue(Boolean actual, String expected) {
        try {
            Assert.assertTrue(actual, expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
