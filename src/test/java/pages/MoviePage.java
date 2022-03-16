package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MoviePage extends BasePage{

    private By actorsItem = By.cssSelector("li.card");
    private By movieTittle = By.xpath("//div[@class=\"title ott_false\"]/h2");

    public MoviePage(WebDriver driver) {
        super(driver);
    }

    public ActorPage clickSelectActor(int item){
        mapWebElements(actorsItem).get(item).click();
        return new ActorPage(driver);
    }

    public String getMovieName(){
        String val = mapWebElement(movieTittle).getText();
        val = val.substring(0, val.length()-7);
        return val;
    }

}
