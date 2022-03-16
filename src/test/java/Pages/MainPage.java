package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

    private By loginMenuButton = By.xpath("//li/a[@href='/login']");
    private By searchBar = By.cssSelector("input#inner_search_v4");
    private By searchButton = By.cssSelector("input[value=\"Search\"]");
    private By menuItem = By.cssSelector("li.k-menu-item");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickloginMenuButton() {
        mapWebElement(loginMenuButton).click();
        return new LoginPage(driver);
    }

    public MovieItemsPage clickSearchButton(){
        mapWebElement(searchButton).click();
        return new MovieItemsPage(driver);
    }

    public MainPage searchMovie(String movie){
        mapWebElement(searchBar).sendKeys(movie);
        return new MainPage(driver);
    }

    public FilterPage clickMovieMenuItem(int item){
        mapWebElements(menuItem).get(0).click();
        mapWebElements(menuItem).get(item).click();
        return new FilterPage(driver);
    }

}
