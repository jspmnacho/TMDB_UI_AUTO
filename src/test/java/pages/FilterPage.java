package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FilterPage extends BasePage{

    private By fiterItem = By.xpath("//div[@class=\"filter_panel card closed\"]/div[@data-callback=\"filterCallback()\"]");
    private By genresActionItem = By.cssSelector("li[data-value=\"28\"]");
    private By searchButton = By.xpath("//div[@class=\"apply small background_color light_blue enabled\"]//p[@class=\"load_more\"]/a[@class=\"no_click load_more\"]");
    private By movieItem = By.cssSelector("div.style_1");
    private By sortResultsButton = By.xpath("//div[@class=\"filter\"]/span[@role=\"listbox\"]");
    private By sortResults = By.xpath("//ul[@id=\"sort_by_listbox\"]/li");
    private By dateMovieItem = By.xpath("//div[@class=\"card style_1\"]//div[@class=\"content\"]/p");



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

    public void validateDateMovie() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");
        List valor = mapWebElements(dateMovieItem);
        for(int i= 0; i<valor.size(); i++){
            for(int j= 0; j<4; j++){
                String valFijo = mapWebElements(dateMovieItem).get(j).getText();
                String val = mapWebElements(dateMovieItem).get(j).getText();
                Date dateFormateada = formato.parse(val);
                Date dateFijo = formato.parse(valFijo);
                if(dateFormateada.getYear() <= dateFijo.getYear()){
                    Assert.assertTrue(true, "Año del item " + j +" es menor");
                }else{
                    Assert.assertTrue(false, "Año del item " + j +" es mayor");
                }
            }
        }
    }
}
