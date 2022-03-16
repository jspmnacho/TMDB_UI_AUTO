package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FilterPage extends BasePage{

    private By fiterItem = By.xpath("//div[@class=\"filter_panel card closed\"]/div[@data-callback=\"filterCallback()\"]");
    private By genresActionItem = By.cssSelector("li[data-value=\"28\"]");
    private By searchButton = By.xpath("//div[@class=\"apply small background_color light_blue enabled\"]//p[@class=\"load_more\"]/a[@class=\"no_click load_more\"]");
    private By movieItem = By.cssSelector("div.style_1");
    private By sortResultsButton = By.xpath("//div[@class=\"filter\"]/span[@role=\"listbox\"]");
    private By sortResults = By.xpath("//ul[@id=\"sort_by_listbox\"]/li");
    private By date



    public FilterPage(WebDriver driver) {
        super(driver);
    }

    public FilterPage clickFiltersItem(){
        mapWebElement(fiterItem).click();
        return new FilterPage(driver);
    }

    public FilterPage clickGenresItem(){
        mapWebElement(genresActionItem).click();
        return new FilterPage(driver);
    }

    public FilterPage clickSearchButton(){
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement val = mapWebElement(searchButton);
        je.executeScript("arguments[0].scrollIntoView(true);",val);
        val.click();
        return new FilterPage(driver);
    }

    public MoviePage clickMovieItem(int item){
        mapWebElements(movieItem).get(item).click();
        return new MoviePage(driver);
    }

    public FilterPage selectSortResultsBy(int item){
        mapWebElements(sortResultsButton).get(0).click();
        mapWebElements(sortResults).get(item).click();
        return new FilterPage(driver);
    }

    public MovieItemsPage clicMoviesItem(int item){
        mapWebElements(movieItem).get(item).click();
        return new MovieItemsPage(driver);
    }
}
