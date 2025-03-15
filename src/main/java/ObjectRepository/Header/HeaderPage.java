package ObjectRepository.Header;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HeaderPage {

    WebDriver driver;

    public HeaderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory((SearchContext) driver, 120), this);
    }

    //find logo on header
    @FindBy(xpath = "//div[@class='brand-title']/button")
    private WebElement logo;

    //find search box on header
    @FindBy(xpath = "//input[@aria-label='search']")
    private WebElement searchbox;

    //find cart on header
    @FindBy(xpath = "//button[@class='mdc-icon-button mat-mdc-icon-button mat-unthemed mat-mdc-button-base ng-star-inserted']")
    private WebElement cart;

    //find Login button on header
    @FindBy(xpath = "//span[@class='mdc-button__label' and text()=' Login ']")
    private WebElement loginbutton;

    //click logo header
    public void clicklogoheader(){
        logo.click();
    }

    //input search box on header
    public void inputsearchboxheader(String keyword){
        searchbox.sendKeys(keyword);
    }

    //click cart on header
    public void clickcartheader(){
        cart.click();
    }

    //click Login button on header
    public void clickloginheader(){
        loginbutton.click();
    }
}
