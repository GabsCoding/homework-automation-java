package entities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    protected String url;

    protected WebDriver driver;

    private static final String DRIVER_PATH = "//src//main//resources//chromedriver";

    private static final String RESOURCE_PATH = "/src/main/resources/paginaDeTeste.html";

    @BeforeClass
    public void preCondition() {
        url = System.getProperty("user.dir") + RESOURCE_PATH;

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + DRIVER_PATH);

        driver = new ChromeDriver();

        driver.get("file://" + url);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterTest(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
