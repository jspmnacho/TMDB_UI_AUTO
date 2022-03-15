package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage{

    private By loginMenuButton = By.xpath("//li/a[@href='/login']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLoginButton(){
        mapWebElement(loginMenuButton).click();
        return new LoginPage(driver);
    }

    public MainPage waitForElement(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(loginMenuButton));
        return new MainPage(driver);
    }


}
