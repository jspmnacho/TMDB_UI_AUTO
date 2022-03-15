import Pages.LoginPage;
import Pages.MainPage;
import Pages.UserLoggedPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends Hooks{

    @Test
    public void Login() {
        Data data = new Data();
        
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForElement();
        LoginPage loginPage = mainPage.clickLoginButton();
        loginPage.sendKeys(data.getUsername(), data.getPassword());
        UserLoggedPage userLoggedPage = loginPage.clickButton();
        Assert.assertEquals(userLoggedPage.getText(), "juanpuerto");
        
    }
}
