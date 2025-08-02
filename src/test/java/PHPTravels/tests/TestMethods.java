package PHPTravels.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestMethods {

    protected WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest running");
        System.out.println("BeforeTest completed");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod running");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("BeforeMethod completed");
    }

/*
    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod running");
        if (driver != null){
           driver.quit();
       }
    }
 */
}
