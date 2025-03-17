package ObjectRepository.Cart;

import com.beust.ah.A;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.AssertJUnit;

import java.util.List;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory((SearchContext) driver, 120), this);
    }

    //find Cart title page
    @FindBy(xpath = "//mat-card-title[@class='mat-mdc-card-title mat-h1' and text()=' Shopping cart ']")
    private WebElement carttitlepage;

    //find empty state information
    @FindBy(xpath = "//mat-card-title[@class='mat-mdc-card-title mat-h1' and text()='Your shopping cart is empty.']")
    private WebElement emptycart;

    //find Continue Shopping button on empty state
    @FindBy(xpath = "//span[text()=' Continue shopping ']")
    private WebElement continueshoppingbutton;

    //find Clear Cart button
    @FindBy(xpath = "//span[text()=' Clear cart ']")
    private WebElement clearcartbutton;

    //find table title Image
    @FindBy(xpath = "//th[text()='Image']")
    private WebElement imagetabletitle;

    //find table title Title
    @FindBy(xpath = "//th[text()='Title']")
    private WebElement titletabletitle;

    //find table title Price
    @FindBy(xpath = "//th[text()='Price']")
    private WebElement pricetabletitle;

    //find table title Quantity
    @FindBy(xpath = "//th[text()='Quantity']")
    private WebElement quantitytabletitle;

    //find table title Total
    @FindBy(xpath = "//th[text()='Total']")
    private WebElement totaltabletitle;

    //find table title Action
    @FindBy(xpath = "//th[text()='Action']")
    private WebElement actiontabletitle;

    //find first data Image
    @FindBy(xpath = "/html/body/app-root/div/app-shoppingcart/mat-card/mat-card-content[1]/table/tbody/tr[1]/td[1]/img")
    private WebElement firstdataimage;

    //find first data Title
    @FindBy(xpath = "/html/body/app-root/div/app-shoppingcart/mat-card/mat-card-content[1]/table/tbody/tr[1]/td[2]/a")
    private WebElement firstdatatitle;

    //find second data Title
    @FindBy(xpath = "/html/body/app-root/div/app-shoppingcart/mat-card/mat-card-content[1]/table/tbody/tr[2]/td[2]/a")
    private WebElement seconddatatitle;

    //find first data Price
    @FindBy(xpath = "/html/body/app-root/div/app-shoppingcart/mat-card/mat-card-content[1]/table/tbody/tr[1]/td[3]")
    private WebElement firstdataprice;

    //find first data Quantity
    @FindBy(xpath = "/html/body/app-root/div/app-shoppingcart/mat-card/mat-card-content[1]/table/tbody/tr[1]/td[4]/div/div[2]")
    private WebElement firstdataquantity;

    //find first data Total
    @FindBy(xpath = "/html/body/app-root/div/app-shoppingcart/mat-card/mat-card-content[1]/table/tbody/tr[1]/td[5]")
    private WebElement firstdataTotal;

    //find first icon delete on Action
    @FindBy(xpath = "/html/body/app-root/div/app-shoppingcart/mat-card/mat-card-content[1]/table/tbody/tr[1]/td[6]/button/mat-icon")
    private WebElement firstdatadeleteicon;

    //find Cart Total label
    @FindBy(xpath = "//strong[text()='Cart Total:']")
    private WebElement carttotallabel;

    //find Cart Total data
    @FindBy(xpath = "/html/body/app-root/div/app-shoppingcart/mat-card/mat-card-content[2]/td[5]/strong")
    private WebElement carttotaldata;

    //find Checkout button
    @FindBy(xpath = "//span[text()=' CheckOut ']")
    private WebElement checkoutbutton;

    //validate empty cart
    public void validateemptycart(){
        AssertJUnit.assertEquals("Shopping cart", carttitlepage.getText());
        AssertJUnit.assertEquals("Your shopping cart is empty.", emptycart.getText());
        AssertJUnit.assertEquals("Continue shopping", continueshoppingbutton.getText());
    }

    //click clear cart button
    public void clickclearcart(){
        clearcartbutton.click();
    }

    //validate Cart page
    public void validatecartpage(String title, String price, String quantity){
        AssertJUnit.assertEquals("Shopping cart", carttitlepage.getText());
        AssertJUnit.assertEquals("Clear cart", clearcartbutton.getText());
        AssertJUnit.assertEquals("Image", imagetabletitle.getText());
        AssertJUnit.assertEquals("Title", titletabletitle.getText());
        AssertJUnit.assertEquals("Price", pricetabletitle.getText());
        AssertJUnit.assertEquals("Quantity", quantitytabletitle.getText());
        AssertJUnit.assertEquals("Total", totaltabletitle.getText());
        AssertJUnit.assertEquals("Action", actiontabletitle.getText());
        firstdataimage.isDisplayed();
        AssertJUnit.assertEquals(title, firstdatatitle.getText());
        AssertJUnit.assertEquals(price, firstdataprice.getText());
        AssertJUnit.assertEquals(quantity, firstdataquantity.getText());
        firstdatadeleteicon.isDisplayed();
        AssertJUnit.assertEquals("Cart Total:", carttotallabel.getText());
        AssertJUnit.assertEquals(price, carttotaldata.getText());
        AssertJUnit.assertEquals("CheckOut", checkoutbutton.getText());
    }

    //click Checkout button
    public void clickcheckoutbutton(){
        checkoutbutton.click();
    }

}
