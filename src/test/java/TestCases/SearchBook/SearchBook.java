package TestCases.SearchBook;

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

import java.util.concurrent.TimeUnit;

public class SearchBook extends Util {
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
    public static void successfullysearchbook(){
        driver.get("https://bookcart.azurewebsites.net/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        HeaderPage headerPage = new HeaderPage(driver);
        String keyword = "Rot & Ruin";
        headerPage.inputsearchboxheader(keyword);
        headerPage.validatesearchresult(keyword);
        headerPage.clicksearchresult();

        MainPage mainPage = new MainPage(driver);
        mainPage.validatebooktitle(keyword);
    }
}
