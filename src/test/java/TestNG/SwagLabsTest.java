package TestNG;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class SwagLabsTest {

    //Global variable
    String BaseURL = "https://www.saucedemo.com/";
    WebDriver driver;
    String expectedText;
    String actualText;

    //before test methde
    @BeforeTest
    public void beforeTestMethod() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    //Test methods
    //Test Case 001
    @Test (priority = 1)
    public void loginLogout() throws InterruptedException {

        System.out.println("----------- SWAG LAB TEST -----------");
        System.out.println("--------------------------------------");
        System.out.println("\n----------- Test Case 001 -----------");

        //Loggin to the website
        userLogin();

        //Confirm in correct page
        expectedText = "Swag Labs";
        actualText = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();

        if (expectedText.equals(actualText)) {

            System.out.println("\nLogin Successfull : Load home page");

        }
        else {

            System.out.println("\nLogin Fail : Error loading home page ");
        }

        //Test User logout button
        userLogout();

    }

    //Test Case 002
    @Test (priority = 2)
    public void ItemCardBtn() throws InterruptedException {

        System.out.println("\n----------- Test Case 002 -----------");
        System.out.println("----------- Item Card Test -----------");

        //Click add to cart button
        itemCardAddToCartBtn();

        //check the add cart icon
        expectedText = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        actualText = "1";

        if (expectedText.equals(actualText)) {
            System.out.println("\nAdd to card successfull");
        }
        else {
            System.out.println("\nError in Add to Cart Option");

        }
        Thread.sleep(2000);

        //Click remove button
        itemCardRemoveBtn();

    }

    //Test Case 003
    @Test (priority = 3)
    public void ItencardTitleAndDescription() throws InterruptedException {


        System.out.println("\n----------- Test Case 003 -----------");

        //Item Card Title
        System.out.println("----------- Card Title Test -----------");

        expectedText = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
        actualText = "Sauce Labs Backpack";

        if (expectedText.equals(actualText)) {
            System.out.println("\nCard Title: PASS");
        }
        else {
            System.out.println("\nCard Title: FAIL");

        }

        Thread.sleep(3000);



        //item Card Discription
        System.out.println("\n----------- Card Discription Test -----------");

        expectedText = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[1]/div")).getText();
        actualText = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

        if (expectedText.equals(actualText)) {
            System.out.println("\nCard Description: PASS");
        }
        else {
            System.out.println("\nCard Description: FAIL");

        }

        Thread.sleep(3000);


    }

    //Test Case 004
    @Test (priority = 4)
    public void ItemCardPriceCurrency() throws InterruptedException, IOException {

        System.out.println("\n----------- Test Case 004 -----------");

        //Item Card Title
        System.out.println("----------- Card Price Currency Test -----------");

        expectedText = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")).getText();
        actualText = "$29.99";

        if (expectedText.equals(actualText)) {
            System.out.println("\nCard Price Currency: PASS");
            System.out.println("Item Card Test: Successfull");
            System.out.println("Item Card Test: Successfull");
            takeSnapShot(driver,"C:\\Users\\Dinuli Nethmini\\Desktop\\SQA\\Selenium\\test-1\\Images\\ItemCardtestComplete.png");
            System.out.println("SnapShot Captured");
        }
        else {
            System.out.println("\nCard Price Currency: FAIL");
            System.out.println("Item Card Test: Fail");
            System.out.println("Image Captured");
            takeSnapShot(driver,"C:\\Users\\Dinuli Nethmini\\Desktop\\SQA\\Selenium\\test-1\\Images\\ItemCardTestFail.png");
            System.out.println("SnapShot Captured");


        }

        Thread.sleep(3000);
    }

    //Test Case 005
    @Test (priority = 5)
    public void Item() throws InterruptedException {

        System.out.println("\n----------- Test Case 005 -----------");

        //Item Click
        ItemClick();
        Thread.sleep(2000);

        //Item Title Test
        ItemTitle();
        Thread.sleep(2000);

        //Item Discription Test
        ItemDescription();
        Thread.sleep(2000);

        //Item Currency Test
        ItemPriceCurrency();
        Thread.sleep(2000);

        //Add to cart button button
        ItemAddToCard();
        Thread.sleep(2000);

        Thread.sleep(3000);

    }

    //Test Case 006
    @Test (priority = 6)
    public void CartSection() throws InterruptedException {

        System.out.println("\n----------- Test Case 006 -----------");

        //Item Card Title
        System.out.println("----------- Cart Page -----------");

        //Cart Button Click
        CartBtnClick();
        Thread.sleep(2000);

        //Page Confirmation
        expectedText = "Your Cart";
        actualText = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("\nCart Page Confirmation : PASS");
        }
        else {
            System.out.println("\nCart Page Confirmation : FAIL");
        }

        Thread.sleep(2000);

        //Check Qty and description titles
        QtyAndDescriptionTitle();
        Thread.sleep(2000);

        //Check item Quantity
        ItemQuantity();
        Thread.sleep(2000);

        //Check Item Title
        CartItemTitle();
        Thread.sleep(2000);

        //Check Item Discription
        CartItemDescription();
        Thread.sleep(2000);

        //Check item Currency
        CartItemCurrency();
        Thread.sleep(2000);

        //Click Remove Btn and again go to cart
        CartRemoveBtn();
        Thread.sleep(2000);

    }

    //Test Case 007
    @Test (priority = 7)
    public void CheckoutPage() throws InterruptedException, IOException {

        //Checkout page
        System.out.println("\n----------- Test Case 007 -----------");
        System.out.println("----------- Checkout Page -----------");

        //Checkout Button Click
        CheckoutClickBtn();
        Thread.sleep(2000);

        //Checkout Title
        expectedText = "Checkout: Your Information";
        actualText = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("\nCheckout Page Loading  : PASS");
        }
        else {
            System.out.println("\nCheckout Page Loading : FAIL");
        }


        //===============================================
        //Fill input fields
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Akila");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Lakshitha");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("12500");
        Thread.sleep(1000);

        //Click Continue button
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();

        Thread.sleep(1000);

        //Confirm Successfully added customer details
        expectedText="Checkout: Overview";
        actualText= driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("\nCheckout Customer Details Submit : PASS");
            System.out.println("Sucessfully loaded Checkout: Overview Page");
            takeSnapShot(driver,"C:\\Users\\Dinuli Nethmini\\Desktop\\SQA\\Selenium\\test-1\\Images\\LoadCheckoutOverviewComplete.png");

        }
        else {
            System.out.println("\nCheckout Customer Details Submit : FAIL");
            System.out.println("Error loading Checkout: Overview Page");
            takeSnapShot(driver,"C:\\Users\\Dinuli Nethmini\\Desktop\\SQA\\Selenium\\test-1\\Images\\LoadCheckoutOverviewError.png");

        }



    }

    //Test Case 008
    @Test (priority = 8)
    public void CheckoutOverviewItem() {

        //Checkout page
        System.out.println("\n----------- Test Case 008-----------");
        System.out.println("----------- Checkout: Overview Page -----------");

        //Check Item Title
        expectedText= "Sauce Labs Backpack";
        actualText= driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("\nTitle Test: PASS");
        }
        else {
            System.out.println("\nTitle Test: FAIL");
        }

        //Check Item Description
        expectedText= "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        actualText= driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[1]")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("Description Test: PASS");
        }
        else {
            System.out.println("Description Test: FAIL");
        }

        //Check Item Quantity
        expectedText= "1";
        actualText= driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[1]")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("Quantity Test: PASS");
        }
        else {
            System.out.println("Quantity Test: FAIL");
        }

        //Check Item Price
        expectedText= "$29.99";
        actualText= driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("Currency Test: PASS");
        }
        else {
            System.out.println("Currency Test: FAIL");
        }

    }

    //Test Case 009
    @Test (priority = 9)
    public void PaymentInformation() {

        //Payment Information
        System.out.println("\n----------- Test Case 009-----------");

        //Check Payment Infomation Title
        expectedText= "Payment Information:";
        actualText= driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[1]")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("\nPayment Information Title Test: PASS");
        }
        else {
            System.out.println("\nPayment Information Title Test: FAIL");
        }

        //Payment info test
        expectedText = "SauceCard #31337";
        actualText= driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[2]")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("Payment Informations Test: PASS");
        }
        else {
            System.out.println("Payment Information Test: FAIL");
        }


    }

    //Test Case 010
    @Test (priority = 10)
    public void ShippingInformation() {

        //Shipping Information
        System.out.println("\n----------- Test Case 010-----------");

        //Shipping info Title Test
        expectedText = "Shipping Information:";
        actualText= driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[3]")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("Shipping Information Title Test: PASS");
        }
        else {
            System.out.println("Shipping Information Title Test: FAIL");
        }

        //Shipping info Test
        expectedText = "Free Pony Express Delivery!";
        actualText= driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[4]")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("Shipping Information Test: PASS");
        }
        else {
            System.out.println("Shipping Information Test: FAIL");
        }

    }

    //Test Case 011
    @Test (priority = 11)
    public void PriceTotal() throws IOException, InterruptedException {

        //Price Total
        System.out.println("\n----------- Test Case 011-----------");

        //Shipping info Title Test
        expectedText = "Price Total";
        actualText= driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[5]")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("\nPrice Total Title Test: PASS");
        }
        else {
            System.out.println("\nPrice Total Title Test: FAIL");
        }

        //Item Total
        expectedText = "Item total: $29.99";
        actualText= driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("Item Total Test: PASS");
        }
        else {
            System.out.println("Item Total Test: FAIL");
        }

        //Item Tax
        expectedText = "Tax: $2.40";
        actualText= driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("Item Tax Test: PASS");
        }
        else {
            System.out.println("Item Tax Test: FAIL");
        }

        Thread.sleep(2000);

        // Item Price Variables
        double itemTotal = 29.99;
        double tax = 2.40;
        double total = itemTotal + tax;
        String totalText = String.format("Total: $%.2f", total);

        String expectedTotal = totalText;
        String actualTotal = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]")).getText();

        if (expectedTotal.equals(actualTotal)) {
            System.out.println("\nTotal Price Calculation Test: PASS");
            System.out.println("Payment Page Complete");
            takeSnapShot(driver,"C:\\Users\\Dinuli Nethmini\\Desktop\\SQA\\Selenium\\test-1\\Images\\PaymentInfoPageComplete.png");
            System.out.println("SnapShot Captured");
        }
        else {
            System.out.println("\nTotal Price Calculation Test: FAIL");
            takeSnapShot(driver,"C:\\Users\\Dinuli Nethmini\\Desktop\\SQA\\Selenium\\test-1\\Images\\PaymentInfoPageError.png");
            System.out.println("SnapShot Captured");
        }


        FinishBtn();

    }

    //Test Case 012
    @Test (priority = 12)
    public void ThankyouPage() throws IOException, InterruptedException {

        //Thank you for your order page test
        expectedText = "Thank you for your order!";
        actualText = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();

        if (expectedText.equals(actualText)){
            System.out.println("Order Placed Successfully");
            System.out.println("THank you Page Load : PASS");
            takeSnapShot(driver,"C:\\Users\\Dinuli Nethmini\\Desktop\\SQA\\Selenium\\test-1\\Images\\OrderComplete.png");
            System.out.println("SnapShot Captured");
        }
        else {
            System.out.println("Order Placing Fail");
            System.out.println("THank you Page Load : FAIL");
            takeSnapShot(driver,"C:\\Users\\Dinuli Nethmini\\Desktop\\SQA\\Selenium\\test-1\\Images\\OrderFail.png");
            System.out.println("SnapShot Captured");
        }

        Thread.sleep(2000);
        //Click Back to home button
        BacktohomeBtn();
    }

    //After test section
    @AfterTest
    public void AfterTestMethod() throws InterruptedException {


        Thread.sleep(5000);
        driver.quit();


    }




    //Supportive method section
    public void userLogin() throws InterruptedException {

        driver.get(BaseURL);
        Thread.sleep(3000);

        //Identify the Username text and send value
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        Thread.sleep(1000);

        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        Thread.sleep(3000);

    }

    public void userLogout() throws InterruptedException {

        //Open navigtaion bar
        driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();

        Thread.sleep(2000);

        //click logout button
        driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();

        driver.get(BaseURL);
        Thread.sleep(3000);

        //Identify the Username text and send value
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        Thread.sleep(3000);
    }

    public void itemCardAddToCartBtn() throws InterruptedException {

        //Click add to cart button
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();

        Thread.sleep(2000);
    }

    public void itemCardRemoveBtn() throws InterruptedException {

        //Click remove button
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();

        Thread.sleep(2000);
    }

    public void takeSnapShot(WebDriver webDriver, String fileWithPath) throws IOException {

        // Convert web driver object to screenShot
        TakesScreenshot srcshot = ((TakesScreenshot) webDriver);

        //Call getScreenShot As Method to create image file
        File SrcFile = srcshot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File DestFile = new File(fileWithPath);

        //copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }

    public void ItemClick() throws InterruptedException {

        //Click Item
        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();

        Thread.sleep(3000);
    }

    public void ItemTitle() {

        //Confirm in correct page
        expectedText = "Sauce Labs Backpack";
        actualText = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]")).getText();

        if (expectedText.equals(actualText)) {

            System.out.println("\nItem Title : PASS");

        }
        else {

            System.out.println("\nItem Title : FAIL");
        }
    }

    public void ItemDescription() {

        //Confirm in correct page
        expectedText = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        actualText = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]")).getText();

        if (expectedText.equals(actualText)) {

            System.out.println("\nItem Discription : PASS");

        }
        else {

            System.out.println("\nItem Discription : FAIL");
        }
    }

    public void ItemPriceCurrency() {

        //Currency Test
        expectedText = "$29.99";
        actualText = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("\nCurrency Test : PASS");
        }
        else {
            System.out.println("\nCurrency Test : FAIL");
        }
    }

    public void ItemAddToCard() throws InterruptedException {

        //Click add to cart button
        driver.findElement(By.xpath("//*[@id=\"add-to-cart\"]")).click();

        Thread.sleep(2000);
    }

    public void CartBtnClick() throws InterruptedException {

        //Click add to cart button
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).click();

        Thread.sleep(2000);
    }

    public void QtyAndDescriptionTitle() {

        //Qty Text Title Test
        expectedText = "QTY";
        actualText = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[1]")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("\nItem Qty Title : PASS");
        }
        else {
            System.out.println("\nItem Qty Title : FAIL");
        }

        //Qty Text Title Test
        expectedText = "Description";
        actualText = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[2]")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("Item Description Title : PASS");
        }
        else {
            System.out.println("Item Description Title : FAIL");
        }

    }

    public void ItemQuantity() {

        //Qty Text Title Test
        expectedText = "1";
        actualText = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[1]")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("\nItem Qty : PASS");
        }
        else {
            System.out.println("\nItem Qty : FAIL");
        }
    }

    public void CartItemTitle() {

        //Cart Item Title
        expectedText = "Sauce Labs Backpack";
        actualText = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("\nCorrect Item Added To Cart : PASS");
        }
        else {
            System.out.println("\nCorrect Item Added To Cart : FAIL");
        }
    }

    public void CartItemDescription() {

        //Cart Item Title
        expectedText = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        actualText = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[1]")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("\nCart Item Description Matching : PASS");
        }
        else {
            System.out.println("\nCart Item Description MAtching : FAIL");
        }
    }

    public void CartItemCurrency() {

        //Cart Item Title
        expectedText = "$29.99";
        actualText = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("\nCart Item Correct Currency : PASS");
        }
        else {
            System.out.println("\nCart Item Correct Currency : FAIL");
        }
    }

    public void CartRemoveBtn() throws InterruptedException {

        //Cart item title
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();
        Thread.sleep(1000);

        //Click to continue shopping
        driver.findElement(By.xpath("//*[@id=\"continue-shopping\"]")).click();
        Thread.sleep(1000);

        //Click again item to cart
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        Thread.sleep(1000);

        //Click again cart
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).click();
        Thread.sleep(1000);
    }

    public void CheckoutClickBtn() throws InterruptedException {

        //Cart item title
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        Thread.sleep(1000);
    }

    public void FinishBtn() throws InterruptedException {

        //Finish button Click
        driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
        Thread.sleep(2000);
    }

    public void BacktohomeBtn() throws InterruptedException {

        //Back to home button click
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
        Thread.sleep(2000);
    }

}
