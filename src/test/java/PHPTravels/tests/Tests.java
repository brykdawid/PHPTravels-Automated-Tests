package PHPTravels.tests;

import PHPTravels.pages.*;
import PHPTravels.tests.TestMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Tests extends TestMethods {


    //Data
    String websiteURL = "http://www.kurs-selenium.pl/demo/";
    String searchResultsURL = "http://www.kurs-selenium.pl/demo/hotels/search/united-arab-emirates/dubai/21-08-2025/29-08-2025/2/0";
    String userRegisterUrl = "http://www.kurs-selenium.pl/demo/register";
    String userLoginUrl = "http://www.kurs-selenium.pl/demo/login";
    String blogPageUrl = "http://www.kurs-selenium.pl/demo/blog/listing/1";
    //Register/Login data
    private String name = "Dawid";
    private String surname = "Bryk";
    private int phone = 615625716;
    private String email = "khgaskjhdga@gmail.com";
    private String password = "qwerty123";

    //Logger Creation
    private static final Logger logger = LogManager.getLogger();


    //Register User test
    @Test
    public void registerUser(){
        driver.get(userRegisterUrl);
        logger.info("registerUser started");

        UserRegisterPage userRegisterPage = new UserRegisterPage(driver);
        userRegisterPage.userRegister(name, surname, phone, email, password);

        logger.info("registerUser completed");

    }
    //Login User test
    @Test
    public void loginUser() throws InterruptedException {
        logger.info("loginUser started");
        driver.get(userLoginUrl);
        UserLoginPage userLoginPage = new UserLoginPage(driver);

        userLoginPage.userLogin(email, password);

        logger.info("loginUser completed");
    }

    //searchHotel test
    @Test
    public void searchHotelTest () throws InterruptedException {

        driver.get(websiteURL);

        logger.info("searchHotelTest start");
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);

        logger.info(" hotelSearchPage.setCity(Dubai); func started");
        hotelSearchPage.setCity("France");


        logger.info("hotelSearchPage.setDates started");
        hotelSearchPage.setDates("21/07/2022","28/07/2022");

        logger.info("hotelSearchPage.setTravelers started");
        hotelSearchPage.setTravelers(2,1);
        logger.info("hotelSearchPage.searchButtonClick started");

        hotelSearchPage.searchButtonClick();
        logger.info("searchHotelTest end");
    }

    //Empty city searchTest
    @Test
    public void emptyCityHotelSearchTest() throws InterruptedException {
        driver.get(websiteURL);

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        logger.info(" hotelSearchPage.setCity(); func started - blank space left");

        logger.info("hotelSearchPage.setDates started");
        hotelSearchPage.setDates("21/07/2022","28/07/2022");

        logger.info("hotelSearchPage.setTravelers started");
        hotelSearchPage.setTravelers(2,1);
        logger.info("hotelSearchPage.searchButtonClick started");

        hotelSearchPage.searchButtonClick();
        logger.info("searchHotelTest end");


    }

    //Results tab test
    @Test
    public  void searchResultTest() throws InterruptedException {
        driver.get(searchResultsURL);
        logger.info("searchResultTest started");

        HotelSeachResultsPage hotelSeachResultsPage = new HotelSeachResultsPage(driver);
        hotelSeachResultsPage.setFiltersOptions();
        hotelSeachResultsPage.getResults();

        logger.info("searchResultTest ended");
    }

    //Home Page Blog
    @Test
    public void getHomePageBlog() throws InterruptedException {
        driver.get(websiteURL);
        logger.info("getHomePageBlog() started");

        HomePage homePage = new HomePage(driver);
        homePage.getBlog();

        logger.info("homePageElements() completed");
    }

    //Home Page Featured Hotel - error java.lang.IllegalArgumentException: bound must be positive
    @Test
    public void getHomePageFeaturedHotel() throws InterruptedException {
        driver.get(websiteURL);
        logger.info("getHomePageFeaturedHotel() started");

        HomePage homePage = new HomePage(driver);
        homePage.getFeaturedHotel();

        logger.info("getHomePageFeaturedHotel() completed");
    }

    //Home Page Featured Tours
    @Test
    public void getHomePageFeaturedTours() throws InterruptedException{
        driver.get(websiteURL);
        logger.info("getHomePageFeaturedTours() started");

        HomePage homePage = new HomePage(driver);
        homePage.getFeaturedTours();

        logger.info("getHomePageFeaturedTours() completed");
    }

    //Home Page Featured Cars
    @Test
    public void getHomePageFeaturedCars() throws InterruptedException{
        driver.get(websiteURL);
        logger.info("getHomePageFeaturedCars() started");

        HomePage homePage = new HomePage(driver);
        homePage.getFeaturedCars();

        logger.info("getHomePageFeaturedCars() completed");
    }

    //Home Page Special Offer
    @Test
    public void getHomePageSpecialOffer() throws InterruptedException{
        driver.get(websiteURL);
        logger.info("getHomePageSpecialOffer() started");

        HomePage homePage = new HomePage(driver);
        homePage.getSpecialOffer();

        logger.info("getHomePageSpecialOffer() completed");
    }

    //Blog Page Tests
    @Test
    public void getLatestsPost(){
        driver.get(blogPageUrl);
        BlogPage blogPage = new BlogPage(driver);
        blogPage.getLatestPost();
    }

    @Test
    public void getSearch(){
        driver.get(blogPageUrl);
        BlogPage blogPage = new BlogPage(driver);
        blogPage.getSearch();
    }

    @Test
    public void getCategory(){
        driver.get(blogPageUrl);
        BlogPage blogPage = new BlogPage(driver);
        blogPage.getCategories();
    }

    @Test
    public void getPopularPost(){
        driver.get(blogPageUrl);
        BlogPage blogPage = new BlogPage(driver);
        blogPage.getPopularPost();
    }




}
