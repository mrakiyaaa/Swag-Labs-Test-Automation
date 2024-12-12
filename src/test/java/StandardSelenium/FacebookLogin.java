package StandardSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {
    public static void main (String [] args){

        //Create web driver object to interact with the browser
        WebDriver driver;
        //Assign browser value to the web driver object
        driver=new ChromeDriver();
        //Open the chrome browser window and maximize in the UI
        driver.manage().window().maximize();
        //0Through the driver object, calling the URL
        driver.get("https://www.facebook.com/");


    }
}
