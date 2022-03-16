package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilterPage extends BasePage{

    private By fiterItem = By.cssSelector("div.name");
    private By genresActionItem = By.cssSelector("li[data-value=\"28\"]");
    private By searchButton = By.cssSelector("p.load_more");
    private By movieItem = By.cssSelector("div.style_1");


    public FilterPage(WebDriver driver) {
        super(driver);
    }

    public FilterPage clickFiltersItem(){
        mapWebElements(fiterItem).get(1).click();
        return new FilterPage(driver);
    }

    public FilterPage clickGenresItem(){
        mapWebElement(genresActionItem).click();
        return new FilterPage(driver);
    }

    public FilterPage clickSearchButton(){
        mapWebElements(searchButton).get(1).click();
        return new FilterPage(driver);
    }

    public MoviePage clickMovieItem(int item){
        mapWebElements(movieItem).get(item).click();
        return new MoviePage(driver);
    }
}
