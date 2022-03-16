package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{


    private By usernameText = By.cssSelector("input#username");
    private By passwordText = By.cssSelector("input#password");
    private By loginButton = By.cssSelector("input#login_button");
    private By wasProblem = By.xpath("//div[@class=\"error_status card\"]//div[@class=\"content\"]//li");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

/*    public MainPage waitForElement(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(usernameText));
        return new MainPage(driver);
    }
*/
    public LoginPage sendKeys(String user, String password){

        mapWebElement(usernameText).sendKeys(user);
        mapWebElement(passwordText).sendKeys(password);
        return new LoginPage(driver);
    }

    public UserLoggedPage clickButton(){
        mapWebElement(loginButton).click();
        return new UserLoggedPage(driver);
    }

    public LoginPage clickLoginButton(){
        mapWebElement(loginButton).click();
        return new LoginPage(driver);
    }

    public String getText(int val){
        return mapWebElements(wasProblem).get(val).getText();

    }

}
