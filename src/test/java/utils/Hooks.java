package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Hooks {

    protected WebDriver driver;
    protected Data data = new Data();

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.themoviedb.org/");
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(ITestResult.FAILURE==result.getStatus()){
            Date date = new Date();
            Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
            SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
            try{
                ImageIO.write(screenshot.getImage(),"PNG",new File(
                        "C:\\Users\\jpuerto\\OneDrive - ENDAVA\\Documents\\JSPM\\Manual2Automation\\" +
                                "Challenge\\TMDB_UI_AUTO\\src\\main\\screenshots\\" + result.getName()+"_"+
                                sFormat.format(date) +".jpg"));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        driver.quit();
    }
}
