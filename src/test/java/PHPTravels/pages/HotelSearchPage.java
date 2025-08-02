package PHPTravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HotelSearchPage {

    //Localize the Search Hotel text box
    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement searchHotelTextBox;

    //Localize the input
    @FindBy(xpath = "//div[@id='select2-drop']//input" )
    private WebElement searchHotelInput;

    //List of results based on countryName
    @FindBy(xpath = "//span[@class='select2-match']")
    private List<WebElement> searchResults;

    //Localize the check in date picker
    @FindBy(xpath = "//input[@name='checkin']")
    private WebElement checkInInput;

    //Localize the checkout date picker
    @FindBy(xpath = "//input[@name='checkout']")
    private WebElement checkoutInput;

    //Localize Adults and Child amount picker
    @FindBy(xpath = "//input[@id='travellersInput']")
    private WebElement adultChildAmount;

    @FindBy(xpath = "//input[@id='adultInput']")
    private WebElement adultAmountInput;

    @FindBy(xpath = "//input[@id='childInput']")
    private WebElement childAmountInput;

    //Search button
    @FindBy(xpath = "//button[@class='btn btn-lg btn-block btn-primary pfb0 loader']")
    private WebElement searchButton;

    public HotelSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


        public void setCity(String cityName) throws InterruptedException {
            searchHotelTextBox.click();
            searchHotelInput.sendKeys(cityName);
            Thread.sleep(2000);
            System.out.println("Search results count: " + searchResults.size());
            System.out.println("Search results: " + searchResults);

            if (!searchResults.isEmpty()){
                Random random = new Random();
                int randomIndex = random.nextInt(searchResults.size());
                WebElement randomListElement = searchResults.get(randomIndex);
                System.out.printf("Selected list element: " +randomListElement.getText());
                randomListElement.click();

            }
            else {
                System.out.printf("Error selecting random element");
            }
            Thread.sleep(2000);


        }

        public void setDates(String checkin, String checkout){
            checkInInput.sendKeys(checkin);
            checkoutInput.sendKeys(checkout);
        }

        public void setTravelers(int adultAmount, int childAmount) throws InterruptedException {
            adultChildAmount.click();
            Thread.sleep(1000);
            adultAmountInput.clear();
            adultAmountInput.sendKeys(String.valueOf(adultAmount));

            childAmountInput.clear();
            childAmountInput.sendKeys(String.valueOf(childAmount));
    }

        public void searchButtonClick(){
            searchButton.click();
        }
}
