package stepdefinition;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestingBase {

    private static WebDriver driver;


    public TestingBase() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Akshay-Gunjan\\IdeaProjects\\Practice\\Drivers\\chromedriver.exe");
         driver =  new ChromeDriver();
    }


    public static WebDriver getDriver() {
        return driver;
    }
}