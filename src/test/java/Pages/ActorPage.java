package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActorPage extends BasePage{

    private By actorMovies = By.cssSelector("a.tooltip");

    public ActorPage(WebDriver driver) {
        super(driver);
    }


}
