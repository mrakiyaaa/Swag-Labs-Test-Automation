package StandardSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InstagramLogin_Headless {

    public static void main (String[] args) throws InterruptedException {

        WebDriver driver;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--Headless=new");

        driver = new ChromeDriver(options);
        driver.get("https://www.instagram.com/accounts/login/?hl=en");

        Thread.sleep(2000);

        // Identify the Web Elements
        WebElement UserNameTxt = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input"));
        WebElement PasswordTxt = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input"));
        WebElement Loginbtn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button"));

        // Trigger the action
        UserNameTxt.sendKeys("mr.akiyaa_");
        PasswordTxt.sendKeys("akila@1234");
        Loginbtn.click();

        Thread.sleep(2000);

        System.out.println("Title is: " + driver.getTitle());


    }
}
