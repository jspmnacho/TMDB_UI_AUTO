import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends Hooks{

    @Test
    public void SuccessLogin() {
        Data data = new Data();
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.clickloginMenuButton();
        loginPage.sendKeys(data.getUsername(), data.getPassword());
        UserLoggedPage userLoggedPage = loginPage.clickButton();
        Assert.assertEquals(userLoggedPage.getText(), "juanpuerto");
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
    public void SuccessfulSearch() throws InterruptedException {
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
        Thread.sleep(10000);
    }

    @Test
    public void ValidateActingTimeline() throws InterruptedException {
        Data data = new Data();
        MainPage mainPage = new MainPage(driver);
        FilterPage filterPage = mainPage.clickMovieMenuItem(1);
        MoviePage moviePage = filterPage.clickMovieItem(3);
        //String movieName = moviePage.getMovieName();
        //System.out.println(movieName);
        moviePage.clickSelectActor(0);

        Thread.sleep(10000);
    }
}
