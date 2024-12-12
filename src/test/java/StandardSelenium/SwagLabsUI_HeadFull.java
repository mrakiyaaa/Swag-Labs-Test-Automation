package StandardSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabsUI_HeadFull {

    public static WebDriver driver;

    public static void main (String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        // Execution of methods
        LoginTest();
        Dashboardtest();


    }

    public static void LoginTest() throws InterruptedException {

        //Identify the web elements
        WebElement userNameTxt = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        WebElement passwordTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));

        // Trigger the actions
        userNameTxt.sendKeys("standard_user");
        Thread.sleep(1000);
        passwordTxt.sendKeys("secret_sauce");
        Thread.sleep(1000);
        LoginBtn.click();

        System.out.println("Login SuccessFull");
    }

    public static void Dashboardtest() throws InterruptedException {

        WebElement SlideBarBtn = driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]"));
        WebElement SlidebarCloseBtn = driver.findElement(By.xpath("//*[@id=\"react-burger-cross-btn\"]"));
        //Trigger the action
        SlideBarBtn.click();
        Thread.sleep(2000);
        SlidebarCloseBtn.click();

        System.out.println("Slide Bar Open Successfull");
    }
}
