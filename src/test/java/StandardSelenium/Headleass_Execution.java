package StandardSelenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Headleass_Execution {

    public static void main (String[] args){

        WebDriver driver;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");

        driver=new ChromeDriver(options);
        driver.get("https://www.sliit.lk/");
        System.out.println("Title is: " + driver.getTitle());

    }
}
