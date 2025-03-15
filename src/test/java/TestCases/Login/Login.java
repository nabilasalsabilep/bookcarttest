package TestCases.Login;

import ObjectRepository.Header.HeaderPage;
import ObjectRepository.Login.LoginPage;
import Utils.Util;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Login extends Util {
    public static WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public static void setup (String browser) throws Exception{
        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(false);
//			options.addArguments("--headless");
//            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
//		driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

    }

    @AfterTest
    public static void tearDown() {
        driver.quit();
    }

    @Test(dataProvider = "getData")
    public static void login(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
        driver.get("https://bookcart.azurewebsites.net/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickloginheader();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.validateloginpagewording();
        loginPage.setusername(input.get("username"));
        loginPage.setpassword(input.get("password"));
        loginPage.clicklogin();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getjsonData("/Users/salsa/IdeaProjects/bookcarttest/src/test/java/TestData/UserAccount.json");
        return new Object[][] { {data.get(0)}};
    }

}
