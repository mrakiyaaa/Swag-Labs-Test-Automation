package StandardSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebElementsAutomation {

    // Create a public web driver object
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException{

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/akila/Downloads/Web%20elements.html");

        // Calling Methods
        OptionButton();
        Thread.sleep(1000);
        CheckBoxes();
        Thread.sleep(1000);
        ComboBox();
        Thread.sleep(1000);
        DropDownList();
        Thread.sleep(1000);
        Button();
        Thread.sleep(1000);
        TextBox();
        Thread.sleep(1000);
        Linktext();
    }

    public static void OptionButton() {

        // Identify web element
        WebElement option1 = driver.findElement(By.id("vfb-7-1"));
        WebElement option2 = driver.findElement(By.id("vfb-7-2"));
        WebElement option3 = driver.findElement(By.id("vfb-7-3"));

        //Execute / Trigger the action
        option1.click();

        if (option1.isSelected()) {

            System.out.println("--------- Option Button Output ---------");
            System.out.println("Option Button 1 has been selected");
        }
        else {
            System.out.println("--------- Option button Output ---------");
            System.out.println("Another Option Button has been selected");

        }

    }

    public static void CheckBoxes() throws InterruptedException {

        // identify the web elements
        WebElement CheckBox1 = driver.findElement(By.id("vfb-6-0"));
        WebElement CheckBox2 = driver.findElement(By.id("vfb-6-1"));
        WebElement CheckBox3 = driver.findElement(By.id("vfb-6-2"));

        // Execute the action
        CheckBox1.click();
        Thread.sleep(1000);
        CheckBox2.click();


        if(CheckBox1.isSelected() && CheckBox2.isSelected()){

            System.out.println("--------- Check Box Output ---------");
            System.out.println("Check Box 1 and 2 have been selected");
        }
        else{

            System.out.println("--------- Check Box Output ---------");
            System.out.println("Another check box/es has been selected");
        }

    }

    public static void ComboBox() throws InterruptedException {

        // Identify web element
        Select ComboBox_Fruits = new Select(driver.findElement(By.id("fruits")));

        // Execute / Trigger the action

        // 1st Option - Select By Visible Text
        ComboBox_Fruits.selectByVisibleText("Banana");
        System.out.println("--------- Combo box selected by visible text output");
        System.out.println("Banana");

        Thread.sleep(2000);

        // 2nd option - Select By Visible Index
        ComboBox_Fruits.selectByIndex(2);
         System.out.println("--------- Cobo Box Selected by Index output ---------");
        System.out.println("Orange");

    }

    public static void DropDownList() throws InterruptedException {

        // identidy the web element
        Select Dropdown_Countries = new Select(driver.findElement(By.name("country")));

        // Execute / Trigger the Action

        // 1st Option - Select By Visible Text
        Dropdown_Countries.selectByVisibleText("ANGOLA");
        System.out.println("--------- Combo box select by visible text output ---------");
        System.out.println("ANGOLA");

        Thread.sleep(2000);

        // 2nd Option - Select by Index
        Dropdown_Countries.selectByIndex(14);
        System.out.println("--------- Combo Box Select By Index ---------");
        System.out.println("AUSTRIA");


    }

    public static void Button() {

        //Identify the Web Element
        WebElement Submit_Btn = driver.findElement(By.name("submit"));

        // Execute / Trigger the action
        Submit_Btn.click();
        System.out.println("--------- Submit Button Output ---------");
        System.out.println("Submit Button has been Clicked");

    }

    public static void TextBox() {

        //identify the Web element
        WebElement TextBox = driver.findElement(By.name("userName"));

        //Execute / Trigger the action
        TextBox.sendKeys("Janudi");
        System.out.println("--------- Text Box Output ---------");
        System.out.println("Janudi");
    }

    public static void Linktext() {

        //Identify Web Element and Execute / Trigger the action
        driver.findElement(By.linkText("your destination")).click();
        System.out.println("--------- Hyper Link output ---------");
        System.out.println("Navigated to SLIIT Website");

    }
}
