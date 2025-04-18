package TestCases.Cart;

import ObjectRepository.BookDetail.BookDetailPage;
import ObjectRepository.Cart.CartPage;
import ObjectRepository.Header.HeaderPage;
import ObjectRepository.Main.MainPage;
import Utils.Util;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddtoCartfromDetailPage extends Util {

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
    public void addtocartfromdetailpage() throws InterruptedException {
        driver.get("https://bookcart.azurewebsites.net/");
        Thread.sleep(30000);

        MainPage mainPage = new MainPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        BookDetailPage bookDetail = new BookDetailPage(driver);
        CartPage cartPage = new CartPage(driver);

        String booktitle = mainPage.getfirstbooktitle();
        String bookprice = mainPage.getfirstbookprice();

        mainPage.clickfirstbook();

        AssertJUnit.assertEquals(booktitle, bookDetail.booktitleonbookdetail());
        AssertJUnit.assertEquals(bookprice, bookDetail.priceofbookdetail());

        int numberofcartitems = headerPage.numberofcartitems();
        bookDetail.clickaddtocartbookdetail();
        Thread.sleep(2000);

        // List of different XPath expressions of book title
        String[] listbooktitle = {
                String.valueOf(bookDetail.booktitleelement()),
                String.valueOf(bookDetail.similarbooktitleelement()),
        };

        // List of different XPath expressions of book title
        String[] listbookprice = {
                String.valueOf(bookDetail.bookpriceelement()),
                String.valueOf(bookDetail.similarbookpricelement()),
        };

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(1000);
        bookDetail.clickaddtocartsimilarbook();
        Thread.sleep(5000);
        int finalamount = numberofcartitems + 2;
        AssertJUnit.assertEquals(finalamount, headerPage.numberofcartitems());

        headerPage.clickcartheader();
        Thread.sleep(1000);

        cartPage.validatewordingoncartpage();
        cartPage.validatebookimage();
        cartPage.validatebooktitle(listbooktitle);
        cartPage.validatebookprice(listbookprice);
        cartPage.validatetotal();
        cartPage.validatedeletebutton();
        cartPage.validatecarttotal();
    }

}
