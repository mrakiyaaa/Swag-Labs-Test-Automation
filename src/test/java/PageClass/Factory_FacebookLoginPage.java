package PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Factory_FacebookLoginPage {

    //Identify web elements

    // 1) General/Normal way of find element
    @FindBy(xpath="//*[@id=\"email\"]")
    WebElement userLogin;

    // 2) Standard way of find element using HOW
    @FindBy(how= How.XPATH,using="//*[@id=\"pass\"]") WebElement password;

    @FindBy(how=How.NAME,using="login") WebElement loginButton;

    // 3) Define web driver object for page class
    WebDriver WebPageClassDriver;

    // 4) Constructor method
    public Factory_FacebookLoginPage(WebDriver TestClassDriver)
    {

        this.WebPageClassDriver=TestClassDriver;
    }

    // 5) Initialize methods
    public void Validatelogin(String uname, String pass)
    {
        userLogin.sendKeys(uname);
        password.sendKeys(pass);
        loginButton.click();
    }

    public void InsertValuetoUserName(String uname)
    {
        userLogin.sendKeys(uname);
    }

}
