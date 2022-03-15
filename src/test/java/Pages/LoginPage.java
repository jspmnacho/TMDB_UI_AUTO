package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.crypto.Data;

public class LoginPage extends BasePage{


    private By usernameText = By.cssSelector("input#username");
    private By passwordText = By.cssSelector("input#password");
    private By loginButton = By.cssSelector("input#login_button");



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage waitForElement(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(usernameText));
        return new MainPage(driver);
    }

    public LoginPage sendKeys(String user, String password){

        mapWebElement(usernameText).sendKeys(user);
        mapWebElement(passwordText).sendKeys(password);
        return new LoginPage(driver);
    }

    public UserLoggedPage clickButton(){
        mapWebElement(loginButton).click();
        return new UserLoggedPage(driver);
    }


}
