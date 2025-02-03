package testautomation.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testautomation.utils.AppiumUtils;

import java.time.Duration;

public class HomePage {
    @FindBy(xpath = "//android.widget.TextView[@text=\"Ürün, marka veya kategori ara\"]")
    WebElement searchBox;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"search-input\"]")
    WebElement searchInput;

    AndroidDriver driver;
    WebDriverWait wait;
    AppiumUtils utils;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.utils = new AppiumUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchForProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOf(searchBox)).click();
        wait.until(ExpectedConditions.visibilityOf(searchInput)).sendKeys(productName);
        utils.pressSubmitButton();
    }

}
