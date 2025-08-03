package PHPTravels.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserRegisterPage {

    private static final Logger logger = LogManager.getLogger();

    //Register Page
    //First name
    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstName;

    //Last Name
    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastName;

    //Mobile Number
    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneNumber;

    //Email Address
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailAddress;

    //Password
    @FindBy(xpath = "//input[@type='password']")
    private List<WebElement> password;

    //Submit Btn
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;


    public UserRegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void userRegister(String name, String surname, int phoneNum, String email, String pass){
        logger.info("userRegister started");
        logger.info("Sending firstName: {}", name);
        firstName.sendKeys(name);
        logger.info("Sending lastName: {}", surname);
        lastName.sendKeys(surname);
        logger.info("Sending emailAddress: {}", email);
        phoneNumber.sendKeys(String.valueOf(phoneNum));
        logger.info("Sending phoneNumber: {}", phoneNum);
        emailAddress.sendKeys(email);
        logger.info("Sending password: {}", pass);
        for(int i = 0; i < password.size(); i++){
            password.get(i).sendKeys(pass);
        }

        submitBtn.click();
    }



}
