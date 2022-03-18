import pages.*;
import utils.Hooks;
import org.testng.annotations.Test;


public class MainTest extends Hooks {

    @Test (groups = { "test1", "test2"})
    public void SuccessLogin() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.clickloginMenuButton();
        loginPage.sendKeys(data.getUsername(), data.getPassword());
        UserLoggedPage userLoggedPage = loginPage.clickButton();
        mainPage.assertionsEquals(userLoggedPage.getText(), data.getUsername());

    }

    @Test (groups = { "test2"})
    public void FailedLogin(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.clickloginMenuButton();
        loginPage.sendKeys(data.getUsername(), data.getPassWrong())
                .clickButton();
        mainPage.assertionsEquals(loginPage.getText(0), "We couldn't validate your information. Want to try again?");
        mainPage.assertionsEquals(loginPage.getText(1), "You have 4 remaining login attempts.");

    }

    @Test (groups = { "test2"})
    public void SuccessfulSearch() {
        MainPage mainPage = new MainPage(driver);
        mainPage.assertionsEquals(mainPage.searchMovie(data.getMovieName())
                .clickSearchButton()
                .checkMovieTittle(), "Fight Club");
    }

    @Test (groups = { "test3"})
    public void VerifyMovieGenreFilter() {
        MainPage mainPage = new MainPage(driver);
        FilterPage filterPage = mainPage.clickMovieMenuItem(4);
        filterPage.clickFiltersItem()
                .clickGenresItem()
                .clickSearchButton();
        mainPage.assertionsTrue(filterPage.clicMoviesItem(5).validarGenres(data.getGenreMovie()), "Validate genres success");
    }

    @Test (groups = { "test3"})
    public void ValidateActingTimeline(){
        MainPage mainPage = new MainPage(driver);
        FilterPage filterPage = mainPage.clickMovieMenuItem(1);
        MoviePage moviePage = filterPage.clickMovieItem(3);
        String movieName = moviePage.getMovieName();
        ActorPage actorPage = moviePage.clickSelectActor(0);
        mainPage.assertionsTrue(actorPage.validarActingTimeLine(movieName), "Validación de pelicula en acting time line");
    }

    @Test (groups = { "test4"})
    public void SortDatesAscendingOrder() {
        MainPage mainPage = new MainPage(driver);
        FilterPage filterPage = mainPage.clickMovieMenuItem(4);
        filterPage.selectSortResultsBy(5)
                .clickSearchButton()
                .validateDateMovie();
    }
}
