package PHPTravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserLoginPage {

    private static final Logger logger = LogManager.getLogger();

    @FindBy(xpath = "//input[@type='email']" )
    private WebElement emailAddress;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='remember-me']")
    private WebElement rememberMeCheckBox;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginBtn;

    public UserLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void userLogin(String email, String pass) throws InterruptedException {
        Thread.sleep(1000);
        emailAddress.sendKeys(email);
        password.sendKeys(pass);
        rememberMeCheckBox.click();

        loginBtn.click();

        logger.info("Provided email and password: {} {}", email, pass);
    }

}
