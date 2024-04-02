package stepdefinition;
import com.epam.healenium.SelfHealingDriver;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import util.ExcelRead;
import util.readYml;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class stepdef extends TestingBase {

   //SelfHealingDriver driver = (SelfHealingDriver) TestingBase.getDriver();
    WebDriver driver =  TestingBase.getDriver();
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);



        @Given("^the user launches demoblaze application$")
               public void launch() throws InterruptedException {
           // driver = getdriver();
            driver.get("https://demoblaze.com/");
            driver.manage().window().maximize();

        }

        @Given("^the user launches kyc application using maker$")
            public void launchkyc() throws InterruptedException {
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
            driver.get("http://blinkyc-ui.s3-website.ap-south-1.amazonaws.com/#/");
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//input[contains(@id,\"email1\")]")).sendKeys("hg54558");
            driver.findElement(By.xpath("//input[@placeholder=\"password\"]")).sendKeys("blinkyc-ui");
            driver.findElement(By.xpath("//button[@label=\"Sign In\"]")).click();

    }

        @Given("^the user launches kyc application using incorrect login cred$")
        public void incorrectlogin() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        driver.get("http://blinkyc-ui.s3-website.ap-south-1.amazonaws.com/#/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@placeholder=\"SOEID\"]")).sendKeys("gs41556");
        driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("blinkyc-ui");
        driver.findElement(By.xpath("//button[@label=\"Sign In\"]")).click();

    }

        @Then("^application throws error message$")
        public void errormsg() throws InterruptedException {
            driver = (SelfHealingDriver) getDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        String errormessage = driver.findElement(By.xpath("//span[@id=\"pr_id_1-label\"]")).getText();
        System.out.println("Error message is "+ errormessage);
        errormessage.equalsIgnoreCase("Either Username or Password is Incorrect");
        Thread.sleep(500);
        driver.quit();
    }


        @Given("^the user launches kyc application using checker$")
            public void checker() throws InterruptedException {
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
            driver.get("http://blinkyc-ui.s3-website.ap-south-1.amazonaws.com/#/");
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//input[@placeholder=\"SOEID\"]")).sendKeys("rs19099");
            driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("blinkyc-ui");
            driver.findElement(By.xpath("//button[@label=\"Sign In\"]")).click();

    }


       @When("^the user rejects kyc request$")
            public void reject() throws InterruptedException {
            driver = (SelfHealingDriver) getDriver();
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
            driver.findElement(By.xpath("//button[contains(@class,\"button-danger\")]")).click();

    }

       @Given("^user opens eureka$")
       public void openeureka() {
            driver.get("https://eureka.com/");
            driver.manage().window().maximize();
        }

    @Given("^user opens selector hub and practices xpath$")
        public void selectorhub() throws InterruptedException {
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();
        List close = driver.findElements(By.xpath("//img[@title=\"Close\"]"));
        if( close.size()>0) {
            driver.findElement(By.xpath("//img[@title=\"Close\"]")).click();
        }
        driver.findElement(By.xpath("//input[@title=\"Email\"]")).sendKeys("Gunjan");
        driver.findElement(By.xpath("//input[@title=\"Password\"]")).sendKeys("Sharma");
        driver.findElement(By.xpath("(//input[@name=\"company\"])[1]")).sendKeys("Google");
        driver.findElement(By.xpath("(//input[@name=\"mobile number\"])[1]")).sendKeys("123456789");
        driver.findElement(By.xpath("//button[@value=\"Submit\"]")).click();
        driver.findElement(By.xpath("(//div/label)[11]/*")).click();
        driver.findElement(By.xpath("//input[@placeholder=\"First Enter name\"]")).sendKeys("Gunjan");
        driver.findElement(By.xpath("//input[@placeholder = \"First Crush\"]")).sendKeys("Akshay");
        WebElement element = driver.findElement(By.xpath("//button[text()=\"Checkout here\"]"));
        String mainHandle=driver.getWindowHandle();
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        driver.findElement(By.xpath("//a[text()= \"Join Training\"]")).click();

         close = driver.findElements(By.xpath("//img[@title=\"Close\"]"));
        if( close.size()>0) {
            driver.findElement(By.xpath("//img[@title=\"Close\"]")).click();
        }
        driver.switchTo().window(mainHandle);

       WebElement selectElment =  driver.findElement(By.xpath("//select[@id=\"cars\"]"));
       Select selectObject = new Select(selectElment);
        selectObject.selectByVisibleText("Audi");

        driver.findElement(By.xpath("//input[@type=\"date\"]")).sendKeys("01021989");

        driver.findElement(By.xpath("//a[contains(@href,\"shadow\")]")).click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.navigate().back();

        close = driver.findElements(By.xpath("//img[@title=\"Close\"]"));
        if( close.size()>0) {
            driver.findElement(By.xpath("//img[@title=\"Close\"]")).click();
        }

        driver.findElement(By.xpath("//a[text()=\"Joe.Root\"]/parent::td/preceding-sibling::td")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");


    driver.findElement(By.xpath("//button[text()='Click To Open Window Alert']")).click();
     Alert alert = driver.switchTo().alert();
     System.out.println("The alerts text is " + alert.getText());
     alert.accept();

        driver.findElement(By.xpath("//button[text()=\"Click To Open Window Prompt Alert\"]")).click();
        Alert alert1 = driver.switchTo().alert();
        System.out.println("The alerts text is " + alert1.getText());
        alert1.accept();


        driver.findElement(By.xpath("//button[@id=\"myBtn\"]")).click();
        WebElement elmt = driver.findElement(By.xpath("(//a[contains(text(),\"Testing Daily\")])[2]"));
         js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", elmt);
        driver.switchTo().window(mainHandle);
        driver.findElement(By.xpath("//span[@class=\"close\"]")).click();



        }


        @When("^the user opens kyc doc$")
        public void viewdoc() throws InterruptedException {
        driver = (SelfHealingDriver) getDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//span[contains(text(),\"PAN\")]")).click();
        Thread.sleep(5000);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,\"p-dialog-header-close\")]")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }

        @When("^the user opens app analytics and closes app$")
        public void analytics() throws InterruptedException {
        driver = (SelfHealingDriver) getDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//span[@class=\"ng-tns-c35-3 pi pi-plus\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(@class,\"p-link layout-topbar-button\")]")).click();
        driver.quit();

    }


        @When("^the user approves kyc request$")
        public void approve() throws InterruptedException {
        driver = (SelfHealingDriver) getDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//button[contains(@class,\"button-success\")]")).click();


    }

        @When("^the user clicks on an application id$")
            public void openapp() throws InterruptedException {
            driver = (SelfHealingDriver) getDriver();
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
            driver.findElement(By.xpath("//a[text()=\"39hox\"]")).click();

    }

        @When("^the user performs retry$")
            public void retry() throws InterruptedException {
            driver = (SelfHealingDriver) getDriver();
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
            driver.findElement(By.xpath("//span[@class=\"p-button-icon pi pi-refresh p-icon-size\"]")).click();

    }

        @When("^the maker submits a doc for verification$")
        public void submit() throws InterruptedException {
        driver = (SelfHealingDriver) getDriver();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[@class=\"p-button-icon pi pi-check\"]")).click();

    }

    @When("^close app detail window$")
    public void closeappdetail() throws InterruptedException {
        driver = (SelfHealingDriver) getDriver();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[@class=\"p-dialog-header-close-icon pi pi-times ng-tns-c37-8\"]")).click();

    }


    @Then("^the user logs off$")
        public void logoff() throws InterruptedException {
            driver = (SelfHealingDriver) getDriver();
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
            driver.findElement(By.xpath("//i[@class=\"pi pi-power-off\"]")).click();

            driver.quit();
        }

        @When("^user waits$")
        public void customwait() throws InterruptedException {

            Thread.sleep(5000);
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

    @Then("count the number of items having price read from excel")
    public void readexcel() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        ExcelRead e = new ExcelRead();
        String value = e.read();
        String xpath = "//h5[text()='$"+value+"']/parent::div/h4/a";
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        System.out.println("The total number of elements with price $790 is " + elements.size());
        for(WebElement element : elements){
            System.out.println(element.getText());
        }

        driver.findElement(By.xpath("//a[contains(text(), \"Nokia lumia 1520\")]")).click();

        driver.findElement(By.xpath("//a[contains(text(), \"Add to cart\")]")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();

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


    @Given("^the user opens Paras Bank Website \\$(\\w+)$")
    public void theUserOpensParasBankWebsite(String URL) {

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        String value  = readYml.read(URL);
        driver.get(value);
        driver.manage().window().maximize();



    }

    @Then("^user registers on website using \\$(\\w+)$")
    public void userRegistersOnWebsite(String name) {
        String locator = readYml.readLocator(name);
        driver.findElement(By.xpath(locator)).click();
        String username = readYml.read("username");
        String firstName = readYml.readLocator("firstName");
        driver.findElement(By.xpath(firstName)).sendKeys("Gunjan");
        String password = readYml.read("password");
        String lastName = readYml.readLocator("lastName");
        driver.findElement(By.xpath(lastName)).sendKeys("Sharma");
        String address = readYml.readLocator("address");
        driver.findElement(By.xpath(address)).sendKeys("A 701, Aeropolis Society");
        String state = readYml.readLocator("state");
        driver.findElement(By.xpath(state)).sendKeys("Maharashtra");
        String city = readYml.readLocator("city");
        driver.findElement(By.xpath(city)).sendKeys("Pune");
        String zipCode = readYml.readLocator("zipCode");
        driver.findElement(By.xpath(zipCode)).sendKeys("411049");
        String phno = readYml.readLocator("phoneNumber");
        driver.findElement(By.xpath(phno)).sendKeys("123456789");
        String ssn = readYml.readLocator("ssn");
        driver.findElement(By.xpath(ssn)).sendKeys("ABCD123456789");
        String uname = readYml.readLocator("userName");
        driver.findElement(By.xpath(uname)).sendKeys(username);
        String pwd = readYml.readLocator("password");
        driver.findElement(By.xpath(pwd)).sendKeys(password);
        String repeatPwd = readYml.readLocator("repeatPwd");
        driver.findElement(By.xpath(repeatPwd)).sendKeys(password);
        String registerButton = readYml.readLocator("registerButton");
        driver.findElement(By.xpath(registerButton)).click();

    }

    @When("^user logs in using \\$(\\w+) and \\$(\\w+)$")
    public void userLogsInUsing$usernameAnd$password(String unamevar, String pwdvar) {
        String username = readYml.read(unamevar);
        String password = readYml.read(pwdvar);
        String unameLoc = readYml.readLocator("username");
        String pwdLoc = readYml.readLocator("pwd");
        driver.findElement(By.xpath(unameLoc)).sendKeys(username);
        driver.findElement(By.xpath(pwdLoc)).sendKeys(password);
        driver.findElement(By.xpath(readYml.readLocator("loginButton"))).click();

    }

    @Then("^user performs a txn for \"([^\"]*)\"$")
    public void userPerformsATxnFor(String amt) throws InterruptedException {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(readYml.readLocator("transferFunds"))).click();
        Thread.sleep(1000);
        String amount = amt.replaceAll("\\$","");
        driver.findElement(By.xpath(readYml.readLocator("amount"))).sendKeys(amount);
        driver.findElement(By.xpath(readYml.readLocator("transferButton"))).click();

    }
}

