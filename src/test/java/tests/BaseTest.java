package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.SearchResultsPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
    private WebDriver driver;
    private static final String AVIC_URL = "https://avic.ua/";

    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() throws Exception {
        driver = initDriver();
        driver.manage().window().maximize();
        driver.get(AVIC_URL);
    }

    private WebDriver initDriver() throws Exception {
        String browser = System.getProperty("browser");
        if((browser == null) || ("chrome".equalsIgnoreCase(browser)) ){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if ("ie".equalsIgnoreCase(browser)){
            WebDriverManager.iedriver().setup();
            return new InternetExplorerDriver();
        } else {
            throw new Exception("Check browser var");
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public SearchResultsPage getSearchResultPage() {
        return new SearchResultsPage(getDriver());
    }

    public LoginPage getLoginPage() {
        return new LoginPage(getDriver());
    }

    public ProfilePage getProfilePage() {
        return new ProfilePage(getDriver());
    }
}