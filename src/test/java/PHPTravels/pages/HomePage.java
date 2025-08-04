package PHPTravels.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import java.util.List;
import java.util.Random;

public class HomePage {

    private static final Logger logger = LogManager.getLogger();

    //Home Page elements and methods besides main hotel search

    //Home Page blogs
    @FindBy(xpath = "//div[@class='col-md-4']//div[@class='probox']")
    private List<WebElement> homePageBlogs;

    //Home Page Featured Hotels
    @FindBy(xpath = "//a[@class='loader wow animated']")
    private List<WebElement> featuredHotels;

    //Home Page Featured Flights - to do


    //Home Page Featured Tours
    @FindBy(xpath = "//div[@class='hotel-item']")
    private List<WebElement> featuredTours;

    //Book Now - Featured Tours
    @FindBy(xpath = "//a[text()=' Book Now']")
    private List<WebElement> bookNowFeaturedTours;

    //Home screen Featured Cars
    @FindBy(xpath = "//div[@class='col-md-3 col-sm-6 owl-item mt25 cars']//div[@class='imgLodBg']")
    private List<WebElement> featuredCars;

    //Home Screen special offer
    @FindBy(xpath = "//div[@class='more hidden-xs hidden-sm']//div[@class='col-md-5']")
    private WebElement specialOffer;

    //Home Screen View More Offers - special offer card
    @FindBy(xpath = "//a[text()='View More Offers']")
    private WebElement viewMoreOffersBtn;


    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void randomFunction() throws InterruptedException {
        Random random1 = new Random();
        int randomFunc = random1.nextInt(5);

        if (randomFunc == 0){
            logger.info("funkcja 0");
            Thread.sleep(1000);
            Random random = new Random();
            int randomBlog = random.nextInt(homePageBlogs.size());
            WebElement selectedBlog = homePageBlogs.get(randomBlog);
            selectedBlog.getLocation();
            selectedBlog.click();
            Thread.sleep(1000);
        }
        if (randomFunc == 1){
            logger.info("funkcja 1");
            Thread.sleep(1000);
            Random random = new Random();
            int randomFeaturedHotel = random.nextInt(featuredHotels.size());
            WebElement selectedFeaturedHotel = featuredHotels.get(randomFeaturedHotel);
            selectedFeaturedHotel.getLocation();
            selectedFeaturedHotel.click();
            Thread.sleep(1000);
        }
        if (randomFunc == 2){
            logger.info("funkcja 2");
            Thread.sleep(1000);
            Random random = new Random();
            int randomFeaturedTours = random.nextInt(featuredTours.size());
            WebElement selectedFeatureTour = featuredTours.get(randomFeaturedTours);
            selectedFeatureTour.getLocation();
            selectedFeatureTour.click();
            Thread.sleep(1000);
        }
        if (randomFunc == 3){
            logger.info("funkcja 3");
            Thread.sleep(1000);
            Random random = new Random();
            int randomFeaturedCars = random.nextInt(featuredCars.size());
            WebElement selectedFeaturedCar = featuredCars.get(randomFeaturedCars);
            selectedFeaturedCar.getLocation();
            selectedFeaturedCar.click();
            Thread.sleep(1000);
        }
        if (randomFunc == 4){
            logger.info("funkcja 4");
            Thread.sleep(1000);
            specialOffer.getLocation();
            specialOffer.getText();
            viewMoreOffersBtn.click();
            Thread.sleep(1000);
        }
    }



}
