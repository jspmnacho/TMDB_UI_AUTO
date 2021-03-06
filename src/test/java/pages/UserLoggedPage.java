package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserLoggedPage extends BasePage{

    private By userLogin = By.tagName("h2");


    public UserLoggedPage(WebDriver driver) {
        super(driver);
    }

    public String getText(){
        return mapWebElement(userLogin).getText();
    }
}
