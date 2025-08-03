package PHPTravels.tests;

import PHPTravels.pages.HotelSeachResultsPage;
import PHPTravels.pages.HotelSearchPage;
import PHPTravels.pages.UserLoginPage;
import PHPTravels.pages.UserRegisterPage;
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
    //Register/Login data
    private String name = "Dawid";
    private String surname = "Bryk";
    private int phone = 615625716;
    private String email = "khgaskjhdga@gmail.com";
    private String password = "qwerty123";

    //Logger Creation
    private static final Logger logger = LogManager.getLogger();


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


    @Test
    public  void searchResultTest() throws InterruptedException {
        driver.get(searchResultsURL);
        logger.info("searchResultTest started");

        HotelSeachResultsPage hotelSeachResultsPage = new HotelSeachResultsPage(driver);
        hotelSeachResultsPage.setFiltersOptions();
        hotelSeachResultsPage.getResults();

        logger.info("searchResultTest ended");
    }

    @Test
    public void registerUser(){
        driver.get(userRegisterUrl);
        logger.info("registerUser started");

        UserRegisterPage userRegisterPage = new UserRegisterPage(driver);
        userRegisterPage.userRegister(name, surname, phone, email, password);

        logger.info("registerUser completed");

    }

    @Test
    public void loginUser() throws InterruptedException {
        logger.info("loginUser started");
        driver.get(userLoginUrl);
        UserLoginPage userLoginPage = new UserLoginPage(driver);

        userLoginPage.userLogin(email, password);

        logger.info("loginUser completed");
    }


}
