package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class MovieItemsPage extends BasePage {

    private By movieTittle = By.tagName("h2");
    private By genresMovie = By.xpath("//span[@class=\"genres\"]/a");

    public MovieItemsPage(WebDriver driver) {
        super(driver);
    }

    public String checkMovieTittle(){

        String val = driver.findElements(movieTittle).get(0).getText();

        return val;
    }

    public Boolean validarGenres(String genre){
        Boolean result = false;
        List valor = mapWebElements(genresMovie);
        for(int i= 0; i<valor.size(); i++){
            for(int j= 0; j<valor.size(); j++){
                String val = mapWebElements(genresMovie).get(j).getText();
                System.out.println(val);
                if(mapWebElements(genresMovie).get(j).getText().equals(genre)){
                    result = true;
                    i = valor.size();
                    j= valor.size();
                }
            }
        }
        return result;
    }



}
