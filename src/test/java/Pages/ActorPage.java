package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class ActorPage extends BasePage{

    private By actorMovies = By.xpath("//a[@class=\"tooltip\"]/bdi");

    public ActorPage(WebDriver driver) {
        super(driver);
    }

    public Boolean validarActingTimeLine(String movie){
        Boolean result = false;
        List valor = mapWebElements(actorMovies);
        for(int i= 0; i<valor.size(); i++){
            for(int j= 0; j<valor.size(); j++){
                String val = mapWebElements(actorMovies).get(j).getText();
                System.out.println(val);
                if(mapWebElements(actorMovies).get(j).getText().equals(movie)){
                    result = true;
                    i = valor.size();
                    j= valor.size();
                }
            }
        }
        return result;
    }


}
