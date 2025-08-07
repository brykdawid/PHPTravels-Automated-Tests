package PHPTravels.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class BlogPage {

    //Pages
    @FindBy(xpath = "//ul[@class='nav nav-pills nav-justified']//li")
    private List<WebElement> pagesNum;

    //Latest posts
    @FindBy(xpath = "//h4[@class='go-right RTL mtb0 upper']")
    private List<WebElement> latestPosts;

    //Date
    @FindBy(xpath = "//div[@class='post-left go-right']//span")
    private List<WebElement> postDate;

    //Desc
    @FindBy(xpath = "//p[@class='RTL']")
    private List<WebElement> postShortDesc;



    //Quick Search
    // Input
    @FindBy(xpath = "//input[@class='form-control sub_email']")
    private WebElement searchInput;

    //Search Button
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement searchBtn;


    //Categories and Posts panel
    @FindBy(xpath = "//a[@class='list-group-item']")
    private List<WebElement> categories;


    //Popular posts (name)
    @FindBy(xpath = "//h5[@class='go-text-right bold']")
    private List<WebElement> popularPosts;

    //Popular posts dates
    @FindBy(xpath = "//p[@class='text-warning weak']")
    private List<WebElement> popularPostDates;

    private static final Logger logger = LogManager.getLogger() ;

    public BlogPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }




    Random random = new Random();

    public void getLatestPost(){
        logger.info("getLatestPost() started");


        int selectPage = random.nextInt(pagesNum.size());
        logger.info("selected page: {}", selectPage);

        pagesNum.get(selectPage).click();
        logger.info("page {} clicked", selectPage);


        int selectPost = random.nextInt(latestPosts.size());
        logger.info("selected post: {}", selectPost);

        logger.info(postDate.get(selectPost).getText());
        logger.info(postShortDesc.get(selectPost).getText());


        latestPosts.get(selectPost).click();
        logger.info("post {} clicked", selectPost);

        logger.info("getLatestPost() completed");
    }

    public void getSearch(){
        logger.info("getSearch() started");
        searchInput.sendKeys("asdkjha");
        searchBtn.click();
        logger.info("getSearch() started");
    }

    public void getCategories(){
        logger.info("getCategories() started");

        int selectCategory = random.nextInt(categories.size());
        logger.info("selected category num: {}", selectCategory);
        categories.get(selectCategory).click();

        logger.info("getCategories() completed");
    }

    public void getPopularPost(){
        logger.info("getPopularPost() started");

        int selectPopularPost = random.nextInt(popularPosts.size());
        logger.info("selected post num: {}", selectPopularPost);
        logger.info(popularPosts.get(selectPopularPost).getText());
        logger.info(popularPostDates.get(selectPopularPost).getText());
        popularPosts.get(selectPopularPost).click();

        logger.info("getPopularPost() completed");


    }

}
