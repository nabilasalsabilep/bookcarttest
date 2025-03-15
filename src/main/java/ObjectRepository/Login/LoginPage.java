package ObjectRepository.Login;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.AssertJUnit;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory((SearchContext) driver, 120), this);
    }

    //find Login title page
    @FindBy(xpath = "//mat-card-title[text()=' Login ']")
    private WebElement logintitlepage;

    //find New User text
    @FindBy(xpath = "//span[text()='New User? ']")
    private WebElement newuser;

    //find Register button
    @FindBy(xpath = "//span[text()='Register']")
    private WebElement registerbutton;

    //find input Username field
    @FindBy(xpath = "//input[@formcontrolname='username']")
    private WebElement inputusername;

    //find input Password field
    @FindBy(xpath = "//input[@formcontrolname='password']")
    private WebElement inputpassword;

    //find show password field
    @FindBy(xpath = "//mat-icon[text()='visibility_off']")
    private WebElement showpassword;

    //find hide password field
    @FindBy(xpath = "//mat-icon[text()='visibility']")
    private WebElement hidepassword;

    //find Login button
    @FindBy(xpath = "//span[text()='Login']")
    private WebElement loginbutton;

    //validate wording on Login page
    public void validateloginpagewording(){
        AssertJUnit.assertEquals("Login", logintitlepage.getText());
        AssertJUnit.assertEquals("New User?", newuser.getText());
        AssertJUnit.assertEquals("Register", registerbutton.getText());
        AssertJUnit.assertEquals("Login", loginbutton.getText());
    }

    //click New User hyperlink
    public void clickregister(){
        registerbutton.click();
    }

    //input Username field
    public void setusername(String username){
        inputusername.sendKeys(username);
    }

    //input Password field
    public void setpassword(String password){
        inputpassword.sendKeys(password);
    }

    //click show password field
    public void clickshowpassword(){
        showpassword.click();
    }

    //click hide password field
    public void clickhidepassword(){
        hidepassword.click();
    }

    //click Login button
    public void clicklogin(){
        loginbutton.click();
    }

}
