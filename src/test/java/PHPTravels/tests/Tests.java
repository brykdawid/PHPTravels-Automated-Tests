package PHPTravels.tests;

import PHPTravels.pages.HotelSearchPage;
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



}
