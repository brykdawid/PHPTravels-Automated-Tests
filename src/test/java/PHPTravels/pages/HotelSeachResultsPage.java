package PHPTravels.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.Random;

public class HotelSeachResultsPage {



    private static final Logger logger = LogManager.getLogger();


    //Filters--------------------------------------------------------------
    //Star grade menu
    @FindBy(xpath = "//button[@data-target='#collapse1']")
    private WebElement starGradeButton;

    //Hotel ratings - 5 objects (list)
    @FindBy(xpath = "//div[@class='rating']//div[@class='go-right']")
    private List<WebElement> starGrade;

    //Price Range menu
    @FindBy(xpath = "//button[@data-target='#collapse2']")
    private WebElement priceRangeButton;

    //Slider Handle - not working
    @FindBy(xpath = "//class[@class='slider-handle round']")
    private WebElement priceRangeSliderHandle;

    //Property types menu
    @FindBy(xpath = "//button[@data-target='#collapse3']")
    private WebElement propertyTypesButton;

    //Property Types Check Boxes
    @FindBy(xpath = "//input[@id='Hotel']")
    private List<WebElement> propertyTypesCheckBoxes;

    //Amenites Menu
    @FindBy(xpath = "//button[@data-target='#collapse4']")
    private WebElement amenitesButton;

    //Amenites Check Boxes
    @FindBy(xpath = "//input[@id='amenities[]']")
    private List<WebElement> amenitesCheckBoxes;

    //Submit Filters button
    @FindBy(xpath = "//button[@id='searchform']")
    private WebElement submitFiltersButton;

    //Results-----------------------------------------------------------------------
    //Titles
    @FindBy(xpath = "//h4[@class='RTL go-text-right mt0 mb4 list_title']")
    private List<WebElement> hotelTitles;

    //City
    @FindBy(xpath = "//a[@class='go-right ellipsisFIX go-text-right mob-fs14']" )
    private List<WebElement> cityResults;

    //Hotel Description
    @FindBy(xpath = "//div[@class='grey RTL fs12 hidden-xs']//p")
    private List<WebElement> hotelDescriptions;

    //Hotel rating
    @FindBy(xpath = "//div[@class='review text-center size18 hidden-xs']")
    private List<WebElement> hotelRaiting;

    //Details button
    @FindBy(xpath = "//button[@class='btn btn-primary br25 loader loader btn-block']")
    private List<WebElement> detailsButton;

    public HotelSeachResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }



    public void setFiltersOptions() throws InterruptedException {
        logger.info("setFiltersOptions function started");
        logger.info("Selecting random star grade");
        Random random1 = new Random();
        int randomStarGrade = random1.nextInt(starGrade.size());
        WebElement selectRandomGrade = starGrade.get(randomStarGrade);
        logger.info("selected random grade: {}", randomStarGrade);
        selectRandomGrade.click();
        Thread.sleep(1000);



        /*
        logger.info("Selecting random property type");
        Random random2 = new Random();
        int randomPropertyType = random2.nextInt(propertyTypesCheckBoxes.size());
        WebElement selectRandomType = propertyTypesCheckBoxes.get(randomPropertyType);
        logger.info("Selected property type number: {}", selectRandomType);
        selectRandomType.getLocation();
        Thread.sleep(1000);
        selectRandomType.click();
        Thread.sleep(1000);



        logger.info("Selecting random amenities");
        Random random3 = new Random();
        int randomAmenities = random3.nextInt(amenitesCheckBoxes.size());
        WebElement selectRandomAmenities = amenitesCheckBoxes.get(randomAmenities);
        logger.info("Selected Amenities number: {}", selectRandomAmenities);
        selectRandomAmenities.getLocation();
        Thread.sleep(1000);
        selectRandomAmenities.click();
        Thread.sleep(1000);
        */

        submitFiltersButton.getLocation();
        submitFiltersButton.click();
        Thread.sleep(1500);
    }

    public void getResults(){

        if(!hotelTitles.isEmpty()){



            logger.info("Selecting random search result");
            Random random = new Random();
            int randomResult = random.nextInt(hotelTitles.size());
            WebElement selectRandomTitle = hotelTitles.get(randomResult);
            logger.info("Selected random title: {}", selectRandomTitle.getText());
            WebElement selectRandomCity = cityResults.get(randomResult);
            logger.info("Selected random title: {}", selectRandomCity.getText());
            WebElement selectRandomDesc = hotelDescriptions.get(randomResult);
            logger.info("Selected random title: {}", selectRandomDesc.getText());
            WebElement selectHotelRaiting = hotelRaiting.get(randomResult);
            logger.info("Selected hotel raiting: {}", selectHotelRaiting.getText());

            detailsButton.get(randomResult).click();

        }
        else{
            logger.warn("Results are empty");
        }

    }


}
