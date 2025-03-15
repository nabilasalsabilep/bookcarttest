package ObjectRepository.Register;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory((SearchContext) driver, 120), this);
    }

    //find User Registration title page
    @FindBy(xpath = "//mat-card-title[text()=' User Registration ']")
    private WebElement registrationtitlepage;

    //find Already has account text
    @FindBy(xpath = "//span[text()='Already Registered? ']")
    private WebElement alreadyregisteredtext;

    //find Login button
    @FindBy(xpath = "//span[text()='Login']")
    private WebElement loginbutton;

    //find input First Name field
    @FindBy(xpath = "//input[@formcontrolname='firstName']")
    private WebElement inputfirstname;

    //find input Last Name field
    @FindBy(xpath = "//input[@formcontrolname='lastName']")
    private WebElement inputlastname;

    //find input Username field
    @FindBy(xpath = "//input[@formcontrolname='userName']")
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

    //find input Confirm Password field
    @FindBy(xpath = "//input[@formcontrolname='confirmPassword']")
    private WebElement inputconfirmpassword;

    //find show confirm password field
    @FindBy(xpath = "//mat-icon[text()=' visibility_off']")
    private WebElement showconfirmpassword;

    //find hide confirm password field
    @FindBy(xpath = "//mat-icon[text()=' visibility']")
    private WebElement hideconfirmpassword;

    //find Gender label name
    @FindBy(xpath = "//mat-label[text()='Gender:']")
    private WebElement genderlabelname;

    //find Male radio button
    @FindBy(xpath = "//label[text()=' Male ']")
    private WebElement malegender;

    //find Female radio button
    @FindBy(xpath = "//label[text()=' Female ']")
    private WebElement femalegender;

    //find Register button
    @FindBy(xpath = "//span[text()='Register']")
    private WebElement registerbutton;

    //validate wording on User Registration page
    public void validateregistrationpage(){
        AssertJUnit.assertEquals("User Registration", registrationtitlepage.getText());
        AssertJUnit.assertEquals("Already Registered?", alreadyregisteredtext.getText());
        AssertJUnit.assertEquals("Login", loginbutton.getText());
        AssertJUnit.assertEquals("Gender:", genderlabelname.getText());
        AssertJUnit.assertEquals("Male", malegender.getText());
        AssertJUnit.assertEquals("Female", femalegender.getText());
        AssertJUnit.assertEquals("Register", registerbutton.getText());
    }

    //input First Name field
    public void setfirstname(String firstname){
        inputfirstname.sendKeys(firstname);
    }

    //input Last Name field
    public void setlastname(String lastname){
        inputlastname.sendKeys(lastname);
    }

    //input Username field
    public void setusername(String username){
        inputusername.sendKeys(username);
    }

    //input Password field
    public void setpassword(String password){
        inputpassword.sendKeys(password);
    }

    //click show password
    public void clickshowpassword(){
        showpassword.click();
    }

    //click hide password
    public void clickhidepassword(){
        hidepassword.click();
    }

    //input Confirm Password field
    public void setconfirmpassword(String confirmpassword){
        inputconfirmpassword.sendKeys(confirmpassword);
    }

    //click show confirm password
    public void clickshowconfirmpassword(){
        showconfirmpassword.click();
    }

    //click hide confirm password
    public void clickhideconfirmpassword(){
        hideconfirmpassword.click();
    }

    //click Male radio button
    public void selectmalegender(){
        malegender.click();
    }

    //click Female radio button
    public void selectfemalegender(){
        femalegender.click();
    }

    //click Register button
    public void clickregister(){
        registerbutton.click();
    }

}
