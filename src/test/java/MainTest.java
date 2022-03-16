import pages.*;
import utils.Data;
import utils.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends Hooks {

    @Test
    public void SuccessLogin() {
        Data data = new Data();
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.clickloginMenuButton();
        loginPage.sendKeys(data.getUsername(), data.getPassword());
        UserLoggedPage userLoggedPage = loginPage.clickButton();
        Assert.assertEquals(userLoggedPage.getText(), data.getUsername());
    }

    @Test
    public void FailedLogin(){
        Data data = new Data();
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.clickloginMenuButton();
        loginPage.sendKeys(data.getUsername(), data.getPassWrong());
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getText(0), "We couldn't validate your information. Want to try again?");
        Assert.assertEquals(loginPage.getText(1), "You have 4 remaining login attempts.");
    }

    @Test
    public void SuccessfulSearch() {
        Data data = new Data();
        MainPage mainPage = new MainPage(driver);
        Assert.assertEquals(mainPage.searchMovie(data.getMovieName())
                .clickSearchButton()
                .checkMovieTittle(), "Fight Club");
    }

    @Test
    public void VerifyMovieGenreFilter() throws InterruptedException {
        Data data = new Data();
        MainPage mainPage = new MainPage(driver);
        FilterPage filterPage = mainPage.clickMovieMenuItem(4);
        filterPage.clickFiltersItem()
                .clickGenresItem()
                .clickSearchButton();
        Assert.assertTrue(filterPage.clicMoviesItem(5).validarGenres(data.getGenreMovie()), "Validate genres success");
    }

    @Test
    public void ValidateActingTimeline(){
        MainPage mainPage = new MainPage(driver);
        FilterPage filterPage = mainPage.clickMovieMenuItem(1);
        MoviePage moviePage = filterPage.clickMovieItem(3);
        String movieName = moviePage.getMovieName();
        ActorPage actorPage = moviePage.clickSelectActor(0);
        Assert.assertTrue(actorPage.validarActingTimeLine(movieName), "Validación de pelicula en acting time line");
    }

    @Test
    public void SortDatesAscendingOrder() throws InterruptedException {
        Data data = new Data();
        MainPage mainPage = new MainPage(driver);
        FilterPage filterPage = mainPage.clickMovieMenuItem(4);
        filterPage.selectSortResultsBy(5)
                .clickSearchButton();
    }
}
