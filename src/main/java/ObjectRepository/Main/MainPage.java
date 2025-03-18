package ObjectRepository.Main;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import java.time.Duration;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory((SearchContext) driver, 120), this);
    }

    //find first book card
    @FindBy(xpath = "/html/body/app-root/div/app-home/div/div[2]/div/div/app-book-card/mat-card/mat-card-content")
    private WebElement bookcard;

    //find first book title
    @FindBy(xpath = "//div[@class='card-title my-2']")
    private WebElement firstbooktitle;

    //find first book price
    @FindBy(xpath = "/html/body/app-root/div/app-home/div/div[2]/div/div[1]/app-book-card/mat-card/mat-card-content/p")
    private WebElement firstbookprice;

    //find first book add to cart button
    @FindBy(xpath = "/html/body/app-root/div/app-home/div/div[2]/div/div[1]/app-book-card/mat-card/mat-card-content/app-addtocart/button/span[2]")
    private WebElement firstbookaddtocartbutton;

    //click first book card
    public void clickbookcard(){
        bookcard.click();
    }

    //get first book title element
    public WebElement getfirstbooktitleelement(){
        return firstbooktitle;
    }

    //get first book title
    public String getfirstbooktitle(){
        return firstbooktitle.getText();
    }

    //click first book title
    public void clickfirstbook(){
        firstbooktitle.click();
    }

    //get first book title element
    public WebElement getfirstbookpriceelement(){
        return firstbookprice;
    }

    //get first book price
    public String getfirstbookprice(){
        return firstbookprice.getText();
    }

    //validate first book title match with keyword inputted on search box
    public void validatebooktitle(String keyword){
        AssertJUnit.assertEquals(keyword, firstbooktitle.getText());
    }

    //validate wording and click first book add to cart button
    public void validateaddtocartbutton(){
        AssertJUnit.assertEquals("Add to Cart", firstbookaddtocartbutton.getText());
        firstbookaddtocartbutton.click();
    }
}
