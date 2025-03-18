package ObjectRepository.BookDetail;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.AssertJUnit;

public class BookDetailPage {

    WebDriver driver;

    public BookDetailPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory((SearchContext) driver, 120), this);
    }

    //find Book Details title page
    @FindBy(xpath = "//mat-card-title[@class='mat-mdc-card-title mat-h1' and text()='Book Details']")
    private WebElement bookdetailstitlepage;

    //find book image
    @FindBy(xpath = "//img[@class='mat-mdc-card-image mdc-card__media']")
    private WebElement bookimage;

    //find Title label name
    @FindBy(xpath = "//strong[text()='Title']")
    private WebElement titlelabelname;

    //find Author label name
    @FindBy(xpath = "//strong[text()='Author']")
    private WebElement authorlabelname;

    //find Category label name
    @FindBy(xpath = "//strong[text()='Category']")
    private WebElement categorylabelname;

    //find Price label name
    @FindBy(xpath = "//strong[text()='Price']")
    private WebElement pricelabelname;

    //find book title of Book Details
    @FindBy(xpath = "/html/body/app-root/div/app-book-details/mat-card/mat-card-content/div[2]/table/tbody/tr[1]/td[2]")
    private WebElement booktitleonbookdetail;

    //find author name of Book Details
    @FindBy(xpath = "/html/body/app-root/div/app-book-details/mat-card/mat-card-content/div[2]/table/tbody/tr[2]/td[2]")
    private WebElement authoronbookdetail;

    //find category of Book Details
    @FindBy(xpath = "/html/body/app-root/div/app-book-details/mat-card/mat-card-content/div[2]/table/tbody/tr[3]/td[2]")
    private WebElement categoryonbookdetail;

    //find price of Book Details
    @FindBy(xpath = "/html/body/app-root/div/app-book-details/mat-card/mat-card-content/div[2]/table/tbody/tr[4]/td[2]")
    private WebElement priceofbookdetails;

    //find Add to Cart button
    @FindBy(xpath = "/html/body/app-root/div/app-book-details/mat-card/mat-card-content/div[2]/div/app-addtocart/button/span[2]")
    private WebElement addtocartbutton;

    //find Similar Book section title
    @FindBy(xpath = "//mat-card-title[@class='mat-mdc-card-title mat-h1' and text()=' Similar Books ']")
    private WebElement similarbooktitlesection;

    //find book title of first book on Similar Books section
    @FindBy(xpath = "/html/body/app-root/div/app-book-details/app-similarbooks/mat-card/mat-card-content/div/div[1]/app-book-card/mat-card/mat-card-content/div/a/strong")
    private WebElement booktitleofsimilarbook;

    //find price of first book on Similar Books section
    @FindBy(xpath = "/html/body/app-root/div/app-book-details/app-similarbooks/mat-card/mat-card-content/div/div[1]/app-book-card/mat-card/mat-card-content/p")
    private WebElement bookpriceofsimilarbook;

    //find Add to Cart button of first book on Similar Books section
    @FindBy(xpath = "/html/body/app-root/div/app-book-details/app-similarbooks/mat-card/mat-card-content/div/div[1]/app-book-card/mat-card/mat-card-content/app-addtocart/button/span[2]")
    private WebElement addtocartsimilarbook;

    //validate Book Details page
    public void validatebookdetailpage(){
        AssertJUnit.assertEquals("Book Details", bookdetailstitlepage.getText());
        bookimage.isDisplayed();
        AssertJUnit.assertEquals("Title", titlelabelname.getText());
        AssertJUnit.assertEquals("Author", authorlabelname.getText());
        AssertJUnit.assertEquals("Category", categorylabelname.getText());
        AssertJUnit.assertEquals("Price", pricelabelname.getText());
        AssertJUnit.assertEquals("Add to Cart", addtocartbutton.getText());
        AssertJUnit.assertEquals("Similar Books", similarbooktitlesection.getText());
    }

    //click Add to Cart button on Book Details
    public void clickaddtocartbookdetail(){
        addtocartbutton.click();
    }

    //get element title of Book Details
    public WebElement booktitleelement(){
        return booktitleonbookdetail;
    }

    //get text of book title on Book Details
    public String booktitleonbookdetail(){
        return booktitleonbookdetail.getText();
    }

    //get text of author name on Book Details
    public String authorofbookdetail(){
        return authoronbookdetail.getText();
    }

    //get text of category on Book Details
    public String categoryofbookdetail(){
        return categoryonbookdetail.getText();
    }

    //get element price of Book Details
    public WebElement bookpriceelement(){
        return priceofbookdetails;
    }

    //get text of price on Book Details
    public String priceofbookdetail(){
        return priceofbookdetails.getText();
    }

    //get element title of Similar Books
    public WebElement similarbooktitleelement(){
        return booktitleofsimilarbook;
    }

    //get text of first book title on Similar Books
    public String booktitleofsimilarbook(){
        return booktitleofsimilarbook.getText();
    }

    //get element price of Similar Book
    public WebElement similarbookpricelement(){
        return bookpriceofsimilarbook;
    }

    //get text price of first book on Similar Books
    public String priceofsimilarbook(){
        return bookpriceofsimilarbook.getText();
    }

    //click Add to Cart on first book of Similar Books
    public void clickaddtocartsimilarbook(){
        addtocartsimilarbook.click();
    }
}
