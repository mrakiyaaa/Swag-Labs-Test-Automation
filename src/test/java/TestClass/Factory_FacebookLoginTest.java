package TestClass;

import PageClass.Factory_FacebookLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Factory_FacebookLoginTest {

    //Global Variable Section
    String BaseURL="https://www.facebook.com/";
    WebDriver TestClassChromeDriver;

    @BeforeTest
    public void BeforeTestMethod()
    {
        TestClassChromeDriver=new ChromeDriver();
        TestClassChromeDriver.manage().window().maximize();
        TestClassChromeDriver.get(BaseURL);
    }

    @Test(priority = 1)
    public void verifyLogin()
    {
        // Created page object using page factory
        Factory_FacebookLoginPage pageUsingPageFactory = PageFactory.initElements(TestClassChromeDriver,Factory_FacebookLoginPage.class);
        pageUsingPageFactory.Validatelogin("Chandana","1234");

    }

    @AfterTest
    public void afterTest()
    {
        //TestClassChromeDriver.quit();
    }
}
