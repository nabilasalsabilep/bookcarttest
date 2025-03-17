package ObjectRepository.Cart;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.AssertJUnit;

import java.text.DecimalFormat;
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

    //find second data Image
    @FindBy(xpath = "/html/body/app-root/div/app-shoppingcart/mat-card/mat-card-content[1]/table/tbody/tr[2]/td[1]/img")
    private WebElement secondataimage;

    //find first data Title
    @FindBy(xpath = "/html/body/app-root/div/app-shoppingcart/mat-card/mat-card-content[1]/table/tbody/tr[1]/td[2]/a")
    private WebElement firstdatatitle;

    //find second data Title
    @FindBy(xpath = "/html/body/app-root/div/app-shoppingcart/mat-card/mat-card-content[1]/table/tbody/tr[2]/td[2]/a")
    private WebElement seconddatatitle;

    //find first data Price
    @FindBy(xpath = "/html/body/app-root/div/app-shoppingcart/mat-card/mat-card-content[1]/table/tbody/tr[1]/td[3]")
    private WebElement firstdataprice;

    //find second data Price
    @FindBy(xpath = "/html/body/app-root/div/app-shoppingcart/mat-card/mat-card-content[1]/table/tbody/tr[2]/td[3]")
    private WebElement secondbookprice;

    //find first data Quantity
    @FindBy(xpath = "/html/body/app-root/div/app-shoppingcart/mat-card/mat-card-content[1]/table/tbody/tr[1]/td[4]/div/div[2]")
    private WebElement firstdataquantity;

    //find second data Quantity
    @FindBy(xpath = "/html/body/app-root/div/app-shoppingcart/mat-card/mat-card-content[1]/table/tbody/tr[2]/td[4]/div/div[2]")
    private WebElement seconddataquantity;

    //find first data Total
    @FindBy(xpath = "/html/body/app-root/div/app-shoppingcart/mat-card/mat-card-content[1]/table/tbody/tr[1]/td[5]")
    private WebElement firstdataTotal;

    //find second data Total
    @FindBy(xpath = "/html/body/app-root/div/app-shoppingcart/mat-card/mat-card-content[1]/table/tbody/tr[2]/td[5]")
    private WebElement secondatatotal;

    //find first icon delete on Action
    @FindBy(xpath = "/html/body/app-root/div/app-shoppingcart/mat-card/mat-card-content[1]/table/tbody/tr[1]/td[6]/button/mat-icon")
    private WebElement firstdatadeleteicon;

    //find second icon delete on Action
    @FindBy(xpath = "/html/body/app-root/div/app-shoppingcart/mat-card/mat-card-content[1]/table/tbody/tr[2]/td[6]/button/mat-icon")
    private WebElement secondatadeleteicon;

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

    //validate total
    public void validatetotal(){
//        String pricetext = firstdataprice.getText();
//        String numericString = pricetext.replaceAll("₹", "").trim();
//        double price = Double.parseDouble(numericString);
//        int qty = Integer.parseInt(firstdataquantity.getText());
//        double totalPrice = price * qty;
//        DecimalFormat df = new DecimalFormat("#.00");
//        String formattedTotalPrice = df.format(totalPrice);
//        return "₹" + formattedTotalPrice;
        int numberOfRows = driver.findElements(By.xpath("//table/tbody/tr")).size();
        for (int i = 1; i <= numberOfRows; i++) {
            // XPath for the price
            WebElement priceElement = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[3]"));
            String priceString = priceElement.getText();

            // Remove currency symbol (₹) and clean the string
            String numericString = priceString.replaceAll("₹", "").trim();

            // Convert to double (numeric value)
            double price = Double.parseDouble(numericString);

            // XPath for the quantity
            WebElement quantityElement = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[4]/div/div[2]"));
            String quantityString = quantityElement.getText();

            // Convert quantity to integer
            int quantity = Integer.parseInt(quantityString);

            // Get Total
            WebElement expectedTotalElement = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[5]"));
            String expectedTotalString = expectedTotalElement.getText();
            String expectedNumericString = expectedTotalString.replaceAll("₹", "").trim();
            double expectedTotal = Double.parseDouble(expectedNumericString);


            // Multiply price by quantity
            double actualTotal = price * quantity;

            // Verify that the actual total matches the expected total
            if (Math.abs(actualTotal - expectedTotal) < 0.01) {  // Using a small tolerance for comparison
                System.out.println("Row " + i + ": Verified successfully. Total matches.");
            } else {
                System.out.println("Row " + i + ": Verification failed. Actual: ₹" + actualTotal + ", Expected: ₹" + expectedTotal);
            }
        }

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

    //validate Cart page after selecting 2 different books
    public void validatecartpagewith2differentselectedbook(String title1, String title2, String price1, String price2){
        AssertJUnit.assertEquals("Shopping cart", carttitlepage.getText());
        AssertJUnit.assertEquals("Clear cart", clearcartbutton.getText());
        AssertJUnit.assertEquals("Image", imagetabletitle.getText());
        AssertJUnit.assertEquals("Title", titletabletitle.getText());
        AssertJUnit.assertEquals("Price", pricetabletitle.getText());
        AssertJUnit.assertEquals("Quantity", quantitytabletitle.getText());
        AssertJUnit.assertEquals("Total", totaltabletitle.getText());
        AssertJUnit.assertEquals("Action", actiontabletitle.getText());

        // Find all book title elements of each row
        List<WebElement> listbooktitle = driver.findElements(By.xpath("//table/tbody/tr/td[2]/a"));

        // Find all price of book elements of each row
        List<WebElement> priceElements = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));


        // Listing the book title from section Book Details and Similar Books
        String[] expectedTitle = {title1, title2};

        // Listing the price of books from section Book Details and Similar Books
        String[] expectedPrices = {price1, price2};

        for (int i = 1; i < listbooktitle.size(); i++) {
            WebElement linkElement = listbooktitle.get(i);
            String actualTitle = linkElement.getText();

            WebElement priceElement = priceElements.get(i);
            String actualPrice = priceElement.getText();

            // Compare the actual text with the expected text
            if (actualTitle.equals(expectedTitle[i])) {
                System.out.println("Row " + (i) + ": Text matches: " + actualTitle);
            } else {
                System.out.println("Row " + (i) + ": Text does not match. Expected: " + expectedTitle[i] + ", Found: " + actualTitle);
            }

            // Compare the actual text with the expected text
            if (actualPrice.equals(expectedPrices[i])) {
                System.out.println("Row " + (i) + ": Text matches: " + actualPrice);
            } else {
                System.out.println("Row " + (i) + ": Text does not match. Expected: " + expectedPrices[i] + ", Found: " + actualPrice);
            }

            // Verify the image element
            WebElement imageXPath = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[1]/img"));
            imageXPath.isDisplayed();

            // Verify the icon element
            WebElement iconXPath = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[6]/button/mat-icon"));
            iconXPath.isDisplayed();
        }
        AssertJUnit.assertEquals("Cart Total:", carttotallabel.getText());
        AssertJUnit.assertEquals("CheckOut", checkoutbutton.getText());
    }
}
