package TestClass;

import PageClass.POM_Facebook_LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class POM_FacebookLoginTest {

    //Global Variable Section
    String BaseURL="https://www.facebook.com/";
    WebDriver TestClassChromeDriver;

    @BeforeTest
    public void BeforeTestMethod()
    {
        //WebDriverManager.chromedriver().setup();
        TestClassChromeDriver=new ChromeDriver();
        TestClassChromeDriver.manage().window().maximize();
        TestClassChromeDriver.get(BaseURL);
    }

    @Test(priority=1)
    public void FacebookLoginPageVerifyValidLogin() throws InterruptedException
    {
        //Constructor method from page class
        POM_Facebook_LoginPage  FBLogin = new POM_Facebook_LoginPage (TestClassChromeDriver);
        FBLogin.passingValuestoUserNamePassword("Chandana", "Chandana@123456789");
        Thread.sleep(4000);
        FBLogin.clickLoginButton();
    }

    @Test(priority=2)
    public void verifyFacebookLoginPageTitle() throws InterruptedException
    {
        //Constructor method from page class
        POM_Facebook_LoginPage  FBLogin = new POM_Facebook_LoginPage (TestClassChromeDriver);
        boolean status = FBLogin.verifyPageTitle();
        if(status)
        {
            System.out.println("Page Title Verification: Success");
        }
        else
        {
            System.out.println("Page Title Verification: Fail");
        }

    }

    @AfterTest()
    public void AfterTestMethod()
    {
        //TestClassChromeDriver.quit();
    }

}
