package TestCases.Cart;

import ObjectRepository.Cart.CartPage;
import ObjectRepository.Header.HeaderPage;
import ObjectRepository.Main.MainPage;
import Utils.Util;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AddtoCart extends Util {

    public static WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public static void setup(String browser) throws Exception{
        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(false);
//			options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
//		driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    @AfterTest
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public static void addtocartfrommainpage() throws InterruptedException {
        driver.get("https://bookcart.azurewebsites.net/");
        Thread.sleep(30000);

        MainPage mainPage = new MainPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);

        String booktitle = mainPage.getfirstbooktitle();
        String bookprice = mainPage.getfirstbookprice();

        int numberofcartitems = headerPage.numberofcartitems();
        mainPage.validateaddtocartbutton();
        Thread.sleep(5000);
        int finalamount = numberofcartitems + 1;
        AssertJUnit.assertEquals(finalamount, headerPage.numberofcartitems());

        headerPage.clickcartheader();
        Thread.sleep(1000);

        CartPage cartPage = new CartPage(driver);
        cartPage.validatecartpage(booktitle, bookprice, Integer.toString(finalamount));
    }
}
