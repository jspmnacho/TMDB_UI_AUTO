package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MovieItemsPage extends BasePage {

    private By movieTittle = By.tagName("h2");

    public MovieItemsPage(WebDriver driver) {
        super(driver);
    }

    public String checkMovieTittle(){

        String val = driver.findElements(movieTittle).get(0).getText();

        return val;
    }



}
