package TestNG;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class AdminUserSearch {

    //Global variable section
    String BaseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    WebDriver driver;
    String expectedText;
    String actualText;
    Boolean status;

    //Before test section
    @BeforeTest
    public void BeforeTestMethod(){

        //Headless Execution if needed
        //ChromeOptions  options = new ChromeOptions
        //options.addArguments("--headless=new");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Test Case - Search by Username (TC: 001)
    @Test (priority = 1)
    public void searchByUsername() throws InterruptedException, IOException {

        System.out.println("--------------TC 001--------------");

        // Login to the system
        userLogin();

        // Select admin sub menu item
        adminClick();

        // Send the username
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys("Admin");

        // Click the search button
        searchButtonClick();

        Thread.sleep(4000);

        // Vertify actual text
        expectedText = "Admin";
        actualText = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[2]/div")).getText();

        //Print actual Text
        System.out.println("Test Case 001 Actual Text: " + actualText);

        if (expectedText.equals(actualText)){

            System.out.println("TC 001: PASS");
            System.out.println("Admin Search for system user by username is done successfully");
            System.out.println("TC 001: Screen Image Captured - Successfully");
            takeSnapShot(driver,"C:\\Users\\akila\\Desktop\\SQA Course\\Selenium\\test-1\\SQA-Selenium\\Snapshots\\SearchByUserName.png");

        }
        else {

            System.out.println("TC 001: FAIL");
            System.out.println("TC 001: Screen Image Captured - Fail");
            takeSnapShot(driver,"C:\\Users\\akila\\Desktop\\SQA Course\\Selenium\\test-1\\SQA-Selenium\\Snapshots\\SearchByUserNameError.png");

        }

        System.out.println("-----------------------------------------");

        // Click reset button
        resetButtonClick();

  }

    //Test Case - Search By Non-Existing Username (TC: 002)
    @Test (priority = 2)
    public void searchbyNonExistingUsername() throws InterruptedException, IOException {

        resetButtonClick();

        System.out.println("--------------TC 002--------------");

        //send the username
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys("Janudi Dilakna");

        //click the search button
        searchButtonClick();

        //Vertify if the filter result is correct
        expectedText = "No Records Found";
        actualText = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")).getText();

        if (expectedText.equals(actualText)) {

            System.out.println("TC 002: PASS");
            System.out.println("Admin search for system non existing user by username done successfully");
            takeSnapShot(driver,"C:\\Users\\akila\\Desktop\\SQA Course\\Selenium\\test-1\\SQA-Selenium\\Snapshots\\SearchByNonExistingUserName.png");

        }
        else {

            System.out.println("TC 002: FAIL");
            System.out.println("TC 002; Screen Image Captured");
            takeSnapShot(driver,"C:\\Users\\akila\\Desktop\\SQA Course\\Selenium\\test-1\\SQA-Selenium\\Snapshots\\SearchByNonExistingUserNameError.png");

        }
        System.out.println("-----------------------------------------");

        //Click reset button
        resetButtonClick();

    }

    //Search by user role (TC 003)
    @Test (priority = 3)
    public void searchByUserRole() throws InterruptedException {

        System.out.println("--------------TC 003--------------");

        //User Role Selection
        userRoleDropdownFilterSelection();

        //Click the search button
        searchButtonClick();

        //Vertify if the filter result is correct
        expectedText = "Admin";
        actualText = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[3]/div")).getText();

        if (expectedText.equals(actualText)) {

            System.out.println("TC 003: PASS");
            System.out.println("Admin search for system user by User Role is done successfully");

        }
        else {
            System.out.println("TC 004: FAIL");
        }
        System.out.println("-----------------------------------------");

        //Click Reset button
        resetButtonClick();
    }

    //Search by employee name (TC 004)
    @Test (priority = 4)
    public void searchByEmployeeName() throws InterruptedException {

        System.out.println("--------------TC 004--------------");

        //Employee name filtering
        emplyeeNameEnter();

        //Click search button
        searchButtonClick();

        //Vertify if the filter result is correct
        expectedText = "manda users";
        actualText = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[4]/div")).getText();

        if (expectedText.equals(actualText)) {

            System.out.println("TC 004: PASS");
            System.out.println("Admin search for system user by employee name is done successfully");

        }
        else {
            System.out.println("TC 004: FAIL");
        }
        System.out.println("-----------------------------------------");

        //Click reset button
        resetButtonClick();
    }



    // Supportive method section
    public void userLogin() throws InterruptedException {

        //Calling the OrangeHRM Login Page
        driver.get(BaseURL);
        Thread.sleep(3000);


        //Identify the Username Text Box and Send Value
        driver.findElement(By.name("username")).sendKeys("Admin");
        //Identify the Password Text Box and Send Value
        driver.findElement(By.name("password")).sendKeys("admin123");
        //Identify the Login Button and Click
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();


        Thread.sleep(3000);


    }

    public void adminClick() throws InterruptedException {

        //click Admin menu item
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")).click();


        //Wait for 3 seconds till the page loads
        Thread.sleep(3000);


        //Verify if the Admin menu is clicked successfully
        expectedText="System Users";
        actualText = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5")).getText();


        if (expectedText.equals(actualText))
        {
            System.out.println("User clicked on Admin sub-menu");
        }
        else
        {
            System.out.println("Unsuccessful click on Admin sub-menu");
        }

    }

    public void resetButtonClick() throws InterruptedException {

        // Click the reset button
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[1]"));

        // Wait for 3 seconds till the page loads
        Thread.sleep(3000);

    }

    public void userRoleDropdownFilterSelection() throws InterruptedException {

        // Click the dropdown arrow unser user role
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]/i")).click();

        // Wait for 1 second till the dropfown loads
        Thread.sleep(1000);

        // Select the admin option
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")).click();

        // wait for 1 second till admin option is selected
        Thread.sleep(1000);

    }

    public void searchButtonClick() throws InterruptedException {

        // Click the search button
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();

        // Wait for 5 seconds till the pge loads
        Thread.sleep(5000);

    }

    public void emplyeeNameEnter() throws InterruptedException {

        //Enter employee name
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input")).sendKeys("manda users");

        // Wait for 2 seconds till the dowp down loads
        Thread.sleep(2000);

        //Select the name suggestion
        driver.findElement(By.xpath(""));
        Thread.sleep(2000);
    }

    public void StatuesDropDownFilter() throws InterruptedException {

        //Click the drop down under button
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]")).click();

        //wait for 1 second till load the drop down options
        Thread.sleep(1000);

        //Select the enabled option
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]")).click();

        //wait for 1 second till load the drop down options
        Thread.sleep(1000);

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


}
