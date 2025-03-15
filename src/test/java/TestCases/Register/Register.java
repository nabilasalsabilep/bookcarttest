package TestCases.Register;

import ObjectRepository.Header.HeaderPage;
import ObjectRepository.Login.LoginPage;
import ObjectRepository.Register.RegisterPage;
import Utils.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Register extends Util {
    private static final Logger log = LoggerFactory.getLogger(Register.class);
    public static WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public static void setup (String browser) throws Exception{
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
    public static void tearDown() {
        driver.quit();
    }

    @Test()
    public static void successful_register () throws InterruptedException {
        driver.get("https://bookcart.azurewebsites.net/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickloginheader();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickregister();

        RegisterPage registerPage = new RegisterPage(driver);
        RandomData randomData = new RandomData();
        String firstname = randomData.generateRandomFirstName();
        String lastname = randomData.generateRandomLastName();
        String username = randomData.generateRandomUsername();
        String password = randomData.generateRandomPassword();

        registerPage.validateregistrationpage();
        registerPage.setfirstname(firstname);
        registerPage.setlastname(lastname);
        registerPage.setusername(username);
        registerPage.setpassword(password);
        registerPage.setconfirmpassword(password);
        registerPage.selectmalegender();
        Thread.sleep(1000);
        registerPage.clickregister();
        registerPage.validatetoastsuccess();

        loginPage.setusername(username);
        loginPage.setpassword(password);
        loginPage.clicklogin();
    }

}
