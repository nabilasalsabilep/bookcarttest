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
import java.util.ArrayList;
import java.util.Arrays;
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

    //validate Cart page
    public void validatewordingoncartpage(){
        AssertJUnit.assertEquals("Shopping cart", carttitlepage.getText());
        AssertJUnit.assertEquals("Clear cart", clearcartbutton.getText());
        AssertJUnit.assertEquals("Image", imagetabletitle.getText());
        AssertJUnit.assertEquals("Title", titletabletitle.getText());
        AssertJUnit.assertEquals("Price", pricetabletitle.getText());
        AssertJUnit.assertEquals("Quantity", quantitytabletitle.getText());
        AssertJUnit.assertEquals("Total", totaltabletitle.getText());
        AssertJUnit.assertEquals("Action", actiontabletitle.getText());
        AssertJUnit.assertEquals("Cart Total:", carttotallabel.getText());
        AssertJUnit.assertEquals("CheckOut", checkoutbutton.getText());
    }

    //click Checkout button
    public void clickcheckoutbutton(){
        checkoutbutton.click();
    }

    //validate book image on Cart Page
    public void validatebookimage(){
        // Find all price of book elements of each row
        List<WebElement> table = driver.findElements(By.xpath("//table/tbody/tr"));

        for (int i = 1; i < table.size(); i++) {
            // Verify the image element
            WebElement imageXPath = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[1]/img"));
            imageXPath.isDisplayed();
        }
    }

    //validate book title
    public void validatebooktitle(String[] xpaths){
        // Define a list to store text values
        List<String> texts = new ArrayList<>();

        for (String xpath : xpaths) {
            try {
                WebElement element = driver.findElement(By.xpath(xpath));
                texts.add(element.getText());
            } catch (Exception e) {
                texts.add("Element not found: " + xpath);
            }
        }
    }

    //validate price of book from Book Details
    public void validatebookprice(String[] xpaths){
        // Define a list to store text values
        List<String> expectedPrices = new ArrayList<>();

        // Fetch expected prices from given xpaths
        for (String xpath : xpaths) {
            try {
                WebElement element = driver.findElement(By.xpath(xpath));
                expectedPrices.add(element.getText());
            } catch (Exception e) {
                expectedPrices.add("Not Found"); // Handle missing elements gracefully
                System.out.println("Element not found for XPath: " + xpath);
            }
        }

        // Find all price elements from the book details table
        List<WebElement> priceElements = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));

        // Ensure expectedPrices and priceElements have the same size
        int minSize = Math.min(expectedPrices.size(), priceElements.size());

        for (int i = 0; i < minSize; i++) {
            WebElement priceElement = priceElements.get(i);
            String actualPrice = priceElement.getText();
            String expectedPrice = expectedPrices.get(i);

            // Compare actual and expected price
            if (actualPrice.equals(expectedPrice)) {
                System.out.println("Row " + (i + 1) + ": Price matches: " + actualPrice);
            } else {
                System.out.println("Row " + (i + 1) + ": Price mismatch! Expected: " + expectedPrice + ", Found: " + actualPrice);
            }
        }
    }

    //validate book delete icon is displayed on Cart Page
    public void validatedeletebutton(){
        // Find all price of book elements of each row
        List<WebElement> table = driver.findElements(By.xpath("//table/tbody/tr"));

        for (int i = 1; i < table.size(); i++) {
            // Verify the icon element
            WebElement iconXPath = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[6]/button/mat-icon"));
            iconXPath.isDisplayed();
        }
    }

    //validate total
    public void validatetotal(){
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

    //validate Cart Total of summation all the Total of books
    public void validatecarttotal(){
        // Get all rows in the shopping cart table
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

        double calculatedSum = 0.0;

        for (int i = 1; i <= rows.size(); i++) {
            // Get the total price per row
            WebElement rowTotalElement = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[5]"));
            String rowTotalString = rowTotalElement.getText().replace("₹", "").trim();
            double rowTotal = Double.parseDouble(rowTotalString);

            // Add to total sum
            calculatedSum += rowTotal;
        }

        // Get the grand total from the final price element
        WebElement grandTotalElement = driver.findElement(By.xpath("/html/body/app-root/div/app-shoppingcart/mat-card/mat-card-content[2]/td[5]/strong"));
        String grandTotalString = grandTotalElement.getText().replace("₹", "").trim();
        double grandTotal = Double.parseDouble(grandTotalString);

        // Validate if calculated sum matches grand total
        if (Math.abs(calculatedSum - grandTotal) < 0.01) { // Using tolerance for floating-point comparison
            System.out.println("Grand total matches: ₹" + grandTotal);
        } else {
            System.out.println("Grand total mismatch! Expected: ₹" + grandTotal + ", Calculated: ₹" + calculatedSum);
        }
    }

}
