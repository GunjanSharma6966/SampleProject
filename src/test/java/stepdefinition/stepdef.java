package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class stepdef extends TestingBase {

   WebDriver driver = TestingBase.getDriver();


        @Given("^the user launches demoblaze application$")
               public void launch() throws InterruptedException {
           // driver = getdriver();
            driver.get("https://demoblaze.com/");
            driver.manage().window().maximize();

        }

        @Then("count the number of items having price 790")
        public void count() throws InterruptedException {

            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

            //driver.findElement(By.xpath("//a[text()='Samsung galaxy s6']")).click();
            List<WebElement> elements = driver.findElements(By.xpath("//h5[text()='$790']/parent::div/h4/a"));
            System.out.println("The total number of elements with price $790 is " + elements.size());
            for(WebElement element : elements){
                System.out.println(element.getText());
            }

            driver.findElement(By.xpath("//a[contains(text(), \"Nokia lumia 1520\")]")).click();

            driver.findElement(By.xpath("//a[contains(text(), \"Add to cart\")]")).click();
            Thread.sleep(1000);
            driver.switchTo().alert().accept();

//            driver.findElement(By.xpath("//a[@id=\"signin2\"]")).click();
//
//            driver.findElement(By.xpath("//input[@id=\"sign-username\"]")).sendKeys("GunjanSharma");
//
//            driver.findElement(By.xpath("//input[@id=\"sign-password\"]")).sendKeys("Gunjan@123");
//
//            driver.findElement(By.xpath("//button[text()=\"Sign up\"]")).click();
//
//            Thread.sleep(1000);
//            driver.switchTo().alert().accept();

            driver.findElement(By.xpath("//a[text()=\"Log in\"]")).click();

            driver.findElement(By.xpath("//input[@id=\"loginusername\"]")).sendKeys("GunjanSharma");

            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@id=\"loginpassword\"]")).sendKeys("Gunjan@123");

            driver.findElement(By.xpath("//button[text()=\"Log in\"]")).click();

            driver.navigate().refresh();

            driver.findElement(By.xpath("//a[contains(text(), \"Add to cart\")]")).click();
            Thread.sleep(2000);
            driver.switchTo().alert().accept();

            driver.findElement(By.xpath("//a[text()=\"Cart\"]")).click();

            Thread.sleep(3000);
            driver.findElement(By.xpath("//a[text()=\"Delete\"]")).click();


            //driver.quit();


        }

    @Given("^the user launches dropdown application$")
    public void dropdown() throws InterruptedException {
        // driver = getdriver();
        driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
        driver.manage().window().maximize();

    }

    @Then("^test dropdown$")
    public void testdrodpwn(){
           WebElement products = driver.findElement(By.xpath("//select[@id=\"first\"]"));
           Select sel = new Select(products);
           sel.selectByValue("Google");
           sel.selectByIndex(2);

    }

    @Then("^do right click and mouse hover$")
        public void action() throws IOException {
            WebElement elm = driver.findElement(By.xpath("//a[text()=\"Selenium [Python]\"]"));
        Actions action = new Actions(driver);
        action.moveToElement(elm).perform();
        action.contextClick(elm).perform();

        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        File DestFile=new File("Screenshots\\snap1.jpg");

        FileUtils.copyFile(SrcFile, DestFile);

    }

    @Then("^print all links from the page$")
    public void alllinks(){
          List<WebElement> l = driver.findElements(By.xpath("//a"));

        for (WebElement a:l) {
            System.out.println(a.getText());
        }
    }

    @Then("the user prints all links starting with s")
    public void linksstartingwiths(){
        List<WebElement> l = driver.findElements(By.xpath("//a[starts-with(text(), 'S')]"));

        for (WebElement a:l) {
            System.out.println(a.getText());
        }

        System.out.println(10 * 20 + "Employee");
        System.out.println((10 + 20) + "Employee");
        System.out.println("Employee" + 10 + 20);
        System.out.println("Employee" + 10 * 20);
    }

    @Given("the user launches toolsqa and hovers")
    public void opentoolsqa(){
            driver.get("https://demoqa.com/tool-tips");
            WebElement Hoverbutton = driver.findElement(By.xpath("//button[@id = 'toolTipButton']"));
            Actions action = new Actions(driver);
            action.moveToElement(Hoverbutton).build().perform();



        driver.get("https://www.makemytrip.com/flights");
       WebElement Searchbutton = driver.findElement(By.xpath("//a[contains(text(),'Search')]"));
        Searchbutton.click();
        //Link driver.findElements(By.xpath("//span[contains(text(),'View Prices')]"));

    }

    @Then("browser is quit")
    public void quit(){
            driver.quit();
    }

    }

