package testautomation.stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import testautomation.pages.HomePage;
import testautomation.pages.ProductDetailPage;
import testautomation.pages.ProductListPage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;


public class StepDefinitions {
    public static AndroidDriver driver;
    HomePage homePage;
    ProductListPage productListPage;
    ProductDetailPage productDetailPage;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "Galaxy A32");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "13");  // Adjust based on your device
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:appPackage", "com.cimrimobilevoyager");
        capabilities.setCapability("appium:appActivity", "com.cimrimobilevoyager.MainActivity");
        capabilities.setCapability("appium:udid", "RF8R40DC2NX");
        capabilities.setCapability("appium:newCommandTimeout", 3600);
        capabilities.setCapability("appium:autoGrantPermissions", true);
        capabilities.setCapability("appium:ensureWebviewsHavePages", true);
        capabilities.setCapability("appium:nativeWebScreenshot", true);
        capabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL url = URI.create("http://127.0.0.1:4723/").toURL();
        driver = new AndroidDriver(url, capabilities);

    }


    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }


    @Given("the user opens the app")
    public void theUserOpensTheApp() {
        homePage = new HomePage(driver);
    }

    @When("the user searches for {string}")
    public void theUserSearchesFor(String product) {
        homePage.searchForProduct(product);
    }

    @And("clicks on the filter button")
    public void clicksOnTheFilterButton() {
        productListPage = new ProductListPage(driver);
        productListPage.applyFilters();
    }

    @And("selects the sorting option as Highest Price")
    public void selectsTheSortingOptionAsHighestPrice() {
        productListPage.sortByHighestPrice();
    }

    @And("clicks on the 10th product in the results")
    public void clicksOnTheThProductInTheResults() {
        productListPage.selectTenthProduct();
    }

    @Then("the Go to Seller button should be displayed on the product detail page")
    public void theGoToSellerButtonShouldBeDisplayedOnTheProductDetailPage() {
        productDetailPage = new ProductDetailPage(driver);
        Assert.assertTrue(productDetailPage.isGoToSellerButtonDisplayed(), "Go to Seller button is not displayed!");
    }
}
